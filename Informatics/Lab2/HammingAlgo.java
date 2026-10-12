import java.util.Scanner;
import java.lang.Math;

class HammingAlgo {

    final int LENGTH_OF_NUMBER = 7;
    final int COUNT_OF_S = 3;

    final Scanner sc = new Scanner(System.in);

    public void main(String[] strs){
        String number = inputNum();
        int errBit = findBitWithErr(number);

        System.out.println(errBit == 0 ? "-- Ошибок нет --\nИнформационные биты: " + getInfoBits(number.toCharArray()) : "Ошибка в бИте №" + errBit);
        
        if(errBit != 0)
            System.out.println("Исправленное сообщение:" + fixBitInNum(errBit, number));
        
        sc.close();
    }

    private String inputNum(){
        String num;
        boolean checkedI;

        String str = "Введите число: ";
    
        do{
            System.out.print(str);
            num = sc.nextLine();

            checkedI = checkInput(num.trim());

            str = checkedI ? str : "-- Неверно ввели число --\nВведите число: ";
        }while(!checkedI);

        return num.trim();
    }

    private boolean checkInput(String numStr){
        if (numStr.isEmpty() || numStr == null || numStr.length() != LENGTH_OF_NUMBER) return false;

        for(int i = 0; i < numStr.length(); i++)
            if(numStr.charAt(i) != '0' && numStr.charAt(i) != '1')
                return false;
        return true;
    }

    private int findBitWithErr(String numStr){
        int result = 0;
        boolean[] num = new boolean[LENGTH_OF_NUMBER];

        for(int i = 0; i < LENGTH_OF_NUMBER; i++)
            num[i] = numStr.charAt(i) == '1';

        for(int i = 0; i < COUNT_OF_S; i++){
            int r = (int) Math.pow(2, i);
            boolean xor = false;

            for(int j = 0; j < LENGTH_OF_NUMBER; j++){
                if((int) ((j + 1) / r) % 2 == 1)
                    xor = xor ^ num[j];
            }
            
            if(xor)
                result += (int) Math.pow(2,i);
        }
        return result;
    }

    private String fixBitInNum(int index, String numStr){
        char[] numChars = numStr.toCharArray();
        numChars[index - 1] = numChars[index - 1] == '1' ? '0' : '1';
        
        return getInfoBits(numChars);
    }

    private String getInfoBits(char[] numChars){
        String numStr = String.valueOf(numChars[2]);
        
        for(int i = 4; i < LENGTH_OF_NUMBER; i++)
            numStr += numChars[i];

        return numStr;
    }
}
