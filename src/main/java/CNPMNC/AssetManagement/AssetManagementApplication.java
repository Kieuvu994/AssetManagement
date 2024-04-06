package CNPMNC.AssetManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AssetManagementApplication {

  public static void main(String[] args) {
    SpringApplication.run(AssetManagementApplication.class, args);
  }

  @GetMapping("help")
  public String help() {
    return "i can see you.";
  }

}
