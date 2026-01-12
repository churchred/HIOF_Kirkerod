import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Gets user input
        String line;
        Scanner input = new Scanner(System.in);
        System.out.print("$ ");
        line = input.nextLine();

        // Encrypts and prints the input string
        String encryptedText = encrypt(line);
        System.out.println("Encrypted: " + encryptedText);
    }


    // Encrypt the given message
    public static String encrypt(String S){

        // Creates a stack and a queue
        Stack<Character> stack = new Stack<Character>();
        Queue<Character> queue = new LinkedList<>();

        // Encrypts the given String, 0=move forwards(encrypt),
        // while 1=move backwards(decrypt)
        S = rot13(S);
        System.out.println("> " + S);

        // Gets all the characters in the given String
        char[] C = S.toCharArray();

        // Loop through all chars, encrypts them and places them
        // in the new list in the right order.
        for (int i = 0; i < C.length; i++){

            // First half of the chars are
            // placed into a Queue and rest into a Stack.
            if (i < C.length / 2){
                queue.add(C[i]);
            }
            else{
                stack.push(C[i]);
            }
        }


        // Where we store all the new chars given from stack/queue
        List<Character> list = new ArrayList<>();

        // Alternates between adding from Queue and Stack until both empty
        while (true){

            // Take from stack if possible
            if (!stack.isEmpty()) {
                list.add(stack.pop());
            }

            // Take from queue if possible
            if (!queue.isEmpty()) {
                list.add(queue.poll());
            }

            // Check if both are empty and break loop if so
            if (stack.isEmpty() && queue.isEmpty()) {
                break;
            }

        }

        return list.toString();
    }

    // Encrypt/Decrypt the given message
    public static String rot13(String S){

        char[] C = S.toCharArray();
        for (int i = 0; i < S.length(); i++)
        {
            char c = C[i];
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            C[i] = c;
        }
        return String.valueOf(C);
    }
}