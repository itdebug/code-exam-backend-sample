package com.prj.repository;

import com.prj.entity.EmpSalaryApply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/11/12
 * @地址 https://github.com/itdebug/
 * @描述
 */
@Repository
public interface EmpSalaryApplyRepository extends JpaRepository<EmpSalaryApply, String> {

	Page<EmpSalaryApply> findByManagerLikeAndApproveDateBetween(String manager,
																Date approveDateStart,
																Date approveDateEnd, Pageable pageable);
}
