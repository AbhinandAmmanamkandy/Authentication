package com.ghostreborn.authentication.repository;

import com.ghostreborn.authentication.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}
