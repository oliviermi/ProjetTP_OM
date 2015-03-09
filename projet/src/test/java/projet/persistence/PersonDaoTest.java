/**
 * 
 */
package projet.persistence;

import org.ili.java.projecttp.persistence.dao.impl.PersonDAO;
import org.ili.java.projecttp.persistence.dataobject.PersonDo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Olivier MICHALSKI
 *
 */
public class PersonDaoTest {

  @Autowired
  private PersonDAO personDAO;
  
  /**
   * @throws java.lang.Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    
  }

  /**
   * @throws java.lang.Exception
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    
  }

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
    
  }

  /**
   * Test method for {@link org.ili.java.projecttp.persistence.dao.impl.PersonDAO#countAll()}.
   */
  @Test
  public void testCountAll() {
   // fail("Not yet implemented");
  }

  /**
   * Test method for {@link org.ili.java.projecttp.persistence.dao.impl.PersonDAO#create(org.ili.java.projecttp.persistence.dataobject.PersonDo)}.
   * @throws Exception 
   */
  @Test
  public void testCreate() {
  personDAO.create(new PersonDo("michel", "henry"));
  
  }

  /**
   * Test method for {@link org.ili.java.projecttp.persistence.dao.impl.PersonDAO#find(java.lang.Integer)}.
   */
  @Test
  public void testFind() {
  //  fail("Not yet implemented");
  }

  /**
   * Test method for {@link org.ili.java.projecttp.persistence.dao.impl.PersonDAO#findAll()}.
   */
  @Test
  public void testFindAll() {
    //fail("Not yet implemented");
  }

  /**
   * Test method for {@link org.ili.java.projecttp.persistence.dao.impl.PersonDAO#update(org.ili.java.projecttp.persistence.dataobject.PersonDo)}.
   */
  @Test
  public void testUpdate() {
    //fail("Not yet implemented");
  }

  /**
   * Test method for {@link org.ili.java.projecttp.persistence.dao.impl.PersonDAO#delete(java.lang.Integer)}.
   */
  @Test
  public void testDelete() {
   // fail("Not yet implemented");
  }

  /**
   * Test method for {@link org.ili.java.projecttp.persistence.dao.impl.PersonDAO#exist(org.ili.java.projecttp.persistence.dataobject.PersonDo)}.
   */
  @Test
  public void testExist() {
    //fail("Not yet implemented");
  }

}
