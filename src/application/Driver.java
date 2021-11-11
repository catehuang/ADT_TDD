package application;

import java.io.File;
import java.io.FileNotFoundException;

import exceptions.EmptyQueueException;
import parser.Parser;
import utilities.*;

public class Driver {

	public static <E> void main(String[] args) throws FileNotFoundException, EmptyQueueException {
		
		if (args.length != 1)
		{
			System.out.println("Usage: When put (sample1.)xml file into res folder, the command will be:");
			System.out.println("java -jar Parser.jar sample1.xml");
		}
		else
		{
			String xmlPath = "res/" + args[0];
			File file = new File(xmlPath);
			
			if (! file.exists())
			{
				System.out.println("File not found.");
			}
			else
			{
				System.out.println("Parse for errors in the XML construction...");
				System.out.println();
				Parser parser = new Parser(xmlPath);
			}
		}
		
	}
}
