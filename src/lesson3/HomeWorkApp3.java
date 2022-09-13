package lesson2;

public class HomeWorkApp2 {

    public static void main(String[] args) {
        System.out.println(checkNum(5, 5));
        drawLine();
        checkNumSign(-8);
        drawLine();
        System.out.println(checkNumSignBool(-5));
        drawLine();
        stringNTimes("Java", 5);
        drawLine();
        System.out.println(checkLeapYear(2000));
        drawLine();
        checkLeapYearVer2(2100);

    }
    private static void drawLine() {
        System.out.println("________________________________________________");
    }
    /*
       1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит
   в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
       */
    static boolean checkNum(int a, int b) {
        return a + b <= 20 && a + b >= 10;
    }
    /*
    2. Написать метод, которому в качестве параметра передается целое число, метод должен
напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль
считаем положительным числом.
    */
    public static void checkNumSign(int c) {
        if (c >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    /*
  3. Написать метод, которому в качестве параметра передается целое число. Метод должен
вернуть true, если число отрицательное, и вернуть false если положительное.
   */
    static boolean checkNumSignBool(int c) {
        if (c == 0) {
            System.out.println("Хотя ноль не является ни отрицательным, ни положительным числом");
        }
        return c < 0;
    }
     /*
    4. Написать метод, которому в качестве аргументов передается строка и число, метод должен
отпечатать в консоль указанную строку, указанное количество раз;
    */
     public static void stringNTimes(String str, int n) {
         for (int i = 0; i < n; i++) {
             System.out.println(str);
         }
     }
     /*
    5. * Написать метод, который определяет, является ли год високосным, и возвращает boolean
(високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого
100-го, при этом каждый 400-й – високосный.
    */
    //1 вариант решения
     static boolean checkLeapYear(int year) {
         return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
     }
    //2 вариант решения
     static boolean checkLeapYearVer2(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("Это високосный год");
        } else {
            System.out.println("Это не високосный год");
        }
        return false;
    }
}
