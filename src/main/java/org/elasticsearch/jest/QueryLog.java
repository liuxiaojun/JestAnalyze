package org.elasticsearch.jest;

import io.searchbox.annotations.JestId;
/**
 * Created by GaoPan on 2016/4/9.
 * 欢迎访问http://devops.taobao.com
 * 报名Elasticsearch高端培训，尽在DevOps运维
 */
public class QueryLog {
    @JestId
    private long docId;
    private long userId;
    private int age;
    private String queryWord;

    public long getDocId() {
        return docId;
    }

    public void setDocId(long docId) {
        this.docId = docId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getQueryWord() {
        return queryWord;
    }

    public void setQueryWord(String queryWord) {
        this.queryWord = queryWord;
    }
}
