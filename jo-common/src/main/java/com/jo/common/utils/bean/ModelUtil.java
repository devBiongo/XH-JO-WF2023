package com.jo.common.utils.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class ModelUtil {
    @SuppressWarnings("unchecked")
    @SneakyThrows
    public static <T> T cloneBean(final T source) {
        T target = (T) source.getClass().getDeclaredConstructor().newInstance();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <M, T> T convertDtoPo(M source, Class<T> tClazz) {
        try {
            T target = tClazz.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (Throwable t) {
            throw new RuntimeException(t.getMessage());
        }
    }

    public static <M, T> List<T> convertDtoPoBatch(List<M> sources, Class<T> tClazz) {
        List<T> tList = new ArrayList<>();
        for (M source : sources) {
            tList.add(convertDtoPo(source, tClazz));
        }
        return tList;
    }

    //    private static Object copyBean(Object obj) throws Exception {
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(bos);
//        oos.writeObject(obj);
//        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
//        ObjectInputStream ois = new ObjectInputStream(bis);
//        return ois.readObject();
//    }

    @SneakyThrows
    public static <T> List<T> copyBeanList(final List<T> modelList) {
        if (modelList.isEmpty()) {
            return new ArrayList<>();
        }
        return modelList.stream()
                .map(ModelUtil::cloneBean)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public static <T> List<Long> getTableIds(List<T> modelList) {
        List<Long> returnList = new ArrayList<>();
        for (T model : modelList) {
            returnList.add(getTableId(model));
        }
        return returnList;
    }

    @SneakyThrows
    public static <T> Long getTableId(T model) {
        for (Field field : model.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(TableId.class)) {
                if (field.getType() == Long.class) {
                    field.setAccessible(true);
                    return (Long) field.get(model);
                } else {
                    throw new RuntimeException("System error : only support tableId with type Long");
                }
            }
        }
        throw new RuntimeException("System error : can not find @TableId");
    }

    public static <T> List<T> getIntersections(List<T> aList, List<T> bList) {
        return aList.stream().filter(a ->
                bList.stream().map(ModelUtil::getTableId).anyMatch(id ->
                        Objects.equals(ModelUtil.getTableId(a), id)
                )
        ).toList();
    }

    public static <T> List<T> getDifferences(List<T> aList, List<T> bList) {
        return aList.stream().filter(a ->
                bList.stream().map(ModelUtil::getTableId).noneMatch(id ->
                        Objects.equals(ModelUtil.getTableId(a), id)
                )
        ).toList();
    }
}