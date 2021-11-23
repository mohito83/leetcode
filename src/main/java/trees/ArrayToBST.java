package src.main.java.trees;

public class ArrayToBST {
    TreeNode getMinimalBST (int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode root = buildBST(arr, 0, arr.length-1);
        return root;
    }

    TreeNode buildBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end)/2;
        TreeNode parent = new TreeNode(arr[mid]);
        parent.setLeft(buildBST(arr, start, mid-1));
        parent.setRight(buildBST(arr, mid+1, end));

        return parent;
    }

    private void printBST (TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, "", "", root);
        System.out.print(sb.toString());
    }

    void traversePreOrder(StringBuilder sb, String padding, String pointer, TreeNode node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getVal());
            sb.append("\n");

            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("│  ");

            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "└──";
            String pointerForLeft = (node.getRight() != null) ? "├──" : "└──";

            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.getLeft());
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.getRight());
        }
    }

    public static void main (String[] args) {
        int[] arr = {1,2,3,4,5,6};

        ArrayToBST arrayToBST = new ArrayToBST();
        TreeNode root = arrayToBST.getMinimalBST(arr);

        arrayToBST.printBST(root);
    }
}
