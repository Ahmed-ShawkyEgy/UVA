import java.util.*;
import java.io.*;


public class Main {
	static ArrayList<ArrayList<Child>> adjList;
	static String[] pathos = {"non-existent","recessive","dominant"};
	static Hashtable<String, Integer> map ;
	
	public static void SetGenes(String child)
	{
		if(adjList.get( map.get(child) ).get(0).disease == -1 )
		{
			int sum =0;
			for(int i =1 ; i < adjList.get( map.get(child) ).size() ; i++ )
			{
				SetGenes(adjList.get( map.get(child) ).get(i).name);
				sum+= adjList.get( map.get(child) ).get(i).disease;
			}
			switch(sum)
			{
			case 1: sum =0;break;
			case 2: sum =1;break;
			case 3: sum=2;break;
			case 4: sum=2;break;
			default :;
			}
			adjList.get(map.get(child)).get(0).disease = sum ;
		}
	}
	public static void main(String[] args) throws IOException
    {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		String s;
		PrintWriter out = new PrintWriter(System.out);
		map = new Hashtable<String, Integer>();
		int index = 0;
		int n = Integer.parseInt(br.readLine());
		adjList = new ArrayList<ArrayList<Child>>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			if(!map.containsKey(a))
			{
				map.put(a, index);
				adjList.add(new ArrayList<Child>());
				adjList.get(index++).add(new Child(a));		
				adjList.get(map.get(a)).get(0).disease= -1;
				adjList.get(map.get(a)).get(0).hasDis=false;
			}			
			boolean found = false;
			for(int j =0;j<3;j++)
			{
				if(b.equals(pathos[j]))
				{
					adjList.get(map.get(a)).get(0).disease=j;
					adjList.get(map.get(a)).get(0).hasDis = true;
					found = true;
					break;
				}
			}
			if(!found)
			{
				if(!map.containsKey(b))
				{
					map.put(b, index);
					adjList.add(new ArrayList<Child>());
					adjList.get(index++).add(new Child(b));					
				}
				adjList.get(map.get(b)).add(adjList.get(map.get(a)).get(0));
			}
		}
		for(int i =0;i<adjList.size();i++)
		{
			SetGenes(adjList.get(i).get(0).name);
		}
		ArrayList<Child> ans = new ArrayList<Child>();
		for(int i =0;i<adjList.size();i++)
		{
			Child x = adjList.get(i).get(0) ;
			ans.add(x);
		}
		Collections.sort(ans);
		for(int i =0;i<ans.size();i++)
		{
			int dis = ans.get(i).disease;
			out.append(ans.get(i).name+" "+pathos[dis]+"\n");
		}
		out.flush();
		br.close();
    } 
	
	static class Child implements Comparable<Child>
	{
		String name;
		int disease;
		boolean hasDis;
		public Child(String s)
		{
			name = s;
			disease = -1;
		}
		@Override
		public int compareTo(Child o) {
			return this.name.compareTo(o.name);
		}
		public String toString()
		{
			return name+" "+disease + " HasDis: "+hasDis;
		}
		
	}
}
