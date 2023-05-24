package com.amazonaws.kafka.samples;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.kafka.common.TopicPartition;
import samples.clickstream.avro.ClickEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Events {
    private static final Logger logger = LogManager.getLogger(Events.class);
    private final static AtomicLong totalEvents = new AtomicLong(0L);
    private AtomicInteger errorCount = new AtomicInteger(0);
    private AtomicInteger eventCount = new AtomicInteger(0);
    private final Map<TopicPartition, Long> lastOffset = new HashMap<>();
    private Long previousGlobalSeqNo = 0L;
    private String topic;

    Events(String topic){
        this.topic = topic;
        //logger.info(topic);
    }

    static Long getTotalEvents(){
        return totalEvents.longValue();
    }

    int getThreadEventCount(){
        return eventCount.intValue();
    }

    int getErrorCount(){
        return errorCount.intValue();
    }

    Map<TopicPartition, Long> getLastOffset(){
        return lastOffset;
    }

    Long getLastGlobalSeqNo(){
        return previousGlobalSeqNo;
    }

    void genEvents(Producer<String, ClickEvent> kafkaProducer, String userID) throws Exception {

        ClickEvent event = new ClickEvent();
        String Account_Id = null;
        String Customer_Name = null;
        String Merchant_Type = null;
        String Transaction_Id = null;
        String Transaction_Type = null;
        int Transaction_Amount = 0;
        String Transaction_Date = null;
        int icount = 0;
        int max_count = 100;
        //String topic = System.getenv("topic_name");
      
        do {

            Account_Id = event.getAccount_Id().toString();
            Customer_Name = event.getCustomer_Name(10).toString();
            Merchant_Type = event.getMerchant_Type().toString();
            Transaction_Id = event.getTransaction_Id(16).toString();
            Transaction_Type = event.getTransaction_Type().toString();
            Transaction_Amount = event.getTransaction_Amount();
            Transaction_Date = event.getTransaction_Date("01/18/2023").toString();
            event = genUserEvent(Account_Id,Customer_Name,Merchant_Type,Transaction_Id,Transaction_Type,Transaction_Amount,Transaction_Date);
            //logger.info(new Gson().toJson(event));
            try{
                ProducerRecord record = new ProducerRecord<>(this.topic,userID, event);
                logger.info(record);
                
                 kafkaProducer.send(new ProducerRecord<>(this.topic,userID, event), (recordMetadata, e) -> {
                    if (e != null) {
                        logger.info("Error occurred");
                        logger.error(Util.stackTrace(e));
                        errorCount.getAndIncrement();
                    } 
                }).get();
            }
            catch (Exception e)
            {
                logger.info("Error occurred in kafkaProducer.send");
                logger.error(Util.stackTrace(e));
            }
            
            icount++;
        } while (icount < max_count && errorCount.get() < 1);

    }

    private ClickEvent genUserEvent(String Account_Id, String Customer_Name, String Merchant_Type, String Transaction_Id, String Transaction_Type, int Transaction_Amount, String Transaction_Date)
    {
        

       return ClickEvent.newBuilder()
                .setAccount_Id(Account_Id)
                .setCustomer_Name(Customer_Name)
                .setMerchant_Type(Merchant_Type)
                .setTransaction_Id(Transaction_Id)
                .setTransaction_Type(Transaction_Type)
                .setTransaction_Amount(Transaction_Amount)
                .setTransaction_Date(Transaction_Date)
                .build();
                
        

    }
    
}

