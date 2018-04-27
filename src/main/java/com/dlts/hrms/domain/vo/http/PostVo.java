package com.dlts.hrms.domain.vo.http;

import java.util.List;

/**
 * Created by admin on 2018/4/3.
 */
public class PostVo {

    private String url;

    private List<PostParamVo> params;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<PostParamVo> getParams() {
        return params;
    }

    public void setParams(List<PostParamVo> params) {
        this.params = params;
    }
}
