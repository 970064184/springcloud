package com.example.demo.test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

import org.junit.Test;

public class TestLocalDateTime {

	// LocalDate LocalTime LocalDateTime

	@Test
	public void test() {
		LocalDateTime ldt = LocalDateTime.now();// 2018-08-28T15:50:40.134
		System.out.println(ldt);

		LocalDateTime of = LocalDateTime.of(2018, 8, 23, 13, 15);// 2018-08-23T13:15
		System.out.println(of);

		LocalDateTime plusYears = ldt.plusYears(2);// +2年
		System.out.println(plusYears);// 2020-08-28T15:50:40.134

		LocalDateTime minusYears = ldt.minusYears(2);// -2年
		System.out.println(minusYears);// 2016-08-28T15:52:14.815

		Month month = ldt.getMonth();
		System.out.println(month);// AUGUST
		int monthValue = ldt.getMonthValue();// 8
		System.out.println(monthValue);
	}

	/**
	 * Instand：时间戳（以Unix 元年：1970年1月1日 00:00:00之间的毫秒值）
	 */
	@Test
	public void test1() {
		Instant ins = Instant.now();// 默认获取UTC时区（时间协调时间）（和实际时间相处8个钟）
		System.out.println(ins);// 2018-08-28T07:58:09.313Z
		OffsetDateTime atOffset = ins.atOffset(ZoneOffset.ofHours(8));
		System.out.println(atOffset);// 2018-08-28T16:01:14.762+08:00
		System.out.println(ins.toEpochMilli());// 转换成时间戳 1535443394357
	}

	/**
	 * Duration：计算两个时间之间的间隔 Period：计算两个日期之间的间隔
	 */
	@Test
	public void test2() {
		LocalDateTime ldt = LocalDateTime.now();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		LocalDateTime ldt2 = LocalDateTime.now();
		// LocalDateTime ldt2 = LocalDateTime.of(2018, 8, 26, 15, 56);
		Duration between = Duration.between(ldt, ldt2);
		System.out.println(between);// PT1S
		System.out.println(between.toMillis());// 1000
	}

	@Test
	public void test3() {
		LocalDate ld = LocalDate.now();// 2018-08-28
		LocalDate ld2 = ld.minusDays(1);// 2018-08-27
		System.out.println(ld2);
		Period between = Period.between(ld, ld2);
		System.out.println(between);
		System.out.println(between.getDays());
	}

	@Test
	public void test4() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);// 2018-08-28T17:12:00.164
		LocalDateTime ldt2 = ldt.withDayOfMonth(10);// 2018-08-10T17:12:00.164
		System.out.println(ldt2);

		LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println(ldt3);// 2018-09-02T17:13:30.630

		// 自定义：下一个工作日
		LocalDateTime ldt5 = ldt.with((l) -> {
			LocalDateTime ldt4 = (LocalDateTime) l;
			DayOfWeek dayOfWeek = ldt4.getDayOfWeek();
			if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
				return ldt4.plusDays(3);
			} else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
				return ldt4.plusDays(2);
			} else {
				return ldt4.plusDays(1);
			}
		});
		System.out.println(ldt5);// 2018-08-29T17:20:29.391
	}

	@Test
	public void test5() {
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime ldt = LocalDateTime.now();
		String format = ldt.format(dtf);
		System.out.println(format);// 2018-08-28T17:27:29.07

		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
		String format2 = dtf2.format(ldt);
		System.out.println(format2);// 2018年08月28日 17:31:19
		LocalDateTime parse = ldt.parse(format2, dtf2);
		System.out.println(parse);// 2018-08-28T17:36:34
	}

	@Test
	public void test6() {
		Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
		availableZoneIds.forEach(System.out::println);
	}

	@Test
	public void test7() {
		LocalDateTime now = LocalDateTime.now(ZoneId.of("Japan"));
		System.out.println(now);// 2018-08-28T18:49:47.049
	}
}
