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
 *         &lt;element name="clienteRQ" type="{http://frexofa.op/cliente}clienteRQ"/>
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
    "clienteRQ"
})
@XmlRootElement(name = "crearClienteRequest")
public class CrearClienteRequest {

    @XmlElement(required = true)
    protected ClienteRQ clienteRQ;

    /**
     * Gets the value of the clienteRQ property.
     * 
     * @return
     *     possible object is
     *     {@link ClienteRQ }
     *     
     */
    public ClienteRQ getClienteRQ() {
        return clienteRQ;
    }

    /**
     * Sets the value of the clienteRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClienteRQ }
     *     
     */
    public void setClienteRQ(ClienteRQ value) {
        this.clienteRQ = value;
    }

}
