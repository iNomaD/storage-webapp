package fi.jyu.webapp.clients;

import fi.jyu.webapp.clients.test.*;

import java.util.ArrayList;

public class StorageClient {

    public StorageClient(){}

    public String GetList(){

        DiskService disksService = new DiskService();
        Disk disk = disksService.getDiskPort();

        return disk.getDisks();
    }

    public String GetHD(String i){

        DiskService disksService = new DiskService();
        Disk disk = disksService.getDiskPort();

        return disk.getDiskbyId(i);
    }

}
