package org.ili.java.projecttp.persistence.dataobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "person")
public class PersonDo implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -1347457951201299553L;

  @Id
  @GeneratedValue
  private int    idperson;

  @Column(name = "nomperson")
  private String nom;

  @Column(name = "prenomperson")
  private String prenom;

  //@Column(name = "birthdateperson")
  //private Date birthDate;

  public PersonDo() {

  }

  public PersonDo(final String nom, final String prenom) {
    this.nom = nom;
    this.prenom = prenom;
  }

  /**
   * @return the idperson
   */
  public int getIdperson() {
    return idperson;
  }

  /**
   * @param idperson the idperson to set
   */
  public void setIdperson(final int idperson) {
    this.idperson = idperson;
  }

  /**
   * @return the nom
   */
  public String getNom() {
    return nom;
  }

  /**
   * @param nom the nom to set
   */
  public void setNom(final String nom) {
    this.nom = nom;
  }

  /**
   * @return the prenom
   */
  public String getPrenom() {
    return prenom;
  }

  /**
   * @param prenom the prenom to set
   */
  public void setPrenom(final String prenom) {
    this.prenom = prenom;
  }

  //	/**
  //	 * @return the birthDate
  //	 */
  //	public Date getBirthDate() {
  //		return birthDate;
  //	}
  //
  //	/**
  //	 * @param birthDate the birthDate to set
  //	 */
  //	public void setBirthDate(final Date birthDate) {
  //		this.birthDate = birthDate;
  //	}

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder();
    builder.append("PersonDo [idperson=");
    builder.append(idperson);
    builder.append(", nom=");
    builder.append(nom);
    builder.append(", prenom=");
    builder.append(prenom);
    builder.append(", birthDate=");
    //builder.append(birthDate);
    builder.append("]");
    return builder.toString();
  }

}
