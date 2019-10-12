package com.base.vistter.service.impl;

import com.base.vistter.bean.Pager;
import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.BaseMapper;
import com.base.vistter.service.BaseService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl implements BaseService {

    private BaseMapper baseMapper;

    @PostConstruct
    public void setBaseMapper(BaseMapper baseMapper){
        this.baseMapper = baseMapper;
    }

    @Override
    public Pager findPager(Pager pager, Map paramMap) throws PlatformException {
        return baseMapper.findPager(pager, paramMap);
    }

    @Override
    public void save(Map paramMap) throws PlatformException {
        baseMapper.save(paramMap);
    }

    @Override
    public void update(Map paramMap) throws PlatformException {
        baseMapper.update(paramMap);
    }

    @Override
    public void deleteById(String id) throws PlatformException {
        baseMapper.deleteById(id);
    }

    @Override
    public void delete(List list) throws PlatformException {
        baseMapper.delete(list);
    }
}
