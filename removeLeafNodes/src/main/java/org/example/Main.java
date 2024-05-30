package org.example;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(!Objects.isNull(root.left)){
            removeLeafNodes(root.left, target);
        }

        if(!Objects.isNull(root.right)){
            removeLeafNodes(root.left, target);
        }

        if(root.val==target) {
            root = null;
        }

        return root;
    }

    public 
}