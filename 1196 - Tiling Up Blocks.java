import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static Block[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
		while(true)
		{
			n = Integer.parseInt(br.readLine().trim());
			if(n==0)break;
			arr = new Block[n];
			for (int i = 0; i < n; i++) 
			{
				st = new StringTokenizer(br.readLine());
				arr[i] = new Block(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(arr);
			sb.append(LIS()+"\n");
		}
		System.out.println(sb+"*");
	}
	static class Block implements Comparable<Block>
	{
		int left,mid;
		public Block(int l,int m)
		{
			left = l;
			mid = m;
		}
		public int compareTo(Block o) {
			return left!=o.left?left-o.left:mid-o.mid;
		}
		
	}
	
	static int LIS()
	{
		int ans = 1;
		int[] memo = new int[n];
		Arrays.fill(memo, 1);
		for (int i = n-1; i >=0; i--) 
		{
			int max = 0;
			for (int j = i+1; j < n; j++) 
				if(arr[j].mid>=arr[i].mid)
					max = Math.max(max, memo[j]);
			memo[i] += max;
			ans = Math.max(ans, memo[i]);
		}
		return ans;
	}
	 
}
