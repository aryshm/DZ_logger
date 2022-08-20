import java.text.spi.BreakIteratorProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int size, maxValue, treshold;


    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner;
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        while (true) {
            logger.log("Введите размер списка: ");
            scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                logger.log("Введено число " + size);
                if (size <= 0) {
                    logger.log("Введено некорректное число! Необходимо положительное число, повторите ввод");
                } else {
                    break;
                }
            } else {
                logger.log("Введено не число");
            }
        }
        while (true) {
            logger.log("Введите верхнюю границу для значений: ");
            scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                maxValue = scanner.nextInt();
                logger.log("Введено число " + maxValue);
                if (maxValue <= 0) {
                    logger.log("Введено некорректное число! Необходимо положительное число, повторите ввод");
                } else {
                    break;
                }
            } else {
                logger.log("Введено не число");
            }
        }
        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(maxValue));
        }
        logger.log(String.format("Вот случайный список: %s", list));
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        while (true) {
            logger.log("Введите порог для фильтра: ");
            scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                treshold = scanner.nextInt();
                logger.log("Введено число " + treshold);
                if (treshold <= 0 || treshold > maxValue) {
                    logger.log("Введено некорректное число! Необходимо число, меньше верхней границы");
                } else {
                    break;
                }
            } else {
                logger.log("Введено не число");
            }
        }
        Filter filter = new Filter(treshold);
        List<Integer> result = filter.filterOut(list);
        logger.log("Выводим результат на экран");
        logger.log("Отфильтрованный список: " + result);
        logger.log("Завершаем программу");
    }
}
