package com.people.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.http.HttpHeaders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ELSConfig {

    @Bean
    public ClientConfiguration clientConfiguration(){
        // config reference link : https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#elasticsearch.clients.configuration
        HttpHeaders compatibilityHeaders = new HttpHeaders();
        compatibilityHeaders.add("Accept", "application/vnd.elasticsearch+json;compatible-with=7");
        compatibilityHeaders.add("Content-Type", "application/vnd.elasticsearch+json;"
                + "compatible-with=7");
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .withDefaultHeaders(compatibilityHeaders)    // this variant for imperative code
                .withHeaders(() -> compatibilityHeaders)     // this variant for reactive code
                .withHeaders(() -> {
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("currentTime", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                    return headers;
                })
                .build();
        return clientConfiguration;
    }

}




