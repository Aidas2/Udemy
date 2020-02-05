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

import com.itextpdf.html2pdf.LogMessageConstant;
import com.itextpdf.html2pdf.attach.ProcessorContext;
import com.itextpdf.io.util.MessageFormatUtil;
import com.itextpdf.kernel.pdf.PdfDictionary;
import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.tagging.PdfStructureAttributes;
import com.itextpdf.kernel.pdf.tagging.StandardRoles;
import com.itextpdf.kernel.pdf.tagutils.AccessibilityProperties;
import com.itextpdf.layout.tagging.IAccessibleElement;
import com.itextpdf.layout.IPropertyContainer;
import com.itextpdf.html2pdf.html.AttributeConstants;
import com.itextpdf.styledxmlparser.node.IElementNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThTagWorker extends TdTagWorker {
    /**
     * Creates a new {@link ThTagWorker} instance.
     *
     * @param element the element
     * @param context the context
     */
    public ThTagWorker(IElementNode element, ProcessorContext context) {
        super(element, context);
    }

    @Override
    public void processEnd(IElementNode element, ProcessorContext context) {
        super.processEnd(element, context);
        IPropertyContainer elementResult = super.getElementResult();
        if (elementResult instanceof IAccessibleElement) {
            ((IAccessibleElement) elementResult).getAccessibilityProperties().setRole(StandardRoles.TH);
            if (context.getPdfDocument() == null || context.getPdfDocument().isTagged()) {
                String scope = element.getAttribute(AttributeConstants.SCOPE);
                AccessibilityProperties properties = ((IAccessibleElement) elementResult).getAccessibilityProperties();
                PdfDictionary attributes = new PdfDictionary();
                attributes.put(PdfName.O, PdfName.Table);
                if (scope != null && (AttributeConstants.ROW.equalsIgnoreCase(scope) || AttributeConstants.ROWGROUP.equalsIgnoreCase(scope))) {
                    attributes.put(PdfName.Scope, PdfName.Row);
                    properties.addAttributes(new PdfStructureAttributes(attributes));
                } else if (scope != null && (AttributeConstants.COL.equalsIgnoreCase(scope) || AttributeConstants.COLGROUP.equalsIgnoreCase(scope))) {
                    attributes.put(PdfName.Scope, PdfName.Column);
                    properties.addAttributes(new PdfStructureAttributes(attributes));
                } else {
                    Logger logger = LoggerFactory.getLogger(ThTagWorker.class);
                    logger.warn(MessageFormatUtil.format(LogMessageConstant.NOT_SUPPORTED_TH_SCOPE_TYPE, scope));
                }

            }

        }
    }

}
