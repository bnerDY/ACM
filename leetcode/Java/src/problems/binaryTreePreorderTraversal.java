package problems;

import problems.ADT.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 01/04/2016.
 */
public class binaryTreePreorderTraversal {
    /**
     * Given a binary tree, return the preorder traversal of its nodes' values.
     * For example:
     * Given binary tree {1,#,2,3},
     * 1
     *  \
     *  2
     * /
     * 3
     * return [1,2,3].
     *
     * @param root
     * @return
     */

    static List<Integer> res = new ArrayList<>();

    public static List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        if (root != null) {
            traversal(root);
        }

        return res;
    }

    public static void traversal(TreeNode p) {
        res.add(p.val);
        if (p.left != null)
            traversal(p.left);
        if (p.right != null)
            traversal(p.right);
    }

//    public static List<Integer> preOrderTraversal(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        List<Integer> res = new ArrayList<>();
//
//        if (root == null) {
//            return res;
//        }
//
//        stack.push(root);
//        while (!stack.empty()) {
//            //left -> right
//            TreeNode node = stack.pop();
//            res.add(node.val);
//            if (node.right != null) {
//                stack.push(node.right);
//            }
//            if (node.left != null) {
//                stack.push(node.left);
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(2);
        test.right = new TreeNode(3);
        test.left.left = new TreeNode(4);
        test.left.right = new TreeNode(5);
        test.left.right.right = new TreeNode(7);
        test.right.left = new TreeNode(6);

        List<Integer> res = preOrderTraversal(test);
        System.out.println(res);
    }
}
