package com.prj.controller;

import com.prj.dto.ResponseModel;
import com.prj.entity.EmpSalaryApply;
import com.prj.entity.Employee;
import com.prj.repository.EmpSalaryApplyRepository;
import com.prj.repository.EmployeeRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
public class EmpSalaryApplyController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmpSalaryApplyRepository empSalaryApplyRepository;

	@PostMapping("/empSalaryApply")
	public ResponseModel salaryApply(@RequestBody EmpSalaryApply empSalaryApply) {
		Optional<Employee> byId = employeeRepository.findById(empSalaryApply.getEmpId());
		if(!byId.isPresent()) {
			return new ResponseModel(1000, "审批失败");
		}

		Employee employee = byId.get();
		double salary = empSalaryApply.getEmpSalary() * (1 + empSalaryApply.getApproveRate() / 100);
		employee.setSalary(salary);

		empSalaryApply.setApproveSalary(salary);
		empSalaryApply.setApproveDate(new Date());

		employeeRepository.save(employee);
		empSalaryApplyRepository.save(empSalaryApply);
		return new ResponseModel(200, "审批成功");
	}

	@GetMapping("/empSalaryApply")
	public Page<EmpSalaryApply> empSalaryApply(int pageNum,
											   int pageSize,
											   String manager,
											   String approveDateStart,
											   String approveDateEnd) {
		Date start = new Date();
		Date end = start;
		if(StringUtils.isNotBlank(approveDateStart)) {
			try {
				start = DateUtils.parseDate(approveDateStart, "yyyy-MM-dd");
			} catch (ParseException e) {

			}
		}

		if(StringUtils.isNotBlank(approveDateEnd)) {
			try {
				end = DateUtils.parseDate(approveDateEnd, "yyyy-MM-dd");
			} catch (ParseException e) {

			}
		}
		start = DateUtils.setHours(start, 0);
		start = DateUtils.setMinutes(start, 0);
		start = DateUtils.setSeconds(start, 0);


		end = DateUtils.setHours(end, 23);
		end = DateUtils.setMinutes(end, 59);
		end = DateUtils.setSeconds(end, 59);
		return empSalaryApplyRepository.findByManagerLikeAndApproveDateBetween("%" + manager + "%",
				start, end, PageRequest.of(pageNum -1 , pageSize));

	}
}
