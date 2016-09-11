import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main {
	static boolean gameOver;
	static boolean firstTurn ;
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			String xx = br.readLine();
			if(xx.charAt(0)=='#')
				break;
			Deque<String> nonD = new LinkedList<String>();
			Deque<String> D = new LinkedList<String>();
			StringTokenizer st = new StringTokenizer(xx);
			boolean lastD = true;
			for (int i = 0; i < 13; i++) {
				if(lastD)
					nonD.add(st.nextToken());
				else
					D.add(st.nextToken());
				lastD = !lastD;
			}
			for (int i = 0; i < 3; i++) {
				
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 13; j++) 
				{
					if(lastD)
						nonD.add(st.nextToken());
					else
						D.add(st.nextToken());
					lastD = !lastD;
				}
			}
			Deque<String> heap = new LinkedList<String>();
			gameOver = false;
			firstTurn = true;
			boolean winner = true;
			while(true)
			{				
				if(firstTurn)
				{
					if(nonD.isEmpty() )
					{
						winner = false;
						break;
					}
					if(gameOver)
					{
						if(nonD.isEmpty())
							winner = false;
						else
							winner = true;
							
						break;
					}
					String card = nonD.pollLast();
					heap.add(card);
					firstTurn = false;
					switch(card.charAt(1))
					{
					case 'A':
						firstTurn = !firstTurn;
						simulate(D, nonD, heap, 4);
						break;
					case 'K':
						firstTurn = !firstTurn;
						simulate(D, nonD, heap, 3);
						break;
					case 'Q':
						firstTurn = !firstTurn;
						simulate(D, nonD, heap, 2);
						break;
					case 'J':
						firstTurn = !firstTurn;
						simulate(D, nonD, heap, 1);
						break;
					default:
						break;
					}
					if(gameOver)
					{
						if(nonD.isEmpty())
							winner = false;
						else
							winner = true;
							
						break;
					}
				}
				if(!firstTurn)
				{
					if(D.isEmpty() )
					{
						winner = true;
						break;
					}
					if(gameOver)
					{
						if(nonD.isEmpty())
							winner = false;
						else
							winner = true;
							
						break;
					}
					firstTurn = true;
					String card = D.pollLast();
					heap.add(card);
					switch(card.charAt(1))
					{
					case 'A':
						firstTurn = !firstTurn;
						simulate(nonD, D, heap, 4);
						break;
					case 'K':
						firstTurn = !firstTurn;
						simulate(nonD, D, heap, 3);
						break;
					case 'Q':
						firstTurn = !firstTurn;
						simulate(nonD, D, heap, 2);
						break;
					case 'J':
						firstTurn = !firstTurn;
						simulate(nonD, D, heap, 1);
						break;
					default:
						break;
					}
					if(gameOver)
					{
						if(nonD.isEmpty())
							winner = false;
						else
							winner = true;
							
						break;
					}
				}
			}
			if(!winner)
			{
				String ans = (D.size()<10)? " "+D.size() : D.size()+""; 
				out.append("1 "+ans+"\n");
			}
			else
			{
				String ans = (nonD.size()<10)? " "+nonD.size() :nonD.size()+""; 
				out.append("2 "+ans+"\n");
			}
		}
		out.flush();
	}
	public static void simulate(Deque<String> first ,Deque<String> sec,Deque<String> heap,int counter)
	{
		
		while(counter-->0)
		{
			if(first.isEmpty())
			{
				gameOver = true;
				return;
			}
			String card = first.pollLast();
			heap.add(card);
			switch (card.charAt(1)) {
			case 'A':
				firstTurn = !firstTurn;
				simulate(sec, first, heap, 4);
				return;
			case 'K':
				firstTurn = !firstTurn;
				simulate(sec, first, heap, 3);
				return;
			case 'Q':
				firstTurn = !firstTurn;
				simulate(sec, first, heap, 2);
				return;
			case 'J':
				firstTurn = !firstTurn;
				simulate(sec, first, heap, 1);
				return;
			default:
				break;
			}
		}
		takeHeap(sec, heap);
		
	}
	public static void takeHeap(Deque<String>player,Deque<String>heap)
	{
		while(!heap.isEmpty())
		{
			player.offerFirst(heap.pollFirst());
		}
	}
}
