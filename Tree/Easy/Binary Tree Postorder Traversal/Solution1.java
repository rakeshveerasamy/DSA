//TIme Complexity O(n) space complexity O(n) - due to recursion

class Solution {
    List<Integer> postOrderList = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root!=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            postOrderList.add(root.val);
        }
        return postOrderList;
    }
}
