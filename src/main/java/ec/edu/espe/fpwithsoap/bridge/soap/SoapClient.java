package ec.edu.espe.fpwithsoap.bridge.soap;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Service
@Component("NumberConversion")
public class SoapClient extends WebServiceGatewaySupport {
    private String endpoint = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso?wsdl";
}
