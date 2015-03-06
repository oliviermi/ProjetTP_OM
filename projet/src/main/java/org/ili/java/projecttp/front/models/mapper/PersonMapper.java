package org.ili.java.projecttp.front.models.mapper;

import org.ili.java.projecttp.front.models.dto.PersonDTO;
import org.ili.java.projecttp.persistence.dataobject.PersonDo;
import org.ili.java.projecttp.utils.logger.Loggable;
import org.slf4j.Logger;

public final class PersonMapper {

  @Loggable
  private static Logger logger;
  
  private PersonMapper() {

  }

  public static PersonDo getPersonDoFromDto(final PersonDTO personDTO) {

    final PersonDo personDo = new PersonDo();

    if (personDTO.getId() != null) {

      personDo.setIdperson(personDTO.getId());
    }
    personDo.setNom(personDTO.getNomPerson());
    personDo.setPrenom(personDTO.getPrenomPerson());
    personDo.setBirthDate(personDTO.getBirthDatePerson());

    logger.debug("in personmappper dto->do");
    logger.debug(personDo.toString());
    logger.debug(personDTO.toString());
    
    return personDo;
  }

  public static PersonDTO getPersonDtoFromDo(final PersonDo personDo) {

    final PersonDTO personDTO = new PersonDTO();

    personDTO.setId(personDo.getIdperson());
    personDTO.setNomPerson(personDo.getNom());
    personDTO.setPrenomPerson(personDo.getPrenom());
    personDTO.setBirthDatePerson(personDo.getBirthDate());

    System.out.println("in personmappper do->dto");
    System.out.println(personDo.toString());
    System.out.println(personDTO.toString());
    
    return personDTO;
  }
}
