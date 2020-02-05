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
package com.itextpdf.html2pdf.css;

import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;
import com.itextpdf.html2pdf.LogMessageConstant;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;
import com.itextpdf.test.annotations.type.IntegrationTest;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.IOException;

@Category(IntegrationTest.class)
public class PseudoElementsTest extends ExtendedHtmlConversionITextTest {
    public static final String destinationFolder = "./target/test/com/itextpdf/html2pdf/css/PseudoElementsTest/";
    public static final String sourceFolder = "./src/test/resources/com/itextpdf/html2pdf/css/PseudoElementsTest/";

    @BeforeClass
    public static void beforeClass() {
        createOrClearDestinationFolder(destinationFolder);
    }

    @Test
    public void beforeAfterPseudoTest01() throws IOException, InterruptedException {
        convertToPdfAndCompare("beforeAfterPseudoTest01", sourceFolder, destinationFolder);
    }

    @Test
    public void beforeAfterPseudoTest02() throws IOException, InterruptedException {
        convertToPdfAndCompare("beforeAfterPseudoTest02", sourceFolder, destinationFolder);
    }

    @Test
    public void beforeAfterPseudoTest03() throws IOException, InterruptedException {
        convertToPdfAndCompare("beforeAfterPseudoTest03", sourceFolder, destinationFolder);
    }

    @Test
    public void beforeAfterPseudoTest04() throws IOException, InterruptedException {
        convertToPdfAndCompare("beforeAfterPseudoTest04", sourceFolder, destinationFolder);
    }

    @Test
    public void beforeAfterPseudoTest05() throws IOException, InterruptedException {
        convertToPdfAndCompare("beforeAfterPseudoTest05", sourceFolder, destinationFolder);
    }

    @Test
    public void beforeAfterPseudoTest06() throws IOException, InterruptedException {
        convertToPdfAndCompare("beforeAfterPseudoTest06", sourceFolder, destinationFolder);
    }

    @Test
    public void beforeAfterPseudoTest07() throws IOException, InterruptedException {
        convertToPdfAndCompare("beforeAfterPseudoTest07", sourceFolder, destinationFolder);
    }

    @Test
    public void beforeAfterPseudoTest10() throws IOException, InterruptedException {
        convertToPdfAndCompare("beforeAfterPseudoTest10", sourceFolder, destinationFolder);
    }

    @Test
    public void beforeAfterPseudoTest11() throws IOException, InterruptedException {
        convertToPdfAndCompare("beforeAfterPseudoTest11", sourceFolder, destinationFolder);
    }

    @Test
    public void beforeAfterPseudoTest12() throws IOException, InterruptedException {
        convertToPdfAndCompare("beforeAfterPseudoTest12", sourceFolder, destinationFolder);
    }

    @Test
    public void beforeAfterPseudoTest13() throws IOException, InterruptedException {
        convertToPdfAndCompare("beforeAfterPseudoTest13", sourceFolder, destinationFolder);
    }

    @Test
    public void beforeAfterPseudoTest14() throws IOException, InterruptedException {
        convertToPdfAndCompare("beforeAfterPseudoTest14", sourceFolder, destinationFolder);
    }

    @Test
    public void collapsingMarginsBeforeAfterPseudo01() throws IOException, InterruptedException {
        convertToPdfAndCompare("collapsingMarginsBeforeAfterPseudo01", sourceFolder, destinationFolder);
    }

    @Test
    public void collapsingMarginsBeforeAfterPseudo02() throws IOException, InterruptedException {
        convertToPdfAndCompare("collapsingMarginsBeforeAfterPseudo02", sourceFolder, destinationFolder);
    }

    @Test
    //TODO: incorrect behaviour because of trimmed non-breakable space
    public void collapsingMarginsBeforeAfterPseudo03() throws IOException, InterruptedException {
        convertToPdfAndCompare("collapsingMarginsBeforeAfterPseudo03", sourceFolder, destinationFolder);
    }

    @Test
    public void collapsingMarginsBeforeAfterPseudo04() throws IOException, InterruptedException {
        convertToPdfAndCompare("collapsingMarginsBeforeAfterPseudo04", sourceFolder, destinationFolder);
    }

    @Test
    public void collapsingMarginsBeforeAfterPseudo05() throws IOException, InterruptedException {
        convertToPdfAndCompare("collapsingMarginsBeforeAfterPseudo05", sourceFolder, destinationFolder);
    }

