package com.hitachi.hitachidemo.repository;

import com.hitachi.hitachidemo.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}
