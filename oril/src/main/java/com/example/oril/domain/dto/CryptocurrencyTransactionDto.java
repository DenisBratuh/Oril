package com.example.oril.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CryptocurrencyTransactionDto {

    private String id;

    private String currencyName;

    private Long date;

    private Double price;

}
