package com.kgms.db;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class EsManager implements InitializingBean {

    private String addr = "localhost";
    private int port = 9200;
    RestClient restClient = null;

    ElasticsearchClient client = null;



    @Override
    public void afterPropertiesSet() throws Exception {
        initEs();
    }

    public void initEs() {
        // Create the low-level client
        restClient = RestClient.builder(new HttpHost(addr, port)).build();

        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

        // And create the API client
        client = new ElasticsearchClient(transport);
    }

    public ElasticsearchClient getClient() {
        return client;
    }
}
