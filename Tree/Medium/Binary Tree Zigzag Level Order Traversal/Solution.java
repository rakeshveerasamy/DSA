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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        TreeTraversal tt = new TreeTraversal(root);
        return tt.getResult();
    }
}
class TreeTraversal{
        private TreeNode root;
        private List<List<Integer>> res;
    
        TreeTraversal(TreeNode root){
                this.root =root;
                this.res=new ArrayList<>();
                initiateTraverse();
        }
    
        private void initiateTraverse(){
                Queue<TreeNode> que = new LinkedList<>();
                boolean flag = true;
                if(this.root!=null){
                        que.offer(this.root);
                }
                while(!que.isEmpty()){
                    int size = que.size();
                    List<Integer> temp = new ArrayList<>();
                    
                    while(size>0){
                            TreeNode curr =que.poll();
                            temp.add(curr.val);
                            if(curr.left!=null){
                                que.offer(curr.left);
                            }
                            if(curr.right!=null){
                                que.offer(curr.right);
                            }
                            size--;
                    }
                    if(!flag){
                        Collections.reverse(temp);
                    }
                    this.res.add(temp);
                    flag = !flag;
                }
        }
        public List<List<Integer>> getResult(){
                return this.res;
        }
}
