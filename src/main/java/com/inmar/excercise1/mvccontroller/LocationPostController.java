package com.inmar.excercise1.mvccontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inmar.excercise1.controller.LocationController;
import com.inmar.excercise1.model.Location;
import com.inmar.excercise1.service.LocationService;

@Controller
public class LocationPostController {

	@Autowired
	LocationService locationService;
	@Autowired
	Location location;
	
    @PostMapping
   
    @RequestMapping(value="/locationpost", method=RequestMethod.POST)
    public String location(@RequestParam("l_name") String name,@RequestParam("l_description") String description) {
       
    	location.setName(name);
    	location.setDescription(description);
    	locationService.createLocation(location);
    	location=new Location();
    	return "location.jsp";
    	
    }
    @GetMapping("/locationpost")
    public String location(Model model) {
       
    	List<Location> locationlist=locationService.getAllLocation();
    	model.addAttribute("locationlist", "Test");
    	return "location.jsp";
    	
    }
    
    

}