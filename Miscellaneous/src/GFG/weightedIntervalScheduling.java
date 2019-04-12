package GFG;
import java.util.Arrays;
import java.util.Comparator;

class Job{
	int start,finish,profit;
	public Job(int start,int finish,int profit){
		this.start=start;
		this.finish=finish;
		this.profit=profit;
	}
}

class JobComparator implements Comparator<Job>{
	
	public int compare(Job a, Job b)
    {
        return a.finish < b.finish ? -1 : a.finish == b.finish ? 0 : 1;
    }
}
public class weightedIntervalScheduling {
	
	public static int latestNonConflict(Job a[],int i) {
		for (int j=i-1; j>=0; j--)
	    {
	        if (a[j].finish <= a[i].start)
	            return j;
	    }
	    return -1;
	}
	
	public static int binaryNonConflict(Job a[],int i) {
		int l=0,h=i-1;
		
		while(l<=h) {
			int mid=(l+h)/2;
			if(a[mid].finish<=a[i].start) {
				if(a[mid+1].finish<=a[i].start)
					l=mid+1;
				else
					return mid;
			}
			else
				h=mid-1;
		}
		return -1;
	}
	
	public static int schedule(Job jobs[]) {
		Arrays.sort(jobs, new JobComparator());
		int n=jobs.length;
		int table[]=new int[n];
		table[0]=jobs[0].profit;
		for(int i=1;i<n;i++) {
			int inclProf=jobs[i].profit;
			int p=binaryNonConflict(jobs, i);
			if(p!=-1)
				inclProf+=table[p];
			table[i]=Math.max(inclProf, table[i-1]);
		}
		return table[n-1];
	}
	
	public static void main(String args[]) {
		Job jobs[] = {new Job(1, 2, 50), new Job(3, 5, 20),
                new Job(6, 19, 100), new Job(2, 100, 200)};

  System.out.println("Optimal profit is " + schedule(jobs));
	}

}

//if we use binary search, O(nlogn), else O(n^2)
