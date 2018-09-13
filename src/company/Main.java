package company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
//    static class Node {
//        int data;
//        company.DoubleLinkedList.Node right;
//        company.DoubleLinkedList.Node down;
//        int rowCount;
//        int columnCount;
//    }
//
//    ;
//
//    // returns head pointer of linked list
//    // constructed from 2D matrix
//    static Node construct(int inputElement, int rowCount, int columnCount) {
//        Node temp = new Node();
//        int tempColumnCount = 0;
//
//
//        if (rowCount == 0) {
//
//            for (int i = 0; i < columnCount; i++) {
//                temp = temp.right;
//            }
//            temp.data = inputElement;
//        }
//
//        if (rowCount == 1)
//            columnCount++;
//
//
//        else {
//            for (int i = 0; i < rowCount; i++) {
//                temp = temp.down;
//            }
//            if (tempColumnCount == 0) {
//                temp.data = Integer.parseInt(currentElement);
//            } else {
//                for (int i = 0; i < tempColumnCount; i++) {
//                    temp = temp.right;
//                }
//                temp.data = Integer.parseInt(currentElement);
//            }
//        }
//
//
//        // return if i or j is out of bounds
//        return temp;
//    }
//
//    // utility function for displaying
//    // linked list data
//    static void display(company.DoubleLinkedList.Node head) {
//
//        // pointer to move right
//        company.DoubleLinkedList.Node Rp;
//
//        // pointer to move down
//        company.DoubleLinkedList.Node Dp = head;
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

    // A basic doubly linked list implementation. ∗/


    // node of linked list


    public static void main(String[] args) {

        String inputOne = "sample_input_output/1_a.txt";
        String inputTwo = "sample_input_output/1_b.txt";

        DoubleLinkedList firstInput = new DoubleLinkedList();
        firstInput = firstInput.buildMatrix(inputOne);

//        FileInput inputA = new FileInput(inputOne);
//        FileInput inputB = new FileInput(inputTwo);

        firstInput.displayMatrix(firstInput.getHead());


    }

}
