import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String [] roles= {
                "Городничий","Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String [] textLines={
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println(printTextPerRole(roles, textLines));
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

    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder result = new StringBuilder();

        for (String role : roles) {
            result.append(role).append(":\n");
            for (int TextIndex = 0; TextIndex < textLines.length; TextIndex++) {
                if (textLines[TextIndex].startsWith(role + ":")) {
                    result.append(TextIndex + 1)
                            .append(")")
                            .append(textLines[TextIndex]
                            .replaceFirst((role + ":"), ""))
                            .append("\n");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
}