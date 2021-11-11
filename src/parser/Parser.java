package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.hamcrest.core.StringEndsWith;

import exceptions.EmptyQueueException;
import utilities.*;

public class Parser {
	
	String xmlPath;
	MyStack mystack = new MyStack();
	MyQueue errorQ = new MyQueue();
	MyQueue extrasQ = new MyQueue();
	int count = 0;
	
	public Parser() {
		super();
	}

	public Parser(String xmlPath) throws FileNotFoundException, EmptyQueueException 
	{
		String line;
		String tag;
		Scanner in = new Scanner(new File(xmlPath));
		
		while (in.hasNextLine())
		{
			line = in.nextLine().trim();

			
			if (line.startsWith("<?") && line.endsWith("?>"))
			{
				// ignore in this assignment
			}
			else if (line.startsWith("<") && line.endsWith("/>"))
			{
				// self-closing tag, no closing tags
				// ignore
			}
			else if (line.startsWith("</") && line.endsWith(">"))
			{
				// closing tag, whose tag name matches to opening tag
				tag = line.split("</")[1].split(">")[0];

				if (mystack.isEmpty())
				{
					errorQ.enqueue(line);
				} 			
				else if (getTagName(line).equals(getTagName((String) mystack.peek())))
				{
					mystack.pop();
				}
				else if (! errorQ.isEmpty() && (getTagName(line).equals(getTagName((String) errorQ.peek()))))
				{
					errorQ.dequeue();
				}
				else {
					if (mystack.search(getTagName(line)) != -1)
					{
						while (! getTagName((String) mystack.peek()).equals(getTagName(line)))
						{
							count++;
							System.out.println("Error: " + errorQ.enqueue(mystack.pop()));
						}
					}
					else
					{
						extrasQ.enqueue(line);
					}
				}
			}
			else if (line.startsWith("<") && line.endsWith(">"))
			{
				// opening tag, which needs a closing tag
				mystack.push(line);
			}
		}
		
		while (! mystack.isEmpty())
		{
			errorQ.enqueue(mystack.pop());
		}
		
		if (errorQ.isEmpty() && !extrasQ.isEmpty())
		{
			while(! extrasQ.isEmpty())
			{
				count++;
				System.out.println("Error: " + extrasQ.dequeue());
			}
		}		
		if (! errorQ.isEmpty() && extrasQ.isEmpty())
		{
			while(! errorQ.isEmpty())
			{
				count++;
				System.out.println("Error: " + errorQ.dequeue());
			}
		}
		
		while (! extrasQ.isEmpty() && ! errorQ.isEmpty())
		{
			if (! extrasQ.isEmpty() && ! extrasQ.isEmpty())
			{
				if (! extrasQ.peek().equals(errorQ.peek()))
				{
					count++;
					System.out.println("Error: " + errorQ.dequeue());
				}
				else
				{
					extrasQ.dequeue();
					errorQ.dequeue();
				}
			}
		}
		if (count == 0)
		{
			System.out.println("All good. Well constructed.");
		}
	}
	
	private String getTagName(String line) {
		line = line.trim();
		if (line.startsWith("</") && line.endsWith(">"))
		{
			return line.split("</")[1].split(">")[0];
		}
		else if (line.startsWith("<") && line.endsWith(">"))
		{
			if (line.contains(" "))
			{
				return line.split("<")[1].split(" ")[0];
			}
			else
			{
				return line.split("<")[1].split(">")[0];
			}
		}
		return null;
	}
	

}
