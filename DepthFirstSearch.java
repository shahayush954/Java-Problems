import java.util.*;

class DFS{
	private int graph[][];
	private Stack<Integer> stack = new Stack<Integer>();
	private int visited[];
	private String path = "";
	public DFS(int n){
		graph = new int[n][n];
		visited = new int[n]; 
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				graph[i][j] = 0;
			}
			visited[i] = 0;
		}
	}
	public void addEdge(int source, int destination, int weight){
		graph[source][destination] = weight;
	}

	public void search(int source,int destination){
		stack.push(source);
		int newnode = 0;
		while(!stack.empty()){
			source = stack.pop();
			path = path + source;
			visited[source] = 1;
			//System.out.println(source+"->");
			if(source == destination){
				break;
			}
			for(int i=0;i<graph.length;i++){
				if(graph[source][i] > 0 && visited[i] == 0){
					stack.push(i);
				}
			}
		}
		int cost = 0;
		for(int i=0;i<path.length()-1;i++){
			cost = cost + graph[Character.getNumericValue(path.charAt(i))][Character.getNumericValue(path.charAt(i+1))];
		}
		System.out.println("Number of nodes traversed:"+path.length());
		System.out.println(path);
		System.out.println("Cost:"+cost);
	}
}

public class DepthFirstSearch{
	public static void main(String[]args){
		DFS dfs = new DFS(7);
		dfs.addEdge(0,1,3);
		dfs.addEdge(0,2,1);
		dfs.addEdge(0,3,8);
		dfs.addEdge(1,0,3);
		dfs.addEdge(1,4,3);
		dfs.addEdge(1,5,7);
		dfs.addEdge(1,6,15);
		dfs.addEdge(2,0,1);
		dfs.addEdge(2,6,20);
		dfs.addEdge(3,0,8);
		dfs.addEdge(3,6,5);
		dfs.addEdge(4,1,3);
		dfs.addEdge(5,1,7);
		dfs.addEdge(6,1,15);
		dfs.addEdge(6,2,20);
		dfs.addEdge(6,3,5);
		dfs.search(0,6);
	}
}