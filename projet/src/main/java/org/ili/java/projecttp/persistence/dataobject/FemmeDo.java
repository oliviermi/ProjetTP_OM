package org.ili.java.projecttp.persistence.dataobject;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * @author Olivier MICHALSKI
 *
 */
public class FemmeDo extends PersonDo {

  private static final long   serialVersionUID = -6331753782922538604L;

  @NotNull
  @Column(name = "sexeperson")
  private static final String SEXE             = "Feminin";
}
