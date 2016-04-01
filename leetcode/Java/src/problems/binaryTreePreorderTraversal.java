package problems;

import problems.ADT.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Martin on 01/04/2016.
 */
public class binaryTreePreorderTraversal {
    /**
     * Given a binary tree, return the preorder traversal of its nodes' values.
     For example:
     Given binary tree {1,#,2,3},
     1
      \
      2
     /
     3
     return [1,2,3].
     * @param root
     * @return
     */


    public static List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        stack.push(root);
        while (!stack.empty()) {
            //left -> right
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode test = new TreeNode(1);
        test.right = new TreeNode(2);
        test.right.left = new TreeNode(3);

        List<Integer> res = preorderTraversal(test);
        System.out.println(res);
    }
}
