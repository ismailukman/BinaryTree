//Mathias Augsburger
//CSC 3410 Data Structures
//Assignment 7
//12-1-2015

import java.util.*;

/* Class Tree */
public class Tree
{
    public static void main(String[] args)
    {                 
        /* Creating object of BinaryTree */
        BinaryTree BinaryTree = new BinaryTree(); 
        System.out.println("Linked List Binary Search Tree");   
        System.out.println("_________________________________");
        /*  Accept input  */
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        int x = 1;
        
    	for (int i = 0; i<100; i++){
    		/*	Creating 100 random integer values from 1-99	*/
    		
        	Double rand = Math.random()*(100 -1) + 1;
        	int randInt = rand.intValue();
        	BinaryTree.insert(randInt);
        	list.add(randInt);
        	x++;
        	
        }
        System.out.println("Randomly Generated numbers: ");
        System.out.println(list);
        System.out.println("_________________________________");
        
        System.out.print("\nPost order: ");
        BinaryTree.postorder();
        System.out.print("\nPre order: "); 
        BinaryTree.preorder();
        System.out.print("\nIn order: ");
        BinaryTree.inorder();
        
        

        
        
                         
    }
}


class Node        
{
    Node left, right;
    int data;

    /* Constructor */
    public Node(int n)
    {
        left = null;
        right = null;
        data = n;
    }         
}

/* Class BinaryTree */
class BinaryTree
{
    private Node root;

    /* Constructor */
    public BinaryTree()
    {
        root = null;
    }
    /* Functions to insert data */
    public void insert(int data)
    {
        root = insert(root, data);
    }
    /* Function to insert data recursively */
    private Node insert(Node node, int data)
    {
        if (node == null)
            node = new Node(data);
        else
        {
            if (data <= node.data)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }
    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(Node r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.data +" ");
            inorder(r.right);
        }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(Node r)
    {
        if (r != null)
        {
            System.out.print(r.data +" ");
            preorder(r.left);             
            preorder(r.right);
        }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(Node r)
    {
        if (r != null)
        {
            postorder(r.left);             
            postorder(r.right);
            System.out.print(r.data +" ");
        }
    }     
}

