package com.sodyu.lucene.util;

import com.sodyu.lucene.dal.dao.SearchDemoEntityMapper;
import com.sodyu.lucene.dal.entity.SearchDemoEntity;
import com.sodyu.lucene.dal.entity.SearchDemoEntityExample;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.util.BytesRef;

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
                document.add(new StringField("id",entity.getSpotID().toString(), Field.Store.YES));
                document.add(new TextField("name",entity.getSpotName(), Field.Store.YES));
                document.add(new SortedDocValuesField("name", new BytesRef(entity.getSpotName())));
                document.add(new TextField("ename",entity.getEname(), Field.Store.YES));
                document.add(new StoredField("lat",entity.getLat()));
                document.add(new StoredField("lon",entity.getLon()));
                document.add(new LatLonPoint("coordinate",entity.getLat(),entity.getLon()));
                document.add(new StringField("address",entity.getAddress()==null?"":entity.getAddress(),Field.Store.YES));
                document.add(new StringField("city",entity.getCityName()==null?"":entity.getCityName(),Field.Store.YES));
                document.add(new StringField("districtname",entity.getDistrictName()==null?"":entity.getDistrictName(),Field.Store.YES));
                document.add(new DoublePoint("attendtiondegree",entity.getAttentionDegree()));
                long date=entity.getCreateTime()==null?System.currentTimeMillis():entity.getCreateTime().getTime();
                document.add(new NumericDocValuesField("createtime",date));
                documents.add(document);
            }

        }
        return documents;
    }
}
