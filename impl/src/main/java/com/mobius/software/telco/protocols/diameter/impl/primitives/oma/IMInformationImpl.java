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
import com.mobius.software.telco.protocols.diameter.primitives.oma.IMInformation;
import com.mobius.software.telco.protocols.diameter.primitives.oma.NumberOfMessagesSuccessfullyExploded;
import com.mobius.software.telco.protocols.diameter.primitives.oma.NumberOfMessagesSuccessfullySent;
import com.mobius.software.telco.protocols.diameter.primitives.oma.TotalNumberOfMessagesExploded;
import com.mobius.software.telco.protocols.diameter.primitives.oma.TotalNumberOfMessagesSent;

/**
*
* @author yulian oifa
*
*/
public class IMInformationImpl extends DiameterAvpImpl implements IMInformation
{
	private TotalNumberOfMessagesSent totalNumberOfMessagesSent;
	private TotalNumberOfMessagesExploded totalNumberOfMessagesExploded;
	private NumberOfMessagesSuccessfullySent numberOfMessagesSuccessfullySent;
	private NumberOfMessagesSuccessfullyExploded numberOfMessagesSuccessfullyExploded;
					
	public IMInformationImpl()
	{
		
	}
	
	public Long getTotalNumberOfMessagesSent()
	{
		if(totalNumberOfMessagesSent == null)
			return null;
		
		return totalNumberOfMessagesSent.getUnsigned();
	}
	
	public void setTotalNumberOfMessagesSent(Long value)
	{
		if(value==null)
			this.totalNumberOfMessagesSent = null;
		else
			this.totalNumberOfMessagesSent = new TotalNumberOfMessagesSentImpl(value, null, null);			
	}
	
	public Long getTotalNumberOfMessagesExploded()
	{
		if(totalNumberOfMessagesExploded == null)
			return null;
		
		return totalNumberOfMessagesExploded.getUnsigned();
	}
	
	public void setTotalNumberOfMessagesExploded(Long value)
	{
		if(value==null)
			this.totalNumberOfMessagesExploded = null;
		else
			this.totalNumberOfMessagesExploded = new TotalNumberOfMessagesExplodedImpl(value, null, null);			
	}
	
	public Long getNumberOfMessagesSuccessfullySent()
	{
		if(numberOfMessagesSuccessfullySent == null)
			return null;
		
		return numberOfMessagesSuccessfullySent.getUnsigned();
	}
	
	public void setNumberOfMessagesSuccessfullySent(Long value)
	{
		if(value==null)
			this.numberOfMessagesSuccessfullySent = null;
		else
			this.numberOfMessagesSuccessfullySent = new NumberOfMessagesSuccessfullySentImpl(value, null, null);			
	}
	
	public Long getNumberOfMessagesSuccessfullyExploded()
	{
		if(numberOfMessagesSuccessfullyExploded == null)
			return null;
		
		return numberOfMessagesSuccessfullyExploded.getUnsigned();
	}
	
	public void setNumberOfMessagesSuccessfullyExploded(Long value)
	{
		if(value==null)
			this.numberOfMessagesSuccessfullyExploded = null;
		else
			this.numberOfMessagesSuccessfullyExploded = new NumberOfMessagesSuccessfullyExplodedImpl(value, null, null);			
	}
}