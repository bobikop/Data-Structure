package session_12;

import java.util.*;

public class LCA {

    public static void main(String[] args) {
      TreeNode root=new TreeNode(3);
        TreeNode node1=new TreeNode(5);
        TreeNode node2=new TreeNode(1);
        TreeNode node3=new TreeNode(6);
        TreeNode node4=new TreeNode(2);
        TreeNode node5=new TreeNode(7);
        TreeNode node6=new TreeNode(0);
        TreeNode node7=new TreeNode(8);
        TreeNode node8=new TreeNode(4);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node4.left=node5;
        node4.right=node8;
        node2.left=node6;
        node2.right=node7;
        System.out.println(lowestCommonAncestor(root, node3, node6).val);

    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Termination
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }

    // Iterartive solution
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}