import java.util.Random;

public class Main {
    public static final String ANSI_RED = "\033[1;31m";

    public static int division(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println(ANSI_RED + "Divide by zero " + "is not supported");
        }
        return -1;
    }

    public static void printArray(int[] arr) {
        int i = 0;
        try {
            while (true) {
                System.out.println(arr[i]);
                i++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(ANSI_RED + "End of the array");


        }

    }

    public static int recursion(int start) {
        try {
                recursion(start);
        } catch (StackOverflowError e) {
            System.out.println(ANSI_RED + "The memory is full");
        }
        return -1;
    }
    public static void printOneWord(String word){
        boolean result= word.contains(" ");
        try {
            if (result){
                throw new
            }

        }
            else
                System.out.println(word);
        catch (){

        }


    }

    public static void main(String[] args) {
        System.out.println(division(5, 0));
        System.out.println("----------");
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            int nextNum = random.nextInt(1, 100);
            arr[i] = nextNum;
        }
        printArray(arr);



    }
}







