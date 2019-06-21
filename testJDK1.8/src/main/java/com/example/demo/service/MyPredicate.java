package com.example.demo.service;

@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);

	// public boolean test2(T t);

}
