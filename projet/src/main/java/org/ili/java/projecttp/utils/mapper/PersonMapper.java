package org.ili.java.projecttp.utils.mapper;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.ili.java.projecttp.front.models.dto.PersonDTO;
import org.ili.java.projecttp.persistence.dataobject.PersonDo;

/**
 * @author Olivier MICHALSKI
 *
 */
public final class PersonMapper {

  /**
   * 
   */
  private PersonMapper() {
    //empty method
  }

  /**
   * @param personDTO
   * @return
   */
  public static PersonDo getPersonDoFromDto(final PersonDTO personDTO) {

    final PersonDo personDo = new PersonDo();

    if (personDTO.getId() != null) {

      personDo.setIdperson(personDTO.getId());
    }
    personDo.setNom(personDTO.getNomPerson());
    personDo.setPrenom(personDTO.getPrenomPerson());
    personDo.setBirthDate(personDTO.getBirthDatePerson());
    personDo.setListFriend((Set<PersonDo>) getPersonDtoListFromDoList(personDTO.getListFriend()));

    return personDo;
  }

  /**
   * @param personDo
   * @return
   */
  public static PersonDTO getPersonDtoFromDo(final PersonDo personDo) {

    final PersonDTO personDTO = new PersonDTO();

    personDTO.setId(personDo.getIdperson());
    personDTO.setNomPerson(personDo.getNom());
    personDTO.setPrenomPerson(personDo.getPrenom());
    personDTO.setBirthDatePerson(personDo.getBirthDate());
    personDTO.setListFriend((Set<PersonDTO>) getPersonDoListFromDTOList(personDo.getListFriend()));

    return personDTO;
  }

  /**
   * @param l
   * @return
   */
  public static Collection<PersonDo> getPersonDtoListFromDoList(final Collection<PersonDTO> l) {

   Collection<PersonDo> returnList = null;

    if (l == null) {
      return returnList;
    }

    returnList = new HashSet<PersonDo>();

    for (PersonDTO p : l) {
      returnList.add(getPersonDoFromDto(p));
    }

    return returnList;
  }

  /**
   * @param l
   * @return
   */
  public static Collection<PersonDTO> getPersonDoListFromDTOList(final Collection<PersonDo> l) {

    Collection<PersonDTO> returnList = null;

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
