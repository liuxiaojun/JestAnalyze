package org.elasticsearch.jest;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * Created by GaoPan on 2016/4/9.
 * 欢迎访问http://devops.taobao.com
 * 报名Elasticsearch高端培训，尽在DevOps运维
 */
public class JestAnalyze {

    private JestClient client = ESFactory.getClient();

    public void indexBulk(String indexName) {
        try {
            Bulk.Builder bulkBuilder = new Bulk.Builder();

            QueryLog log1 = new QueryLog();
            log1.setDocId(1);
            log1.setUserId(1001);
            log1.setAge(26);
            log1.setQueryWord("iphone");
            Index index1 = new Index.Builder(log1).index(indexName).type(indexName).build();
            bulkBuilder.addAction(index1);

            QueryLog log2 = new QueryLog();
            log2.setDocId(2);
            log2.setUserId(1002);
            log2.setAge(28);
            log2.setQueryWord("elasticsearch");
            Index index2 = new Index.Builder(log2).index(indexName).type(indexName).build();
            bulkBuilder.addAction(index2);

            QueryLog log3 = new QueryLog();
            log3.setDocId(3);
            log3.setUserId(1003);
            log3.setAge(26);
            log3.setQueryWord("movie");
            Index index3 = new Index.Builder(log3).index(indexName).type(indexName).build();
            bulkBuilder.addAction(index3);

            QueryLog log4 = new QueryLog();
            log4.setDocId(4);
            log4.setUserId(1004);
            log4.setAge(27);
            log4.setQueryWord("elasticsearch");
            Index index4 = new Index.Builder(log4).index(indexName).type(indexName).build();
            bulkBuilder.addAction(index4);

            JestResult rs =  client.execute(bulkBuilder.build());
            System.out.println(rs.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void aggs(String indexName, String term1, String term2) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.aggregation(
                AggregationBuilders.terms(term1).field(term1)
                .subAggregation(AggregationBuilders.terms(term2).field(term2))).size(0);
        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex(indexName).build();
        try {
            JestResult rs = client.execute(search);
            System.out.println(rs.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JestAnalyze jestInstance = new JestAnalyze();
        String indexName = "querylog";
        jestInstance.indexBulk(indexName);
        String term1 = "queryWord";
        String term2 = "age";
        jestInstance.aggs(indexName, term1, term2);
    }
}
