package company;

public class Main {

    public static void main(String[] args) {

        String inputOne = "sample_input_output/1_a.txt";
        String inputTwo = "sample_input_output/1_b.txt";

        FileInput inputA = new FileInput(inputOne);
        FileInput inputB = new FileInput(inputTwo);

        DoubleLinkedList firstFile = new DoubleLinkedList(inputA.getImportList(), inputA.getRowCount(), inputA.getColumnCount());
    }
}
