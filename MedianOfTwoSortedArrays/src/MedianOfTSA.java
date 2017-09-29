import java.util.Scanner;

/**
 * Created by DELL on 2017/9/27.
 */
public class MedianOfTSA
{
    /*
     * 关键在于中位数的意义：分割
     */

    public static double findMedianSortedArrays(int[] A, int[] B)
    {
        int m = A.length, n = B.length;

        /*
         * 为了下面计算j的式子恒大于零，我们需要让A为相对较短的数组
         */
        if (m > n)
        {
            int[] temp = A;
            A = B;
            B = temp;

            m = A.length;
            n = B.length;
        }

        /*
         * 这里定义了i的意义：表示中位数分割的左部分的元素个数
         */
        int iMin = 0, iMax = m;

        while (iMin <= iMax)
        {
            int i = (iMin + iMax) / 2;
            /*
             * 这里经过了推导
             * 如果m+n是奇数，中位数划在了左部分
             */
            int j = (m + n + 1) / 2 - i;

            if (i > iMin && A[i-1] > B[j])
            {
                iMax--;
            }
            else if (i < iMax && B[j-1] > A[i])
            {
                iMin++;
            }
            else
            {
                int maxLeft = 0, minRight = 0, sum = m + n;

                if (i == 0)
                    maxLeft = B[j-1];
                else if (j == 0)
                    maxLeft = A[i-1];
                else
                    maxLeft = Math.max(A[i-1], B[j-1]);

                if (sum % 2 == 1)
                    return maxLeft;

                if (i == m)
                    minRight = B[j];
                else if (j == n)
                    minRight = A[i];
                else
                    minRight = Math.min(A[i], B[j]);

                double result = (maxLeft + minRight) / 2.0;
                return result;
            }
        }
        return 0.0;
    }
//    public double findMedianSortedArrays(int[] A, int[] B)
//    {
//        int m = A.length, n = B.length;
//
//        //要以A为基准，所以要短的，保证式子的值在0以上
//        if (m > n)
//        {
//            //交换A和B
//            int[] temp;
//            temp = A;
//            B = A;
//            A = temp;
//
//            m = A.length;
//            n = B.length;
//        }
//
//        int iMin = 0, iMax = m;
//        while (iMin <= iMax)
//        {
//            int i = (iMin + iMax) / 2;
//            int j = (m + n + 1) / 2 - i;
//
//            if (iMin < iMax && A[i-1] > B[j])
//            {
//                iMax--;
//            }
//            else if (iMin < iMax && B[j-1] > A[i])
//            {
//                iMin++;
//            }
//            else
//            {
//                //满足条件了，可以准备输出了
//                int maxLeft = 0, minRight = 0;
//                if (i == 0)
//                    maxLeft = B[j-1];
//                else if (j == 0)
//                    maxLeft = A[i-1];
//                else
//                    maxLeft = Math.max(A[i-1], B[j-1]);
//
//                if ((m + n) % 2 == 1)
//                    return maxLeft;
//
//                if (i == m)
//                    minRight = B[j];
//                else if (j == n)
//                    minRight = A[i];
//                else
//                    minRight = Math.min(A[i], B[j]);
//
//                return (maxLeft + minRight) / 2.0;
//            }
//        }
//        return 0.0;
//    }

    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);

        int m = input.nextInt();
        int[] A = new int[m];
        for (int i = 0; i < m; i++)
            A[i] = input.nextInt();

        int n = input.nextInt();
        int[] B = new int[n];
        for (int i = 0; i < n; i++)
            B[i] = input.nextInt();

        System.out.println(findMedianSortedArrays(A, B));
    }
}
