package CNPMNC.AssetManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import CNPMNC.AssetManagement.model.Department;
import CNPMNC.AssetManagement.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

  private DepartmentService departmentService;

  public DepartmentController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Department> getAll() {
    return departmentService.getAll();
  }
}
