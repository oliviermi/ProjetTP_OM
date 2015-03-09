package org.ili.java.projecttp.front.models.mapper;

import java.util.HashSet;
import java.util.Set;

import org.ili.java.projecttp.front.models.dto.PersonDTO;
import org.ili.java.projecttp.persistence.dataobject.PersonDo;
import org.ili.java.projecttp.utils.logger.Loggable;
import org.slf4j.Logger;

public final class PersonMapper {

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
    personDo.setListFriend(getPersonDtoListFromDoList(personDTO.getListFriend()));

    return personDo;
  }

  public static PersonDTO getPersonDtoFromDo(final PersonDo personDo) {

    final PersonDTO personDTO = new PersonDTO();

    personDTO.setId(personDo.getIdperson());
    personDTO.setNomPerson(personDo.getNom());
    personDTO.setPrenomPerson(personDo.getPrenom());
    personDTO.setBirthDatePerson(personDo.getBirthDate());
    personDTO.setListFriend(getPersonDoListFromDTOList(personDo.getListFriend()));

    return personDTO;
  }

  private static Set<PersonDo> getPersonDtoListFromDoList(final Set<PersonDTO> l) {

  Set<PersonDo> returnList = null;
    
    if (l == null) {
      return returnList;
    }

    returnList = new HashSet<PersonDo>();
    
    for (PersonDTO p : l) {
      returnList.add(getPersonDoFromDto(p));
    }

    return returnList;
  }

  private static Set<PersonDTO> getPersonDoListFromDTOList(final Set<PersonDo> l) {
    
    Set<PersonDTO> returnList = null;
    
    if (l == null) {
      return returnList;
    }
    
    returnList = new HashSet<PersonDTO>();

    for (PersonDo p : l) {
      returnList.add(getPersonDtoFromDo(p));
    }

    return returnList;
  }

}
