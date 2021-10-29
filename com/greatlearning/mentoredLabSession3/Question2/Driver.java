package com.greatlearning.mentoredLabSession3.Question2;

import java.util.ArrayList;

class Node{
	
	int key;
	Node left,right;
	
	public Node(int key) {
		this.key = key;
		left = right = null;
	}
}
public class Driver {
	
	static ArrayList<Integer> getLongestPath(Node root){
		if(root == null)
			return new ArrayList<>();
		
		ArrayList<Integer> rightNode = getLongestPath(root.right);
		ArrayList<Integer> leftNode = getLongestPath(root.left);
		
		if(rightNode.size() < leftNode.size())
			leftNode.add(root.key);
		
		else
			rightNode.add(root.key);
		
		return leftNode.size() > rightNode.size() ? leftNode : rightNode;
	}

	public static void main(String[] args) {
		Node node1 = new Node(100);
		Node node2 = new Node(20);
		Node node3 = new Node(130);
		Node node4 = new Node(10);
		Node node5 = new Node(50);
		Node node6 = new Node(110);
		Node node7 = new Node(140);
		Node node8 = new Node(5);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;
		
		node4.left = node8;
		
		ArrayList<Integer> longestPath = getLongestPath(node1);
		System.out.print("Longest Path "+longestPath.get(longestPath.size() -1));
		for(int i=longestPath.size() -2; i>=0;i--) {
			
			System.out.print("->"+longestPath.get(i));
		}
	
	}

}
