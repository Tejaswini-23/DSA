import java.util.*;
class BSTLCount{
    Node root=null;
    public static void main(String args[]){
        BSTLCount t1=new BSTLCount();
        t1.menu();
    }
    public void menu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("1.Insert"); 
        System.out.println("2.Traversal");
        System.out.println("3.EXIT");
        System.out.println("4.Leaf Nodes Count");
        System.out.println("5.Non leaf Nodes Count");
        while(true){
        System.out.println("Enter the operation :");
        int choice;
        choice=sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter a value to insert : ");
                root=insertBegin(root,sc.nextInt());
                break;
            case 2:
                System.out.println("1.Inorder");
                System.out.println("2.Preorder");
                System.out.println("3.Postorder");
                int order;
                order=sc.nextInt();
                switch(order){
                    case 1:inOrder(root);break;
                    case 2:preOrder(root);break;
                    case 3:postOrder(root);break;
                    default:System.out.println("Enter a valid traversal");
                }
                break;
            case 3:
                System.exit(0);
            case 4:
                int c=leafNodes(root);
                System.out.println("Leaf Nodes Count : "+c);
                break;
            case 5:
                int c2=nonLeafNodes(root);
                System.out.println("Non Leaf Nodes Count : "+c2);
                break;
            default:
                System.out.println("Enter a valid option");
                break;
        }
        }
    }
    public Node insertBegin(Node root,int x){
        if(root==null){
            Node t=new Node(x);
            t.data=x;
            t.left=null;
            t.right=null;
            root=t;
            return root;
        }
        else if(x<root.data){
            root.left=insertBegin(root.left,x);
        }
        else if(x>root.data){
            root.right=insertBegin(root.right,x);
        }
            return root;
    }
    public void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
    public void preOrder(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void postOrder(Node root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }
    public int leafNodes(Node root){
        if(root==null){
            return 0;
            }
        else if(root.left==null && root.right==null){
            return 1;
        }
        else{
            return leafNodes(root.left)+leafNodes(root.right);
        }
    }
    public int nonLeafNodes(Node root){
        if(root==null){
            return 0;
        }
        else if(root.left!=null || root.right!=null){
            return 1+nonLeafNodes(root.left)+nonLeafNodes(root.right);
        }
        else{
            return nonLeafNodes(root.left)+nonLeafNodes(root.right);
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