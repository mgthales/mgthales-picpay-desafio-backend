package br.com.thalesmonteiro.picpay_desafio_backend.notification;

import br.com.thalesmonteiro.picpay_desafio_backend.authorization.AuthorizerService;
import br.com.thalesmonteiro.picpay_desafio_backend.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class NotificationConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizerService.class);


    private RestClient restClient;

    public NotificationConsumer(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://util.devi.tools/api/v1/notify").build();
    }
    @KafkaListener(topics = "transaction-notification", groupId = "picpay-desafio-backend")
    public void receiveNotification(Transaction transaction){
        LOGGER.info("notifying transaction {}...",transaction);
        var response = restClient.get()
                .retrieve()
                .toEntity(Notification.class);

        if (response.getStatusCode().isError() || response.getBody().status().equals("fail")){
            throw new NotificationException("Error sending notification!");
        }
        LOGGER.info("notifying has been sent {}...",response.getBody());
    }
}
