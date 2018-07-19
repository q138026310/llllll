package com.dlts.hrms;

import com.dlts.hrms.utils.CalcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

/**
 * Created by admin on 2018/4/25.
 */
public class TestTmp {

    static Logger logger = LoggerFactory.getLogger(TestTmp.class);

    public static void main(String[] args) throws ParseException {
        logger.info(String.valueOf(CalcUtils.div(2.8,0.7,2)));
    }
}
