package db.api.service;

import db.entities.Competition;
import db.entities.Sponsor;
import db.entities.Sport;
import db.entities.models.surface.SportsFacility;
import db.repository.CompetitionRepository;
import db.repository.SponsorRepository;
import db.repository.SportRepository;
import db.repository.sports.SportsFacilityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CompetitionService {
    private final CompetitionRepository competitionRepository;
    private final SportRepository sportRepository;
    private final SportsFacilityRepository sportsFacilityRepository;
    private final SponsorRepository sponsorRepository;

    public Competition addCompetition(String title, String period, Long sponsorId, Long sportId, Long sportsfacilityId) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Sponsor sponsor = sponsorRepository.findById(sponsorId).orElseThrow();
        Sport sport = sportRepository.findById(sportId).orElseThrow();
        SportsFacility sportsFacility = sportsFacilityRepository.findById(sportsfacilityId).orElseThrow();

        Competition competition = new Competition(title, dateFormat.parse(period), sponsor, sport, sportsFacility);
        competitionRepository.save(competition);
        return competition;
    }

    public Competition deleteCompetition(Long competitionId) {
        Competition competition = competitionRepository.findById(competitionId).orElseThrow();
        competitionRepository.delete(competition);
        return competition;
    }

    public Competition updateCompetition(Long id, String title, String period, Long sponsorId, Long sportId, Long sportsfacilityId) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Sponsor sponsor = sponsorRepository.findById(sponsorId).orElseThrow();
        Sport sport = sportRepository.findById(sportId).orElseThrow();
        SportsFacility sportsFacility = sportsFacilityRepository.findById(sportsfacilityId).orElseThrow();

        Competition competition = competitionRepository.findById(id).orElseThrow();
        if (!Objects.equals(title, "")) {
            competition.setTitle(title);
        }
        if (!Objects.equals(period, "")) {
            competition.setPeriod(dateFormat.parse(period));
        }
        competition.setSponsor(sponsor);
        competition.setSport(sport);
        competition.setSportsFacility(sportsFacility);

        competitionRepository.save(competition);
        return competition;
    }
}
