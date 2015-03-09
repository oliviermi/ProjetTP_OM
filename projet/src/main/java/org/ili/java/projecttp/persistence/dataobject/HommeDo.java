package org.ili.java.projecttp.persistence.dataobject;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * @author Olivier MICHALSKI
 *
 */
public class HommeDo extends PersonDo {

  private static final long   serialVersionUID = 1131889898985207102L;

  @NotNull
  @Column(name = "sexeperson")
  private static final String SEXE             = "Masculin";
}
