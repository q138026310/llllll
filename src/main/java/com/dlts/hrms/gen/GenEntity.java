package com.dlts.hrms.gen;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class GenEntity {
	public static void init() throws IOException {
		List<Table> tables = DbUtils.getTables();
		for (Table t : tables) {

			String text = initTable(t);

			String key = getEntityName(t.name) + ".java";

			FileUtils.write(new File(MybatisGenerator.baseCodePath() + "entity\\" + key), text);
		}
	}

	public static String initTable(Table table) {
		List<Column> columns = DbUtils.getColumns(table.name);

		String template = MybatisGenerator.getEntityTemplate();

		template = template.replace("${entityName}", getEntityName(table.name));
		template = template.replace("${property}", getProperty(columns));

		return template;
	}

	private static String getProperty(List<Column> columns) {
		String property = "";
		for (int i = 0, size = columns.size(); i < size; i++) {
			String cname = columns.get(i).name;
			String ctype = columns.get(i).type;

			property += "private " + convertType(ctype) + " " + getPropName(cname) + ";";

		}

		for (int i = 0, size = columns.size(); i < size; i++) {
			String cname = columns.get(i).name;
			String ctype = columns.get(i).type;

			property += "public " + convertType(ctype) + " get" + upperFisrtChar(getPropName(cname)) + "(){";
			property += "return this." + getPropName(cname) + ";";
			property += "}";

			property += "public void set" + upperFisrtChar(getPropName(cname)) + "(" + convertType(ctype) + " "
					+ getPropName(cname) + "){";
			property += "this." + getPropName(cname) + "=" + getPropName(cname) + ";";
			property += "}";

		}

		return property;
	}

	private static String convertType(String type) {
		if (type.equals("varchar") || type.equals("char") || type.equals("text")) {
			return "String";
		} else if (type.equals("int")) {
			return "Integer";
		} else if (type.equals("date") || type.equals("datetime")) {
			return "Date";
		} else {
			throw new RuntimeException("convert type error");
		}
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
	 * @param tableName
	 *            user_role
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
