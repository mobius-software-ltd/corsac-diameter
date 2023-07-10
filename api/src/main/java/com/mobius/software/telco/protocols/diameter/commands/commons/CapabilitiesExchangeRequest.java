package com.mobius.software.telco.protocols.diameter.commands.commons;
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

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;

/**
*
* @author yulian oifa
*
*/
@DiameterCommandDefinition(applicationId = -1, commandCode = 257, request = true, proxyable = false, name="Capabilities-Exchange-Request")
public interface CapabilitiesExchangeRequest extends DiameterMessage
{
	public List<InetAddress> getHostIpAddresses();
	
	void setHostIpAddress(List<InetAddress> value);
	
	public Long getVendorId();
	
	void setVendorId(Long value);
	
	public String getProductName();
	
	void setProductName(String value);
	
	public Long getOriginStateId();
	
	void setOriginStateId(Long value);
	
	public List<Long> getSupportedVendorIds();
	
	void setSupportedVendorIds(List<Long> value);
	
	public List<Long> getAuthApplicationIds();
	
	void setAuthApplicationIds(List<Long> value);
	
	public List<Long> getAcctApplicationIds();
	
	void setAcctApplicationIds(List<Long> value);
	
	public List<Long> getInbandSecurityIds();
	
	void setInbandSecurityIds(List<Long> value);

	public List<VendorSpecificApplicationId> getVendorSpecificApplicationIds();
	
	void setVendorSpecificApplicationIds(List<VendorSpecificApplicationId> value);

	public Long getFirmwareRevision();
	
	void setFirmwareRevision(Long value);	
}