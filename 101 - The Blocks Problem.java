import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] posBlock,posStack , last , arr[];
	
	static void returnBlocks(int a)
	{
		int x = posBlock[a] , y = posStack[a];
		for(int i = y+1;i<last[x];i++)
		{
			int cur = arr[x][i];
			arr[cur][0] = cur;
			posBlock[cur] = cur;
			posStack[cur] = 0;
			last[cur] = 1;
		}
		last[x] = y+1;
	}
	
	static void mvOn(int a,int b)
	{
		returnBlocks(a);
		returnBlocks(b);
		
		int oldPos = posBlock[a] ;
		last[oldPos]--;
		int pos = posBlock[b] , height = posStack[b];
		arr[pos][++height] = a;
		posBlock[a] = pos;
		posStack[a] = height++;
		
		last[pos] = height;
	}
	
	static void mvOver(int a,int b)
	{
		returnBlocks(a);
		
		int oldPos = posBlock[a] ;
		last[oldPos]--;
		
		int pos = posBlock[b] , height = last[pos];
		arr[pos][height] = a;
		posBlock[a] = pos;
		posStack[a] = height++;
		
		last[pos] = height;
	}
	
	static void pileOn(int a,int b)
	{
		returnBlocks(b);
		pileOver(a, b);
	}
	
	static void pileOver(int a,int b)
	{
		int posA = posBlock[a] , posB = posBlock[b];
		int oldHeight = posStack[a];
		for(int i = posStack[a]; i < last[posA];++i)
		{
			int cur = arr[posA][i];
			arr[posB][last[posB]] = cur;
			posStack[cur] = last[posB]++;
			posBlock[cur] = posB;
		}
		last[posA] = oldHeight;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n+1][n+1];
		last = new int[n+1];
		posBlock = new int[n+1];
		posStack = new int[n+1];
		
		for (int i = 0; i <= n; i++) 
		{
			arr[i][0] = posBlock[i] = i;
			last[i] = 1;
		}
		
		while(true)
		{
			String ins = sc.next();
			if(ins.equals("quit"))
				break;
			int a = sc.nextInt()+1;
			String ins1 = sc.next();
			int b = sc.nextInt()+1;
			
			if(posBlock[a]==posBlock[b])
				continue;
			
			if(ins.equals("move"))
			{
				if(ins1.equals("onto"))
					mvOn(a, b);
				else
					mvOver(a, b);
			}
			else
			{
				if(ins1.equals("onto"))
					pileOn(a, b);
				else
					pileOver(a, b);
			}
		}
		
		for(int i = 1;i<=n;i++)
		{
			System.out.print((i-1)+":");
			for(int j = 0; j < last[i];j++)
				System.out.print(" "+(arr[i][j]-1));
			
			System.out.println();
		}
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public Scanner(String s) throws FileNotFoundException {br = new BufferedReader(new FileReader(s));}
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
