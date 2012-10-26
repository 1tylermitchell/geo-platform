//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.26 at 03:16:42 PM CEST 
//


package org.geosdi.geoplatform.xml.wfs.v110;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * 
 *             Reports the total number of features affected by some kind 
 *             of write action (i.e, insert, update, delete).
 *          
 * 
 * <p>Java class for TransactionSummaryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionSummaryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="totalInserted" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="totalUpdated" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="totalDeleted" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionSummaryType", propOrder = {
    "totalInserted",
    "totalUpdated",
    "totalDeleted"
})
public class TransactionSummaryType
    implements ToString
{

    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger totalInserted;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger totalUpdated;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger totalDeleted;

    /**
     * Gets the value of the totalInserted property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalInserted() {
        return totalInserted;
    }

    /**
     * Sets the value of the totalInserted property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalInserted(BigInteger value) {
        this.totalInserted = value;
    }

    /**
     * Gets the value of the totalUpdated property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalUpdated() {
        return totalUpdated;
    }

    /**
     * Sets the value of the totalUpdated property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalUpdated(BigInteger value) {
        this.totalUpdated = value;
    }

    /**
     * Gets the value of the totalDeleted property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalDeleted() {
        return totalDeleted;
    }

    /**
     * Sets the value of the totalDeleted property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalDeleted(BigInteger value) {
        this.totalDeleted = value;
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
        {
            BigInteger theTotalInserted;
            theTotalInserted = this.getTotalInserted();
            strategy.appendField(locator, this, "totalInserted", buffer, theTotalInserted);
        }
        {
            BigInteger theTotalUpdated;
            theTotalUpdated = this.getTotalUpdated();
            strategy.appendField(locator, this, "totalUpdated", buffer, theTotalUpdated);
        }
        {
            BigInteger theTotalDeleted;
            theTotalDeleted = this.getTotalDeleted();
            strategy.appendField(locator, this, "totalDeleted", buffer, theTotalDeleted);
        }
        return buffer;
    }

}
