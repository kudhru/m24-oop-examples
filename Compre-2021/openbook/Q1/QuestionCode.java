import java.util.*;

public class QuestionCode {
    private static Scanner sc ;
    public static void main(String[] args) 
    {
        int number , square , cube , factorial ;
        sc = new Scanner(System.in);
        
        System.out.print("Please Enter any number :");
        number = sc.nextInt();

        for (int i = number;i<10;i++)
        {

            square = cal_square(number);

            System.out.println ("\n The Square of a given number " + number + " = " + square);

            cube = cal_cube(number);
            System.out.println("\n The Cube of the Given numbe " + number + " = " + cube);

            factorial = cal_factorial(number);
            System.out.println("\n The Factoraial of the Given Number " + number + " = "+ factorial);

        }

        
    }

    public static int cal_square(int n)
    {
        return n * n ;
    }

    public static int cal_cube(int n )
    {
        return n*n*n ;
    }

    public static int cal_factorial(int n)
    {
        if (n==0){
            return 1 ;
        }
        else {
            return ( n * cal_factorial (n-1));
        }

    }

    
}

