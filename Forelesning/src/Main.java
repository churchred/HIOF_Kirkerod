
public class Main {
    public static void main(String[] args) {
        // Variables and datatypes

        System.out.println("-- Variable tests --");

        // Heltal
        int heltall = 10;
        System.out.println("Heltall: " + heltall);

        // Desimaltall
        // Kan ta imot heltall
        double desimal = 10.999;
        System.out.println("Desimaltall: " + desimal);

        // Booelean true/false (lowercase)
        boolean bool = (1==1);
        System.out.println("Bool: " + bool);

        // String
        String text = "Hello there!";
        System.out.println("String: " + text);


        System.out.println("\n -- Function 1 --");
        System.out.println("A 15 year old can drink: " + isMyndig(15));
        System.out.println("A 18 year old can drink: " + isMyndig(18));
        System.out.println("A 25 year old can drink: " + isMyndig(25));

        System.out.println("\n -- Function 2 --");
        countUp(10,20);

        System.out.println("\n -- Classes --");


    }

    public static void countUp(int startNr, int endNr){
        String temp = "";
        for(int i = startNr; i < endNr+1; i++){
            temp += i + " ";
        }
        System.out.println(temp);
    }

    public static boolean isMyndig(int age){
        if (age >= 18){
            return true;
        } else{
            return false;
        }
    }

    public static int sumOfTwoNumbers(int number1, int number2){
        return number1 + number2;
    }
}


