package org.example;

import java.util.Objects;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        TreeNode rightRightLeftRight = new TreeNode(30);
        TreeNode rightRightLeft = new TreeNode(30, null, rightRightLeftRight);
        TreeNode rightRight = new TreeNode(7, rightRightLeft, null);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode right = new TreeNode(20, rightLeft, rightRight);

        TreeNode left = new TreeNode(9);
        TreeNode root = new TreeNode(3, left, right);

        Main main = new Main();
        int result = main.maxDepth(root);
    }

    public int maxDepth(TreeNode root) {
        return  calculate(root);
    }

    private int calculate(TreeNode root) {
        if(Objects.isNull(root.right) && Objects.isNull(root.left)){
            return 1;
        }
        int depthRight=0;
        int depthLeft=0;
        if(Objects.nonNull(root.left)){
            depthLeft =depthLeft+ calculate(root.left);
        }

        if(Objects.nonNull(root.right)) {
            depthRight =depthRight+ calculate(root.right);
        }

        return Math.max(depthLeft, depthRight)+1;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}