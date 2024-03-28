package com.employee.demo.empservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.demo.dto.EmpSaveDto;
import com.employee.demo.empentity.EmpEntity;
import com.employee.demo.emprepository.EmpRepository;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpRepository empRepository;

	@Override
	public String saveData(EmpSaveDto empSaveDto) {
		EmpEntity empEntity=new EmpEntity(empSaveDto.getEmpname(),empSaveDto.getPosition(),empSaveDto.getCity(),empSaveDto.getSalary());
		empRepository.save(empEntity);
		return empEntity.getEmpname();
		}

	@Override
	public List<EmpEntity> getData() {
		// TODO Auto-generated method stub
		List li=empRepository.findAll();
		return li;
	}

	
	@Override
	public String updateData(int id, EmpEntity empEntity) {
		Optional<EmpEntity> optionalobj=empRepository.findById(id);
		if(optionalobj.isPresent()) {
			EmpEntity empentity=optionalobj.get();
			empentity.setEmpname(empEntity.getEmpname());
			empentity.setPosition(empEntity.getPosition());
			empentity.setCity(empEntity.getCity());
			empentity.setSalary(empEntity.getSalary());
			empRepository.save(empentity);
			return "updated successfully";
			}else {
				return "id is no found";
			}
		
	}

	@Override
	public String deleteData(int id) {
		// TODO Auto-generated method stub
		Optional optionalobj=empRepository.findById(id);
		if(optionalobj.isPresent()) {
			empRepository.deleteById(id);
			return "Deleted Successfully";
		}
			
		return "id is not found";
	}

}
