package ru.selfservicelaundry.parser.service.parser;

import ru.selfservicelaundry.parser.model.Laundry;

public interface LaundryParserService {
    Laundry load(String laundryId);
}
