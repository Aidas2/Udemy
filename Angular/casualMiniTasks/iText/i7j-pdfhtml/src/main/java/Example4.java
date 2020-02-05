import com.itextpdf.html2pdf.HtmlConverter;

import java.io.FileOutputStream;

public class Example4 {
    public static void main(String[] args) {
        new C07E04_CreateFromURL().createPdf(new URL(ADDRESS), DEST);
        
        public void createPdf(URL url, String dest) throws IOException {
            HtmlConverter.convertToPdf(url.openStream(), new FileOutputStream(dest));
        }
    }
    public static final String ADDRESS = "https://stackoverflow.com/help/on-topic";

}
