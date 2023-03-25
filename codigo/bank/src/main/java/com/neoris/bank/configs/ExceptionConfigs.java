package com.neoris.bank.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "control")
public class ExceptionConfigs {

    private Map<String, String> exception;

    public static final String PERZONALIZADA = "personalizada";

    public static final String SYSTEMA =  "systema";

    public String getTiposExcepciones(final String tipoExcep) {
        return exception.get(tipoExcep);
    }

}
