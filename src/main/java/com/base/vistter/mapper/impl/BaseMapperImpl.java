package com.base.vistter.mapper.impl;

import com.base.vistter.bean.Pager;
import com.base.vistter.bean.Result;
import com.base.vistter.mapper.BaseMapper;
import com.base.vistter.exception.PlatformException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseMapperImpl implements BaseMapper {

    protected static final Logger logger = LogManager.getLogger(BaseMapperImpl.class);

    @Autowired
    protected SqlSession session;

    @Override
    public Pager findPager(Pager pager) throws PlatformException {
        try {
            return this.findPager(pager, null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public Pager findPager(Pager pager, Map paramMap) throws PlatformException {
        logger.info("查询分页开始，查询分页参数", pager, "查询条件参数", paramMap);
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
            logger.info("查询结束");
            return pager;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public List<Map> findList() throws PlatformException {
        try {
            return this.findList(null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public List<Map> findList(Map paramMap) throws PlatformException {
        logger.info("查询列表开始，查询参数", paramMap);
        try {
            List<Map> list = session.selectList(this.getNameSpace() + ".list", paramMap);
            logger.info("查询列表结束, 列表结果 ", list);
            return list;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public List<Map> findList(String statement, Object parameter) throws PlatformException {
        logger.info("查询列表开始，查询参数", parameter);
        try {
            List<Map> list = session.selectList(this.getNameSpace() + "." + statement, parameter);
            logger.info("查询列表结束, 列表结果 ", list);
            return list;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public long count() throws PlatformException {
        try {
            return this.count(null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public long count(Map paramMap) throws PlatformException {
        logger.info("统计个数开始， 统计参数", paramMap);
        try {
            long count = session.selectOne(this.getNameSpace() + ".count", paramMap);
            logger.info("统计个数结束， 得到个数是 ", count);
            return count;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public long count(String statement, Object parameter) throws PlatformException {
        logger.info("统计个数开始， 统计参数", parameter);
        try {
            long count = session.selectOne(this.getNameSpace() + "." + statement, parameter);
            logger.info("统计个数结束， 得到个数是 ", count);
            return count;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public Map load(String id) throws PlatformException {
        logger.info("加载单条数据， 加载参数 ", id);
        try {
            return session.selectOne(this.getNameSpace() + ".load", id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public Map load(String statement, Object parameter) throws PlatformException {
        logger.info("加载单条数据， 加载参数 ", parameter);
        try {
            return session.selectOne(this.getNameSpace() + "." + statement, parameter);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public void save() throws PlatformException {
        try {
            this.save(null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public void save(Map paramMap) throws PlatformException {
        logger.info("保存开始， 保存参数 ", paramMap);
        try {
            session.insert(this.getNameSpace() + ".save", paramMap);
            logger.info("保存结束");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public void update() throws PlatformException {
        try {
            this.update(null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public void update(Map paramMap) throws PlatformException {
        logger.info("修改开始， 修改参数 ", paramMap);
        try {
            session.update(this.getNameSpace() + ".update", paramMap);
            logger.info("修改结束");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public void update(String statement, Object parameter) throws PlatformException {
        logger.info("修改开始， 修改参数 ", parameter);
        try {
            session.update(this.getNameSpace() + "." + statement, parameter);
            logger.info("修改结束");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public void deleteById(String id) throws PlatformException {
        logger.info("删除开始， 删除参数 ", id);
        try {
            session.delete(this.getNameSpace() + ".deleteById", id);
            logger.info("删除结束");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    @Override
    public void delete(List list) throws PlatformException {
        logger.info("删除开始， 删除参数 ", list);
        try {
            session.delete(this.getNameSpace() + ".delete", list);
            logger.info("删除结束");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PlatformException();
        }
    }

    protected abstract String getNameSpace();
}
