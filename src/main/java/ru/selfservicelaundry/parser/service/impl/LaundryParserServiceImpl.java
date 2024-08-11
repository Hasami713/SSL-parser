package ru.selfservicelaundry.parser.service.impl;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.selfservicelaundry.parser.model.Laundry;
import ru.selfservicelaundry.parser.model.Slot;
import ru.selfservicelaundry.parser.service.loader.DocumentLoaderService;
import ru.selfservicelaundry.parser.service.parser.LaundryParserService;

@Service
@RequiredArgsConstructor
public class LaundryParserServiceImpl implements LaundryParserService {

    private final static String AVAILABLE_STATUS = "Свободно";

    private final DocumentLoaderService documentLoaderService;

    @Cacheable(value = "laundry_cache", key = "laundryId")
    public Laundry load(String laundryId) {

        var slots = new ArrayList<Slot>();

        var document = documentLoaderService.loadLaundryPage(laundryId);
        var elements = document.select(".machine");

        for (var element : elements) {

            var slotId = element.attr("data-num");
            var statusDescription = element.select(".status").text();
            boolean available = statusDescription.equals(AVAILABLE_STATUS);

            slots.add(new Slot(slotId, available));
        }

        return new Laundry(laundryId, slots);
    }
}
