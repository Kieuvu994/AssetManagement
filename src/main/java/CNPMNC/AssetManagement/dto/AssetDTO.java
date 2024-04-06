package CNPMNC.AssetManagement.dto;

import CNPMNC.AssetManagement.enums.AssetStatus;
import lombok.Data;

@Data
public class AssetDTO {
    private long id = -1;
    private String name;
    private AssetStatus status = AssetStatus.Available;
}
