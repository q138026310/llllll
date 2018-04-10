package com.dlts.hrms.domain.vo.http;

import org.apache.http.Header;

/**
 * Created by admin on 2018/4/10.
 */
public class HttpResult {

    private String content;
    private Header[] headers;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Header[] getHeaders() {
        return headers;
    }

    public void setHeaders(Header[] headers) {
        this.headers = headers;
    }
}
