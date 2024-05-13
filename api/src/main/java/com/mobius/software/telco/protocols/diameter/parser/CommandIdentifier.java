package com.mobius.software.telco.protocols.diameter.parser;
/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
public class CommandIdentifier
{
	private Integer commandCode;
	private Boolean isRequest;
	
	public CommandIdentifier(Integer commandCode, Boolean isRequest)
	{
		this.commandCode = commandCode;
		this.isRequest = isRequest;
	}

	public Integer getCommandCode()
	{
		return commandCode;
	}

	public void setCommandCode(Integer commandCode)
	{
		this.commandCode = commandCode;
	}

	public Boolean getIsRequest()
	{
		return isRequest;
	}

	public void setIsRequest(Boolean isRequest)
	{
		this.isRequest = isRequest;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commandCode == null) ? 0 : commandCode.hashCode());
		result = prime * result + ((isRequest == null) ? 0 : isRequest.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		CommandIdentifier other = (CommandIdentifier) obj;
		if (commandCode == null)
		{
			if (other.commandCode != null)
				return false;
		} 
		else if (!commandCode.equals(other.commandCode))
			return false;
		
		if (isRequest == null)
		{
			if (other.isRequest != null)
				return false;
		} 
		else if (!isRequest.equals(other.isRequest))
			return false;
		
		return true;
	}	
}