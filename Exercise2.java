public class Exercise2 {

    public static String cellNum (String cellNum)
    {
        String returnCell= "";
        if (cellNum.length() == 10 )
        { if (cellNum.charAt(0)=='0'&& cellNum.charAt(1)=='5' && isAllNum(cellNum.substring(2)))
            returnCell =returnCell +'0'+'5'+cellNum.charAt(2) + '-' + cellNum.substring(3);

        }else if (cellNum.length() == 11)
        {
            if (cellNum.charAt(0)=='0'&& cellNum.charAt(1)=='5' && cellNum.charAt(3)=='-'
                    && isAllNum(cellNum.substring(4)))
                returnCell = cellNum;

        }else if (cellNum.length() == 12)
        {
            if (cellNum.charAt(0)=='9'&& cellNum.charAt(1)=='7' && cellNum.charAt(2)=='2' &&
                    cellNum.charAt(3)=='5'&& isAllNum(cellNum.substring(4)) )
                returnCell =returnCell +'0'+'5'+cellNum.charAt(4) + '-' + cellNum.substring(5);

        }
        return returnCell;


    }


    public static boolean isAllNum(String string)
    {
        boolean isAllNum=false;
        int count = 0;
        for (int i=0; i<string.length();i++)
        {
            if(string.charAt(i)=='0' ||string.charAt(i)=='1' || string.charAt(i)=='2' ||string.charAt(i)=='3'
                    || string.charAt(i)=='4'|| string.charAt(i)=='5'||string.charAt(i)=='6'||string.charAt(i)=='7'
                    ||string.charAt(i)=='8'|| string.charAt(i)=='9')
                count++;

        }
        if (count == string.length())
            isAllNum = true;

        return isAllNum;

    }

}
