package com.example.oril.repository;

import com.example.oril.domain.model.CryptocurrencyTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface CryptocurrencyTransactionRepository extends MongoRepository<CryptocurrencyTransaction, String> {
    public Optional<CryptocurrencyTransaction> findFirstByCurrencyNameOrderByPriceAsc(@NonNull String name);

    public Optional<CryptocurrencyTransaction> findFirstByCurrencyNameOrderByPriceDesc(@NonNull String name);

    public Page<CryptocurrencyTransaction> findAllByCurrencyName(@NonNull String name, Pageable pageable);

}
