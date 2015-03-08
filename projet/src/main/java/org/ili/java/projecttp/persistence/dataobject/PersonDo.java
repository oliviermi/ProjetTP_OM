package org.ili.java.projecttp.persistence.dataobject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.annotations.IndexColumn;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

import javax.persistence.OneToMany;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;

@Table(name = "person")
@NamedQuery(name = "Person.findAll", query = "SELECT p FROM PersonDo p")
@Entity
public class PersonDo implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -1347457951201299553L;

  @Id
  @GeneratedValue
  private int               idperson;

  @NotNull
  @Column(name = "nomperson")
  private String            nom;

  @NotNull
  @Column(name = "prenomperson")
  private String            prenom;

  @NotNull
  @Past
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  @Column(name = "birthdateperson")
  private Date              birthDate;

 
//  @ManyToMany(cascade = ALL)
//  @JoinTable(name = "friends", 
//            joinColumns = @JoinColumn(name = "idperson1", referencedColumnName = "idperson"), 
//            inverseJoinColumns = @JoinColumn(name = "idperson2", referencedColumnName = "idperson"))
//  private List<PersonDo>    listFriend;

  
  @OneToMany(cascade = ALL, fetch = EAGER)
  @JoinTable(name = "friends", joinColumns = {@JoinColumn(name = "idperson1", 
                                                          referencedColumnName = "idperson"),
                                              @JoinColumn(name = "idperson2", 
                                              referencedColumnName = "idperson")}, 
                               inverseJoinColumns = {@JoinColumn(name = "idperson1", 
                                                                 referencedColumnName = "idperson"),
                                                     @JoinColumn(name = "idperson2", referencedColumnName = "idperson")})
  private List<PersonDo>    listFriend;
  
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

  /**
   * @return the birthDate
   */
  public Date getBirthDate() {
    return birthDate;
  }

  /**
   * @param birthDate the birthDate to set
   */
  public void setBirthDate(final Date birthDate) {
    this.birthDate = birthDate;
  }

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
    builder.append(birthDate);
    builder.append("]");
    return builder.toString();
  }

  /**
   * @return
   */
  public Map<String, Object> propertiesToMap() {
    final Map<String, Object> propertiesMap = new HashMap<String, Object>();
    final PersonDo obj = this;
    ReflectionUtils.doWithFields(PersonDo.class, new FieldCallback() {

      public void doWith(final Field field) throws IllegalAccessException {
        // make the field accessible if defined private
        ReflectionUtils.makeAccessible(field);

        if (field.getAnnotation(Column.class) != null) {
          propertiesMap.put(field.getAnnotation(Column.class).name(), field.get(obj));
        }
      }
    });

    return propertiesMap;
  }

  /**
   * @return the listFriend
   */
  public List<PersonDo> getListFriend() {
    return listFriend;
  }

  /**
   * @param listFriend the listFriend to set
   */
  public void setListFriend(List<PersonDo> listFriend) {
    this.listFriend = listFriend;
  }

  //  /**
  //   * @return the listFriend
  //   */
  //  public List<PersonDo> getListFriend() {
  //    return listFriend;
  //  }
  //
  //  /**
  //   * @param listFriend the listFriend to set
  //   */
  //  public void setListFriend(List<PersonDo> listFriend) {
  //    this.listFriend = listFriend;
  //  }

}
