package com.dlts.hrms;

import com.dlts.hrms.utils.DateUtils;
import com.dlts.hrms.utils.IpUtils;
import com.dlts.hrms.utils.Md5Utils;
import com.dlts.hrms.web.system.UserAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2018/4/25.
 */
public class TestTmp {

    static Logger logger = LoggerFactory.getLogger(TestTmp.class);

    public static void main(String[] args) throws ParseException {
        System.out.print(new Date().getTime());

        logger.info("abc{},{}",123,45);

        Date date = new SimpleDateFormat("yyyy/MM/dd").parse("2015/12/31");
        String result = new SimpleDateFormat("yyyy/MM/dd").format(date);
        logger.info(result);
    }
}
