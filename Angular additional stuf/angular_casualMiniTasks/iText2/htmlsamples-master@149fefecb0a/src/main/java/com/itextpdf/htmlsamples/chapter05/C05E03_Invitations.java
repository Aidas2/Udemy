/*
 * Copyright 2016-2017, iText Group NV.
 * This example was created by Bruno Lowagie.
 * It was written in the context of the following book:
 * https://leanpub.com/itext7_pdfHTML
 * Go to http://developers.itextpdf.com for more info.
 */
package com.itextpdf.htmlsamples.chapter05;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.attach.ITagWorker;
import com.itextpdf.html2pdf.attach.ProcessorContext;
import com.itextpdf.html2pdf.attach.impl.DefaultTagWorkerFactory;
import com.itextpdf.html2pdf.attach.impl.tags.SpanTagWorker;
import com.itextpdf.html2pdf.html.node.IElementNode;
import com.itextpdf.licensekey.LicenseKey;

/**
 * Creates a series of PDF files from HTML that uses some custom tags.
 */
public class C05E03_Invitations {

	/** The Base URI of the HTML page. */
	public static final String BASEURI = "src/main/resources/html/";
	/** The path to the source HTML file. */
	public static final String SRC = String.format("%sinvitation.html", BASEURI);
	/** The target folder for the result. */
	public static final String TARGET = "target/results/ch05/";
	/** The pattern for the path to the resulting PDF files. */
	public static final String DEST = "target/results/ch05/invitation%s.pdf";

	/**
	 * The main method of this example.
	 *
	 * @param args no arguments are needed to run this example.
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
    public static void main(String[] args) throws IOException {
        LicenseKey.loadLicenseFile(System.getenv("ITEXT7_LICENSEKEY") + "/itextkey-html2pdf_typography.xml");
    	File file = new File(TARGET);
    	file.mkdirs();
        C05E03_Invitations app = new C05E03_Invitations();
        String[] names = {"Bruno Lowagie", "Ingeborg Willaert", "John Doe"};
        int counter = 1;
        for (String name : names) {
        	app.createPdf(name, SRC, String.format(DEST, counter++));
        }
    }

    /**
     * Creates the PDF file.
     *
     * @param name the name that will be used to replace the content of a custom tag
     * @param src the path to the source HTML file
     * @param dest the path to the resulting PDF
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void createPdf(final String name, String src, String dest) throws IOException {
    	final SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setTagWorkerFactory(
        		new DefaultTagWorkerFactory() {
        		    @Override
        		    public ITagWorker getCustomTagWorker(IElementNode tag, ProcessorContext context) {
        		        if ("name".equalsIgnoreCase(tag.name()) ) {
        		            return new SpanTagWorker(tag, context) {
        		            	@Override
        		                public boolean processContent(String content, ProcessorContext context) {
        		                    return super.processContent(name, context);
        		                }
        		            };
        		        }
        		        else if ("date".equalsIgnoreCase(tag.name()) ) {
        		            return new SpanTagWorker(tag, context) {
        		            	@Override
        		                public boolean processContent(String content, ProcessorContext context) {
        		                    return super.processContent(sdf.format(new Date()), context);
        		                }
        		            };
        		        }
        		        return null;
        		    }
        		}
        	);
        HtmlConverter.convertToPdf(new File(src), new File(dest), converterProperties);
    }
}