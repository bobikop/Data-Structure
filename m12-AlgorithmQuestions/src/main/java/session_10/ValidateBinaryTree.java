package session_10;

public class ValidateBinaryTree {
    public static void main(String[] args) {
    TreeNode root=new TreeNode(5);
    root.left=new TreeNode(1);
    root.right=new TreeNode(4);
    root.right.left=new TreeNode(3);
    root.right.right=new TreeNode(6);
        System.out.println(isValidBST(root));
    }
        public static boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public static boolean isValidBST(TreeNode root, long minVal, long maxVal) {
            if (root == null) return true;
            if (root.val >= maxVal || root.val <= minVal) return false;
            return isValidBST(root.left, minVal, root.val)
                    && isValidBST(root.right, root.val, maxVal);
        }

}