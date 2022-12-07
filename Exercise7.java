import java.util.Random;
import java.util.Scanner;

public class Exercise7 {
    public static void main (String[] arg)
    {
       System.out.println("Welcome to our play!!");
       System.out.println("Guess our secret number");
        System.out.println("The number should include 4 digits where each digit is between 1-6");
        boolean isSuprisingRoute = false;
        int tries = choosingRoute();
        if (tries == 0)
        {
            isSuprisingRoute = true;
            tries = surprisingRoute();
        }
        String secretNum = randomNum();
        boolean hasWinner = false;
        String guess;
        for (int i = 1; i<=tries; i++)
        {
            guess = getUserGuess();
            if (secretNum.equals(guess))
            {
                hasWinner = true;
                System.out.println("This is the secret number, you are the WINNER!!");
                break;
            } else if (haveDuplicates(guess)) {
                System.out.println("You guessed a number with a double digit");
                System.out.println("Penalty of 2 attempts");
                i+=2;
                if (!isSuprisingRoute)
                {
                   printLeftTries(tries-i);
                }

            }else {
                System.out.println("You guessed a number with " + accurateGuess(guess,secretNum) + " accurate guess ");
                System.out.println("You guessed a number with " + partialGuess(guess,secretNum) + " partial  guess ");
                System.out.println ("Try again");
                if (!isSuprisingRoute)
                {
                   printLeftTries(tries-i);
                }
            }
        }
        if (!hasWinner){
            System.out.println ("You've run out of tries ");
            System.out.println ("You LOST!!");
        }


    }

    public static void printLeftTries(int tries)
    {
        System.out.println ("You have left " + tries + " tries");
    }

    public static String randomNum()
    {
        Random random = new Random();
        String randomNum = "";
        int num;
        for (int i= 1; i<=4; i++)
        {
         num = random.nextInt(1,7);
         if (!randomNum.contains(Integer.toString(num)))
         {
             randomNum += Integer.toString(num);
         }else {
            i--;
         }
        }

        return randomNum;
    }

    public static int choosingRoute() {
        Scanner scanner = new Scanner(System.in);
        int tries;
        do {

            System.out.println("Please choose route: ");
            System.out.println("for easy route press 20 ");
            System.out.println("for medium route press 15 ");
            System.out.println("for hard route press 10 ");
            System.out.println("for surprising route press 0 ");
            tries = scanner.nextInt();
            if (condition(tries)) {
                System.out.println("Please try again ");
            }

        } while (condition(tries));
        if (tries != 0)
        {
            System.out.println("You choose rout with "+ tries+ "tries");
        }
      return tries;
    }

    public static boolean condition (int tries)
    {
        return tries!=20 && tries!=15 && tries!=10 && tries!=0;
    }

    public static int surprisingRoute ()
    {
        Random random = new Random();
        int tries = random.nextInt(5,26);
        return tries;

    }

    public static boolean haveDuplicates (String guess)
    {
        boolean isHaveDuplicates= false;
        for (int i=0; i< 4;i++)
        {
            for (int j=i+1;j< 4;j++)
            {
                if (guess.charAt(i)==guess.charAt(j))
                {
                    isHaveDuplicates=true;
                }
            }
        }
        return isHaveDuplicates;
    }

    public static int accurateGuess(String guess, String secret)
    {
        int countAccurateGuess = 0;
        for(int i= 0; i<4; i++)
        {
            if (guess.charAt(i) == secret.charAt(i))
                countAccurateGuess++;

        }
        return countAccurateGuess;

    }

    public static int partialGuess(String guess, String secret)
    {
        int countPartialGuess =0;
        for (int i=0; i< 4;i++)
        {
            for (int j=0;j< 4;j++)
            {
                if (i == j && j!=3)
                {
                    j++;
                }
                if (secret.charAt(i) == guess.charAt(j))
                {
                        countPartialGuess++;
                }
            }
        }
        return countPartialGuess;
    }

    public static String getUserGuess ()
    {  Scanner scanner = new Scanner(System.in);
        String guess;
        do {

        System.out.println("Try to guess: ");
        guess = scanner.nextLine();
        if (!checkUserInput(guess))
        {
            System.out.println("The number is invalid ");
            System.out.println("The number should include 4 digits where each digit is between 1-6");
        }
    }while (!checkUserInput(guess));
      return  guess;
    }
    public static boolean checkUserInput (String guess)
    {
        boolean isCorrect = true;
        if (guess.length() !=4)
        {
            isCorrect = false;
        }
        for (int i = 0; i<4; i++)
        {
            if ( Character.getNumericValue(guess.charAt(i)) <1 || Character.getNumericValue(guess.charAt(i)) >6 )
            {
                isCorrect = false;
            }

        }

        return  isCorrect;
    }
}
