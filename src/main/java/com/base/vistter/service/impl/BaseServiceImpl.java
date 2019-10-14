package com.base.vistter.service.impl;

import com.base.vistter.bean.Pager;
import com.base.vistter.exception.PlatformException;
import com.base.vistter.mapper.BaseMapper;
import com.base.vistter.service.BaseService;
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
    public Pager findPager(Pager pager, Map paramMap) throws PlatformException {
        return baseMapper.findPager(pager, paramMap);
    }

    @Transactional(readOnly = true)
    public Pager findPager(Pager pager) throws PlatformException {
        return baseMapper.findPager(pager);
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