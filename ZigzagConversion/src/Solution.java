import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by DELL on 2017/10/21.
 */
/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P.......A........H.......N
   ..A...P....L..S....I...I...G
   ....Y.......I........R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Solution
{
    public static String convert(String s, int numRows)
    {
        char[] srcArray = s.toCharArray();
        int n = srcArray.length;
        boolean down = true;
        ArrayList<ArrayList<Character>> dst = new ArrayList<ArrayList<Character>>();
        int dstIndex = 0;

        for (int i = 0; i < numRows; i++)
            dst.add(new ArrayList<Character>());

        for (int i = 0; i < n; i++)
        {
            dst.get(dstIndex).add(srcArray[i]);

            if (down)
            {
                dstIndex = (dstIndex + 1 > numRows - 1) ? dstIndex : dstIndex + 1;
                if (dstIndex >= numRows - 1)
                    down = false;
            }
            else
            {
                dstIndex = (dstIndex - 1 < 0) ? dstIndex : dstIndex - 1;
                if (dstIndex <= 0)
                    down = true;
            }
        }

        StringBuilder dstString = new StringBuilder();
        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < dst.get(i).size(); j++)
                dstString.append(dst.get(i).get(j));
        }

        return dstString.toString();
    }


    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);

        String srcString = input.nextLine();
        int size = input.nextInt();

        System.out.format("Result: %s", convert(srcString, size));
    }
}
