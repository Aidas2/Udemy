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
package com.itextpdf.html2pdf.css.apply.impl;

import com.itextpdf.html2pdf.attach.ITagWorker;
import com.itextpdf.html2pdf.attach.ProcessorContext;
import com.itextpdf.html2pdf.css.CssConstants;
import com.itextpdf.html2pdf.css.apply.ICssApplier;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.BorderCollapsePropertyValue;
import com.itextpdf.layout.property.Property;
import com.itextpdf.styledxmlparser.css.util.CssUtils;
import com.itextpdf.styledxmlparser.node.IStylesContainer;

/**
 * {@link ICssApplier} implementation for table elements.
 */
public class TableTagCssApplier extends BlockCssApplier {

    /* (non-Javadoc)
     * @see com.itextpdf.html2pdf.css.apply.impl.BlockCssApplier#apply(com.itextpdf.html2pdf.attach.ProcessorContext, com.itextpdf.html2pdf.html.node.IStylesContainer, com.itextpdf.html2pdf.attach.ITagWorker)
     */
    @Override
    public void apply(ProcessorContext context, IStylesContainer stylesContainer, ITagWorker worker) {
        super.apply(context, stylesContainer, worker);

        Table table = (Table) worker.getElementResult();
        if (table != null) {
            String tableLayout = stylesContainer.getStyles().get(CssConstants.TABLE_LAYOUT);
            if (tableLayout != null) {
                table.setProperty(Property.TABLE_LAYOUT, tableLayout);
            }
            String borderCollapse = stylesContainer.getStyles().get(CssConstants.BORDER_COLLAPSE);
            // BorderCollapsePropertyValue.COLLAPSE is default in iText layout
            if (null == borderCollapse || CssConstants.SEPARATE.equals(borderCollapse)) {
                table.setBorderCollapse(BorderCollapsePropertyValue.SEPARATE);
            }
            String borderSpacing = stylesContainer.getStyles().get(CssConstants.BORDER_SPACING);
            if (null != borderSpacing) {
                String[] props = borderSpacing.split("\\s+");
                if (1 == props.length) {
                    table.setHorizontalBorderSpacing(CssUtils.parseAbsoluteLength(props[0]));
                    table.setVerticalBorderSpacing(CssUtils.parseAbsoluteLength(props[0]));
                } else if (2 == props.length) {
                    table.setHorizontalBorderSpacing(CssUtils.parseAbsoluteLength(props[0]));
                    table.setVerticalBorderSpacing(CssUtils.parseAbsoluteLength(props[1]));
                }
            }
        }
    }
}
