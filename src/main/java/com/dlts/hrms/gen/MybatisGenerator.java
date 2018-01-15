package com.dlts.hrms.gen;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class MybatisGenerator {

    private static String XML_TEMPLATE_PATH = "template/template.xml";

    private static String MAPPER_TEMPLATE_PATH = "template/mapper.j";

    private static String ENTITY_TEMPLATE_PATH = "template/entity.j";

    public static void main(String[] args) throws IOException {

        initTemplatePath();
        GenXml.init();
        GenEntity.init();
        GenMapper.init();
        System.out.println("end");
    }

    public static String getXmlTemplate() {
        return getTemplate(XML_TEMPLATE_PATH);
    }

    public static String getMapperTemplate() {
        return getTemplate(MAPPER_TEMPLATE_PATH);
    }

    public static String getEntityTemplate() {
        return getTemplate(ENTITY_TEMPLATE_PATH);
    }

    private static String getTemplate(String path) {
        File file = new File(path);
        try {
            return FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void initTemplatePath() {
        XML_TEMPLATE_PATH = basePath() + XML_TEMPLATE_PATH;
        MAPPER_TEMPLATE_PATH = basePath() + MAPPER_TEMPLATE_PATH;
        ENTITY_TEMPLATE_PATH = basePath() + ENTITY_TEMPLATE_PATH;
    }

    public static String basePath() {
        return MybatisGenerator.class.getResource("/").toString().replace("file:/", "");
    }

    public static String baseCodePath() {
        return System.getProperty("user.dir") + "\\src\\main\\java\\com\\dlts\\hrms\\";
    }

    public static String baseMapperPath() {
        return System.getProperty("user.dir") + "\\src\\main\\resources\\com\\dlts\\hrms\\mapper\\";
    }

}
