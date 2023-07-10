package com.mobius.software.telco.protocols.diameter.commands;
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

import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/
public interface DiameterMessage extends DiameterGroupedAvp
{
	public Boolean getIsRetransmit();
	
	public Long getHopByHopIdentifier();
	
	public Long getEndToEndIdentifier();
	
	void setIsRetransmit(Boolean value);
	
	void setHopByHopIdentifier(Long value);
	
	void setEndToEndIdentifier(Long value);
	
	public String getOriginHost();
	
	void setOriginHost(String value);
	
	public String getOriginRealm();
	
	void setOriginRealm(String value);
	
	public String getSessionId();
	
	void setSessionId(String value);
}