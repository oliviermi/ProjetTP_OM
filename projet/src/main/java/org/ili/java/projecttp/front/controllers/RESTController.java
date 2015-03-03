package org.ili.java.projecttp.front.controllers;

import org.ili.java.projecttp.business.service.IService;
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
@RequestMapping("/restCRUD")
public class RESTController {

  @Loggable
  private Logger             logger;

  @Autowired
  @Qualifier("PersonService")
  private IService<PersonDo> personService;

  /**
   * @param name
   * @param name2
   * @param model
   * @return
   */
  @RequestMapping(value = "/{name}", method = RequestMethod.GET)
  public String get(@PathVariable final String name, final ModelMap model) {

    
    
    model.addAttribute("action", "get");
    return "result";
  }

  /**
   * @param name
   * @param model
   * @return
   */
  @RequestMapping(value = "/{name}", method = RequestMethod.POST)
  public String post(@PathVariable final String name, final ModelMap model) {
    
    //submit
    model.addAttribute("action", "post");
    return "result";
  }

  /**
   * @param name
   * @param model
   * @return
   */
  @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
  public String put(@PathVariable final String name, final ModelMap model) {
    model.addAttribute("action", "put");
    return "result";
  }

  /**
   * @param name
   * @param model
   * @return
   */
  @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
  public String delete(@PathVariable final String name, final ModelMap model) {
    model.addAttribute("action", "delete");
    return "result";
  }
}
