package com.employee.demo.empcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.demo.dto.EmpSaveDto;
import com.employee.demo.empentity.EmpEntity;
import com.employee.demo.empservice.EmpService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class EmpController {
	@Autowired
	private EmpService empService;
	@PostMapping("/save")
	public String saveData(@RequestBody EmpSaveDto empSaveDto) {
		return empService.saveData(empSaveDto);
		
		
	}
	@GetMapping("/data")
	public List<EmpEntity> getData() {
		List li=empService.getData();
		return li;
		
	}
	@PutMapping("/update/{id}")
	public String updateData(@PathVariable int id,@RequestBody EmpEntity empEntity  ) {
	return 	empService.updateData( id, empEntity);
		
	}
	@DeleteMapping("/delete/{id}")
	public String deleteData(@PathVariable int id) {
		return empService.deleteData(id);
		
	}

}
