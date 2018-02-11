package com.dlts.hrms.gen;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class GenMapper {
    public static void init() throws IOException {
        List<Table> tables = DbUtils.getTables();
        for (Table t : tables) {

            String text = initTable(t);

            String key = getEntityName(t.name) + "Mapper.java";

            String path = MybatisGenerator.baseCodePath() + "mapper\\" + key;

            FileUtils.write(new File(path), existsCode(text, path, t));
        }
    }

    public static String existsCode(String template, String path, Table table) throws IOException {

        File f = new File(path);
        if (f.exists()) {
            String content = FileUtils.readFileToString(f, "UTF-8");

            String startStr = "{";
            String endStr = "}";

            int start = content.indexOf(startStr) + startStr.length();
            int end = content.indexOf(endStr);

            template = template.replace("${gen}",
                    content.substring(start, end).replaceFirst("\r\n", "").trim());


            startStr = "package com.dlts.hrms.mapper;";
            endStr = "public interface";
            start = content.indexOf(startStr) + startStr.length();
            end = content.indexOf(endStr);
            template = template.replace("${importGen}",
                    content.substring(start, end).replaceFirst("\r\n", "").trim());


        } else {
            String entityName = getEntityName(table.name);
            template = template.replace("${gen}", "");
            template = template.replace("${importGen}",
                    "import com.dlts.hrms.entity." + entityName + ";");
        }



        return template;
    }

    public static String initTable(Table table) {

        String template = MybatisGenerator.getMapperTemplate();

        template = template.replace("${entityName}", getEntityName(table.name));

        return template;
    }

    /**
     * @param tableName user_role
     * @return UserRole
     */
    private static String getEntityName(String tableName) {
        String[] arr = tableName.split("_");
        String entityName = "";
        for (int i = 0; i < arr.length; i++) {
            entityName += upperFisrtChar(arr[i]);
        }
        return entityName;
    }

    private static String upperFisrtChar(String value) {
        return Character.toUpperCase(value.charAt(0)) + value.substring(1);
    }

}
