import java.util.*;

class stack{
	int arr[] = new int[3];
	int top = -1;
	public void push(int data){
		if(top == arr.length-1){
			System.out.println("Stack is Full");
		}
		else{
			top = top + 1;
			arr[top] = data;
		}
	}

	public void pop(){
		if(top == -1){
			System.out.println("Stack is empty");
		}
		else{
			int data = arr[top];
			top = top - 1;
			System.out.println(data);
		}
	}

	public void display(){
		for(int i=0;i<=top;i++){
			System.out.println(arr[i]+"\t");
		}
	}
}

class stack_implementation{
	public static void main(String[]args){
		stack s = new stack();
		s.push(1);
		s.push(2);
		s.push(3);
		//s.push(4);
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.display();
	}
}