package kr.purred.sample;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameFinderForFile implements IFindName
{
	private List<String> names;

	public NameFinderForFile (String fileName) throws IOException
	{
		File file = new File (fileName);

		String content = FileUtils.readFileToString (file, "UTF-8");

		names = Arrays.stream (content.split ("\n")).map (String::trim).filter ((s) -> !s.isEmpty ()).collect (Collectors.toList ());
	}

	public boolean findName (String name)
	{
		return names.contains (name);
	}
}
