package com.mobius.software.telco.protocols.diameter.impl.commands;

import com.mobius.software.telco.protocols.diameter.commands.DiameterErrorAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;

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
public class DiameterErrorAnswerImpl extends DiameterAnswerBase implements DiameterErrorAnswer
{
	private Long applicationID;
	
	protected Integer commandCode;
	
	public DiameterErrorAnswerImpl(Long applicationID,Integer commandCode,String originHost,String originRealm,Boolean isRetransmit,Long resultCode) throws MissingAvpException
	{
		super(originHost, originRealm, isRetransmit , resultCode);
		
		this.applicationID = applicationID;		
		this.commandCode = commandCode;
	}

	@Override
	public Integer getCommandCode()
	{
		return commandCode;
	}

	@Override
	public Long getApplicationId()
	{
		return applicationID;
	}
}