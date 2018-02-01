import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
		
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt() , budget = sc.nextInt();
			HashMap<String, ArrayList<Pair>> map = new HashMap<String, ArrayList<Pair>>();
			for (int i = 0; i < n; i++) 
			{
				String s = sc.next();
				if(!map.containsKey(s))
					map.put(s, new ArrayList<Pair>());
				sc.next();
				int p = sc.nextInt() , q = sc.nextInt();
				map.get(s).add(new Pair(p, q));
			}
			Pair[][] arr = new Pair[map.size()][];
			int idx = 0 ;
			
			for(Entry<String, ArrayList<Pair>> e : map.entrySet())
			{
				ArrayList<Pair> tmp= e.getValue();
				Collections.sort(tmp);
				Pair[] a = new Pair[tmp.size()];
				for(int i = 0;i<a.length;++i)
					a[i] = tmp.get(i);
				
				arr[idx++] = a;
				budget-= a[0].p;
			}
			int[] pointer = new int[idx];
			int curQ=0;
			while(true)
			{
				curQ = 1000000001;
				for (int i = 0; i < idx; i++) 
					curQ = Math.min(curQ, arr[i][pointer[i]].q);
				
				boolean update = false;
				for (int i = 0; i < idx; i++) 
					if(arr[i][pointer[i]].q==curQ)
						for(int j = pointer[i]+1;j<arr[i].length;++j)
							if(arr[i][j].q>curQ && budget+arr[i][pointer[i]].p-arr[i][j].p >=0)
							{
								update= true;
								budget=budget+arr[i][pointer[i]].p-arr[i][j].p;
								pointer[i] = j;
								break;
							}
				
				if(!update)break;
			}
			
			System.out.println(curQ);
		}
	}
	
	static class Pair implements Comparable<Pair>
	{
		int p,q;
		public Pair(int a,int b) {p = a;q=b;}
		
		public int compareTo(Pair o) {return p-o.p;}
		
	}
	
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public Scanner(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(s));
		}
		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		public String nextLine() throws IOException {return br.readLine();}		
		public long nextLong() throws IOException {return Long.parseLong(next());}		
		public double nextDouble() throws IOException {return Double.parseDouble(next());}	
		public char nextChar() throws IOException{return next().charAt(0);}
		public boolean ready() throws IOException {return br.ready();}
		public int[] nextIntArr() throws IOException{
			st = new StringTokenizer(br.readLine());
			int[] res = new int[st.countTokens()];
			for (int i = 0; i < res.length; i++)
				res[i] = nextInt();
			return res;
		}
		public char[] nextCharArr() throws IOException{
			st = new StringTokenizer(br.readLine());
			char[] res = new char[st.countTokens()];
			for (int i = 0; i < res.length; i++) 
				res[i] = nextChar();
			return res;
		}
	}

}
