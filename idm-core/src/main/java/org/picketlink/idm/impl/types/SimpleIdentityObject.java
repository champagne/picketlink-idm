/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2008, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors. 
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
package org.jboss.identity.idm.impl.types;

import org.jboss.identity.idm.common.exception.PolicyValidationException;
import org.jboss.identity.idm.spi.model.IdentityObject;
import org.jboss.identity.idm.spi.model.IdentityObjectType;

import java.io.Serializable;


/**
 * Very simple identity object
 *
 * @author boleslaw dot dawidowicz at redhat anotherdot com
 *
 * @since Aug 6, 2008
 */
public class SimpleIdentityObject implements IdentityObject, Serializable
{

   private final String name;

   private final String id;

   private final IdentityObjectType type;

   public SimpleIdentityObject(String name, String id, IdentityObjectType type)
   {
      if (name == null)
      {
         throw new IllegalArgumentException("name is null");
      }
      if (type == null)
      {
         throw new IllegalArgumentException("type is null");
      }

      this.name = name;
      this.id = id;
      this.type = type;
   }

   public SimpleIdentityObject(String name, IdentityObjectType type)
   {
      if (name == null)
      {
         throw new IllegalArgumentException("name is null");
      }
      if (type == null)
      {
         throw new IllegalArgumentException("type is null");
      }

      this.name = name;
      this.type = type;
      this.id = null;
   }

   public String getName()
   {
      return name;
   }

   public String getId()
   {
      return id;
   }

   public IdentityObjectType getIdentityType()
   {
      return type;
   }

   public void validatePolicy() throws PolicyValidationException
   {

   }

   @Override
   public String toString()
   {
      return "IdentityObject[id=" + getId() + "; name="  + getName() + "; type=" + getIdentityType().getName() + "]";
   }
}