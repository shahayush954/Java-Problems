import java.util.*;

public class SelectionSortImplementation{
	public static void main(String[]args){
		int arr[] = {5,1,4,2,8};

		for(int i=0;i<arr.length-1;i++){
			int ind = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[ind]){
					ind = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[ind];
			arr[ind] = temp;
		}

		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}