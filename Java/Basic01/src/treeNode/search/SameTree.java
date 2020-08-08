package treeNode.search;

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private static ArrayList<Integer> tree1 = new ArrayList<>();
    private static ArrayList<Integer> tree2 = new ArrayList<>();
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<Integer> tree1Res = new ArrayList<>();
        ArrayList<Integer> tree2Res = new ArrayList<>();
        tree1Res = SameTree.recursive(p, tree1);
        tree2Res = SameTree.recursive(q, tree2);

        System.out.println("tree1" + tree1Res);
        System.out.println("tree2" + tree2Res);

        if ( tree1Res.equals(tree2Res) ){
            return true;
        }
        else {
            return false;
        }
    }
}

public class SameTree {
    private static ArrayList<Integer> tree = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root1 = creatTree1();
        TreeNode root2 = creatTree2();
        Solution sameTree = new Solution();
        boolean isSame = sameTree.isSameTree(root1, root2);
        System.out.println(isSame);
    }

    // 创建一个底层结点(这个叫啥来着)
    private static TreeNode getBottomNode(int val){
        return new TreeNode(val, null, null);
    }

    private static TreeNode creatTree1(){

        // layer 3
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );

        // root
        TreeNode root = new TreeNode();

        return root;
    }
    private static TreeNode creatTree2(){
        // layer 2
        TreeNode node2 = new TreeNode(2);

        // root
        TreeNode root = new TreeNode();

        return root;
    }

    public static ArrayList<Integer> recursive(TreeNode node, ArrayList<Integer> treeArray){

        int val = node.val;
        treeArray.add(val);
        TreeNode left = node.left;
        TreeNode right = node.right;

        // 递归左树
        if( left != null ){
            recursive( left, treeArray );
        }else {
            treeArray.add(null);
        }

        // 递归右树
        if( right != null ){
            recursive( right, treeArray );
        }else {
            treeArray.add(null);
        }

        return treeArray;

    }
}
