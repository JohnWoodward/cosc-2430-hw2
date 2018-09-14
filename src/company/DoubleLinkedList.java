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

        public int getElementInt() {
            String i = "" + element;
            int elementInt = Integer.parseInt(i);

            return elementInt;

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
    public void addColumn(Interger e) {


        currentElement = currentElement.getRight();
        currentElement.setElement(e);
        currentElement.setRight(columnNode());

        // place just after the header
    }

    public void addRow(Interger e, int row) {
        currentElement = header;
        for (int i = 0; i < row - 1; i++) {
            currentElement = currentElement.getDown();
            if (currentElement.getElement() == null) {
                currentElement.setDown(rowNode());
                currentElement.setRight(columnNode());
            }
        }
        currentElement.setElement(e);
    }

    public void downPointers(DoubleLinkedList inputMatrix) {
        Node elementAbove = inputMatrix.getHead();
        currentElement = elementAbove.getDown();
        int tempRowCount = 1;

        while (currentElement.getElement() != null) {
            while (currentElement.getElement() != null) {
                elementAbove.setDown(currentElement);
                currentElement = currentElement.getRight();
                elementAbove = elementAbove.getRight();
            }

            tempRowCount++;
            System.out.print("\n");
            currentElement = inputMatrix.getHead();
            elementAbove = inputMatrix.getHead();
            for (int i = 0; i < tempRowCount; i++) {
                currentElement = currentElement.getDown();
            }
            for (int i = 0; i < tempRowCount - 1; i++) {
                elementAbove = elementAbove.getDown();
            }
        }
    }


    public void displayMatrix(Node header) {
        currentElement = header;
        int tempRowCount = 0;

        while (currentElement.getElement() != null) {
            while (currentElement.getElement() != null) {
                System.out.print(currentElement.getElement() + " ");
                currentElement = currentElement.getRight();

            }
            tempRowCount++;
            System.out.print("\n");
            currentElement = header;
            for (int i = 0; i < tempRowCount; i++) {
                currentElement = currentElement.getDown();
            }
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


    public DoubleLinkedList buildMatrix(String inputFile) {


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
                            currentMatrix = new DoubleLinkedList(Integer.valueOf(currentInteger));
                            columnCount++;
                        } else {
                            currentMatrix.addColumn(currentInteger);
                            columnCount++;
                        }
                    }


                    if (rowCount > 1) {
                        if (tempColumnCount < 1) {
                            currentMatrix.addRow(currentInteger, rowCount);
                            tempColumnCount++;
                            // TODO move down instead of create a new row


                        } else {
                            currentMatrix.addColumn(currentInteger);
                        }
                    }
                }

            }
            fr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        downPointers(currentMatrix);


        return currentMatrix;

    }

    public void addMatrix(DoubleLinkedList matrixOne, DoubleLinkedList matrixTwo) {
        Node matrixOneElement = matrixOne.getHead();
        Node matrixTwoElement = matrixTwo.getHead();
        int tempRowCount = 0;
        double sum;
        double matrixOneInt;
        double matrixTwoInt;

        if (matrixOne.getRowCount() != matrixTwo.getRowCount() && matrixOne.getColumnCount() != matrixTwo.getColumnCount()) {
            System.out.println("Not able to add current matrices");
        } else {

            while (matrixOneElement.getElement() != null) {
                while (matrixOneElement.getElement() != null) {
                    sum = 0;
                    matrixOneInt = matrixOneElement.getElementInt();
                    matrixTwoInt = matrixTwoElement.getElementInt();
                    sum = matrixOneInt + matrixTwoInt;
                    System.out.printf("%.1f", sum);
                    System.out.print(" ");
                    matrixOneElement = matrixOneElement.getRight();
                    matrixTwoElement = matrixTwoElement.getRight();

                }
                tempRowCount++;
                System.out.print("\n");
                matrixOneElement = matrixOne.getHead();
                matrixTwoElement = matrixTwo.getHead();
                for (int i = 0; i < tempRowCount; i++) {
                    matrixOneElement = matrixOneElement.getDown();
                    matrixTwoElement = matrixTwoElement.getDown();
                }
            }


        }


    }

    public void subtractMatrix(DoubleLinkedList matrixOne, DoubleLinkedList matrixTwo) {
        Node matrixOneElement = matrixOne.getHead();
        Node matrixTwoElement = matrixTwo.getHead();
        int tempRowCount = 0;
        double difference;
        double matrixOneInt;
        double matrixTwoInt;

        if (matrixOne.getRowCount() != matrixTwo.getRowCount() && matrixOne.getColumnCount() != matrixTwo.getColumnCount()) {
            System.out.println("Not able to add current matrices");
        } else {

            while (matrixOneElement.getElement() != null) {
                while (matrixOneElement.getElement() != null) {
                    difference = 0;
                    matrixOneInt = matrixOneElement.getElementInt();
                    matrixTwoInt = matrixTwoElement.getElementInt();
                    difference = matrixOneInt - matrixTwoInt;
                    System.out.printf("%.1f", difference);
                    System.out.print(" ");
                    matrixOneElement = matrixOneElement.getRight();
                    matrixTwoElement = matrixTwoElement.getRight();

                }
                tempRowCount++;
                System.out.print("\n");
                matrixOneElement = matrixOne.getHead();
                matrixTwoElement = matrixTwo.getHead();
                for (int i = 0; i < tempRowCount; i++) {
                    matrixOneElement = matrixOneElement.getDown();
                    matrixTwoElement = matrixTwoElement.getDown();
                }
            }


        }


    }

    public void multiplyMatrix(DoubleLinkedList matrixOne, DoubleLinkedList matrixTwo, int m1, int n2) {
        if (m1 != n2) {
            System.out.print("Not able to multiply incompatible matrices");
        }

        Node matrixOneElement = matrixOne.getHead();
        Node matrixTwoElement = matrixTwo.getHead();
        Node matrixOneRow;
        double product = 0;
        int tempRow = 0;
        int tempColumn = 0;

        while (matrixOneElement.getElement() != null) {
            matrixOneRow = matrixOneElement;
            matrixTwoElement = matrixTwo.getHead();
            tempColumn = 0;



            while (matrixTwoElement.getElement() != null) {
                matrixOneElement = matrixOneRow;

                while (matrixOneElement.getElement() != null) {
                    product += matrixOneElement.getElementInt() * matrixTwoElement.getElementInt();
                    matrixOneElement = matrixOneElement.getRight();
                    matrixTwoElement = matrixTwoElement.getDown();
                }
                System.out.printf("%.1f", product);
                System.out.print(" ");
                product = 0;

                tempColumn++;
                matrixTwoElement = matrixTwo.getHead();
                for (int i = 0; i < tempColumn; i++) {
                    matrixTwoElement = matrixTwoElement.getRight();
                }

            }

            tempRow++;
            matrixOneElement = matrixOne.getHead();
            for (int i = 0; i < tempRow; i++) {
                matrixOneElement = matrixOneElement.getDown();
            }

            System.out.println();




        }


    }
}


//----------- end of DoublyLinkedList class -----------
