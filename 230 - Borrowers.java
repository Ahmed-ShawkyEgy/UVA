import java.util.*;
import java.io.*;


public class Main{
	public static void main(String[] args) throws IOException
  {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		String s;
		PrintWriter out = new PrintWriter(System.out);
		ArrayList<Book> list = new ArrayList<Book>();
		while(!(s = br.readLine() ).equals("END") )
		{
			int last = s.lastIndexOf('"');
			String title = s.substring(0,last+1);
			String author = s.substring( last+1 );
			list.add(new Book(title,author));
		}
		Collections.sort(list);		
		boolean [] returned = new boolean[list.size()];
		boolean [] taken = new boolean[list.size()];
		while(!(s = br.readLine() ).equals("END") )
		{
			if(s.charAt(0)=='R')
			{
				String titl = s.substring(s.indexOf('"'));
				for (int i = 0; i < list.size(); i++) {
					if(list.get(i).title.equals(titl))
					{
						returned[i] = true;
						taken[i] = true;
						break;
					}
				}
			}
			else
			{
				if(s.charAt(0)=='S')
				{
					String after = "";
					for (int i = 0; i < list.size(); i++) {
						if(taken[i] && returned[i])
						{
							if(after.equals(""))
							out.append("Put "+list.get(i).title+" first\n");
							else
								out.append("Put "+list.get(i).title+" after "+after+"\n");
							taken[i] = false;
						}
						if(!taken[i])
						{
							after = list.get(i).title;
						}
					}
					out.append("END\n");
					
				}
				else
				{
					String titl = s.substring(s.indexOf('"'));
					for (int i = 0; i < list.size(); i++) {
						if(list.get(i).title.equals(titl))
						{
							taken[i] = true;
							returned[i] = false;
							break;
						}
					}
				}
			}
		}
		out.flush();
		br.close();
  } 
	
	static class Book implements Comparable<Book>
	{
		String title,author;
		public Book(String t,String a)
		{
			title = t;
			author = a;
		}
		@Override
		public int compareTo(Book o) {
			int x = this.author.compareTo(o.author);
			if(x!=0)
				return x;
			return this.title.compareTo(o.title);
		}
		public String toString()
		{
			return "Title: "+title+" Author: "+author+"\n";
		}
	}
}
