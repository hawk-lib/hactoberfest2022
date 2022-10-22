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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        // preorder(ans,root);
        Stack<TreeNode> st = new Stack<>();
        if(root==null) return ans;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            ans.add(temp.val);
            if(temp.right!=null)st.push(temp.right); 
            if(temp.left!=null)st.push(temp.left);
            
        }
        return ans;
    } 
                  // using recursion method 
                  
    // public void preorder(List<Integer> list , TreeNode root){
    //     if(root==null) return;
    //     list.add(root.val);
    //     preorder(list,root.left);
    //     preorder(list,root.right);
    // }
}
