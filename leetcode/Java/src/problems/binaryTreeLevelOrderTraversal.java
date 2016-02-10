package problems;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Martin on 15/06/2015.
 */

/**Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
     3
    / \
   9  20
      / \
     15  7
 return its level order traversal as:
 [[3], [9,20], [15,7]]
 *
 */


public class binaryTreeLevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        //problem 102
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curLevCnt = 1;
        int nextLevCnt = 0;
        ArrayList<Integer> levelres = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            curLevCnt--;
            levelres.add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
                nextLevCnt++;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextLevCnt++;
            }
            if (curLevCnt == 0) {
                curLevCnt = nextLevCnt;
                nextLevCnt = 0;
                res.add(levelres);
                levelres = new ArrayList<Integer>();
            }

        }
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
