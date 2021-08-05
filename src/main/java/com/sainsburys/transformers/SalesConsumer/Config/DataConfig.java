package com.sainsburys.transformers.SalesConsumer.Config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class DataConfig {


    @Value("${bootstrapservers}")
    private String bootstrapservers;

    @Value("${consumer_group_id}")
    private String consumer_group_id;

    @Value("${max_poll_records}")
    private String max_poll_records;

    @Value("${auto_offset_reset}")
    private String auto_offset_reset;

    @Value("${enable_auto_commit}")
    private String enable_auto_commit;


    @Value("${topic_name}")
    private String myTopicName;


    @Value ("${schemaRegistryURL}")
    private String schemaRegistryURL;

    public String getMyTopicName() {
        return myTopicName;
    }

    public void setMyTopicName(String myTopicName) {
        this.myTopicName = myTopicName;
    }

    public String getSchemaRegistryURL() {
        return schemaRegistryURL;
    }

    public void setSchemaRegistryURL(String schemaRegistryURL) {
        this.schemaRegistryURL = schemaRegistryURL;
    }

    public String getBootstrapservers() {
        return bootstrapservers;
    }

    public void setBootstrapservers(String bootstrapservers) {
        this.bootstrapservers = bootstrapservers;
    }

    public String getConsumer_group_id() {
        return consumer_group_id;
    }

    public void setConsumer_group_id(String consumer_group_id) {
        this.consumer_group_id = consumer_group_id;
    }

    public String getMax_poll_records() {
        return max_poll_records;
    }

    public void setMax_poll_records(String max_poll_records) {
        this.max_poll_records = max_poll_records;
    }

    public String getAuto_offset_reset() {
        return auto_offset_reset;
    }

    public void setAuto_offset_reset(String auto_offset_reset) {
        this.auto_offset_reset = auto_offset_reset;
    }

    public String getEnable_auto_commit() {
        return enable_auto_commit;
    }

    public void setEnable_auto_commit(String enable_auto_commit) {
        this.enable_auto_commit = enable_auto_commit;
    }


}



