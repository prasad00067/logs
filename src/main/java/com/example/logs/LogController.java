package com.example.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private static final Logger log = LoggerFactory.getLogger(LogController.class);

    @Autowired
    private LogService service;
    @RequestMapping("/")
    public void getLogs() {
        log.info("|--------------------------------------------|");
        log.info("|           Lakshmi Priyanka Dasari          |");
        service.print();
    }

}
