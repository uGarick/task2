import java.util.Arrays;
import java.util.OptionalInt;

public class task2 {
    public static void main(String[] args) {
        System.out.println(repeat("mice", 5));

        int[] arr = new int[]{10, 4, 1, 4, -10, -50, 32, 21};
        System.out.println(differenceMaxMin(arr));

        arr = new int[]{1, 5, 6};
        System.out.println(isAvgWhole(arr));

        arr = new int[]{1, -2, 3};
        System.out.println(cumulativeSum(arr));

        System.out.println(getDecimalPlaces("43.20"));

        System.out.println(Fibonacci(7));

        System.out.println(isValid("590a01"));

        System.out.println(isStrangePair("ratio", "orator"));

        System.out.println(isPrefix("automation", "auto-"));

        System.out.println(isSuffix("arachnophobia", "-phobia"));

        System.out.println(boxSeq(3));
    }

    public static StringBuilder repeat(String str, int n) {
        char[] strArray = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < n; j++) {
                result.append(strArray[i]);
            }
        }
        return result;
    }

    public static int differenceMaxMin (int[] arr) {
        int maxArr = Arrays.stream(arr).max().getAsInt();
        int minArr = Arrays.stream(arr).min().getAsInt();
        return maxArr-minArr;
    }

    public static boolean isAvgWhole(int[] arr) {
        double arrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
        }
        double arrAvg = arrSum/arr.length;
        return Math.round(arrAvg) == arrAvg;
    }

    public static int[] cumulativeSum(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += arr[j];
            }
            result[i] = sum;
        }
        System.out.printf(Arrays.toString(result) + ":\t");
        return result;
    }

    public static int getDecimalPlaces(String num) {
        int result = 0;

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '.') {
                result = num.length() - i - 1;
            }
        }

        return result;
    }

    public static int Fibonacci(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        if (n > 2) {
            for (int i = 2; i < arr.length; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr[n-1];
    }

    public static boolean isValid(String str) {
        if (str.length() != 5) return false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') return false;
        }
        String num = "1234567890";
        for (int i = 0; i < str.length(); i++) {
            boolean isDigit = false;
            for (int j = 0; j < num.length(); j++) {
                if (str.charAt(i) == num.charAt(j)) isDigit = true;
            }
            if (!isDigit) return false;
        }
        return true;
    }

    public static boolean isStrangePair(String a, String b) {
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        if (a.length() == 0 && b.length() == 0) return true;
        if (a.length() == 0 || b.length() == 0) return false;
        return (aArray[0] == bArray[bArray.length - 1]) && (aArray[aArray.length - 1] == bArray[0]);
    }

    public static boolean isPrefix(String str, String prefix) {
        if (prefix.charAt(prefix.length() - 1) != '-') return false;
        StringBuffer nPrefix = new StringBuffer(prefix);
        nPrefix.delete(nPrefix.length()-1, nPrefix.length());
        return str.startsWith(nPrefix.toString());
    }

    public static boolean isSuffix(String str, String suffix) {
        if (suffix.charAt(0) != '-') return false;
        StringBuffer nSuffix = new StringBuffer(suffix);
        nSuffix.delete(0, 1);
        return str.endsWith(nSuffix.toString());
    }

    public static int boxSeq(int step) {
        int result = 0;
        for (int i = 1; i <= step; i++){
            if (i % 2 == 1) result += 3;
            if (i % 2 == 0) result -= 1;
        }
        return result;
    }
}
