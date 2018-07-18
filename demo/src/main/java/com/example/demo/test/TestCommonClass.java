package com.example.demo.test;

/**
 * 测试各种常用类
 * 
 * @author zb
 * @date 2018年7月16日 下午5:27:57
 */
public class TestCommonClass {

	public static void main(String[] args) {
		// int i = 9;
		// Integer integer = new Integer(i);
		// System.out.println(integer);
		// int intValue = integer.intValue();
		// System.out.println(intValue);
		//
		// int ii = 8;
		// String valueOf = String.valueOf(ii);
		// System.out.println(valueOf);
		//
		// String s = " hl sdlsj ";
		// System.out.println(s.startsWith("d"));
		// System.out.println(s.startsWith("h"));
		// System.out.println(s);
		// System.out.println(s.trim());

		// ==是否是同一对象，equals内容是否一样
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		String s4 = new String("abc");
		System.out.println(s1 == s2);// true
		System.out.println(s1 == s3);// false
		System.out.println(s3 == s4);// false
		System.out.println(s1.equals(s2));// true
		System.out.println(s1.equals(s3));// true
		System.out.println(s3.equals(s4));// true
	}
}
