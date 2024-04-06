package CNPMNC.AssetManagement.repository;

import CNPMNC.AssetManagement.model.Asset;
import org.springframework.data.repository.CrudRepository;

public interface AssetRepository extends CrudRepository<Asset, Long> {
}
