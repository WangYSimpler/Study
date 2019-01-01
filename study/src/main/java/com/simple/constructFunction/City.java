package com.simple.constructFunction;

public class City extends Country {

	String name;

	void value() {
		name = "Hefei";
		System.out.println(name);
		///���췽��ʵ�ַ�����֤��ȡ������ĺ���
		super.value();// �����ô˷���ʱ��super.name���ص��Ǹ���ĳ�Ա������ֵnull
		System.out.println(super.name);
	}

	public static void main(String[] args) {
		City c = new City();
		c.value();
	}
}
