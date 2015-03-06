package org.ili.java.projecttp.front.models.mapper;

import org.ili.java.projecttp.front.models.dto.PersonDTO;
import org.ili.java.projecttp.persistence.dataobject.PersonDo;

public class PersonMapper {

  public static PersonDo getPersonDoFromDto(final PersonDTO personDTO) {

    final PersonDo personDo = new PersonDo();

    if (personDTO.getId() != null) {
      personDo.setIdperson(personDTO.getId());
    }
    personDo.setNom(personDTO.getNomPerson());
    personDo.setPrenom(personDTO.getPrenomPerson());
    personDo.setBirthDate(personDTO.getBirthDatePerson());

    return personDo;
  }

  public static PersonDTO getPersonDtoFromDo(final PersonDo personDo) {

    final PersonDTO personDto = new PersonDTO();

    personDto.setId(personDo.getIdperson());
    personDto.setNomPerson(personDo.getNom());
    personDto.setPrenomPerson(personDo.getPrenom());
    personDto.setBirthDatePerson(personDo.getBirthDate());

    return personDto;
  }
}
