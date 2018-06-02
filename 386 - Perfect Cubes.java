import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int cube(int n){return n*n*n;}
	
	static int cubicRoot(int n)
	{
		for(int i = 2;cube(i)<=n;i++)
			if(cube(i)==n)return i;
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean[][][] taken = new boolean[201][201][201];
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (int a = 2; a <= 200; a++) 
		{
			for (int b = 2; b < a; b++) 
			{
				for (int c = b; cube(c)+cube(b) < cube(a); c++) 
				{
					int d = cube(a) - cube(b) - cube(c);
					d = cubicRoot(d);
					int[] tmp = {b,c,d};
					Arrays.sort(tmp);
					
					if(d!=-1 && !taken[tmp[0]][tmp[1]][tmp[2]])
					{
						if(!first)
							sb.append("\n");
						first = false;
						sb.append("Cube = "+a+", Triple = ("+b+","+c+","+d+")");
						taken[tmp[0]][tmp[1]][tmp[2]] = true;
					}
				}
			}
		}
		System.out.println(sb);
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
