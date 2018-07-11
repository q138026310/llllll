import com.dlts.hrms.domain.vo.http.HttpResult;
import com.dlts.hrms.utils.HttpUtils;
import com.dlts.hrms.utils.JsonUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.http.Header;
import org.junit.Test;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.*;
import java.util.Date;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by admin on 2018/4/10.
 */
public class App {
    public static final String BASE_URL = "http://127.0.0.1:8888/hrms";

    public static void test(String url, Map<String,String> params){

        String login_url = BASE_URL +"/index/login.spring";

        Map<String,String> loginParams = Maps.newHashMap();

        loginParams.put("username","admin");
        loginParams.put("password","admin");

        HttpResult result = HttpUtils.get(login_url,loginParams);
        System.out.println("result:   "+result);

        JsonObject login = JsonUtils.toJsonObject(result.getContent());
        String token = login.get("data").getAsJsonObject().get("token").getAsString();

        Map<String,String> headers = Maps.newHashMap();


        String cookieValue = null;
        for(Header header : result.getHeaders()){
            if( header.getName().equals("Set-Cookie") ){
                cookieValue = header.getValue();
                break;
            }
        }
        headers.put("Cookie",cookieValue+";token="+token);

        result = HttpUtils.get(url+".spring",params,headers);
        System.out.println("RESULT::::"+result.getContent());
    }


    @Test
    public void initTables(){
        Connection conn = null;
        try {
            conn = getConnection();
            App.initTables(conn);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConn(conn);
        }
    }

    private static void initTables(Connection conn){
        Set<Class<?>> classes = getClasses("com.dlts.hrms.domain.entity");

        //System.out.print();

        for( Class<?> clazz : classes ){
            //System.out.println("--------------------"+clazz.getSimpleName());
            if(clazz.getSimpleName().equals("BaseEntity")){
                continue;
            }
            initTable(conn,clazz);
        }

        //SELECT GROUP_CONCAT(COLUMN_NAME SEPARATOR ",") FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = 'hrms' AND TABLE_NAME = 'SYS_USER'

        // 所有空数据用-1代替

        //客户
        String sql = "INSERT INTO `hrms`.`sys_customer`(`id`,`customer_id`,`contact`, `contact_phone`, `status`, `create_user_id`, `create_time`, `update_user_id`, `update_time`)" +
                " VALUES ('100000001','100000001','如来', '13999999999', 1, 0, sysdate(), 0, '0');";
        executeSql(conn,sql);

        //公司
        sql = "INSERT INTO `hrms`.`sys_company`(`id`, `name`, `code`, `parent_id`, `contact`, `contact_phone`, `status`, `create_user_id`, `create_time`," +
                " `update_user_id`, `update_time`, `customer_id`) VALUES " +
                " (200000001, '平台', '000', -1, 'admin', '13888888888', 1, 300000001, sysdate(), -1, -1,100000001);";
        executeSql(conn,sql);
        //用户
        sql = "insert into sys_user(id,company_id,organization_id,username,password,code,name,email,phone,mobile,photo,login_ip,login_time,status,create_user_id,create_time,update_user_id,update_time,customer_id) " +
                " values(300000001,200000001,1,'admin','176d8ab94944e3883779f50f7638fd4a','0001','121','','',131,'',1,'',1,1,'',1,'',100000001)";
        executeSql(conn,sql);


    }

    private static void executeSql(Connection conn, String sql){
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closePstmt(pstmt);
    }

    private static void initTable(Connection conn,Class<?> clazz){
        Table table = clazz.getAnnotation(Table.class);

        executeSql(conn,"drop table if EXISTS "+table.name());

        StringBuilder sb = new StringBuilder("create table "+table.name()+"(");

        sb.append("id bigint(19) NOT NULL,");

        Field[] fields =  FieldUtils.getAllFields(clazz);

        List<String> sqls = Lists.newArrayList();

        for(Field field:fields){
            Transient t = field.getAnnotation(Transient.class);
            if(t!=null || field.getName().equals("id") ){
                continue;
            }

            String dbType = casType(field.getName(),field.getType().getSimpleName());
            if(isFixField(field.getName())){
                sb.append(" "+toColumnName(field.getName())+" "+dbType+" NOT NULL,");
            }else{
                Column column = field.getAnnotation(Column.class);
                if(column==null){
                    System.out.println(table.name()+"-------"+field.getName()+"--8888888-"+field.getType().getSimpleName());
                }
                sb.append(" "+toColumnName(field.getName())+" "+dbType+"("+column.length()+") NOT NULL,");

                if( column.unique() ){
                    sqls.add("ALTER TABLE "+table.name()+" ADD UNIQUE ("+toColumnName(field.getName())+")");
                }
            }
            sb.append("\r\n");


        }

        sb.append("PRIMARY KEY (id) )");

        executeSql(conn,"DROP TABLE IF EXISTS "+table.name());
        executeSql(conn,sb.toString());

        for( String sql : sqls ){
            executeSql(conn,sql);
        }

        //System.out.println(sb.toString());
    }

