import java.util.Scanner;
import java.util.Locale;

public class Main {
    final static String alph = "0123456789ABCDEFG";

    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        sc.useLocale(Locale.US);
        printHello();
        chooseCmd();
    }

    private static void chooseCmd(){
        Scanner scCommands = new Scanner(System.in);
        String cmd = "";
        
        do{
            System.out.print("Введите команду из списка: ");
            cmd = scCommands.nextLine();

            if(cmd.equals("start")) 
                System.out.println("Новое число: " + calcNum());

            if(cmd.equals("help")) 
                printHelp();

        }while(!cmd.equals("exit"));

        System.out.println("Покаа!");
    }

    private static void printHello(){
        String[] startWords = new String[]{
            "==============================",
            "Привет пользователь!",
            "==============================",
            "Основные команды:",
            "start - запуск программы",
            "help - как пользоваться программой",
            "exit - выход из программы",
            "=============================="
        };

        for(String el : startWords){
            System.out.println(el);
        }
    }

    private static void printHelp(){
        String[] startWords = new String[]{
            "==============================",
            "Как пользоваться программой",
            "==============================",
            "Основные команды:",
            "start - запуск программы",
            "help - список команд",
            "exit - выход из программы",
            "=============================="
        };

        for(String el : startWords){
            System.out.println(el);
        }
    }

    private static String calcNum(){
        System.out.print("Введите сс 1-го числа (2-16, fib - 1, fact - 0): ");
        int mode1 = sc.nextInt(); sc.nextLine();

        System.out.print("Введите 1-е число: ");
        String num = sc.nextLine();

        System.out.print("Введите новую сс (2-16, fact - 0): ");
        int mode2 = sc.nextInt();
        sc.nextLine();

        if(mode1 == mode2) 
            return num;

        if (mode1 == 0) {
            if (mode2 == 10) num = fromFactTo10System(num);
            else num = from10toXSystem(mode2, Float.parseFloat(fromFactTo10System(num)));
        } 
        else if (mode2 == 0) {
            if (mode1 == 10) num = from10ToFactSystem(Float.parseFloat(num));
            else num = from10ToFactSystem(Float.parseFloat(fromXto10System(mode1, num)));
        }
        else if (mode1 == 1) {
            if (mode2 == 10) num = fromFibTo10System(num);
            else num = from10toXSystem(mode2, Float.parseFloat(fromFibTo10System(num)));
        }
        else {
            if(mode1 == 10 && mode2 >= 2 && mode2 <= 16) 
                num = from10toXSystem(mode2, Float.parseFloat(num));
            else
                if(mode2 == 10) num = fromXto10System(mode1, num);
                else num = from10toXSystem(mode2, Float.parseFloat(fromXto10System(mode1, num)));
        }

        return num;
    }


    private static String from10toXSystem(int system, float number) {
        if (number == 0 || system <= 1) return "Неверный ввод";

        String temp = "";

        int integerPart = (int) number;
        float fractionalPart = number - integerPart;

        while (integerPart > 0) {
            temp = alph.charAt(integerPart % system) + temp;
            integerPart /= system;
        }

        if (fractionalPart != 0) {
            temp += ".";

            for (int i = 0; i < 5; i++) {
                fractionalPart *= system;

                int digit = (int) fractionalPart;

                temp += alph.charAt(digit);

                fractionalPart -= digit;
            }
        }

        return temp;
    }

    private static String fromXto10System(int system, String number){
        if(Float.parseFloat(number) == 0 || system <= 1) return "Неверный ввод";

        int dotIndex = number.indexOf(".");

        String integerPart, fractionalPart;

        if(dotIndex == -1){
            integerPart = number;
            fractionalPart = "";
        }
        else{
            integerPart = number.substring(0, dotIndex);
            fractionalPart = number.substring(dotIndex + 1);
        }

        double result = 0;
        int power = 1;

        for(int i = integerPart.length() - 1; i >= 0; i--){
            int digit = Character.digit(integerPart.charAt(i), system);
            if (digit == -1 || digit >= system) return "Неверный ввод";
            result += digit * power;
            power *= system;
        }

        if(!fractionalPart.isEmpty()){
            double fractionalPower = 1.0 / system;

            for(int i = 0; i <= fractionalPart.length() - 1; i++){
                int digit = Character.digit(fractionalPart.charAt(i), system);
                if (digit == -1 || digit >= system) return "Неверный ввод";
                result += digit * fractionalPower;
                fractionalPower /= system;
            }
        }

        return String.valueOf(result);
    }

    private static String from10ToFactSystem(float number) {
        if (number == 0) return "0";
        if (number < 0) return "Неверный ввод";

        String temp = "";

        int integerPart = (int) number;
        float fractionalPart = number - integerPart;

        if (integerPart == 0) {
            temp = "0";
        } else {
            int i = 2; 
            while (integerPart > 0) {
                int remainder = integerPart % i;
                temp = alph.charAt(remainder) + temp;
                integerPart /= i;
                i++;
            }
        }

        if (fractionalPart != 0) {
            temp += ".";
            int i = 2;

            for (int j = 0; j < 5; j++) {
                fractionalPart *= i;

                int digit = (int) fractionalPart;
                temp += alph.charAt(digit);

                fractionalPart -= digit;
                i++;
            }
        }

        return temp;
    }

    private static String fromFactTo10System(String number) {
        if (number == null || number.isEmpty()) return "Неверный ввод";

        int dotIndex = number.indexOf(".");
        String integerPart, fractionalPart;

        if (dotIndex == -1) {
            integerPart = number;
            fractionalPart = "";
        } else {
            integerPart = number.substring(0, dotIndex);
            fractionalPart = number.substring(dotIndex + 1);
        }

        double result = 0;

        int factorial = 1;
        int step = 2;
        for (int i = integerPart.length() - 1; i >= 0; i--) {
            int digit = Character.digit(integerPart.charAt(i), 10);
            if (digit == -1 || digit >= step) return "Неверный ввод";
            
            result += digit * factorial;
            factorial *= step;
            step++;
        }

        if (!fractionalPart.isEmpty()) {
            double divFactorial = 2.0;
            int nextMul = 3; 

            for (int i = 0; i < fractionalPart.length(); i++) {
                int digit = Character.digit(fractionalPart.charAt(i), 10);
                if (digit == -1 || digit >= nextMul) return "Неверный ввод";

                result += digit * (1.0 / divFactorial);
                
                divFactorial *= nextMul;
                nextMul++;
            }
        }

        return String.valueOf((int) result);
    }

    private static String fromFibTo10System(String number) {
        if (number == null || number.isEmpty()) return "Неверный ввод";
        if (number.contains("11")) return "Неверный ввод";

        int dotIndex = number.indexOf(".");
        String integerPart, fractionalPart;

        if (dotIndex == -1) {
            integerPart = number;
            fractionalPart = "";
        } else {
            integerPart = number.substring(0, dotIndex);
            int endSubstring = Math.min(dotIndex + 6, number.length());
            fractionalPart = number.substring(dotIndex + 1, endSubstring);
        }

        double result = 0;

        int fPrev = 1;
        int fCurr = 2;
        for (int i = integerPart.length() - 1; i >= 0; i--) {
            int digit = Character.digit(integerPart.charAt(i), 10);
            if (digit != 0 && digit != 1) return "Неверный ввод";

            result += digit * fPrev;

            int next = fPrev + fCurr;
            fPrev = fCurr;
            fCurr = next;
        }

        if (!fractionalPart.isEmpty()) {
            int fPrevDiv = 1;
            int fCurrDiv = 2;

            for (int i = 0; i < fractionalPart.length(); i++) {
                int digit = Character.digit(fractionalPart.charAt(i), 10);
                if (digit != 0 && digit != 1) return "Неверный ввод";

                result += digit * (1.0 / fPrevDiv);

                int next = fPrevDiv + fCurrDiv;
                fPrevDiv = fCurrDiv;
                fCurrDiv = next;
            }
        }

        return String.valueOf((long) result);
    }


}
