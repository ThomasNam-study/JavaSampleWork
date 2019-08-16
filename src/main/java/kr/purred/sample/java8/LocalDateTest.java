package kr.purred.sample.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by RED on 2017-05-02.
 */
public class LocalDateTest
{
	public static void main(String [] args)
	{
		// LocalDate date = LocalDate.of (2016, 5, 6);
		LocalDate date = LocalDate.now ();

		System.out.println ("year : " + date.getYear ());
		System.out.println ("month : " + date.getMonth ());
		System.out.println ("day : " + date.getDayOfMonth ());

		DayOfWeek dayOfWeek = date.getDayOfWeek ();

		System.out.println ("dayOfWeek : " + dayOfWeek);

		System.out.println ("lengthOfMonth : " + date.lengthOfMonth ());

		LocalTime time = LocalTime.now ();

		System.out.println ("hour : " + time.getHour ());
		System.out.println ("min : " + time.getMinute ());
		System.out.println ("sec : " + time.getSecond ());

		// 날짜 조정
		LocalDate date1 = date.withYear (2011);

		System.out.println ("DATE1 : " + date1);

		LocalDate date2 = date1.plusWeeks (1);

		System.out.println ("DATE2 : " + date2);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("yyyy-MM-dd");

		System.out.println ("DATE3 : " + date2.format (formatter));
	}
}
