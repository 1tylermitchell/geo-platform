//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.16 at 04:57:06 PM CEST 
//


package org.geosdi.geoplatform.xml.ebrim._3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * Mapping of the same named interface in ebRIM.
 * 
 * <p>Java class for PersonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}RegistryObjectType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}Address" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}PersonName" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}TelephoneNumber" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0}EmailAddress" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonType", propOrder = {
    "address",
    "personName",
    "telephoneNumber",
    "emailAddress"
})
@XmlSeeAlso({
    UserType.class
})
public class PersonType
    extends RegistryObjectType
    implements Serializable, ToString
{

    private final static long serialVersionUID = 1100L;
    @XmlElement(name = "Address")
    protected List<PostalAddressType> address;
    @XmlElement(name = "PersonName")
    protected PersonNameType personName;
    @XmlElement(name = "TelephoneNumber")
    protected List<TelephoneNumberType> telephoneNumber;
    @XmlElement(name = "EmailAddress")
    protected List<EmailAddressType> emailAddress;

    /**
     * Gets the value of the address property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the address property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PostalAddressType }
     * 
     * 
     */
    public List<PostalAddressType> getAddress() {
        if (address == null) {
            address = new ArrayList<PostalAddressType>();
        }
        return this.address;
    }

    /**
     * Gets the value of the personName property.
     * 
     * @return
     *     possible object is
     *     {@link PersonNameType }
     *     
     */
    public PersonNameType getPersonName() {
        return personName;
    }

    /**
     * Sets the value of the personName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonNameType }
     *     
     */
    public void setPersonName(PersonNameType value) {
        this.personName = value;
    }

    /**
     * Gets the value of the telephoneNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the telephoneNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTelephoneNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TelephoneNumberType }
     * 
     * 
     */
    public List<TelephoneNumberType> getTelephoneNumber() {
        if (telephoneNumber == null) {
            telephoneNumber = new ArrayList<TelephoneNumberType>();
        }
        return this.telephoneNumber;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the emailAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmailAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EmailAddressType }
     * 
     * 
     */
    public List<EmailAddressType> getEmailAddress() {
        if (emailAddress == null) {
            emailAddress = new ArrayList<EmailAddressType>();
        }
        return this.emailAddress;
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
            List<PostalAddressType> theAddress;
            theAddress = (((this.address!= null)&&(!this.address.isEmpty()))?this.getAddress():null);
            strategy.appendField(locator, this, "address", buffer, theAddress);
        }
        {
            PersonNameType thePersonName;
            thePersonName = this.getPersonName();
            strategy.appendField(locator, this, "personName", buffer, thePersonName);
        }
        {
            List<TelephoneNumberType> theTelephoneNumber;
            theTelephoneNumber = (((this.telephoneNumber!= null)&&(!this.telephoneNumber.isEmpty()))?this.getTelephoneNumber():null);
            strategy.appendField(locator, this, "telephoneNumber", buffer, theTelephoneNumber);
        }
        {
            List<EmailAddressType> theEmailAddress;
            theEmailAddress = (((this.emailAddress!= null)&&(!this.emailAddress.isEmpty()))?this.getEmailAddress():null);
            strategy.appendField(locator, this, "emailAddress", buffer, theEmailAddress);
        }
        return buffer;
    }

    public void setAddress(List<PostalAddressType> value) {
        this.address = null;
        List<PostalAddressType> draftl = this.getAddress();
        draftl.addAll(value);
    }

    public void setTelephoneNumber(List<TelephoneNumberType> value) {
        this.telephoneNumber = null;
        List<TelephoneNumberType> draftl = this.getTelephoneNumber();
        draftl.addAll(value);
    }

    public void setEmailAddress(List<EmailAddressType> value) {
        this.emailAddress = null;
        List<EmailAddressType> draftl = this.getEmailAddress();
        draftl.addAll(value);
    }

}
