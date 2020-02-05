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

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.Property;
import com.itextpdf.test.ExtendedITextTest;
import com.itextpdf.test.annotations.type.IntegrationTest;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * This test handles the case where a br tag causes the pdf to no longer be pdf/A compliant
 * The underlying problem turns out to be that the inserted Text IElement has no font, and uses the default (Helvetica) font.
 * The font does not get embedded, and as such, it breaks the compliancy.
 */
@Category(IntegrationTest.class)
public class BrTagTest extends ExtendedITextTest {

    @BeforeClass
    public static void beforeClass() {
    }

    @Test
    public void test() throws IOException, InterruptedException {
        String input = "<html>\n" +
                "<head><title>Test</title></head>" +
                "<body style=\"font-family: FreeSans;\">" +
                "<h1>Test</h1>" +
                "<br />" +
                "<p>Hello World</p>" +
                "</body>" +
                "</html>";

        List<IElement> elements = HtmlConverter.convertToElements(input);
        Assert.assertEquals(3, elements.size());
        Assert.assertTrue(elements.get(1) instanceof Paragraph);
        Assert.assertEquals(1, ((Paragraph)elements.get(1)).getChildren().size());
        IElement iElement = ((Paragraph) elements.get(1)).getChildren().get(0);
        Assert.assertArrayEquals(new String[] {"freesans"}, iElement.<String[]>getProperty(Property.FONT));
    }
}
