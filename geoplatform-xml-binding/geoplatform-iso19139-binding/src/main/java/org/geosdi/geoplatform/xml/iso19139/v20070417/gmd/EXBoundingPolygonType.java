//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.18 at 03:12:11 PM CEST 
//


package org.geosdi.geoplatform.xml.iso19139.v20070417.gmd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.geosdi.geoplatform.xml.iso19139.v20070417.gss.GMObjectPropertyType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * Boundary enclosing the dataset expressed as the closed set of (x,y) coordinates of the polygon (last point replicates first point)
 * 
 * <p>Java class for EX_BoundingPolygon_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EX_BoundingPolygon_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.isotc211.org/2005/gmd}AbstractEX_GeographicExtent_Type">
 *       &lt;sequence>
 *         &lt;element name="polygon" type="{http://www.isotc211.org/2005/gss}GM_Object_PropertyType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EX_BoundingPolygon_Type", propOrder = {
    "polygon"
})
public class EXBoundingPolygonType
    extends AbstractEXGeographicExtentType
    implements ToString
{

    @XmlElement(required = true)
    protected List<GMObjectPropertyType> polygon;

    /**
     * Gets the value of the polygon property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the polygon property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPolygon().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GMObjectPropertyType }
     * 
     * 
     */
    public List<GMObjectPropertyType> getPolygon() {
        if (polygon == null) {
            polygon = new ArrayList<GMObjectPropertyType>();
        }
        return this.polygon;
    }

    public boolean isSetPolygon() {
        return ((this.polygon!= null)&&(!this.polygon.isEmpty()));
    }

    public void unsetPolygon() {
        this.polygon = null;
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        super.appendFields(locator, buffer, strategy);
        {
            List<GMObjectPropertyType> thePolygon;
            thePolygon = (this.isSetPolygon()?this.getPolygon():null);
            strategy.appendField(locator, this, "polygon", buffer, thePolygon);
        }
        return buffer;
    }

    public void setPolygon(List<GMObjectPropertyType> value) {
        this.polygon = null;
        List<GMObjectPropertyType> draftl = this.getPolygon();
        draftl.addAll(value);
    }

}
