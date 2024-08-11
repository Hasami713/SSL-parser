package ru.selfservicelaundry.parser.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Laundry {

    private String laundryId;
    private String address;
    private List<Slot> slots;

    public Laundry(String laundryId, String address) {
        this.laundryId = laundryId;
        this.address = address;
    }

    public Laundry(String laundryId, List<Slot> slots) {
        this.laundryId = laundryId;
        this.slots = slots;
    }
}
