package com.neoris.bank.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "msmail")
public class MsEmailConfig {

    private Map<String, String> message;

    public static final String WELCOME = "welcome";

    public static final String WITHDRAWAL =  "withdrawal";

    public static final String UPDATE =  "update";

    public static final String DEPOSIT =  "deposit";

    public static final String DELETION =  "deletion";


    public String getMessageType(final String type) {
        return message.get(type);
    }

}
