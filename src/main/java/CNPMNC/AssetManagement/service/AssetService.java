package CNPMNC.AssetManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CNPMNC.AssetManagement.dto.AssetDTO;
import CNPMNC.AssetManagement.model.Asset;
import CNPMNC.AssetManagement.repository.AssetRepository;


@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<AssetDTO> getAll() {
        Iterable<Asset> assets = assetRepository.findAll();
        List<AssetDTO> assetDTOs = new ArrayList<AssetDTO>();
        assets.forEach((asset) -> {
            assetDTOs.add(modelMapper.map(asset, AssetDTO.class));
        });
        return assetDTOs;
    }

    public AssetDTO createAsset(AssetDTO assetDTO) {
        
        Asset asset = assetRepository.save(modelMapper.map(assetDTO, Asset.class));
        return modelMapper.map(asset, AssetDTO.class);
    }

    public AssetDTO getById(long id) {
        Optional<Asset> asset = assetRepository.findById(id);
        return modelMapper.map(asset, AssetDTO.class);
    }

    public Asset editAsset(Asset newAsset, Long id) {
        return assetRepository.findById(id)
            .map(Asset -> {
              Asset.setName(newAsset.getName());
              Asset.setDepartmentId(newAsset.getDepartmentId());
              Asset.setStatus(newAsset.getStatus());
              return assetRepository.save(Asset);
            })
            .orElseGet(() -> {
              newAsset.setId(id);
              return assetRepository.save(newAsset);
            });
      }
 
}
