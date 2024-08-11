package ru.selfservicelaundry.parser.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.selfservicelaundry.parser.model.Laundry;
import ru.selfservicelaundry.parser.service.parser.LaundriesParserService;
import ru.selfservicelaundry.parser.service.LaundriesService;

@Service
@RequiredArgsConstructor
public class LaundriesServiceImpl implements LaundriesService {

    private final LaundriesParserService laundriesParserService;

    public List<Laundry> getAll() {
        return laundriesParserService.loadAll();
    }
}
