package controller;

import annotation.Autowired;
import service.MyService;

public class MyController {

    @Autowired
    MyService service;

    public void getData(String data){
        service.getData(data);
    }

}
