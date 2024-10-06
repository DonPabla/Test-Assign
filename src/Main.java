public class Main {
    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor();

        // Пример использования методов:
        System.out.println(processor.isStrongPassword("Password123!")); // проверка пароля
        System.out.println(processor.calculateDigits("Текст с 3 цифрами: 123")); // подсчет цифр
        System.out.println(processor.calculateWords("Текст для подсчета слов")); // подсчет слов
        System.out.println(processor.calculateExpression("2+3*5")); // вычисление выражения
    }
}
