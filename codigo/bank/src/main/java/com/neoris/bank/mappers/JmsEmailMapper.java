package com.neoris.bank.mappers;

import com.neoris.bank.dto.UserDTO;
import com.neoris.bank.dto.jms.email.JmsEmailDetails;

public class JmsEmailMapper {


    public static JmsEmailDetails getUsuarioDTOToEmail(String email, String name , String emailType,long amount){
        return JmsEmailDetails
                .builder()
                .recipient(email)
                .name(name)
                .emailType(emailType)
                .amount(amount)
                .build();
    }

}
