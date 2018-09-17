

public class HW2 {

    public static void main(String[] args) {

        String inputOne = "sample_input_output/1_a.txt";
        String inputTwo = "sample_input_output/1_b.txt";
        String testInput = "C:\\Users\\John Woodward\\IdeaProjects\\cosc-2430-hw2\\src\\testinput";


        DoubleLinkedList fileInput1 = new DoubleLinkedList();
        DoubleLinkedList fileInput2 = new DoubleLinkedList();
        DoubleLinkedList singleFileInput = new DoubleLinkedList();





        if(args[0].equals("add")) {
            String FileOne = args[1];
            String FileTwo = args[2];
            fileInput1 = fileInput1.buildMatrix(FileOne);
            fileInput2 = fileInput2.buildMatrix(FileTwo);
            fileInput1.addMatrix(fileInput1, fileInput2);
            fileInput1.fileOutput(args[3]);
        }

        else if (args[0].equals("sub")) {
            String FileOne = args[1];
            String FileTwo = args[2];
            fileInput1 = fileInput1.buildMatrix(FileOne);
            fileInput2 = fileInput2.buildMatrix(FileTwo);
            fileInput1.subtractMatrix(fileInput1, fileInput2);
            fileInput1.fileOutput(args[3]);
        }

        else if (args[0].equals("mul")) {
            String FileOne = args[1];
            String FileTwo = args[2];
            fileInput1 = fileInput1.buildMatrix(FileOne);
            fileInput2 = fileInput2.buildMatrix(FileTwo);
            fileInput1.multiplyMatrix(fileInput1, fileInput2, fileInput1.getRowCount(), fileInput2.getColumnCount());
            fileInput1.fileOutput(args[3]);
        }

        else if (args[0].equals("tra")) {
            String singleFile = args[1];
            singleFileInput = singleFileInput.buildMatrix(singleFile);
            singleFileInput.transposeMatrix(singleFileInput);
            singleFileInput.fileOutput(args[2]);
        }

        else if (args[0].equals("det")) {
            String singleFile = args[1];
            singleFileInput = singleFileInput.buildMatrix(singleFile);
            singleFileInput.matrixDet(singleFileInput, singleFileInput.getRowCount(), singleFileInput.getColumnCount());
            singleFileInput.fileOutput(args[2]);
        }



    }
}
