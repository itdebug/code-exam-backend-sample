package com.prj.repository;

import com.prj.entity.Dept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/11/11
 * @地址 https://github.com/itdebug/
 * @描述
 */
public interface DeptRepository extends JpaRepository<Dept, String> {

	Page<Dept> findByIdLikeAndManagerLikeAndNameLike(String id, String manager, String name, Pageable pageable);
	Dept findByName(String name);
}
