import java.util.Scanner;

public class Exercise6 {

    public static void main(String[] args)
    {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Please enter quadratic equation, from the following form  ax^2+bx+c=0");
        String quadraticEquation=scanner.nextLine();
        if (isQuadraticEquationRight(quadraticEquation))
        {
            int a = parameterA(quadraticEquation);
            int b = parameterB(quadraticEquation);
            int c = parameterC(quadraticEquation);
            System.out.println("For " +quadraticEquation);
            printSolutions(a,b,c);
        }else {
            System.out.println("You didn't write the equation from the right shape");
        }
    }


    public static boolean isQuadraticEquationRight(String quadraticEquation) {
        boolean isQuadraticEquationRight = true;

            int countAppearancesOfX = 0;
            int countPlusOrMinus = 0;
            for (int i = 0; i < quadraticEquation.length() - 2; i++) {

                if ( i>0 && (quadraticEquation.charAt(i) == '+' || quadraticEquation.charAt(i) == '-')) {
                    countPlusOrMinus++;
                }

                if (quadraticEquation.charAt(i) == 'x') {
                    countAppearancesOfX++;
                    if (countAppearancesOfX == 1 && (quadraticEquation.charAt(i + 1) != '^'
                            || quadraticEquation.charAt(i + 2) != '2')) {

                        isQuadraticEquationRight = false;
                    }

                }
            }
            if (countAppearancesOfX != 2 || countPlusOrMinus != 2 ) {
                isQuadraticEquationRight = false;
            }
            if (quadraticEquation.charAt(quadraticEquation.indexOf("=0")-1) =='-'||
                    quadraticEquation.charAt(quadraticEquation.indexOf("=0")-1) =='+')
            {
                isQuadraticEquationRight=false;
            }
            if (!quadraticEquation.endsWith("=0")) {
                isQuadraticEquationRight = false;
            }

        return isQuadraticEquationRight;
    }

    public static int parameterA (String quadraticEquation)
    {
        String parameterA= quadraticEquation.substring(0, quadraticEquation.indexOf("x^2"));
        int a;
        if (parameterA.equals("")|| parameterA.equals("+") )
        {
            a = 1;
        } else if (parameterA.equals("-") ) {
            a=-1;
        } else {
            a=Integer.parseInt(parameterA);
        }
        return a;
    }

    public static int parameterB (String quadraticEquation)
    {
        String parameterB ="";
        for (int i = quadraticEquation.indexOf("x^2")+3; i < quadraticEquation.length() ; i++)
        {
            if (quadraticEquation.charAt(i) != 'x')
            {
                parameterB += quadraticEquation.charAt(i);
            }else {
                break;
            }

        }
        int b;
        if ( parameterB.equals("+") )
        {
            b = 1;
        } else if (parameterB.equals("-") ) {
            b=-1;
        } else {
            b=Integer.parseInt(parameterB);
        }
        return b;
    }

    public static int parameterC(String quadraticEquation)
    {
        String parameterC ="";
        if (quadraticEquation.indexOf("x-")!= -1)
        {
            parameterC=quadraticEquation.substring(quadraticEquation.indexOf("x-")+1,quadraticEquation.indexOf("=0"));
        }else {
            parameterC=quadraticEquation.substring(quadraticEquation.indexOf("x+")+1,quadraticEquation.indexOf("=0"));
        }
        return Integer.parseInt(parameterC);
    }

    public static void printSolutions (int a, int b,int c)
    {
        float x1;
        float x2;
        float discriminanta =  (b*b-4*a*c);
        if (discriminanta >0)
        {
            x1 = (float) (-b + Math.sqrt(discriminanta)) / (2 * a);
            x2 = (float) (-b - Math.sqrt(discriminanta)) / (2 * a);
            System.out.println("we have two solutions: x1:" +x1 +" x2:" +x2);
        } else if (discriminanta== 0)
        {
            x1 = (float) (-b + Math.sqrt(discriminanta)) / (2 * a);
            System.out.println("we have one solution x= " +x1);
        } else {
            System.out.println("we don't have solution");
        }
    }

  }

