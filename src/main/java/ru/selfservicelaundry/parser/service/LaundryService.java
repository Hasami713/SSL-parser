package ru.selfservicelaundry.parser.service;

import java.util.List;

import ru.selfservicelaundry.parser.model.AvailableSlots;
import ru.selfservicelaundry.parser.model.Laundry;
import ru.selfservicelaundry.parser.model.Slot;

public interface LaundryService {
    boolean checkAvailable(String laundryId, String slotId);
    List<Slot> getAvailable(String laundryId);
    Laundry getLaundry(String laundryId);
}
