import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example3 {
    public static void main(String[] args) throws IOException {

        // IO
        File htmlSource = new File("C:\\Udemy_etc\\Angular\\casualMiniTasks\\iText\\input.html");
//        File htmlSource = new File("http://www.slf4j.org/codes.html#StaticLoggerBinder");
        File pdfDest = new File("C:\\Udemy_etc\\Angular\\casualMiniTasks\\iText\\output.pdf");
        // pdfHTML specific code
        ConverterProperties converterProperties = new ConverterProperties();
        HtmlConverter.convertToPdf(new FileInputStream(htmlSource),
                new FileOutputStream(pdfDest), converterProperties);

    }
}
