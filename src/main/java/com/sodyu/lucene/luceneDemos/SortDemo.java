package com.sodyu.lucene.luceneDemos;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yuhp on 2017/7/24.
 */
public class SortDemo {
    private static Logger logger = LoggerFactory.getLogger(SortDemo.class);
    public void Search() {
        try {
            long startTime=System.currentTimeMillis();
            LuceneDemoSearch.initSearch();
            Query query=new TermQuery(new Term("name","上海"));
            System.out.println("Query类型-----"+query.getClass().getSimpleName());
            System.out.println("解析query-----"+query.toString());
            Sort sort=new Sort(new SortField("createtime",SortField.Type.LONG,true),SortField.FIELD_DOC);
            TopFieldDocs docs = LuceneDemoSearch.indexSearcher.search(query, 10,sort);
            System.out.println("共找到匹配处：" + docs.totalHits); // totalHits表示匹配的数量
            //根据TopDocs获取ScoreDoc对象
            ScoreDoc[] scoreDocs = docs.scoreDocs;
            System.out.println("共找到匹配文档数：" + scoreDocs.length);//scoreDocs最多只会包含前N个文档;但是totalHits会返回匹配的总数量
            for (int i = 0; i < scoreDocs.length; i++) {
                FieldDoc scoreDoc = (FieldDoc)scoreDocs[i];
                float score=scoreDoc.score;
//                System.out.println(scoreDoc.fields[0]);
                int docid=scoreDoc.doc;
                Document doc = LuceneDemoSearch.indexSearcher.doc(scoreDoc.doc);
                System.out.println("id("+doc.get("id") + ")---" + doc.get("name")+"--"+docid);
            }
            LuceneDemoSearch.close();
            long endTime=System.currentTimeMillis();
            System.out.println("查询耗时："+(endTime-startTime)+"ms");
        } catch (Exception e) {
            logger.error("查询失败",e);
        }
    }

    public static void main(String[] args) {
        SortDemo demo=new SortDemo();
        demo.Search();
    }
}
