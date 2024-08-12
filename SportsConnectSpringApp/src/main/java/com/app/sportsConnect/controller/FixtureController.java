package com.app.sportsConnect.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.sportsConnect.entity.BasketballFixture;
import com.app.sportsConnect.entity.CricketFixture;
import com.app.sportsConnect.entity.FootballFixture;
import com.app.sportsConnect.entity.VolleyballFixture;
import com.app.sportsConnect.exceptions.ResourceNotFoundException;
import com.app.sportsConnect.service.FixtureService;

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
    @PostMapping("/basketball")
    public ResponseEntity<BasketballFixture> createBasketballFixture(@RequestBody BasketballFixture fixture) {
        BasketballFixture savedFixture = fixtureService.saveBasketballFixture(fixture);
        return ResponseEntity.ok(savedFixture);
    }

    // Get all basketball fixtures
    @GetMapping("/basketball")
    public ResponseEntity<List<BasketballFixture>> getAllBasketballFixtures() {
        List<BasketballFixture> fixtures = fixtureService.getAllBasketballFixtures();
        return ResponseEntity.ok(fixtures);
    }

    // Update a specific basketball fixture
    @PatchMapping("/basketball/{matchId}")
    public ResponseEntity<BasketballFixture> updateBasketballFixture(@PathVariable Long matchId, @RequestBody Map<String, Object> updatedFixture) throws ResourceNotFoundException {
        BasketballFixture fixture = fixtureService.updateBasketballFixture(matchId, updatedFixture);
        return fixture != null ? ResponseEntity.ok(fixture) : ResponseEntity.notFound().build();
    }

}
