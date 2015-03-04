package org.ili.java.projecttp.front.models.dto;

import java.util.Date;

/**
 * @author Olivier MICHALSKI
 *
 */
public class PersonDTO {

  //textbox
  private Integer id;
  
  //textbox
  private String nomPerson;

  //textbox
  private String prenomPerson;

  //textbox
  private Date birthDatePerson;

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
  public void setId(Integer id) {
    this.id = id;
  }
}
