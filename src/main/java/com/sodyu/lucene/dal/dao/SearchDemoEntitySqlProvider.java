package com.sodyu.lucene.dal.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.sodyu.lucene.dal.entity.SearchDemoEntity;
import com.sodyu.lucene.dal.entity.SearchDemoEntityExample.Criteria;
import com.sodyu.lucene.dal.entity.SearchDemoEntityExample.Criterion;
import com.sodyu.lucene.dal.entity.SearchDemoEntityExample;
import java.util.List;
import java.util.Map;

public class SearchDemoEntitySqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table demo
     *
     * @mbggenerated Fri Jul 21 11:08:49 CST 2017
     */
    public String countByExample(SearchDemoEntityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("demo");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table demo
     *
     * @mbggenerated Fri Jul 21 11:08:49 CST 2017
     */
    public String deleteByExample(SearchDemoEntityExample example) {
        BEGIN();
        DELETE_FROM("demo");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table demo
     *
     * @mbggenerated Fri Jul 21 11:08:49 CST 2017
     */
    public String insertSelective(SearchDemoEntity record) {
        BEGIN();
        INSERT_INTO("demo");
        
        if (record.getID() != null) {
            VALUES("ID", "#{ID,jdbcType=BIGINT}");
        }
        
        if (record.getSpotID() != null) {
            VALUES("spotID", "#{spotID,jdbcType=BIGINT}");
        }
        
        if (record.getSpotName() != null) {
            VALUES("spotName", "#{spotName,jdbcType=VARCHAR}");
        }
        
        if (record.getEname() != null) {
            VALUES("ename", "#{ename,jdbcType=VARCHAR}");
        }
        
        if (record.getLat() != null) {
            VALUES("lat", "#{lat,jdbcType=DOUBLE}");
        }
        
        if (record.getLon() != null) {
            VALUES("lon", "#{lon,jdbcType=DOUBLE}");
        }
        
        if (record.getAddress() != null) {
            VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getDistrictName() != null) {
            VALUES("districtName", "#{districtName,jdbcType=VARCHAR}");
        }
        
        if (record.getCityName() != null) {
            VALUES("cityName", "#{cityName,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceName() != null) {
            VALUES("provinceName", "#{provinceName,jdbcType=VARCHAR}");
        }
        
        if (record.getCountryName() != null) {
            VALUES("countryName", "#{countryName,jdbcType=VARCHAR}");
        }
        
        if (record.getThemeTags() != null) {
            VALUES("themeTags", "#{themeTags,jdbcType=VARCHAR}");
        }
        
        if (record.getAttentionDegree() != null) {
            VALUES("attentionDegree", "#{attentionDegree,jdbcType=DOUBLE}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("createTime", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table demo
     *
     * @mbggenerated Fri Jul 21 11:08:49 CST 2017
     */
    public String selectByExample(SearchDemoEntityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("spotID");
        SELECT("spotName");
        SELECT("ename");
        SELECT("lat");
        SELECT("lon");
        SELECT("address");
        SELECT("districtName");
        SELECT("cityName");
        SELECT("provinceName");
        SELECT("countryName");
        SELECT("themeTags");
        SELECT("attentionDegree");
        SELECT("createTime");
        FROM("demo");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table demo
     *
     * @mbggenerated Fri Jul 21 11:08:49 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        SearchDemoEntity record = (SearchDemoEntity) parameter.get("record");
        SearchDemoEntityExample example = (SearchDemoEntityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("demo");
        
        if (record.getID() != null) {
            SET("ID = #{record.ID,jdbcType=BIGINT}");
        }
        
        if (record.getSpotID() != null) {
            SET("spotID = #{record.spotID,jdbcType=BIGINT}");
        }
        
        if (record.getSpotName() != null) {
            SET("spotName = #{record.spotName,jdbcType=VARCHAR}");
        }
        
        if (record.getEname() != null) {
            SET("ename = #{record.ename,jdbcType=VARCHAR}");
        }
        
        if (record.getLat() != null) {
            SET("lat = #{record.lat,jdbcType=DOUBLE}");
        }
        
        if (record.getLon() != null) {
            SET("lon = #{record.lon,jdbcType=DOUBLE}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getDistrictName() != null) {
            SET("districtName = #{record.districtName,jdbcType=VARCHAR}");
        }
        
        if (record.getCityName() != null) {
            SET("cityName = #{record.cityName,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceName() != null) {
            SET("provinceName = #{record.provinceName,jdbcType=VARCHAR}");
        }
        
        if (record.getCountryName() != null) {
            SET("countryName = #{record.countryName,jdbcType=VARCHAR}");
        }
        
        if (record.getThemeTags() != null) {
            SET("themeTags = #{record.themeTags,jdbcType=VARCHAR}");
        }
        
        if (record.getAttentionDegree() != null) {
            SET("attentionDegree = #{record.attentionDegree,jdbcType=DOUBLE}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table demo
     *
     * @mbggenerated Fri Jul 21 11:08:49 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("demo");
        
        SET("ID = #{record.ID,jdbcType=BIGINT}");
        SET("spotID = #{record.spotID,jdbcType=BIGINT}");
        SET("spotName = #{record.spotName,jdbcType=VARCHAR}");
        SET("ename = #{record.ename,jdbcType=VARCHAR}");
        SET("lat = #{record.lat,jdbcType=DOUBLE}");
        SET("lon = #{record.lon,jdbcType=DOUBLE}");
        SET("address = #{record.address,jdbcType=VARCHAR}");
        SET("districtName = #{record.districtName,jdbcType=VARCHAR}");
        SET("cityName = #{record.cityName,jdbcType=VARCHAR}");
        SET("provinceName = #{record.provinceName,jdbcType=VARCHAR}");
        SET("countryName = #{record.countryName,jdbcType=VARCHAR}");
        SET("themeTags = #{record.themeTags,jdbcType=VARCHAR}");
        SET("attentionDegree = #{record.attentionDegree,jdbcType=DOUBLE}");
        SET("createTime = #{record.createTime,jdbcType=TIMESTAMP}");
        
        SearchDemoEntityExample example = (SearchDemoEntityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table demo
     *
     * @mbggenerated Fri Jul 21 11:08:49 CST 2017
     */
    public String updateByPrimaryKeySelective(SearchDemoEntity record) {
        BEGIN();
        UPDATE("demo");
        
        if (record.getSpotID() != null) {
            SET("spotID = #{spotID,jdbcType=BIGINT}");
        }
        
        if (record.getSpotName() != null) {
            SET("spotName = #{spotName,jdbcType=VARCHAR}");
        }
        
        if (record.getEname() != null) {
            SET("ename = #{ename,jdbcType=VARCHAR}");
        }
        
        if (record.getLat() != null) {
            SET("lat = #{lat,jdbcType=DOUBLE}");
        }
        
        if (record.getLon() != null) {
            SET("lon = #{lon,jdbcType=DOUBLE}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getDistrictName() != null) {
            SET("districtName = #{districtName,jdbcType=VARCHAR}");
        }
        
        if (record.getCityName() != null) {
            SET("cityName = #{cityName,jdbcType=VARCHAR}");
        }
        
        if (record.getProvinceName() != null) {
            SET("provinceName = #{provinceName,jdbcType=VARCHAR}");
        }
        
        if (record.getCountryName() != null) {
            SET("countryName = #{countryName,jdbcType=VARCHAR}");
        }
        
        if (record.getThemeTags() != null) {
            SET("themeTags = #{themeTags,jdbcType=VARCHAR}");
        }
        
        if (record.getAttentionDegree() != null) {
            SET("attentionDegree = #{attentionDegree,jdbcType=DOUBLE}");
        }
        
        if (record.getCreateTime() != null) {
            SET("createTime = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("ID = #{ID,jdbcType=BIGINT}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table demo
     *
     * @mbggenerated Fri Jul 21 11:08:49 CST 2017
     */
    protected void applyWhere(SearchDemoEntityExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}