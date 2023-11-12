package com.prj.controller;

import com.prj.dto.ResponseModel;
import com.prj.entity.EmpKpi;
import com.prj.entity.Employee;
import com.prj.repository.DeptRepository;
import com.prj.repository.EmpKpiRepository;
import com.prj.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/11/12
 * @地址 https://github.com/itdebug/
 * @描述
 */
@RestController
@CrossOrigin
public class EmpKpiController {


	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmpKpiRepository empKpiRepository;

	@Autowired
	private DeptRepository deptRepository;
	@PostMapping("/empKpi")
	public ResponseModel empKpi(@RequestBody EmpKpi empKpi) {
		Optional<Employee> byId = employeeRepository.findById(empKpi.getEmployeeID());
		if(!byId.isPresent()) {
			return new ResponseModel(1000, "评价失败");
		}
		Employee employee = byId.get();
		empKpi.setEmployeeName(employee.getName());
		empKpi.setCheck_date(new Date());
		empKpiRepository.save(empKpi);
		return new ResponseModel(200, "评价成功");
	}

	@GetMapping("/empKpi")
	public Page<EmpKpi> page(
			int pageSize,
			int pageNumber,
			String empId,
			String empName,
			String kpi
	) {
		return empKpiRepository.findByEmployeeIDLikeAndEmployeeNameLikeAndKpiLike(
				"%" + empId + "%",
				"%" + empName + "%",
				"%" + kpi + "%",
				PageRequest.of(pageNumber - 1, pageSize)
		);
	}
}