    @Test
    public void collapsingMarginsBeforeAfterPseudo06() throws IOException, InterruptedException {
        convertToPdfAndCompare("collapsingMarginsBeforeAfterPseudo06", sourceFolder, destinationFolder);
    }

    @Test
    public void escapedStringTest01() throws IOException, InterruptedException {
        convertToPdfAndCompare("escapedStringTest01", sourceFolder, destinationFolder);
    }

    @Test
    public void escapedStringTest02() throws IOException, InterruptedException {
        convertToPdfAndCompare("escapedStringTest02", sourceFolder, destinationFolder);
    }

    @Test
    public void escapedStringTest03() throws IOException, InterruptedException {
        convertToPdfAndCompare("escapedStringTest03", sourceFolder, destinationFolder);
    }

    @Test
    public void escapedStringTest04() throws IOException, InterruptedException {
        convertToPdfAndCompare("escapedStringTest04", sourceFolder, destinationFolder);
    }

    @Test
    public void escapedStringTest05() throws IOException, InterruptedException {
        convertToPdfAndCompare("escapedStringTest05", sourceFolder, destinationFolder);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = LogMessageConstant.CONTENT_PROPERTY_INVALID, count = 5))
    public void attrTest01() throws IOException, InterruptedException {
        convertToPdfAndCompare("attrTest01", sourceFolder, destinationFolder);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = LogMessageConstant.CONTENT_PROPERTY_INVALID, count = 3))
    public void attrTest02() throws IOException, InterruptedException {
        convertToPdfAndCompare("attrTest02", sourceFolder, destinationFolder);
    }


    @Test
    public void emptyStillShownPseudoTest01() throws IOException, InterruptedException {
        convertToPdfAndCompare("emptyStillShownPseudoTest01", sourceFolder, destinationFolder);
    }

    @Test
    public void emptyStillShownPseudoTest02() throws IOException, InterruptedException {
        // TODO inline elements with absolute positioning are not supported at the moment
        convertToPdfAndCompare("emptyStillShownPseudoTest02", sourceFolder, destinationFolder);
    }

    @Test
    public void emptyStillShownPseudoTest03() throws IOException, InterruptedException {
        // TODO inline elements with absolute positioning are not supported at the moment
        convertToPdfAndCompare("emptyStillShownPseudoTest03", sourceFolder, destinationFolder);
    }

    @Test
    public void emptyStillShownPseudoTest04() throws IOException, InterruptedException {
        // TODO inline elements with absolute positioning are not supported at the moment
        convertToPdfAndCompare("emptyStillShownPseudoTest04", sourceFolder, destinationFolder);
    }

    @Test
    public void emptyStillShownPseudoTest05() throws IOException, InterruptedException {
        convertToPdfAndCompare("emptyStillShownPseudoTest05", sourceFolder, destinationFolder);
    }

    @Test
    public void emptyStillShownPseudoTest06() throws IOException, InterruptedException {
        convertToPdfAndCompare("emptyStillShownPseudoTest06", sourceFolder, destinationFolder);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = com.itextpdf.io.LogMessageConstant.RECTANGLE_HAS_NEGATIVE_OR_ZERO_SIZES),
    })
    public void emptyStillShownPseudoTest07() throws IOException, InterruptedException {
        convertToPdfAndCompare("emptyStillShownPseudoTest07", sourceFolder, destinationFolder);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = com.itextpdf.io.LogMessageConstant.RECTANGLE_HAS_NEGATIVE_OR_ZERO_SIZES),
    })
    public void emptyStillShownPseudoTest08() throws IOException, InterruptedException {
        convertToPdfAndCompare("emptyStillShownPseudoTest08", sourceFolder, destinationFolder);
    }

    @Test
    public void emptyStillShownPseudoTest09() throws IOException, InterruptedException {
        convertToPdfAndCompare("emptyStillShownPseudoTest09", sourceFolder, destinationFolder);
    }

    @Test
    public void pseudoDisplayTable01Test() throws IOException, InterruptedException {
        convertToPdfAndCompare("pseudoDisplayTable01", sourceFolder, destinationFolder);
    }

    @Test
    public void pseudoDisplayTable02Test() throws IOException, InterruptedException {
        convertToPdfAndCompare("pseudoDisplayTable02", sourceFolder, destinationFolder);
    }
}
