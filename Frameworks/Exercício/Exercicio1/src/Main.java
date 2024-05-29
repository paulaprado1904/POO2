public class Main {

    // Método que retorna "object" se o parâmetro for um objeto genérico
    static String f(Object s) {
        return "object";
    }

    // Método que retorna "string" se o parâmetro for uma String
    static String f(String s) {
        return "string";
    }

    // Método genérico que determina o tipo do objeto passado como argumento
    static <T> String generic(T t) {
        return f(t);
    }

    public static void main(String[] args) {
        System.out.println(generic("Hello World")); // Saída: string
    }
}
