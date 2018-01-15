package com.dlts.hrms.gen;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class GenXml {
    public static void init() throws IOException {
        List<Table> tables = DbUtils.getTables();
        for (Table t : tables) {

            String text = initTable(t);

            String key = getEntityName(t.name) + "Mapper.xml";

            String path = MybatisGenerator.baseMapperPath() + key;

            FileUtils.write(new File(path), existsCode(text, path));
        }
    }

    public static String existsCode(String template, String path) throws IOException {

        File f = new File(path);
        if (f.exists()) {
            String content = FileUtils.readFileToString(f);

            String startStr = "<!--gen-e-1-w-0-->";
            String endStr = "<!--gen-e-1-w-1-->";

            int start = content.indexOf(startStr) + startStr.length();
            int end = content.indexOf(endStr);

            template = template.replace("${gen}", content.substring(start, end));
        } else {
            template = template.replace("${gen}", "");
        }



        return template;
    }

    public static String initTable(Table table) {
        List<Column> columns = DbUtils.getColumns(table.name);

        String template = MybatisGenerator.getXmlTemplate();

        template = template.replace("${entityName}", getEntityName(table.name));
        template = template.replace("${Base_Column}", getBaseColumn(columns));
        template = template.replace("${tableName}", table.name);
        template = template.replace("${insertValues}", getInsertValues(columns));
        template = template.replace("${updateSelectiveSet}", getUpdateSelectiveSet(columns));
        template = template.replace("${updateSet}", getUpdateSet(columns));
        template = template.replace("${where}", getWhere(columns));
        template = template.replace("<!--${dtd}-->",
                "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");

        return template;
    }

    private static String getWhere(List<Column> columns) {
        String baseColumn = " where 1=1 ";
        for (int i = 0, size = columns.size(); i < size; i++) {
            String cname = columns.get(i).name;
            baseColumn += "<if test=\"" + getPropName(cname) + "!=null\">";
            baseColumn += "and " + cname + "=#{" + getPropName(cname) + "}";
            baseColumn += "</if>";

        }
        return baseColumn;

    }

    private static String getUpdateSet(List<Column> columns) {
        String baseColumn = "";
        for (int i = 0, size = columns.size(); i < size; i++) {
            if (i > 0) {
                baseColumn += ",";
            }

            String cname = columns.get(i).name;
            baseColumn += cname + "=#{" + getPropName(cname) + "}";

        }
        return baseColumn;

    }

    private static String getUpdateSelectiveSet(List<Column> columns) {
        String baseColumn = "<set>";
        for (int i = 0, size = columns.size(); i < size; i++) {
            String cname = columns.get(i).name;

            baseColumn += "<if test=\"" + getPropName(cname) + " != null\">";
            baseColumn += cname + " = #{" + getPropName(cname) + "},";
            baseColumn += "</if>";
        }
        return baseColumn + "</set>";
    }

    private static String getInsertValues(List<Column> columns) {
        String baseColumn = "";
        for (int i = 0, size = columns.size(); i < size; i++) {
            if (i > 0) {
                baseColumn += ",";
            }
            baseColumn += "#{" + columns.get(i).name + "}";
        }
        return baseColumn;
    }

    private static String getBaseColumn(List<Column> columns) {
        String baseColumn = "";
        for (int i = 0, size = columns.size(); i < size; i++) {
            if (i > 0) {
                baseColumn += ",";
            }
            baseColumn += columns.get(i).name;
        }
        return baseColumn;
    }

    private static String getPropName(String columnName) {
        String[] arr = columnName.split("_");
        String entityName = arr[0];
        for (int i = 1; i < arr.length; i++) {
            entityName += upperFisrtChar(arr[i]);
        }
        return entityName;
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
