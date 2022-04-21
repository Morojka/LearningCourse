import java.io.Console;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.function.DoubleUnaryOperator;
import java.util.logging.*;

import PostSystem.*;
import PostSystem.Package;
import Robot.*;
import TextAnalyzers.*;

public class Main {
    public static void main(String[] args) {
    }

    //task 4.3.2
    public static void sendMail() {
        Thief thief = new Thief(10);
        MailService[] services = {thief};

        Package goldPackage = new Package("gold", 20);
        Package bricksPackage = new Package("bricks", 5);
        MailPackage GoldPackageToSend = new MailPackage("me", "you", goldPackage);
        MailPackage BricksPackageToSend = new MailPackage("you", "me", bricksPackage);

        MailMessage message = new MailMessage("me", "you", "Hello, there!");

        UntrustworthyMailWorker postWorker = new UntrustworthyMailWorker(services);
        MailPackage deliveredMail = ((MailPackage) postWorker.processMail(BricksPackageToSend));

        System.out.println(MessageFormat.format("content: {0}, price: {1}", deliveredMail.getContent().getContent(), deliveredMail.getContent().getPrice()));
    }

    //task 4.3.1
    public static void logging() {
        Logger loggingClassA = Logger.getLogger("org.stepic.java.logging.ClassA");
        loggingClassA.setLevel(Level.ALL);
        Logger loggingClassB = Logger.getLogger("org.stepic.java.logging.ClassB");
        loggingClassB.setLevel(Level.WARNING);
        Logger orgStepicJava = Logger.getLogger("org.stepic.java");
        orgStepicJava.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new XMLFormatter());
        orgStepicJava.addHandler(consoleHandler);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 0; i < 3; i++){
            try (RobotConnection connection = robotConnectionManager.getConnection()) {
                connection.moveRobotTo(toX, toY);
                i = 3;
            } catch (RobotConnectionException e) {
                if (i == 2) {
                    throw e;
                }
            }
        }
    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        /*String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };

        System.out.println(checkLabels(textAnalyzers, "Very bad, very neg =(, very ..................").toString());*/
        Label label;

        for (TextAnalyzer analyzer : analyzers) {
            label = analyzer.processText(text);
            if (label != Label.OK) return label;
        }

        return Label.OK;
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
                if (i + 1 < a1.length) {
                    i++;
                } else {
                    for (; j < a2.length; j++) {
                        result[k + 1] = a2[j];
                        k++;
                    }
                    break;
                }
            } else {
                result[k] = a2[j];
                if (j + 1 < a2.length) {
                    j++;
                } else {
                    for (; i < a1.length; i++) {
                        result[k + 1] = a1[i];
                        k++;
                    }
                    break;
                }
            }
        }

        return result;
    }

    private static String printTextPerRole(String[] roles, String[] textLines) {
        /*String [] roles= {
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
        System.out.println(printTextPerRole(roles, textLines));*/
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

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        // System.out.println(integrate(x -> 1, 0, 10)); вызов
        double result = 0;
        double n = 10000000;
        double h = (b - a) / n;

        for (int i = 0; i <= n; i++) {
            result += f.applyAsDouble(a + h * (i + 0.5));
        }
        result *= h;
        return result;
    }
}