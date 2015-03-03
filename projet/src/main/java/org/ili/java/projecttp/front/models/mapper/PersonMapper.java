package org.ili.java.projecttp.front.models.mapper;

import org.ili.java.projecttp.front.models.dto.PersonDTO;
import org.ili.java.projecttp.persistence.dataobject.PersonDo;

public class PersonMapper {

  public PersonDo getPersonDoFromDto(final PersonDTO personDTO) {
    
    final PersonDo personDo = new PersonDo();

    personDo.setNom(personDTO.getNomPerson());
    personDo.setPrenom(personDTO.getPrenomPerson());
    personDo.setBirthDate(personDTO.getBirthDatePerson());

    return personDo;
  }

  public PersonDTO getPersonDtoFromDo(final PersonDo personDo) {

    final PersonDTO personDto = new PersonDTO();

    personDto.setNomPerson(personDo.getNom());
    personDto.setPrenomPerson(personDo.getPrenom());
    personDto.setBirthDatePerson(personDo.getBirthDate());

    return personDto;
  }
}
