package com.base.vistter.mapper;

import com.base.vistter.bean.Pager;
import com.base.vistter.exception.PlatformException;

import java.util.List;
import java.util.Map;

public interface BaseMapper {

    /**
     * 查询分页
     *
     * @param pager
     * @return
     */
    Pager findPager(Pager pager) throws PlatformException;

    /**
     * 查询分页
     *
     * @param pager
     * @param paramMap
     * @return
     */
    Pager findPager(Pager pager, Map paramMap) throws PlatformException;

    /**
     * 查询列表
     *
     * @return
     */
    List<Map> findList() throws PlatformException;

    /**
     * 查询列表
     *
     * @param paramMap
     * @return
     */
    List<Map> findList(Map paramMap) throws PlatformException;

    /**
     *
     * @param statement
     * @param parameter
     * @return
     * @throws PlatformException
     */
    List<Map> findList(String statement, Object parameter) throws PlatformException;
    /**
     * 查询记录数
     *
     * @return
     */
    long count() throws PlatformException;

    /**
     * 查询记录数
     *
     * @param paramMap
     * @return
     */
    long count(Map paramMap) throws PlatformException;

    /**
     *
     * @param statement
     * @param parameter
     * @return
     * @throws PlatformException
     */
    long count(String statement, Object parameter) throws PlatformException;

    /**
     *
     * @param id
     * @return
     * @throws PlatformException
     */
    Map load(String id) throws PlatformException;

    /**
     *
     * @param statement
     * @param parameter
     * @return
     * @throws PlatformException
     */
    Map load(String statement, Object parameter) throws PlatformException;

    /**
     * 保存记录
     */
    void save() throws PlatformException;

    /**
     * 保存记录
     *
     * @param paramMap
     */
    void save(Map paramMap) throws PlatformException;

    /**
     * 修改记录
     */
    void update() throws PlatformException;

    /**
     * 修改记录
     *
     * @param paramMap
     */
    void update(Map paramMap) throws PlatformException;

    /**
     *
     * @param id
     * @throws PlatformException
     */
    void deleteById(String id) throws  PlatformException;

    /**
     *
     * @param list
     * @throws PlatformException
     */
    void delete(List list) throws  PlatformException;


}
