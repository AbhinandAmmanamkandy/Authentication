package com.ghostreborn.authentication.controller;

import com.ghostreborn.authentication.model.Asset;
import com.ghostreborn.authentication.repository.AssetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/assets")
public class AssetsController {

    private final AssetRepository assetRepository;

    public AssetsController(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @GetMapping
    @ResponseBody
    public List<Asset> getAll() {
        return assetRepository.findByDeletedFalse();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Asset getAssetById(@PathVariable Long id) {
        return assetRepository.findById(id)
                .orElse(new Asset());
    }

    @PostMapping
    public String createAsset(Asset asset) {
        assetRepository.save(asset);
        return "redirect:/dashboard";
    }

    @PatchMapping("/{id}")
    @ResponseBody
    public Asset updateAsset(@PathVariable Long id, @RequestBody Asset updatedAsset) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        if (updatedAsset.getName() != null)
            asset.setName(updatedAsset.getName());

        return assetRepository.save(asset);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteAsset(@PathVariable Long id) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        asset.setDeleted(true);

        assetRepository.save(asset);

        return "deleted";
    }

}
