package com.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

@RestController
@RequestMapping("api/v1/")
public class ShipWreckController {

	 @Autowired
	 private ShipwreckRepository shipwreckRepository;
	 
	@RequestMapping(value="shipwrecks", method=RequestMethod.GET)
	public List<Shipwreck> list() {
		//return shipwreckRepository.list();
		return shipwreckRepository.findAll();
	}
	
	
	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id) {
		//return ShipwreckStub.get(id);
		return shipwreckRepository.findOne(id);
	}
	
	@RequestMapping(value="shipwrecks", method=RequestMethod.POST)
	public Shipwreck get(@RequestBody Shipwreck shipwreck) {
		//return ShipwreckStub.create(shipwreck);
		return shipwreckRepository.saveAndFlush(shipwreck);
	}
	
	
	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.PUT)
	public Shipwreck get(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
		Shipwreck existing=shipwreckRepository.findOne(id);
		BeanUtils.copyProperties(shipwreck, existing);
		//return ShipwreckStub.update(id, shipwreck);
		return shipwreckRepository.saveAndFlush(existing);
	}
	
	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id) {
		//return ShipwreckStub.delete(id);
		Shipwreck existing=shipwreckRepository.findOne(id);
		 shipwreckRepository.delete(id);
		 return existing;
	}
}
