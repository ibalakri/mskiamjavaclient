package com.amazonaws.kafka.samples;

import org.apache.kafka.clients.producer.*;
import samples.clickstream.avro.ClickEvent;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Future;
import java.lang.InterruptedException;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.KafkaEvent;


public class KafkaClickstreamClient implements RequestHandler<KafkaEvent, String> {

    private static final Logger logger = LogManager.getLogger(KafkaClickstreamClient.class);
    static AtomicLong counter = new AtomicLong(0);
    static Long startTime;
    
    @Parameter(names = {"--numThreads", "-nt"})
    static Integer numThreads = 2; 
    
    @Parameter(names = {"--help", "-h"}, help = true)
    private boolean help = false;
    
    @Parameter(names = {"--runFor", "-rf"})
    private static Integer runFor = 0;

    @Parameter(names = {"--numberOfUsers", "-nou"})
    static Integer numberOfUsers = 1;
    static AtomicBoolean cancel = new AtomicBoolean(false);

    @Parameter(names = {"--topic", "-t"})
    static String topic = "ExampleTopic";

    @Parameter(names = {"--propertiesFilePath", "-pfp"})
    private static String propertiesFilePath = "/tmp/kafka/producer.properties";

 

    @Parameter(names = {"--noDelay", "-nd"})
    static boolean noDelay = false;

    @Parameter(names = {"--sslEnable", "-ssl"})
    static boolean sslEnable = false;

    @Parameter(names = {"--iamEnable", "-iam"})
    static boolean iamEnable = false;

    @Parameter(names = {"--mTLSEnable", "-mtls"})
    static boolean mTLSEnable = false;

    @Parameter(names = {"--glueSchemaRegistry", "-gsr"})
    static boolean glueSchemaRegistry = false;

    @Parameter(names = {"--gsrRegistryName", "-grn"})
    static String gsrRegistryName;

    @Parameter(names = {"--gsrSchemaName", "-gsn"})
    static String gsrSchemaName;

    @Parameter(names = {"--gsrSchemaDescription", "-gsd"})
    static String gsrSchemaDescription = "Schema for Sample Transaction";

    @Parameter(names = {"--saslscramEnable", "-sse"})
    static boolean saslscramEnable = false;

    @Parameter(names = {"--saslscramUser", "-ssu"})
    static String saslscramUser;

    @Parameter(names = {"--region", "-reg"})
    static String region = "us-east-1";

    @Parameter(names = {"--gsrRegion", "-gsrr"})
    static String gsrRegion = "us-east-1";

    @Parameter(names = {"--gsrAutoRegistration", "-gar"})
    static boolean gsrAutoRegistration = false;

    @Parameter(names = {"--gsrCompatibilitySetting", "-gcs"})
    static String gsrCompatibilitySetting;

    @Parameter(names = {"--nologgingEvents", "-nle"})
    static boolean nologgingEvents = false; 

    static long startingGlobalSeqNo = 0; 

    
    private void runProducer(String bootstrap, String clientid, String topic) throws Exception {
        
        startTime = System.nanoTime();
        logger.info("Start time: {} \n", TimeUnit.NANOSECONDS.toMillis(startTime));
        logger.info("Reached specified run time of {} seconds. Shutting down. \n", runFor);
        final Producer<String, ClickEvent> kafkaProducer = new KafkaProducerFactory(bootstrap, clientid).createProducer();
        try{
            RunProducer r = new RunProducer(kafkaProducer, topic,clientid);
            logger.info("Making a call to run producer");
            r.call();
            logger.info("shutdown the run producer");
            r.shutdown();
        }
        catch (Exception e)
        {
            logger.error(Util.stackTrace(e));
        }
    }


    @Override
    public String handleRequest(KafkaEvent kafkaEvent, Context context) {
        String response = "200 OK";
        String topic = System.getenv("TOPIC_NAME");
        logger.info("Logging Kafka event");
        //logger.info(kafkaEvent);
        String bootstrap = System.getenv("BOOTSTRAP_SERVERS_CONFIG");
        String client_id = System.getenv("CLIENT_ID_CONFIG");
        try{
           KafkaClickstreamClient client = new KafkaClickstreamClient();
           ParametersValidator.validate();
           client.runProducer(bootstrap,client_id,topic);
        }
        catch (Exception e)
        {
            logger.error(Util.stackTrace(e));
        }
        return response;
    }

}
