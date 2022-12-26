package com.example.oril.service;

import com.example.oril.domain.model.Cryptocurrency;
import com.example.oril.domain.model.CryptocurrencyTransaction;
import com.example.oril.repository.CryptocurrencyTransactionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class CexIoService {

    private final String Url = "https://cex.io/api/trade_history";
    private final CryptocurrencyTransactionRepository repository;

    @SneakyThrows
    public void getTradeHistory() {
        RestTemplate restTemplate = new RestTemplate();
        for (Cryptocurrency elem : Cryptocurrency.values()) {
            String currencyPairHistory = restTemplate
                    .getForObject(Url + elem.getUrl(), String.class);
            CryptocurrencyTransaction[] test = new ObjectMapper().readValue(currencyPairHistory, CryptocurrencyTransaction[].class);
            Arrays.stream(test)
                    .peek(s -> s.setCurrencyName(elem.name()))
                    .forEach(repository::save);
        }
    }
}
