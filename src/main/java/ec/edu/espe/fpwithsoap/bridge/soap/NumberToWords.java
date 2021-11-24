package ec.edu.espe.fpwithsoap.bridge.soap;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "ubiNum"
})
@XmlRootElement(name = "NumberToWords")
public class NumberToWords {

    @XmlElement(required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger ubiNum;

    /**
     * Obtiene el valor de la propiedad ubiNum.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getUbiNum() {
        return ubiNum;
    }

    /**
     * Define el valor de la propiedad ubiNum.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setUbiNum(BigInteger value) {
        this.ubiNum = value;
    }

}