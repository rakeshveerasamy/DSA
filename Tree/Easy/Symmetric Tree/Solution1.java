//Time Complexity -  O(n)
//Space Complexity - O(n) - due to stack of recursion
class Solution {
    public boolean isSame(TreeNode p , TreeNode  q){
        if(p == null && q == null) return true;
        if(p == null || q == null ) return false;
        if(p.val!=q.val) return false;
        return isSame(p.right,q.left) && isSame(p.left,q.right);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null ) return true;

        return isSame(root.left,root.right);
    }
}
