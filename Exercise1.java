import java.util.Scanner;

public class Exercise1 {

    public static void printNumBiggerThenAverage()
    {
        Scanner scanner = new Scanner(System.in);
        float[] numbers = new float[10];
        float sum = 0;
        System.out.println("Please enter 10 numbers");
        for (int i=0; i< numbers.length;i++)
        {
            System.out.println("Number " + (i+1) + ": ");
            numbers[i] = scanner.nextFloat();
            sum += numbers[i];
        }

        sum = sum/10;

        System.out.println("The larger than average numbers are: ");
        for (int i=0; i< numbers.length;i++)
        {
            if(numbers[i] > sum)
                System.out.print(numbers[i] + ", ");
        }

    }
}
