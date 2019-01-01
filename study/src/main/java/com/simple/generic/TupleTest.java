package com.simple.generic;

import java.util.Date;

public class TupleTest{
	public static void main(String[] args) {  
        TwoTuple<Integer,String> twoT = new TwoTuple<Integer,String>(99,"掌上洪城");  
        System.out.println(twoT);  
        System.out.println("======扩展元组类库后======");  
        ThreeTuple<Integer,String,Date> threeT= new ThreeTuple<Integer,String,Date>(99,"掌上洪城",new Date());  
        System.out.println(threeT);  
    }  
}

class TwoTuple<A,B>{  
    public final A first;  
    public final B second;  
  
    public TwoTuple(A a,B b){ //这里是括号，不是中括号  
        first = a;  
        second = b;  
    }  
    public String toString(){  
        return "(" + first + "," + second + ")";  
    }  
}  

class ThreeTuple<A,B,C> extends TwoTuple<A,B>{  
    private final C three;  
    public ThreeTuple(A a,B b,C c){  
        super(a,b);  
        three = c;  
    }  
    public String toString(){  
        return "(" + first + "," + second + "," + three + ")";  
    }  
}  


