package com.ectrip.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huangxinguang on 2017/5/23 上午9:31.
 */
public interface BaseDAO<T> {
    /**
     * 保存
     * @param t
     */
    void save(T t);

    /**
     * 更新
     * @param t
     */
    void update(T t);

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 查询
     * @param id
     * @return
     */
    T find(Integer id);

    /**
     * 批量保存
     * @param list
     */
    void batchSave(List<T> list);

    /**
     * 批量删除
     * @param idlist
     */
    void batchDelete(List<Integer> idlist);

}
