package com.neuedu.air_plane.service;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.air_plane.dao.BaseDao;
import com.neuedu.air_plane.model.PageCondition;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseService<D extends BaseDao<T>, T> {

    //利用了spring的泛型依赖注入
    @Autowired
    protected D dao;

    public void insert(T t) {
        dao.insert(t);
    }

    public void update(T t) {
        dao.update(t);
    }

    public List<T> findList(T t) {
        return dao.findList(t);
    }

    public T find(T t) {
        return dao.find(t);
    }

    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    /**
     * 分页查询的方法
     * @param condition
     * @return
     */
    public PageInfo<T> page(PageCondition<T> condition){
        return PageHelper.startPage(condition.getPageNum(),condition.getPageSize())
                .doSelectPageInfo(()->dao.findList(condition.getCondition()));
    }
}
