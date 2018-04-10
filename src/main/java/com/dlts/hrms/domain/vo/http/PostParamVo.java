package com.dlts.hrms.domain.vo.http;


import com.dlts.hrms.domain.cm.GlobalConstant;

/**
 * Created by admin on 2018/4/3.
 */
public class PostParamVo {

    private String key;
    private String value;
    private int valueType;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getValueType() {
        return valueType;
    }

    public void setValueType(int valueType) {
        this.valueType = valueType;
    }

    public static PostParamVo getStringParam(String key,String value){
        PostParamVo param =getParam(key,value);
        param.setValueType(GlobalConstant.PostValueType.STRING);
        return param;
    }

    public static PostParamVo getFileParam(String key,String value){
        PostParamVo param =getParam(key,value);
        param.setValueType(GlobalConstant.PostValueType.FILE);
        return param;
    }

    private static PostParamVo getParam(String key,String value){
        PostParamVo param = new PostParamVo();
        param.setKey(key);
        param.setValue(value);
        return param;
    }
}
