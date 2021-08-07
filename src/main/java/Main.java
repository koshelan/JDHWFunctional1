import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Generate<String, List<String>> generate = x -> // создание функции с использованием функционального инерфейса
                Arrays.stream(x.split(" ")) // Искользование Монад
                        .filter(s->!s.equals(""))
                        .filter(s->!" ".equals(s))
                        .sorted()
                        .collect(Collectors.toList());

        SortedSet<String> dictionary = new TreeSet<>();
        List<String> words;
        while (true) {
            System.out.println("Введите текст или end для выхода");
            String msg = scanner.nextLine();
            if (msg.equals("end")) {
                break;
            }
            words = generate.convert(msg);
            System.out.println("Слова в предложении:\n" + words);
            dictionary.addAll(words);
        }
        System.out.println("Весь словарь:\n" + dictionary);
    }


}
