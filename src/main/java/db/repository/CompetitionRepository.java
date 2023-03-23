package db.repository;

import db.entities.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    @Query(name = "getCompetitionByPeriod", nativeQuery = true)
    List<Competition> getCompetitionByPeriod(Date startDate, Date endDate);
    @Query(name = "getCompetitionByFacility", nativeQuery = true)
    List<Competition> getCompetitionByFacility(Long sportsFacilityId);
}
