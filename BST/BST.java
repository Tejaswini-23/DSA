import java.util.*;
class BST{
    Node root=null;
    public static void main(String args[]){
        BST t1=new BST();
        t1.menu();
    }
    public void menu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("1.Insert"); 
        System.out.println("2.Traversal");
        System.out.println("3.EXIT");
        System.out.println("Enter the operation :");
        int choice;
        choice=sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter a value to insert : ");
                insertBegin(sc.nextInt());
                break;
            case 2:
                traversal(root);
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Enter a valid option");
                break;
        }
    }
    public void insertBegin(int x){
        Node t=new Node(x);
        t.data=x;
        t.left=null;
        t.right=null;
        if(root==null){
            root=t;
        }
        else{
            Node p=null; 
            Node curr=root;
            while(curr!=null){
                p=curr;
                if(x<curr.data){
                    curr=curr.left;
                }
                else if(x>curr.data){
                    curr=curr.right;
                }
                else{
                    System.out.println("Duplicate value");
                    break;
                }

            }
        }
        if(x<p.data){
            p.left=t;
        }
        else{ 
            p.right=t;
        }      
    }
    public void traversal(Node root){
        if(root!=null){
            traversal(root.left);
            System.out.print(root.data+" ");
            traversal(root.right);
        }
    }
}
class Node{
    int data;
    Node left,right;
    public Node(int x){
        this.data=x;
        left=null;
    
        right=null;
    }
}