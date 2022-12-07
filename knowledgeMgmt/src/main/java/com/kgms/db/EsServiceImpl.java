package com.kgms.db;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class EsServiceImpl {

    @Autowired
    private EsManager esManager;

    public <T> void search(String index, Map<String, Object> condition, Class<T> clazz) throws IOException {
        SearchResponse<T> searchResp = esManager.getClient().search(s -> s.index(index).query(q -> q
                        .term(t -> t.field("name").value(v -> v.stringValue("bicycle")))),
                clazz);

        for (Hit<T> hit : searchResp.hits().hits()) {
            processProduct(hit.source());

        }
    }


    private <T> void processProduct(T source) {

    }

    public void createIndex(String IndexName, String indexAliaName) {
        CreateIndexResponse createResponse;
        try {
            createResponse = esManager.getClient().indices()
                    .create(c -> c
                            .index(IndexName)
                            .aliases(indexAliaName, a -> a
                                    .isWriteIndex(true)
                            )
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
