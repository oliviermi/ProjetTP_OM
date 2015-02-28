package org.ili.java.projecttp.front.controllers;

import org.ili.java.projecttp.business.service.impl.PersonService;
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
  private Logger        logger;

  @Autowired
  private PersonService personService;

  @RequestMapping(value = "/{name}", method = RequestMethod.GET)
  public String get(@PathVariable
  final String name, final ModelMap model) {

    final PersonDo p2 = new PersonDo("michel", "legrand");

    personService.addPerson(p2);

    model.addAttribute("action", p2.toString());
    return "result";
  }

  @RequestMapping(value = "/{name}", method = RequestMethod.POST)
  public String post(@PathVariable
  final String name, final ModelMap model) {
    model.addAttribute("action", "post");
    return "result";
  }

  @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
  public String put(@PathVariable
  final String name, final ModelMap model) {
    model.addAttribute("action", "put");
    return "result";
  }

  @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
  public String delete(@PathVariable
  final String name, final ModelMap model) {
    model.addAttribute("action", "delete");
    return "result";
  }
}
