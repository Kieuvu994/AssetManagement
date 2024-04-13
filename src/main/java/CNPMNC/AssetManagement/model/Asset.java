package CNPMNC.AssetManagement.model;

import CNPMNC.AssetManagement.enums.AssetStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name="status")
    private AssetStatus status;
    
    @Column(name="dep_id")
    private Integer dep_id;
}
