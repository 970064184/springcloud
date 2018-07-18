package com.example.demo.test;

import com.example.demo.domain.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestMain {

	public static void main(String[] args) {
		new Person();
		// Person p = new Person();
		// Person p = new Person(2l, "test", 25);
		// Person p = Person.builder().age(8).userName("ggg").build();
		// p.setId(1233456l);
		// System.out.println(p);
		log.info("测试日志");

		Person p1 = new Person();
		Person p2 = new Person();
		System.out.println(p1.equals(p2));// true System.out.println(p1 == p2);//

		int a = 8;
		int b = 0; // System.out.println(a / b);

		try {
			System.out.println(a / b);
		} catch (Exception e) {
			System.out.println("异常信息：" + e.getMessage());
			System.err.println("除数不能为零");
			e.printStackTrace();
		}

		System.out.println("代码块结束");

		/*
		 * Demo02 d = new Demo02(); try { int x = d.div(4, -1); System.out.println("x:"
		 * + x); } catch (MyException e) { System.out.println(e.toString()); //
		 * System.out.println("除数出现负数了"); System.out.println("错误的负数是：" + e.getValue());
		 * } System.out.println("over");
		 */
	}

}

/*
 * class Demo02 { int div(int a, int b) throws MyException { if (b < 0) { throw
 * new MyException("出现了除数是负数的情况", b);// 手动通过throw关键字抛出一个自定义异常对象。 } return a / b;
 * } }
 */