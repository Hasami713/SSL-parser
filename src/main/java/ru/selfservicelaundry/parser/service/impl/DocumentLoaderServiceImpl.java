package ru.selfservicelaundry.parser.service.impl;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import ru.selfservicelaundry.parser.service.loader.DocumentLoaderService;

@Service
public class DocumentLoaderServiceImpl implements DocumentLoaderService {

    private final static String LAUNDRIES_URL = "https://washer.mylaundry.ru/";
    private final static String LAUNDRY_URL = "https://washer.mylaundry.ru/device/%s";

    @SneakyThrows
    public Document loadLaundryPage(String laundryId) {
        return Jsoup.connect(String.format(LAUNDRY_URL, laundryId)).get();
    }

    @SneakyThrows
    public Document loadLaundriesPage() {
        return Jsoup.connect(LAUNDRIES_URL).get();
    }
}
