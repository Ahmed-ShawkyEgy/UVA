import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	UnionFind uf = new UnionFind(n);
    	while(br.ready())
    	{
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int c = Integer.parseInt(st.nextToken());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());    
    		if(c==0)
    			return;
    		switch (c) {
			case 1:
				uf.setFrinds(x, y);
				break;
			case 2:
				uf.setEnemies(x, y);
				break;
			case 3:
				uf.areFriends(x, y);
				break;
			case 4:
				uf.areEnemies(x, y);
			default:
				break;
			}
    	}
   }
   static class UnionFind
   {
	   int[] head;
	   int[] rank;
	   int[] enemy;
	   public UnionFind(int n)
	   {
		   head = new int[n];
		   rank = new int[n];
		   enemy = new int[n];
		   for (int i = 0; i < n; i++) 
		   {
			   head[i] = i;
			   rank[i] = 1;
			   enemy[i] = -1;
		   }
	   }
	   public int findSet(int x)
	   {
		   if(x==-1 || head[x] == x)
			   return x;
		   return head[x] = findSet(head[x]);
	   }
	   public void union(int x,int y)
	   {
		   int a = findSet(x),b = findSet(y);
		   if(a==b || a==-1 || b==-1)
			   return;
		   if(rank[a]>rank[b])
		   {
			   head[b] = a;
		   }
		   else
		   {
			   head[a] = b;
			   if(rank[a]==rank[b])
			   {
				   rank[b]++;
			   }
		   }
	   }
	   public void setFrinds(int x,int y)
	   {
		   int a = findSet(x), b = findSet(y);
		   if(a==b)
			   return;
		   int enemy1 = findSet(enemy[a]);
		   int enemy2 = findSet(enemy[b]);
		   if(enemy1==-1 && enemy2!=-1)
		   {
			   union(a, b);
			   enemy[findSet(a)] = enemy2;
			   enemy[findSet(enemy2)] = findSet(a);
			   return;
		   }
		   if(enemy2==-1 && enemy1!=-1)
		   {
			   union(a, b);
			   enemy[findSet(a)] = enemy1;
			   enemy[findSet(enemy1)] = findSet(a);
			   return;
		   }
		   if(enemy1==-1 && enemy1==-1)
		   {
			   union(a, b);
			   findSet(a);
			   findSet(b);
			   return;
		   }
		   if(enemy1==enemy2)
		   {
			   union(a, b);
			   return;
		   }
		   if(enemy[enemy1]==enemy2 || enemy[enemy2]==enemy1)
		   {
			   union(a, enemy2);
			   union(b, enemy1);
			   enemy[findSet(a)] = findSet(b);
			   enemy[findSet(b)] = findSet(a);
			   System.out.println(-1);
			   return;
		   }
		   if(enemy1==b || enemy2==a)
		   {
			   System.out.println(-1);
			   return;
		   }
		   union(a, b);
		   int new_set = findSet(a);	
		   findSet(b);
		   if(enemy1!=-1 && enemy2!=-1)
		   {
			   union(enemy1, enemy2);
			   int new_Enemy = findSet(enemy1);
			   findSet(enemy2);
			   enemy[new_set] = findSet(new_Enemy);
			   enemy[findSet(new_Enemy)] = new_set;
		   }
		   else
		   {
			   if(enemy1==-1 && enemy2!=-1)
			   {
				   enemy[new_set] = enemy2;
				   enemy[enemy2] = new_set;
			   }
			   else
			   {
				   if(enemy2==-1 && enemy1!=-1)
				   {
					   enemy[new_set] = enemy1;
					   enemy[enemy1] = new_set;
				   }
			   }
		   }
	   }
	   public void setEnemies(int x,int y)
	   {
		   int a = findSet(x), b = findSet(y);
		   int e1 = findSet(enemy[a]);
		   int e2 = findSet(enemy[b]);
		   if(a==b)
		   {
			   System.out.println(-1);
			   return;
		   }
		   if(e1==-1 && e2==-1)
		   {
			   enemy[a] = b;
			   enemy[b] = a;
			   return;
		   }
		   if(e1!=-1 && e2==-1)
		   {
			   union(b, e1);
			   enemy[a] = findSet(b);
			   enemy[findSet(b)] = a;
			   return;
		   }
		   if(e2!=-1 && e1==-1)
		   {
			   union(a, e2);
			   enemy[b] = findSet(a);
			   enemy[findSet(a)] = b;
			   return;
		   }
		   if(e1==e2)
		   {
			   union(a, b);
			   enemy[findSet(a)] = findSet(e1);
			   System.out.println(-1);
			   return;
		   }
		   if(e1==b || e2==a)
		   {
			   return;
		   }
		   union(a, e2);
		   union(b, e1);
		   enemy[findSet(a)] = findSet(b);
		   enemy[findSet(b)] = findSet(a);
	   }
	   public void areFriends(int x,int y)
	   {
		   int a = findSet(x), b = findSet(y);
		   if(a==b)
		   {
			   System.out.println(1);
			   return;
		   }
		   int e1 = findSet(enemy[findSet(a)]);
		   int e2 = findSet(enemy[findSet(b)]);
		   if(e1==-1 && e2==-1)
		   {
			   System.out.println(0);
			   return;
		   }		   
		   if(e1==e2)
		   {
			   union(a, b);
			   enemy[findSet(a)] = findSet(e1);
			   enemy[findSet(e1)] = findSet(a);
			   System.out.println(1);
			   return;
		   }
		   System.out.println(0);
	   }
	   public void areEnemies(int x,int y)
	   {
		   int a = findSet(x), b = findSet(y);
		   int e1 = findSet(enemy[findSet(a)]);
		   int e2 = findSet(enemy[findSet(b)]);
		   if(e1==b || e2==a)
		   {
			   System.out.println(1);
			   return;
		   }
		   System.out.println(0);
	   }
	   
   }
}	
