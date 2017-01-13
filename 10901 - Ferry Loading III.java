import java.io.*;
import java.util.*;
public class Main{ // This is probably one of the worst AC algorithims for this problem :)
	static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) throws Throwable
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(br.readLine());
		boolean first = true;
		while(cases-->0)
		{
			if(!first)
				out.append("\n");
			first = false;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int cars = Integer.parseInt(st.nextToken());
			Queue<Integer> leftBank = new LinkedList<Integer>();
			Queue<Integer> rightBank = new LinkedList<Integer>();
			
			Queue<Integer> printLeft = new LinkedList<Integer>();
			Queue<Integer> printRight = new LinkedList<Integer>();
			Queue<Character> printOrders = new LinkedList<Character>();
			
			int time = 0;
			boolean leftB = true;
			while(cars-->0)
			{
				st = new StringTokenizer(br.readLine());
				int arrive = Integer.parseInt(st.nextToken());
				if(st.nextToken().charAt(0)=='l')
				{
					leftBank.add(arrive);
					printOrders.add('l');
				}
				else
				{
					rightBank.add(arrive);
					printOrders.add('r');
				}
			}
			while(!leftBank.isEmpty() || !rightBank.isEmpty())
			{
				if(leftB)
				{
				if(leftBank.isEmpty() || (!rightBank.isEmpty() &&rightBank.peek()<leftBank.peek() && leftBank.peek()>time))
					{
						int currentLoad = 0;
						int curTime = rightBank.peek();
						time = Math.max(time, curTime);
						time += t;
						while(!rightBank.isEmpty() && rightBank.peek()<=time && currentLoad<n)
						{
							currentLoad++;
							rightBank.poll();
						}
						time += t;
						leftB = true;
						while(currentLoad-->0)
							printRight.add(time);
						continue;
					}
					int currentLoad = 0;
					int curTime = leftBank.peek();
					time = Math.max(time, curTime);
					while(!leftBank.isEmpty() && leftBank.peek()<=time  && currentLoad<n)
					{
						currentLoad++;
						leftBank.poll();
					}
					time += t;
					leftB = false;
					while(currentLoad-->0)
						printLeft.add(time);
				}
				else
				{
				if(rightBank.isEmpty() ||(!leftBank.isEmpty() && leftBank.peek()<rightBank.peek() && rightBank.peek()>time))
					{
						int currentLoad = 0;
						int curTime = leftBank.peek();
						time = Math.max(time, curTime);
						time += t;
						while(!leftBank.isEmpty() && leftBank.peek()<=time  && currentLoad<n)
						{
							currentLoad++;
							leftBank.poll();
						}
						time += t;
						leftB = false;
						while(currentLoad-->0)
							printLeft.add(time);
						continue;
					}
					int currentLoad = 0;
					int curTime = rightBank.peek();
					time = Math.max(time, curTime);
					while(!rightBank.isEmpty() && rightBank.peek()<=time && currentLoad<n)
					{
						currentLoad++;
						rightBank.poll();
					}
					time += t;
					leftB = true;
					while(currentLoad-->0)
						printRight.add(time);
				}
			}
			append(printRight, printLeft, printOrders);
		}
		out.flush();
	}
	public static void append(Queue<Integer> r,Queue<Integer> l,Queue<Character> order)
	{
		while(!order.isEmpty())
		{
			if(order.poll()=='l')
				out.append(l.poll()+"\n");
			else
				out.append(r.poll()+"\n");
		}
	}
}	
