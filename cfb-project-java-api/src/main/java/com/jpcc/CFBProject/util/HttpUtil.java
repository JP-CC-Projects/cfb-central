package com.jpcc.CFBProject.util;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

public class HttpUtil {

    public static String makeApiCall(String baseUrl,
                                     String path,
                                     String apiKey,
                                     Map<String, Object> queryParams) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl).path(path);

        // Add query parameters from the map
        for (Map.Entry<String, Object> param : queryParams.entrySet()) {
            builder.queryParam(param.getKey(), param.getValue());
        }

        URI uri = builder.build().encode().toUri();
        System.out.println("URL being called: " + uri.toString());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}