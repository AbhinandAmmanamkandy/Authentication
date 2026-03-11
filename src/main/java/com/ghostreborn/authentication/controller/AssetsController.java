package com.ghostreborn.authentication.controller;

import com.ghostreborn.authentication.model.Asset;
import com.ghostreborn.authentication.repository.AssetRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetsController {

    private final AssetRepository assetRepository;

    public AssetsController(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @GetMapping
    public List<Asset> getAll() {
        return assetRepository.findAll();
    }

}
