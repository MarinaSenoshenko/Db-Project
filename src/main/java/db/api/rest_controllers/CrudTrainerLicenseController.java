package db.api.rest_controllers;

import db.api.service.TrainerLicenseService;
import db.entities.TrainerLicense;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/trainerlicense")
public class CrudTrainerLicenseController {
    private final TrainerLicenseService trainerLicenseService;

    @PostMapping("")
    public TrainerLicense addTrainerLicense(@RequestParam("trainer") Long trainerId, @RequestParam("sport") String value,
                                            Authentication authentication) {
        if (authentication.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ADMIN"))) {
            return null;
        }
        return trainerLicenseService.addTrainerLicense(trainerId, value);
    }

    @DeleteMapping("")
    public TrainerLicense deleteTrainerLicense(@RequestParam("trainerlicense") Long trainerLicenseId,
                                               Authentication authentication) {
        if (authentication.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ADMIN"))) {
            return null;
        }
        return trainerLicenseService.deleteTrainerLicense(trainerLicenseId);
    }
}
