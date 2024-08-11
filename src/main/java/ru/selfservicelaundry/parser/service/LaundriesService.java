package ru.selfservicelaundry.parser.service;

import java.util.List;
import ru.selfservicelaundry.parser.model.Laundry;

public interface LaundriesService {
    List<Laundry> getAll();
}
