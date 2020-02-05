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
package com.itextpdf.html2pdf.css.apply.util;

import com.itextpdf.html2pdf.LogMessageConstant;
import com.itextpdf.html2pdf.attach.ProcessorContext;
import com.itextpdf.html2pdf.css.CssConstants;
import com.itextpdf.layout.IPropertyContainer;
import com.itextpdf.layout.property.Property;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.styledxmlparser.css.util.CssUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Utilities class to apply a padding.
 */
public final class PaddingApplierUtil {

    /** The logger. */
    private static final Logger logger = LoggerFactory.getLogger(PaddingApplierUtil.class);

    /**
     * Creates a new {@link PaddingApplierUtil} instance.
     */
    private PaddingApplierUtil() {
    }

    /**
     * Applies paddings to an element.
     *
     * @param cssProps the CSS properties
     * @param context the processor context
     * @param element the element
     */
    public static void applyPaddings(Map<String, String> cssProps, ProcessorContext context, IPropertyContainer element) {
        applyPaddings(cssProps, context, element, 0.0f, 0.0f);
    }

    /**
     * Applies paddings to an element.
     *
     * @param cssProps the CSS properties
     * @param context the processor context
     * @param element the element
     * @param baseValueHorizontal value used by default for horizontal dimension
     * @param baseValueVertical value used by default for vertical dimension
     */
    public static void applyPaddings(Map<String, String> cssProps, ProcessorContext context, IPropertyContainer element, float baseValueVertical, float baseValueHorizontal) {
        String paddingTop = cssProps.get(CssConstants.PADDING_TOP);
        String paddingBottom = cssProps.get(CssConstants.PADDING_BOTTOM);
        String paddingLeft = cssProps.get(CssConstants.PADDING_LEFT);
        String paddingRight = cssProps.get(CssConstants.PADDING_RIGHT);

        float em = CssUtils.parseAbsoluteLength(cssProps.get(CssConstants.FONT_SIZE));
        float rem = context.getCssContext().getRootFontSize();
        UnitValue paddingTopVal = CssUtils.parseLengthValueToPt(paddingTop, em, rem);
        UnitValue paddingBottomVal = CssUtils.parseLengthValueToPt(paddingBottom, em, rem);
        UnitValue paddingLeftVal = CssUtils.parseLengthValueToPt(paddingLeft, em, rem);
        UnitValue paddingRightVal = CssUtils.parseLengthValueToPt(paddingRight, em, rem);

        if (paddingTopVal != null) {
            if (paddingTopVal.isPointValue()) {
                element.setProperty(Property.PADDING_TOP, paddingTopVal);
            } else {
                if (baseValueVertical != 0.0f)
                    element.setProperty(Property.PADDING_TOP, new UnitValue(UnitValue.POINT, baseValueVertical * paddingTopVal.getValue() * 0.01f));
                else
                    logger.error(LogMessageConstant.PADDING_VALUE_IN_PERCENT_NOT_SUPPORTED);
            }
        }

        if (paddingBottomVal != null) {
            if (paddingBottomVal.isPointValue()) {
                element.setProperty(Property.PADDING_BOTTOM, paddingBottomVal);
            } else {
                if (baseValueVertical != 0.0f)
                    element.setProperty(Property.PADDING_BOTTOM, new UnitValue(UnitValue.POINT, baseValueVertical * paddingBottomVal.getValue() * 0.01f));
                else
                    logger.error(LogMessageConstant.PADDING_VALUE_IN_PERCENT_NOT_SUPPORTED);
            }
        }

        if (paddingLeftVal != null) {
            if (paddingLeftVal.isPointValue()) {
                element.setProperty(Property.PADDING_LEFT, paddingLeftVal);
            } else {
                if (baseValueHorizontal != 0.0f)
                    element.setProperty(Property.PADDING_LEFT, new UnitValue(UnitValue.POINT, baseValueHorizontal * paddingLeftVal.getValue() * 0.01f));
                else
                    logger.error(LogMessageConstant.PADDING_VALUE_IN_PERCENT_NOT_SUPPORTED);
            }
        }

        if (paddingRightVal != null) {
            if (paddingRightVal.isPointValue()) {
                element.setProperty(Property.PADDING_RIGHT, paddingRightVal);
            } else {
                if (baseValueHorizontal != 0.0f)
                    element.setProperty(Property.PADDING_RIGHT, new UnitValue(UnitValue.POINT, baseValueHorizontal * paddingRightVal.getValue() * 0.01f));
                else
                    logger.error(LogMessageConstant.PADDING_VALUE_IN_PERCENT_NOT_SUPPORTED);
            }
        }
    }

}
