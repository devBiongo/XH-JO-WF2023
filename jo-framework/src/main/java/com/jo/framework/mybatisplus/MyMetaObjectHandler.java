package com.jo.framework.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.jo.common.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充【insert】");
        this.setFieldValByName("createdAt", new Timestamp(System.currentTimeMillis()), metaObject);
        this.setFieldValByName("createdBy", SecurityUtils.getUsername(), metaObject);
        this.setFieldValByName("version", 1, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("公共字段自动填充【update】");
        this.setFieldValByName("updatedAt", new Timestamp(System.currentTimeMillis()), metaObject);
        this.setFieldValByName("updatedBy", SecurityUtils.getUsername(), metaObject);
    }
}