package com.neuedu.air_plane.model;

import lombok.Data;

/**
 * 代表前台传过来的分页查询条件
 * @param <T>
 */
@Data
public class PageCondition<T> {

    private Integer pageNum; // 当前页
    private Integer pageSize; // 每页显示条目
    private T condition; //代表业务查询的条件字段
}
