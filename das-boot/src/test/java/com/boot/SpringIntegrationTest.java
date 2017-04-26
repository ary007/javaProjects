package com.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import com.boot.repository.ShipwreckRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class SpringIntegrationTest {

	 @Autowired
	 private ShipwreckRepository shipwreckRepository;
	
	 @Test
	 public void findAllTest() {
		assertThat(shipwreckRepository.findAll().size(),is(greaterThan(0)));
	}

}
