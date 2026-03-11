package com.ghostreborn.authentication.controller;

import com.ghostreborn.authentication.model.Asset;
import com.ghostreborn.authentication.repository.AssetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final AssetRepository assetRepository;

    public DashboardController(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @GetMapping
    public String dashboard(Model model) {
        List<Asset> assets = assetRepository.findAll();
        model.addAttribute("assets", assets);
        return "dashboard";
    }

    @GetMapping("/create")
    public String createAsset() {
        return "create_asset";
    }

    @GetMapping("/view/{id}")
    public Asset viewAsset(
            @PathVariable Long id
    ) {
        return assetRepository.findById(id).orElse(new Asset());
    }

}
