import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(sc.ready())
		{
			int n = sc.nextInt() , k = sc.nextInt() , a[] = sc.nextIntArr();
			SegmentTree st = new SegmentTree(a);
			while(k-->0)
			{
				char c = sc.nextChar();
				int x = sc.nextInt() , y = sc.nextInt();
				if(c=='C')
					st.update(x-1, y);
				else
				{
					int v = st.query(x-1, y-1);
					char q = v==-1?'-':v==0?'0':'+';
					sb.append(q);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static class SegmentTree
	{
		int[] tree , arr;
		
		public SegmentTree(int[] a) {
			arr = a;
			tree = new int[a.length<<2];
			build(1, 0, arr.length-1);
		}
		
		void build(int n,int l,int r)
		{
			if(l==r)
				tree[n] = (int) Math.signum(arr[l]);
			else
			{
				int mid = (l+r)>>1;
				build(n<<1, l, mid);
				build(n<<1|1, mid+1, r);
				tree[n] = tree[n<<1] * tree[n<<1|1];
			}
		}
		
		void update(int p,int v) {update(1, 0, arr.length-1, p, v);}
		
		void update(int n,int l,int r,int p,int v)
		{
			if(l>p||r<p)return;
			if(l==p&&r==p)
				tree[n] = (int)Math.signum(v);
			else
			{
				int mid = (l+r)>>1;
				update(n<<1, l, mid,p,v);
				update(n<<1|1, mid+1, r,p,v);
				tree[n] = tree[n<<1] * tree[n<<1|1];
			}
		}
		
		int query(int l,int r){return query(1, 0, arr.length-1, l, r);}
		
		int query(int n,int l,int r,int lq,int rq)
		{
			if(l>rq||r<lq)return 1;
			if(l>=lq&&r<=rq)return tree[n];
			int mid = (l+r)>>1;
			return query(n<<1, l, mid, lq, rq) * query(n<<1|1, mid+1, r, lq, rq);
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
