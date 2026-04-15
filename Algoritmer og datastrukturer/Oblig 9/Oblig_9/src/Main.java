import java.util.Scanner;

public class Main {
    // main(): Test program, prints all words on a given file
    public static void main (String argv[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("File? ");
        String fileName = scan.nextLine();

        WordReader wR = new WordReader(fileName);
        String word = wR.nextWord();
        while (word != null)
        {
            System.out.println(word);
            word = wR.nextWord();
        }
    }
}