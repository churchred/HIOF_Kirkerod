import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        // Task 1 - Integer ArrayList
        System.out.println("--- Integer ArrayList ---");
        ArrayList<Integer> numberList = new ArrayList<>();

        System.out.println("List size:" + numberList.size());

        numberList.add(42);

        System.out.println("List size:" + numberList.size());
    }
}