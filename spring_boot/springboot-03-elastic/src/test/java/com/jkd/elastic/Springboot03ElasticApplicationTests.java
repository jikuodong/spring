package com.jkd.elastic;

import com.alibaba.fastjson.JSONObject;
import com.jkd.elastic.bean.Users;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.io.IOException;

@SpringBootTest
class Springboot03ElasticApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    String index = "users";

    /**
     * 创建索引
     */
    @Test
    void contextLoads() throws IOException {
        CreateIndexRequest indexRequest = new CreateIndexRequest(index);
        CreateIndexResponse response = restHighLevelClient.indices()
                .create(indexRequest, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());
    }

    /**
     * 添加文档
     */
    @Test
    public void addDoc() throws IOException {
        IndexRequest request = new IndexRequest(index);
        String source = JSONObject.toJSONString(new Users(10000,"逍遥",31));
        // 手动设置id
        request.id("10001");
        request.source(source,XContentType.JSON);
        IndexResponse response = restHighLevelClient.index(request,RequestOptions.DEFAULT);
        System.out.println(response.getResult());
    }

    //保存
    @Test
    public void test01(){
        Users users = new Users(10000, "逍遥", 30);
        //修改也可以用save
        elasticsearchRestTemplate.save(users);
    }

    //获取
    @Test
    public void test02(){
        //获取aaa索引中id为1的Article对象
        Users users = elasticsearchRestTemplate.get("10000", Users.class);
        System.out.println(users);
    }


}
