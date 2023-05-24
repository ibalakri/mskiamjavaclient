package com.amazonaws.kafka.samples;

import com.amazonaws.kafka.samples.saslscram.Secrets;
import com.amazonaws.services.schemaregistry.serializers.avro.AWSKafkaAvroSerializer;
import com.amazonaws.services.schemaregistry.utils.AWSSchemaRegistryConstants;
import com.amazonaws.services.schemaregistry.utils.AvroRecordType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.amazonaws.services.schemaregistry.serializers.GlueSchemaRegistryKafkaSerializer;
import samples.clickstream.avro.ClickEvent;
import software.amazon.awssdk.services.glue.model.Compatibility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

class KafkaProducerFactory {

    private final String ACKS_CONFIG = "all";
    private final String RETRIES_CONFIG = "5";
    private final String bootstrap;
    private final String clientid;
    private static final Logger logger = LogManager.getLogger(KafkaClickstreamClient.class);

    KafkaProducerFactory(String bootstrap, String clientid) {
        this.bootstrap = bootstrap;
        this.clientid = clientid;
    }

    Producer<String, ClickEvent> createProducer() throws Exception {

        //logger.info(bootstrap);
        //logger.info(clientid);
        Properties producerProps = new Properties();
        producerProps.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
        producerProps.setProperty(ProducerConfig.CLIENT_ID_CONFIG, clientid);
        producerProps.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
        producerProps.setProperty(SaslConfigs.SASL_MECHANISM, "AWS_MSK_IAM");
        producerProps.setProperty(SaslConfigs.SASL_JAAS_CONFIG, "software.amazon.msk.auth.iam.IAMLoginModule required;");
        producerProps.setProperty(SaslConfigs.SASL_CLIENT_CALLBACK_HANDLER_CLASS, "software.amazon.msk.auth.iam.IAMClientCallbackHandler");
        producerProps.setProperty(ProducerConfig.ACKS_CONFIG, ACKS_CONFIG);
        producerProps.setProperty(ProducerConfig.RETRIES_CONFIG, RETRIES_CONFIG);
        producerProps.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producerProps.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, GlueSchemaRegistryKafkaSerializer.class.getName());
        producerProps.setProperty(AWSSchemaRegistryConstants.AWS_REGION, KafkaClickstreamClient.gsrRegion);
        producerProps.setProperty(AWSSchemaRegistryConstants.AVRO_RECORD_TYPE, AvroRecordType.GENERIC_RECORD.getName());
        producerProps.setProperty(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        producerProps.put(AWSSchemaRegistryConstants.DATA_FORMAT, "AVRO"); // OR "JSON"
        producerProps.setProperty(AWSSchemaRegistryConstants.SCHEMA_AUTO_REGISTRATION_SETTING, "false");
        if (KafkaClickstreamClient.gsrRegistryName != null)
          producerProps.setProperty(AWSSchemaRegistryConstants.REGISTRY_NAME, KafkaClickstreamClient.gsrRegistryName);
        if (KafkaClickstreamClient.gsrSchemaName != null)
           producerProps.setProperty(AWSSchemaRegistryConstants.SCHEMA_NAME, KafkaClickstreamClient.gsrSchemaName);
        if (KafkaClickstreamClient.gsrSchemaDescription != null)
           producerProps.setProperty(AWSSchemaRegistryConstants.DESCRIPTION, KafkaClickstreamClient.gsrSchemaDescription);
        if (KafkaClickstreamClient.gsrCompatibilitySetting != null)
           producerProps.setProperty(AWSSchemaRegistryConstants.COMPATIBILITY_SETTING, Compatibility.FULL.toString());
        return new KafkaProducer<>(producerProps);
    }
}
