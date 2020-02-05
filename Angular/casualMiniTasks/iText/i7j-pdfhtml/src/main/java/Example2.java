import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Example2 {
    public static void main(String[] args) throws IOException {

        File outputFile = new File("C:\\Udemy_etc\\Angular\\casualMiniTasks\\iText\\example2_output.pdf");

        ConverterProperties properties = new ConverterProperties();
        properties.setBaseUri("C:\\Udemy_etc\\Angular\\casualMiniTasks\\iText\\");

        HtmlConverter.convertToDocument("<h1>Test</h1><p>Hello World</p><img src=\"img/logo.png\">", new PdfWriter(outputFile), properties);

        try {
            Desktop.getDesktop().open(outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
