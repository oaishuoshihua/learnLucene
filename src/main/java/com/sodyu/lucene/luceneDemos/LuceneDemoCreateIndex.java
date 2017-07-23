package com.sodyu.lucene.luceneDemos;

import com.sodyu.lucene.constants.CommonConstant;
import com.sodyu.lucene.util.DalUtil;
import com.sodyu.lucene.util.DocumentUtil;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Iterator;
import java.util.List;


/**
 * Created by yuhp on 2017/7/17.
 */
public class LuceneDemoCreateIndex {


    private static Logger logger = LoggerFactory.getLogger(LuceneDemoCreateIndex.class);

    public static void createIndex() {
        Directory directory = null;
        IndexWriter writer = null;
        try {
            directory = FSDirectory.open(FileSystems.getDefault().getPath(CommonConstant.INDEX_PATH));
            Analyzer analyzer = new IKAnalyzer(true);
            IndexWriterConfig config = new IndexWriterConfig(analyzer);
            config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            writer = new IndexWriter(directory, config);
            List<Document> documents= DocumentUtil.getDocuments(DalUtil.getSearchDemoEntityList());
            Iterator<Document> iterator=documents.iterator();
            while(iterator.hasNext()){
                Document doc=iterator.next();
                writer.addDocument(doc);
            }
            writer.commit();
            writer.close();
            logger.info("创建索引成功");
        } catch (IOException e) {
            logger.error("创建索引对象indexWriter出错");
        } finally {
            try {
                if (writer != null) writer.close();
                directory.close();
            } catch (Exception e) {
                logger.error("关闭文件流出错");
            }
        }


    }

}
