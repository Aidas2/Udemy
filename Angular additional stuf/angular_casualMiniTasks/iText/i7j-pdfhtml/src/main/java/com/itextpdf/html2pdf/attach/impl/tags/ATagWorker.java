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

import com.itextpdf.html2pdf.attach.ProcessorContext;
import com.itextpdf.html2pdf.attach.impl.layout.RunningElement;
import com.itextpdf.html2pdf.attach.util.LinkHelper;
import com.itextpdf.kernel.pdf.tagging.StandardRoles;
import com.itextpdf.layout.IPropertyContainer;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.property.FloatPropertyValue;
import com.itextpdf.layout.property.Property;
import com.itextpdf.layout.property.Transform;
import com.itextpdf.html2pdf.html.AttributeConstants;
import com.itextpdf.styledxmlparser.node.IElementNode;
import com.itextpdf.styledxmlparser.resolver.resource.UriResolver;

import java.net.MalformedURLException;


/**
 * TagWorker class for the {@code a} element.
 */
public class ATagWorker extends SpanTagWorker {

    /**
     * Creates a new {@link ATagWorker} instance.
     *
     * @param element the element
     * @param context the context
     */
    public ATagWorker(IElementNode element, ProcessorContext context) {
        super(element, context);
    }

    /* (non-Javadoc)
     * @see com.itextpdf.html2pdf.attach.impl.tags.SpanTagWorker#processEnd(com.itextpdf.html2pdf.html.node.IElementNode, com.itextpdf.html2pdf.attach.ProcessorContext)
     */
    @Override
    public void processEnd(IElementNode element, ProcessorContext context) {
        super.processEnd(element, context);

        String url = element.getAttribute(AttributeConstants.HREF);
        if (url != null) {
            String base = context.getBaseUri();
            if (base != null) {
                UriResolver uriResolver = new UriResolver(base);
                if (!(url.startsWith("#") && uriResolver.isLocalBaseUri()))
                    try {
                        String resolvedUri = uriResolver.resolveAgainstBaseUri(url).toExternalForm();
                        if (!url.endsWith("/") && resolvedUri.endsWith("/"))
                            resolvedUri = resolvedUri.substring(0, resolvedUri.length() - 1);
                        if (!resolvedUri.startsWith("file:"))
                            url = resolvedUri;
                    } catch (MalformedURLException exception) {
                    }
            }
            for (int i = 0; i < getAllElements().size(); i++) {
                if (getAllElements().get(i) instanceof RunningElement) {
                    continue;
                }
                if (getAllElements().get(i) instanceof IBlockElement) {
                    Div simulatedDiv = new Div();
                    simulatedDiv.getAccessibilityProperties().setRole(StandardRoles.LINK);
                    Transform cssTransform = getAllElements().get(i).<Transform>getProperty(Property.TRANSFORM);
                    if (cssTransform != null) {
                        getAllElements().get(i).deleteOwnProperty(Property.TRANSFORM);
                        simulatedDiv.setProperty(Property.TRANSFORM, cssTransform);
                    }
                    FloatPropertyValue floatPropVal = getAllElements().get(i).<FloatPropertyValue>getProperty(Property.FLOAT);
                    if (floatPropVal != null) {
                        getAllElements().get(i).deleteOwnProperty(Property.FLOAT);
                        simulatedDiv.setProperty(Property.FLOAT, floatPropVal);
                    }
                    simulatedDiv.add((IBlockElement) getAllElements().get(i));
                    String display = childrenDisplayMap.remove(getAllElements().get(i));
                    if (display != null) {
                        childrenDisplayMap.put(simulatedDiv, display);
                    }
                    getAllElements().set(i, simulatedDiv);
                }
                LinkHelper.applyLinkAnnotation(getAllElements().get(i), url);
            }
        }

        if (!getAllElements().isEmpty()) {
            String name = element.getAttribute(AttributeConstants.NAME);
            IPropertyContainer firstElement = getAllElements().get(0);
            firstElement.setProperty(Property.DESTINATION, name);
        }
    }
}
