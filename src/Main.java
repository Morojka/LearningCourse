import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeArrays(new int[]{1,2,3}, new int[]{1,3})));
    }

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.valueOf(1);

        for (int i = 1; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];

        for (int i = 0, j = 0, k = 0; k < result.length; k++) {
            if (a1.length == 0) {
                for (; j < result.length; j++) {
                    result[j] = a2[j];
                }
                break;
            } else if (a2.length == 0) {
                for (; i < result.length; i++) {
                    result[i] = a1[i];
                }
                break;
            }

            if (a1[i] <= a2[j]) {
                result[k] = a1[i];
                if (i+1 < a1.length) {
                    i++;
                } else {
                    for (; j < a2.length; j++) {
                        result[k+1] = a2[j];
                        k++;
                    }
                    break;
                }
            } else {
                result[k] = a2[j];
                if (j+1 < a2.length) {
                    j++;
                } else {
                    for (; i < a1.length; i++) {
                        result[k+1] = a1[i];
                        k++;
                    }
                    break;
                }
            }
        }

        return result;
    }
}