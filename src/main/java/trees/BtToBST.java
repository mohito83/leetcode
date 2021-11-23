package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BtToBST {
    private static int index=0;
    public static void main(String[] args) {
        BtToBST btToBST = new BtToBST();

        TreeNode root = btToBST.buildBT();
        btToBST.printTree(root);

        List<Integer> list = new ArrayList<>();
        btToBST.inorderBT(root, list);

        Collections.sort(list);

        btToBST.convertToBST(root, list);
        System.out.println();
        btToBST.printTree(root);
    }

    private void inorderBT(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderBT(root.getLeft(), list);
        list.add(root.getVal());
        inorderBT(root.getRight(), list);
    }

    TreeNode buildBT() {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(4));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(2));
        root.getLeft().setRight(new TreeNode(5));

        return root;
    }

    void printTree(TreeNode root) {
        //Inorder print
        if(root == null) {
            return;
        }
        printTree(root.getLeft());
        System.out.print(root.getVal() + "\t");
        printTree(root.getRight());
    }

    void convertToBST(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        convertToBST(root.getLeft(), list);
        root.setVal(list.get(index));
        index = index + 1;
        convertToBST(root.getRight(), list);
    }

    void swap (TreeNode r1 , TreeNode r2) {
        int temp = r1.getVal();
        r1.setVal(r2.getVal());
        r2.setVal(temp);
    }
}
