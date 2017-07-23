package com.sodyu.lucene.demo;

import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.FieldComparator;
import org.apache.lucene.search.FieldComparatorSource;
import org.apache.lucene.search.LeafFieldComparator;
import org.apache.lucene.search.Scorer;

import java.io.IOException;

/**
 * Created by yuhp on 2017/6/26.
 */
public class CustomSortDemo {


}


class DistanceComparatorSource extends FieldComparatorSource {

    private double x;
    private double y;
    public DistanceComparatorSource(double x,double y){
        super();
        this.x=x;
        this.y=y;

    }
    @Override
    public FieldComparator<?> newComparator(String fieldName, int numHits, int i1, boolean b) throws IOException {
        return new DistanceComparator(fieldName,numHits);
    }


    class DistanceComparator extends FieldComparator implements LeafFieldComparator{
        private int[] xDoc,yDoc;
        private float[] values;
        private float bottom;
        String fieldName;

        public DistanceComparator(String fieldName,int numHits){
            this.fieldName=fieldName;
            values=new float[numHits];
        }
        @Override
        public int compare(int i, int i1) {
            if(values[i]>values[i1]){
                return 1;
            }
            if(values[i]<values[i1]){
                return -1;
            }
            return 0;
        }

        @Override
        public void setTopValue(Object o) {

        }

        @Override
        public Object value(int i) {
            return null;
        }

        @Override
        public LeafFieldComparator getLeafComparator(LeafReaderContext leafReaderContext) throws IOException {
            return null;
        }

        public void setBottom(int i) {

        }

        public int compareBottom(int i) throws IOException {
            return 0;
        }

        public int compareTop(int i) throws IOException {
            return 0;
        }

        public void copy(int i, int i1) throws IOException {

        }

        public void setScorer(Scorer scorer) {

        }
    }
}