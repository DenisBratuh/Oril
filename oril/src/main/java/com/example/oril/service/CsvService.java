package com.example.oril.service;

import com.example.oril.domain.model.Cryptocurrency;
import com.opencsv.CSVWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CsvService {

    private final CryptocurrencyTransactionService currencyPairHistoryService;

    public void createCsvReport() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileWriter fw = new FileWriter("CSVReport.csv");
             CSVWriter writer = new CSVWriter(fw)) {
            for (Cryptocurrency elem : Cryptocurrency.values()) {
                stringBuilder.append("Cryptocurrency Name: " + elem.name() + ", ");
                stringBuilder.append("Max price: ");
                stringBuilder.append(currencyPairHistoryService.max(elem.name()).getPrice() + ", ");
                stringBuilder.append("Min price: ");
                stringBuilder.append(currencyPairHistoryService.min(elem.name()).getPrice() + ", ");
            }
            writer.writeNext(stringBuilder.toString().split(","));
        } catch (IOException exception) {
            exception.printStackTrace();
        }


    }
}
