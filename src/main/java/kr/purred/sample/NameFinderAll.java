package kr.purred.sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NameFinderAll implements IFindName, IRegistFileName
{
	private List<IFindName> nameFinders;

	public NameFinderAll () throws IOException
	{
		nameFinders = new ArrayList<> ();
	}

	public boolean findName (String name)
	{
		for (IFindName findName : nameFinders)
		{
			boolean result = findName.findName (name);

			if (result)
				return true;
		}

		return false;
	}

	@Override
	public void addNameFinder (IFindName finder)
	{
		nameFinders.add (finder);
	}
}
