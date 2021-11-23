package trees;

import java.util.Stack;

public class PreorderTraversal {
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

    void preorderRecursive(TreeNode root) {
        if( root == null) {
            return;
        }

        System.out.print(root.getVal());
        preorderRecursive(root.getLeft());
        preorderRecursive(root.getRight());
    }

    void preorderIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.empty()) {
            TreeNode current = s.pop();
            System.out.print(current.getVal());

            if (current.getRight() != null) {
                s.push(current.getRight());
            }

            if(current.getLeft() != null) {
                s.push(current.getLeft());
            }
        }
    }

    public static void main(String[] args) {
        PreorderTraversal preorder = new PreorderTraversal();
        TreeNode root = preorder.init();

        System.out.println("\n Recursive approach: ");
        preorder.preorderRecursive(root);

        System.out.println("\n Iterative approach: ");
        preorder.preorderIterative(root);
    }
}
