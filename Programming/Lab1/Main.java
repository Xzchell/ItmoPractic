public class Main {
    final static int ARRAY_F_FROM = 15;
    final static int ARRAY_F_TO = 3;
    final static int ARRAY_F_LENGTH = ARRAY_F_FROM - ARRAY_F_TO + 1;

    final static float ARRAY_X_MIN = -6.0f;
    final static float ARRAY_X_MAX = 8.0f;
    final static int ARRAY_X_LENGTH = 12;

    final static int ARRAY_B_LENGTH_VER = 13;
    final static int ARRAY_B_LENGTH_HOR = 12;

    public static void main (String[] args) {
        long[] f = makeArrayF();
        printArrayF(f);

        float[] x = makeArrayX();
        printArrayX(x);

        double[][] b = makeArrayB(f, x);
        printMatrixB(b);
    }

    private static long[] makeArrayF(){
        long[] tempArray = new long[ARRAY_F_LENGTH];
        for(int i = 0; i < ARRAY_F_LENGTH; i++){
            tempArray[i] = ARRAY_F_FROM - i;
        }
        return tempArray;
    }

    private static float[] makeArrayX(){
        float[] tempArray = new float[ARRAY_X_LENGTH];
        for(int i = 0; i < ARRAY_X_LENGTH; i++){
            tempArray[i] = random(ARRAY_X_MAX, ARRAY_X_MIN);
        }
        return tempArray;
    }

    private static float random (float max, float min) {
        return (float) (Math.random() * (max - min)) + min;
    }

    private static double[][] makeArrayB(long[] f, float[] x){
        double[][] tempArray = new double[ARRAY_B_LENGTH_VER][ARRAY_B_LENGTH_HOR];
        for(int i = 0; i < ARRAY_B_LENGTH_VER; i++){
            for(int j = 0; j < ARRAY_B_LENGTH_HOR; j++){
                tempArray[i][j] = calculate(x[j], f[i]);
            }
        }
        return tempArray;
    }

    private static double calculate(float x, long f){
        if(f == 6) return formula1(x);
        if(checkElements(f)) return formula2(x);
        return formula3(x);
    }

    /*
    *   Блок методов формулы №1
    */

    private static double formula1(float x){
        return Math.pow(formula1Part1(x), formula1Numerator(x) / formula1Denominator(x));
    }

    private static double formula1Part1(float x){
        return Math.cos(Math.pow(((x + 0.5f)/x), 2));
    }

    private static double formula1Numerator(float x){
        return Math.pow(0.25 / Math.log(Math.abs(x)), 2) + 1;
    }

    private static double formula1Denominator(float x){
        return Math.pow(Math.tan(x) / (Math.atan((x+1) / 14) - (1.0 / 3.0)), 3);
    }

    /*
    *   Формула №2
    */

    private static double formula2(float x){
        return (Math.pow((1.0 / 3.0) / Math.atan((x + 1) / 14), 3) - 0.25) / Math.PI;
    }

    /*
    *   Формула №3
    */

    private static double formula3(float x){
        return Math.pow(Math.cbrt(Math.pow((0.5f * Math.cbrt(x)), 3)) / 0.25f, 2);
    }

    private static void printArrayF(long[] f){
        System.out.println("Elements Array F");
        for(long el : f) System.out.print(el + " ");
        System.out.println("\n");
    }

    private static void printArrayX(float[] x){
        System.out.println("Elements Array X");
        for(float el : x) System.out.print(el + " ");
        System.out.println("\n");
    }

    private static void printMatrixB(double[][] b){
        System.out.println("Elements Matrix B");
        for(double[] massive : b){
            for(double el : massive){
                System.out.printf("%10.2f ", el);
            }
            System.out.println();
        }
    }

    /*
    *   Логическое условие на существование элемента в множестве доступных значений
    */

    private static boolean checkElements(long f){
        long[] elements = new long[] {4, 5, 8, 11, 12, 15};
        for (long el : elements)
            if(el == f) return true;
        return false;
    }
}
