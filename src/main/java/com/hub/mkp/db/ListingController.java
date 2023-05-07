/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hub.mkp.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Classe che gestisce le richieste HTTP relative agli annunci di vendita.
 *
 * @author 588se
 */
@RestController
@RequestMapping("/listings")
public class ListingController {

    @Autowired
    private ListingRepository listingRepository;

    /**
     * Restituisce tutti gli annunci.
     */
    @GetMapping
    public List<Listing> getAllListings() {
        return listingRepository.findAll();
    }

    /**
     * Restituisce un annuncio specifico in base all'ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Listing> getListingById(@PathVariable String id) {
        Optional<Listing> optionalListing = listingRepository.findById(id);
        if (optionalListing.isPresent()) {
            return ResponseEntity.ok(optionalListing.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Crea un nuovo annuncio.
     */
    @PostMapping
    public Listing createListing(@RequestBody Listing listing) {
        return listingRepository.save(listing);
    }

    /**
     * Aggiorna un annuncio esistente in base all'ID.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Listing> updateListing(@PathVariable String id, @RequestBody Listing updatedListing) {
        Optional<Listing> optionalListing = listingRepository.findById(id);
        if (optionalListing.isPresent()) {
            Listing existingListing = optionalListing.get();
            existingListing.setTitle(updatedListing.getTitle());
            existingListing.setDescription(updatedListing.getDescription());
            existingListing.setPrice(updatedListing.getPrice());
            Listing savedListing = listingRepository.save(existingListing);
            return ResponseEntity.ok(savedListing);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Elimina un annuncio in base all'ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListing(@PathVariable String id) {
        Optional<Listing> optionalListing = listingRepository.findById(id);
        if (optionalListing.isPresent()) {
            listingRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
