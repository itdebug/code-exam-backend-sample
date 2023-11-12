package com.prj.repository;

import com.prj.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/11/11
 * @地址 https://github.com/itdebug/
 * @描述
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

	Page<Employee> findByIdLikeAndNameLikeAndDeptLikeAndPositionLike(
			String id,
			String name,
			String dept,
			String position,
			Pageable pageable);
}
