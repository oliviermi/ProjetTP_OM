package org.ili.java.projecttp.front.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.ili.java.projecttp.business.service.IService;
import org.ili.java.projecttp.front.models.dto.PersonDTO;
import org.ili.java.projecttp.persistence.dataobject.PersonDo;
import org.ili.java.projecttp.utils.logger.Loggable;
import org.ili.java.projecttp.utils.mapper.PersonMapper;
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
  private static final String PERSONS   = "persons";
  private static final String PERSON    = "person";

  @Autowired
  @Qualifier("PersonService")
  private IService<PersonDo>  personService;

  @Loggable
  private Logger              myLogger;

  private Map<String, String> errors    = new HashMap<String, String>();

  /**
   * @param personDTO
   * @param result
   * @return
   */
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public ModelAndView savePerson(@ModelAttribute("command")
  final PersonDTO personDTO) {

    myLogger.debug("*****SAVE with personDTO = " + personDTO.toString());

    final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    final Validator validator = factory.getValidator();
    final Set<ConstraintViolation<PersonDTO>> constraintViolations = validator.validate(personDTO);

    if (constraintViolations.size() > 0) {

      final Map<String, Object> model = new HashMap<String, Object>();

      myLogger.debug("*****OMImpossible de valider les donnees du bean : nb errerur : " + constraintViolations.size());

      for (ConstraintViolation<PersonDTO> contraintes : constraintViolations) {
        myLogger.debug("*******" + contraintes.getRootBeanClass().getSimpleName() + "." + contraintes.getPropertyPath() + " " + contraintes.getMessage());
        errors.put(contraintes.getPropertyPath().toString(), contraintes.getMessage());
      }
      myLogger.debug("putting errors to add form");
      model.put("errors", errors);
      model.put(PERSON, personDTO);
      model.put(PERSONS, prepareListofBean(personService.fetchAllPersons()));
      myLogger.debug("errors contains :" + errors.toString());

      final PersonDo personDo = prepareModel(personDTO);
      personService.modifiyPerson(personDo);

      return new ModelAndView(ADDPERSON, model);

    } else {

      myLogger.debug("valider les donnees du bean ok");
      final PersonDo personDo = prepareModel(personDTO);
      personService.modifiyPerson(personDo);
    }
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
  public ModelAndView addPerson(@ModelAttribute("command")
  final PersonDTO personDTO) {

    myLogger.debug("****ADD");

    final Map<String, Object> model = new HashMap<String, Object>();
    model.put(PERSONS, prepareListofBean(personService.fetchAllPersons()));

    return new ModelAndView(ADDPERSON, model);
  }

  /**
   * @param personDTO
   * @return
   */
  @RequestMapping(value = "/edit", method = RequestMethod.GET)
  public ModelAndView editEmployee(@ModelAttribute("command")
  final PersonDTO personDTO) {

    final Map<String, Object> model = new HashMap<String, Object>();

    model.put(PERSON, preparePersonDTO(personService.fetchPerson(personDTO.getId())));
    model.put(PERSONS, prepareListofBean(personService.fetchAllPersons()));

    return new ModelAndView(ADDPERSON, model);
  }

  /**
   * @return
   */
  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public ModelAndView welcome() {

    return new ModelAndView("index");
  }

  /**
   * @param personDTO
   * @return
   */
  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public ModelAndView deletePerson(@ModelAttribute("command")
  final PersonDTO personDTO) {

    final Map<String, Object> model = new HashMap<String, Object>();

    personService.removePerson(prepareModel(personDTO));

    model.put(PERSON, null);
    model.put(PERSONS, prepareListofBean(personService.fetchAllPersons()));

    model.put(PERSON, null);
    model.put(PERSONS, prepareListofBean(personService.fetchAllPersons()));

    return new ModelAndView(ADDPERSON, model);
  }

  /**
   * @param personDTO
   * @return
   */
  private PersonDo prepareModel(final PersonDTO personDTO) {

    final PersonDo personDo = PersonMapper.getPersonDoFromDto(personDTO);

    personDTO.setId(null);

    return personDo;
  }

  /**
   * @param personDos
   * @return
   */
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

  /**
   * @param personDo
   * @return
   */
  private PersonDTO preparePersonDTO(final PersonDo personDo) {

    return PersonMapper.getPersonDtoFromDo(personDo);
  }

  /**
   * @return the errors
   */
  public Map<String, String> getErrors() {
    return errors;
  }

  /**
   * @param errors the errors to set
   */
  public void setErrors(final Map<String, String> errors) {
    this.errors = errors;
  }
}
