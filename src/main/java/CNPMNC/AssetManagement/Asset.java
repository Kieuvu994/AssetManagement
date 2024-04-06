package CNPMNC.AssetManagement;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Asset {
    
enum Status{Available,BeingUsed,Missing,Broken};
    @Id
 
    private String id;
    private String name;
    private Status state;
     
    public Asset(String id, String name, Status state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getState() {
        return this.state;
    }

    public void setState(Status state) {
        this.state = state;
    }
  
}
