import java.util.*;
import java.lang.*;
public class prims
{
    public static int v=5;

    public static int minWeight(int []weight,boolean []visited)
    {
    	int min=Integer.MAX_VALUE;
    	int minIndex=-1;
    	for(int i=0;i<v;i++)
    	{
    		if(visited[i]==false && weight[i]<min)
    		{
    			min=weight[i];
    			minIndex=i;
    		}
    	}
    	return minIndex;
    }
    
	public static void PrimsMST(int [][]graph)
	{
		boolean visited[]=new boolean[v];
		int parent[]=new int[v];
		int weight[]=new int[v];
		
		for(int i=0;i<v;i++)
		{
			visited[i]=false;
			weight[i]=Integer.MAX_VALUE;
		}
		weight[0]=0;
		parent[0]=-1;
		
		for(int count=0;count<v-1;count++)
		{
			int u=minWeight(weight,visited);
			
			visited[u]=true;
			for(int i=0;i<v;i++)
			{
				if(graph[u][i]!=0 && visited[i]==false && graph[u][i]<weight[i])
				{
					parent[i]=u;
					weight[i]=graph[u][i];
				}
			}
			
		}
		printArray(parent,graph);
	}
	
	public static void printArray(int []parent,int [][]graph)
	{
		System.out.println("Edge \tWeight"); 
        for (int i = 1; i < v; i++) 
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]); 
	}
	
	public static void main(String args[])
	{
		prims tree=new prims();
		int graph[][]= {
				{0,2,0,6,0},
				{2,0,3,8,5},
				{0,3,0,0,7},
				{6,8,0,0,9},
				{0,5,7,9,0}
		               };
		prims.PrimsMST(graph);
	}
}
