package com.hitachi.hitachidemo.controller;

import com.hitachi.hitachidemo.dto.AssetDTO;
import com.hitachi.hitachidemo.service.AssetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/asset")
@CrossOrigin(origins = "http://localhost:3000")
public class AssetController {

    AssetService assetService;

    // Create Asset API
    @PostMapping
    public ResponseEntity<AssetDTO> createEmployee(@RequestBody AssetDTO assetDTO) {
        AssetDTO savedAsset = assetService.createAsset(assetDTO);
        return new ResponseEntity<>(savedAsset, HttpStatus.CREATED);
    }

    // Get Asset API
    @GetMapping("{id}")
    public ResponseEntity<AssetDTO> getEmployee(@PathVariable("id") Long assetId) {
        AssetDTO assetDTO = assetService.getAssetById(assetId);
        return ResponseEntity.ok(assetDTO);
    }

    // Get all Assets API
    @GetMapping
    public ResponseEntity<List<AssetDTO>> getAllEmployees() {
        List<AssetDTO> assets = assetService.getAllAssets();
        return ResponseEntity.ok(assets);
    }

    // Update Asset API
    @PutMapping("{id}")
    public ResponseEntity<AssetDTO> updateEmployee(@PathVariable("id") Long assetId,
                                                      @RequestBody AssetDTO updateAsset) {
        AssetDTO updatedAsset = assetService.updateAsset(assetId, updateAsset);
        return ResponseEntity.ok(updatedAsset);
    }

    // Delete Asset API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long assetId) {
        assetService.deleteAsset(assetId);
        return ResponseEntity.ok("Asset with id " + assetId + " deleted successfully.");
    }
}
