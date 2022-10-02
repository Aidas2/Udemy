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
import com.itextpdf.styledxmlparser.LogMessageConstant;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;
import com.itextpdf.test.annotations.type.IntegrationTest;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class FontSizeTest extends ExtendedHtmlConversionITextTest {

    public static final String sourceFolder = "./src/test/resources/com/itextpdf/html2pdf/css/FontSizeTest/";
    public static final String destinationFolder = "./target/test/com/itextpdf/html2pdf/css/FontSizeTest/";

    @BeforeClass
    public static void beforeClass() {
        createDestinationFolder(destinationFolder);
    }

    //TODO: Note that in case of font-size < 100% in browsers line-height stays the same as in 100%. We don't do it for now.
    @Test
    public void fontSize01Test() throws IOException, InterruptedException {
        convertToPdfAndCompare("fontSizeTest01", sourceFolder, destinationFolder);}

    @Test
    public void fontSize02Test() throws IOException, InterruptedException {
        convertToPdfAndCompare("fontSizeTest02", sourceFolder, destinationFolder);}

    @Test
    public void fontAbsoluteKeywords() throws IOException, InterruptedException {
        convertToPdfAndCompare("fontAbsoluteKeywords", sourceFolder, destinationFolder);
    }

    @Test
    public void fontRelativeKeywords() throws IOException, InterruptedException {
        convertToPdfAndCompare("fontRelativeKeywords", sourceFolder, destinationFolder);
    }

    @Test
    // TODO DEVSIX-2881 : Update cmps
    @LogMessages(messages = @LogMessage(messageTemplate = LogMessageConstant.UNKNOWN_ABSOLUTE_METRIC_LENGTH_PARSED))
    public void spacesInFontSizeValueTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spacesInFontSizeValueTest", sourceFolder, destinationFolder);
    }
}
