package com.openbravo.pos.payment;

import com.openbravo.pos.forms.AppProperties;

public class PaymentGatewayFac {

    private PaymentGatewayFac() {
    }

    public static PaymentGateway getPaymentGateway(AppProperties props) {

        String sReader = props.getProperty("payment.gateway");
// JG 16 May 12 use switch
        switch (sReader) {
            case "external":
                return new PaymentGatewayExt();
            case "PayPoint / SecPay":
                return new PaymentGatewayPayPoint(props);
            case "AuthorizeNet":
                return new PaymentGatewayAuthorizeNet(props);
            case "BluePay AUTH.NET EMU":
                return new PaymentGatewayBluePayAUTHNETEMU(props);
            case "BluePay 2.0 POST":
                return new PaymentGatewayBluePay20POST(props);
            case "La Caixa (Spain)":
                return new PaymentGatewayCaixa(props);
            case "Planetauthorize":
                return new PaymentGatewayPlanetauthorize(props);
            case "First Data / LinkPoint / YourPay":
                return new PaymentGatewayLinkPoint(props);
            case "PaymentsGateway.net":
                return new PaymentGatewayPGNET(props);
            default:
                return null;
        }
    }
}
