package company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// A basic doubly linked list implementation. ∗/
public class DoubleLinkedList<Interger> {
    private int columnCount;
    private int rowCount;



//        // node of linked list
//    static class Node {
//        int data;
//        Node right;
//        Node down;
//        int rowCount;
//        int columnCount;
//    };
//
//    // returns head pointer of linked list
//    // constructed from 2D matrix
//    static Node construct(String inputFile) {
//        BufferedReader br = null;
//        FileReader fr = null;
//        int rowCount = 0;
//        int columnCount = 0;
//        int tempColumnCount = 0;
//        String currentLine;
//        String[] currentRowArray;
//        Node temp = new Node();
//
//        try {
//
//            fr = new FileReader(inputFile);
//            br = new BufferedReader(fr);
//
//            while ((currentLine = br.readLine()) != null) {
//                rowCount++;
//
//
//                currentRowArray = currentLine.split(" ");
//
//
//                for (String currentElement : currentRowArray) {
//                    if (rowCount == 0) {
//
//                        for (int i = 0; i < columnCount; i++) {
//                            temp = temp.right;
//                        }
//                        temp.data = Integer.parseInt(currentElement);
//                    }
//
//                    if (rowCount == 1)
//                        columnCount++;
//
//
//                    else {
//                        for (int i = 0; i < rowCount; i++) {
//                            temp = temp.down;
//                        }
//                        if (tempColumnCount == 0) {
//                            temp.data = Integer.parseInt(currentElement);
//                        } else {
//                            for (int i = 0; i < tempColumnCount; i++) {
//                                temp = temp.right;
//                            }
//                            temp.data = Integer.parseInt(currentElement);
//                        }
//                    }
//                }
//            }
//            fr.close();
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // return if i or j is out of bounds
//        return temp;
//    }
//
//    // utility function for displaying
//    // linked list data
//    static void display(Node head) {
//
//        // pointer to move right
//        Node Rp;
//
//        // pointer to move down
//        Node Dp = head;
//
//        // loop till node->down is not NULL
//        while (Dp != null) {
//            Rp = Dp;
//
//            // loop till node->right is not NULL
//            while (Rp != null) {
//                System.out.print(Rp.data + " ");
//                Rp = Rp.right;
//            }
//            System.out.println();
//            Dp = Dp.down;
//        }
//    }

    // driver program


    //---------------- nested Node class ----------------
    private static class Node<Interger> {
        private Interger element;
        private Node<Interger> down;
        private Node<Interger> right;


        public Node(Interger e, Node<Interger> d, Node<Interger> n) {
            element = e;
            down = d;
            right = n;
        }

        public Interger getElement() {
            return element;
        }

        public void setElement(Interger element) {
            this.element = element;
        }

        public Node<Interger> getDown() {
            return down;
        }

        public Node<Interger> getRight() {
            return right;
        }


        public void setDown(Node<Interger> d) {
            down = d;
        }

        public void setRight(Node<Interger> n) {
            right = n;
        }
    } //----------- end of nested Node class -----------

    // instance variables of the DoublyLinkedList
    private Node<Interger> header; // header sentinel
    private Node<Interger> row;
    private Node<Interger> column; // trailer sentinel
    private int size = 0;
    private Node<Interger> currentElement;
    private Node<Interger> oneRowUp;// number of elements in the list

    // // Constructs a new empty list. ∗/
    public DoubleLinkedList() {
        header = new Node<>(null, null, null); // create header
        header.setDown(rowNode());
        header.setRight(columnNode());
        currentElement = header;
        // trailer is preceded by header

        // header is followed by trailer
    }

    public DoubleLinkedList(Interger firstElement) {
        header = new Node<>(firstElement, null, null);
        header.setRight(columnNode());
        header.setDown(rowNode());
        currentElement = header;
    }

    public Node getHead() {

        return header;
    }




    public void setOneRowUp(Node nodeBelow, int currentRow, int currentColumn) {
        oneRowUp = header;
        for (int i = 0; i < currentRow-1; i++) {
            oneRowUp = header.getDown();
        }
        for (int i = 0; i < currentColumn-1; i++) {
            oneRowUp = oneRowUp.getRight();
        }
        oneRowUp.setDown(nodeBelow);

    }

