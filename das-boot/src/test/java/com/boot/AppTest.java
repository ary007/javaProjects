package com.boot;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipWreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	@InjectMocks 
	ShipWreckController shipWreck;
	
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
 @Test
 public void ShipWreckControllerTest()
 {
	 Shipwreck sw=new Shipwreck();
	 sw.setId(1L);
	 Mockito.when(shipwreckRepository.findOne(1l)).thenReturn(sw);
	 
	 Shipwreck st=shipwreckRepository.findOne(1l);
	assertEquals(st,sw);
	assertThat(st.getId(), is(1l));
 }
}
