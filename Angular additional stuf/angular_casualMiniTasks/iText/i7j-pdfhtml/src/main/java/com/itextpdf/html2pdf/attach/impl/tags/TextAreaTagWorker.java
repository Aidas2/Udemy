/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2020 iText Group NV
    Authors: Bruno Lowagie, Paulo Soares, et al.
    
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
package com.itextpdf.html2pdf.attach.impl.tags;

import com.itextpdf.html2pdf.attach.ITagWorker;
import com.itextpdf.html2pdf.attach.ProcessorContext;
import com.itextpdf.html2pdf.attach.impl.layout.Html2PdfProperty;
import com.itextpdf.html2pdf.attach.impl.layout.form.element.TextArea;
import com.itextpdf.layout.IPropertyContainer;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.html2pdf.html.AttributeConstants;
import com.itextpdf.html2pdf.css.CssConstants;
import com.itextpdf.styledxmlparser.css.util.CssUtils;
import com.itextpdf.styledxmlparser.node.IElementNode;

/**
 * TagWorker class for the {@code textarea} element.
 */
public class TextAreaTagWorker implements ITagWorker, IDisplayAware {

    /**
     * The Constant DEFAULT_TEXTAREA_NAME.
     */
    private static final String DEFAULT_TEXTAREA_NAME = "TextArea";

    /**
     * The text area.
     */
    private TextArea textArea;

    private String display;

    /**
     * Creates a new {@link TextAreaTagWorker} instance.
     *
     * @param element the element
     * @param context the context
     */
    public TextAreaTagWorker(IElementNode element, ProcessorContext context) {
        String name = element.getAttribute(AttributeConstants.ID);
        if (name == null) {
            name = DEFAULT_TEXTAREA_NAME;
        }
        name = context.getFormFieldNameResolver().resolveFormName(name);
        textArea = new TextArea(name);
        Integer rows = CssUtils.parseInteger(element.getAttribute(AttributeConstants.ROWS));
        Integer cols = CssUtils.parseInteger(element.getAttribute(AttributeConstants.COLS));
        textArea.setProperty(Html2PdfProperty.FORM_FIELD_ROWS, rows);
        textArea.setProperty(Html2PdfProperty.FORM_FIELD_COLS, cols);
        textArea.setProperty(Html2PdfProperty.FORM_FIELD_FLATTEN, !context.isCreateAcroForm());
        textArea.setProperty(Html2PdfProperty.FORM_ACCESSIBILITY_LANGUAGE, element.getAttribute(AttributeConstants.LANG));
        String placeholder = element.getAttribute(AttributeConstants.PLACEHOLDER);
        if (null != placeholder) {
            Paragraph paragraph;
            if (placeholder.isEmpty()) {
                paragraph = new Paragraph();
            } else {
                if (placeholder.trim().isEmpty()) {
                    paragraph = new Paragraph("\u00A0");
                } else {
                    paragraph = new Paragraph(placeholder);
                }
            }
            textArea.setPlaceholder(paragraph.setMargin(0));
        }
        display = element.getStyles() != null ? element.getStyles().get(CssConstants.DISPLAY) : null;
    }

    /* (non-Javadoc)
     * @see com.itextpdf.html2pdf.attach.ITagWorker#processEnd(com.itextpdf.html2pdf.html.node.IElementNode, com.itextpdf.html2pdf.attach.ProcessorContext)
     */
    @Override
    public void processEnd(IElementNode element, ProcessorContext context) {
    }

    /* (non-Javadoc)
     * @see com.itextpdf.html2pdf.attach.ITagWorker#processContent(java.lang.String, com.itextpdf.html2pdf.attach.ProcessorContext)
     */
    @Override
    public boolean processContent(String content, ProcessorContext context) {
        if (content.startsWith("\r\n")) {
            content = content.substring(2);
        } else if (content.startsWith("\r") || content.startsWith("\n")) {
            content = content.substring(1);
        }
        textArea.setProperty(Html2PdfProperty.FORM_FIELD_VALUE, content);
        return true;
    }

    /* (non-Javadoc)
     * @see com.itextpdf.html2pdf.attach.ITagWorker#processTagChild(com.itextpdf.html2pdf.attach.ITagWorker, com.itextpdf.html2pdf.attach.ProcessorContext)
     */
    @Override
    public boolean processTagChild(ITagWorker childTagWorker, ProcessorContext context) {
        return childTagWorker instanceof PlaceholderTagWorker && null != textArea.getPlaceholder();
    }

    /* (non-Javadoc)
     * @see com.itextpdf.html2pdf.attach.ITagWorker#getElementResult()
     */
    @Override
    public IPropertyContainer getElementResult() {
        return textArea;
    }

    @Override
    public String getDisplay() {
        return display;
    }
}
