package com.example.mongoDBWithSpring.serviceImpl;

import com.example.mongoDBWithSpring.model.JSONoutput;
import com.example.mongoDBWithSpring.service.OpenApisForTesting;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static com.example.mongoDBWithSpring.Constants.*;

@Service
@Slf4j
public class OpenApisForTestingImpl implements OpenApisForTesting{

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public String coindeskApiForTest1() {


        return restTemplate.getForObject(URL_FOR_LIST_COINDESK, String.class);
    }

    @Override
    public JSONoutput timer7OutputForJSON() {
        return null;
    }


}
