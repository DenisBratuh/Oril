package com.example.oril.domain.mapper;

import com.example.oril.domain.model.CryptocurrencyTransaction;
import com.example.oril.domain.dto.CryptocurrencyTransactionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CryptocurrencyTransactionMapper {

    CryptocurrencyTransactionMapper INSTANCE = Mappers.getMapper(CryptocurrencyTransactionMapper.class);
    CryptocurrencyTransactionDto entityToDto(CryptocurrencyTransaction cryptocurrencyTransaction);

}
