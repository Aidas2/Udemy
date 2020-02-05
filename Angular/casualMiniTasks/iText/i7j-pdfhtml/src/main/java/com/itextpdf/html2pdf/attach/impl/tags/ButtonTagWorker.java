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
import com.itextpdf.html2pdf.attach.impl.layout.form.element.Button;
import com.itextpdf.html2pdf.attach.impl.layout.form.element.ButtonContainer;
import com.itextpdf.html2pdf.attach.impl.layout.form.element.IFormField;
import com.itextpdf.html2pdf.attach.util.AccessiblePropHelper;
import com.itextpdf.html2pdf.html.AttributeConstants;
import com.itextpdf.layout.IPropertyContainer;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.tagging.IAccessibleElement;
import com.itextpdf.styledxmlparser.node.IElementNode;

/**
 * TagWorker class for a button element.
 */
public class ButtonTagWorker extends DivTagWorker {

    /** The Constant DEFAULT_BUTTON_NAME. */
    private static final String DEFAULT_BUTTON_NAME = "Button";

    /** The button. */
    private IFormField formField;

    /** The lang attribute value. */
    private String lang;

    private StringBuilder fallbackContent = new StringBuilder();

    private String name;

    private boolean flatten;

    private boolean hasChildren = false;

    /**
     * Creates a new {@link ButtonTagWorker} instance.
     *
     * @param element the element
     * @param context the context
     */
    public ButtonTagWorker(IElementNode element, ProcessorContext context) {
        super(element, context);
        String name = element.getAttribute(AttributeConstants.ID);
        if (name == null) {
            name = DEFAULT_BUTTON_NAME;
        }
        this.name = context.getFormFieldNameResolver().resolveFormName(name);
        flatten = !context.isCreateAcroForm();

        lang = element.getAttribute(AttributeConstants.LANG);
    }

    /* (non-Javadoc)
     * @see com.itextpdf.html2pdf.attach.ITagWorker#processContent(java.lang.String, com.itextpdf.html2pdf.attach.ProcessorContext)
     */
    @Override
    public boolean processContent(String content, ProcessorContext context) {
        fallbackContent.append(content);
        return super.processContent(content, context);
    }

    /* (non-Javadoc)
     * @see com.itextpdf.html2pdf.attach.ITagWorker#processTagChild(com.itextpdf.html2pdf.attach.ITagWorker, com.itextpdf.html2pdf.attach.ProcessorContext)
     */
    @Override
    public boolean processTagChild(ITagWorker childTagWorker, ProcessorContext context) {
        hasChildren = true;
        return super.processTagChild(childTagWorker, context);
    }

    /* (non-Javadoc)
     * @see com.itextpdf.html2pdf.attach.ITagWorker#getElementResult()
     */
    @Override
    public IPropertyContainer getElementResult() {
        if (formField == null) {
            if (hasChildren) {
                ButtonContainer button = new ButtonContainer(name);
                button.setProperty(Html2PdfProperty.FORM_ACCESSIBILITY_LANGUAGE, lang);
                Div div = (Div) super.getElementResult();
                for (IElement element : div.getChildren()) {
                    if (element instanceof IAccessibleElement) {
                        AccessiblePropHelper.trySetLangAttribute((IAccessibleElement) element, lang);
                    }
                    if (element instanceof IBlockElement) {
                        button.add((IBlockElement) element);
                    } else if (element instanceof Image) {
                        button.add((Image) element);
                    }
                }
                div.getChildren().clear();
                formField = button;
            } else {
                Button inputButton = new Button(name);
                inputButton.setProperty(Html2PdfProperty.FORM_ACCESSIBILITY_LANGUAGE, lang);
                inputButton.setProperty(Html2PdfProperty.FORM_FIELD_VALUE, fallbackContent.toString().trim());
                formField = inputButton;
            }
        }
        formField.setProperty(Html2PdfProperty.FORM_FIELD_FLATTEN, flatten);
        return formField;
    }
}
