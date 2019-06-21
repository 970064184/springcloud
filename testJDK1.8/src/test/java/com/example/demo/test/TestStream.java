package com.example.demo.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.example.demo.domain.Employee;

/**
 * 测试stream API
 * 
 * @author zb
 * @date 2018年8月22日 下午3:58:47
 */
public class TestStream {
	List<Employee> employees = Arrays.asList(new Employee("张三", 45, 8888), new Employee("李四", 5, 777),
			new Employee("王五", 25, 6666), new Employee("赵六", 25, 8888), new Employee("田七", 65, 9999),
			new Employee("赵8", 25, 8888));

	/**
	 * 分区
	 */
	@Test
	public void test7() {
		Map<Boolean, List<Employee>> collect = employees.stream()
				.collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));
		System.out.println(collect);
		// {false=[Employee(name=李四, age=5, salary=777.0), Employee(name=王五, age=25,
		// salary=6666.0)], true=[Employee(name=张三, age=45, salary=8888.0),
		// Employee(name=赵六, age=25, salary=8888.0), Employee(name=田七, age=65,
		// salary=9999.0), Employee(name=赵8, age=25, salary=8888.0)]}
	}

	/**
	 * 多级分组
	 */
	@Test
	public void test6() {
		Map<Double, Map<Integer, List<Employee>>> collect = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalary, Collectors.groupingBy(Employee::getAge)));
		System.out.println(collect);
	}

	@Test
	public void test5() {
		Map<Integer, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getAge));
		System.out.println(collect);
	}

	@Test
	public void test1() {
		employees.stream().filter((x) -> x.getAge() > 35)// 中间操作
				.forEach(System.out::println);// 终止操作
	}

	@Test
	public void test2() {
		List<String> list = Arrays.asList("ddd", "aaa", "sss", "vvv", "ddddd", "www");
		list.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);
		// 打印结果：
		// DDD
		// AAA
		// SSS
		// VVV
		// DDDDD
		// WWW

		System.out.println("-------------------------");
		employees.stream().map((e) -> e.getAge()).forEach(System.out::println);
		// -------------------------
		// 45
		// 5
		// 25
		// 25
		// 65
	}

	@Test
	public void test3() {
		List<String> list = Arrays.asList("ddd", "aaa", "sss", "vvv", "ddddd", "www");
		list.stream().sorted().forEach(System.out::println);
		// aaa
		// ddd
		// ddddd
		// sss
		// vvv
		// www
		System.out.println("----------------------");
		employees.stream().sorted((x, y) -> {
			if (x.getAge() == y.getAge()) {
				return x.getName().compareTo(y.getName());
			} else {
				return Integer.compare(x.getAge(), y.getAge());
			}
		}).forEach(System.out::println);
		// ----------------------
		// Employee(name=李四, age=5, salary=777.0)
		// Employee(name=王五, age=25, salary=6666.0)
		// Employee(name=赵六, age=25, salary=8888.0)
		// Employee(name=张三, age=45, salary=8888.0)
		// Employee(name=田七, age=65, salary=9999.0)
	}

	@Test
	public void test4() {
		List<Employee> collect = employees.stream().collect(Collectors.toList());
		System.out.println(collect);
		List<String> collect2 = employees.stream().map((e) -> e.getName()).collect(Collectors.toList());
		System.out.println(collect2);
		List<String> collect3 = employees.stream().map(Employee::getName).collect(Collectors.toList());
		System.out.println(collect3);
		// [Employee(name=张三, age=45, salary=8888.0), Employee(name=李四, age=5,
		// salary=777.0), Employee(name=王五, age=25, salary=6666.0), Employee(name=赵六,
		// age=25, salary=8888.0), Employee(name=田七, age=65, salary=9999.0)]
		// [张三, 李四, 王五, 赵六, 田七]
		// [张三, 李四, 王五, 赵六, 田七]

	}
}
