package kr.purred.sample.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class FileCopyTest
{
	public static void main (String [] args) throws IOException
	{
		//final String fileName = "C:\\Users\\RED\\Downloads\\ciderMember.xls";
		//final String fileName = "C:\\Users\\RED\\Downloads\\20190524_101046[1].jpg";
		// final String fileName = "C:\\Users\\RED\\Downloads\\tPayLite_sample_JSP.zip";
		final String fileName = "C:\\Users\\RED\\Downloads\\BananaPOS_3.3.0.11_D_Patch.EXE";

		File file = new File (fileName);

		System.out.println ("파일명 : " + file.getName ());
		System.out.println ("파일사이즈 : " + file.length () / 1024+ "KB");


		executeTest ("버퍼    10", () -> test1  (fileName, 10));
		executeTest ("버퍼  1024", () -> test1  (fileName, 1024));
		executeTest ("버퍼  2048", () -> test1  (fileName, 2048));
		executeTest ("버퍼  4096", () -> test1  (fileName, 4096));
		executeTest ("버퍼 10240", () -> test1  (fileName, 10240));

	}

	static void executeTest (String title, Runnable run)
	{
		Date startDate = new Date ();

		if (run != null)
			run.run ();

		Date endDate = new Date ();

		System.out.println (title + " - 걸린시간 : " + (endDate.getTime () - startDate.getTime ()) + "ms");

		try
		{
			Thread.sleep (100);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace ();
		}
	}

	static void test1 (String fileName, int bufSize)
	{
		try
		{
			File file = new File (fileName);

			if (file.isFile ())
			{
				FileInputStream f = new FileInputStream (file);
				FileOutputStream out = new FileOutputStream ("C:\\Users\\RED\\Downloads\\output");

				int length;
				byte[] buffer = new byte[bufSize];
				while ((length = f.read (buffer)) != -1)
					out.write (buffer, 0, length);

				f.close ();
				out.close ();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace ();
		}
	}
}
