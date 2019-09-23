package Aufgabe04;

public class TreeNode<T> {
    TreeNode<T> left,right;

    /** Simple Node class */
    TreeNode(TreeNode<T> left,TreeNode<T> right){
        this.left=left;
        this.right=right;
    }

    /** @return the Node's left child */
    public TreeNode<T> getLeft(){
        return left;
    }

    /** @return the Node's right child */
    public TreeNode<T> getRight(){
        return right;
    }
}
