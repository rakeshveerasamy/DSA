
//Time complexity O(n) , Space Complexity : O(n) -  due to recursion
class Solution {
    List<Integer> preOrderList = new LinkedList();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root!=null){
            preOrderList.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return preOrderList;
    }
}
