package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        TreeNode tail = new TreeNode(3);
        TreeNode mid = new TreeNode(2, tail, null);
        TreeNode root = new TreeNode(1, null, mid);

        Main main = new Main();
        main.inorderTraversal(root);

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }
        List<Integer> leftValues = inorderTraversal(root.left);

        if(Objects.isNull(leftValues)) {
            result.add(null);
        }

        result.addAll(leftValues);
        result.add(root.val);

        List<Integer> rightValues = inorderTraversal(root.right);
        if(Objects.isNull(rightValues)){
            result.add(null);
        }
        result.addAll(rightValues);
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