public class Exercise4 {


        public static int indexOfSummit (int[] array)
    {
        int indexOfSummit = -1;
         int indexOfEndRisingArray =indexOfEndRisingArray(array);
        int indexOfEndDownArray = indexOfEndDownArray(array,indexOfEndRisingArray);
        if (indexOfEndDownArray ==array.length -1)
        {
            indexOfSummit= indexOfEndRisingArray;
          }
        return indexOfSummit;
    }


    public static int indexOfEndRisingArray (int[] array)
    {
        int index = 0;

        for (int i = 0; i < array.length -1; i++)
        {
            if (array[i]> array[i+1])
            {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int indexOfEndDownArray (int[] array, int startIndex)
    {
        int index = startIndex;

        for (int i = startIndex; i < array.length -1; i++)
        {
            if (array[i]< array[i+1])
            {
                index = i;
                break;
            }
        }
        return index;
    }


}
