import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			int q = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < arr.length; i++) 
				arr[i] = Integer.parseInt(st.nextToken());
			
			SegmentTree tree = new SegmentTree(arr);
			while(q-->0)
			{
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken())-1;
				int r = Integer.parseInt(st.nextToken())-1;
				out.append(tree.search(l, r)+"\n");
			}
		}
		out.flush();
	}
	static class SegmentTree
	{
		static class Node
		{
			int leftVal,leftCount;
			int rightVal,rightCount;
			int val;
		}
		int[] arr;
		Node[] tree;
		int n;
		
		public SegmentTree(int[] a) 
		{
			arr = a;
			n = 0;
			int ind = 1;
			while(n<a.length)
			{
				n = 1<<ind++;
			}
			tree = new Node[n<<1];
			build(1, 0, a.length-1);
		}
		public int left(int cur)
		{
			return cur<<1;
		}
		public int right(int cur)
		{
			return (cur<<1)+1;
		}
		public void build(int cur,int l,int r)
		{
			Node curNode = new Node();
			if(l==r)
			{
				curNode.leftCount = 1;
				curNode.rightCount = 1;
				curNode.leftVal = arr[l];
				curNode.rightVal = arr[l];
				curNode.val = 1;
				tree[cur] = curNode;
				return;
			}
			int mid = (l+r) >> 1;
			build(left(cur), l, mid);
			build(right(cur), mid+1, r);
			Node leftNode = tree[left(cur)];
			Node rightNode = tree[right(cur)];
			
			curNode.val = Math.max(leftNode.val, rightNode.val);
			curNode.leftVal = leftNode.leftVal;
			curNode.leftCount = leftNode.leftCount;
			curNode.rightVal = rightNode.rightVal;
			curNode.rightCount = rightNode.rightCount;
			
			if(leftNode.rightVal == leftNode.leftVal && leftNode.rightVal == rightNode.leftVal)
				curNode.leftCount += rightNode.leftCount;
			
			if(rightNode.rightVal == rightNode.leftVal && rightNode.leftVal == leftNode.rightVal)
				curNode.rightCount += leftNode.rightCount;

			if(leftNode.rightVal == rightNode.leftVal )
				curNode.val = Math.max(leftNode.rightCount + rightNode.leftCount, curNode.val);

			tree[cur] = curNode;
		}
		
		public int search(int lq,int rq)
		{
			return search(1,0,arr.length-1,lq,rq).val;
		}
		public Node search(int cur,int l,int r,int lq,int rq)
		{
			if(l>rq || r<lq)
				return new Node();

			if(l==r)
				return tree[cur];

			if(l>=lq && r<=rq)
				return tree[cur];
			
			Node curNode = new Node();
			int mid = (l+r) >> 1;
			
			Node leftNode = search(left(cur), l, mid,lq,rq);
			Node rightNode = search(right(cur), mid+1, r,lq,rq);
			
			curNode.val = Math.max(leftNode.val, rightNode.val);
			curNode.leftVal = leftNode.leftVal;
			curNode.leftCount = leftNode.leftCount;
			curNode.rightVal = rightNode.rightVal;
			curNode.rightCount = rightNode.rightCount;
			
			if(leftNode.rightVal == leftNode.leftVal && leftNode.rightVal == rightNode.leftVal)
				curNode.leftCount += rightNode.leftCount;
				
			if(rightNode.rightVal == rightNode.leftVal && rightNode.leftVal == leftNode.rightVal)
				curNode.rightCount += leftNode.rightCount;

			if(leftNode.rightVal == rightNode.leftVal )
				curNode.val = Math.max(leftNode.rightCount + rightNode.leftCount, curNode.val);

			return curNode;
		}
	}
}
