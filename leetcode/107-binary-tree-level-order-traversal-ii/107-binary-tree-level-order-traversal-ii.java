/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       Queue<TreeNode> q=new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        if(root==null){
            return wrapList;
        }
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> sublist=new LinkedList<Integer>();
            for(int i=0;i<n;i++){
                if(q.peek().left!=null){
                    q.add(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.add(q.peek().right);
                }
                sublist.add(q.poll().val);
            }
            wrapList.add(0,sublist);
        }
        return wrapList;
    }
}