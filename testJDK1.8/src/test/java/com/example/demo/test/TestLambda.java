package com.example.demo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

import com.example.demo.domain.Employee;
import com.example.demo.service.MyFun;

/**
 * 测试lambda表达式的语法
 * 
 * @author zb
 * @date 2018年8月21日 下午5:39:11
 */
public class TestLambda {

	List<Employee> list = Arrays.asList(new Employee("张三", 45, 8888), new Employee("李四", 5, 777),
			new Employee("王五", 25, 6666), new Employee("赵六", 25, 8888), new Employee("田七", 65, 9999));

	@Test
	public void test1() {
		Runnable r = () -> System.out.println("hello 已启动");
		r.run();
	}

	@Test
	public void test2() {
		Consumer<String> con = x -> System.out.println(x);
		con.accept("hello world !");
	}

	@Test
	public void test3() {
		Comparator<Integer> c = (x, y) -> {
			System.out.println("函数接口");
			return Integer.compare(x, y);
		};
		int compare = c.compare(5, 3);
		System.out.println(compare);
	}

	@Test
	public void test4() {
		Comparator<Integer> c = (x, y) -> Integer.compare(x, y);
		int compare = c.compare(5, 3);
		System.out.println(compare);
	}

	@Test
	public void test5() {
		Integer operation = operation(400, (x) -> x + 3);
		System.out.println(operation);
	}

	public Integer operation(Integer num, MyFun mf) {
		return mf.getValue(num);
	}

	/**
	 * 排序
	 */
	@Test
	public void test6() {
		List<Integer> asList = Arrays.asList(5, 7, 4);
		Collections.sort(asList, (x, y) -> Integer.compare(x, y));
		System.out.println(asList);
	}

	/**
	 * 需求：调用Collections.sort()方法，通过定制排序比较两个Employee（先按年龄比，年龄相同按姓名比），使用Lambda作为参数传递
	 */
	@Test
	public void test7() {
		Collections.sort(list, (x, y) -> {
			if (x.getAge() == y.getAge()) {
				return x.getName().compareTo(y.getName());
			} else {
				return -Integer.compare(x.getAge(), y.getAge());
			}
		});
		System.out.println(list);
	}

	@Test
	public void test8() {
		happy(888L, (m) -> System.out.println("消费了：" + m + "元"));
	}

	public void happy(double money, Consumer<Double> con) {
		con.accept(money);
	}

	@Test
	public void test9() {
		List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
		System.out.println(numList);
	}

	/**
	 * 产生指定个数的整数，并放入集合中
	 * 
	 * @param num
	 * @param sup
	 * @return
	 */
	public List<Integer> getNumList(int num, Supplier<Integer> sup) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			Integer a = sup.get();
			list.add(a);
		}
		return list;
	}

	@Test
	public void test10() {
		String strHandle = strHandle("xiaozhang", (x) -> "hello " + x);
		System.out.println(strHandle);

		String strHandle2 = strHandle("\t\t\t\t  我的测试    sdsdd ", (x) -> {
			System.out.println(x);
			return x.trim();
		});
		System.out.println(strHandle2);
	}

	/**
	 * 函数型接口 需求：用于处理字符串
	 */
	public String strHandle(String str, Function<String, String> fun) {
		return fun.apply(str);
	}

	@Test
	public void test11() {
		boolean judge = judge(10, (n) -> n > 5);
		System.out.println(judge);
	}

	public boolean judge(Integer num, Predicate<Integer> pre) {
		return pre.test(num);
	}

	@Test
	public void test12() {
		List<String> list = Arrays.asList("sdsd", "dsdsd00", "we", "dsdfs");
		List<String> filterStr = filterStr(list, (s) -> s.length() > 4);
		System.out.println(filterStr);
	}

	/**
	 * 需求：将满足条件的字符串，放入集合中
	 */
	public List<String> filterStr(List<String> list, Predicate<String> pre) {
		List<String> strList = new ArrayList<>();
		for (String str : list) {
			if (pre.test(str)) {
				strList.add(str);
			}
		}
		return strList;
	}
}
