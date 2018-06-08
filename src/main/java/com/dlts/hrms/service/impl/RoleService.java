package com.dlts.hrms.service.impl;

import com.dlts.hrms.domain.cm.Unified;
import com.dlts.hrms.domain.entity.Role;
import com.dlts.hrms.mapper.RoleMapper;
import com.dlts.hrms.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends BaseService {

    @Autowired
    RoleMapper roleMapper;

    public Unified<List<Role>> select(Role role) {
        return select(role,roleMapper);
    }

    public Unified<Role> get(Role role) {
        return get(role,roleMapper);
    }

}
