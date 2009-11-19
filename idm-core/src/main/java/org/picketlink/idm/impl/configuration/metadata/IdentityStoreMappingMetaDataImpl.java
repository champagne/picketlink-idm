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

package org.jboss.identity.idm.impl.configuration.metadata;

import org.jboss.identity.idm.spi.configuration.metadata.IdentityStoreMappingMetaData;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;

/**
 * @author <a href="mailto:boleslaw.dawidowicz at redhat.com">Boleslaw Dawidowicz</a>
 * @version : 0.1 $
 */
public class IdentityStoreMappingMetaDataImpl implements IdentityStoreMappingMetaData, Serializable
{
   private String identityStoreId;

   private List<String> identityObjectTypeMappings = new LinkedList<String>();

   private Map<String, List<String>> options = new HashMap<String, List<String>>();

   public IdentityStoreMappingMetaDataImpl()
   {
   }

   public void setIdentityStoreId(String identityStoreId)
   {
      this.identityStoreId = identityStoreId;
   }

   public void setIdentityObjectTypeMappings(List<String> identityObjectTypeMappings)
   {
      this.identityObjectTypeMappings = identityObjectTypeMappings;
   }

   public void setOptions(Map<String, List<String>> options)
   {
      this.options = options;
   }

   public String getIdentityStoreId()
   {
      return identityStoreId;
   }

   public List<String> getIdentityObjectTypeMappings()
   {
      return identityObjectTypeMappings;
   }

   public Map<String, List<String>> getOptions()
   {
      return options;
   }

   public List<String> getOption(String optionName)
   {
      if (options != null )
      {
         return options.get(optionName);
      }

      return null;
   }

   public String getOptionSingleValue(String optionName)
   {
      List<String> values = getOption(optionName);

      if (values != null && values.size() > 0)
      {
         return values.get(0);
      }

      return null;
   }


}
