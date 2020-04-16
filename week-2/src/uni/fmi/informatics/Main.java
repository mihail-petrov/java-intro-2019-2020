package uni.fmi.informatics;

public class Main {

    public static void main(String[] args) {
        demonstrateStrings();
        demonstrateExpressions();
        demonstrateIfElse();
        demonstrateSwitchCase();
        demonstrateCast();
    }

    public static void demonstrateStrings() {
        String welcomeMessage = "Good Morning"; // char[]

        String speciality = "Informatics";

        String univesity = new String("Plovdiv University");

        String concatenatedResult = welcomeMessage + ", " + speciality;

        System.out.println("RESULT: " + concatenatedResult);
    }

    public static void demonstrateExpressions() {
        // Аритметични оператори: -, +, *, /, %, ++, --
        int sum = 8 + 4;
        System.out.println("Сумата на числата е: " + sum);

        // Оператори ++ и --
        int firstNumber = 2;
        int incrementedFirstNumber = ++firstNumber;
        System.out.println("First number: " + firstNumber);
        System.out.println("Incremented first number: " + incrementedFirstNumber);

        // Логически оператори: &&, ||, !
        boolean flagTrue = true;
        boolean flagFalse = false;

        System.out.println(flagFalse && flagTrue);
        System.out.println(flagTrue || flagFalse);
        System.out.println(!flagTrue);

        // Побитови оператори: &, |, ~

        // Оператори за сравнение: ==, !=, >, <, >=, <=
        int numberTen = 10;
        int numberFive = 5;

        System.out.println("numberTen > numberFive && numberTen == numberFive: " +
                (numberTen > numberFive && numberTen == numberFive && numberTen%numberFive == 0)
        );

        // Оператори за присвояване: =, +=, -=, *=, /=
        int assign = 2;
        assign += 2; // assign = assign + 2;
        System.out.println("assign = " + assign);
    }

    public static  void demonstrateIfElse() {
        int number = 6;

        if (number%2 == 0) {
            System.out.println("Числото е четно!");
        } else {
            System.out.println("Числото е нечетно!");
        }

        if (number == 7) {
            System.out.println("Цифрата е равна 7");
        } else if (number > 7) {
            System.out.println("Цифрата е по-голяма от 7");
        } else {
            System.out.println("Цифрата е по-малка от 7");
        }
    }

    public static void demonstrateSwitchCase() {
        int monthNumber = 4;
        String monthName;

        switch (monthNumber) {
            case 1:
                monthName = "January";
                break;

            case 2:
                monthName = "February";
                break;

            case 3:
                monthName = "March";
                break;

            case 4:
                monthName = "April";
                break;

            case 5:
                monthName = "May";
                break;

            case 6:
                monthName = "June";
                break;

            case 7:
                monthName = "July";
                break;

            case 8:
                monthName = "August";
                break;

            case 9:
                monthName = "September";
                break;

            case 10:
                monthName = "October";
                break;

            case 11:
                monthName = "November";
                break;

            case 12:
                monthName = "December";
                break;

            default:
                monthName = "Invalid month";
                break;
        }

        System.out.println("Month name is: " + monthName);
    }

    public static void demonstrateCast() {
        // Имплицитно кастване
        int implicitCastIntValue = 10;
        double implicitCastDoubleValue = implicitCastIntValue;
        System.out.println("Имплицитно кастване: " + implicitCastDoubleValue);

        // Експлицитно кастване
        double explicitCastDoubleValue = 10.7;
        int explicitCastIntValue = (int) explicitCastDoubleValue;
        System.out.println("Explicit cast: " + explicitCastIntValue);

        // Булево кастване
        boolean flagTrueBooleanCast = true;
        boolean flagTrueCast = flagTrueBooleanCast;
        System.out.println("Boolean cast: " + flagTrueCast);
    }
}
