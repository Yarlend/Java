
public class Main {
    public static void main(String[] args) {
        String s = "helloworld";
        String[] substrings = {"hello", "world"};

        boolean result = canBeMadeFromSubstrings(s, substrings); // вызываем функцию
        System.out.println(result);  // выводим результат
    }

    public static boolean canBeMadeFromSubstrings(String s, String[] substrings) {
        // используем метод append чтобы добавить каждую строку из массива substring
        // в экземпляр класа StringBuilder
        StringBuilder combined = new StringBuilder();
        for (String substring : substrings) {
            combined.append(substring);
        }

        // преобразовываем combined в незименяемую строку combinedStr
        String combinedStr = combined.toString();

        // проверяем, является ли строка s перестановкой объединённых подстрок
        return combinedStr.length() == s.length() && combinedStr.contains(s);
    }
}
