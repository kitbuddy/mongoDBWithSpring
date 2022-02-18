package com.example.mongoDBWithSpring.Controllers;

import com.example.mongoDBWithSpring.model.JSONoutput;
import com.example.mongoDBWithSpring.service.OpenApisForTesting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openapi")
@Slf4j
public class GoogleApisController {

    @Autowired
    OpenApisForTesting openApisForTesting;

    @GetMapping("/coindesk")
    public String getDistanceMatrixJson() {
       return openApisForTesting.coindeskApiForTest1();
    }

    @GetMapping("/getJsonOutput")
    public JSONoutput getBpisByCurrency() {
        log.info("---Inside getBpisByCurrency ------");

        return openApisForTesting.timer7OutputForJSON();
    }
}
