/*
 * Copyright 2016-2017, iText Group NV.
 * This example was created by Bruno Lowagie.
 * It was written in the context of the following book:
 * https://leanpub.com/itext7_pdfHTML
 * Go to http://developers.itextpdf.com for more info.
 */
package com.itextpdf.htmlsamples.chapter07;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;
import com.itextpdf.licensekey.LicenseKey;

public class C07E08_Metadata {

	/** The Base URI of the HTML page. */
	public static final String BASEURI = "src/main/resources/html/";
	/** The path to the source HTML file. */
	public static final String SRC = String.format("%smetadata.html", BASEURI);
	/** The target folder for the result. */
	public static final String TARGET = "target/results/ch07/";
	/** The path to the resulting PDF file. */
	public static final String DEST = String.format("%smetadata.pdf", TARGET);

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
    	C07E08_Metadata app = new C07E08_Metadata();
        app.createPdf(SRC, DEST);
    }

    /**
     * Creates the PDF file.
     *
     * @param src the path to the source HTML file
     * @param dest the path to the resulting PDF
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void createPdf(String src, String dest) throws IOException {
    	PdfWriter writer = new PdfWriter(dest, new WriterProperties().addXmpMetadata());
		HtmlConverter.convertToPdf(new FileInputStream(src), writer);
    }

}
