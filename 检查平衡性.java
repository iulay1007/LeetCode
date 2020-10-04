
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 检查平衡性 {
    int left,right;
    public boolean isBalanced(TreeNode root) {

        dfsleft(root.left);
        dfsright(root.right);

        if(Math.abs(left-right)<=1)
            return true;
        return false;

    }

    private int dfsright(TreeNode treeNode) {
if (treeNode==null)
    return 0;
        int count=0,result=0;
        if(treeNode.left!=null){
            count++;
           result+= count+dfsleft(treeNode.left);

        }
        return result;

    }

    private int dfsleft(TreeNode treeNode) {
        if (treeNode==null)
            return 0;

        int count=0,result=0;
        if(treeNode.right!=null){
            count++;
            result=count+ dfsleft(treeNode.right);

        }
        return result;
    }
}