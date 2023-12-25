//TIme Complexity O(n) - but catalan number = 2n* Cn / n+1
//Space complexity  = O(n) - It's also actually catalan number
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    public List<TreeNode> generateTrees(int start , int end) {
        List<TreeNode> result =  new ArrayList<>();

        if(start == end) {
                result.add(new TreeNode(start));
                return result;
        }
        if(start>end){
            result.add(null);
            return result;
        }
        for(int i = start;i<=end;i++) {
            List<TreeNode> leftSubTrees =generateTrees(start, i-1);
            List<TreeNode> rightSubTrees = generateTrees(i+1,end);

            for(TreeNode right: rightSubTrees){
                for (TreeNode left: leftSubTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right =right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
