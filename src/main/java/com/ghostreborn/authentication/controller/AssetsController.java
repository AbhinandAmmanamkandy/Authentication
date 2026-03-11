package com.ghostreborn.authentication.controller;

import com.ghostreborn.authentication.model.Asset;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetsController {

    ArrayList<Asset> testAssets = new ArrayList<>(
            List.of(
                    new Asset(1L, "Asset 1"),
                    new Asset(2L, "Asset 2"),
                    new Asset(3L, "Asset 3")
            )
    );

    @GetMapping
    public List<Asset> getAll() {
        return testAssets;
    }

}
