import org.junit.Assert;
import org.junit.Test;

public class SimpleTreeTest {

    @Test (expected = IllegalArgumentException.class)
    public void testSimpleTree(){
        SimpleTree<Integer> tree = new SimpleTree<>();
        Assert.assertEquals(0,tree.getHeight());
        tree.setRoot(0);
        Assert.assertEquals(0,(int)tree.getRoot().getKey());
        tree.add(1,tree.getRoot());
        Assert.assertEquals(1,(int)tree.getRoot().getLeftChild().getKey());
        tree.add(2,tree.getRoot());
        Assert.assertEquals(1,(int)tree.getRoot().getLeftChild().getKey());
        Assert.assertEquals(2,(int)tree.getRoot().getRightChild().getKey());
        Assert.assertEquals(2,tree.getHeight());
        Assert.assertEquals(1,tree.getHeightFromSpecificNode(tree.getRoot().getLeftChild()));
        tree.add(5,tree.getRoot());
        Assert.assertEquals(0,tree.getHeightFromSpecificNode(null));
    }
}
