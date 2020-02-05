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
package com.itextpdf.html2pdf.attach.impl.layout.form.renderer;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfButtonFormField;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.html2pdf.attach.impl.layout.Html2PdfProperty;
import com.itextpdf.html2pdf.attach.impl.layout.form.element.ButtonContainer;
import com.itextpdf.html2pdf.attach.impl.layout.form.element.IFormField;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.annot.PdfAnnotation;
import com.itextpdf.kernel.pdf.tagging.StandardRoles;
import com.itextpdf.kernel.pdf.tagutils.TagTreePointer;
import com.itextpdf.layout.property.Property;
import com.itextpdf.layout.property.TransparentColor;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.renderer.BlockRenderer;
import com.itextpdf.layout.renderer.DrawContext;
import com.itextpdf.layout.renderer.IRenderer;

import java.util.List;

/**
 * The {@link AbstractOneLineTextFieldRenderer} implementation for buttons with kids.
 * @deprecated Will be renamed to {@code ButtonRenderer} in next major release.
 */
@Deprecated
public class ButtonContainerRenderer extends BlockRenderer {

    private static final float DEFAULT_FONT_SIZE = 12f;

    public ButtonContainerRenderer(ButtonContainer modelElement) {
        super(modelElement);
    }

    @Override
    public void draw(DrawContext drawContext) {
        super.draw(drawContext);
        if (!isFlatten()) {
            String value = getDefaultValue();
            String name = getModelId();
            UnitValue fontSize = (UnitValue) this.getPropertyAsUnitValue(Property.FONT_SIZE);
            if (!fontSize.isPointValue()) {
                fontSize = UnitValue.createPointValue(DEFAULT_FONT_SIZE);
            }
            PdfDocument doc = drawContext.getDocument();
            Rectangle area = getOccupiedArea().getBBox().clone();
            applyMargins(area, false);
            PdfPage page = doc.getPage(occupiedArea.getPageNumber());
            PdfButtonFormField button = PdfFormField.createPushButton(doc, area, name, value, doc.getDefaultFont(), fontSize.getValue());
            button.getWidgets().get(0).setHighlightMode(PdfAnnotation.HIGHLIGHT_NONE);
            button.setBorderWidth(0);
            button.setBackgroundColor(null);
            TransparentColor color = getPropertyAsTransparentColor(Property.FONT_COLOR);
            if (color != null) {
                button.setColor(color.getColor());
            }
            PdfAcroForm forms = PdfAcroForm.getAcroForm(doc, true);
            //Add fields only if it isn't already added. This can happen on split.
            if (forms.getField(name) == null) {
                forms.addField(button, page);
            }

            if (doc.isTagged()) {
                TagTreePointer formParentPointer = doc.getTagStructureContext().getAutoTaggingPointer();
                List<String> kidsRoles = formParentPointer.getKidsRoles();
                int lastFormIndex = kidsRoles.lastIndexOf(StandardRoles.FORM);
                TagTreePointer formPointer = formParentPointer.moveToKid(lastFormIndex);

                String lang = this.<String>getProperty(Html2PdfProperty.FORM_ACCESSIBILITY_LANGUAGE);
                if (lang != null) {
                    formPointer.getProperties().setLanguage(lang);
                }
                formParentPointer.moveToParent();
            }
        }
    }

    @Override
    protected Float getLastYLineRecursively() {
        return super.getFirstYLineRecursively();
    }

    @Override
    public IRenderer getNextRenderer() {
        return new ButtonContainerRenderer((ButtonContainer) modelElement);
    }

    //NOTE: Duplicates methods from AbstractFormFieldRenderer should be changed in next major version

    /**
     * Gets the model id.
     *
     * @return the model id
     */
    protected String getModelId() {
        return ((IFormField) getModelElement()).getId();
    }

    /**
     * Checks if form fields need to be flattened.
     *
     * @return true, if fields need to be flattened
     */
    public boolean isFlatten() {
        Boolean flatten = getPropertyAsBoolean(Html2PdfProperty.FORM_FIELD_FLATTEN);
        return flatten != null ? (boolean) flatten : (boolean) modelElement.<Boolean>getDefaultProperty(Html2PdfProperty.FORM_FIELD_FLATTEN);
    }

    /**
     * Gets the default value of the form field.
     *
     * @return the default value of the form field
     */
    public String getDefaultValue() {
        String defaultValue = this.<String>getProperty(Html2PdfProperty.FORM_FIELD_VALUE);
        return defaultValue != null ? defaultValue : modelElement.<String>getDefaultProperty(Html2PdfProperty.FORM_FIELD_VALUE);
    }
}
