package ru.selfservicelaundry.parser.service.impl;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.selfservicelaundry.parser.model.Laundry;
import ru.selfservicelaundry.parser.service.loader.DocumentLoaderService;
import ru.selfservicelaundry.parser.service.parser.LaundriesParserService;

@Service
@RequiredArgsConstructor
public class LaundriesParserServiceImpl implements LaundriesParserService {

    private final DocumentLoaderService documentLoaderService;

    @Cacheable(value = "laundries_cache")
    public List<Laundry> loadAll() {

        var laundries = new ArrayList<Laundry>();

        var document = documentLoaderService.loadLaundriesPage();
        var links = document.select("a");

        for (var link : links) {
            var href = link.attr("href");
            var address = link.text();

            if (href.contains("/device")) {
                var laundryId = href.substring(href.indexOf('/', 1) + 1);
                laundries.add(new Laundry(laundryId, address, null));
            }







        }

        return laundries;
    }
}
