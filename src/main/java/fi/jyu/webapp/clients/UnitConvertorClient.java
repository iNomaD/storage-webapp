package fi.jyu.webapp.clients;

import fi.jyu.webapp.clients.webservicex.ComputerUnit;
import fi.jyu.webapp.clients.webservicex.ComputerUnitSoap;
import fi.jyu.webapp.clients.webservicex.Computers;

public class UnitConvertorClient {

    public UnitConvertorClient(){}

    public double sendRequest(double inputValue, String inputUnit, String outputUnit){

        ComputerUnit convertorService = new ComputerUnit();
        ComputerUnitSoap convertorServiceSoap = convertorService.getComputerUnitSoap();

        Computers INUnit = Computers.fromValue(inputUnit);
        Computers OUTUnit = Computers.fromValue(outputUnit);
        //switch (inputUnit.toLowerCase())
        //    case "byte":

        return convertorServiceSoap.changeComputerUnit(inputValue,INUnit,OUTUnit);
    }
}
