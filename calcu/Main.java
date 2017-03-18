package calculator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);


        int choice = 0;

        while (choice != 3) {

            System.out.println("1.Wprowadź wyrażenie");
            System.out.println("2.Importuj wyrażenie z pliku");
            System.out.println("3.Zakończ");
            choice = sc.nextInt();


            switch (choice) {
                case 1:
                    System.out.print("Podaj wyrażenie infiksowe: ");
                    String expression = sc.next();
                    ReversePolishNotation reversePn = new ReversePolishNotation(expression);
                    Calculator calculator = new Calculator(reversePn.toString());


                    while (!expression.equals("koniec")) {

                        System.out.println("Wyrażenie: " + expression + " = " + calculator.calculateValue());

                        System.out.print("Podaj nastepne wyrażenie infiksowe: ");

                        expression = sc.next();
                        reversePn = new ReversePolishNotation(expression);
                        calculator = new Calculator(reversePn.toString());
                    }
                    calculator.setExpression(" ");
                    break;

                case 2:
                    FileExpression fileExpression = new FileExpression();
                    fileExpression.generatedFile();
                    File file = new File("expression.txt");
                    Scanner in = new Scanner(file);

                    expression = in.nextLine();

                    System.out.println("Wyrażenia z pliku:");
                    System.out.println();
                    while (in.hasNextLine()) {
                        reversePn = new ReversePolishNotation(expression);
                        calculator = new Calculator(reversePn.toString());

                        System.out.println("Wyrażenie: " + expression + " = " + calculator.calculateValue());
                        expression = in.nextLine();
                    }
                    System.out.println("______________________________________");

                    break;

                case 3:
                    System.out.println("Bye bye");

                default:
                    System.out.println("Niepoprawny wybór !");
            }


        }

    }
}