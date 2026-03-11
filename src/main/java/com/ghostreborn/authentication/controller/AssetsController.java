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
        return assetRepository.findAll();
    }

    @PostMapping
    public String createAsset(Asset asset) {
        assetRepository.save(asset);
        return "redirect:/dashboard";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteAsset(@PathVariable Long id) {
        assetRepository.deleteById(id);
        return "deleted";
    }

}
