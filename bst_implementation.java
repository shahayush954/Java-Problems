import java.util.*;

class BinarySearchTree{
	int data;
	BinarySearchTree left = null;
	BinarySearchTree right = null;

	public BinarySearchTree addElement(int data,BinarySearchTree root){
		BinarySearchTree newnode = new BinarySearchTree();
		newnode.data = data;
		if(root == null){
			root = newnode;
		}
		else if(data < root.data){
			root.left = addElement(data,root.left);
		}
		else if(data > root.data){
			root.right = addElement(data,root.right);
		}
		return root;
	}

	public void display(BinarySearchTree node){
		if(node != null){

			System.out.println(node.data);
			display(node.left);
			display(node.right);
			
		}
	}

}


class bst_implementation{
	public static void main(String[]args){
		BinarySearchTree bst = new BinarySearchTree();
		bst = bst.addElement(10,bst);
		bst.left = null;
		bst = bst.addElement(5,bst);
		bst = bst.addElement(2,bst);
		bst = bst.addElement(6,bst);
		bst = bst.addElement(15,bst);
		bst = bst.addElement(11,bst);
		bst = bst.addElement(20,bst);
		bst.display(bst);
	}
}