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
    static List<Integer> res = new ArrayList<>();

    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return res;
        }
        if(root !=null){
            traversal(root);
        }

        return res;
    }

    public static void traversal(TreeNode p){
        if(p.left!=null)
            traversal(p.left);

        res.add(p.val);

        if(p.right!=null)
            traversal(p.right);
    }

//    non-recursive way.
//    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        ArrayList<Integer> result = new ArrayList<>();
//        TreeNode curt = root;
//        while (curt != null || !stack.empty()) {
//            while (curt != null) {
//                stack.add(curt);
//                curt = curt.left;
//            }
//            curt = stack.peek();
//            stack.pop();
//            result.add(curt.val);
//            curt = curt.right;
//        }
//        return result;
//    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(root));
    }
}
