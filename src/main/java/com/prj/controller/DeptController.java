package com.prj.controller;

import com.prj.dto.ResponseModel;
import com.prj.entity.Dept;
import com.prj.repository.DeptRepository;
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
public class DeptController {

	@Autowired
	private DeptRepository deptRepository;

	/**
	 * 部门列表查询
	 * @param pageNum
	 * @param pageSize
	 * @param id
	 * @param manager
	 * @param name
	 * @return
	 */
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

	/**
	 * 批量删除部门
	 * @param ids
	 * @return
	 */
	@DeleteMapping("depts")
	public ResponseModel deleteBatch(String ids) {
		deptRepository.deleteAllById(Arrays.asList(ids.split(",")));
		return new ResponseModel(200, "成功");
	}

	/**
	 * 单个部门删除
	 * @param id
	 * @return
	 */
	@DeleteMapping("dept")
	public ResponseModel delete(String id) {
		deptRepository.deleteById(id);
		return new ResponseModel(200, "成功");
	}

	/**
	 * 新增部门
	 * @param dept
	 * @return
	 */
	@PostMapping("dept")
	public ResponseModel add(@RequestBody Dept dept) {
		Optional<Dept> byId = deptRepository.findById(dept.getId());
		if(byId.isPresent()) {
			return new ResponseModel(1000, "ID已存在");
		}
		deptRepository.save(dept);
		return new ResponseModel(200, "成功");
	}

	/**
	 * 查询部门
	 * @param id
	 * @return
	 */
	@GetMapping("dept")
	public Dept get(String id) {
		return deptRepository.findById(id).get();
	}

	/**
	 * 修改部门
	 * @param dept
	 * @return
	 */
	@PutMapping("dept")
	public ResponseModel modify(@RequestBody Dept dept) {
		deptRepository.save(dept);
		return new ResponseModel(200, "成功");
	}
}
