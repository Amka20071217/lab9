import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void processStrings(
            List<String> words,
            Predicate<String> predicate,
            Function<String, String> function,
            Consumer<String> consumer) {

        for (String word : words) {

            if (predicate.test(word)) {

                String result = function.apply(word);

                consumer.accept(result);
            }
        }
    }

    public static void main(String[] args) {

        List<String> words =
                Arrays.asList("programchallal");

        Predicate<String> predicate =
                s -> s.length() > 5;

        Function<String, String> function =
                s -> new StringBuilder(s)
                        .reverse()
                        .toString();

        Consumer<String> consumer =
                s -> System.out.println(
                        "GARSHIL: " +
                        s.toUpperCase());

        processStrings(
                words,
                predicate,
                function,
                consumer);
    }
}