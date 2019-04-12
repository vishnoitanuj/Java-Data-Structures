package CN;

import java.util.Scanner;

public class HasPath {
	
	public static boolean checkPath(int[][] edges,int sv,int ev) {
		boolean visited[] = new boolean[edges.length];
		return DFS(edges,sv,ev,visited);
	}

	private static boolean DFS(int[][] edges, int sv,int ev, boolean[] visited) {
		visited[sv] = true;
		if(sv==ev)
			return true;
		boolean ans = false;
		for(int i=0;i<edges.length;i++) {
			if(edges[sv][i]==1 && !visited[i])
				ans = DFS(edges, i, ev, visited);
			if(ans)
				return ans;
		}
		return ans;
	}

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
		System.out.println(checkPath(edges,sv,ev));
		sc.close();
	}
}
