import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.File;
import java.io.IOException;

public class Example1 {
    public static void main(String[] args) throws IOException {

        File outputFile = new File("C:\\Udemy_etc\\Angular\\casualMiniTasks\\iText\\example1_output.pdf");

        HtmlConverter.convertToDocument("<h1>Test</h1><p>Hello World</p>", new PdfWriter(outputFile));

//        try {
//            Desktop.getDesktop().open(outputFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
