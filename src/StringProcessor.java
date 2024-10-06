import java.util.Stack;

public class StringProcessor {

    // Метод для проверки, является ли пароль "сильным"
    public boolean isStrongPassword(String password) {
        // Проверяем, что длина пароля не меньше 8 символов
        if (password.length() < 8) {
            return false; // Если пароль меньше 8 символов, он не сильный
        }

        // Флаги для проверки наличия различных символов
        boolean hasUpperCase = false;  // Заглавная буква
        boolean hasLowerCase = false;  // Строчная буква
        boolean hasDigit = false;      // Цифра
        boolean hasSpecialSymbol = false; // Специальный символ

        // Проверяем каждый символ пароля
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true; // Если символ заглавная буква
            } else if (Character.isLowerCase(ch)) {
                hasLowerCase = true; // Если символ строчная буква
            } else if (Character.isDigit(ch)) {
                hasDigit = true; // Если символ цифра
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialSymbol = true; // Если символ не буква и не цифра (спецсимвол)
            }
        }

        // Пароль считается сильным, если он содержит все необходимые типы символов
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialSymbol;
    }

    // Метод для подсчета количества цифр в строке
    public int calculateDigits(String sentence) {
        int digitCount = 0; // Счетчик цифр

        // Если строка пустая (null), возвращаем 0
        if (sentence == null) {
            return 0;
        }

        // Перебираем каждый символ строки
        for (char ch : sentence.toCharArray()) {
            if (Character.isDigit(ch)) {
                digitCount++; // Если символ цифра, увеличиваем счетчик
            }
        }

        return digitCount; // Возвращаем количество цифр
    }

    // Метод для подсчета количества слов в строке
    public int calculateWords(String sentence) {
        // Если строка пустая или состоит только из пробелов, возвращаем 0
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }

        // Разбиваем строку на слова, разделенные пробелами
        String[] words = sentence.trim().split("\\s+");
        return words.length; // Возвращаем количество слов
    }

    // Метод для вычисления математического выражения (только с операторами +, -, *, /)
    public double calculateExpression(String expression) {
        Stack<Double> values = new Stack<>(); // Стек для чисел
        Stack<Character> ops = new Stack<>(); // Стек для операторов

        double tempNumber = 0; // Переменная для текущего числа
        char previousOperator = '+'; // Предыдущий оператор, по умолчанию '+' для первого числа

        // Проходим по каждому символу выражения
        for (int index = 0; index < expression.length(); index++) {
            char currentChar = expression.charAt(index); // Получаем текущий символ

            // Если символ - цифра, собираем число
            if (Character.isDigit(currentChar)) {
                tempNumber = tempNumber * 10 + (currentChar - '0');
            }

            // Если символ - оператор или это конец строки
            if ((!Character.isDigit(currentChar) && currentChar != ' ' && currentChar != '(') || index == expression.length() - 1) {
                // Обрабатываем предыдущий оператор
                if (previousOperator == '+') {
                    values.push(tempNumber); // Добавляем число в стек
                } else if (previousOperator == '-') {
                    values.push(-tempNumber); // Добавляем отрицательное число в стек
                } else if (previousOperator == '*') {
                    values.push(values.pop() * tempNumber); // Умножаем последнее число из стека на текущее
                } else if (previousOperator == '/') {
                    values.push(values.pop() / tempNumber); // Делим последнее число из стека на текущее
                }

                previousOperator = currentChar; // Обновляем предыдущий оператор
                tempNumber = 0; // Обнуляем текущее число
            }
        }

        // Итоговый результат
        double finalResult = 0;
        // Складываем все числа из стека
        while (!values.isEmpty()) {
            finalResult += values.pop(); // Добавляем число к результату
        }

        return finalResult; // Возвращаем итоговый результат
    }
}
