import java.util.*;

public class BooleanMatrixProblem{
	public static void main(String[]args){
		int mat[][] = {{1,0,0},{1,0,0},{1,0,0},{0,0,0}};
		int row[] = new int[4];
		int col[] = new int[3];

		for(int i=0;i<=3;i++){
			row[i] = 0;
		}
		for(int j=0;j<=2;j++){
			col[j] = 0;	
		}

		for(int i=0;i<=3;i++){
			for(int j=0;j<=2;j++){
				if(mat[i][j]== 1){
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		for(int i=0;i<=3;i++){
			for(int j=0;j<=2;j++){
				if(row[i] == 1 || col[j] == 1){
					mat[i][j] = 1;
				}
			}
		}

		for(int i=0;i<=3;i++){
			for(int j=0;j<=2;j++){
				System.out.print(mat[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}
}