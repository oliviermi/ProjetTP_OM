package org.ili.java.projecttp.front.controllers;

import org.ili.java.projecttp.persistence.dao.impl.PersonDAO;
import org.ili.java.projecttp.persistence.dataobject.PersonDo;
import org.ili.java.projecttp.utils.logger.Loggable;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class RESTController {

	@Loggable
	private Logger logger;

	@Autowired
	private PersonDAO personDAO;
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String get(@PathVariable final String name, final ModelMap model) {

		// model.addAttribute("action", name);

		logger.info(name);

		logger.info("nb person " + personDAO.countAll().toString());
		
		final PersonDo p = personDAO.find(1);
		
		logger.info("nb person " + personDAO.countAll().toString());
		
		logger.info("p = " + p.toString());
		
		//PersonDo p2 = new PersonDo("michel", "legrand");
		
		//personDAO.create(p2);
	    
		//logger.info("p2 = " + p2.toString());
		
		p.setNom("un autre nom");
		
		personDAO.update(p);
		
		final PersonDo p2 = personDAO.find(1);
		
		logger.info("p2 = " + p2.toString());
		    
		logger.info("nb person " + personDAO.countAll().toString());
		model.addAttribute("action", p.toString());
		return "result";
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.POST)
	public String post(@PathVariable final String name, final ModelMap model) {
		model.addAttribute("action", "post");
		return "result";
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.PUT)
	public String put(@PathVariable final String name, final ModelMap model) {
		model.addAttribute("action", "put");
		return "result";
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
	public String delete(@PathVariable final String name, final ModelMap model) {
		model.addAttribute("action", "delete");
		return "result";
	}
}
