
class Solution {
    public int maxDepth(TreeNode root) {
       return findHeight(root,0);
    }
    public int findHeight(TreeNode root,int height){
        if(root == null){
            return height;
        }
        
        int leftHeight = findHeight(root.left,height+1);
        int rightHeight = findHeight(root.right,height+1);
        
        return Math.max(leftHeight,rightHeight);
            
    }
}
