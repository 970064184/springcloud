package com.example.cloud.test;

/**
 * 任意只包含一个抽象方法的接口
 * 
 * @author zb
 * @date 2018年6月8日 下午5:51:32
 * @param <F>
 * @param <T>
 */
@FunctionalInterface
public interface Converter<F, T> {

	T convert(F from);
}
