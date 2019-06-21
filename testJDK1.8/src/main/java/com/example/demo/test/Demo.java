package com.example.demo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.domain.Employee;
import com.example.demo.service.FilterEmployeeByAge;
import com.example.demo.service.FilterEmployeeBySalary;
import com.example.demo.service.MyPredicate;

/**
 * 需求1：获取当前公司中员工工资大于5000 需求 2：获取当前公司中员工年龄大于35
 * 
 * @author zb
 * @date 2018年8月21日 下午4:57:45
 */
public class Demo {

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee("张三", 45, 8888), new Employee("李四", 5, 777),
				new Employee("王五", 25, 6666), new Employee("赵六", 55, 8888), new Employee("田七", 65, 9999));
		// 需求1
		filterEmployees1(list);
		// 需求2
		filterEmployees2(list);

		// 代码重复冗余
		// 所以优化方式如下：
		// 优化方式1：策略设计模式
		filterEmployees3(list, new FilterEmployeeByAge());
		filterEmployees3(list, new FilterEmployeeBySalary());
		// 优化方式2：匿名内部类
		List<Employee> emps = filterEmployees3(list, t -> t.getSalary() > 5000);
		System.out.println(emps);
		// 优化方式3：lambda表达式
		List<Employee> emps1 = filterEmployees3(list, t -> t.getSalary() > 5000);
		emps1.forEach(System.out::println);
		// 优化方式4：stream API
		list.stream().filter(t -> t.getSalary() > 5000).forEach(System.out::println);
	}

	private static void filterEmployees1(List<Employee> list) {
		List<Employee> emps = new ArrayList<>();
		list.forEach(l -> {
			if (l.getSalary() > 5000) {
				emps.add(l);
			}
		});
		System.out.println(emps);
	}

	private static void filterEmployees2(List<Employee> list) {
		List<Employee> emps = new ArrayList<>();
		list.forEach(l -> {
			if (l.getAge() > 35) {
				emps.add(l);
			}
		});
		System.out.println(emps);
	}

	private static List<Employee> filterEmployees3(List<Employee> list, MyPredicate<Employee> mp) {
		List<Employee> emps = new ArrayList<>();
		for (Employee employee : list) {
			if (mp.test(employee)) {
				emps.add(employee);
			}
		}
		System.out.println(emps);
		return emps;
	}

}
