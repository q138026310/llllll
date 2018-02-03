package com.dlts.hrms.web.base;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;

import com.dlts.hrms.cm.App;

@Controller
public class AppController {


    @PostConstruct
    public void init() {
        Properties p = getProperties();
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
