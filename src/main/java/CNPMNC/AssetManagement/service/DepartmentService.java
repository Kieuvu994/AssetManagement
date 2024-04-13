package CNPMNC.AssetManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;
import CNPMNC.AssetManagement.model.Department;
import CNPMNC.AssetManagement.repository.DepartmentRepository;

@Service
public class DepartmentService {

  private final DepartmentRepository repository;

  public DepartmentService(DepartmentRepository repo) {
    this.repository = repo;
  }

  public List<Department> getAll() {
    return repository.findAll();
  }
}
