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
import com.itextpdf.kernel.utils.CompareTool;
import com.itextpdf.test.ExtendedITextTest;
import com.itextpdf.test.annotations.type.IntegrationTest;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class BodyTest extends ExtendedITextTest {

    public static final String sourceFolder = "./src/test/resources/com/itextpdf/html2pdf/element/BodyTest/";
    public static final String destinationFolder = "./target/test/com/itextpdf/html2pdf/element/BodyTest/";

    @BeforeClass
    public static void beforeClass() {
        createDestinationFolder(destinationFolder);
    }

    @Test
    public void body01Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "bodyTest01.html"), new File(destinationFolder + "bodyTest01.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "bodyTest01.pdf", sourceFolder + "cmp_bodyTest01.pdf", destinationFolder, "diff01_"));
    }

    @Test
    public void body02Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "bodyTest02.html"), new File(destinationFolder + "bodyTest02.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "bodyTest02.pdf", sourceFolder + "cmp_bodyTest02.pdf", destinationFolder, "diff02_"));
    }

    @Test
    public void body03Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "bodyTest03.html"), new File(destinationFolder + "bodyTest03.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "bodyTest03.pdf", sourceFolder + "cmp_bodyTest03.pdf", destinationFolder, "diff03_"));
    }

    @Test
    public void body04Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "bodyTest04.html"), new File(destinationFolder + "bodyTest04.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "bodyTest04.pdf", sourceFolder + "cmp_bodyTest04.pdf", destinationFolder, "diff04_"));
    }

    @Test
    public void body05Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "bodyTest05.html"), new File(destinationFolder + "bodyTest05.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "bodyTest05.pdf", sourceFolder + "cmp_bodyTest05.pdf", destinationFolder, "diff05_"));
    }

    @Test
    public void body06Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "bodyTest06.html"), new File(destinationFolder + "bodyTest06.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "bodyTest06.pdf", sourceFolder + "cmp_bodyTest06.pdf", destinationFolder, "diff06_"));
    }

    // this test is both for html and body
    @Test
    public void body07Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "bodyTest07.html"), new File(destinationFolder + "bodyTest07.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "bodyTest07.pdf", sourceFolder + "cmp_bodyTest07.pdf", destinationFolder, "diff07_"));
    }

    // this test is both for html and body
    @Test
    public void body08Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "bodyTest08.html"), new File(destinationFolder + "bodyTest08.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "bodyTest08.pdf", sourceFolder + "cmp_bodyTest08.pdf", destinationFolder, "diff08_"));
    }

    // this test is both for html and body
    @Test
    public void body09Test() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "bodyTest09.html"), new File(destinationFolder + "bodyTest09.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "bodyTest09.pdf", sourceFolder + "cmp_bodyTest09.pdf", destinationFolder, "diff09_"));
    }
}
