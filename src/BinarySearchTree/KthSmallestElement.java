package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
 */
public class KthSmallestElement {
    // Recursive approach implemented
    private static void kthSmallestHelper(TreeNode root, int k, List<Integer> list) {
        if (root != null) {
            if (root.left != null) kthSmallestHelper(root.left, k, list);

            list.add(root.val);

            if (root.right != null) kthSmallestHelper(root.right, k, list);
        }
    }

    private static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        kthSmallestHelper(root, k, list);
        return list.get(k - 1);
    }

    public static void main(String[] args) {
        /*
                    3
                 1     4
                   2
         */
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(1);
        TreeNode rootRight = new TreeNode(4);
        TreeNode leafRight = new TreeNode(2);

        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.right = leafRight;

        int output = kthSmallest(root, 2);
        System.out.println("Smallest value is " + output);
    }
}
