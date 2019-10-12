package com.base.vistter.mapper.impl;

import com.base.vistter.bean.Pager;
import com.base.vistter.mapper.BaseMapper;
import com.base.vistter.exception.PlatformException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BaseMapperImpl implements BaseMapper {

    @Autowired
    protected SqlSession session;

    @Override
    public Pager findPager(Pager pager) throws PlatformException {
        try {
            return this.findPager(pager, null);
        } catch (Exception e) {
            throw new PlatformException();
        }
    }

    @Override
    public Pager findPager(Pager pager, Map paramMap) throws PlatformException {
        try {
            long total = session.selectOne(this.getNameSpace() + ".pagerCount", paramMap);
            if (paramMap == null) {
                paramMap = new HashMap();
            }
            paramMap.put("start", (pager.getPagerNumber() - 1) * pager.getPageSize());
            paramMap.put("limit", pager.getPageSize());
            List<Map> result = session.selectList(this.getNameSpace() + ".pager", paramMap);
            pager.setTotal(total);
            pager.setResult(result);
            return pager;
        } catch (Exception e) {
            throw new PlatformException();
        }
    }

    @Override
    public List<Map> findList() throws PlatformException {
        try {
            return this.findList(null);
        } catch (Exception e) {
            throw new PlatformException();
        }
    }

    @Override
    public List<Map> findList(Map paramMap) throws PlatformException {
        try {
            List<Map> list = session.selectList(this.getNameSpace() + ".list", paramMap);
            return list;
        } catch (Exception e) {
            throw new PlatformException();
        }
    }

    @Override
    public long count() throws PlatformException {
        try {
            return this.count(null);
        } catch (Exception e) {
            throw new PlatformException();
        }
    }

    @Override
    public long count(Map paramMap) throws PlatformException {
        try {
            return session.selectOne(this.getNameSpace() + ".count", paramMap);
        } catch (Exception e) {
            throw new PlatformException();
        }
    }

    @Override
    public void save() throws PlatformException {
        try {
            this.save(null);
        } catch (Exception e) {
            throw new PlatformException();
        }
    }

    @Override
    public void save(Map paramMap) throws PlatformException {
        try {
            session.insert(this.getNameSpace() + ".save", paramMap);
        } catch (Exception e) {
            throw new PlatformException();
        }
    }

    @Override
    public void update() throws PlatformException {
        try {
            this.update(null);
        } catch (Exception e) {
            throw new PlatformException();
        }
    }

    @Override
    public void update(Map paramMap) throws PlatformException {
        try {
            session.update(this.getNameSpace() + ".update", paramMap);
        } catch (Exception e) {
            throw new PlatformException();
        }
    }

    @Override
    public void deleteById(String id) throws  PlatformException{
        try {
            session.delete(this.getNameSpace()+ ".deleteById" , id);
        } catch (Exception e) {
            throw new PlatformException();
        }
    }

    @Override
    public void delete(List list) throws  PlatformException{
        try {
            session.delete(this.getNameSpace()+ ".delete" , list);
        } catch (Exception e) {
            throw new PlatformException();
        }
    }

    protected abstract String getNameSpace();
}
