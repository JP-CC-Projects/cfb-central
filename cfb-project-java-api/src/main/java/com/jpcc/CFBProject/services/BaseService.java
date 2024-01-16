package com.jpcc.CFBProject.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpcc.CFBProject.config.CFBApiConfig;
import com.jpcc.CFBProject.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class BaseService {
    protected WebClient webClient;
    protected ObjectMapper objectMapper;
    protected CFBApiConfig cfbApiConfig;
    @Value("${cfbApiKey}")
    protected String cfbApiKey;
    @Value("${googleSearchCx}")
    protected String googleSearchCx;
    @Value("${googleApiKey}")
    protected String googleApiKey;

    @Autowired
    public BaseService(WebClient webClient, ObjectMapper objectMapper, CFBApiConfig cfbApiConfig) {
        this.webClient = webClient;
        this.objectMapper = objectMapper;
        this.cfbApiConfig = cfbApiConfig;
    }
    protected String fetchJsonFromApi(String endpoint, Map<String, Object> queryParams) throws Exception {
        return HttpUtil.makeApiCall(cfbApiConfig.getBase(),
                endpoint, cfbApiKey, queryParams);
    }
    protected <T, R> List<R> fetchSaveAndConvert(String endpoint,
                                                 Map<String, Object> queryParams,
                                                 Class<T[]> clazz,
                                                 Function<T, R> converter,
                                                 Function<R, Boolean> existsChecker,
                                                 Consumer<R> saver) throws Exception {
        String json = fetchJsonFromApi(endpoint, queryParams);
        T[] objects = objectMapper.readValue(json, clazz);
        List<R> results = new ArrayList<>();

        for (T object : objects) {
            R entity = converter.apply(object);
            if (!existsChecker.apply(entity)) {
                saver.accept(entity);
                results.add(entity);
            }
        }
        return results;
    }
    protected <T, R> List<R> fetchSaveAndConvertBatch(String endpoint,
                                                      Map<String, Object> queryParams,
                                                      Class<T[]> clazz,
                                                      Function<T, R> converter,
                                                      Function<R, Boolean> existsChecker,
                                                      Consumer<List<R>> batchSaver) throws Exception {
        String json = fetchJsonFromApi(endpoint, queryParams);
        T[] objects = objectMapper.readValue(json, clazz);
        List<R> newEntities = new ArrayList<>();

        for (T object : objects) {
            R entity = converter.apply(object);
            if (!existsChecker.apply(entity)) {
                newEntities.add(entity);
            }
        }

        batchSaver.accept(newEntities);
        return newEntities;
    }
}