package db.api.rest_controllers;

import db.api.service.CompetitionPlayerService;
import db.entities.CompetitionPlayer;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/competitionplayer")
public class CrudCompetitionPlayerController {
    private final CompetitionPlayerService competitionPlayerService;

    @PostMapping("")
    public CompetitionPlayer addCompetitionPlayer(@RequestParam("athlete") Long athleteId,
                                                  @RequestParam("competition") Long competitionId,
                                                  @RequestParam("wasawarding") boolean wasawarding,
                                                  @RequestParam("result") Long result, Authentication authentication) {
        if (authentication.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ADMIN"))) {
            throw new AccessDeniedException("Access denied");
        }
        return competitionPlayerService.addCompetitionPlayer(athleteId, competitionId, wasawarding, result);
    }

    @PutMapping("")
    public CompetitionPlayer updateCompetitionPlayer(@RequestParam("athlete") Long athleteId,
                                                  @RequestParam("competition") Long competitionId,
                                                  @RequestParam("wasawarding") boolean wasawarding,
                                                  @RequestParam("result") Long result, Authentication authentication) {
        if (authentication.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ADMIN"))) {
            throw new AccessDeniedException("Access denied");
        }
        return competitionPlayerService.updateCompetitionPlayer(athleteId, competitionId, wasawarding, result);
    }

    @DeleteMapping("")
    public CompetitionPlayer deleteCompetitionPlayer(@RequestParam("athlete") Long athleteId,
                                                     @RequestParam("competition") Long competitionId, Authentication authentication) {
        if (authentication.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ADMIN"))) {
            throw new AccessDeniedException("Access denied");
        }
        return competitionPlayerService.deleteCompetitionPlayer(athleteId, competitionId);
    }
}
