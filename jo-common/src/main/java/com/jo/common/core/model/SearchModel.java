package com.jo.common.core.model;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jo.common.utils.StringUtils;
import lombok.Data;

import java.util.List;

@Data
public class SearchModel<T> {

    private Integer pageIndex;

    private Integer pageSize;

    private List<Field> fields;

    private String orderField;

    private boolean asc;

    public IPage<T> getPage() {
        IPage<T> page = new Page<>(pageIndex, pageSize);
        if (!StringUtils.isBlank(orderField)) {
            OrderItem orderItem = new OrderItem();
            orderItem.setAsc(asc);
            orderItem.setColumn(orderField);
            page.orders().add(orderItem);
        }
        return page;
    }

    public QueryWrapper<T> getQueryModel() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        for (Field field : this.fields) {
            switch (field.getQueryMethod()) {
                case eq -> queryWrapper.eq(true, StringUtils.toUnderScoreCase(field.getName()), field.getValue());
                case ne -> queryWrapper.ne(true, StringUtils.toUnderScoreCase(field.getName()), field.getValue());
                case like -> queryWrapper.like(true, StringUtils.toUnderScoreCase(field.getName()), field.getValue());
            }
        }
        if (!StringUtils.isBlank(orderField)) {
            queryWrapper.orderBy(true, asc, StringUtils.toUnderScoreCase(orderField));
        }
        return queryWrapper;
    }
}