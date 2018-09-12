package company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileInput {

    private int rowCount;
    private int columnCount;
    private SingleLinkedList importList;

    public static class SingleLinkedList<E> {

        private static class Node<E> {
            private E element;
            private Node<E> next;

            public Node(E e, Node<E> n) {
                element = e;
                next = n;
            }

            public E getElement() {
                return element;
            }

            public Node<E> getNext() {
                return next;
            }

            public void setNext(Node<E> n) {
                next = n;
            }
        }


        private Node<E> head = null;
        private Node<E> tail = null;
        private int size = 0;

        public SingleLinkedList() {
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public E first() {
            if (isEmpty())
                return null;
            return head.getElement();
        }

        public E last() {
            if (isEmpty())
                return null;
            return tail.getElement();
        }

        public void addFirst(E e) {
            Node<E> newest = new Node<>(e, null);
            if (size == 0)
                tail = head;
            size++;
        }

        public void addLast(E e) {
            Node<E> newest = new Node<>(e, null);
            if (isEmpty())
                head = newest;
            else
                tail.setNext(newest);
            tail = newest;
            size++;
        }

        public E removeFirst() {
            if (isEmpty())
                return null;
            E answer = head.getElement();
            head = head.getNext();
            size--;
            if (size == 0)
                tail = null;
            return answer;
        }
    }


    FileInput() {

    }

    FileInput(String inputFile) {


        BufferedReader br = null;
        FileReader fr = null;
        rowCount = 0;
        columnCount = 0;
        String currentLine;
        String[] currentRowArray;
        importList = new SingleLinkedList();

        try {

            fr = new FileReader(inputFile);
            br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                rowCount++;


                currentRowArray = currentLine.split(" ");


                for (String currentElement : currentRowArray) {

                    importList.addLast(Integer.parseInt(currentElement));
                    if (rowCount == 1)
                        columnCount++;

                }
            }
            fr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int getColumnCount () {
        return columnCount;
    }
    int getRowCount () {
        return rowCount;
    }
    SingleLinkedList getImportList () {
        return importList;
    }
}

