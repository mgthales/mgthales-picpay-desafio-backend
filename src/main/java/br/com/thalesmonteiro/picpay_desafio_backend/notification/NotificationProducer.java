package br.com.thalesmonteiro.picpay_desafio_backend.notification;

import br.com.thalesmonteiro.picpay_desafio_backend.transaction.Transaction;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {
    public final KafkaTemplate<String, Transaction> kafkaTemplate;

    public NotificationProducer(KafkaTemplate<String, Transaction> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendNotifiation(Transaction transaction){
        kafkaTemplate.send("transaction-notification", transaction);
    }
}
