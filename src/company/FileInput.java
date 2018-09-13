//package company;
//
//import java.awt.*;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//
//
//public class FileInput {
//
//    private int rowCount;
//    private int columnCount;
//
//
//    FileInput() {
//
//    }
//
//    FileInput(String inputFile) {
//
//
//        BufferedReader br = null;
//        FileReader fr = null;
//        rowCount = 0;
//        columnCount = 0;
//        String currentLine;
//        String[] currentRowArray;
//        ArrayList
//
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
//                    allNumbers.add(currentElement);
//
//
//
//
//                    if (rowCount == 1)
//                        columnCount++;
//
//                }
//            }
//            fr.close();
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    int getColumnCount () {
//        return columnCount;
//    }
//    int getRowCount () {
//        return rowCount;
//    }
//
//}
//
