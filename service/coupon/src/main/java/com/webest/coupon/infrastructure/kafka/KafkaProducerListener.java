package com.webest.coupon.infrastructure.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaProducerListener implements ProducerListener<String, String> {

    @Override
    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
        ProducerListener.super.onSuccess(producerRecord, recordMetadata);
//        log.info("message body -> {}", producerRecord.value());
//        log.info("message header -> {}", producerRecord.headers());
//        log.info("message topic -> {}", recordMetadata.topic());
//        log.info("message offset -> {}", recordMetadata.offset());
    }

    @Override
    public void onError(ProducerRecord producerRecord, RecordMetadata recordMetadata,
        Exception exception) {
        ProducerListener.super.onError(producerRecord, recordMetadata, exception);
        log.info("message body -> {}", producerRecord.value());
        log.info("message header -> {}", producerRecord.headers());
        log.info("message topic -> {}", recordMetadata.topic());
        log.info("message offset -> {}", recordMetadata.offset());
        log.error("message exception -> {}", exception);
    }
}