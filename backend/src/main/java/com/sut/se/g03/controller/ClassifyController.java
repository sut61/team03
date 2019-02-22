package com.sut.se.g03.controller;

import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClassifyController {
	@Autowired
	private ClassifyRepository classifyRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ClassifyStatusRepository classifyStatusRepository;
	@Autowired
	private ClassifyItemRepository classifyItemRepository;
	@Autowired
	private ItemTypeRepository itemTypeRepository;
	@Autowired
	private TypeOfItemRepository typeOfItemRepository;

	@GetMapping("/classify/queue/class")
	public List<Classify> getAllClassify(){
		return classifyRepository.findAll();
	}

	@GetMapping("/classify/queue/status")
	public List<ClassifyStatus> getAllStatus(){
		return classifyStatusRepository.findAll();
	}

	@GetMapping("classify/queue/item")
	public List<Item> getAllItem(){
		return itemRepository.findAll();
	}

	@GetMapping("classify/queue/type")
	public List<ItemType> getAllType(){
		return itemTypeRepository.findAll();
	}

	@PostMapping("classify/manage/status/{statusId}/{classId}")
	public ResponseEntity<String> manageStatus(@PathVariable Long statusId, @PathVariable Long classId){
		Classify classify = null;
		if(classifyRepository.findById(classId).isPresent()) {
			classify = classifyRepository.findById(classId).get();
		}
		if(classifyStatusRepository.findById(statusId).isPresent()) {
			try{
				if(classify.getClassifyStatus() == classifyStatusRepository.findById(statusId).get()){
					return new ResponseEntity<>("status has assigned", HttpStatus.BAD_REQUEST);
				}
				classify.setClassifyStatus(classifyStatusRepository.findById(statusId).get());
			}catch (NullPointerException e){
				return new ResponseEntity<>("cannot find classify id or status id", HttpStatus.BAD_REQUEST);
			}
		}
		classifyRepository.save(classify);
		return new ResponseEntity<>("change status complete", HttpStatus.ACCEPTED);
	}

	@PostMapping("classify/manage/type/{typeId}/{itemId}")
	public ResponseEntity<String> manageType(@PathVariable Long typeId, @PathVariable Long itemId){
		TypeOfItem typeOfItem = new TypeOfItem(itemTypeRepository.getOne(typeId), itemRepository.getOne(itemId));
		Example<TypeOfItem> e = Example.of(typeOfItem);
		if (typeOfItemRepository.exists(e))
			return new ResponseEntity<>("type has assigned", HttpStatus.BAD_REQUEST);
		typeOfItemRepository.save(typeOfItem);
		return new ResponseEntity<>("assign type complete", HttpStatus.ACCEPTED);
	}

	@PostMapping("classify/manage/class/{classId}/{itemId}")
	public ResponseEntity<String> manageClass(@PathVariable Long classId, @PathVariable Long itemId){
		Classify classify = null;
		ClassifyItem classifyItem = null;
		if (classifyRepository.findById(classId).isPresent())
			classify = classifyRepository.findById(classId).get();
		try {
			if (classify.isDecreaseAble())
				classify.setAmount(classify.getAmount() - 1);
			if (classify.getAmount() < 0)
				return new ResponseEntity<>("empty amount", HttpStatus.BAD_REQUEST);
			if (itemRepository.findById(itemId).isPresent())
				classifyItem = new ClassifyItem(classify, itemRepository.findById(itemId).get());
			}catch (NullPointerException e){
			return new ResponseEntity<>("cannot find class id or item id", HttpStatus.BAD_REQUEST);
			}
			Example<ClassifyItem> e = Example.of(classifyItem);
			if(classifyItemRepository.exists(e))
				return new ResponseEntity<>("class has assigned", HttpStatus.BAD_REQUEST);
			classifyItemRepository.save(classifyItem);
			return new ResponseEntity<>("assign class complete", HttpStatus.ACCEPTED);
	}

	@PostMapping("classify/add/class")
	public ResponseEntity<String> addClass(@RequestBody Classify classify){
		classifyRepository.save(classify);
		return new ResponseEntity<>("add class complete", HttpStatus.ACCEPTED);
	}

	@PostMapping("classify/add/type/{typeName}")
	public ResponseEntity<String> addType(@PathVariable String typeName){
		itemTypeRepository.save(new ItemType(typeName));
		return new ResponseEntity<>("add type complete", HttpStatus.ACCEPTED);
	}

}
