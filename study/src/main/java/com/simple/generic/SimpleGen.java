package com.simple.generic;

public class SimpleGen {

	private Object obj;
	
	
	
	public SimpleGen(Object obj) {
		super();
		this.obj = obj;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public void showClassName(){
		System.out.println(obj.getClass().getName());
	}

	public static void main(String[] args) {
		
		SimpleGen sg = new SimpleGen(new Integer(99));  
        sg.showClassName();  
        int i = (Integer) sg.getObj(); //强制类型转换，系统可能会抛一个ClassCastException异常信息  
        System.out.println("value = " + i);  
        SimpleGen sg2 = new SimpleGen("掌上洪城");  
        sg2.showClassName();               //强制类型转换，系统可能会抛一个ClassCastException异常信息  
        String str = (String) sg2.getObj();  
        System.out.println("value = " + str);  
	}

}
