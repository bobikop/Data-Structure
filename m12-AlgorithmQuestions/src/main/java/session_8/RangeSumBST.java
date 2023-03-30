package session_8;

public class RangeSumBST {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(1);
        root.right=new TreeNode(4);
        root.right.left=new TreeNode(3);
        root.right.right=new TreeNode(6);
        System.out.println(rangeSumBST(root, 3, 6));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root==null) return 0;
       int ans=0;
        if (low <= root.val && root.val <= high)
            ans += root.val;
        ans+=rangeSumBST(root.left, 3, 6);
        ans+=rangeSumBST(root.right, 3, 6);
        return ans;
        // return ans+rangeSumBST(root.left, 3, 6)+ans+=rangeSumBST(root.right, 3, 6)
    }

}