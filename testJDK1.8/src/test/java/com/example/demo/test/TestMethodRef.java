package com.example.demo.test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import com.example.demo.domain.Employee;

/**
 * 测试jkd8方法引用
 * 
 * @author zb
 * @date 2018年8月22日 下午2:24:14
 */
public class TestMethodRef {

	@Test
	public void test1() {
		Consumer<String> con = (x) -> System.out.println(x);
		con.accept("山东黄金");
		Consumer<String> con1 = System.out::println;
		con1.accept("ceshi");
	}

	@Test
	public void test2() {
		Employee e = new Employee("xiao", 14, 6999);
		Supplier<String> sup = () -> e.getName();
		String string = sup.get();
		System.out.println(string);
		Supplier<String> sup1 = e::getName;
		String string2 = sup1.get();
		System.out.println(string2);
	}

	@Test
	public void test3() {
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
		int compare = com.compare(3, 5);
		System.out.println(compare);

		Comparator<Integer> com1 = Integer::compare;
		int compare2 = com1.compare(8, 7);
		System.out.println(compare2);
	}

	@Test
	public void test4() {
		// 类：：实例方法名
		// 规则：x,y x为实例方法的调用者，y为实例方法的参数实例
		BiPredicate<String, String> bp = (x, y) -> x.equals(y);
		boolean test = bp.test("abc", "abc");
		System.out.println(test);
		BiPredicate<String, String> bp1 = String::equals;
		boolean test2 = bp1.test("ddd", "d1dd");
		System.out.println(test2);
	}

	@Test
	public void test5() {
		Supplier<Employee> sup = () -> new Employee();
		Employee employee = sup.get();
		System.out.println(employee);

		Supplier<Employee> sup1 = Employee::new;
		Employee employee2 = sup1.get();
		System.out.println(employee2);

		BiFunction<String, Integer, Employee> bf = (x, y) -> new Employee(x, y);
		Employee apply = bf.apply("www", 12);
		System.out.println(apply);

		BiFunction<String, Integer, Employee> bf1 = Employee::new;
		Employee apply2 = bf1.apply("dddd", 88);
		System.out.println(apply2);
	}

	@Test
	public void test6() {
		Function<Integer, String[]> fun = (x) -> new String[x];
		String[] apply = fun.apply(2);
		System.out.println(apply.length);

		Function<Integer, String[]> fun1 = String[]::new;
		String[] apply2 = fun1.apply(5);
		System.out.println(apply2.length);
	}
}
