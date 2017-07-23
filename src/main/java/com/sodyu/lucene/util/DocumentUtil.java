package com.sodyu.lucene.util;

import com.sodyu.lucene.dal.dao.SearchDemoEntityMapper;
import com.sodyu.lucene.dal.entity.SearchDemoEntity;
import com.sodyu.lucene.dal.entity.SearchDemoEntityExample;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexableField;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yuhp on 2017/7/19.
 */
public class DocumentUtil {

    public static List<Document> getDocuments(List<SearchDemoEntity> entityList){
        List<Document> documents=new ArrayList<Document>();
        if(entityList!=null&&entityList.size()>0){
            Iterator<SearchDemoEntity> iterator =entityList.iterator();
            while(iterator.hasNext()){
                SearchDemoEntity entity=iterator.next();
                Document document=new Document();
                document.add(new Field("id",entity.getSpotID().toString(), StringField.TYPE_STORED));
                document.add(new Field("name",entity.getSpotName(), TextField.TYPE_STORED));
                document.add(new Field("ename",entity.getEname(), TextField.TYPE_STORED));
                document.add(new StoredField("lat",entity.getLat()));
                document.add(new StoredField("lon",entity.getLon()));
                document.add(new LatLonPoint("coordinate",entity.getLat(),entity.getLon()));
                document.add(new Field("address",entity.getAddress()==null?"":entity.getAddress(),TextField.TYPE_STORED));
                document.add(new Field("city",entity.getCityName()==null?"":entity.getCityName(),StringField.TYPE_STORED));
                document.add(new Field("districtname",entity.getDistrictName()==null?"":entity.getDistrictName(),StringField.TYPE_STORED));
                document.add(new DoublePoint("attendtiondegree",entity.getAttentionDegree()));
                long date=entity.getCreateTime()==null?System.currentTimeMillis():entity.getCreateTime().getTime();
                document.add(new NumericDocValuesField("createtime",date));
                documents.add(document);
            }

        }
        return documents;
    }
}
