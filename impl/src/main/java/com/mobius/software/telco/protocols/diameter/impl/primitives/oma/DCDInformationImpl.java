package com.mobius.software.telco.protocols.diameter.impl.primitives.oma;
/*
 * Mobius Software LTD
 * Copyright 2023, Mobius Software LTD and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.oma.ContentID;
import com.mobius.software.telco.protocols.diameter.primitives.oma.ContentProviderID;
import com.mobius.software.telco.protocols.diameter.primitives.oma.DCDInformation;

/**
*
* @author yulian oifa
*
*/
public class DCDInformationImpl extends DiameterAvpImpl implements DCDInformation
{
	private ContentID contentID;
	private ContentProviderID contentProviderID;
					
	public DCDInformationImpl()
	{
		
	}
	
	public String getContentID()
	{
		if(contentID == null)
			return null;
		
		return contentID.getString();
	}
	
	public void setContentID(String value)
	{
		if(value==null)
			this.contentID = null;
		else
			this.contentID = new ContentIDImpl(value, null, null);			
	}
	
	public String getContentProviderID()
	{
		if(contentProviderID == null)
			return null;
		
		return contentProviderID.getString();
	}
	
	public void setContentProviderID(String value)
	{
		if(value==null)
			this.contentProviderID = null;
		else
			this.contentProviderID = new ContentProviderIDImpl(value, null, null);			
	}
}