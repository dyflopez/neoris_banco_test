package com.neoris.bank.mappers;

import com.neoris.bank.constants.Constantes;
import com.neoris.bank.dto.SearchUserDateDTO;
import com.neoris.bank.utils.Utilities;

public class SearchTransactionsMapper {

    public SearchTransactionsMapper(){}

    public static SearchUserDateDTO getTransactionDatesMapper(String identification,
                                                            String startDate,
                                                            String endDate){
        return SearchUserDateDTO
                .builder()
                .identification(identification)
                .startDate(Utilities.stringToLocalDateTime(startDate, Constantes.FORMATO_YYYY_MM_DD_HH_MM_SS))
                .endDate(Utilities.stringToLocalDateTime(endDate, Constantes.FORMATO_YYYY_MM_DD_HH_MM_SS))
                .build();
    }
}
