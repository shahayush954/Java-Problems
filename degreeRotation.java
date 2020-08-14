import java.util.*;

public class degreeRotation{
	public static void main(String[]args){
		int a[][] = {{1,2,3},{4,5,6},{7,8,9}};
		int b[][] = new int[3][3];
		for(int i=2;i>=0;i--){
			for(int j=0;j<=2;j++){
				System.out.println(a[j][i]);
			}
			System.out.println("\n");
		}
	}
}