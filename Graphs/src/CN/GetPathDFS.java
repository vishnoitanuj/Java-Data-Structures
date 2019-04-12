package CN;

import java.util.Scanner;

public class GetPathDFS {
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		int edges[][] = new int[n][n];
		for(int i=0;i<e;i++) {
			int fv = sc.nextInt();
			int sv = sc.nextInt();
			edges[fv][sv] = 1;
			edges[sv][fv] = 1;
		}
		int sv = sc.nextInt();
		int ev = sc.nextInt();
		int[] ans = printDFSPath(edges,sv,ev);
		for(int i=ans.length-1;i>=0;i--)
			System.out.println(ans[i]);
		sc.close();

	}

	public static int[] printDFSPath(int[][] edges, int sv, int ev) {
		// TODO Auto-generated method stub
		return null;
	}

}
