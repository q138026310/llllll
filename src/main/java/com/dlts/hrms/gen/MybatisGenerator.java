package com.dlts.hrms.gen;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class MybatisGenerator {

	private static String XML_TEMPLATE_PATH = "template/template.xml";

	public static void main(String[] args) {
		System.out.println("1");
		initTemplatePath();
		GenXml.init();
		System.out.println("end");
	}

	public static String getXmlTemplate() {
		File file = new File(XML_TEMPLATE_PATH);
		try {
			return FileUtils.readFileToString(file, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void initTemplatePath() {
		XML_TEMPLATE_PATH = MybatisGenerator.class.getResource("/").toString().replace("file:/", "")
				+ XML_TEMPLATE_PATH;
	}

}
