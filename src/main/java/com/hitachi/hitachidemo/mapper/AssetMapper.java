package com.hitachi.hitachidemo.mapper;

import com.hitachi.hitachidemo.dto.AssetDTO;
import com.hitachi.hitachidemo.entity.Asset;

public class AssetMapper {

    public static AssetDTO mapToAssetDto(Asset asset) {
        return new AssetDTO(
                asset.getId(),
                asset.getName(),
                asset.getQuantity()
        );
    }

    public static Asset mapToAsset(AssetDTO assetDTO) {
        return new Asset(
                assetDTO.getId(),
                assetDTO.getName(),
                assetDTO.getQuantity()
        );
    }
}
