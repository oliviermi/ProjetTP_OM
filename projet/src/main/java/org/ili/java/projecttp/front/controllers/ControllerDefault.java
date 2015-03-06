package org.ili.java.projecttp.front.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ili.java.projecttp.business.service.IService;
import org.ili.java.projecttp.front.models.dto.PersonDTO;
import org.ili.java.projecttp.front.models.mapper.PersonMapper;
import org.ili.java.projecttp.persistence.dataobject.PersonDo;
import org.ili.java.projecttp.utils.logger.Loggable;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Olivier MICHALSKI
 *
 */
@Controller
public class ControllerDefault {

  private static final String ADDPERSON = "addPerson";
  private static final String PERSONS = "persons";
  private static final String PERSON = "person";
  
  @Autowired
  @Qualifier("PersonService")
  private IService<PersonDo> personService;

  @Loggable
  private Logger        logger;
  
  /**
   * @param personDTO
   * @param result
   * @return
   */
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public ModelAndView savePerson(@ModelAttribute("command") final PersonDTO personDTO) {
    
    final PersonDo personDo = prepareModel(personDTO);
    personService.modifiyPerson(personDo);
    
    return new ModelAndView("redirect:/add.html");
  }

  /**
   * @return
   */
  @RequestMapping(value = "/persons", method = RequestMethod.GET)
  public ModelAndView listEmployees() {
    
    final Map<String, Object> model = new HashMap<String, Object>();
    model.put("persons", prepareListofBean(personService.fetchAllPersons()));
    
    return new ModelAndView("personsList", model);
  }

  /**
   * @param personDTO
   * @param result
   * @return
   */
  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public ModelAndView addPerson(@ModelAttribute("command") final PersonDTO personDTO) {
    
    final Map<String, Object> model = new HashMap<String, Object>();
    model.put(PERSONS, prepareListofBean(personService.fetchAllPersons()));
    
    return new ModelAndView(ADDPERSON, model);
  }

  @RequestMapping(value = "/edit", method = RequestMethod.GET)
  public ModelAndView editEmployee(@ModelAttribute("command") final PersonDTO personDTO) {
    
    final Map<String, Object> model = new HashMap<String, Object>();
    
    model.put(PERSON, preparePersonDTO(personService.fetchPerson(personDTO.getId())));
    model.put(PERSONS, prepareListofBean(personService.fetchAllPersons()));
    
    return new ModelAndView(ADDPERSON, model);
  }
  
  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public ModelAndView welcome() {
    
    return new ModelAndView("index");
  }

  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public ModelAndView deletePerson(@ModelAttribute("command") final PersonDTO personDTO) {
    
    final Map<String, Object> model = new HashMap<String, Object>();

    personService.removePerson(prepareModel(personDTO));
    
    model.put(PERSON, null);
    model.put(PERSONS, prepareListofBean(personService.fetchAllPersons()));
    
    return new ModelAndView(ADDPERSON, model);
  }

  private PersonDo prepareModel(final PersonDTO personDTO) {
    
    final PersonDo personDo = PersonMapper.getPersonDoFromDto(personDTO);
    
    personDTO.setId(null);
    
    return personDo;
  }

  private List<PersonDTO> prepareListofBean(final List<PersonDo> personDos) {
    
    List<PersonDTO> personDtos = null;
    
    if (personDos != null && !personDos.isEmpty()) {
      personDtos = new ArrayList<PersonDTO>();
      
      for (PersonDo personDo : personDos) {
        personDtos.add(PersonMapper.getPersonDtoFromDo(personDo));
      }
    }
    return personDtos;
  }

  private PersonDTO preparePersonDTO(final PersonDo personDo) {
    
    return PersonMapper.getPersonDtoFromDo(personDo);
  }
}