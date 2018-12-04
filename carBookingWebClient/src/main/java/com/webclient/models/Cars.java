//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2018.12.04 at 11:13:19 AM GMT 
//


package com.webclient.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cars complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cars"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="carMake" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="carModel" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="carReg" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="carSize" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fuelType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="rentalId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="seats" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="transmission" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cars", namespace = "http://ds.sw.gmit.ie/models/", propOrder = {
    "carMake",
    "carModel",
    "carReg",
    "carSize",
    "fuelType",
    "rentalId",
    "seats",
    "transmission"
})
public class Cars {

    @XmlElement(namespace = "http://ds.sw.gmit.ie/models/", required = true)
    protected String carMake;
    @XmlElement(namespace = "http://ds.sw.gmit.ie/models/", required = true)
    protected String carModel;
    @XmlElement(namespace = "http://ds.sw.gmit.ie/models/", required = true)
    protected String carReg;
    @XmlElement(namespace = "http://ds.sw.gmit.ie/models/", required = true)
    protected String carSize;
    @XmlElement(namespace = "http://ds.sw.gmit.ie/models/", required = true)
    protected String fuelType;
    @XmlElement(namespace = "http://ds.sw.gmit.ie/models/")
    protected int rentalId;
    @XmlElement(namespace = "http://ds.sw.gmit.ie/models/")
    protected int seats;
    @XmlElement(namespace = "http://ds.sw.gmit.ie/models/", required = true)
    protected String transmission;

    /**
     * Gets the value of the carMake property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarMake() {
        return carMake;
    }

    /**
     * Sets the value of the carMake property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarMake(String value) {
        this.carMake = value;
    }

    /**
     * Gets the value of the carModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarModel() {
        return carModel;
    }

    /**
     * Sets the value of the carModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarModel(String value) {
        this.carModel = value;
    }

    /**
     * Gets the value of the carReg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarReg() {
        return carReg;
    }

    /**
     * Sets the value of the carReg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarReg(String value) {
        this.carReg = value;
    }

    /**
     * Gets the value of the carSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarSize() {
        return carSize;
    }

    /**
     * Sets the value of the carSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarSize(String value) {
        this.carSize = value;
    }

    /**
     * Gets the value of the fuelType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuelType() {
        return fuelType;
    }

    /**
     * Sets the value of the fuelType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuelType(String value) {
        this.fuelType = value;
    }

    /**
     * Gets the value of the rentalId property.
     * 
     */
    public int getRentalId() {
        return rentalId;
    }

    /**
     * Sets the value of the rentalId property.
     * 
     */
    public void setRentalId(int value) {
        this.rentalId = value;
    }

    /**
     * Gets the value of the seats property.
     * 
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Sets the value of the seats property.
     * 
     */
    public void setSeats(int value) {
        this.seats = value;
    }

    /**
     * Gets the value of the transmission property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransmission() {
        return transmission;
    }

    /**
     * Sets the value of the transmission property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransmission(String value) {
        this.transmission = value;
    }

}
