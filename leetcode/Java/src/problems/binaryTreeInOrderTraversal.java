package problems;

import problems.ADT.TreeNode;

import java.util.ArrayList;
import java.util.List;
//TODO
/**
 * Created by Martin on 10/02/2016.
 */

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
        1
         \
         2
        /
        3
 return [1,3,2].
 */
public class binaryTreeInOrderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        if(root.left != null){
            inorderTraversal(root.left);
        }
        if(root.right != null){
            inorderTraversal(root.right);
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(root));
    }
}
