import java.util.*;

class CSP{
	private int graph[][];
	private int filled[];
	private int neighbours[][];
	private int colors;
	private int totalVertex;

	public CSP(int n,int m){
		graph = new int[n][n];
		filled = new int[n];
		neighbours = new int[2][n];
		colors = m;
		totalVertex = n;

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				graph[i][j] = 0;
			}
			filled[i] = 0;
		}
	}

	public void addEdge(int v1, int v2){
		graph[v1][v2] = 1;
	}

	public void initializeNeighbours(){
		int count = 0;
		for(int i=0;i<graph.length;i++){
			count = 0;
			for(int j=0;j<graph[i].length;j++){
				if(graph[i][j] == 1){
					count = 1;
					neighbours[0][i]++;
				}
			}
			neighbours[1][i] = i;
			if(count == 0){
				filled[i] = 1;
			}
		}
	}

	public boolean isAssignmentPossible(int vertex,int col){
		for(int i=0;i<graph.length;i++){
			if(graph[vertex][i] == 1 && col == filled[i]){
				return false;
			}
		}
		return true;
	}

	public void printSolution(){ 
        System.out.println("Colors Assigned:"); 
        for (int i = 0; i < filled.length; i++){
            System.out.print(" " + filled[i] + " "); 
        } 
        System.out.println(); 
    } 

	public boolean graphColoring(int vertex){
		//System.out.println(neighbours[1][vertex]);
		if(vertex == totalVertex){
			return true;
		}
		for(int i=1;i<=colors;i++){
			if(isAssignmentPossible(neighbours[1][vertex],i)){
				filled[neighbours[1][vertex]] = i;
				if(graphColoring(vertex+1)){
					return true;
				}
				filled[neighbours[1][vertex]] = 0;
			}
		}
		return false;
	}

	public void sortNeighbours(){
		int temp1 = 0,temp2 = 0;
		for(int i=0;i<neighbours[0].length-1;i++){
			for(int j=0;j<neighbours[0].length-i-1;j++){
				if(neighbours[0][j] < neighbours[0][j+1]){
					temp1 = neighbours[0][j];
					temp2 = neighbours[1][j];
					neighbours[0][j] = neighbours[0][j+1];
					neighbours[1][j] = neighbours[1][j+1];
					neighbours[0][j+1] = temp1;
					neighbours[1][j+1] = temp2;
				}
			}
		}
		/*for(int i=0;i<2;i++){
			for(int j=0;j<neighbours[0].length;j++){
				System.out.print(neighbours[i][j]+"\t");
			}
			System.out.println();
		}*/
	}
}

public class ConstraintSatisfyingProblem{
	public static void main(String[]args){
		CSP g = new CSP(7,3);

//---------Graph1--------------
		g.addEdge(0,1);
		g.addEdge(0,5);
		g.addEdge(1,0);
		g.addEdge(1,2);
		g.addEdge(1,5);
		g.addEdge(2,1);
		g.addEdge(2,3);
		g.addEdge(2,5);
		g.addEdge(3,2);
		g.addEdge(3,4);
		g.addEdge(3,5);
		g.addEdge(4,3);
		g.addEdge(4,5);
		g.addEdge(5,0);
		g.addEdge(5,1);
		g.addEdge(5,2);
		g.addEdge(5,3);
		g.addEdge(5,4);
//--------------------------

//-------Graph2-------------
		/*
		g.addEdge(0,1);
		g.addEdge(0,5);
		g.addEdge(0,6);
		g.addEdge(1,0);
		g.addEdge(1,2);
		g.addEdge(1,6);
		g.addEdge(2,1);
		g.addEdge(2,3);
		g.addEdge(2,6);
		g.addEdge(3,2);
		g.addEdge(3,4);
		g.addEdge(3,6);
		g.addEdge(4,3);
		g.addEdge(4,5);
		g.addEdge(4,6);
		g.addEdge(5,0);
		g.addEdge(5,4);
		g.addEdge(5,6);
		g.addEdge(6,0);
		g.addEdge(6,1);
		g.addEdge(6,2);
		g.addEdge(6,3);
		g.addEdge(6,4);
		g.addEdge(6,5);
		*/
//----------------------------------
		g.initializeNeighbours();
		g.sortNeighbours();
		if(!g.graphColoring(0)){
			System.out.println("Solution not Possible");
		}
		else{
			g.printSolution();
		}
	}
}