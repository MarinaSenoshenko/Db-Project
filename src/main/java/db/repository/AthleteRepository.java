package db.repository;

import db.entities.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    @Query(name = "getAthletesByRanking", nativeQuery = true)
    Iterable<Athlete> getAthletesByRanking(String sport, Long athleteRankId);
    @Query(name = "getAthletesByTrainerAndRank", nativeQuery = true)
    Iterable<Athlete> getAthletesByTrainerAndRank(Long trainerLicenseId, Long athleteRankId);
    @Query(name = "getAthletesWhoMoreThanOneSport", nativeQuery = true)
    Iterable<?> getAthletesWhoMoreThanOneSport();
    @Query(name = "getAthletesWhoWinnerByCompetition", nativeQuery = true)
    Iterable<Athlete> getAthletesWhoWinnerByCompetition(Long competitionId);
    @Query(name = "getAthletesWhoNotInCompetitionByPeriod", nativeQuery = true)
    Iterable<Athlete> getAthletesWhoNotInCompetitionByPeriod(Date startDate, Date endDate);
    @Query(name = "getNotUsedInOtherTablesAthletes", nativeQuery = true)
    Iterable<Long> getNotUsedInOtherTablesAthletes();
}
