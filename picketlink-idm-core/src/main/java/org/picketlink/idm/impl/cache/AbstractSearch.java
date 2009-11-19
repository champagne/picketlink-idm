/*
* JBoss, a division of Red Hat
* Copyright 2009, Red Hat Middleware, LLC, and individual contributors as indicated
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


package org.picketlink.idm.impl.cache;

import org.picketlink.idm.api.IdentitySearchCriteria;

import java.io.Serializable;

public abstract class AbstractSearch implements Serializable
{
   private IdentitySearchCriteria searchCriteria;

   public IdentitySearchCriteria getSearchCriteria()
   {
      return searchCriteria;
   }

   public void setSearchCriteria(IdentitySearchCriteria searchCriteria)
   {
      this.searchCriteria = searchCriteria;
   }

   @Override
   public int hashCode()
   {
      return searchCriteria != null ? searchCriteria.hashCode() : 0;
   }
}
