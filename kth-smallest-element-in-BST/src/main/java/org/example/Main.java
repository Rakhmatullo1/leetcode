package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        TreeNode leftRight = new TreeNode(2);
        TreeNode left = new TreeNode(1, null, leftRight);
        TreeNode right = new TreeNode(4);
        TreeNode root = new TreeNode(3, left, right);

        Main main = new Main();
       main.kthSmallest(root,1);

    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = toList(root);
        Collections.sort(nums);
        return nums.get(k-1);
    }

    public List<Integer> toList(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        if(Objects.isNull(treeNode)){
            return result;
        }

        result.addAll(toList(treeNode.left));
        result.add(treeNode.val);
        result.addAll(toList(treeNode.right));
        return result;
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