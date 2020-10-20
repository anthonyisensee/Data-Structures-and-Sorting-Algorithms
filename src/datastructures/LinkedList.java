package datastructures;

import data.people.Person;

import java.util.Iterator;

/**
 * A custom linked list class.
 * @param <Item> Whatever type of object you decide to store in the list.
 * @author anthonyisensee
 */
public class LinkedList<Item> implements Iterable<Item>{

    /** Defines the nodes in our linked list. */
    public class Node<Item> {
        Item item;
        Node<Item> next;

        public Item getItem() {
            return item;
        }
    }

    /** Number of items in the list. */
    private int mNumberOfItems;

    /** First Node */
    private Node<Item> mFirst;

    public int getNumberOfItems() {
        return mNumberOfItems;
    }

    public Node<Item> getFirst() {
        return mFirst;
    }
/* Last Node
    private Node mLast; */

    /** Constructor */
    public LinkedList() {
        mNumberOfItems = 0;
    }

    /** Iterator class */
    public Iterator<Item> iterator() { return new ItemIterator<>(this); }

    /** Iterator specific to this class */
    class ItemIterator<Item> implements Iterator<Item> {

        // keep track of our current node
        private LinkedList<Item>.Node<Item> i;

        public ItemIterator(LinkedList<Item> list) {
            i = list.getFirst();
        }

        @Override
        public boolean hasNext() {
            // if no next
            if (i.next == null) {
                return false;
            }
            // if there is a next
            else {
                return true;
            }

        }

        @Override
        public Item next() {
            // return the next piece of data in the LinkedList and advance node by one
            Item returnItem = i.next.getItem();
            i = i.next;
            return returnItem;
        }

        @Override
        public void remove() {
            // not supported
        }
    }

    /**
     * Add an item to the beginning of the linked list.
     * @param item Item to be added to the list.
     */
    public void addItem(Item item) {

        // create new node
        Node<Item> newNode = new Node<Item>();

        // populate new node with item
        newNode.item = item;

        // links the new node to the old first node
        newNode.next = mFirst;  // the first node added will link to null. That's okay.

        // sets mFirst to our newNode so that we can keep track of where our list starts.
        mFirst = newNode;

        // adds one to the number of items
        ++mNumberOfItems;

    }

    /**
     * Will return true if the linked list is empty.
     */
    public boolean isEmpty() {

        // if mFirst is not assigned, LinkedList is empty.
        if (mFirst == null) {
            return true;
        }
        // if mFirst is assigned, LinkedList has items.
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        LinkedList mPeopleLinkedList = new LinkedList<Person>();
        mPeopleLinkedList.addItem(new Person("Bill", 25));
        System.out.print(mPeopleLinkedList.isEmpty());

        // TODO: Diagnose why this ranged based loop does not work.
        /*
        for (Person p : mPeopleLinkedList) {
            System.out.println(p.mName);
        }
        */
    }
}
