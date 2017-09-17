package fi.jyu.webapp.clients;

import fi.jyu.webapp.clients.test.*;

import java.util.ArrayList;

public class StorageClient {

    public StorageClient(){}

    public String GetList(){

        DiskService disksService = new DiskService();
        Disk disk = disksService.getDiskPort();
        System.out.println(disk.getDisks());


        return("-1");
    }


}
