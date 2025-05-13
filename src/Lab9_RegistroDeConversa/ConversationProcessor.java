package Lab9_RegistroDeConversa;
import java.util.*;
import java.util.stream.Collectors;

public class ConversationProcessor {
    private Map<String, Set<String>> userWords;
    private Map<String, Integer> wordFrequency;
    private Set<String> allUsers;

    public ConversationProcessor() {
        userWords = new HashMap<>();
        wordFrequency = new HashMap<>();
        allUsers = new HashSet<>();
    }

    public void processMessage(String user, String message) {
        if (user == null || message == null || user.isEmpty() || message.isEmpty()) {
            return;
        }

        allUsers.add(user);
        String[] words = cleanAndSplitMessage(message);
        Set<String> wordsForUser = userWords.getOrDefault(user, new HashSet<>());

        for (String word : words) {
            if (!word.isEmpty()) {
                wordsForUser.add(word);
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        userWords.put(user, wordsForUser);
    }

    public List<String> getCommonWordsRanked() {
        Set<String> commonWords = findCommonWords();

        return commonWords.stream()
                .sorted(Comparator
                        .comparingInt((String word) -> wordFrequency.get(word)).reversed()
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    private Set<String> findCommonWords() {
        if (allUsers.isEmpty() || userWords.isEmpty()) {
            return Collections.emptySet();
        }

        Set<String> commonWords = new HashSet<>(userWords.values().iterator().next());

       for (Set<String> words : userWords.values()) {
            commonWords.retainAll(words);
            if (commonWords.isEmpty()) {
                break;
            }
        }

        return commonWords;
    }

    private String[] cleanAndSplitMessage(String message) {

        String cleaned = message.toLowerCase()
                .replaceAll("[^a-záéíóúâêîôûãõç\\s]", "");

        return Arrays.stream(cleaned.split("\\s+"))
                .filter(word -> !word.isEmpty())
                .toArray(String[]::new);
    }

    protected Map<String, Integer> getWordFrequency() {
        return Collections.unmodifiableMap(wordFrequency);
    }

    protected Map<String, Set<String>> getUserWords() {
        return Collections.unmodifiableMap(userWords);
    }
}