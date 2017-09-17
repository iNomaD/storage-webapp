package fi.jyu.soapservice.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class CSVReader {
    private String csvFile = "src/main/resources/database.csv";
    private String cvsSplitBy = ",";

    public String CSVProcess(String id) {
        BufferedReader br = null;
        String line;
        String result = "<NewDataSet>";
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] hd = line.split(cvsSplitBy);

                if (((Integer.parseInt(hd[0]) == Integer.parseInt(id)))) {
                    result = result + ("<HD><ID>" + hd[0] + "</ID><Vendor>" + hd[1] + "</Vendor><Type>" + hd[2] + "</Type><Capacity>" + hd[3] + "</Capacity><Rpm>" + hd[4] + "</Rpm><Price>" + hd[5] + "</Price></HD>");
                    break;
                } else if (Integer.parseInt(id) <= -1) {
                    result = result + ("<HD><ID>" + hd[0] + "</ID><Vendor>" + hd[1] + "</Vendor><Type>" + hd[2] + "</Type><Capacity>" + hd[3] + "</Capacity><Rpm>" + hd[4] + "</Rpm><Price>" + hd[5] + "</Price></HD>");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (result.equals("<NewDataSet>")) {
            return "<NewDataSet> No Information </NewDataSet>";
        } else {
            result = result + "</NewDataSet>";
            return result;
        }
    }
}

