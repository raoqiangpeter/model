package com.raoqiang.model.pmml.entry;

import java.util.Map;

public class Params {

    private Map map;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Params(Map map) {
        this.map = map;
    }

    public Params() {
    }

    @Override
    public String toString() {
        return "Params{" +
                "map=" + map +
                '}';
    }
}
