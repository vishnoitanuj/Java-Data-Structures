package CN;

import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	int source,dest,weight;

	@Override
	public int compareTo(Edge arg0) {
		return this.weight - arg0.weight;
	}
	
}
public class Kruskal {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		Edge input[] = new Edge[e];
		for(int i=0;i<e;i++) {
			input[i] = new Edge();
			input[i].source = sc.nextInt();
			input[i].dest = sc.nextInt();
			input[i].weight = sc.nextInt();
		}
		kruskal(input,n);
		sc.close();
	}

	public static void kruskal(Edge[] input, int n) {
		
		Arrays.sort(input);
		Edge output[] = new Edge[n-1];
		int i=0,count=0,j;
		int parent[] = new int[n];
		
		for(j=0;j<n;j++)
			parent[j] = j;
		
		while(count!=n-1) {
			Edge currentEdge = input[i];
			int sourceParent = findParent(currentEdge.source,parent);
			int destParent = findParent(currentEdge.dest,parent);
			
			if(sourceParent!=destParent) {
				output[count++] = input[i];
				parent[sourceParent] = destParent;
			}
			i++;
		}
		
		for(j=0;j<n-1;j++) {
			if(output[j].source < output[j].dest)
				System.out.println(output[j].source + " " + output[j].dest + " " + output[j].weight);
			else
				System.out.println(output[j].dest + " " + output[j].source + " " + output[j].weight);
				
		}
	}

	private static int findParent(int v, int[] parent) {
		
		if(parent[v]==v)
			return v;
		return findParent(parent[v], parent);
	}
}
