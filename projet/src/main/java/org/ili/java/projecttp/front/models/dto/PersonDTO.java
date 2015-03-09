package org.ili.java.projecttp.front.models.dto;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Olivier MICHALSKI
 *
 */
public class PersonDTO {

  //textbox
  private Integer        id;

  //textbox
  @NotNull
  @NotEmpty
  @NotBlank
  private String         nomPerson;

  //textbox
  @Past
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private Date           birthDatePerson;

  @NotNull
  @NotEmpty
  @NotBlank
  private String         prenomPerson;

  @Null
  private Set<PersonDTO> listFriend;

  /**
   * @return the nomPerson
   */
  public String getNomPerson() {
    return nomPerson;
  }

  /**
   * @param nomPerson the nomPerson to set
   */
  public void setNomPerson(final String nomPerson) {
    this.nomPerson = nomPerson;
  }

  /**
   * @return the prenomPerson
   */
  public String getPrenomPerson() {
    return prenomPerson;
  }

  /**
   * @param prenomPerson the prenomPerson to set
   */
  public void setPrenomPerson(final String prenomPerson) {
    this.prenomPerson = prenomPerson;
  }

  /**
   * @return the birthDatePerson
   */
  public Date getBirthDatePerson() {
    return birthDatePerson;
  }

  /**
   * @param birthDatePerson the birthDatePerson to set
   */
  public void setBirthDatePerson(final Date birthDatePerson) {
    this.birthDatePerson = birthDatePerson;
  }

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(final Integer id) {
    this.id = id;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder();
    builder.append("PersonDTO [id=");
    builder.append(id);
    builder.append(", nomPerson=");
    builder.append(nomPerson);
    builder.append(", prenomPerson=");
    builder.append(prenomPerson);
    builder.append(", birthDatePerson=");
    builder.append(birthDatePerson);
    builder.append("]");
    return builder.toString();
  }

  /**
   * @return the listFriend
   */
  public Set<PersonDTO> getListFriend() {
    return listFriend;
  }

  /**
   * @param listFriend the listFriend to set
   */
  public void setListFriend(final Set<PersonDTO> listFriend) {
    this.listFriend = listFriend;
  }

}
