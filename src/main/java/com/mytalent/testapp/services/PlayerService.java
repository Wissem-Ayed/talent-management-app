package com.mytalent.testapp.services;

import com.mytalent.testapp.dtos.CreatePlayerRequest;
import com.mytalent.testapp.entities.Player;
import com.mytalent.testapp.repositories.PlayerRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found"));
    }

    public Player createPlayer(CreatePlayerRequest dto) {
        Player player = new Player();

        player.setFirstName(dto.getFirstName());
        player.setLastName(dto.getLastName());
        player.setEmail(dto.getEmail());
        player.setPhoneNumber(dto.getPhoneNumber());
        player.setDateOfBirth(dto.getDateOfBirth());
        player.setNationality(dto.getNationality());
        player.setAddressLine2(dto.getAddressLine2());
        player.setCity(dto.getCity());
        player.setState(dto.getState());
        player.setPrimaryPosition(dto.getPrimaryPosition());
        player.setSecondaryPosition(dto.getSecondaryPosition());
        player.setPreferredFoot(dto.getPreferredFoot());
        player.setHeightInCm(dto.getHeightInCm());
        player.setWeightInKg(dto.getWeightInKg());
        player.setProfilePhotoUrl(dto.getProfilePhotoUrl());
        player.setCertificateOfBirthUrl(dto.getCertificateOfBirthUrl());

        return playerRepository.save(player);
    }
}
