package com.ghostreborn.authentication.controller;

import com.ghostreborn.authentication.model.Asset;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetsController {

    ArrayList<Asset> testAssets = new ArrayList<>(
            List.of(
                    new Asset()
            )
    );

}
