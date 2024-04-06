package CNPMNC.AssetManagement.repository;

import CNPMNC.AssetManagement.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}
