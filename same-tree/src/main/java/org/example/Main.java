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
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(1);
        TreeNode root = new TreeNode(1, left, left);
        TreeNode root1 = new TreeNode(1, null, right);
        Main main = new Main();
        main.isSameTree(root, root1);

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pList = inorder(p);
        List<Integer> qList = inorder(q);


        if(pList.size() !=qList.size()) {
            return false;
        }

        for(int i=0; i<pList.size(); i++) {
            if(!Objects.equals(pList.get(i), qList.get(i))) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }
        result.add(root.val);
        List<Integer> leftValues = inorder(root.left);

        result.addAll(leftValues);
        List<Integer> rightValues = inorder(root.right);
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