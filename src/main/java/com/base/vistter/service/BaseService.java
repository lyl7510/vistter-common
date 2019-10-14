package com.base.vistter.service;

import com.base.vistter.bean.Pager;
import com.base.vistter.exception.PlatformException;

import java.util.List;
import java.util.Map;

public interface BaseService {

    Pager findPager(Pager pager, Map paramMap) throws PlatformException;

    Pager findPager(Pager pager) throws PlatformException;

    void save(Map paramMap) throws PlatformException;

    void save() throws PlatformException;

    void update(Map paramMap) throws PlatformException;

    void update() throws PlatformException;

    Map load(String id) throws PlatformException;

    void deleteById(String id) throws PlatformException;

    void delete(List list) throws PlatformException;

}
