package CNPMNC.AssetManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import CNPMNC.AssetManagement.dto.AssetDTO;
import CNPMNC.AssetManagement.model.Asset;
import CNPMNC.AssetManagement.service.AssetService;

@RestController
@RequestMapping("/assets")
public class AssetController {
    @Autowired
    private AssetService assetService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AssetDTO> getAll(){
        List<AssetDTO> assetDTOs = assetService.getAll();
        return assetDTOs;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public AssetDTO getById(@PathVariable long id) {
        return assetService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssetDTO createAsset(@RequestBody AssetDTO assetDTO) {
     
        return assetService.createAsset(assetDTO);
    }
    
    @PostMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
   public Asset editAsset(@RequestBody Asset Asset, @PathVariable Long id) {
    
      return assetService.editAsset(Asset, id);
    }
    
}
