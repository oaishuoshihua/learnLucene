package com.sodyu.lucene;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhp on 2017/5/25.
 */
public class test {
    public static void main(String[] args) throws IOException {
        String test="我是司马懿";
        List<String> list=displayToken(test);
        System.out.println(list);
    }
    public static List<String> displayToken(String str) throws IOException {
        IKSegmenter ik = new IKSegmenter(new StringReader(str), true);
        Lexeme lexeme = null;
        List<String> tokens = new ArrayList<String>();
        while ((lexeme = ik.next()) != null) {
            String word = lexeme.getLexemeText();
            tokens.add(word);
        }
        return tokens;
    }
}
