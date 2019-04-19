package kr.purred.sample;

import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameFinderHttp implements IFindName
{
	private List<String> names;

	public NameFinderHttp () throws IOException
	{
		String content = Request.Get ("http://purred.kr/name3.txt").execute ().returnContent ().asString (Charset.forName ("UTF-8"));

		names = Arrays.stream (content.split ("\n")).map (String::trim).filter ((s) -> !s.isEmpty ()).collect (Collectors.toList ());
	}

	public boolean findName (String name)
	{
		return name.contains (name);
	}
}
