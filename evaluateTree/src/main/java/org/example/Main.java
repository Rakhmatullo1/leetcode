package org.example;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public static boolean evaluateTree(TreeNode root) {

        Boolean leftLeaf = null;
        Boolean rightLeaf = null;

        if(root.val==2 || root.val==3 ){
            if(!Objects.isNull(root.left) ) {
               leftLeaf = evaluateTree(root.left);
            }

            if(!Objects.isNull(root.right)) {
                rightLeaf = evaluateTree(root.right);
            }

            if(root.val == 2) {
                return leftLeaf || rightLeaf;
            }

            return leftLeaf && rightLeaf;
        }


        if(root.val==0){
            return false;
        }


        return  true;
    }


}