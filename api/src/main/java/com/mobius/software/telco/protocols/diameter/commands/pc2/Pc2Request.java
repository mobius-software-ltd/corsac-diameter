package com.mobius.software.telco.protocols.diameter.commands.pc2;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.BannedUserTarget;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.ProSeRequestTypeEnum;

/**
*
* @author yulian oifa
*
*/

public abstract interface Pc2Request extends AuthenticationRequest
{
	public AuthSessionStateEnum getAuthSessionState(); 
	
	public void setAuthSessionState(AuthSessionStateEnum value) throws MissingAvpException; 
	
	public ProSeRequestTypeEnum getProSeRequestType();
	 
	void setProSeRequestType(ProSeRequestTypeEnum value) throws MissingAvpException;

	public String getRequestingRPAUID();
	 
	void setRequestingRPAUID(String value);
	
	public List<BannedUserTarget> getBannedUserTarget();
	 
	void setBannedUserTarget(List<BannedUserTarget> value);	
}