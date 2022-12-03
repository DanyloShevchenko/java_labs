import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        byte[] arr = new byte[5];

        for (int i = 0; i < arr.length; i++)
        {
            try {
                System.out.println("Please enter number");
                arr[i] = input.nextByte();
            }
            catch (InputMismatchException exception)
            {
                System.out.println("Non byte value or byte overflow");
                input.next();
            }
        }
        findMaxElement finder = new findMaxElement();
        try {
            byte x = finder.main(arr);
            System.out.println(x);
        }
        catch (NegativeOnlyArrayException exception)
        {
            System.out.println(exception.getMessage());
        }

    }
}