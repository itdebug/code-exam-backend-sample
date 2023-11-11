package com.prj.controller;

import com.prj.entity.Dept;
import com.prj.mapper.DeptMapper;
import com.prj.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/11/11
 * @地址 https://github.com/itdebug/
 * @描述
 */
@RestController
@CrossOrigin
public class DeptController {

	@Autowired
	private DeptRepository deptRepository;

	@GetMapping("depts")
	public Page<Dept> page(int pageNum, int pageSize, String id,
						   String manager, String name) {
		PageRequest request = PageRequest.of(pageNum - 1, pageSize);
		return deptRepository.findByIdLikeAndManagerLikeAndNameLike(
				"%" + id + "%",
				"%" + manager + "%",
				"%" + name + "%",
				request);
	}
}
