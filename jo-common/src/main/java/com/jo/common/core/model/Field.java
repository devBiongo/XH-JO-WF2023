package com.jo.common.core.model;

import com.jo.common.enums.QueryMethod;
import lombok.Data;

@Data
public class Field {
    private String name;
    private Object value;
    private QueryMethod queryMethod;

    public Field() {}
    public Field(String name, Object value) {
        this(name,value,QueryMethod.eq);
    }

    public Field(String name, Object value, QueryMethod queryMethod) {
        this.name = name;
        this.value = value;
        this.queryMethod = queryMethod;
    }
}