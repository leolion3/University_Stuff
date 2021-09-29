package Aufgabe04;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TreeHeightTest {

    @Test
    public void testTreeEmpty(){
        Assert.assertEquals(0,TreeHeight.treeHeight(null));
    }

    @Test
    public void testTreeHeight(){
        TreeNode node = new TreeNode(new TreeNode(new TreeNode(null,null),null),null);
        Assert.assertEquals(3,TreeHeight.treeHeight(node));
        TreeNode bigAssTree = new TreeNode(
                new TreeNode(
                        new TreeNode(null,null),null
                ),new TreeNode(new TreeNode(new TreeNode(new TreeNode(null,null),null),null),null)
        );
        Assert.assertEquals(5,TreeHeight.treeHeight(bigAssTree));
    }
}
