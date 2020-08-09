package treeNode.traverse;

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

public class PrintTree {
    public static void main(String[] args) {
        TreeNode root = creatTree();
        recursive(root);
    }

    // 创建一个底层结点(这个叫啥来着)
    private static TreeNode getBottomNode(int val){
        return new TreeNode(val, null, null);
    }

    private static TreeNode creatTree(){

        // layer 3
        TreeNode node2 = new TreeNode( 2 );
        TreeNode node3 = new TreeNode( 3 );

        // root
        TreeNode root = new TreeNode(1, node2, node3);

        return root;
    }

    public static void recursive(TreeNode node){

        int val = node.val;
        System.out.println(val);
        TreeNode left = node.left;
        TreeNode right = node.right;

        // 递归左树
        if( left != null ){
            recursive( left );
        }

        // 递归右树
        if( right != null ){
            recursive( right );
        }


    }
}
