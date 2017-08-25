// The idea of this solution is taken from this link : https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v100/EditStepLadders_UVa10029.java
// Note that the input may contain non-lower-case words

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static ArrayList<String>arr;
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner((System.in));
		arr = new ArrayList<String>();
		Trie trie = new Trie();
		n = 0;
		while(sc.ready())
		{
			String s = sc.nextLine().toLowerCase();
			arr.add(s);
			trie.insert(s, n++);
		}
		int[] dp = new int[n];
		int ans = 1;
		Arrays.fill(dp, 1);
		for (int i = 0; i < n; i++) 
		{
			ans = Math.max(ans, dp[i]);
			ArrayList<Integer>list = trie.search(arr.get(i));
			for(int j : list)
				if(j>i)
					dp[j] = Math.max(dp[j], dp[i]+1);
		}
		System.out.println(ans);
	}	
	static class Trie
	{
		static class Node
		{
			int ind;
			Node[] arr;
			public Node(int i) {
				ind = i;
				arr = new Node[26];
			}
		}
		Node root;
		String s;
		int index;
		ArrayList<Integer>list;
		public Trie() {
			root = new Node(-1);
		}
		void insert(String s,int ind)
		{
			this.s = s;
			index = ind;
			insert(root,0);
		}
		void insert(Node cur,int i)
		{
			if(i==s.length())
			{
				cur.ind = index;
				return;
			}
			char c = s.charAt(i);
			if(cur.arr[c-'a']==null)cur.arr[c-'a'] = new Node(-1);
			cur = cur.arr[c-'a'];
			insert(cur, i+1);
		}
		ArrayList<Integer> search(String s)
		{
			this.s = s;
			list = new ArrayList<Integer>(); // A list of indecies of all possible Strings that could match String s
			search(root,0,false);
			return list;
		}
		void search(Node cur,int i,boolean change)
		{
			if(i>s.length()+1)return;
			if(i>=s.length() && cur.ind!=-1 && change)
			{
				list.add(cur.ind);
				return;
			}
			
			if(!change)
			{
				for (int j = 0; j < 26; j++) 
				{
					if(cur.arr[j]!=null)
					{
						search(cur.arr[j],i,true); // Added a character
						search(cur.arr[j],i+1,true); // Changed a character
					}
				}
				search(cur, i+1, true); // Removed a character
			}
			if(i<s.length() && cur.arr[s.charAt(i)-'a']!=null)
				search(cur.arr[s.charAt(i)-'a'],i+1, change); // No change
		}
	}
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		
		public Scanner(FileReader r){	br = new BufferedReader(r);}
		
		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public boolean ready() throws IOException {return br.ready();}

	}

}
