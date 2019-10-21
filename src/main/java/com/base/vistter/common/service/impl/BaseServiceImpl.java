package com.base.vistter.common.service.impl;

import com.base.vistter.common.bean.Pager;
import com.base.vistter.common.exception.PlatformException;
import com.base.vistter.common.mapper.BaseMapper;
import com.base.vistter.common.service.BaseService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Transactional
public abstract class BaseServiceImpl implements BaseService {

    private BaseMapper baseMapper;

    protected abstract BaseMapper getBaseMapper();

    @PostConstruct
    protected void init() {
        this.baseMapper = this.getBaseMapper();
    }

    @Transactional(readOnly = true)
    public Pager findPager( Map paramMap) throws PlatformException {
        return baseMapper.findPager(paramMap);
    }

    @Transactional(readOnly = true)
    public Map load(String id) throws PlatformException {
        return baseMapper.load(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Map paramMap) throws PlatformException {
        baseMapper.save(paramMap);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save() throws PlatformException {
        baseMapper.save();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Map paramMap) throws PlatformException {
        baseMapper.update(paramMap);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update() throws PlatformException {
        baseMapper.update();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(String id) throws PlatformException {
        baseMapper.deleteById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List list) throws PlatformException {
        baseMapper.delete(list);
    }
}
