package com.hitachi.hitachidemo.service;

import com.hitachi.hitachidemo.dto.AssetDTO;

import java.util.List;

public interface AssetService {

    AssetDTO createAsset(AssetDTO assetDTO);

    AssetDTO getAssetById(Long assetId);

    List<AssetDTO> getAllAssets();

    AssetDTO updateAsset(Long assetId, AssetDTO assetDTO);

    void deleteAsset(Long assetId);
}
