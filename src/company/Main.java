package company;

public class Main {

    public static void main(String[] args) {

        String inputOne = "sample_input_output/1_a.txt";
        String inputTwo = "sample_input_output/1_b.txt";
        String testInput = "C:\\Users\\John Woodward\\IdeaProjects\\cosc-2430-hw2\\src\\testinput";


        DoubleLinkedList firstInput = new DoubleLinkedList();
        DoubleLinkedList secondInput = new DoubleLinkedList();
        firstInput = firstInput.buildMatrix(inputOne);
        secondInput = secondInput.buildMatrix(inputTwo);

        firstInput.addMatrix(firstInput, secondInput);
        firstInput.fileOutput("addOutput");
        System.out.println();

        firstInput.subtractMatrix(firstInput,secondInput);
        firstInput.fileOutput("subOutput");
        System.out.println();

        firstInput.multiplyMatrix(firstInput,secondInput,firstInput.getRowCount(),secondInput.getColumnCount());
        firstInput.fileOutput("multOutput");
        System.out.println();

        firstInput.transposeMatrix(firstInput);
        firstInput.fileOutput("transOutput");



    }

}
