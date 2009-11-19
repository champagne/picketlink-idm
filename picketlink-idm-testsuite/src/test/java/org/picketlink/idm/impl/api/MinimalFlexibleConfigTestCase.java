/*
* JBoss, a division of Red Hat
* Copyright 2006, Red Hat Middleware, LLC, and individual contributors as indicated
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/

package org.picketlink.idm.impl.api;

import org.picketlink.idm.impl.IdentityTestPOJO;
import org.picketlink.idm.impl.configuration.IdentityConfigurationImpl;
import org.picketlink.idm.api.IdentitySessionFactory;
import org.jboss.unit.api.pojo.annotations.Create;
import org.jboss.unit.api.pojo.annotations.Destroy;
import org.jboss.unit.api.pojo.annotations.Test;
import org.jboss.unit.api.pojo.annotations.Parameter;

/**
 * @author <a href="mailto:boleslaw.dawidowicz at redhat.com">Boleslaw Dawidowicz</a>
 * @version : 0.1 $
 */
public class MinimalFlexibleConfigTestCase extends IdentityTestPOJO implements APITestContext
{
   private OrganizationTest orgTest;

   private PersistenceManagerTest persistenceManagerTest;

   private RelationshipManagerTest relationshipManagerTest;

   private RoleManagerTest roleManagerTest;

   private UserQueryTest userQueryTest;

   private GroupQueryTest groupQueryTest;

   private RoleQueryTest roleQueryTest;

   private IdentitySessionFactory identitySessionFactory;

   @Create
   public void setUp() throws Exception
   {
      setIdentityConfig("minimal-flexible-identity-config.xml");
      setRealmName("realm://FlexibleRealm");

      super.start();

      orgTest = new OrganizationTest(this);

      persistenceManagerTest = new PersistenceManagerTest(this);
      relationshipManagerTest = new RelationshipManagerTest(this);
      roleManagerTest = new RoleManagerTest(this);

      userQueryTest = new UserQueryTest(this);
      groupQueryTest = new GroupQueryTest(this);
      roleQueryTest = new RoleQueryTest(this);

      identitySessionFactory = new IdentityConfigurationImpl().
         configure(getIdentityConfig()).buildIdentitySessionFactory();
   }

   @Destroy
   public void tearDown() throws Exception
   {
      super.stop();
   }

   public IdentitySessionFactory getIdentitySessionFactory()
   {
      return identitySessionFactory;
   }

   @Test
   public void testOrganization() throws Exception
   {

      orgTest.testRedHatOrganization(getRealmName());
   }

   @Test
   public void testSamplePortal() throws Exception
   {

      orgTest.testSamplePortal(getRealmName());
   }

   @Test
   public void testPersistenceManager() throws Exception
   {
      persistenceManagerTest.testMethods(getRealmName());
   }

   @Test
   public void testRelationshipManager() throws Exception
   {
      relationshipManagerTest.testMethods(getRealmName());
   }

   @Test
   public void testRelationshipManagerCascade() throws Exception
   {
      relationshipManagerTest.testCascade(getRealmName());
   }

   @Test
   public void testRelationshipManagerMergedRoleAssociations() throws Exception
   {
      relationshipManagerTest.testMergedRoleAssociations(getRealmName());
   }

   @Test
   public void testRoleManager() throws Exception
   {
      roleManagerTest.testMethods(getRealmName());
   }

   @Test
   public void testUserQuery() throws Exception
   {
      userQueryTest.testQuery(getRealmName());
   }

   @Test
   public void testGroupQuery() throws Exception
   {
      groupQueryTest.testQuery(getRealmName());
   }

   @Test
   public void testRoleQuery() throws Exception
   {
      roleQueryTest.testQuery(getRealmName());
   }

}