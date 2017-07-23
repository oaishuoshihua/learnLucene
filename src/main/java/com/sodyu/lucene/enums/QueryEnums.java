package com.sodyu.lucene.enums;

/**
 * Created by yuhp on 2017/7/21.
 */
public enum QueryEnums {
    TERMQUERY(0),
    TERMRANGEQUERY(1),
    WILDCARDQUERY(2),
    FUZZYQUERY(3),
    PREFIXQUERY(4),
    SPANTERMQUERY(5),
    SPANFIRSTQUERY(6),
    SPANNNEARQUERY(7),
    SPANORQUERY(8),
    SPANNOTQUERY(9);

    public int code;

    QueryEnums(int code) {
        this.code = code;
    }

    public static int getCode(String name) {
        QueryEnums q = QueryEnums.valueOf(name);
        if (q != null) {
            return q.code;
        } else {
            return -1;
        }

    }
}
