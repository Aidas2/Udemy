/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2020 iText Group NV
    Authors: iText Software.

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License version 3
    as published by the Free Software Foundation with the addition of the
    following permission added to Section 15 as permitted in Section 7(a):
    FOR ANY PART OF THE COVERED WORK IN WHICH THE COPYRIGHT IS OWNED BY
    ITEXT GROUP. ITEXT GROUP DISCLAIMS THE WARRANTY OF NON INFRINGEMENT
    OF THIRD PARTY RIGHTS

    This program is distributed in the hope that it will be useful, but
    WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
    or FITNESS FOR A PARTICULAR PURPOSE.
    See the GNU Affero General Public License for more details.
    You should have received a copy of the GNU Affero General Public License
    along with this program; if not, see http://www.gnu.org/licenses or write to
    the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
    Boston, MA, 02110-1301 USA, or download the license from the following URL:
    http://itextpdf.com/terms-of-use/

    The interactive user interfaces in modified source and object code versions
    of this program must display Appropriate Legal Notices, as required under
    Section 5 of the GNU Affero General Public License.

    In accordance with Section 7(b) of the GNU Affero General Public License,
    a covered work must retain the producer line in every PDF that is created
    or manipulated using iText.

    You can be released from the requirements of the license by purchasing
    a commercial license. Buying such a license is mandatory as soon as you
    develop commercial activities involving the iText software without
    disclosing the source code of your own applications.
    These activities include: offering paid services to customers as an ASP,
    serving PDFs on the fly in a web application, shipping iText with a closed
    source product.

    For more information, please contact iText Software Corp. at this
    address: sales@itextpdf.com
 */
package com.itextpdf.html2pdf;

import com.itextpdf.io.util.UrlUtil;
import com.itextpdf.kernel.utils.CompareTool;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.test.ExtendedITextTest;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;
import com.itextpdf.test.annotations.type.IntegrationTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Category(IntegrationTest.class)
public class Html2PdfTest extends ExtendedITextTest {

    public static final String sourceFolder = "./src/test/resources/com/itextpdf/html2pdf/Html2PdfTest/";
    public static final String destinationFolder = "./target/test/com/itextpdf/html2pdf/Html2PdfTest/";

    @BeforeClass
    public static void beforeClass() {
        createDestinationFolder(destinationFolder);
    }

