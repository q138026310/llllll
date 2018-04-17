package com.dlts.hrms.service.impl;

import com.dlts.hrms.config.LmsMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by admin on 2018/4/17.
 */
public class BaseService<T> {
    @Autowired
    LmsMapper<T> lmsMapper;

}
