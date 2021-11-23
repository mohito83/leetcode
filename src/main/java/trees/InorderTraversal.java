package src.main.java.trees;

import java.util.Stack;

public class InorderTraversal {
    private TreeNode root;

    TreeNode init() {
        TreeNode root = new TreeNode(1);
        TreeNode n = new TreeNode(2);
        root.setLeft(n);
        n = new TreeNode(3);
        root.setRight(n);
        n = new TreeNode(4);
        root.getLeft().setLeft(n);
        n = new TreeNode(5);
        root.getLeft().setRight(n);
        n = new TreeNode(6);
        root.getLeft().getRight().setLeft(n);
        n = new TreeNode(7);
        root.getRight().setRight(n);
        return root;
    }

    void inorderRecursive(TreeNode root) {
        if( root == null) {
            return;
        }
        inorderRecursive(root.getLeft());
        System.out.print(root.getVal());
        inorderRecursive(root.getRight());
    }

    void inorderIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;

        while (current != null || !s.empty()) {
            if (current != null) {
                s.push(current);
                current = current.getLeft();
            } else {
                current = s.pop();
                System.out.print(current.getVal());
                current = current.getRight();
            }

        }
    }

    public static void main(String[] args) {
        InorderTraversal inorder = new InorderTraversal();
        TreeNode root = inorder.init();

        System.out.println("\n Recursive approach: ");
        inorder.inorderRecursive(root);

        System.out.println("\n Iterative approach: ");
        inorder.inorderIterative(root);
    }
}
