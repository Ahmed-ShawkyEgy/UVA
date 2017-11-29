import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Throwable 
	{
		Scanner sc = new Scanner((System.in));
		String[] country = new String[16];
		
		for (int i = 0; i < 16; i++) 
			country[i] = sc.nextLine();
		
		double[][] arr = new double[16][16];
		
		for (int i = 0; i < arr.length; i++) 
			for (int j = 0; j < arr.length; j++) 
				arr[i][j] = sc.nextInt()/100.0;
			
		
		ProbabilityTree tree = new ProbabilityTree(arr);
		
		for (int i = 0; i < 16; i++) 
			System.out.printf("%-10s p=%.2f%s%n",country[i],100*tree.query(i),"%");

	}
	
	static class ProbabilityTree
	{
		double [][] tree;
		double[][] probability;
		
		public ProbabilityTree(double[][] matrix)
		{
			probability = matrix;
			tree = new double[16<<1][];
			build(1, 1, 16);
		}
		int left(int cur){return cur<<1;}
		int right(int cur){return cur<<1|1;}
		
		void build(int cur,int l,int r)
		{
			tree[cur] = new double[r-l+1];
			if(l==r)
			{				
				tree[cur][0] = 1;
				return;
			}
			int mid = (l+r)>>1;
			build(left(cur), l, mid);
			build(right(cur), mid+1, r);
			
			for(int i = 0 ; i < r-mid ; i++)
			{
				/*
           At the beginning my probability of winning the current stage is equal to winning the 
           previous stage AND defeating whoever won the other stage (hence the variable p)
				 */
				tree[cur][i] = tree[left(cur)][i];
        // Holds the probability of other opponents winning their stages
				double p = 0;
				// My index 0 based in the original array
				int curPlayer = l+i-1;
				for(int j = 0 ; j < r-mid;j++)
				{
					// Probability that the other opponent wins his matches
					double rightOpponent = tree[right(cur)][j] ;
					// Probability that I will defeat that opponent
					double deafeatOpponent = probability[curPlayer][mid+j];
					p += rightOpponent * deafeatOpponent;
				}
				tree[cur][i] *= p;
			}
			
			for (int i = mid - l+1; i < r-l+1; i++)
			{
				tree[cur][i] = tree[right(cur)][i-(mid-l+1)];
				double p = 0;
				int curPlayer = l+i-1;
				for(int j = 0; j < r-mid;j++)
				{
					double lf =  tree[left(cur)][j];
					double pr = probability[curPlayer][l+j-1];
					p += lf * pr;
				}
				tree[cur][i] *= p;
			}
		}
		
		double query(int idx)
		{
			// Probability that idx won all stages
			return tree[1][idx];
		}
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
		public boolean ready() throws IOException {return br.ready();}
	}
}
