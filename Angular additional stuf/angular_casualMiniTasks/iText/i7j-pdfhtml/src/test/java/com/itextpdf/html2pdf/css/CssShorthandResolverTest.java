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

import com.itextpdf.styledxmlparser.css.CssDeclaration;
import com.itextpdf.styledxmlparser.css.resolve.shorthand.IShorthandResolver;
import com.itextpdf.styledxmlparser.css.resolve.shorthand.ShorthandResolverFactory;
import com.itextpdf.test.ExtendedITextTest;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;
import com.itextpdf.test.annotations.type.UnitTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

@Category(UnitTest.class)
public class CssShorthandResolverTest extends ExtendedITextTest {

    @Test
    public void backgroundTest01() {
        String shorthandExpression = "red url('img.gif') 25%/50px 150px repeat-y border-box content-box fixed";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "background-color: red",
                "background-image: url('img.gif')",
                "background-position: 25%",
                "background-size: 50px 150px",
                "background-repeat: repeat-y",
                "background-origin: border-box",
                "background-clip: content-box",
                "background-attachment: fixed"
        ));

        IShorthandResolver backgroundResolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BACKGROUND);
        assertNotNull(backgroundResolver);
        List<CssDeclaration> resolvedShorthandProps = backgroundResolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void backgroundTest02() {
        String shorthandExpression = "url('img.gif') red 25%/50px 150px repeat-y fixed border-box content-box";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "background-color: red",
                "background-image: url('img.gif')",
                "background-position: 25%",
                "background-size: 50px 150px",
                "background-repeat: repeat-y",
                "background-origin: border-box",
                "background-clip: content-box",
                "background-attachment: fixed"
        ));

        IShorthandResolver backgroundResolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BACKGROUND);
        assertNotNull(backgroundResolver);
        List<CssDeclaration> resolvedShorthandProps = backgroundResolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void backgroundTest03() {
        String shorthandExpression = "url('img.gif') 25%/50px 150px fixed border-box";
         Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "background-color: initial",
                "background-image: url('img.gif')",
                "background-position: 25%",
                "background-size: 50px 150px",
                "background-repeat: initial",
                "background-origin: border-box",
                "background-clip: initial",
                "background-attachment: fixed"
        ));

        IShorthandResolver backgroundResolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BACKGROUND);
        assertNotNull(backgroundResolver);
        List<CssDeclaration> resolvedShorthandProps = backgroundResolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void backgroundTest04() {
        String shorthandExpression = "inherit";
         Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "background-color: inherit",
                "background-image: inherit",
                "background-position: inherit",
                "background-size: inherit",
                "background-repeat: inherit",
                "background-origin: inherit",
                "background-clip: inherit",
                "background-attachment: inherit"
        ));

        IShorthandResolver backgroundResolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BACKGROUND);
        assertNotNull(backgroundResolver);
        List<CssDeclaration> resolvedShorthandProps = backgroundResolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = "Was not able to define one of the background CSS shorthand properties: rgdbq(150,90,60)"),
            @LogMessage(messageTemplate = "Was not able to define one of the background CSS shorthand properties: url'smiley.gif')")
    })
    public void backgroundTest05() {
        String shorthandExpression = "rgdbq(150,90,60) url'smiley.gif') repeat-x scroll 20 60%";
         Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "background-color: initial",
                "background-image: initial",
                "background-position: 20 60%",
                "background-size: initial",
                "background-repeat: repeat-x",
                "background-origin: initial",
                "background-clip: initial",
                "background-attachment: scroll"
        ));

        IShorthandResolver backgroundResolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BACKGROUND);
        assertNotNull(backgroundResolver);
        List<CssDeclaration> resolvedShorthandProps = backgroundResolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void backgroundTest06() {
        String shorthandExpression = "DarkOliveGreen fixed center";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "background-color: darkolivegreen",
                "background-image: initial",
                "background-position: center",
                "background-size: initial",
                "background-repeat: initial",
                "background-origin: initial",
                "background-clip: initial",
                "background-attachment: fixed"
        ));

        IShorthandResolver backgroundResolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BACKGROUND);
        assertNotNull(backgroundResolver);
        List<CssDeclaration> resolvedShorthandProps = backgroundResolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderBottomTest01() {
        String shorthandExpression = "15px dotted blue";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-bottom-width: 15px",
                "border-bottom-style: dotted",
                "border-bottom-color: blue"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER_BOTTOM);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderLeftTest01() {
        String shorthandExpression = "10px solid #ff0000";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-left-width: 10px",
                "border-left-style: solid",
                "border-left-color: #ff0000"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER_LEFT);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderRightTest01() {
        String shorthandExpression = "10px double rgb(12,220,100)";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-right-width: 10px",
                "border-right-style: double",
                "border-right-color: rgb(12,220,100)"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER_RIGHT);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderTopTest01() {
        String shorthandExpression = "10px hidden rgba(12,225,100,0.7)";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-top-width: 10px",
                "border-top-style: hidden",
                "border-top-color: rgba(12,225,100,0.7)"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER_TOP);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderTest01() {
        String shorthandExpression = "thick groove black";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-top-width: thick",
                "border-right-width: thick",
                "border-bottom-width: thick",
                "border-left-width: thick",
                "border-top-style: groove",
                "border-right-style: groove",
                "border-bottom-style: groove",
                "border-left-style: groove",
                "border-top-color: black",
                "border-right-color: black",
                "border-bottom-color: black",
                "border-left-color: black"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderTest02() {
        String shorthandExpression = "groove";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-top-width: initial",
                "border-right-width: initial",
                "border-bottom-width: initial",
                "border-left-width: initial",
                "border-top-style: groove",
                "border-right-style: groove",
                "border-bottom-style: groove",
                "border-left-style: groove",
                "border-bottom-color: initial",
                "border-left-color: initial",
                "border-right-color: initial",
                "border-top-color: initial"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderTest03() {
        String shorthandExpression = "inherit";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-top-width: inherit",
                "border-right-width: inherit",
                "border-bottom-width: inherit",
                "border-left-width: inherit",
                "border-top-style: inherit",
                "border-right-style: inherit",
                "border-bottom-style: inherit",
                "border-left-style: inherit",
                "border-top-color: inherit",
                "border-right-color: inherit",
                "border-bottom-color: inherit",
                "border-left-color: inherit"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderTest04() {
        String shorthandExpression = "dashed";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-top-width: initial",
                "border-right-width: initial",
                "border-bottom-width: initial",
                "border-left-width: initial",
                "border-top-style: dashed",
                "border-right-style: dashed",
                "border-bottom-style: dashed",
                "border-left-style: dashed",
                "border-bottom-color: initial",
                "border-left-color: initial",
                "border-right-color: initial",
                "border-top-color: initial"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderTest05() {
        String shorthandExpression = "dashed green";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-top-width: initial",
                "border-right-width: initial",
                "border-bottom-width: initial",
                "border-left-width: initial",
                "border-top-style: dashed",
                "border-right-style: dashed",
                "border-bottom-style: dashed",
                "border-left-style: dashed",
                "border-top-color: green",
                "border-right-color: green",
                "border-bottom-color: green",
                "border-left-color: green"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderTest06() {
        String shorthandExpression = "1px dashed";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-top-width: 1px",
                "border-right-width: 1px",
                "border-bottom-width: 1px",
                "border-left-width: 1px",
                "border-top-style: dashed",
                "border-right-style: dashed",
                "border-bottom-style: dashed",
                "border-left-style: dashed",
                "border-bottom-color: initial",
                "border-left-color: initial",
                "border-right-color: initial",
                "border-top-color: initial"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderTest07() {
        String shorthandExpression = "1px dashed green";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-top-width: 1px",
                "border-right-width: 1px",
                "border-bottom-width: 1px",
                "border-left-width: 1px",
                "border-top-style: dashed",
                "border-right-style: dashed",
                "border-bottom-style: dashed",
                "border-left-style: dashed",
                "border-top-color: green",
                "border-right-color: green",
                "border-bottom-color: green",
                "border-left-color: green"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderWidthTest01() {
        String shorthandExpression = "thin medium thick 10px";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-top-width: thin",
                "border-right-width: medium",
                "border-bottom-width: thick",
                "border-left-width: 10px"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER_WIDTH);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderWidthTest02() {
        String shorthandExpression = "thin 20% thick";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-top-width: thin",
                "border-right-width: 20%",
                "border-bottom-width: thick",
                "border-left-width: 20%"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER_WIDTH);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderWidthTest03() {
        String shorthandExpression = "inherit";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-top-width: inherit",
                "border-right-width: inherit",
                "border-bottom-width: inherit",
                "border-left-width: inherit"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER_WIDTH);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderStyleTest01() {
        String shorthandExpression = "dotted solid double dashed";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-top-style: dotted",
                "border-right-style: solid",
                "border-bottom-style: double",
                "border-left-style: dashed"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER_STYLE);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderStyleTest02() {
        String shorthandExpression = "dotted solid";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-top-style: dotted",
                "border-right-style: solid",
                "border-bottom-style: dotted",
                "border-left-style: solid"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER_STYLE);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderColorTest01() {
        String shorthandExpression = "red rgba(125,0,50,0.4) rgb(12,255,0) #0000ff";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-top-color: red",
                "border-right-color: rgba(125,0,50,0.4)",
                "border-bottom-color: rgb(12,255,0)",
                "border-left-color: #0000ff"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER_COLOR);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void borderColorTest02() {
        String shorthandExpression = "red";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "border-top-color: red",
                "border-right-color: red",
                "border-bottom-color: red",
                "border-left-color: red"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.BORDER_COLOR);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void fontTest01() {
        String shorthandExpression = "italic normal bold 12px/30px Georgia, serif";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "font-style: italic",
                "font-variant: initial",
                "font-weight: bold",
                "font-size: 12px",
                "line-height: 30px",
                "font-family: georgia,serif"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.FONT);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void fontTest02() {
        String shorthandExpression = "bold Georgia, serif";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "font-style: initial",
                "font-variant: initial",
                "font-weight: bold",
                "font-size: initial",
                "line-height: initial",
                "font-family: georgia,serif"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.FONT);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void fontTest03() {
        String shorthandExpression = "inherit";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "font-style: inherit",
                "font-variant: inherit",
                "font-weight: inherit",
                "font-size: inherit",
                "line-height: inherit",
                "font-family: inherit"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.FONT);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void fontTest04() {
        String shorthandExpression = "bold Georgia, serif, \"Times New Roman\"";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "font-style: initial",
                "font-variant: initial",
                "font-weight: bold",
                "font-size: initial",
                "line-height: initial",
                "font-family: georgia,serif,\"Times New Roman\""
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.FONT);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void fontTest05() {
        String shorthandExpression = "italic normal bold 12px/30px Georgia, \"Times New Roman\", serif";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "font-style: italic",
                "font-variant: initial",
                "font-weight: bold",
                "font-size: 12px",
                "line-height: 30px",
                "font-family: georgia,\"Times New Roman\",serif"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.FONT);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void fontTest06() {
        String shorthandExpression = "italic normal bold 12px/30px Georgia    ,   \"Times New Roman\"   ,    serif";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "font-style: italic",
                "font-variant: initial",
                "font-weight: bold",
                "font-size: 12px",
                "line-height: 30px",
                "font-family: georgia,\"Times New Roman\",serif"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.FONT);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void fontTest07() {
        String shorthandExpression = "italic normal bold 12px/30px Georgia    ,   \"Times New Roman\"   ";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "font-style: italic",
                "font-variant: initial",
                "font-weight: bold",
                "font-size: 12px",
                "line-height: 30px",
                "font-family: georgia,\"Times New Roman\""
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.FONT);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void fontTest08() {
        String shorthandExpression = "Georgia,'Times New Roman'";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "font-style: initial",
                "font-variant: initial",
                "font-weight: initial",
                "font-size: initial",
                "line-height: initial",
                "font-family: georgia,'Times New Roman'"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.FONT);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void fontTest09() {
        String shorthandExpression = "Georgia  ,   'Times New Roman', serif";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "font-style: initial",
                "font-variant: initial",
                "font-weight: initial",
                "font-size: initial",
                "line-height: initial",
                "font-family: georgia,'Times New Roman',serif"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.FONT);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void listStyleTest01() {
        String shorthandExpression = "square inside url('sqpurple.gif')";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "list-style-type: square",
                "list-style-position: inside",
                "list-style-image: url('sqpurple.gif')"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.LIST_STYLE);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void listStyleTest02() {
        String shorthandExpression = "inside url('sqpurple.gif')";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "list-style-type: initial",
                "list-style-position: inside",
                "list-style-image: url('sqpurple.gif')"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.LIST_STYLE);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void listStyleTest03() {
        String shorthandExpression = "inherit";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "list-style-type: inherit",
                "list-style-position: inherit",
                "list-style-image: inherit"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.LIST_STYLE);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void marginTest01() {
        String shorthandExpression = "2cm -4cm 3cm 4cm";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "margin-top: 2cm",
                "margin-right: -4cm",
                "margin-bottom: 3cm",
                "margin-left: 4cm"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.MARGIN);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void marginTest02() {
        String shorthandExpression = "2cm auto 4cm";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "margin-top: 2cm",
                "margin-right: auto",
                "margin-bottom: 4cm",
                "margin-left: auto"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.MARGIN);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void outlineTest01() {
        String shorthandExpression = "#00ff00 dashed medium";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "outline-color: #00ff00",
                "outline-style: dashed",
                "outline-width: medium"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.OUTLINE);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void paddingTest01() {
        String shorthandExpression = "10px 5px 15px 20px";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "padding-top: 10px",
                "padding-right: 5px",
                "padding-bottom: 15px",
                "padding-left: 20px"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.PADDING);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void paddingTest02() {
        String shorthandExpression = "10px 5px";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "padding-top: 10px",
                "padding-right: 5px",
                "padding-bottom: 10px",
                "padding-left: 5px"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.PADDING);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    @Test
    public void paddingTest03() {
        String shorthandExpression = "inherit";
        Set<String> expectedResolvedProperties = new HashSet<>(Arrays.asList(
                "padding-top: inherit",
                "padding-right: inherit",
                "padding-bottom: inherit",
                "padding-left: inherit"
        ));

        IShorthandResolver resolver = ShorthandResolverFactory.getShorthandResolver(CssConstants.PADDING);
        assertNotNull(resolver);
        List<CssDeclaration> resolvedShorthandProps = resolver.resolveShorthand(shorthandExpression);
        compareResolvedProps(resolvedShorthandProps, expectedResolvedProperties);
    }

    private void compareResolvedProps(List<CssDeclaration> actual, Set<String> expected) {
        Set<String> actualSet = new HashSet<>();
        for (CssDeclaration cssDecl : actual) {
            actualSet.add(cssDecl.toString());
        }

        boolean areDifferent = false;

        StringBuilder sb = new StringBuilder("Resolved styles are different from expected!");
        Set<String> expCopy = new TreeSet<>(expected);
        Set<String> actCopy = new TreeSet<>(actualSet);
        expCopy.removeAll(actualSet);
        actCopy.removeAll(expected);
        if (!expCopy.isEmpty()) {
            areDifferent = true;
            sb.append("\nExpected but not found properties:\n");
            for (String expProp : expCopy) {
                sb.append(expProp).append('\n');
            }
        }
        if (!actCopy.isEmpty()) {
            areDifferent = true;
            sb.append("\nNot expected but found properties:\n");
            for (String actProp : actCopy) {
                sb.append(actProp).append('\n');
            }
        }

        if (areDifferent) {
            fail(sb.toString());
        }
    }
}