    private static String toColumnName(String propertyName){

        char[] a = propertyName.toCharArray();
        List<Character> b = Lists.newArrayList();

        for( int i=0 ; i<a.length ; i++ ){
            if( Character.isLowerCase(a[i]) ){
                b.add(a[i]);
            }else{
                b.add('_');
                b.add(Character.toLowerCase(a[i]));
            }
        }

        char[] c = new char[b.size()];
        for( int i=0 ; i<c.length ; i++ ){
            c[i] = b.get(i);
        }

        return new String(c);
    }

    private  static String casType(String fieldName ,String propertyTypeName){
        if( fieldName.equals("status") ){
            return "TINYINT";
        }else if( fieldName.equals("createTime") || fieldName.equals("updateTime") ){
            return "CHAR(19)";
        }else if( fieldName.equals("createUserId") || fieldName.equals("updateUserId") || fieldName.equals("customerId") || fieldName.equals("id") ){
            return "BIGINT(19)";
        }else if( propertyTypeName.equals("Long") ){
            return "BIGINT";
        }else if( propertyTypeName.equals("String") ){
            return "CHAR";
        }else if( propertyTypeName.equals("Integer") ){
            return "INT";
        }
        return null;
    }

    private static boolean isFixField(String fieldName){
        if( fieldName.equals("status") || fieldName.equals("id") || fieldName.equals("customerId") || fieldName.equals("createUserId") || fieldName.equals("createTime") || fieldName.equals("updateUserId")|| fieldName.equals("updateTime")){
            return true;
        }else{
            return false;
        }
    }




