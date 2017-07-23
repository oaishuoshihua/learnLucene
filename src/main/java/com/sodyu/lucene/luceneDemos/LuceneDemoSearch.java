package com.sodyu.lucene.luceneDemos;

import com.sodyu.lucene.constants.CommonConstant;
import com.sodyu.lucene.enums.QueryEnums;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.LatLonPoint;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.search.spans.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileSystems;

/**
 * Created by yuhp on 2017/7/17.
 */
public class LuceneDemoSearch {
    private static Logger logger = LoggerFactory.getLogger(LuceneDemoSearch.class);
    private static Directory directory=null;
    private static IndexSearcher indexSearcher = null;
    private static DirectoryReader directoryReader = null;

    /**
     * 创建indexSearch
     */
    public static void initSearch() {
        try {
            directory= FSDirectory.open(FileSystems.getDefault().getPath(CommonConstant.INDEX_PATH));
            //创建IndexReader
            directoryReader = DirectoryReader.open(directory);
            //根据IndexReader创建IndexSearch
            indexSearcher = new IndexSearcher(directoryReader);
        } catch (IOException e) {
            logger.error("创建indexSearch失败",e);
        }
    }

    /**
     * 关闭indexReader
     */
    public static void close(){
        try {
            if(directoryReader!=null){
                directoryReader.close();
            }
            if(directory!=null){
                directory.close();
            }
        } catch (IOException e) {
            logger.error("关闭流出现错误",e);
        }
    }
/**-------------------------------------query类API测试----------start---------------------**/

    public void Search(Query query) {
        try {
            long startTime=System.currentTimeMillis();
            initSearch();
            System.out.println("Query类型-----"+query.getClass().getSimpleName());
            System.out.println("解析query-----"+query.toString());
            TopDocs docs = indexSearcher.search(query, 10);
            System.out.println("共找到匹配处：" + docs.totalHits); // totalHits表示匹配的数量
            //根据TopDocs获取ScoreDoc对象
            ScoreDoc[] scoreDocs = docs.scoreDocs;
            System.out.println("共找到匹配文档数：" + scoreDocs.length);//scoreDocs最多只会包含前N个文档;但是totalHits会返回匹配的总数量
            for (int i = 0; i < scoreDocs.length; i++) {
                ScoreDoc scoreDoc = scoreDocs[i];
                float score=scoreDoc.score;
                Document doc = indexSearcher.doc(scoreDoc.doc);
                System.out.println("id("+doc.get("id") + ")---" + doc.get("name")+"--"+score);
            }
            close();
            long endTime=System.currentTimeMillis();
            System.out.println("查询耗时："+(endTime-startTime)+"ms");
        } catch (Exception e) {
            logger.error("查询失败",e);
        }
    }

/**-------------------------------------query类API测试-----------end-----------------**/


    /**
     * 坐标查询
     */
    public void searchByDistance() {
        try {
            initSearch();
            long startTime=System.currentTimeMillis();
            TopFieldDocs docs =  LatLonPoint.nearest(indexSearcher, "coordinate", 30.9451075304475, 120.896874845028, 6);
            System.out.println("共找到匹配处：" + docs.totalHits); // totalHits表示匹配的数量
            //根据TopDocs获取ScoreDoc对象
            ScoreDoc[] scoreDocs = docs.scoreDocs;
            long endTime=System.currentTimeMillis();
            System.out.println("查询耗时："+(endTime-startTime)+"ms");
            System.out.println("共找到匹配文档数：" + scoreDocs.length);//scoreDocs最多只会包含前N个文档;但是totalHits会返回匹配的总数量
            for (int i = 0; i < scoreDocs.length; i++) {
                ScoreDoc scoreDoc = scoreDocs[i];
                Document doc = indexSearcher.doc(scoreDoc.doc);
                System.out.println(doc.get("id") + ":" + doc.get("name")+ ":" + doc.get("address"));
            }
            close();

        } catch (Exception e) {
            logger.error("查询失败",e);
        }
    }


    private Query getQuery(int queryType){
       Query query=null;
        Term term =null;
        switch (queryType){
            case 0:
                /**termQuery**/
                term=new Term("name", "中山");
                query = new TermQuery(term);//完全匹配
                break;
            case 1:
                /**termRangeQuery**/
                query = new TermRangeQuery("ename",new BytesRef("k"),new BytesRef("l"),false,false);//设定范围,后面代表是否包含边界
                break;
            case 2:
                /**wildcardQuery 通配符匹配**/
                term=new Term("name", "中*");
                query = new WildcardQuery(term);
                break;
            case 3:
                /**FuzzyQuery 模糊相似度匹配**/
                term=new Term("name", "中山");
                query = new FuzzyQuery(term,2,2);// 第二个参数为编辑距离（编辑距离0~2，不超过2），第三个参数代表前几个字符是100%要匹配的
                break;
            case 4:
                /**PrefixQuery 前缀匹配**/
                term=new Term("name", "上海");
                query = new PrefixQuery(term);
                break;
            case 5:
                /**SpanTermQuery 跨度匹配**/
                term=new Term("name", "寺");
                query = new SpanTermQuery(term);//与TermQuery用法很相似，唯一区别就是SapnTermQuery可以得到
                break;
            case 6:
                /**SpanFirstQuery**/
                term=new Term("name", "山");
                SpanTermQuery spanTermQuery=new SpanTermQuery(term);
                query = new SpanFirstQuery(spanTermQuery,4);//在指定的距离可以找到第一个单词的查询
                break;
            case 7:
                /**SpanNearQuery**/
                SpanQuery[] queries=new SpanQuery[2];
                queries[0]=new SpanTermQuery(new Term("name","公园"));
                queries[1]=new SpanTermQuery(new Term("name","中山"));
                query = new SpanNearQuery(queries,0,true);//查询的几个语句之间保持着一定的距离
                break;
            case 8:
                /**SpanOrQuery**/
                query = new SpanOrQuery(new SpanTermQuery(new Term("name","公园")),new SpanTermQuery(new Term("name","中山")));//同时几个词句查询
                break;
            case 9:
                /**SpanNotQuery**/
                SpanQuery termQuery1=new SpanTermQuery(new Term("name","公园"));
                SpanQuery termQuery2=new SpanTermQuery(new Term("name","中山"));
                SpanQuery includeQuery = new SpanNearQuery(new SpanQuery[]{termQuery1,termQuery2},3,true);
                SpanQuery excludeQuery =new SpanTermQuery(new Term("name","王"));
                query = new SpanNotQuery(includeQuery,excludeQuery,4,3);//从一个词距查询结果中除去一个词距查询
                break;

        }
        return query;
    }


    public static void main(String[] args) {
//        LuceneDemoCreateIndex.createIndex();
        LuceneDemoSearch search=new LuceneDemoSearch();
        Query query=search.getQuery(QueryEnums.SPANFIRSTQUERY.code);
        search.Search(query);
    }

}
