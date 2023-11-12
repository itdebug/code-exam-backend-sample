package com.prj.controller;

import com.prj.dto.ResponseModel;
import com.prj.entity.Dept;
import com.prj.entity.Employee;
import com.prj.repository.DeptRepository;
import com.prj.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/11/11
 * @地址 https://github.com/itdebug/
 * @描述
 */
@RestController
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DeptRepository deptRepository;

	@RequestMapping("/employees")
	public Page<Employee> list(int pageNum, int pageSize, String id,
							   String name, String dept, String position,
							   Double salary) {
		return employeeRepository.findByIdLikeAndNameLikeAndDeptLikeAndPositionLike(
				"%" + id + "%",
				"%" + name + "%",
				"%" + dept + "%",
				"%" + position + "%",
				PageRequest.of(pageNum -1, pageSize));
	}

	@PostMapping("/employee")
	public ResponseModel add(@RequestBody Employee employee) {
		Optional<Employee> byId = employeeRepository.findById(employee.getId());
		if(byId.isPresent()) {
			return new ResponseModel(1000, "已存在");
		}
		employeeRepository.save(employee);
		return new ResponseModel(200, "成功");
	}

	@PutMapping("/employee")
	public ResponseModel edit(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return new ResponseModel(200, "成功");
	}

	@DeleteMapping("/employees")
	public ResponseModel deleteBatch(String ids) {
		employeeRepository.deleteAllById(Arrays.asList(ids.split(",")));
		return new ResponseModel(200, "成功");
	}

	@DeleteMapping("/employee")
	public ResponseModel delete(String id) {
		employeeRepository.deleteById(id);
		return new ResponseModel(200, "成功");
	}

	@GetMapping("/employee")
	public Employee get(String id) {
		return employeeRepository.findById(id).get();
	}

	@GetMapping("/employeeAndDept")
	public Employee employeeAndDept(String id) {
		Employee employee = employeeRepository.findById(id).get();
		String deptName = employee.getDept();
		Dept dept = deptRepository.findByName(deptName);
		employee.setManager(dept.getManager());
		return employee;
	}
}
