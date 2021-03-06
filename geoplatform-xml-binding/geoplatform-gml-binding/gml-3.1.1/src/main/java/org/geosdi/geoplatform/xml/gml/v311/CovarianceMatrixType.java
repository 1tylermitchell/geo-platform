//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.17 at 10:27:36 PM CEST 
//


package org.geosdi.geoplatform.xml.gml.v311;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * Error estimate covariance matrix. 
 * 
 * <p>Java class for CovarianceMatrixType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CovarianceMatrixType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractPositionalAccuracyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}unitOfMeasure" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.opengis.net/gml}includesElement" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CovarianceMatrixType", propOrder = {
    "unitOfMeasure",
    "includesElement"
})
public class CovarianceMatrixType
    extends AbstractPositionalAccuracyType
    implements ToString
{

    @XmlElement(required = true)
    protected List<UnitOfMeasureType> unitOfMeasure;
    @XmlElement(required = true)
    protected List<CovarianceElementType> includesElement;

    /**
     * Ordered sequence of units of measure, corresponding to the row and column index numbers of the covariance matrix, starting with row and column 1 and ending with row/column N. Each unit of measure is for the ordinate reflected in the relevant row and column of the covariance matrix. Gets the value of the unitOfMeasure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unitOfMeasure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnitOfMeasure().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UnitOfMeasureType }
     * 
     * 
     */
    public List<UnitOfMeasureType> getUnitOfMeasure() {
        if (unitOfMeasure == null) {
            unitOfMeasure = new ArrayList<UnitOfMeasureType>();
        }
        return this.unitOfMeasure;
    }

    public boolean isSetUnitOfMeasure() {
        return ((this.unitOfMeasure!= null)&&(!this.unitOfMeasure.isEmpty()));
    }

    public void unsetUnitOfMeasure() {
        this.unitOfMeasure = null;
    }

    /**
     * Unordered set of elements in this covariance matrix. Because the covariance matrix is symmetrical, only the elements in the upper or lower diagonal part (including the main diagonal) of the matrix need to be specified. Any zero valued covariance elements can be omitted. Gets the value of the includesElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includesElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludesElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CovarianceElementType }
     * 
     * 
     */
    public List<CovarianceElementType> getIncludesElement() {
        if (includesElement == null) {
            includesElement = new ArrayList<CovarianceElementType>();
        }
        return this.includesElement;
    }

    public boolean isSetIncludesElement() {
        return ((this.includesElement!= null)&&(!this.includesElement.isEmpty()));
    }

    public void unsetIncludesElement() {
        this.includesElement = null;
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
            List<UnitOfMeasureType> theUnitOfMeasure;
            theUnitOfMeasure = (this.isSetUnitOfMeasure()?this.getUnitOfMeasure():null);
            strategy.appendField(locator, this, "unitOfMeasure", buffer, theUnitOfMeasure);
        }
        {
            List<CovarianceElementType> theIncludesElement;
            theIncludesElement = (this.isSetIncludesElement()?this.getIncludesElement():null);
            strategy.appendField(locator, this, "includesElement", buffer, theIncludesElement);
        }
        return buffer;
    }

    public void setUnitOfMeasure(List<UnitOfMeasureType> value) {
        this.unitOfMeasure = null;
        List<UnitOfMeasureType> draftl = this.getUnitOfMeasure();
        draftl.addAll(value);
    }

    public void setIncludesElement(List<CovarianceElementType> value) {
        this.includesElement = null;
        List<CovarianceElementType> draftl = this.getIncludesElement();
        draftl.addAll(value);
    }

}
