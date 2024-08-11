package ru.selfservicelaundry.parser.api;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.selfservicelaundry.parser.model.Laundry;
import ru.selfservicelaundry.parser.model.Slot;
import ru.selfservicelaundry.parser.service.LaundryService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/laundry")
public class LaundryApi {

    private final LaundryService laundryService;

    @GetMapping("{laundryId}")
    public Laundry getLaundry(@PathVariable String laundryId) {
        return laundryService.getLaundry(laundryId);
    }

    @GetMapping("{laundryId}/check")
    public boolean checkAvailable(@PathVariable String laundryId, @RequestParam String slotId) {
        return laundryService.checkAvailable(laundryId, slotId);
    }

    @GetMapping("{laundryId}/available")
    public List<Slot> getAvailable(@PathVariable String laundryId) {
        return laundryService.getAvailable(laundryId);
    }
}
