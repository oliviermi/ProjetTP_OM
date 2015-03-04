package org.ili.java.projecttp.front.controllers;

import org.ili.java.projecttp.front.models.dto.PersonDTO;
import org.ili.java.projecttp.front.models.validators.PersonDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/person.do")
public class PersonController {

  @Autowired
  private PersonDTOValidator personDTOValidator;

  /**
   * @param personDTO
   * @param result
   * @param status
   * @return
   */
  @RequestMapping(method = RequestMethod.POST)
  public String processSubmit(@ModelAttribute("customer")
  final PersonDTO personDTO, final BindingResult result, final SessionStatus status) {

    personDTOValidator.validate(personDTO, result);

    if (result.hasErrors()) {
      // if validator failed
      return "PersonForm";
    } else {
      status.setComplete();
      // form success
      return "PersonSuccess";
    }
  }

  /**
   * @param model
   * @return
   */
  @RequestMapping(method = RequestMethod.GET)
  public String initForm(final ModelMap model) {

    final PersonDTO personDTO = new PersonDTO();
    // Make "Spring MVC" as default checked value

    // Make "Make" as default radio button selected value

    // make "Hibernate" as the default java skills selection

    // initilize a hidden value

    // command object
    model.addAttribute("personDTO", personDTO);

    // return form view
    return "PersonForm";
  }

}
