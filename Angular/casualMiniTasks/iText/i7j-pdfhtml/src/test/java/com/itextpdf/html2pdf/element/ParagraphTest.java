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
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.io.IOException;

@Category(IntegrationTest.class)
public class ParagraphTest extends ExtendedITextTest {

    public static final String sourceFolder = "./src/test/resources/com/itextpdf/html2pdf/element/ParagraphTest/";
    public static final String destinationFolder = "./target/test/com/itextpdf/html2pdf/element/ParagraphTest/";

    @BeforeClass
    public static void beforeClass() {
        createDestinationFolder(destinationFolder);
    }

    @Test
    public void paragraphTest01() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphTest01.html"), new File(destinationFolder + "paragraphTest01.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphTest01.pdf", sourceFolder + "cmp_paragraphTest01.pdf", destinationFolder, "diff01_"));
    }

    @Test
    public void paragraphWithBordersTest01() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithBordersTest01.html"), new File(destinationFolder + "paragraphWithBordersTest01.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithBordersTest01.pdf", sourceFolder + "cmp_paragraphWithBordersTest01.pdf", destinationFolder, "diff02_"));
    }

    @Test
    public void paragraphWithMarginsTest01() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithMarginsTest01.html"), new File(destinationFolder + "paragraphWithMarginsTest01.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithMarginsTest01.pdf", sourceFolder + "cmp_paragraphWithMarginsTest01.pdf", destinationFolder, "diff03_"));
    }

    @Test
    public void paragraphWithPaddingTest01() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithPaddingTest01.html"), new File(destinationFolder + "paragraphWithPaddingTest01.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithPaddingTest01.pdf", sourceFolder + "cmp_paragraphWithPaddingTest01.pdf", destinationFolder, "diff04_"));
    }

    @Test
    public void paragraphWithFontAttributesTest01() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithFontAttributesTest01.html"), new File(destinationFolder + "paragraphWithFontAttributesTest01.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithFontAttributesTest01.pdf", sourceFolder + "cmp_paragraphWithFontAttributesTest01.pdf", destinationFolder, "diff05_"));
    }
    
    @Test
    public void paragraphWithNonBreakableSpaceTest01() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithNonBreakableSpaceTest01.html"), new File(destinationFolder + "paragraphWithNonBreakableSpaceTest01.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithNonBreakableSpaceTest01.pdf", sourceFolder + "cmp_paragraphWithNonBreakableSpaceTest01.pdf", destinationFolder, "diff06_"));
    }

    @Test
    public void paragraphWithNonBreakableSpaceTest02() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithNonBreakableSpaceTest02.html"), new File(destinationFolder + "paragraphWithNonBreakableSpaceTest02.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithNonBreakableSpaceTest02.pdf", sourceFolder + "cmp_paragraphWithNonBreakableSpaceTest02.pdf", destinationFolder, "diff07_"));
    }

    @Test
    public void paragraphWithNonBreakableSpaceTest03() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithNonBreakableSpaceTest03.html"), new File(destinationFolder + "paragraphWithNonBreakableSpaceTest03.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithNonBreakableSpaceTest03.pdf", sourceFolder + "cmp_paragraphWithNonBreakableSpaceTest03.pdf", destinationFolder, "diff08_"));
    }

    @Test
    public void paragraphInTablePercentTest01() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphInTablePercentTest01.html"), new File(destinationFolder + "paragraphInTablePercentTest01.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphInTablePercentTest01.pdf", sourceFolder + "cmp_paragraphInTablePercentTest01.pdf", destinationFolder, "diff09_"));
    }

    @Test
    public void paragraphWithButtonInputLabelSelectTextareaTest() throws IOException, InterruptedException {
        //TODO: update after DEVSIX-2445 fix
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithButtonInputLabelSelectTextareaTest.html"), new File(destinationFolder + "paragraphWithButtonInputLabelSelectTextareaTest.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithButtonInputLabelSelectTextareaTest.pdf", sourceFolder + "cmp_paragraphWithButtonInputLabelSelectTextareaTest.pdf", destinationFolder, "diff11_"));
    }

    @LogMessages(messages = {@LogMessage(messageTemplate = LogMessageConstant.NO_WORKER_FOUND_FOR_TAG, count = 2)})
    @Test
    public void paragraphWithBdoBrImgMapQSubSupTest() throws IOException, InterruptedException {
        //TODO: update after DEVSIX-2445 fix
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithBdoBrImgMapQSubSupTest.html"), new File(destinationFolder + "paragraphWithBdoBrImgMapQSubSupTest.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithBdoBrImgMapQSubSupTest.pdf", sourceFolder + "cmp_paragraphWithBdoBrImgMapQSubSupTest.pdf", destinationFolder, "diff12_"));
    }

    @LogMessages(messages = {@LogMessage(messageTemplate = LogMessageConstant.NO_WORKER_FOUND_FOR_TAG, count = 2)})
    @Test
    public void paragraphWithAbbrAcronymCireCodeDfnEmKbdSampVarTest() throws IOException, InterruptedException {
        //TODO: update after DEVSIX-2445 fix
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithAbbrAcronymCireCodeDfnEmKbdSampVarTest.html"), new File(destinationFolder + "paragraphWithAbbrAcronymCireCodeDfnEmKbdSampVarTest.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithAbbrAcronymCireCodeDfnEmKbdSampVarTest.pdf", sourceFolder + "cmp_paragraphWithAbbrAcronymCireCodeDfnEmKbdSampVarTest.pdf", destinationFolder, "diff13_"));
    }

    @Test
    public void paragraphWithAParagraphSpanDivTest() throws IOException, InterruptedException {
        //TODO: update after DEVSIX-2445 fix
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithAParagraphSpanDivTest.html"), new File(destinationFolder + "paragraphWithAParagraphSpanDivTest.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithAParagraphSpanDivTest.pdf", sourceFolder + "cmp_paragraphWithAParagraphSpanDivTest.pdf", destinationFolder, "diff14_"));
    }

    @LogMessages(messages = {@LogMessage(messageTemplate = LogMessageConstant.NO_WORKER_FOUND_FOR_TAG, count = 2)})
    @Test
    public void paragraphWithBBigISmallTtStrongTest() throws IOException, InterruptedException {
        //TODO: update after DEVSIX-2445 fix
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithBBigISmallTtStrongTest.html"), new File(destinationFolder + "paragraphWithBBigISmallTtStrongTest.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithBBigISmallTtStrongTest.pdf", sourceFolder + "cmp_paragraphWithBBigISmallTtStrongTest.pdf", destinationFolder, "diff15_"));
    }

    @Test
    public void paragraphWithPDisplayTableTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithPDisplayTableTest.html"), new File(destinationFolder + "paragraphWithPDisplayTableTest.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithPDisplayTableTest.pdf", sourceFolder + "cmp_paragraphWithPDisplayTableTest.pdf", destinationFolder, "diff15_"));
    }

    @Test
    public void paragraphWithDifferentSpansTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithDifferentSpansTest.html"), new File(destinationFolder + "paragraphWithDifferentSpansTest.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithDifferentSpansTest.pdf", sourceFolder + "cmp_paragraphWithDifferentSpansTest.pdf", destinationFolder, "diff15_"));
    }

    @Test
    public void paragraphWithDifferentBlocksAndDisplaysTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithDifferentBlocksAndDisplaysTest.html"), new File(destinationFolder + "paragraphWithDifferentBlocksAndDisplaysTest.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithDifferentBlocksAndDisplaysTest.pdf", sourceFolder + "cmp_paragraphWithDifferentBlocksAndDisplaysTest.pdf", destinationFolder, "diff15_"));
    }

    @Test
    public void paragraphWithLabelSpanDisplayBlockTest() throws IOException, InterruptedException {
        //TODO: update after DEVSIX-2619 fix
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithLabelSpanDisplayBlockTest.html"), new File(destinationFolder + "paragraphWithLabelSpanDisplayBlockTest.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithLabelSpanDisplayBlockTest.pdf", sourceFolder + "cmp_paragraphWithLabelSpanDisplayBlockTest.pdf", destinationFolder, "diff15_"));
    }

    @Test
    public void paragraphWithImageTest01() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithImageTest01.html"), new File(destinationFolder + "paragraphWithImageTest01.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithImageTest01.pdf", sourceFolder + "cmp_paragraphWithImageTest01.pdf", destinationFolder, "diff_paragraphWithImageTest01_"));
    }

    @Test
    public void paragraphWithImageTest01RTL() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(sourceFolder + "paragraphWithImageTest01RTL.html"), new File(destinationFolder + "paragraphWithImageTest01RTL.pdf"));
        Assert.assertNull(new CompareTool().compareByContent(destinationFolder + "paragraphWithImageTest01RTL.pdf", sourceFolder + "cmp_paragraphWithImageTest01RTL.pdf", destinationFolder, "diff_paragraphWithImageTest01_"));
    }
}
