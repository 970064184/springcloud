package com.example.project.test;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.Test;

/**
 * 算法测试(O（n^2）的排序算法)
 * 
 * @author zb
 * @date 2018年9月3日 下午6:10:21
 */
public class TestAlgorithm {

	/**
	 * ?
	 */
	int[] arr = { 12, 4, 5, 2, 6, 9, 11, 3 };
	int NUM = 100000;

	@Test
	public void test1() {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = 0;
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		printArr(arr);
	}

	/**
	 * 选择算法排序 ：先选出最小的，然后填在对应的位置上
	 */
	@Test
	public void test2() {
		selectSort(arr);
		printArr(arr);
	}

	private void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
	}

	/**
	 * 数组中的元素交换位置
	 * 
	 * @param arr
	 * @param i
	 * @param j
	 */
	private void swap(int[] arr, int i, int j) {
		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * 打印数组
	 */
	private void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
			// 2 3 4 5 6 9 11 12
		}
	}

	/**
	 * 选择排序算法，对应数据所需要的时间
	 */
	@Test
	public void test3() {
		int[] num = getNum(NUM);
		long startTime = System.currentTimeMillis();
		selectSort(num);// 9 13 22 37 42 42 52 57 66 70
		// 1 25 27 29 42 46 57 58 67 98
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);// 1000:5毫秒；10000：72毫秒 ；100000：2206
		// printArr(num);
	}

	/**
	 * 选择排序算法，对应数据所需要的时间
	 */
	@Test
	public void test4() {
		int[] num = getNum(NUM);
		LocalDateTime startTime = LocalDateTime.now();
		selectSort(num);
		LocalDateTime endTime = LocalDateTime.now();
		System.out.println(Duration.between(startTime, endTime).toMillis());// 1000:7毫秒；10000：70毫秒 ；100000：2289毫秒
	}

	/**
	 * 随机生成指定的整数
	 * 
	 * @param length
	 * @return
	 */
	private int[] getNum(int length) {
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 1000);
		}
		return arr;
	}

	/**
	 * 插入排序：第一个位置不动，前一个位置与第一个位置对比，找到适合位置，然后后面一个在和前面的对比，直到找到合适位置，然后终止循环（类似扑克牌理牌一样）
	 * 
	 * @param arr
	 */
	private void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1])
					swap(arr, j, j - 1);
				else
					break;
			}
		}
	}

	@Test
	public void test6() {
		printArr(arr);
		System.out.println();
		insertionSort2(arr);// 2 3 4 5 6 9 11 12
		printArr(arr);
	}

	@Test
	public void test5() {
		int[] num = getNum(NUM);
		LocalDateTime startTime = LocalDateTime.now();
		insertionSort(num);
		LocalDateTime endTime = LocalDateTime.now();
		System.out.println(Duration.between(startTime, endTime).toMillis());// 1000:4毫秒；10000：55毫秒 ；100000：4838 毫秒
	}

	@Test
	public void test7() {
		int[] num = getNum(NUM);
		LocalDateTime startTime = LocalDateTime.now();
		insertionSort2(num);
		LocalDateTime endTime = LocalDateTime.now();
		System.out.println(Duration.between(startTime, endTime).toMillis());// 1000:4毫秒；10000：31毫秒 ；100000：2349 毫秒
	}

	/**
	 * 优化插入排序算法
	 */
	private void insertionSort2(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j;
			for (j = i; j > 0; j--) {
				if (temp < arr[j - 1]) {
					arr[j] = arr[j - 1];
				} else
					break;
			}
			arr[j] = temp;
		}
	}

	/**
	 * 归并算法mergeSort:24 优化后插入算法insertionSort2:2820 选择算法selectSort:6741
	 * 插入算法insertionSort:5039
	 * 
	 */
	@Test
	public void test8() {
		int[] num = getNum(NUM);
		int[] num1 = new int[NUM];
		int[] num2 = new int[NUM];
		int[] num3 = new int[NUM];
		int[] num4 = new int[NUM];
		int[] num5 = new int[NUM];
		for (int i = 0; i < num.length; i++) {
			num1[i] = num[i];
			num2[i] = num[i];
			num3[i] = num[i];
			num4[i] = num[i];
			num5[i] = num[i];
		}
		LocalDateTime startTime5 = LocalDateTime.now();
		quickSort(num5, 0, num5.length - 1);
		LocalDateTime endTime5 = LocalDateTime.now();
		System.out.println("快速算法quickSort:" + Duration.between(startTime5, endTime5).toMillis());// 1000:1毫秒；10000：7毫秒
		// ；100000：18 毫秒
		LocalDateTime startTime3 = LocalDateTime.now();
		mergeSort(num3, 0, num3.length - 1);
		LocalDateTime endTime3 = LocalDateTime.now();
		System.out.println("自顶向下归并算法mergeSort:" + Duration.between(startTime3, endTime3).toMillis());// 1000:1毫秒；10000：8毫秒
		// ；100000：25 毫秒

		LocalDateTime startTime2 = LocalDateTime.now();
		insertionSort2(num2);
		LocalDateTime endTime2 = LocalDateTime.now();
		System.out.println("优化后插入算法insertionSort2:" + Duration.between(startTime2, endTime2).toMillis());// 1000:5毫秒；10000：26毫秒
		// ；100000：2727 毫秒

		LocalDateTime startTime1 = LocalDateTime.now();
		selectSort(num1);
		LocalDateTime endTime1 = LocalDateTime.now();
		System.out.println("选择算法selectSort:" + Duration.between(startTime1, endTime1).toMillis());// 1000:8毫秒；10000：75毫秒
		// ；100000：5953 毫秒

		LocalDateTime startTime = LocalDateTime.now();
		insertionSort(num);
		LocalDateTime endTime = LocalDateTime.now();
		System.out.println("插入算法insertionSort:" + Duration.between(startTime, endTime).toMillis());// 1000:5毫秒；10000：53毫秒
		// ；100000：4582 毫秒

		LocalDateTime startTime4 = LocalDateTime.now();
		mergeSortBu(num4);
		LocalDateTime endTime4 = LocalDateTime.now();
		System.out.println("自底向上归并算法mergeSortBu:" + Duration.between(startTime4, endTime4).toMillis());// 1000:0毫秒；10000：2毫秒
		// ；100000：23 毫秒

	}

	/**
	 * 归并算法 递归使用归并排序，对arr[l...r]的范围进行排序
	 * 
	 * @param arr
	 */
	public void mergeSort(int[] arr, int l, int r) {
		if (l >= r)
			return;
		int mid = (l + r) / 2;
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		if (arr[mid] > arr[mid + 1]) {// 判断是否是有序数据的排序
			merge(arr, l, mid, r);
		}
	}

	private void merge(int[] arr, int l, int mid, int r) {
		int[] aux = new int[r - l + 1];
		for (int i = l; i <= r; i++)
			aux[i - l] = arr[i];
		int i = l, j = mid + 1;
		for (int k = l; k <= r; k++) {
			if (i > mid) {
				arr[k] = aux[j - l];
				j++;
			} else if (j > r) {
				arr[k] = aux[i - l];
				i++;
			} else if (aux[i - l] < aux[j - l]) {
				arr[k] = aux[i - l];
				i++;
			} else {
				arr[k] = aux[j - l];
				j++;
			}
		}
	}

	@Test
	public void test9() {
		printArr(arr);
		System.out.println();
		mergeSort(arr, 0, arr.length - 1);// 2 3 4 5 6 9 11 12
		printArr(arr);
	}

	/**
	 * 自底向上归并排序
	 * 
	 * @param arr
	 */
	public void mergeSortBu(int[] arr) {
		int n = arr.length;
		for (int sz = 1; sz <= n; sz += sz) {
			for (int i = 0; i + sz < n; i += sz + sz) {
				merge(arr, i, i + sz - 1, (i + sz + sz - 1) < (n - 1) ? (i + sz + sz - 1) : (n - 1));
			}
		}
	}

	/**
	 * 测试自底向上归并算法
	 */
	@Test
	public void test10() {
		printArr(arr);
		System.out.println();
		mergeSortBu(arr);// 2 3 4 5 6 9 11 12
		printArr(arr);
	}

	/**
	 * 快速排序算法:利用递归，对arr[l...r]部分进行快速排序
	 * 
	 * @param arr
	 */
	public void quickSort(int[] arr, int l, int r) {
		if (l >= r)
			return;
		// int p = partition(arr, l, r);
		int p = partition2(arr, l, r);
		quickSort(arr, l, p - 1);
		quickSort(arr, p + 1, r);

	}

	/**
	 * 对arr[l,r]部分进行partition操作
	 * 
	 * @param arr
	 * @param l
	 * @param r
	 * @return 返回p ,使得arr[l...p-1]<arr[p];arr[p+1...r]>arr[p]
	 */
	private int partition(int[] arr, int l, int r) {
		int v = arr[l];
		// arr[l+1...j]<v;arr[j+1...i)>v
		int j = l;
		for (int i = l + 1; i <= r; i++) {
			if (arr[i] < v) {
				swap(arr, j + 1, i);
				j++;
			}
		}
		swap(arr, l, j);
		return j;
	}

	private int partition2(int[] arr, int l, int r) {
		int v = arr[l];
		// arr[l+1...i)<=v;arr(j...r]>=v
		int i = l + 1, j = r;
		while (true) {
			while (i <= r && arr[i] < v)
				i++;
			while (j >= l + 1 && arr[j] > v)
				j--;
			if (i > j)
				break;
			swap(arr, i, j);
			i++;
			j--;
		}
		swap(arr, l, j);
		return j;
	}

	@Test
	public void test11() {
		printArr(arr);
		System.out.println();
		quickSort(arr, 0, arr.length - 1);
		printArr(arr);
	}
}
