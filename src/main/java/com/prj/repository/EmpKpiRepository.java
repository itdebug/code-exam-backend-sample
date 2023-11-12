package com.prj.repository;

import com.prj.entity.EmpKpi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/11/12
 * @地址 https://github.com/itdebug/
 * @描述
 */
@Repository
public interface EmpKpiRepository extends JpaRepository<EmpKpi, String> {

	Page<EmpKpi> findByEmployeeIDLikeAndEmployeeNameLikeAndKpiLike(
			String empId, String empName, String kpi, Pageable pageable
	);
}
