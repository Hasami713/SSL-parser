package ru.selfservicelaundry.parser.api;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.selfservicelaundry.parser.model.Laundry;
import ru.selfservicelaundry.parser.service.LaundriesService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/laundries")
public class LaundriesApi {

    private final LaundriesService laundriesService;

    @GetMapping
    public List<Laundry> getLaundries() {
        return laundriesService.getAll();
    }
}