    public Node getOneRowUp() {
        return oneRowUp;
    }

    public Node rowNode() {
        row = new Node<>(null, null, null);
        return row;
    }

    public Node rowNode(Interger element) {
        row = new Node<>(element, null, null);
        return row;
    }

    public Node columnNode() {
        column = new Node<>(null, null, null);
        return column;
    }

    public Node columnNode(Node down, Node right) {
        column = new Node<>(null, down, right);
        return column;
    }


    // Returns the number of elements in the linked list. ∗/
    public int size() {
        return size;
    }

    // Tests whether the linked list is empty. ∗/
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns (but does not remove) the first element of the list. ∗/
    public Interger first() {
        if (isEmpty()) return null;
        return header.getElement(); // first element is beyond header
    }

    // Returns (but does not remove) the last element of the list. ∗/


    // Adds element e to the front of the list. ∗/
    public void addColumn(Interger e, int row, int columnCount) {


      +  currentElement = currentElement.getRight();
        currentElement.setElement(e);
        currentElement.setRight(columnNode());
        setOneRowUp(currentElement, row, columnCount);
         // place just after the header
    }

    public void addRow(Interger e, int row, int columnCount) {
        currentElement = header;
        for (int i = 0; i < row-1
                ; i++) {
            currentElement = currentElement.getDown();
            if (currentElement.getElement() == null){
                currentElement.setDown(rowNode());
                currentElement.setRight(columnNode());
            }
        }


        currentElement.setElement(e);


        setOneRowUp(currentElement, row, columnCount);

    }

    public void displayMatrix (Node header) {
        currentElement = header;
        int tempRowCount = 0;

        while (currentElement.getElement() != null) {
            System.out.print(currentElement.getElement()+ " ");
            currentElement = currentElement.getRight();
        }

//        while (currentElement.getDown() != null & currentElement.getRight()!=null) {
//            while (currentElement.getElement() != null) {
//                System.out.print(currentElement.getElement());
//                currentElement = currentElement.getRight();
//            }
//            tempRowCount++;
//            currentElement = header
        }


//        for (int i = 0; i < rowCount; i++) {
//            currentElement = currentElement.getDown();
//
//            for (int j = 0; j < rowCount; j++) {
//                System.out.print(currentElement.getElement());
//                currentElement = currentElement.getRight();
//            }
////            currentElement = header;
//        }




    public int getColumnCount() {
        return columnCount;
    }

    public int getRowCount() {
        return rowCount;
    }


    public  DoubleLinkedList buildMatrix(String inputFile) {






        rowCount = 0;
        columnCount = 0;
        int tempColumnCount;


        DoubleLinkedList currentMatrix;



            BufferedReader br = null;
            FileReader fr = null;
            rowCount = 0;
            columnCount = 0;
            String currentLine;
            String[] currentRowArray;
            currentMatrix = new DoubleLinkedList();
            Node rowAbove;


            try {

                fr = new FileReader(inputFile);
                br = new BufferedReader(fr);

                while ((currentLine = br.readLine()) != null) {
                    rowCount++;
                    tempColumnCount = 0;


                    currentRowArray = currentLine.split(" ");


                    for (String currentInteger : currentRowArray) {
                        if (rowCount == 1) {
                            if ((columnCount == 0 && rowCount == 1)) {
                                currentMatrix = new DoubleLinkedList(Integer.parseInt(currentInteger));
                                columnCount++;
                            }
                            else  {
                                currentMatrix.addColumn(currentInteger,rowCount, columnCount);
                                columnCount++;
                            }
                        }


                        if(rowCount > 1) {
                            if (tempColumnCount <1) {
                                currentMatrix.addRow(currentInteger, rowCount, columnCount);
                                tempColumnCount ++;


                            }
                            else {
                                currentMatrix.addColumn(currentInteger,rowCount, columnCount);
                            }
                        }



                    }
                }
                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        return currentMatrix;

    }
    }

//----------- end of DoublyLinkedList class -----------
