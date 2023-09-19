package com.jo.common.core.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jo.common.utils.bean.ModelUtil;
import lombok.SneakyThrows;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BaseService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

    @SneakyThrows
    @Transactional
    public void saveOrUpdateOrRemoveBatch(final List<T> prevPo, final List<T> currPo) {
        List<Long> removeIds = ModelUtil.getTableIds(ModelUtil.getDifferences(prevPo, currPo));
        if (!removeIds.isEmpty() && !this.removeByIds(removeIds)) {
            throw new RuntimeException("Failed to delete...");
        }
        if (!this.saveOrUpdateBatch(currPo)) {
            throw new RuntimeException("Failed to save and update...");
        }
    }
}
