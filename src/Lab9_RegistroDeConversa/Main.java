package Lab9_RegistroDeConversa;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int M = s.nextInt();
        s.nextLine();


        ConversationProcessor processor = new ConversationProcessor();
        for (int i = 0; i < M; i++) {
            String line = s.nextLine();
            String[] parts = line.split(" ", 2);
            if (parts.length == 2) {
                processor.processMessage(parts[0], parts[1]);
            }
        }


        List<String> commonWords = processor.getCommonWordsRanked();
        if (commonWords.isEmpty()) {
            System.out.println("ALL CLEAR");
        } else {
            for (String word : commonWords) {
                System.out.println(word);
            }
        }

        s.close();
    }
}
