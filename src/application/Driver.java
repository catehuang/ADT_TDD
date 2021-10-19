package application;

import utilities.MyArrayList;

public class Driver {

	public static <E> void main(String[] args) {
		MyArrayList list = new MyArrayList(15);
		
		list.add("a");
		list.add(0, "b");
		list.add("c");
		
		MyArrayList temp = new MyArrayList(15);
		temp.add("d");
		temp.add("e");
		temp.add("f");
		list.addAll(temp);
		list.add("a");
		list.remove("a");
		list.remove(0);
		list.set(list.size()- 1, "g");
		list.set(0, "h");
		System.out.println(list.contains("k"));
		System.out.println(list.contains("h"));
		
		/*
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		*/
		
		
		//list.clear();
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		
		E[] tmp = (E[]) new Object[] {"a", "b", "c"};
		Object[] obj = list.toArray(tmp);
		
		list.add("d");
		list.add("e");
		list.add("f");
		
		obj = list.toArray();
		
		for(Object o : obj)
		{
			System.out.println(o);
		}
		
		
	}
}
