//Time compexity - O(N)
//Space Complexity -  O(N) - due to stack(recursion)

class Solution {
   
    public boolean isValidBST(TreeNode root) {
       
        return isValidBST(root, Long.MIN_VALUE,Long.MAX_VALUE);
        
    }
    public boolean isValidBST(TreeNode root, long min , long max) {
        if(root ==null ) return true;
        if(root.val<=min || root.val>=max) return false;
        return (isValidBST(root.left,(long)min,(long)root.val) && isValidBST(root.right,(long)root.val,(long)max));
    }
}
