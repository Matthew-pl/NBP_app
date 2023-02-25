package org.example;

import java.io.IOException;
import java.net.URISyntaxException;


public class App_Service {

    public void run () throws IOException, URISyntaxException, InterruptedException {

        UserInterface currentInterface = new UserInterface();
        Float amount = currentInterface.getAmountFromUser();
        String currency = currentInterface.getCurrencyFromUser();

        NBP_HTTP_Service service = new NBP_HTTP_Service();
        NBP_Response parsedResponse = service.getResponseFromNBPAndParse(currency.toLowerCase());

        Float availableAmount = amount/(parsedResponse.getRate(0));
        String formattedAmount = String.format("%.2f", availableAmount);

        System.out.printf("For %s PLN you can buy %s %s", amount, formattedAmount, currency.toUpperCase());

    }

}
