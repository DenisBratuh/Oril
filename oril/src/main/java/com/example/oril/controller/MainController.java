package com.example.oril.controller;

import com.example.oril.domain.dto.CryptocurrencyTransactionDto;
import com.example.oril.service.CexIoService;
import com.example.oril.service.CryptocurrencyTransactionService;
import com.example.oril.service.CsvService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/cryptocurrencies")
@RequiredArgsConstructor
public class MainController {

    private final CryptocurrencyTransactionService ser;

    private final CexIoService cexIoService;

    private final CsvService csvService;

    @GetMapping("/update")
    public void addCurrency() {
        cexIoService.getTradeHistory();
    }

    @GetMapping("/minprice")
    public CryptocurrencyTransactionDto minPrice(@RequestParam String name) {
        return ser.min(name);
    }

    @GetMapping("/maxprice")
    public CryptocurrencyTransactionDto maxPrice(@RequestParam String name) {
        return ser.max(name);
    }

    @GetMapping
    public Page<CryptocurrencyTransactionDto> pageOfCurrency(@RequestParam String name,
                                                             @PageableDefault(sort = {"price"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return ser.pageOfCurrency(name, pageable);
    }

    @GetMapping("/csv")
    public void createCsvReport() {
        csvService.createCsvReport();
    }

}
