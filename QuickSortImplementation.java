import java.util.*;

public class QuickSortImplementation{
	static int arr[] = {5,1,4,2,8,3,7,6,9};

	public static void QuickSort(int l,int h){
		if(l<h){
			int j=partition(l,h);
			System.out.println(j);
			for(int i=0;i<arr.length;i++){
				System.out.print(arr[i]+" ");
			}	
			System.out.println();
			QuickSort(l,j-1);
			QuickSort(j+1,h);
		}
	}

	public static int partition(int l,int h){
		int pivot = arr[h];  
        int i = (l-1); // index of smaller element 
        for (int j=l; j<h; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[h]; 
        arr[h] = temp; 
  
        return i+1; 
	}
	public static void main(String[]args){
		QuickSort(0,arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}