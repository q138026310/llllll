package com.dlts.hrms.mapper;

import com.dlts.hrms.config.ActivityMapperProvider;
import com.dlts.hrms.config.LmsMapper;
import com.dlts.hrms.domain.entity.User;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Map;

public interface UserMapper extends LmsMapper<User> {

    @SelectProvider(type=ActivityMapperProvider.class,method="select")
    public List<User> getActivityAll(Map<String,Object> map);


}
