package com.app.sportsConnect.service;

import com.app.sportsConnect.entity.CricketFixture;
import com.app.sportsConnect.entity.FootballFixture;
import com.app.sportsConnect.entity.VolleyballFixture;
import com.app.sportsConnect.exceptions.ResourceNotFoundException;
import com.app.sportsConnect.repository.CricketFixtureRepository;
import com.app.sportsConnect.repository.FootballFixtureRepository;
import com.app.sportsConnect.repository.VolleyballFixtureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class FixtureService {

    @Autowired
    private CricketFixtureRepository cricketFixtureRepository;

    @Autowired
    private FootballFixtureRepository footballFixtureRepository;

    @Autowired
    private VolleyballFixtureRepository volleyballFixtureRepository;

    //Cricket Services
    public CricketFixture saveCricketFixture(CricketFixture fixture) {
        return cricketFixtureRepository.save(fixture);
    }

    public List<CricketFixture> getAllCricketFixtures() {
        return cricketFixtureRepository.findAll();
    }

    public CricketFixture updateCricketFixture(Long matchId, Map<String, Object> updatedFixture) throws ResourceNotFoundException {
        CricketFixture existingFixture = cricketFixtureRepository.findById(matchId).orElseThrow(()-> new ResourceNotFoundException("Fixture Not Found"));

        updatedFixture.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(CricketFixture.class, key);
            assert field != null;
            field.setAccessible(true);
            ReflectionUtils.setField(field, existingFixture, value);
        });

        return cricketFixtureRepository.save(existingFixture);
    }

    //Football Services
    public FootballFixture saveFootballFixture(FootballFixture fixture) {
        return footballFixtureRepository.save(fixture);
    }

    public List<FootballFixture> getAllFootballFixtures() {
        return footballFixtureRepository.findAll();
    }

    public FootballFixture updateFootballFixture(Long matchId, FootballFixture updatedFixture) {
        if (footballFixtureRepository.existsById(matchId)) {
            updatedFixture.setMatchId(matchId);
            return footballFixtureRepository.save(updatedFixture);
        }
        return null;
    }

    //Volleyball Services
    public VolleyballFixture saveVolleyballFixture (VolleyballFixture fixture) {
        return volleyballFixtureRepository.save(fixture);
    }

    public List<VolleyballFixture> getAllVolleyballFixtures() {
        return volleyballFixtureRepository.findAll();
    }

    public VolleyballFixture updateVolleyballFixture(Long matchId, Map<String, Object> updatedFixture) throws ResourceNotFoundException {
        VolleyballFixture existingFixture = volleyballFixtureRepository.findById(matchId).orElseThrow(()-> new ResourceNotFoundException("Fixture Not Found"));

        updatedFixture.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(VolleyballFixture.class, key);
            assert field != null;
            field.setAccessible(true);
            ReflectionUtils.setField(field, existingFixture, value);
        });

        return volleyballFixtureRepository.save(existingFixture);
    }
}

