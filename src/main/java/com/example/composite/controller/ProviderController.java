package com.example.composite.controller;

import com.example.composite.model.Provider;
import com.example.composite.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/providers")
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderRepository providerRepository;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Provider saveProvider(@RequestBody Provider provider){
        return providerRepository.save(provider);
    }
}
