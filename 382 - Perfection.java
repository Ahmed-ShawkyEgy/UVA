import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		System.out.println("PERFECTION OUTPUT");
		while(true)
		{
			int n = sc.nextInt();
			if(n==0)
				break;
			int sum = 0;
			for(int i = 1;i<=n/2;i++)
			{
				if(n%i==0)
					sum += i;
			}
			System.out.printf("%5d  %s\n",n,(sum < n ?
                    "DEFICIENT" : (sum > n ?
                    "ABUNDANT" : "PERFECT")));
		}
		System.out.println("END OF OUTPUT");
	}
}
