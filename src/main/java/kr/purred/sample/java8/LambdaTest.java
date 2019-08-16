package kr.purred.sample.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by purre on 2017-05-01.
 */
public class LambdaTest
{
	public static void main(String [] args)
	{
		List<Apple> apples = new ArrayList<> ();

		apples.add (new Apple (30, "새똥사과"));
		apples.add (new Apple (32, "새똥사과"));
		apples.add (new Apple (33, "개똥사과"));
		apples.add (new Apple (33, "새똥사과"));
		apples.add (new Apple (36, "새똥사과"));
		apples.add (new Apple (20, "새똥사과"));

		// 정렬시 Comparing 사용하기
		// 람다 조합식 - 역정렬 reversed
		// 조합 연결하여 2차 정렬
		List<Apple> newApples = apples.stream ().sorted (
			Comparator.comparing (Apple::getWeight)
			.reversed ()
			.thenComparing (Apple::getName)
		).collect (Collectors.toList ());

		System.out.println (newApples);

		Predicate<Apple> p = ((apple) -> apple.getWeight () >= 32);


		List<Apple> newApples2 = apples.stream ()
			.filter (p.or (apple -> apple.getWeight () <= 20))
			.collect (Collectors.toList ())
			;

		System.out.println (newApples2);
	}
}
