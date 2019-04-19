package kr.purred.sample;

import java.io.IOException;

public class MainWork
{
	public static void main(String [] args) throws IOException
	{
		System.out.println ("Hello World!!");

		NameFinderAll nameFinderAll = new NameFinderAll ();

		IRegistFileName registFileName = nameFinderAll;

		boolean dev = false;

		if (dev)
			registFileName.addNameFinder (new NameFinderForFile ("name1.txt"));

		registFileName.addNameFinder (new NameFinderForFile ("name2.txt"));
		registFileName.addNameFinder (new NameFinderHttp ());

		IFindName all = nameFinderAll;

		String line = "채빈";

		if (all.findName (line))
			System.out.println ("있음");
		else
			System.out.println ("없음");
	}
}
