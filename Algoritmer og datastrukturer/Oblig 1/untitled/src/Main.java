import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Gets user input
        String line;
        Scanner input = new Scanner(System.in);
        System.out.print("$ ");
        line = input.nextLine();


        // Encrypts and prints the input string
        System.out.println("Encrypt:");
        System.out.println("   - Word:  " + line);
        String encryptedText = krypter(line);
        System.out.println("   - Done:  " + encryptedText);

        // Dencrypts and prints the input string
        System.out.println("Decrypt:");
        System.out.println("   - Word:  " + encryptedText);
        String decryptedText = dekrypter(encryptedText);
        System.out.println("   - Done:  " + decryptedText);
    }


    // Encrypt the work (rot13)
    public static String krypter(String S){

        // Creates a stack and a queue
        Stack<Character> stack = new Stack<Character>();
        Queue<Character> queue = new LinkedList<>();

        // Encrypts the given String
        S = rot13(S);

        // Gets all the characters in the given String
        char[] C = S.toCharArray();

        // Loop through all chars, encrypts them and places them
        // in the new lists in the right order.
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
        String finalWord = "";

        // Alternates between adding from Queue and Stack until both empty
        while (true){

            // Take from stack if possible
            if (!stack.isEmpty()) {
                finalWord += stack.pop();
            }

            // Take from queue if possible
            if (!queue.isEmpty()) {
                finalWord += queue.poll();
            }

            // Check if both are empty and break loop if so
            if (stack.isEmpty() && queue.isEmpty()) {
                break;
            }

        }

        return finalWord;
    }



    // Decrypt the word (rot13)
    public static String dekrypter(String S){

        // Creates a stack and a queue
        Stack<Character> stack = new Stack<Character>();
        Queue<Character> queue = new LinkedList<>();

        // Encrypts the given String,
        S = rot13(S);

        // Gets all the characters in the given String
        char[] C = S.toCharArray();

        // String to be returned
        String finalWord = "";

        // Loop through all chars, then altenrates between adding them to the Queue and Stack.
        // We do this becuase we added them alternativly when we encypted them earlier
        for (int i = 0; i < C.length; i++){
            if (i % 2 == 0){
                stack.push(C[i]);
            } else{
                queue.add(C[i]);
            }
        }

        //Then fills with chars from queue
        while(!queue.isEmpty()){
            finalWord += queue.poll();
        }
        //Fills with chars from stack fist
        while(!stack.isEmpty()){
            finalWord += stack.pop();
        }

        return finalWord;
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

        System.out.println("   - Rot13: " + String.valueOf(C));
        return String.valueOf(C);
    }
}