    @Test
    public void helloWorldParagraphTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "hello_paragraph.html"), new File(destinationFolder + "hello_paragraph.pdf"));
        System.out.println("html: file:///" + UrlUtil.toNormalizedURI(sourceFolder + "hello_paragraph.html").getPath() + "\n");
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "hello_paragraph.pdf", sourceFolder + "cmp_hello_paragraph.pdf", destinationFolder, "diff01_"));
    }

    @Test
    // TODO DEVSIX-1124
    public void helloParagraphTableTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "hello_paragraph_table.html"), new File(destinationFolder + "hello_paragraph_table.pdf"));
        System.out.println("html: file:///" + UrlUtil.toNormalizedURI(sourceFolder + "hello_paragraph_table.html").getPath() + "\n");
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "hello_paragraph_table.pdf", sourceFolder + "cmp_hello_paragraph_table.pdf", destinationFolder, "diff02_"));
    }

    @Test
    public void helloMalformedDocumentTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "hello_malformed.html"), new File(destinationFolder + "hello_malformed.pdf"));
        System.out.println("html: file:///" + UrlUtil.toNormalizedURI(sourceFolder + "hello_malformed.html").getPath() + "\n");
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "hello_malformed.pdf", sourceFolder + "cmp_hello_malformed.pdf", destinationFolder, "diff03_"));
    }

    @Test
    public void helloParagraphJunkSpacesDocumentTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "hello_paragraph_junk_spaces.html"), new File(destinationFolder + "hello_paragraph_junk_spaces.pdf"));
        System.out.println("html: file:///" + UrlUtil.toNormalizedURI(sourceFolder + "hello_paragraph_junk_spaces.html").getPath() + "\n");
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "hello_paragraph_junk_spaces.pdf", sourceFolder + "cmp_hello_paragraph_junk_spaces.pdf", destinationFolder, "diff03_"));
    }

    @Test
    // TODO DEVSIX-1124
    public void helloParagraphNestedInTableDocumentTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "hello_paragraph_nested_in_table.html"), new File(destinationFolder + "hello_paragraph_nested_in_table.pdf"));
        System.out.println("html: file:///" + UrlUtil.toNormalizedURI(sourceFolder + "hello_paragraph_nested_in_table.html").getPath() + "\n");
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "hello_paragraph_nested_in_table.pdf", sourceFolder + "cmp_hello_paragraph_nested_in_table.pdf", destinationFolder, "diff03_"));
    }

    @Test
    public void helloParagraphWithSpansDocumentTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "hello_paragraph_with_span.html"), new File(destinationFolder + "hello_paragraph_with_span.pdf"));
        System.out.println("html: file:///" + UrlUtil.toNormalizedURI(sourceFolder + "hello_paragraph_with_span.html").getPath() + "\n");
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "hello_paragraph_with_span.pdf", sourceFolder + "cmp_hello_paragraph_with_span.pdf", destinationFolder, "diff03_"));
    }

    @Test
    public void helloDivDocumentTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "hello_div.html"), new File(destinationFolder + "hello_div.pdf"));
        System.out.println("html: file:///" + UrlUtil.toNormalizedURI(sourceFolder + "hello_div.html").getPath() + "\n");
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "hello_div.pdf", sourceFolder + "cmp_hello_div.pdf", destinationFolder, "diff03_"));
    }

    @Test
    public void aBlockInPTagTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "aBlockInPTag.html"), new File(destinationFolder + "aBlockInPTag.pdf"));
        System.out.println("html: file:///" + UrlUtil.toNormalizedURI(sourceFolder + "aBlockInPTag.html").getPath() + "\n");
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "aBlockInPTag.pdf", sourceFolder + "cmp_aBlockInPTag.pdf", destinationFolder, "diff03_"));
    }

    @Test
    public void base64svgTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "objectTag_base64svg.html"), new File(destinationFolder + "objectTag_base64svg.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "objectTag_base64svg.pdf", sourceFolder + "cmp_objectTag_base64svg.pdf", destinationFolder, "diff01_"));
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = com.itextpdf.styledxmlparser.LogMessageConstant.UNABLE_TO_RETRIEVE_STREAM_WITH_GIVEN_BASE_URI, count = 1),
            @LogMessage(messageTemplate = LogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 1)})
    public void htmlObjectIncorrectBase64Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "objectTag_incorrectBase64svg.html"), new File(destinationFolder + "objectTag_incorrectBase64svg.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "objectTag_incorrectBase64svg.pdf", sourceFolder + "cmp_objectTag_incorrectBase64svg.pdf", destinationFolder, "diff01_"));

    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = LogMessageConstant.WORKER_UNABLE_TO_PROCESS_IT_S_TEXT_CONTENT, count = 1),
            @LogMessage(messageTemplate = LogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 2),
    })
    public void htmlObjectAltTextTest() throws IOException, InterruptedException {
        //update after DEVSIX-1346
        HtmlConverter.convertToPdf(new File(sourceFolder + "objectTag_altText.html"), new File(destinationFolder + "objectTag_altText.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "objectTag_altText.pdf", sourceFolder + "cmp_objectTag_altText.pdf", destinationFolder, "diff01_"));

    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = LogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 1),})
    public void htmlObjectNestedObjectTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "objectTag_nestedTag.html"), new File(destinationFolder + "objectTag_nestedTag.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "objectTag_nestedTag.pdf", sourceFolder + "cmp_objectTag_nestedTag.pdf", destinationFolder, "diff01_"));

    }


    @Test
    public  void htmlImgBase64SVGTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "imgTag_base64svg.html"), new File(destinationFolder + "imgTag_base64svg.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "imgTag_base64svg.pdf", sourceFolder + "cmp_imgTag_base64svg.pdf", destinationFolder, "diff01_"));
    }
}
