package com.neoris.bank.prodicer.impl;

import com.neoris.bank.dto.jms.email.JmsEmailDetails;
import com.neoris.bank.prodicer.IEmailProduce;
import com.neoris.bank.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailProduceImpl implements IEmailProduce {

    @Value("${activemq.msemail.generate-transactions.queue}")
    private String generateTransactionsTopic;

    private final JmsTemplate jmsTemplate;

    public EmailProduceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendGenerateTransaction(String message) {
        try {
            log.trace(
                    "ActiveMQ outgoing message to queue {}: \n{}",
                    generateTransactionsTopic,
                    message
            );
            jmsTemplate.setPubSubDomain(false);

            jmsTemplate.convertAndSend(
                    generateTransactionsTopic,
                    message
            );
            log.trace(
                    "ActiveMQ outgoing message sent succesfully to topic {}",
                    generateTransactionsTopic
            );
        } catch (JmsException e) {
            log.error(
                    String.format(
                            "Error sending message to topic %s",
                            generateTransactionsTopic
                    ),
                    e
            );
        }
    }

    @Override
    public void GenerateTransactionEmail(JmsEmailDetails jmsEmailDetails) {
        try {

            final String messageBody = Utilities.convertToJson(jmsEmailDetails);

            log.trace(
                    "ActiveMQ outgoing message to queue {}: \n{}",
                    generateTransactionsTopic,
                    messageBody
            );
            jmsTemplate.setPubSubDomain(false);

            jmsTemplate.convertAndSend(
                    generateTransactionsTopic,
                    messageBody
            );
            log.trace(
                    "ActiveMQ outgoing message sent succesfully to topic {}",
                    generateTransactionsTopic
            );
        } catch (JmsException e) {
            log.error(
                    String.format(
                            "Error sending message to topic %s",
                            generateTransactionsTopic
                    ),
                    e
            );
        }
    }
}
