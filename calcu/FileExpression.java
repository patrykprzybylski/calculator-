package calculator;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileExpression {




    public void generatedFile() throws FileNotFoundException {

        PrintWriter printWriter = new PrintWriter("expression.txt");

        printWriter.print("(2+4)*4");
        printWriter.println();
        printWriter.print("(8/4)*4 -1");
        printWriter.println();
        printWriter.print("(2+4)*4+100");
        printWriter.println();
        printWriter.print("(2+4)*4*10");
        printWriter.println();
        printWriter.print("(2+4)*(4*10)+25");
        printWriter.println();
        printWriter.close();

    }
}
