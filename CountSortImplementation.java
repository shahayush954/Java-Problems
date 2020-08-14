import java.util.*;

public class CountSortImplementation{
	public static void main(String[]args){
		int arr[] = {5,1,4,2,8,3,7,6,9};
		int count[] = new int[10];
		for(int i=0;i<arr.length;i++){
			count[arr[i]]++;
		}
		for(int i=1;i<count.length;i++){
			count[i] += count[i-1];
		}
		int output[] = new int[arr.length];
		for(int i=0;i<arr.length;i++){
			output[count[arr[i]]-1] = arr[i];
			count[arr[i]]--;
		}
		for(int i=0;i<output.length;i++){
			System.out.print(output[i]+" ");
		}
	}
}