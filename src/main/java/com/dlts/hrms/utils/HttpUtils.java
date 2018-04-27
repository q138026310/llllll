/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
package com.dlts.hrms.utils;

import com.dlts.hrms.domain.cm.GlobalConstant;
import com.dlts.hrms.domain.ex.ServiceException;
import com.dlts.hrms.domain.vo.http.HttpResult;
import com.dlts.hrms.domain.vo.http.PostParamVo;
import com.dlts.hrms.domain.vo.http.PostVo;
import com.google.common.collect.Lists;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * A example that demonstrates how HttpClient APIs can be used to perform
 * form-based logon.
 */
public class HttpUtils {

    public static HttpResult get(String url){
        return get(url,null,null);
    }

    public static HttpResult get(String url, Map<String,String> params){
        return get(url,params,null);
    }

    public static HttpResult get(String url,Map<String,String> params,Map<String,String> headers){

        HttpResult httpResult = new HttpResult();

        System.out.println("HTTP GET : ["+url+"]");
        StringBuilder fullUrl = new StringBuilder(url);
        fullUrl.append("?a=1");
        if(params!=null){
            for( String key : params.keySet() ){
                fullUrl.append("&"+key+"="+params.get(key));
            }
        }


        //构建HttpClient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //构建POST请求
        HttpGet httpGet = new HttpGet(fullUrl.toString());

        if(headers!=null){
            for( String key : headers.keySet() ){
                httpGet.setHeader(key,headers.get(key));
            }
        }

        try {
            //发送请求
            HttpResponse response = client.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            httpResult.setContent(EntityUtils.toString(httpEntity));
            httpResult.setHeaders(response.getAllHeaders());
            EntityUtils.consume(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpResult;

    }


    public static String post(String url,Map<String,String> paramsMap){
        //构建HttpClient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //构建POST请求
        HttpPost httpPost = new HttpPost(url);
        try {
            //构建文件体
            List<NameValuePair> params = Lists.newArrayList();

            for(String key : paramsMap.keySet()){
                params.add(new BasicNameValuePair(key,paramsMap.get(key)));
            }

            HttpEntity httpEntity = EntityBuilder.create().setParameters(params).build();
            httpPost.setEntity(httpEntity);

            //发送请求
            HttpResponse response = client.execute(httpPost);
            httpEntity = response.getEntity();
            return EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String postMulti(PostVo postVo){
        //构建HttpClient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //构建POST请求
        HttpPost httpPost = new HttpPost(postVo.getUrl());
        try {
            //构建文件体
            HttpEntity httpEntity = getMultiBuilder(postVo.getParams()).build();
            httpPost.setEntity(httpEntity);

            //发送请求
            HttpResponse response = client.execute(httpPost);
            httpEntity = response.getEntity();
            return EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static MultipartEntityBuilder getMultiBuilder(List<PostParamVo> params){
        MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        setParams(builder,params);
        return builder;
    }

    private static void setParams(MultipartEntityBuilder builder,List<PostParamVo> params){

        if(params==null){
            return;
        }

        for( PostParamVo paramVo : params ){
            setParam(builder,paramVo);
        }
    }

    private static void setParam(MultipartEntityBuilder builder,PostParamVo param){
        if( param.getValueType()== GlobalConstant.PostValueType.STRING){
            putString(builder,param.getKey(),param.getValue());
        }else if( param.getValueType()== GlobalConstant.PostValueType.FILE){
            putFile(builder,param.getKey(),param.getValue());
        }else{
            throw new ServiceException("post param value["+param.getValue()+"] type["+param.getValueType()+"] error");
        }
    }

    private static void putString(MultipartEntityBuilder builder,String key,String value){
        StringBody body = new StringBody(value, ContentType.MULTIPART_FORM_DATA);
        builder.addPart(key,body);
    }

    private static void putFile(MultipartEntityBuilder builder,String key,String filePath){
        File file = new File(filePath);
        if(!file.exists()){
            throw new ServiceException("file path ["+filePath+"] not exists");
        }
        String fileName = String.valueOf(new Date().getTime())+filePath.substring(filePath.lastIndexOf("."));
        FileBody body = new FileBody(file, ContentType.MULTIPART_FORM_DATA,fileName);
        builder.addPart(key,body);
    }

}