package datastructures;

import data.people.Person;

public class BinarySearchTree<Item> {

    /**
     * Defines the structure of a node in the tree.
     */
    public class TreeNode<Item> {

        /** Item to store in the node. */
        // TODO: Find fix to set this to private and not have to worry about null point exceptions for .setItem used by .put(x)
        private Item mItem;

        /** Key that refers to this node. */
        private int mKey;

        /** Link to parent node. */
        private TreeNode<Item> mParent;  // if null, should theoretically be root

        /** Link to left child node. */
        private TreeNode<Item> mLeft;

        /** Link to right child node. */
        private TreeNode<Item> mRight;

        /** TreeNode constructor.
         * @param item The item to be stored.
         * @param key The key associated with the item.
         */
        public TreeNode(Item item, int key) {
            setItem(item);
            setKey(key);
        }

        public Item getItem() {
            return mItem;
        }

        public void setItem(Item mItem) {
            this.mItem = mItem;
        }

        public int getKey() {
            return mKey;
        }

        public void setKey(int mKey) {
            this.mKey = mKey;
        }

        public TreeNode<Item> getParent() {
            return mParent;
        }

        public void setParent(TreeNode<Item> mParent) {
            this.mParent = mParent;
        }

        public TreeNode<Item> getLeft() {
            return mLeft;
        }

        public void setLeft(TreeNode<Item> mLeft) {
            this.mLeft = mLeft;
        }

        public TreeNode<Item> getRight() {
            return mRight;
        }

        public void setRight(TreeNode<Item> mRight) {
            this.mRight = mRight;
        }

    }

    /** A reference to the root of our tree. */
    private TreeNode<Item> root;

    /**
     * Adds an item to the correct place in the binary search tree.
     * @param item The item to be stored.
     * @param key A unique or specific key that storage location is based on.
     */
    public void put(Item item, int key) {

        // search for the correct node to place our item in.
        TreeNode<Item> correctNode = search(getRoot(), key);

        // place our item there
        correctNode.setItem(item);


    }

    /**
     * Get an item from that tree based on its key.
     * @param key The key of the Item to get from the tree.
     * @return The item that the key is associated with or null if not in the tree.
     */
    public Item get(int key) {

        //TODO: Finish this class
        return null;

    }

    /**
     * Recursively searches the tree to find where a node is or should be based on a given key.
     * @param node The node to search.
     * @param key The key of the Item we are looking for.
     * @return The node where an item with this key is or should be.
     */
    private TreeNode<Item> search(TreeNode<Item> node, int key) {

        // if the tree is empty or node is a match
        if(isEmpty() || node.getKey() == key) {

            // return null if empty or correct node
            return node;
        }
        // recursively search left child's tree if key is smaller than current node
        else if (key < node.getKey()) {

            // recursively search left child's tree
            return search(node.getLeft(), key);
        }
        // recursively search right child's tree if key is larger than current node
        else if (key > node.getKey()) {

            // recursively search right child's tree
            return search(node.getLeft(), key);
        }
        // if the item is not in the tree
        else {

            // return null
            return null;
        }

    }

    private

    /**
     * Checks to see if the tree is empty.
     * @return Whether the tree is empty.
     */
    boolean isEmpty() {
        return getRoot() == null;
    }

    /** Getters and setters */

    public TreeNode<Item> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<Item> root) {
        this.root = root;
    }


    /** Main method for testing */
    public static void main(String[] Args ) {
        BinarySearchTree<Person> tree = new BinarySearchTree<Person>();


        tree.put(new Person(), 1);

        if (tree.isEmpty()) {
            System.out.println("Is Empty");
        }
    }

}
