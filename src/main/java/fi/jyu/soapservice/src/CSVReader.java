package fi.jyu.soapservice.src;

import fi.jyu.soapservice.src.models.Constants;
import fi.jyu.soapservice.src.models.DiskModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class CSVReader {
    private String csvFile = "src/main/resources/database.csv";
    private String cvsSplitBy = ",";

    public String CSVProcess(String id) {
        BufferedReader br = null;
        String line;

        List<DiskModel> disks = new ArrayList<>();
        try {

            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] hd = line.split(cvsSplitBy);

                if ((Integer.parseInt(hd[0]) == Integer.parseInt(id)) || (Integer.parseInt(id) <= -1)) {
                    disks.add(new DiskModel(Integer.valueOf(hd[0]), hd[1], hd[2], Integer.valueOf(hd[3]), Constants.capacityGB, Integer.valueOf(hd[4]), Integer.valueOf(hd[5]), Constants.priceUSD));
                    if(Integer.parseInt(id) > -1) {
                        break;
                    }
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

        if (disks.isEmpty()) {
            return "<NewDataSet>"+Constants.NO_INFORMATION+"</NewDataSet>";
        } else {
            String result = "<NewDataSet>";
            for(DiskModel disk : disks){
                result += disk.toXML();
            }
            result = result + "</NewDataSet>";
            return result;
        }
    }
}

