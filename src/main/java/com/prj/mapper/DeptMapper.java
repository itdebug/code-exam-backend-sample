package com.prj.mapper;

import com.prj.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @创建人 Eric.Lu
 * @创建时间 2023/11/11
 * @地址 https://github.com/itdebug/
 * @描述
 */
@Mapper
public interface DeptMapper {

	@Select("select * from dept where id like concat('%', #{id}, '%')" +
			" and manager like concat('%', #{manager}, '%')" +
			" and name like concat('%', #{name}, '%')")
	List<Dept> query(String id, String manager, String name);
}
