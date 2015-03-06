package org.ili.java.projecttp.front.controllers;

import org.ili.java.projecttp.business.service.IService;
import org.ili.java.projecttp.front.models.mapper.PersonMapper;
import org.ili.java.projecttp.persistence.dataobject.PersonDo;
import org.ili.java.projecttp.utils.logger.Loggable;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Olivier MICHALSKI
 *
 */
@Controller
@RequestMapping("/PersonRESTCRUD")
public class PersonRESTController {

  private static final String PERSONSTR = "person";
  
  @Autowired
  @Qualifier("PersonService")
  private IService<PersonDo> personService;

  /**
   * @param name
   * @param name2
   * @param model
   * @return
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public String get(@PathVariable final String id, final ModelMap model) {
    
    //select
    final PersonDo person = personService.fetchPerson(Integer.parseInt(id));
    
    model.addAttribute(PERSONSTR, PersonMapper.getPersonDtoFromDo(person));
    model.addAttribute("action", "find");
    return "result";
  }

  /**
   * @param name
   * @param model
   * @return
   */
  @RequestMapping(value = "/{name}", method = RequestMethod.POST)
  public String post(@PathVariable final String name, final ModelMap model) {
    
    //submit insert
    model.addAttribute(PERSONSTR, "post");
    model.addAttribute(PERSONSTR, "insert");
    return "result";
  }

  /**
   * @param name
   * @param model
   * @return
   */
  @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
  public String put(@PathVariable final String name, final ModelMap model) {
    
    //update
    model.addAttribute(PERSONSTR, "put");
    model.addAttribute("action", "update");
    return "result";
  }

  /**
   * @param name
   * @param model
   * @return
   */
  @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
  public String delete(@PathVariable final String name, final ModelMap model) {
   
    //delete
    
    model.addAttribute(PERSONSTR, "delete");
    model.addAttribute("action", "delete");
    return "result";
  }
}
