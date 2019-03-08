package com.launchwindows;

import java.io.IOException;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.launchwindows.resources.LaunchWindowsResource;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LaunchWindowsAppApplication.class) //Testing from main application "src/main/java"
@WebAppConfiguration
public abstract class AbstractTest {
protected MockMvc mvc;
	
	@Resource
    protected WebApplicationContext webApplicationContext; //used in building a MockMvc object
	
	protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
	
	///Required by tests involving Mockito 
	protected void setUp(LaunchWindowsResource controller) {
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
	
	
	///Map java object to JSON
	protected String mapToJson(Object obj) throws JsonProcessingException 
	{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }
	
	//Maps JSON to a java class T
	protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException 
	{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }


}
