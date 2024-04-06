package CNPMNC.AssetManagement.controller;

import CNPMNC.AssetManagement.dto.AssetDTO;
import CNPMNC.AssetManagement.model.Asset;
import CNPMNC.AssetManagement.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public AssetDTO getById(@PathVariable long id) {
        AssetDTO assetDTO = assetService.getById(id);
        return assetDTO;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssetDTO createAsset(@RequestBody AssetDTO assetDTO) {
        return assetService.createAsset(assetDTO);
    }

}
