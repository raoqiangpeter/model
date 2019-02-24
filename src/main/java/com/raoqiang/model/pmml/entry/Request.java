package com.raoqiang.model.pmml.entry;

import java.util.Map;

public class Request {

    private AnthInfo anthInfo;

//    private Map

    private Map params;

    public AnthInfo getAnthInfo() {
        return anthInfo;
    }

    public Request(AnthInfo anthInfo, Map params) {
        this.anthInfo = anthInfo;
        this.params = params;
    }

    public Request() {
    }

    public void setAnthInfo(AnthInfo anthInfo) {
        this.anthInfo = anthInfo;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "Request{" +
                "anthInfo=" + anthInfo +
                ", params=" + params +
                '}';
    }
}
