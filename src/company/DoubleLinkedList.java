package company;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleLinkedList<Interger> {
    private int columnCount;
    private int rowCount;
    private String stringStore;

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
        currentElement.setDown(rowNode());
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
    }

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
        stringStore = "";

        if (matrixOne.getRowCount() != matrixTwo.getRowCount() && matrixOne.getColumnCount() != matrixTwo.getColumnCount()) {
            System.out.println("Not able to add current matrices");
        } else {

            while (matrixOneElement.getElement() != null) {

                while (matrixOneElement.getElement() != null) {
                    sum = 0;
                    matrixOneInt = matrixOneElement.getElementInt();
                    matrixTwoInt = matrixTwoElement.getElementInt();
                    sum = matrixOneInt + matrixTwoInt;
                    sum = BigDecimal.valueOf(sum).setScale(1, RoundingMode.HALF_UP).doubleValue();
                    stringStore += (sum + " ");
                    System.out.printf(sum + " ");

                    matrixOneElement = matrixOneElement.getRight();
                    matrixTwoElement = matrixTwoElement.getRight();
                }

                tempRowCount++;
                stringStore += ("\n");
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
        stringStore = "";

        if (matrixOne.getRowCount() != matrixTwo.getRowCount() && matrixOne.getColumnCount() != matrixTwo.getColumnCount()) {
            System.out.println("Not able to add current matrices");
        } else {

            while (matrixOneElement.getElement() != null) {
                while (matrixOneElement.getElement() != null) {
                    difference = 0;
                    matrixOneInt = matrixOneElement.getElementInt();
                    matrixTwoInt = matrixTwoElement.getElementInt();
                    difference = matrixOneInt - matrixTwoInt;
                    difference = BigDecimal.valueOf(difference).setScale(1, RoundingMode.HALF_UP).doubleValue();
                    stringStore += (difference + " ");
                    System.out.printf(difference + " ");
                    matrixOneElement = matrixOneElement.getRight();
                    matrixTwoElement = matrixTwoElement.getRight();
                }

                tempRowCount++;
                stringStore += ("\n");
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
        stringStore = "";
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

                product = BigDecimal.valueOf(product).setScale(1, RoundingMode.HALF_UP).doubleValue();
                stringStore += (product + " ");
                System.out.printf(product + " ");
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

            stringStore+= ("\n");
            System.out.println();
        }
    }

    public void transposeMatrix(DoubleLinkedList currentMatrix) {

        Node currentPosition = currentMatrix.getHead();
        int currentColumn = 0;
        double currentElement;
        stringStore = "";

        while (currentPosition.getElement()!=null) {

            while ( currentPosition.getElement()!=null) {
                currentElement = currentPosition.getElementInt();

                currentElement = BigDecimal.valueOf(currentElement).setScale(1, RoundingMode.HALF_UP).doubleValue();
                stringStore += (currentElement + " ");
                System.out.printf(currentElement + " ");
                currentPosition = currentPosition.getDown();

            }
            currentColumn++;
            stringStore += ("\n");
            System.out.println();
            currentPosition = currentMatrix.getHead();
            for (int i =0; i < currentColumn; i++) {
                currentPosition = currentPosition.getRight();
            }
        }
    }

    public void matrixDet(DoubleLinkedList currentMatrix, int m, int n) {

        if(m != n) {
            System.out.println("Not a square matrix, cannot find determinant");
        }
        else {
            
        }


    }



    public void fileOutput(String outputFilePath) {
        PrintWriter outputStream;
        try {
            outputStream = new PrintWriter(new FileOutputStream(outputFilePath));
            outputStream.println(" " + stringStore);
            outputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + outputFilePath + "cannot be found.");
            System.exit(1);
        }
    }
}

