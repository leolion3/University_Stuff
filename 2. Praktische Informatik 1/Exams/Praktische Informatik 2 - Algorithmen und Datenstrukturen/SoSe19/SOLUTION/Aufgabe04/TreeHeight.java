package Aufgabe04;

/**
 * Exercise 4: Determining the height of a Binary Tree ( 20 pts )
 *
 * No Java Libraries are permitted except for the "Math".
 */
@SuppressWarnings("all")
public class TreeHeight
{
    /**
     * Determines the height of a Binary Tree
     *
     * @param root The root of the Tree. Can be null!
     *
     * @return The height of the tree. It only counts the nulls as Nodes!
     */

    public static int treeHeight(final TreeNode root)
    {
        return root==null?
                0 : root.getLeft()!=null&&root.getRight()!=null?
                    1+Math.max(treeHeight(root.getLeft()),treeHeight(root.getRight()))
                        :root.getRight()!=null? 1+treeHeight(root.getRight()) : root.getLeft()!=null?
                            1+treeHeight(root.getLeft()) : 1;
    }
}
