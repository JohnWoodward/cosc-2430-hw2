package company;

// A basic doubly linked list implementation. ∗/
public class DoubleLinkedList<E> {

    // node of linked list
    static class Node {
        int data;
        Node right;
        Node down;
    };

    // returns head pointer of linked list
    // constructed from 2D matrix
    static Node construct(int arr[][], int i, int j,
                          int m, int n) {

        // return if i or j is out of bounds
        if (i > n - 1 || j > m - 1)
            return null;

        // create a new node for current i and j
        // and recursively allocate its down and
        // right pointers
        Node temp = new Node();
        temp.data = arr[i][j];
        temp.right = construct(arr, i, j + 1, m, n);
        temp.down = construct(arr, i + 1, j, m, n);
        return temp;
    }

    // utility function for displaying
    // linked list data
    static void display(Node head) {

        // pointer to move right
        Node Rp;

        // pointer to move down
        Node Dp = head;

        // loop till node->down is not NULL
        while (Dp != null) {
            Rp = Dp;

            // loop till node->right is not NULL
            while (Rp != null) {
                System.out.print(Rp.data + " ");
                Rp = Rp.right;
            }
            System.out.println();
            Dp = Dp.down;
        }
    }

    // driver program
    public static void main(String args[]) {
        // 2D matrix
        int arr[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };

        int m = 3, n = 3;
        Node head = construct(arr, 0, 0, m, n);
        display(head);
    }

}
//---------------- nested Node class ----------------
//    private static class Node<E> {
//        private E element;
//        private Node<E> down;
//        private Node<E> right;
//
//        public Node(E e, Node<E> p, Node<E> n) {
//            element = e;
//            down = p;
//            right = n;
//        }
//
//        public E getElement() {
//            return element;
//        }
//
//        public Node<E> getPrev() {
//            return down;
//        }
//
//        public Node<E> getNext() {
//            return right;
//        }
//
//        public void setPrev(Node<E> p) {
//            down = p;
//        }
//
//        public void setNext(Node<E> n) {
//            right = n;
//        }
//    } //----------- end of nested Node class -----------
//
//    // instance variables of the DoublyLinkedList
//    private Node<E> header; // header sentinel
//    private Node<E> trailer; // trailer sentinel
//    private int size = 0; // number of elements in the list
//
//    // // Constructs a new empty list. ∗/
//    public DoubleLinkedList() {
//        header = new Node<>(null, null, null); // create header
//        trailer = new Node<>(null, header, null); // trailer is preceded by header
//
//        header.setNext(trailer); // header is followed by trailer
//    }
//
//    static Node construct(int arr[][], int i, int j,
//                          int m, int n) {
//
//        // return if i or j is out of bounds
//        if (i > n - 1 || j > m - 1)
//            return null;
//
//        // create a new node for current i and j
//        // and recursively allocate its down and
//        // right pointers
//        Node temp = new Node();
//        temp.data = arr[i][j];
//        temp.right = construct(arr, i, j + 1, m, n);
//        temp.down = construct(arr, i + 1, j, m, n);
//        return temp;
//    }
//
//    // Returns the number of elements in the linked list. ∗/
//    public int size() {
//        return size;
//    }
//
//    // Tests whether the linked list is empty. ∗/
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    // Returns (but does not remove) the first element of the list. ∗/
//    public E first() {
//        if (isEmpty()) return null;
//        return header.getNext().getElement(); // first element is beyond header
//    }
//
//    // Returns (but does not remove) the last element of the list. ∗/
//    public E last() {
//        if (isEmpty()) return null;
//        return trailer.getPrev().getElement(); // last element is before trailer
//    }
//
//    // Adds element e to the front of the list. ∗/
//    public void addFirst(E e) {
//        addBetween(e, header, header.getNext()); // place just after the header
//    }
//
//    // Adds element e to the end of the list. ∗/
//    public void addLast(E e) {
//        addBetween(e, trailer.getPrev(), trailer); // place just before the trailer
//    }
//
//    // Removes and returns the first element of the list. ∗/
//    public E removeFirst() {
//        if (isEmpty()) return null; // nothing to remove
//        return remove(header.getNext()); // first element is beyond header
//    }
//
//    // Removes and returns the last element of the list. ∗/
//    public E removeLast() {
//        if (isEmpty()) return null; // nothing to remove
//        return remove(trailer.getPrev()); // last element is before trailer
//    }
//
//    // private update methods
//    // Adds element e to the linked list in between the given nodes. ∗/
//    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
//        // create and link a new node
//        Node<E> newest = new Node<>(e, predecessor, successor);
//        predecessor.setNext(newest);
//        successor.setPrev(newest);
//        size++;
//    }
//
//    // Removes the given node from the list and returns its element. ∗/
//    private E remove(Node<E> node) {
//        Node<E> predecessor = node.getPrev();
//        Node<E> successor = node.getNext();
//        predecessor.setNext(successor);
//        successor.setPrev(predecessor);
//        size--;
//        return node.getElement();
//    }
//----------- end of DoublyLinkedList class -----------
