package com.sut.se.g03.controller;

import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
	public void manageStatus(@PathVariable Long statusId, @PathVariable Long classId){
		Classify classify = classifyRepository.findById(classId).get();
		classify.setClassifyStatus(classifyStatusRepository.findById(statusId).get());
		classifyRepository.save(classify);
	}

	@PostMapping("classify/manage/type/{typeId}/{itemId}")
	public void manageType(@PathVariable Long typeId, @PathVariable Long itemId){
		TypeOfItem typeOfItem = new TypeOfItem(itemTypeRepository.getOne(typeId), itemRepository.getOne(itemId));
		Example<TypeOfItem> e = Example.of(typeOfItem);
		if (typeOfItemRepository.exists(e))
			return;
		typeOfItemRepository.save(typeOfItem);
	}

	@PostMapping("classify/manage/class/{classId}/{itemId}")
	public void manageClass(@PathVariable Long classId, @PathVariable Long itemId){
		Classify classify = classifyRepository.findById(classId).get();
		if(classify.isDecreaseAble())
			classify.setAmount(classify.getAmount()-1);
		ClassifyItem classifyItem = new ClassifyItem(classify, itemRepository.findById(itemId).get());
		Example<ClassifyItem> e = Example.of(classifyItem);
		if(classifyItemRepository.exists(e))
			return;
		classifyItemRepository.save(classifyItem);
	}

	@PostMapping("classify/add/class")
	public void addClass(@RequestBody Classify classify){
		classifyRepository.save(classify);
	}

	@PostMapping("classify/add/type/{typeName}")
	public void addType(@PathVariable String typeName){
		itemTypeRepository.save(new ItemType(typeName));
	}

}
