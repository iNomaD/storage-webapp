package fi.jyu.webapp.clients;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;


import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Date;

import fi.jyu.webapp.clients.gamasystem.*;


public class CurrencyConvertorClient {

    public CurrencyConvertorClient(){}

    public double sendRequest(double inputValue) throws ParseException, DatatypeConfigurationException {

        return sendRequest(inputValue,"USD");
    }

    public double sendRequest(double inputValue, String inputCurrent) throws ParseException, DatatypeConfigurationException {

        ExchangeRates converter = new ExchangeRates();
        ExchangeRatesSoap converterSoap = converter.getExchangeRatesSoap();

        DateFormat DF = new SimpleDateFormat("d.M.y"); //2007-12-31T00:00:00.000+03:00
        String DateString = "17.09.2017";
        Date date = new Date();//DF.parse(DateString);

        GregorianCalendar gregory = new GregorianCalendar();
        gregory.setTime(date);
        gregory.add(GregorianCalendar.DATE,-1);
        date = gregory.getTime();


        XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
        calendar.setTimezone(180);

        DateFormat OutF = new SimpleDateFormat("yyyy-MM-dd");

        //System.out.println(OutF.format(date));

        //System.out.println(converterSoap.convertToEUR(BigDecimal.valueOf(inputValue),"BS", inputCurrent, OutF.format(date),1));

        return converterSoap.convertToEUR(BigDecimal.valueOf(inputValue),"BS", inputCurrent, OutF.format(date),1).doubleValue();//converterSoap.getCurrencyRate("USD", calendar).doubleValue();
    }

}
