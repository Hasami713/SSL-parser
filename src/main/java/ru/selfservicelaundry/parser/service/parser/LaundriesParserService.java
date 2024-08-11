package ru.selfservicelaundry.parser.service.parser;

import java.util.List;
import ru.selfservicelaundry.parser.model.Laundry;

public interface LaundriesParserService {
    List<Laundry> loadAll();
}
