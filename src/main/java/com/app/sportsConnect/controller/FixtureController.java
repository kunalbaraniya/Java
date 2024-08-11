package com.app.sportsConnect.controller;

import com.app.sportsConnect.entity.CricketFixture;
import com.app.sportsConnect.entity.FootballFixture;
import com.app.sportsConnect.entity.VolleyballFixture;
import com.app.sportsConnect.exceptions.ResourceNotFoundException;
import com.app.sportsConnect.service.FixtureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fixtures")
public class FixtureController {

    @Autowired
    private FixtureService fixtureService;

    // Create a new cricket fixture
    @PostMapping("/cricket")
    public ResponseEntity<CricketFixture> createCricketFixture(@RequestBody CricketFixture fixture) {
        CricketFixture savedFixture = fixtureService.saveCricketFixture(fixture);
        return ResponseEntity.ok(savedFixture);
    }

    // Get all cricket fixtures
    @GetMapping("/cricket")
    public ResponseEntity<List<CricketFixture>> getAllCricketFixtures() {
        List<CricketFixture> fixtures = fixtureService.getAllCricketFixtures();
        return ResponseEntity.ok(fixtures);
    }

    // Update a specific cricket fixture
    @PatchMapping("/cricket/{matchId}")
    public ResponseEntity<CricketFixture> updateCricketFixture(@PathVariable Long matchId, @RequestBody Map<String, Object> updatedFixture) throws ResourceNotFoundException {
        CricketFixture fixture = fixtureService.updateCricketFixture(matchId, updatedFixture);
        return fixture != null ? ResponseEntity.ok(fixture) : ResponseEntity.notFound().build();
    }

    // Create a new football fixture
    @PostMapping("/football")
    public ResponseEntity<FootballFixture> createFootballFixture(@RequestBody FootballFixture fixture) {
        FootballFixture savedFixture = fixtureService.saveFootballFixture(fixture);
        return ResponseEntity.ok(savedFixture);
    }

    // Get all football fixtures
    @GetMapping("/football")
    public ResponseEntity<List<FootballFixture>> getAllFootballFixtures() {
        List<FootballFixture> fixtures = fixtureService.getAllFootballFixtures();
        return ResponseEntity.ok(fixtures);
    }

    // Update a specific football fixture
    @PutMapping("/football/{matchId}")
    public ResponseEntity<FootballFixture> updateFootballFixture(@PathVariable Long matchId, @RequestBody FootballFixture updatedFixture) {
        FootballFixture fixture = fixtureService.updateFootballFixture(matchId, updatedFixture);
        return fixture != null ? ResponseEntity.ok(fixture) : ResponseEntity.notFound().build();
    }

    // Create a new volleyball fixture
    @PostMapping("/volleyball")
    public ResponseEntity<VolleyballFixture> createVolleyballFixture(@RequestBody VolleyballFixture fixture) {
        VolleyballFixture savedFixture = fixtureService.saveVolleyballFixture(fixture);
        return ResponseEntity.ok(savedFixture);
    }

    // Get all volleyball fixtures
    @GetMapping("/volleyball")
    public ResponseEntity<List<VolleyballFixture>> getAllVolleyballFixtures() {
        List<VolleyballFixture> fixtures = fixtureService.getAllVolleyballFixtures();
        return ResponseEntity.ok(fixtures);
    }

    // Update a specific volleyball fixture
    @PatchMapping("/volleyball/{matchId}")
    public ResponseEntity<VolleyballFixture> updateVolleyballFixture(@PathVariable Long matchId, @RequestBody Map<String, Object> updatedFixture) throws ResourceNotFoundException {
        VolleyballFixture fixture = fixtureService.updateVolleyballFixture(matchId, updatedFixture);
        return fixture != null ? ResponseEntity.ok(fixture) : ResponseEntity.notFound().build();
    }
}
