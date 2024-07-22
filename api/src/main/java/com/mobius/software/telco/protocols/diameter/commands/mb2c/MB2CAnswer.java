package com.mobius.software.telco.protocols.diameter.commands.mb2c;
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

import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;

/**
*
* @author yulian oifa
*
*/
public interface MB2CAnswer extends AuthenticationAnswer
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value) throws MissingAvpException;
	
	public Long getRestartCounter();
	
	void setRestartCounter(Long value);
}