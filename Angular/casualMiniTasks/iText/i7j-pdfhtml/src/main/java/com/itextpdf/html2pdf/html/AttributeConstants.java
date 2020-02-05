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
package com.itextpdf.html2pdf.html;

import com.itextpdf.styledxmlparser.CommonAttributeConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that bundles a series of attribute constants.
 */
public final class AttributeConstants extends CommonAttributeConstants {
    /**
     * Creates a new {@link AttributeConstants} instance.
     */
    private AttributeConstants() {
    }

    /** The Constant ALIGN. */
    public static final String ALIGN = "align";

    /** The Constant ALT. */
    public static final String ALT = "alt";

    /** The Constant APPLICATION_NAME. */
    public static final String APPLICATION_NAME = "application-name";

    /** The Constant AUTHOR. */
    public static final String AUTHOR = "author";

    /** The Constant BGCOLOR. */
    public static final String BGCOLOR = "bgcolor";

    /** The Constant BORDER. */
    public static final String BORDER = "border";

    /** The Constant CLASS. */
    public static final String CELLPADDING = "cellpadding";

    /** The Constant CLASS. */
    public static final String CELLSPACING = "cellspacing";

    /** The Constant COLOR. */
    public static final String COLOR = "color";

    /** The Constant COLS. */
    public static final String COL = "col";

    /** The Constant COLS. */
    public static final String COLGROUP = "colgroup";

    /** The Constant COLS. */
    public static final String COLS = "cols";

    /** The Constant COLSPAN. */
    public static final String COLSPAN = "colspan";

    /** The Constant CONTENT. */
    public static final String CONTENT = "content";

    /** The Constant DATA */
    public static final String DATA = "data";

    /** The Constant DESCRIPTION. */
    public static final String DESCRIPTION = "description";

    /** The Constant DIR. */
    public static final String DIR = "dir";

    /** The Constant FACE. */
    public static final String FACE = "face";

    /** The Constant HEIGHT. */
    public static final String HEIGHT = "height";

    /** The Constant HREF. */
    public static final String HREF = "href";

    /** The Constant HSPACE. */
    public static final String HSPACE = "hspace";

    /** The Constant ID. */
    public static final String ID = "id";

    /** The Constant KEYWORDS. */
    public static final String KEYWORDS = "keywords";

    /** The Constant LABEL. */
    public static final String LABEL = "label";

    /** The Constant LANG. */
    public static final String LANG = "lang";

    /** The Constant MEDIA. */
    public static final String MEDIA = "media";

    /** The Constant MULTIPLE. */
    public static final String MULTIPLE = "multiple";

    /** The Constant NAME. */
    public static final String NAME = "name";

    /** The Constant NOSHADE. */
    public static final String NOSHADE = "noshade";

    /** The Constant NOWRAP. */
    public static final String NOWRAP = "nowrap";

    /** The Constant NUMBER. */
    public static final String NUMBER = "number";

    /** The Constant ROWS. */
    public static final String ROW = "row";

    /** The Constant ROWS. */
    public static final String ROWGROUP = "rowgroup";

    /** The Constant ROWS. */
    public static final String ROWS = "rows";

    /** The Constant ROWSPAN. */
    public static final String ROWSPAN = "rowspan";

    /** The Constant SCOPE. */
    public static final String SCOPE = "scope";

    /** The Constant SELECTED. */
    public static final String SELECTED = "selected";

    /** The Constant SIZE. */
    public static final String SIZE = "size";

    /** The Constant SPAN. */
    public static final String SPAN = "span";

    /** The Constant SRC. */
    public static final String SRC = "src";

    /** The Constant STYLE. */
    public static final String STYLE = "style";

    /** The Constant TYPE. */
    public static final String TYPE = "type";

    /** The Constant VALIGN. */
    public static final String VALIGN = "valign";

    /** The Constant VALUE. */
    public static final String VALUE = "value";

    /** The Constant VSPACE. */
     public static final String VSPACE = "vspace";

    /** The Constant WIDTH. */
    public static final String WIDTH = "width";

    /** The Constant TITLE. */
    public static final String TITLE = "title";

    // attribute values

    /** The Constant _1. */
    public static final String _1 = "1";

    /** The Constant A. */
    public static final String A = "A";

    /** The Constant a. */
    public static final String a = "a";

    /** The Constant BOTTOM. */
    public static final String BOTTOM = "bottom";

    /** The Constant BUTTON. */
    public static final String BUTTON = "button";

    /** The Constant CENTER. */
    public static final String CENTER = "center";

    /** The Constant CHECKBOX. */
    public static final String CHECKBOX = "checkbox";

    /** The Constant CHECKED. */
    public static final String CHECKED = "checked";

    /** The Constant DATE. */
    public static final String DATE = "date";

    /** The Constant DATETIME. */
    public static final String DATETIME = "datetime";

    /** The Constant DATETIME_LOCAL. */
    public static final String DATETIME_LOCAL = "datetime_local";

    /** The Constant EMAIL. */
    public static final String EMAIL = "email";

    /** The Constant FILE. */
    public static final String FILE = "file";

    /** The Constant HIDDEN. */
    public static final String HIDDEN = "hidden";

    /** The Constant I. */
    public static final String I = "I";

    /** The Constant i. */
    public static final String i = "i";

    /** The Constant IMAGE. */
    public static final String IMAGE = "image";

    /** The Constant LEFT. */
    public static final String LEFT = "left";

    /** The Constant LTR. */
    public static final String LTR = "ltr";

    /** The Constant MIDDLE. */
    public static final String MIDDLE = "middle";

    /** The Constant MONTH. */
    public static final String MONTH = "month";

    /** The Constant PASSWORD. */
    public static final String PASSWORD = "password";

    /** The Constant PLACEHOLDER. */
    public static final String PLACEHOLDER = "placeholder";

    /** The Constant RADIO. */
    public static final String RADIO = "radio";

    /** The Constant RANGE. */
    public static final String RANGE = "range";

    /** The Constant RESET. */
    public static final String RESET = "reset";

    /** The Constant RIGHT. */
    public static final String RIGHT = "right";

    /** The Constant RTL. */
    public static final String RTL = "rtl";

    /** The Constant SEARCH. */
    public static final String SEARCH = "search";

    /**The Constant START*/
    public static final String START = "start";

    /** The Constant SUBMIT. */
    public static final String SUBMIT = "submit";

    /** The Constant TEL. */
    public static final String TEL = "tel";

    /** The Constant TEXT. */
    public static final String TEXT = "text";

    /** The Constant TIME. */
    public static final String TIME = "time";

    /** The Constant TOP. */
    public static final String TOP = "top";

    /**The Constant URL*/
    public static final String URL = "url";

    /**The Constant WEEK*/
    public static final String WEEK = "week";

    /** The Constant INPUT_TYPE_VALUES. */
    public static final Set<String> INPUT_TYPE_VALUES = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList(new String[] {BUTTON, CHECKBOX, COLOR, DATE, DATETIME, DATETIME_LOCAL, EMAIL, FILE, HIDDEN,
                    IMAGE, MONTH, NUMBER, PASSWORD, RADIO, RANGE, RESET, SEARCH, SUBMIT, TEL, TEXT, TIME, URL, WEEK})));

    // iText custom attributes
    public static final class ObjectTypes{
        public static final String SVGIMAGE = "image/svg+xml";
    }

}
