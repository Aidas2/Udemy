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
package com.itextpdf.html2pdf.element;


import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.LogMessageConstant;
import com.itextpdf.kernel.utils.CompareTool;
import com.itextpdf.test.ExtendedITextTest;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;
import com.itextpdf.test.annotations.type.IntegrationTest;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class HtmlTest extends ExtendedITextTest {

    public static final String sourceFolder = "./src/test/resources/com/itextpdf/html2pdf/element/HtmlTest/";
    public static final String destinationFolder = "./target/test/com/itextpdf/html2pdf/element/HtmlTest/";

    @BeforeClass
    public static void beforeClass() {
        createDestinationFolder(destinationFolder);
    }

    @Test
    public void html01Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "htmlTest01.html"), new File(destinationFolder + "htmlTest01.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "htmlTest01.pdf", sourceFolder + "cmp_htmlTest01.pdf", destinationFolder, "diff01_"));
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = LogMessageConstant.NO_WORKER_FOUND_FOR_TAG)})
    public void html02Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "htmlTest02.html"), new File(destinationFolder + "htmlTest02.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "htmlTest02.pdf", sourceFolder + "cmp_htmlTest02.pdf", destinationFolder, "diff02_"));
    }

    @Test
    public void html03Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "htmlTest03.html"), new File(destinationFolder + "htmlTest03.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "htmlTest03.pdf", sourceFolder + "cmp_htmlTest03.pdf", destinationFolder, "diff03_"));
    }

    // this test is both for html and body
    @Test
    public void html04Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "htmlTest04.html"), new File(destinationFolder + "htmlTest04.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "htmlTest04.pdf", sourceFolder + "cmp_htmlTest04.pdf", destinationFolder, "diff04_"));
    }

    @Test
    public void html05Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "htmlTest05.html"), new File(destinationFolder + "htmlTest05.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "htmlTest05.pdf", sourceFolder + "cmp_htmlTest05.pdf", destinationFolder, "diff05_"));
    }

    // this test is both for html and body
    @Test
    public void html06Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "htmlTest06.html"), new File(destinationFolder + "htmlTest06.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "htmlTest06.pdf", sourceFolder + "cmp_htmlTest06.pdf", destinationFolder, "diff06_"));
    }

    // this test is both for html and body
    @Test
    public void html07Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "htmlTest07.html"), new File(destinationFolder + "htmlTest07.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "htmlTest07.pdf", sourceFolder + "cmp_htmlTest07.pdf", destinationFolder, "diff07_"));
    }

    @Test
    public void html08Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "htmlTest08.html"), new File(destinationFolder + "htmlTest08.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "htmlTest08.pdf", sourceFolder + "cmp_htmlTest08.pdf", destinationFolder, "diff08_"));
    }

    @Test
    public void html09Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "htmlTest09.html"), new File(destinationFolder + "htmlTest09.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "htmlTest09.pdf", sourceFolder + "cmp_htmlTest09.pdf", destinationFolder, "diff09_"));
    }
}
