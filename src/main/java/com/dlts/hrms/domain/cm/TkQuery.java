package com.dlts.hrms.domain.cm;

import tk.mybatis.mapper.entity.Example;

/**
 * Created by admin on 2018/4/25.
 */
public class TkQuery {

    Example example;
    Example.Criteria criteria;

    public TkQuery(Example example, Example.Criteria criteria) {
        this.example = example;
        this.criteria = criteria;
    }

    public Example getExample() {
        return example;
    }

    public void setExample(Example example) {
        this.example = example;
    }

    public Example.Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Example.Criteria criteria) {
        this.criteria = criteria;
    }

}
