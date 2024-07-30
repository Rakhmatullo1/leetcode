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
        TreeNode leftRight = new TreeNode(3);
        TreeNode left = new TreeNode(2, null, leftRight);

        TreeNode rightRight = new TreeNode(3);
        TreeNode right = new TreeNode(2, null, rightRight);

        TreeNode root = new TreeNode(1);

        Main main = new Main();
        boolean result =  main.isSymmetric(root);

    }

    public boolean isSymmetric(TreeNode root) {
        List<Integer> leftResult = inorderLeft(root.left);
        List<Integer> rightResult = inorderRight(root.right);

        if(leftResult.size()!=rightResult.size()){
            return false;
        }

        for(int i=0; i<leftResult.size(); i++) {
            if(!Objects.equals(rightResult.get(i), leftResult.get(i))){
                return false;
            }
        }

        return true;
    }

    public List<Integer> inorderLeft(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }
        result.add(root.val);
        List<Integer> leftValues = inorderLeft(root.left);
        result.addAll(leftValues);
        List<Integer> rightValues = inorderLeft(root.right);
        if(leftValues.isEmpty() && !rightValues.isEmpty()) {
            result.add(null);
        }
        result.addAll(rightValues);
        return result;
    }

    public List<Integer> inorderRight(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }
        result.add(root.val);
        List<Integer> leftValues = inorderRight(root.right);
        result.addAll(leftValues);
        List<Integer> rightValues = inorderRight(root.left);
        if(leftValues.isEmpty() && !rightValues.isEmpty()) {
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