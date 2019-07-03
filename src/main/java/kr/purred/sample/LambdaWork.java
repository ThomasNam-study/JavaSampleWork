package kr.purred.sample;

import java.util.function.Function;

public class LambdaWork
{
	static class Ex2 implements AfterProc
	{
		@Override
		public boolean execute (String val2)
		{
			System.out.println ("이후 실행했음");

			return false;
		}
	}

	public static void main (String [] args)
	{
		Ex2 ex2 = new Ex2 ();

		testWork ("안녕", ex2);

		testWork ("안녕2", new AfterProc () {
			@Override
			public boolean execute (String val2)
			{
				System.out.println ("익명 클래스 이용");

				return true;
			}
		});

		testWork ("안녕3", (val2) -> {
			System.out.println ("람다를 이용");
			return true;
		});

		testWorkVersion2 ("안녕4", new AfterProc2 () {
			@Override
			public void execute2 ()
			{

			}

			@Override
			public void execute3 ()
			{

			}
		});
	}

	static void testWorkVersion2 (String data, AfterProc2 afterProc)
	{
		System.out.println ("Data : " + data);

		if (afterProc != null)
		{
			afterProc.execute2 ();
		}
	}

	static void testWork3 (String data, Function<String, Boolean> afterProc)
	{
		System.out.println ("Data : " + data);

		if (afterProc != null)
		{
			System.out.println ("Return : " + afterProc.apply (data));
		}
	}

	static void testWork (String data, AfterProc afterProc)
	{
		System.out.println ("Data : " + data);

		if (afterProc != null)
		{
			System.out.println ("Return : " + afterProc.execute (data));
		}
	}
}
