package com.neoris.bank.prodicer;

import com.neoris.bank.dto.jms.email.JmsEmailDetails;

public interface IEmailProduce {

    void sendGenerateTransaction(
            String message
    );

    void GenerateTransactionEmail(JmsEmailDetails jmsEmailDetails);
}
