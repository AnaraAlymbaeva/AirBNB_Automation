package payment;

import java.util.Scanner;

public class PaymentForm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Сбор данных с формы
        System.out.print("Введите сумму: ");
        double amount = scanner.nextDouble();

        scanner.nextLine(); // Поглощаем остаточный символ новой строки

        System.out.print("Введите метод оплаты (credit card/paypal): ");
        String paymentMethod = scanner.nextLine();

        String cardNumber = null;
        if (paymentMethod.equalsIgnoreCase("credit card")) {
            System.out.print("Введите номер карты (16 цифр): ");
            cardNumber = scanner.nextLine();
        }

        // Обработка формы платежа
        if (submitPaymentForm(amount, paymentMethod, cardNumber)) {
            System.out.println("Платеж успешен!");
        } else {
            System.out.println("Ошибка при обработке платежа.");
        }
    }

    // Метод для обработки данных платежа
    public static boolean submitPaymentForm(double amount, String paymentMethod, String cardNumber) {
        if (amount <= 0) {
            System.out.println("Ошибка: сумма должна быть больше нуля.");
            return false;
        }

        if (paymentMethod.equalsIgnoreCase("credit card")) {
            if (cardNumber == null || cardNumber.length() != 16) {
                System.out.println("Ошибка: неверный номер карты.");
                return false;
            }
            System.out.println("Оплата через кредитную карту на сумму: $" + amount);
            return true;
        } else if (paymentMethod.equalsIgnoreCase("paypal")) {
            System.out.println("Оплата через PayPal на сумму: $" + amount);
            return true;
        } else {
            System.out.println("Ошибка: неподдерживаемый метод оплаты.");
            return false;
        }
    }
    }


