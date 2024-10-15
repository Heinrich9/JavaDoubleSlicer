import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main
{
    static void print(String s)
    {
        System.out.println(s);
    }
    public static void main(String[] args)
    {
        int numIndexesChosen = 0;
        Scanner scanner = new Scanner(System.in);

        Integer [] ints = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        Double [] doubles = new Double[ints.length];

        for (int i = 0; i < doubles.length; i++)
        {
            doubles[i] = Double.valueOf((double)(ints[i]));
        }
        ArrayList<ArrayList<Double>> doubleMatrix = new ArrayList<>();

        for (int i = 0; i < doubles.length; i++)
        {
            System.out.println("index: "+ i + " = " + doubles[i]);
        }

        print("\nChoose your indexes you wish to slice at (press 0 to end): \n");

        String lineRead = scanner.next();
        int indexRead = Integer.parseInt(lineRead);

        ArrayList <Integer> indexSlices = new ArrayList<>();

        while(!lineRead.equals("0"))
        {
            indexSlices.add(indexRead);

            numIndexesChosen++;
            lineRead = scanner.next();
            indexRead = Integer.parseInt(lineRead);
        }
        int firstIndex = 0;
        int lastIndex = doubles.length-1;

        print("\nYou have inputted "+numIndexesChosen+" indexes");

        print("The indexes you entered: \n");

        for (int i = 0; i < indexSlices.size(); i++)
        {
            print(indexSlices.get(i).toString());
        }

        print("\nThe characters for those indexes: \n");

        for (int i = 0; i < indexSlices.size(); i++)
        {
            print(doubles[indexSlices.get(i)].toString());
        }

        print("\nSorting indexes...\n");

        indexSlices.add(firstIndex);
        indexSlices.add(lastIndex);

        Collections.sort(indexSlices);

        int numIndexesInTotal = indexSlices.size();

        print("These are all the indexes you'll need to do the slices: \n");

        print(indexSlices +"\n");

        for (int i = 1; i < indexSlices.size(); i++)
        {
            ArrayList <Double> temp = new ArrayList<>();

            for (int j = indexSlices.get(i-1); j <= indexSlices.get(i); j++)
            {
                temp.add(doubles[j]);
                //print(temp.get(j).toString());
            }
            if(i > 1 || i < indexSlices.size())
            {
                if(i != 1)
                {
                    temp.remove(0);//TEST UPDATE
                }
            }
            doubleMatrix.add(temp);
            print("********************");
        }
        print(doubleMatrix.toString());
    }
}