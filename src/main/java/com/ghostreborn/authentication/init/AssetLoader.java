package com.ghostreborn.authentication.init;

import com.ghostreborn.authentication.model.Asset;
import com.ghostreborn.authentication.repository.AssetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssetLoader {

    @Bean
    CommandLineRunner loadAssets(AssetRepository assetRepository) {
        return args -> {
            assetRepository.save(new Asset(1L, "Asset 1"));
            assetRepository.save(new Asset(2L, "Asset 2"));
            assetRepository.save(new Asset(3L, "Asset 3"));
        };
    }

}
