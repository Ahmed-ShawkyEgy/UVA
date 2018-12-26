import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		char[][] a = new char[5][];
		StringBuilder sb = new StringBuilder();
		int cases = 1;
		while(true)
		{
			a[0] = sc.nextLine().toCharArray();
			if(a[0].length<5 && a[0][0]=='Z')
				break;
			if(cases!=1)
				sb.append("\n");
			sb.append("Puzzle #"+cases+++":\n");
			for(int i = 1; i < 5;i++)a[i] = sc.nextLine().toCharArray();
			int x = 0 , y = 0;
			for (int i = 0; i < a.length; i++) 
				for (int j = 0; j < a[0].length; j++) 
					if(a[i][j]==' ')
					{
						x = i; y=j;
					}
						
			boolean valid = true;
			StringBuilder seq = new StringBuilder();
			while(true)
			{
				String s = sc.nextLine().trim();
				seq.append(s);
				if(s.charAt(s.length()-1)=='0')
					break;
			}
			for(char c : seq.toString().toCharArray())
			{
				if(c=='0')
					break;					
				else if(c=='A')
				{
					if(x==0)valid = false;
					else
					{
						a[x][y] = a[x-1][y];
						a[x-1][y] = ' ';
						--x;
					}
				}
				else if(c=='B')
				{
					if(x==4)valid = false;
					else
					{
						a[x][y] = a[x+1][y];
						a[x+1][y] = ' ';
						++x;
					}
				}
				else if(c=='L')
				{
					if(y==0)valid = false;
					else
					{
						a[x][y] = a[x][y-1];
						a[x][y-1] = ' ';
						--y;
					}
				}
				else if(c=='R')
				{
					if(y==4)valid = false;
					else 
					{
						a[x][y] = a[x][y+1];
						a[x][y+1] = ' ';
						++y;
					}
				}
				
			}
			if(!valid)
				sb.append("This puzzle has no final configuration.\n");
			else
			{
				for(int i = 0; i < 5;i++)
				{
					sb.append(a[i][0]);
					for(int j = 1;j<5;j++)
						sb.append(" "+a[i][j]);
					sb.append("\n");
				}
			}
		}
		System.out.print(sb);
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
