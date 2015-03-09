package org.ili.java.projecttp.front.controllers;

import java.util.List;

import org.ili.java.projecttp.business.service.IService;
import org.ili.java.projecttp.front.models.dto.PersonDTO;
import org.ili.java.projecttp.persistence.dataobject.PersonDo;
import org.ili.java.projecttp.utils.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
  private static final String PERSONSALLTR = "persons";
  private static final String ACTION    = "action";
  private static final String RESULT    = "result";
  private static final String RESULTLIST    = "resultList";

  @Autowired
  @Qualifier("PersonService")
  private IService<PersonDo>  personService;

  /**
   * @param name
   * @param name2
   * @param model
   * @return
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public String get(@PathVariable final String id, final ModelMap model) {

   

    model.addAttribute(PERSONSTR, PersonMapper.getPersonDtoFromDo(personService.fetchPerson(Integer.parseInt(id))));
    model.addAttribute(ACTION, "found");
    return RESULT;
  }

  /**
   * @param id
   * @param model
   * @return
   */
 
  @RequestMapping(value = "/getAll", method = RequestMethod.GET)
  public String getAll(final ModelMap model) {

    //select
    final List<PersonDo> persons = personService.fetchAllPersons();

    model.addAttribute(PERSONSALLTR, PersonMapper.getPersonDoListFromDTOList(persons));
    model.addAttribute(ACTION, "found list");
    return RESULTLIST;
  }
  
  /**
   * @param name
   * @param model
   * @return
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public String delete(@PathVariable final String id, final ModelMap model) {

    //delete
    personService.removePerson(personService.fetchPerson(Integer.parseInt(id)));

    model.addAttribute(ACTION, "deleted");
    return RESULT;
  }
  
  /**
   * @param name
   * @param model
   * @return
   */
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public String post(@RequestBody final PersonDTO personDto, final ModelMap model) {

    personService.addPerson(PersonMapper.getPersonDoFromDto(personDto));
    
    //submit insert
    model.addAttribute(PERSONSTR, PersonMapper.getPersonDoFromDto(personDto));
    model.addAttribute(ACTION, "inserted");
    return RESULT;
  }

  /**
   * @param name
   * @param model
   * @return
   */
  @RequestMapping(value = "/modify", method = RequestMethod.PUT)
  public String put(@RequestBody final PersonDTO personDto, final ModelMap model) {

    //update
    personService.modifiyPerson(PersonMapper.getPersonDoFromDto(personDto));
    
    model.addAttribute(PERSONSTR, "put");
    model.addAttribute(ACTION, "updated");
    return RESULT;
  }
}
