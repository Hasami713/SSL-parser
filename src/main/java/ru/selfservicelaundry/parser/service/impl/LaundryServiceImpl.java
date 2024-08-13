package ru.selfservicelaundry.parser.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.selfservicelaundry.parser.model.AvailableSlots;
import ru.selfservicelaundry.parser.model.Laundry;
import ru.selfservicelaundry.parser.model.Slot;

import ru.selfservicelaundry.parser.service.parser.LaundryParserService;
import ru.selfservicelaundry.parser.service.LaundryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaundryServiceImpl implements LaundryService {

    private final LaundryParserService laundryParserService;

    @Override
    public List<Slot> getAvailable(String laundryId) {
        return getLaundry(laundryId)
                .getSlots()
                .stream()
                .filter(Slot::available)
                .toList();
    }

    @Override
    public boolean checkAvailable(String laundryId, String slotId) {
        return getLaundry(laundryId)
                .getSlots()
                .stream()
                .filter(slot -> slot.slotId().equals(slotId))
                .anyMatch(Slot::available);
    }

    @Override
    public Laundry getLaundry(String laundryId) {
        return laundryParserService.load(laundryId);
    }
}
