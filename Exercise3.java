public class Exercise3 {

    public static int[] createArrayWithoutDuplicates(int[] array) {
        int countDuplicates = 0;
        int[] arrayDuplicateNum = new int[array.length];
        int location = 0;
        for(int i = 0; i< array.length;i++)
        {
            int countContant =countContant(array,array[i]);
            if (countContant!=0 ) {
                if (!isNumAtArrayUntilIndex(arrayDuplicateNum, location + 1, array[i])){
                    countDuplicates += (countContant - 1);
                    arrayDuplicateNum[location] = array[i];
                    location++;
                }else if (array[i] == 0 && indexFirstTime(array,0) == i)
                {
                    countDuplicates += (countContant - 1);
                    arrayDuplicateNum[location] = array[i];
                    location++;

                }
            }

        }

        int location2 = 0;
        int[] arraylessDuplicates = new int[array.length - countDuplicates];
        for (int i = 0; i < array.length; i++) {
            if (!isNumAtArrayUntilIndex(arrayDuplicateNum,location,array[i])) {
                arraylessDuplicates[location2] = array[i];
                location2++;
            } else if ( !isNumAtArrayUntilIndex(arraylessDuplicates,location2,array[i])) {
                arraylessDuplicates[location2] = array[i];
                location2++;
            }

        }
        return arraylessDuplicates;
    }

    public static int countContant(int[] array, int num) {
        int countNum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num)
                countNum++;
        }
        return countNum;
    }

    public static boolean isNumAtArrayUntilIndex (int[] array, int index,int num)
    {
        boolean returnValue = false;
        if (array.length> 0) {
            for (int i = 0; i < index; i++) {
                if (array[i] == num)
                    returnValue = true;
            }
        }
        return returnValue;
    }

    public static int indexFirstTime (int[] array, int num)
    {
        int indexFirstTime = -1;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i]==num)
            {
                indexFirstTime = i;
                break;
            }
        }

        return indexFirstTime;
    }
}
