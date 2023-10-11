package com.vampa.sample_java;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vampa.comfig.RootConfig;
import com.vampa.sample.Restaurant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
public class SampleTests {
 
@Autowired
private Restaurant restaurant;
 
@Test
public void textExist() {
 
assertNotNull(restaurant);
 
}
}
