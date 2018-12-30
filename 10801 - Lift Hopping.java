import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	static int n , k , t[] , oo = (int)1e9;
	static TreeSet<Integer>[] floor;
	static 	ArrayList<Integer>[] liftsInFloor;
	
	static int dijkstra()
	{
		int[][] dist = new int[100][n];
		for (int i = 0; i < dist.length; i++) 
			Arrays.fill(dist[i], oo);
		PriorityQueue<Edge> q = new PriorityQueue<>();
		for (int i = 0; i < n; i++) 
			if(liftsInFloor[0].contains(i))
			{
				dist[0][i] = 0;
				q.add(new Edge(0,i,0));
			}
		
		while(!q.isEmpty())
		{
			Edge cur = q.poll();
			int curFloor = cur.floor , curLift = cur.lift , cost = cur.c; 
			if(curFloor==k)
				return dist[curFloor][curLift];
			if(cost>dist[curFloor][curLift])
				continue;
			Integer nxtFloor = floor[curLift].higher(curFloor);
			Integer prvFloor = floor[curLift].lower(curFloor);
			if(nxtFloor!=null)
			{
				int newCost = cost + (nxtFloor-curFloor) * t[curLift];
				if(newCost<dist[nxtFloor][curLift])
					q.add(new Edge(nxtFloor, curLift, dist[nxtFloor][curLift]=newCost));
			}
			if(prvFloor != null)
			{
				int newCost = cost + (curFloor-prvFloor) * t[curLift];
				if(newCost<dist[prvFloor][curLift])
					q.add(new Edge(prvFloor, curLift, dist[prvFloor][curLift]=newCost));
			}
			
			for(int otherLift : liftsInFloor[curFloor])
				if(otherLift!=curLift && cost+60<dist[curFloor][otherLift])
					q.add(new Edge(curFloor, otherLift, dist[curFloor][otherLift] = cost+60));
		}
		return -1;
	}
	
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			n = sc.nextInt(); k = sc.nextInt();
			t = sc.nexIntArray();
			floor = new TreeSet[5];
			liftsInFloor = new ArrayList[100];
			for (int i = 0; i < floor.length; i++) 
				floor[i] = new TreeSet<>();
			for (int i = 0; i < liftsInFloor.length; i++) 
				liftsInFloor[i] = new ArrayList<>();
			for(int i = 0; i < n;i++)
			{
				int[] line = sc.nexIntArray();
				for (int j : line) 
				{
					floor[i].add(j);
					liftsInFloor[j].add(i);
				}
			}
			int ans = dijkstra();
			sb.append(ans!=-1?ans:"IMPOSSIBLE");
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static class Edge implements Comparable<Edge>
	{
		int floor,lift,c;
		
		public Edge(int floor,int lift,int c){this.floor = floor;this.lift = lift;this.c=c;}
		
		public int compareTo(Edge o) {return c-o.c;}
	}
	
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public Scanner(String file) throws FileNotFoundException { br = new BufferedReader(new FileReader(file));}
		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens())st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		public long nextLong() throws IOException {return Long.parseLong(next());}
		public String nextLine() throws IOException {return br.readLine();}
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-'){neg = true;start++;}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else{sb.append(x.charAt(i));if(dec)f *= 10;}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		public int[] nexIntArray() throws Throwable
		{
			st = new StringTokenizer(br.readLine());
			int[] a = new int[st.countTokens()];
			for(int i = 0; i < a.length;i++)a[i]=nextInt();
			return a;
		}
		public boolean ready() throws IOException {return br.ready();}
	}
}
