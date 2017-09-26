import java.util.Scanner;

/**
 * Created by DELL on 2017/9/24.
 */
public class Solution
{

/*
 * Brute Force
 */
//    public static String longestPalindrome(String s)
//    {
//        if (null == s)
//            return null;
//
//        String result = null;
//        int n = s.length();
//        int max = 0;
//        for (int i = 0; i < n; i++)
//        {
//            for (int j = n - 1; j >= i; j--)
//            {
//                if (isPalindrome(s.substring(i, j+1)) && (j - i + 1) > max)
//                {
//                    max = j - i + 1;
//                    if (i == j)
//                        result = String.valueOf(s.charAt(i));
//                    else
//                        result = s.substring(i, j+1);
//                }
//            }
//        }
//
//        return result;
//    }
//public static boolean isPalindrome(String src)
//{
//    if (null == src)
//    {
//        System.out.println("src is null");
//        return false;
//    }
//
//    int n = src.length();
//    for (int i = 0, j = n - 1; i <= j; i++, j--)
//    {
//        if (src.charAt(i) != src.charAt(j))
//            return false;
//    }
//    return true;
//}


    /*
     * Approach 4
     * 遍历这个字符串[O(n)]，以每一个字符/相邻的两个字符向周围扩展[O(n)]
     * 满足条件便记录下来长度，最后取最大的然后这是就可以计算如何截取字符串的收尾index
     * 截取字符串返回
     * bingo
     */

    public static String longestPalindrome(String src)
    {
        int n = src.length();
        int start = 0, end = 1, maxLength = 0;
        for (int i = 0; i < n; i++)
        {
            int simpleLength = -1, doubleLength = 0;

            int l = i, r = i;
            while (l >= 0 && r < n && src.charAt(l) == src.charAt(r))
            {
                l--;
                r++;
                simpleLength += 2;
            }

            l = i;
            r = i + 1;

            while (l >= 0 && r < n && src.charAt(l) == src.charAt(r))
            {

                l--;
                r++;
                doubleLength += 2;
            }

            int moreLength = Math.max(simpleLength, doubleLength);

            if (moreLength > maxLength)
            {
                maxLength = moreLength;
                start = i - (moreLength - 1) / 2;
                end = i + moreLength / 2 + 1;
            }
        }
        return src.substring(start, end);
    }



    public static void main (String[] args)
    {
        String test = "bb";

        System.out.println(longestPalindrome(test));

    }
}
