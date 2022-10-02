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

import com.itextpdf.html2pdf.attach.impl.OutlineHandler;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.Property;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.test.ExtendedITextTest;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;
import com.itextpdf.test.annotations.type.IntegrationTest;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class Html2ElementsTest extends ExtendedITextTest {

    public static final String destinationFolder = "./target/test/com/itextpdf/html2pdf/Html2ElementsTest/";

    @BeforeClass
    public static void beforeClass() {
        createDestinationFolder(destinationFolder);
    }

    @Test
    public void htmlToElementsTest01() throws IOException {
        String html = "<p>Hello world!</p>";
        List<IElement> lst = HtmlConverter.convertToElements(html);
        Assert.assertTrue(lst.size() == 1);
        Assert.assertTrue(lst.get(0) instanceof Paragraph);
        Paragraph p = (Paragraph) lst.get(0);
        Assert.assertEquals("Hello world!", ((Text) p.getChildren().get(0)).getText());
        Assert.assertEquals(12f, p.<UnitValue>getProperty(Property.FONT_SIZE).getValue(), 1e-10);
    }

    @Test
    public void htmlToElementsTest02() throws IOException {
        String html = "<table style=\"font-size: 2em\"><tr><td>123</td><td><456></td></tr><tr><td>Long cell</td></tr></table>";
        List<IElement> lst = HtmlConverter.convertToElements(html);
        Assert.assertTrue(lst.size() == 1);
        Assert.assertTrue(lst.get(0) instanceof Table);
        Table t = (Table) lst.get(0);
        Assert.assertEquals(2, t.getNumberOfRows());
        Assert.assertEquals("123", ((Text) (((Paragraph) t.getCell(0, 0).getChildren().get(0)).getChildren().get(0))).getText());
        Assert.assertEquals(24f, t.<UnitValue>getProperty(Property.FONT_SIZE).getValue(), 1e-10);
    }

    @Test
    public void htmlToElementsTest03() throws IOException {
        String html = "<p>Hello world!</p><table><tr><td>123</td><td><456></td></tr><tr><td>Long cell</td></tr></table><p>Hello world!</p>";
        List<IElement> lst = HtmlConverter.convertToElements(html);
        Assert.assertTrue(lst.size() == 3);
        Assert.assertTrue(lst.get(0) instanceof Paragraph);
        Assert.assertTrue(lst.get(1) instanceof Table);
        Assert.assertTrue(lst.get(2) instanceof Paragraph);
        Assert.assertEquals("Hello world!", ((Text) ((Paragraph) lst.get(0)).getChildren().get(0)).getText());
        Assert.assertEquals("123", ((Text) (((Paragraph) ((Table) lst.get(1)).getCell(0, 0).getChildren().get(0)).getChildren().get(0))).getText());
    }

    @Test
    // Handles malformed html
    public void htmlToElementsTest04() throws IOException {
        String html = "<p>Hello world!<table><td>123";
        List<IElement> lst = HtmlConverter.convertToElements(html);
        Assert.assertTrue(lst.size() == 2);
        Assert.assertTrue(lst.get(0) instanceof Paragraph);
        Assert.assertTrue(lst.get(1) instanceof Table);
        Assert.assertEquals("Hello world!", ((Text) ((Paragraph) lst.get(0)).getChildren().get(0)).getText());
        Assert.assertEquals("123", ((Text) (((Paragraph) ((Table) lst.get(1)).getCell(0, 0).getChildren().get(0)).getChildren().get(0))).getText());
    }

    @Test
    @LogMessages(messages = {})
    public void htmlToElementsTest05() throws IOException {
        String html = "123";
        List<IElement> lst = HtmlConverter.convertToElements(html);
        Assert.assertTrue(lst.size() == 1);
    }

    @Test
    @LogMessages(messages = {})
    public void htmlElementsTest06() throws IOException {
        String html = "<html>Lorem<p>Ipsum</p>Dolor<p>Sit</p></html>";
        List<IElement> lst = HtmlConverter.convertToElements(html);
        Assert.assertTrue(lst.size() == 4);
        for (int i = 0; i < lst.size(); i++)
            Assert.assertTrue(lst.get(i) instanceof Paragraph);
    }

    @Test
    @LogMessages(messages = {})
    public void htmlElementsTest07() throws IOException {
        String html = "<html>Lorem<span>Dolor</span><p>Ipsum</p><p>Sit</p></html>";
        List<IElement> lst = HtmlConverter.convertToElements(html);
        Assert.assertTrue(lst.size() == 3);
        for (int i = 0; i < lst.size(); i++)
            Assert.assertTrue(lst.get(i) instanceof Paragraph);
    }

    @Test
    // this test checks whether iText fails to process meta tag inside body section or not
    public void htmlToElementsTest08() throws IOException {
        String html = "<html><p>Hello world!</p><meta name=\"author\" content=\"Bruno\"><table><tr><td>123</td><td><456></td></tr><tr><td>Long cell</td></tr></table><p>Hello world!</p></html>";
        HtmlConverter.convertToElements(html);
    }

    @Test
    //Test OutlineHandler exception throwing
    public void htmlToElementsTest09() throws IOException {
        /*
            Outlines require a PdfDocument, and OutlineHandler is based around its availability
            Any convert to elements workflow of course doesn't have a PdfDocument.
            Instead of throwing an NPE when trying it, the OutlineHandler will check for the existence of a pdfDocument
            If no PdfDocument is found, the handler will do nothing silently
         */
        String html = "<html><p>Hello world!</p><meta name=\"author\" content=\"Bruno\"><table><tr><td>123</td><td><456></td></tr><tr><td>Long cell</td></tr></table><p>Hello world!</p></html>";
        ConverterProperties props = new ConverterProperties();
        OutlineHandler outlineHandler = new OutlineHandler();
        outlineHandler.putTagPriorityMapping("h1", 1);
        outlineHandler.putTagPriorityMapping("h3", 2);
        outlineHandler.putTagPriorityMapping("p", 3);
        props.setOutlineHandler(outlineHandler);

        HtmlConverter.convertToElements(html);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = com.itextpdf.styledxmlparser.LogMessageConstant.UNABLE_TO_RETRIEVE_STREAM_WITH_GIVEN_BASE_URI, count = 1),
            @LogMessage(messageTemplate = LogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 1),
            @LogMessage(messageTemplate = LogMessageConstant.PDF_DOCUMENT_NOT_PRESENT, count = 1),
    })
    public void htmlObjectMalformedUrlTest() throws IOException {
        String html = "<object data ='htt://as' type='image/svg+xml'></object>";
        List<IElement> lst = HtmlConverter.convertToElements(html);
        Assert.assertTrue(lst.size() == 0);
    }



}
