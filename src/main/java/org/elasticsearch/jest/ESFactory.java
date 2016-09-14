package org.elasticsearch.jest;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

/**
 * Created by GaoPan on 2016/4/9.
 * 欢迎访问http://devops.taobao.com
 * 报名Elasticsearch高端培训，尽在DevOps运维
 */
public class ESFactory {
    private static String hostAddrs = "http://9.110.187.66:9200";
    private static JestClient client;
    private ESFactory() {

    }

    public synchronized static JestClient getClient() {
        if (client == null) {
            // Construct a new Jest client according to configuration via factory
            JestClientFactory factory = new JestClientFactory();
            factory.setHttpClientConfig(new HttpClientConfig
                    .Builder(hostAddrs)
                    .multiThreaded(true)
                    .build());
            client = factory.getObject();
        }
        return client;
    }
}
