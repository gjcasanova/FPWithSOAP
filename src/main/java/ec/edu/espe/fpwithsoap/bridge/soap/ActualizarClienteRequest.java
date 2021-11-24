package ec.edu.espe.fpwithsoap.bridge.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cedula" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clienteRQ" type="{http://frexofa.op/cliente}clienteActualizarRQ"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cedula",
    "clienteRQ"
})
@XmlRootElement(name = "actualizarClienteRequest")
public class ActualizarClienteRequest {

    @XmlElement(required = true)
    protected String cedula;
    @XmlElement(required = true)
    protected ClienteActualizarRQ clienteRQ;

    /**
     * Gets the value of the cedula property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Sets the value of the cedula property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCedula(String value) {
        this.cedula = value;
    }

    /**
     * Gets the value of the clienteRQ property.
     * 
     * @return
     *     possible object is
     *     {@link ClienteActualizarRQ }
     *     
     */
    public ClienteActualizarRQ getClienteRQ() {
        return clienteRQ;
    }

    /**
     * Sets the value of the clienteRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClienteActualizarRQ }
     *     
     */
    public void setClienteRQ(ClienteActualizarRQ value) {
        this.clienteRQ = value;
    }

}
