package com.example.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private static final Logger log = LoggerFactory.getLogger(LogService.class);
    
    public void print() {
        log.info("   |--------------------------------------------|");
    }
    
}
