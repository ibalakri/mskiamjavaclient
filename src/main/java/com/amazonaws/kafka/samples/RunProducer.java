package com.amazonaws.kafka.samples;

import org.apache.kafka.clients.producer.Producer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import samples.clickstream.avro.ClickEvent;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RunProducer implements Callable<String>{

    private static final Logger logger = LogManager.getLogger(RunProducer.class);
    private final Producer<java.lang.String, ClickEvent> kafkaProducer;
    private boolean cancel = false;
    private static AtomicInteger userIDMax = new AtomicInteger(1000);
    private Random rand = new Random();
    private String topic;
    private String client_Id;

    RunProducer(Producer<java.lang.String, ClickEvent> kafkaProducer, String topic, String client_Id) {
        this.kafkaProducer = kafkaProducer;
        this.topic = topic;
        this.client_Id = client_Id;
    }

    void shutdown() {
        cancel = true;
    }

    private void runProducer() throws Exception {
        Events producer = new Events(topic);
        producer.genEvents(kafkaProducer, client_Id);
    }

    @Override
    public String call() throws Exception {
        runProducer();
        return "Task executed in " + Thread.currentThread().getName();
    }
}
