package com.whs.javacode.hackerrank;

class Node4 {
	int data;
	Node4 left;
	Node4 right;

	Node4(int data) {
		this.data = data;
		left = right = null;
	}
}

public class binary_search_tree_impl {

	public static Node4 insert(Node4 root, int data) {
		if (root == null)
			return new Node4(data);
		else {
			Node4 cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}
	
	


	public static void main(String[] args) {

		int data[] = { 4, 2, 1, 3, 8, 9 };
		Node4 root = null;
		for (int i = 0; i < data.length; i++) {
			insert(root, data[i]);
		}

	}

}
