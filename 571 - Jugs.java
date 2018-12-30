import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int ca,cb,t;
	
	
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		Queue<Pair> q;
		int[][] vis , aPrev , bPrev;
		String[] cmd = {"fill A","fill B","empty A","empty B","pour A B","pour B A","success"};
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			ca = sc.nextInt() ; cb = sc.nextInt() ; t = sc.nextInt();
			q = new LinkedList<>();
			int size = Math.max(ca, cb)+1;
			vis = new int[size][size];
			aPrev = new int[size][size];
			bPrev = new int[size][size];
			for (int i = 0; i < vis.length; i++) {
				Arrays.fill(vis[i], -1);
			}
			vis[0][0] = 6;
			q.add(new Pair(0, 0));
			int ta = -1 , tb = -1;
			while(!q.isEmpty())
			{
				Pair cur = q.poll();
				int a = cur.a , b = cur.b;
				if(b==t)
				{
					ta = a;tb = b;
					break;
				}
				if(vis[ca][b]==-1) // Fill a
				{
					vis[ca][b] = 0;
					aPrev[ca][b] = a;
					bPrev[ca][b] = b;
					q.add(new Pair(ca, b));
				}
				if(vis[a][cb]==-1) // Fill b
				{
					vis[a][cb] = 1;
					aPrev[a][cb] = a;
					bPrev[a][cb] = b;
					q.add(new Pair(a, cb));
				}
				if(vis[0][b]==-1) // Empty a
				{
					vis[0][b] = 2;
					aPrev[0][b] = a;
					bPrev[0][b] = b;
					q.add(new Pair(0, b));
				}
				if(vis[a][0]==-1) // Empty b
				{
					vis[a][0] = 3;
					aPrev[a][0] = a;
					bPrev[a][0] = b;
					q.add(new Pair(a, 0));
				}
				int space = cb-b;
				int newA = a - Math.min(space, a);
				int newB = b+(a-newA);
				if(vis[newA][newB]==-1) // Pour A into B
				{
					vis[newA][newB] = 4;
					aPrev[newA][newB] = a;
					bPrev[newA][newB] = b;
					q.add(new Pair(newA,newB));
				}
				space = ca-a;
				newB = b - Math.min(space, b);
				newA = a+(b-newB);
				if(vis[newA][newB]==-1) // Pour B into A
				{
					vis[newA][newB] = 5;
					aPrev[newA][newB] = a;
					bPrev[newA][newB] = b;
					q.add(new Pair(newA,newB));
				}
			}
			
			Stack<String> stak = new Stack<>();
			
			while(ta>0 || tb>0)
			{
				stak.push(cmd[vis[ta][tb]]);
				int tmp = ta;
				ta = aPrev[ta][tb];
				tb = bPrev[tmp][tb];
			}
			
			while(!stak.isEmpty())
				sb.append(stak.pop()+"\n");		
			sb.append("success\n");
		}
		System.out.print(sb);
	}
	
	static class Pair
	{
		int a,b;
		public Pair(int x,int y)
		{
			a = x;b=y;
		}
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
