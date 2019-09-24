/** Implements a simple tree, where the first element is always
 * added to the left and the second element to the right tree node */
@SuppressWarnings("all")
public class SimpleTree<T> {

    private Node<T> root;

    /** @return the Tree's root */
    public Node<T> getRoot(){
        return root;
    }

    /** Set the Tree's root
     * @param key - the element to store in the root */
    public void setRoot(T key){
        root= new Node<>(null,null,key);
    }

    /** Add an element to the tree
     * @param key - the element to add to the tree
     * @param parent - the element's parent Node */
    public void add(T key,Node<T> parent){
        if (parent.getLeftChild()==null){
            parent.setLeftChild(new Node<>(null,null,key));
        }
        else if (parent.getRightChild()==null){
            parent.setRightChild(new Node<>(null,null,key));
        }
        else{
            throw new IllegalArgumentException("The parent already has the maximum Node amount!");
        }
    }

    /** @return the tree's entire height */
    public int getHeight(){
        return root==null? 0 : getHeightFromSpecificNode(root);
    }

    /** @return the tree's height starting at a specific node
     * @param node - the node to start calculating the height at */
    public int getHeightFromSpecificNode(Node<T> node){
        return node==null?
                0:node.getRightChild()!=null&&node.getLeftChild()!=null?
                1+ Math.max(getHeightFromSpecificNode(node.getRightChild()),
                        getHeightFromSpecificNode(node.getLeftChild()))
                : node.getLeftChild()!=null? 1 + getHeightFromSpecificNode(node.getLeftChild())
                : node.getRightChild()!=null? 1 + getHeightFromSpecificNode(node.getRightChild())
                : 1;
    }

    /** Inner class Node, many Nodes make up one tree */
    public class Node<T>{

        /** Each Node has a left and a right child */
        private Node<T> left,right;
        private T key;

        public Node(Node<T> left, Node<T> right,T key){
            this.left=left;
            this.right=right;
            this.key=key;
        }

        /** @return the Node's left child */
        public Node<T> getLeftChild(){
            return left;
        }

        /** Set the Node's left child
         * @param child - the new left child of the Node */
        public void setLeftChild(Node<T> child){
            this.left=child;
        }

        /** @return the Node's right child */
        public Node<T> getRightChild(){
            return right;
        }

        /** Set the Node's right child
         * @param child - the new right child of the Node */
        public void setRightChild(Node<T> child){
            this.right=child;
        }

        /** @return the key stored in the Node */
        public T getKey(){
            return key;
        }

        /** Set the Node's key
         * @param key - the new key to be stored in the Node */
        public void setKey(T key){
            this.key=key;
        }
    }
}
