import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("""
                    1. Вывести все таблицы из MySQL.
                    2. Создать таблицу в MySQL.
                    3. Ввести список и сохранить в MySQL..
                    4. Удалить элемент из списка в MySQL по ID
                    5. Сохранить все данные (вышеполученные результаты) из MySQL в Excel и вывести на экран 
                    0. Выход.""");

            String s = scanner.nextLine();
            choice = Integer.parseInt(s);
            handleUserChoice(choice, scanner, DBhandler.getTableName());
        } while (choice != 0);
    }

    private static void handleUserChoice (int choice, Scanner scanner, String tableName) {
        String a, b;
        switch (choice) {
            case 1:
                DBhandler.showAllTables();
                break;
            case 2:
                System.out.println("Введите название для создания таблицы:");
                DBhandler.setTableName(scanner.nextLine());
                DBhandler.createTable();
                break;
            case 3:
                StringOperations.inputStrings(scanner);
                break;
            case 4:
                StringOperations.StringIntegrity();
                break;
            case 5:
                ExcelExporter exporter = new ExcelExporter();
                exporter.export();
            case 0:
                System.out.println("Выход из программы...");
                break;
            default:
                System.out.println("Неверный выбор. Попробуйте снова.");
        }
    }
}