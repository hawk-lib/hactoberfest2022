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
    
    static List<Integer> arr = new ArrayList<Integer>();
    static void postorder(TreeNode root){
        if(root == null){
            return ;
        }
        postorder(root.left);
        postorder(root.right);
        arr.add(root.val);
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        arr=new ArrayList<>();
        postorder(root1);
        postorder(root2);
        Collections.sort(arr);
        return arr;
    }
}