package com.neuedu.air_plane.dao;

import java.util.List;

public interface BaseDao<T> {

    void insert(T t);

    void update(T t);

    void deleteById(Integer id);

    T find(T t);

    List<T> findList(T t);


}
