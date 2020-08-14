import java.util.*;

class queue{
	int arr[] = new int[5];
	int front = -1;
	int back = -1;

	public void addElement(int data){
		if(back == -1){
			front++;
			back++;
		}
		else{
			back++;
		}
		arr[back] = data;
	}
	public void removeElement(){
		if(front == arr.length){
			System.out.println("Queue is full");
		}
		else{
			int data = arr[front];
			front = front + 1;
			System.out.println(data);
		}
	}

	public void display(){
		for(int i=front;i<=back;i++){
			System.out.println(arr[i]);
		}
	}
}

public class queue_implementation{
	public static void main(String[]args){
		queue q = new queue();
		q.addElement(2);
		q.addElement(4);
		q.addElement(1);
		q.display();
		q.removeElement();
		q.display();
		q.display();
	}
}