package db.api.service;

import db.entities.CourtSurface;
import db.entities.SportsFacilityType;
import db.entities.models.surface.*;
import db.repository.CourtSurfaceRepository;
import db.repository.SportsFacilityTypeRepository;
import db.repository.sports.ArenaRepository;
import db.repository.sports.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class SportsFacilityService {
    private final SportsFacilityRepository sportsFacilityRepository;
    private final ArenaRepository arenaRepository;
    private final CourtRepository courtRepository;
    private final GymRepository gymRepository;
    private final StadiumRepository stadiumRepository;
    private final CourtSurfaceRepository courtSurfaceRepository;
    private final SportsFacilityTypeRepository sportsFacilityTypeRepository;

    public SportsFacility addSportsFacility(String address, String value) {
        SportsFacilityType type = sportsFacilityTypeRepository.findByValue(value);
        SportsFacility sportsFacility = new SportsFacility(address, type);
        sportsFacilityRepository.save(sportsFacility);
        return sportsFacility;
    }

    public SportsFacility updateSportsFacility(Long id, String type, String address) {
        SportsFacility sportsFacility = sportsFacilityRepository.findById(id).orElseThrow();
        SportsFacilityType sportsFacilityType = sportsFacilityTypeRepository.findByValue(type);
        if (!Objects.equals(address, "")) {
            sportsFacility.setAddress(address);
        }
        sportsFacility.setType(sportsFacilityType);
        sportsFacilityRepository.save(sportsFacility);
        return sportsFacility;
    }

    public SportsFacility deleteSportsFacility(Long facilityId) {
        SportsFacility sportsFacility = sportsFacilityRepository.findById(facilityId).orElseThrow();
        sportsFacilityRepository.delete(sportsFacility);
        return sportsFacility;
    }

    public Arena addArenaParam(String param) {
        Long id = sportsFacilityRepository.getMaxFacilityId(param);
        SportsFacility sportsFacility = sportsFacilityRepository.findById(id).orElseThrow();
        Arena arena = new Arena(param, sportsFacility);
        arenaRepository.save(arena);
        return arena;
    }

    public Arena updateArenaParam(Long id, String param) {
        Arena arena = arenaRepository.findById(id).orElseThrow();
        arena.setTrackNumber(Long.valueOf(param));
        arenaRepository.save(arena);
        return arena;
    }

    public Arena deleteArenaParam(Long arenaId) {
        Arena arena = arenaRepository.findById(arenaId).orElseThrow();
        arenaRepository.delete(arena);
        return arena;
    }

    public Court addCourtParam(String param) {
        Long id = sportsFacilityRepository.getMaxFacilityId(param);
        SportsFacility sportsFacility = sportsFacilityRepository.findById(id).orElseThrow();
        CourtSurface surface = courtSurfaceRepository.findByValue(param);
        Court court = new Court(surface, sportsFacility);
        courtRepository.save(court);
        return court;
    }

    public Court updateCourtParam(Long id, String param) {
        Court court = courtRepository.findById(id).orElseThrow();
        CourtSurface surface = courtSurfaceRepository.findByValue(param);
        court.setSurface(surface);
        courtRepository.save(court);
        return court;
    }

    public Court deleteCourtParam(Long courtId) {
        Court court = courtRepository.findById(courtId).orElseThrow();
        courtRepository.delete(court);
        return court;
    }

    public Gym addGymParam(String param) {
        Long id = sportsFacilityRepository.getMaxFacilityId(param);
        SportsFacility sportsFacility = sportsFacilityRepository.findById(id).orElseThrow();
        Gym gym = new Gym(param, sportsFacility);
        gymRepository.save(gym);
        return gym;
    }

    public Gym updateGymParam(Long id, String param) {
        Gym gym = gymRepository.findById(id).orElseThrow();
        gym.setFloorArea(Double.valueOf(param));
        gymRepository.save(gym);
        return gym;
    }

    public Gym deleteGymParam(Long gymId) {
        Gym gym = gymRepository.findById(gymId).orElseThrow();
        gymRepository.delete(gym);
        return gym;
    }

    public Stadium addStadiumParam(String param) {
        Long id = sportsFacilityRepository.getMaxFacilityId(param);
        SportsFacility sportsFacility = sportsFacilityRepository.findById(id).orElseThrow();
        Stadium stadium = new Stadium(param, sportsFacility);
        stadiumRepository.save(stadium);
        return stadium;
    }

    public Stadium updateStadiumParam(Long id, String param) {
        Stadium stadium = stadiumRepository.findById(id).orElseThrow();
        stadium.setCapacity(Long.valueOf(param));
        stadiumRepository.save(stadium);
        return stadium;
    }

    public Stadium deleteStadiumParam(Long stadiumId) {
        Stadium stadium = stadiumRepository.findById(stadiumId).orElseThrow();
        stadiumRepository.delete(stadium);
        return stadium;
    }
}
