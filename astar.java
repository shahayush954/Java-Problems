import java.io.*; 
import java.util.*;  
public class astar
{ 
    private int vertices;
	int CostMatrix[][];
	int h[];
    int g[];
	private int node_count=0;
    int state[];
	int queue_len =0;
	String path ="";
    astar(int v, int[]heuristic) 
    { 
        vertices= v; 
		CostMatrix = new int[v][v];
		h = heuristic;
		g = new int[v];
		state = new int[v]; // 0 indicates not considered yet , 1 indicates in queue, 2 indicates completed
		for(int i =0;i<g.length;i++)
		{
			g[i] = Integer.MAX_VALUE;
		}
    } 
	void addEdge(int vertex1,int vertex2, int cost) 
    { 
        CostMatrix[vertex1][vertex2]= cost;
		CostMatrix[vertex2][vertex1] = cost;
    }
	void aStar(int start, int end)
	{
		state[start] = 2;
		path= path+"->"+start;
		g[start]=0;
		pushNeighbors(start);
		printStats(start);
		while(queue_len!=0)
		{
			int index = getBestHeur();
			state[index] =2;
			queue_len--;
			printStats(index);
			pushNeighbors(index);
			path= path+"->"+index;
		}
		
	}
	void pushNeighbors(int v)
	{
		for(int i =0;i< vertices;i++)
		{
			if(CostMatrix[v][i]!=0 && g[i]>g[v]+CostMatrix[v][i] && state[i]!=2)
			{
				g[i] = g[v] +CostMatrix[v][i];
				if(state[i] ==0)
					queue_len++;
				state[i]=1;
			}
		}
	}
	int getBestHeur()
	{  
		int value = Integer.MAX_VALUE;
		int index =-1;
		for(int i =0;i<vertices;i++)
		{
			if(state[i] ==1 && g[i]+h[i]<value)
			{
				value= g[i]+h[i];
				index =i;
			}
		}
		return index;
	}
			
	void printStats(int v)
	{ 
	
		System.out.println(v+"\n: QUEUE");
		for(int i =0;i<vertices;i++)
		{
			System.out.print(state[i] +"");
		}
		System.out.println();
		System.out.println("F(x):");
		for(int i =0;i<vertices;i++)
		{
			int value = (g[i]+h[i])>0?(g[i]+h[i]):Integer.MAX_VALUE;
			System.out.print(value+"\t");
		}
		System.out.println();
	}


    public static void main(String args[]) 
    { 
        astar g = new astar(7, new int[]{21,14,18,18,5,8,0}); 

        g.addEdge(0,1,9); 
        g.addEdge(0,2,4); 
        g.addEdge(0,3,7);
        g.addEdge(1,4,11); 
		g.addEdge(2,4,17); 
        g.addEdge(2,5,12); 
        g.addEdge(3,5,14); 
        g.addEdge(4,6,5);
		g.addEdge(5,6,9);

        g.aStar(0,5); 
		System.out.println("Nodes checked are "+g.path);
    } 
} 
