package trees;

import java.util.Stack;

public class PostorderTraversal {
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

    void postorderRecursive(TreeNode root) {
        if( root == null) {
            return;
        }
        postorderRecursive(root.getLeft());
        postorderRecursive(root.getRight());

        System.out.print(root.getVal());
    }

    void postorderIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;
        TreeNode pre = null;

        while (current != null || !s.empty()) {
            if (current != null) {
                s.push(current);
                current = current.getLeft();
            } else {
                current = s.peek();

                if (current.getRight() == null || pre == current.getRight()) {
                    System.out.print(current.getVal());
                    s.pop();
                    pre = current;
                    current = null;
                } else {
                    current = current.getRight();
                }
            }
        }
    }

    public static void main(String[] args) {
        PostorderTraversal postorder = new PostorderTraversal();
        TreeNode root = postorder.init();

        System.out.println("\n Recursive approach: ");
        postorder.postorderRecursive(root);

        System.out.println("\n Iterative approach: ");
        postorder.postorderIterative(root);
    }
}