    /**
     * 从包package中获取所有的Class
     *
     * @param pack
     * @return
     */
    public static Set<Class<?>> getClasses(String pack) {

        // 第一个class类的集合
        Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
        // 是否循环迭代
        boolean recursive = true;
        // 获取包的名字 并进行替换
        String packageName = pack;
        String packageDirName = packageName.replace('.', '/');
        // 定义一个枚举的集合 并进行循环来处理这个目录下的things
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(
                    packageDirName);
            // 循环迭代下去
            while (dirs.hasMoreElements()) {
                // 获取下一个元素
                URL url = dirs.nextElement();
                // 得到协议的名称
                String protocol = url.getProtocol();
                // 如果是以文件的形式保存在服务器上
                if ("file".equals(protocol)) {
                    System.err.println("file类型的扫描");
                    // 获取包的物理路径
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    // 以文件的方式扫描整个包下的文件 并添加到集合中
                    findAndAddClassesInPackageByFile(packageName, filePath,
                            recursive, classes);
                } else if ("jar".equals(protocol)) {
                    // 如果是jar包文件
                    // 定义一个JarFile
                    System.err.println("jar类型的扫描");
                    JarFile jar;
                    try {
                        // 获取jar
                        jar = ((JarURLConnection) url.openConnection())
                                .getJarFile();
                        // 从此jar包 得到一个枚举类
                        Enumeration<JarEntry> entries = jar.entries();
                        // 同样的进行循环迭代
                        while (entries.hasMoreElements()) {
                            // 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
                            JarEntry entry = entries.nextElement();
                            String name = entry.getName();
                            // 如果是以/开头的
                            if (name.charAt(0) == '/') {
                                // 获取后面的字符串
                                name = name.substring(1);
                            }
                            // 如果前半部分和定义的包名相同
                            if (name.startsWith(packageDirName)) {
                                int idx = name.lastIndexOf('/');
                                // 如果以"/"结尾 是一个包
                                if (idx != -1) {
                                    // 获取包名 把"/"替换成"."
                                    packageName = name.substring(0, idx)
                                            .replace('/', '.');
                                }
                                // 如果可以迭代下去 并且是一个包
                                if ((idx != -1) || recursive) {
                                    // 如果是一个.class文件 而且不是目录
                                    if (name.endsWith(".class")
                                            && !entry.isDirectory()) {
                                        // 去掉后面的".class" 获取真正的类名
                                        String className = name.substring(
                                                packageName.length() + 1, name
                                                        .length() - 6);
                                        try {
                                            // 添加到classes
                                            classes.add(Class
                                                    .forName(packageName + '.'
                                                            + className));
                                        } catch (ClassNotFoundException e) {
                                            // log
                                            // .error("添加用户自定义视图类错误 找不到此类的.class文件");
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        // log.error("在扫描用户定义视图时从jar包获取文件出错");
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return classes;
    }

    /**
     * 以文件的形式来获取包下的所有Class
     *
     * @param packageName
     * @param packagePath
     * @param recursive
     * @param classes
     */
    public static void findAndAddClassesInPackageByFile(String packageName,
                                                        String packagePath, final boolean recursive, Set<Class<?>> classes) {
        // 获取此包的目录 建立一个File
        File dir = new File(packagePath);
        // 如果不存在或者 也不是目录就直接返回
        if (!dir.exists() || !dir.isDirectory()) {
            // log.warn("用户定义包名 " + packageName + " 下没有任何文件");
            return;
        }
        // 如果存在 就获取包下的所有文件 包括目录
        File[] dirfiles = dir.listFiles(new FileFilter() {
            // 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
            public boolean accept(File file) {
                return (recursive && file.isDirectory())
                        || (file.getName().endsWith(".class"));
            }
        });
        // 循环所有文件
        for (File file : dirfiles) {
            // 如果是目录 则继续扫描
            if (file.isDirectory()) {
                findAndAddClassesInPackageByFile(packageName + "."
                                + file.getName(), file.getAbsolutePath(), recursive,
                        classes);
            } else {
                // 如果是java类文件 去掉后面的.class 只留下类名
                String className = file.getName().substring(0,
                        file.getName().length() - 6);
                try {
                    // 添加到集合中去
                    //classes.add(Class.forName(packageName + '.' + className));
                    //经过回复同学的提醒，这里用forName有一些不好，会触发static方法，没有使用classLoader的load干净
                    classes.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));
                } catch (ClassNotFoundException e) {
                    // log.error("添加用户自定义视图类错误 找不到此类的.class文件");
                    e.printStackTrace();
                }
            }
        }
    }

    private static void closeRs(ResultSet rs){
        if( rs!=null ){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closePstmt(PreparedStatement pstmt){
        if( pstmt!=null ){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeConn(Connection connection){
        if( connection!=null ){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hrms?characterEncoding=UTF-8&useSSL=false","root","root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }



    /** --------------------------------------------------------------------test */
    @Test
    public void testMysql(){
        Connection conn = null;
        try {
            conn = getConnection();

            String sql = "insert into test_mysql3(id,str,age,float1,name,float2,createTime,status,updateTime) " +
                    " values ";

            int len = 10000;

            for(int i=0 ; i<len ; i++){
                if(i>0){
                    sql += ",";
                }
                sql += "(?,?,?,?,?,?,?,?,?)";
            }

            PreparedStatement pstmt = conn.prepareStatement(sql);

            System.out.println("start");
            for(int i=0 ; i<10000 ; i++){
                long t1 = System.currentTimeMillis();


                    int index = 1;

                    for(int k=0 ; k<len ; k++){
                        Date date = new Date();
                        int age = random.nextInt(1000);
                        float float1 = random.nextFloat();
                        pstmt.setString(index++, com.dlts.hrms.utils.UUID.randomUUID().toString());
                        pstmt.setString(index++,getString(15));
                        pstmt.setInt(index++,age);
                        pstmt.setFloat(index++,float1);
                        pstmt.setString(index++,getString(7));
                        pstmt.setFloat(index++,1-float1);
                        pstmt.setLong(index++,date.getTime());
                        pstmt.setInt(index++,1000-age);
                        pstmt.setDate(index++,new java.sql.Date(date.getTime()));
                    }
                    pstmt.executeUpdate();
                long t2 = System.currentTimeMillis();
                System.out.println(i+"-----"+(t2-t1));
            }

           closePstmt(pstmt);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConn(conn);
        }
    }

    private static final String value = "qwertyuioplkjhgfdsazxcvbnm";

    private static final Random random = new Random();

    private static StringBuilder sb = new StringBuilder();

    private static String getString(int length){
        sb.setLength(0);

        int len = length + random.nextInt(4);
        for( int i=0 ; i<len ; i++ ){
            sb.append(value.charAt(random.nextInt(26)));
        }
        return sb.toString();

    }


}
