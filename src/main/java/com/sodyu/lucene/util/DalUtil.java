package com.sodyu.lucene.util;

import com.sodyu.lucene.dal.dao.SearchDemoEntityMapper;
import com.sodyu.lucene.dal.entity.SearchDemoEntity;
import com.sodyu.lucene.dal.entity.SearchDemoEntityExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by yuhp on 2017/7/17.
 */
public class DalUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession session = null;
    private static Logger logger = LoggerFactory.getLogger(DalUtil.class);
    static {
        /**
         * 初始化Sqlsession
         */
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
            session = sqlSessionFactory.openSession(true);
        }catch (Exception e) {
            logger.error("DB session初始化错误", e);
        }
    }

    public static <T> T getMapper(Class<?> clazz){
        T t=(T)session.getMapper(clazz);
        return t;
    }

    public static List<SearchDemoEntity> getSearchDemoEntityList(){
        SearchDemoEntityMapper mapper= DalUtil.getMapper(SearchDemoEntityMapper.class);
        SearchDemoEntityExample example=new SearchDemoEntityExample();
        example.createCriteria().andSpotNameIsNotNull();
        List<SearchDemoEntity> entityList=mapper.selectByExample(example);
        return entityList;
    }

}
