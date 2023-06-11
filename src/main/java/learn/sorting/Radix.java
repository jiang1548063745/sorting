package learn.sorting;

import learn.utils.CommonUtils;

import java.util.Arrays;

/**
 * 基数排序(多关键字排序)
 *  时间复杂度
 *  空间复杂度
 *
 * @author JiangJian
 * @date 2023/06/10 23:01
 */
public class Radix {

    public static void main(String[] args) {

        int[] arr = {421, 240, 115, 532, 305, 430, 431, 124};

        int[] result = sort(arr);

        CommonUtils.printArr(result);
    }

    /**
     *
     */
    public static int[] sort(int[] arr) {
        int[] result = new int[arr.length];

        int[] count = new int[10];

        // 最高位数
        for (int i = 0; i < 3; i++) {
            int division = (int)Math.pow(10, i);
            System.out.println(">倍数:" +division);

            for (int k : arr) {
                // 根据规则取余数
                int num = k / division % 10;

                System.out.println(" >>余数:" + num);

                // 在对应的余数位上计数
                count[num]++;
            }

            CommonUtils.printArr(count);

            // 记录出现的位置
            for (int m = 1; m < count.length; m++) {
                count[m] = count[m] + count[m - 1];
            }

            CommonUtils.printArr(count);

            // 拓扑到新数组
            for (int n = arr.length - 1; n >= 0; n--) {
                // 确定余数
                int num = arr[n] / division % 10;
                // 根据余数再计数器记录的位置拓扑到结果中
                result[--count[num]] = arr[n];
            }

            // 结果复制
            System.arraycopy(result, 0, arr, 0, arr.length);

            // 清空计数数组
            Arrays.fill(count, 0);

            CommonUtils.printArr(arr);
        }

        return result;
    }
}
