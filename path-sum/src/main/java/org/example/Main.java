package org.example;

import java.util.Objects;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        TreeNode left4 = new  TreeNode(-1);
//        TreeNode right4 = new TreeNode(2);
        TreeNode left3 = new TreeNode(1, left4, null);
        TreeNode right32 = new TreeNode(3);
        TreeNode left2 = new TreeNode(-2, left3, right32);

//        TreeNode right42= new TreeNode(1);
//        TreeNode right3 = new TreeNode(4, null, right42);
        TreeNode left32= new TreeNode(-2);
        TreeNode right2 = new TreeNode(-3, left32, null);

        TreeNode head = new TreeNode(1, left2, right2);

        Main main = new Main();
        main.hasPathSum(head, -1);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(Objects.isNull(root)) {
            return false;
        }

        if(targetSum - root.val == 0) {
            return true;
        }

        if(!Objects.isNull(root.left)) {
            if(hasPathSum(root.left, targetSum-root.val)){
                return true;
            };
        }

        if(!Objects.isNull(root.right)) {
            if(hasPathSum(root.right, targetSum-root.val)){
                return true;
            };
        }

        return false;
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
