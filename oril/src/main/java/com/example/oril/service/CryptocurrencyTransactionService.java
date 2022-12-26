package com.example.oril.service;

import com.example.oril.domain.dto.CryptocurrencyTransactionDto;
import com.example.oril.domain.mapper.CryptocurrencyTransactionMapper;
import com.example.oril.repository.CryptocurrencyTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CryptocurrencyTransactionService {

    private final CryptocurrencyTransactionRepository repository;

    public CryptocurrencyTransactionDto min(String name) {
        return CryptocurrencyTransactionMapper.INSTANCE.entityToDto(repository
                .findFirstByCurrencyNameOrderByPriceAsc(name)
                .orElseThrow(() -> new RuntimeException("Invalid Cryptocurrency name")));
    }

    public CryptocurrencyTransactionDto max(String name) {
        return CryptocurrencyTransactionMapper.INSTANCE.entityToDto(repository
                .findFirstByCurrencyNameOrderByPriceDesc(name)
                .orElseThrow(() -> new RuntimeException("Invalid Cryptocurrency name")));
    }

    public Page<CryptocurrencyTransactionDto> pageOfCurrency(String name, Pageable pageable) {

        return repository.findAllByCurrencyName(name, pageable)
                .map(CryptocurrencyTransactionMapper.INSTANCE::entityToDto);
    }

}
