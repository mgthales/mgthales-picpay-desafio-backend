package br.com.thalesmonteiro.picpay_desafio_backend.notification;

import br.com.thalesmonteiro.picpay_desafio_backend.transaction.Transaction;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final NotificationProducer notificationProducer;

    public NotificationService(NotificationProducer notificationProducer) {
        this.notificationProducer = notificationProducer;
    }

    public void notify(Transaction transaction) {
        notificationProducer.sendNotifiation(transaction);
    }
}
