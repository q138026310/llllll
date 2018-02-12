package com.dlts.hrms.web.base;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;

import com.dlts.hrms.cm.App;
import com.dlts.hrms.cm.GlobalConstant;
import com.dlts.hrms.cm.Gnum;
import com.dlts.hrms.cm.Response;
import com.dlts.hrms.utils.JsonUtils;
import com.google.gson.JsonObject;

@Controller
public class AppController {


    @PostConstruct
    public void init() {
        Properties p = getProperties();
        initFilterUrls(p);
        initCont();
    }

    private static void initCont() {
        JsonObject json = JsonUtils.newJsonObject();
        Field[] enums = GlobalConstant.class.getDeclaredFields();

        try {
            for (Field e : enums) {
                if (e.getType().equals(Gnum.class)) {
                    Gnum num = (Gnum) e.get(Gnum.class);
                    json.addProperty("p" + num.value, num.text);
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e1) {
            e1.printStackTrace();
        }

        App.CONT = Response.body(json);
    }

    private static void initFilterUrls(Properties p) {
        String[] urls = p.getProperty("filter.url").split(",");
        App.FILTER_URLS = new String[urls.length];
        for (int i = 0; i < urls.length; i++) {
            App.FILTER_URLS[i] = urls[i] + ".spring";
        }
    }

    private static Properties getProperties() {
        Resource resource = new ClassPathResource("hrms.properties");
        Properties p = null;
        try {
            p = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return p;
    }

}
