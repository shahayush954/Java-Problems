import java.util.*;

public class MergeSortImplementaion{

	static int arr[] = {5,1,4,2,8,3,7,6,9};

	public static void MergeSort(int l,int h){
		if(l<h){
			int mid = (l+h)/2;
			MergeSort(l,mid);
			MergeSort(mid+1,h);
			Merge(l,mid,h);
		}
	}

	public static void Merge(int l,int mid,int h){
		int n1 = mid-l+1;
		int n2 = h-mid;
		int left[] = new int[n1];
		int right[] = new int[n2];

		for(int i=0;i<n1;i++){
			left[i] = arr[l+i];
		}
		for(int j=0;j<n2;j++){
			right[j] = arr[mid+1+j];
		}
		int i=0,j=0,k=l;
		while(i<n1 && j<n2){
			if(left[i]<=right[j]){
				arr[k] = left[i];
				i++;
			}
			else{
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while(i<n1){
			arr[k] = left[i];
			i++;
			k++;
		}
		while(j<n2){
			arr[k] = right[j];
			j++;
			k++;
		}
	}

	public static void main(String[]args){
		MergeSort(0,arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}