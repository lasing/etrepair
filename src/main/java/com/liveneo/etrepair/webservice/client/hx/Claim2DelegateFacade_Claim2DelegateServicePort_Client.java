package com.liveneo.etrepair.webservice.client.hx;

/**
 * Please modify this class to meet your needs This class is not complete
 */
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2016-04-13T17:43:43.133+08:00
 * Generated source version: 2.7.18
 * 
 */
public final class Claim2DelegateFacade_Claim2DelegateServicePort_Client {
    private static final QName SERVICE_NAME = new QName("http://delegate.provider.webservice.interact.application.sinosoft.com/",
                                                    "Claim2DelegateServiceService");

    private Claim2DelegateFacade_Claim2DelegateServicePort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = Claim2DelegateServiceService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        Claim2DelegateServiceService ss = new Claim2DelegateServiceService(wsdlURL, SERVICE_NAME);
        Claim2DelegateFacade port = ss.getClaim2DelegateServicePort();
        {
            System.out.println("Invoking setCaseToNormal...");
            java.lang.String _setCaseToNormal_request = "";
            try {
                java.lang.String _setCaseToNormal__return = port.setCaseToNormal(_setCaseToNormal_request);
                System.out.println("setCaseToNormal.result=" + _setCaseToNormal__return);
            } catch (Exception_Exception e) {
                System.out.println("Expected exception: Exception has occurred.");
                System.out.println(e.toString());
            }
        }
        System.exit(0);
    }
}
