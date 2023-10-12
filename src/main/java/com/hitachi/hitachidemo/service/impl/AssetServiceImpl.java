package com.hitachi.hitachidemo.service.impl;

import com.hitachi.hitachidemo.dto.AssetDTO;
import com.hitachi.hitachidemo.entity.Asset;
import com.hitachi.hitachidemo.exception.ResourceNotFoundException;
import com.hitachi.hitachidemo.mapper.AssetMapper;
import com.hitachi.hitachidemo.repository.AssetRepository;
import com.hitachi.hitachidemo.service.AssetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AssetServiceImpl implements AssetService {

    AssetRepository assetRepository;

    @Override
    public AssetDTO createAsset(AssetDTO assetDTO) {
        Asset savedAsset = assetRepository.save(AssetMapper.mapToAsset(assetDTO));
        return AssetMapper.mapToAssetDto(savedAsset);
    }

    @Override
    public AssetDTO getAssetById(Long assetId) {
        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Asset with the given id " + assetId + "doesn't exists!"));

        return AssetMapper.mapToAssetDto(asset);
    }

    @Override
    public List<AssetDTO> getAllAssets() {
        List<Asset> assets = assetRepository.findAll();
        return assets.stream()
                .map(AssetMapper::mapToAssetDto)
                .collect(Collectors.toList());
    }

    @Override
    public AssetDTO updateAsset(Long assetId, AssetDTO updateAsset) {
        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Asset with the given id " + assetId + "doesn't exists!"));

        asset.setName(updateAsset.getName());
        asset.setQuantity(updateAsset.getQuantity());

        Asset updatedAsset = assetRepository.save(asset);
        return AssetMapper.mapToAssetDto(updatedAsset);
    }

    @Override
    public void deleteAsset(Long assetId) {
        assetRepository.findById(assetId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Asset with the given id " + assetId + "doesn't exists!"));

        assetRepository.deleteById(assetId);
    }
}
