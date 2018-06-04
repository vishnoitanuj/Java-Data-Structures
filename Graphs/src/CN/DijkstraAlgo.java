package CN;

import java.util.Scanner;

public class DijkstraAlgo {

	public static void dijikstra(int[][] adjacencyMatrix) {
		int v = adjacencyMatrix.length;
		boolean visited[]= new boolean[v];
		int distance[] = new int[v];
		distance[0] = 0;
		for(int i=1;i<v;i++)
			distance[i] = Integer.MAX_VALUE;
		
		for(int i=0;i<v-1;i++) {
			//find Vertex with minimum distance
			int minVertex = findMinVertex(distance, visited);
			visited[minVertex] = true;
			for(int j=0;j<v;j++) {
				if(adjacencyMatrix[minVertex][j]!=0 && !visited[j] && distance[minVertex]!=Integer.MAX_VALUE) {
					int newDistance = distance[minVertex] + adjacencyMatrix[minVertex][j];
					if(newDistance < distance[j])
						distance[j] = newDistance;
				}
			}
		}
		
		//Print
		for(int i=0;i<v;i++)
			System.out.println(i+" "+distance[i]);
		
	}
	
	private static int findMinVertex(int[] distance, boolean[] visited) {
		
		int minVertex = -1;
		for(int i=0;i<distance.length;i++) {
			if(!visited[i] && (minVertex==-1 || distance[i]<minVertex))
				minVertex = i;
		}
		return minVertex;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int adjacencyMatrix[][] = new int[v][v];
		for(int i=0;i<e;i++) {
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				int weight = sc.nextInt();
				adjacencyMatrix[v1][v2] = weight;
				adjacencyMatrix[v2][v1] = weight;
		}
		dijikstra(adjacencyMatrix);
		sc.close();
	}
}
