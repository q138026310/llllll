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

			FileUtils.write(new File(MybatisGenerator.baseCodePath() + "mapper\\" + key), text);
		}
	}

	public static String initTable(Table table) {

		String template = MybatisGenerator.getMapperTemplate();

		template = template.replace("${entityName}", getEntityName(table.name));

		return template;
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
