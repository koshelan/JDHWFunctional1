@FunctionalInterface
public interface Generate<String, List> {
    List convert(String str);
}