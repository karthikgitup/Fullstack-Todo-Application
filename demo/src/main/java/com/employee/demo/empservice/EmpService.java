package com.employee.demo.empservice;

import java.util.List;

import com.employee.demo.dto.EmpSaveDto;
import com.employee.demo.empentity.EmpEntity;

public interface EmpService  {

	String saveData(EmpSaveDto empSaveDto);

	List<EmpEntity> getData();

	

	String updateData(int id, EmpEntity empEntity);

	String deleteData(int id);

}
