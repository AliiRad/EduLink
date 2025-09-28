package com.EduLink.EduLink.model.service.impl;

import java.util.List;

public interface ServiceImpl<T,I>{
    public T insert(T t);
    public T update(T t);
    public T delete(T t);
    public T findById(I id);
    public List<T> findAll();
    public List<T> findAll(String condition);
    public List<T> findAll(String condition, String order);

}
