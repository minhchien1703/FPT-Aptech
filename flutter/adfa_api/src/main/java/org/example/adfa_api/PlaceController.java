package org.example.adfa_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlaceController {

    @GetMapping("/getAllPlace")
    public List<Place> getAllPlace() {
        return Arrays.asList(
                new Place(1L, "Hoi An", 4.0, "https://example.com/hoian.jpg"),
                new Place(2L, "Sai Gon", 4.5, "https://example.com/saigon.jpg")
        );
    }
}