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
package com.itextpdf.html2pdf.attach.impl.tags;

import com.itextpdf.html2pdf.attach.ITagWorker;
import com.itextpdf.html2pdf.attach.ProcessorContext;
import com.itextpdf.html2pdf.attach.impl.layout.Html2PdfProperty;
import com.itextpdf.html2pdf.attach.util.AccessiblePropHelper;
import com.itextpdf.layout.IPropertyContainer;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.OverflowPropertyValue;
import com.itextpdf.layout.property.Property;
import com.itextpdf.html2pdf.html.AttributeConstants;
import com.itextpdf.layout.tagging.IAccessibleElement;
import com.itextpdf.styledxmlparser.node.IElementNode;

/**
 * TagWorker class for the {@code optgroup} element.
 */
public class OptGroupTagWorker extends DivTagWorker {

    /**
     * Creates a new {@link OptGroupTagWorker} instance.
     *
     * @param element the element
     * @param context the context
     */
    public OptGroupTagWorker(IElementNode element, ProcessorContext context) {
        super(element, context);
        String label = element.getAttribute(AttributeConstants.LABEL);
        if (label == null || label.isEmpty()) {
            label = "\u00A0";
        }
        getElementResult().setProperty(Html2PdfProperty.FORM_FIELD_LABEL, label);
        Paragraph p = new Paragraph(label).setMargin(0);
        p.setProperty(Property.OVERFLOW_X, OverflowPropertyValue.VISIBLE);
        p.setProperty(Property.OVERFLOW_Y, OverflowPropertyValue.VISIBLE);
        ((Div) getElementResult()).add(p);
    }

    @Override
    public boolean processContent(String content, ProcessorContext context) {
        return content == null || content.trim().isEmpty();
    }

    @Override
    public boolean processTagChild(ITagWorker childTagWorker, ProcessorContext context) {
        if (childTagWorker instanceof OptionTagWorker) {
            IPropertyContainer element = childTagWorker.getElementResult();
            IPropertyContainer propertyContainer = getElementResult();
            if (propertyContainer instanceof IAccessibleElement) {
                String lang = ((IAccessibleElement) propertyContainer).getAccessibilityProperties().getLanguage();
                AccessiblePropHelper.trySetLangAttribute((Div) childTagWorker.getElementResult(), lang);
            }
            return addBlockChild((com.itextpdf.layout.element.IElement) element);
        } else {
            return super.processTagChild(childTagWorker, context);
        }
    }
}
