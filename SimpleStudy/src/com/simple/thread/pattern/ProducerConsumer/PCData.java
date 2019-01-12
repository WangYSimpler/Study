package com.simple.thread.pattern.ProducerConsumer;

/**
 * Created by Administrator on 2019/1/1.
 */
public  final class PCData {

    private final int intData;

    public PCData(int d) {
        intData=d;
    }

    public PCData(String  d) {
        intData=Integer.valueOf(d);
    }

    public int getData(){

        return intData;

    }
    @Override
    public String toString(){
        return "data:"+ intData ;
    }
}
