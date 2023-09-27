package com.mobius.software.telco.protocols.diameter.impl.primitives.gx;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MaxRequestedBandwidthDLImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MaxRequestedBandwidthULImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultQoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultQoSName;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSClassIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSClassIdentifierEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxRequestedBandwidthDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxRequestedBandwidthUL;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2816L, vendorId = KnownVendorIDs.TGPP_ID)
public class DefaultQoSInformationImpl extends DiameterGroupedAvpImpl implements DefaultQoSInformation
{
	private QoSClassIdentifier qosClassIdentifier;
	private MaxRequestedBandwidthUL maxRequestedBandwidthUL;
	private MaxRequestedBandwidthDL maxRequestedBandwidthDL;
	private DefaultQoSName defaultQoSName;
		
	public DefaultQoSInformationImpl()
	{
		
	}
	
	public QoSClassIdentifierEnum getQoSClassIdentifier()
	{
		if(qosClassIdentifier==null)
			return null;
		
		return qosClassIdentifier.getEnumerated(QoSClassIdentifierEnum.class);
	}
	
	public void setQoSClassIdentifier(QoSClassIdentifierEnum value)
	{
		if(value==null)
			this.qosClassIdentifier = null;
		else
			this.qosClassIdentifier = new QoSClassIdentifierImpl(value, null, null);			
	}
	
	public Long getMaxRequestedBandwidthUL()
	{
		if(maxRequestedBandwidthUL==null)
			return null;
		
		return maxRequestedBandwidthUL.getUnsigned();
	}
	
	public void setMaxRequestedBandwidthUL(Long value)
	{
		if(value==null)
			this.maxRequestedBandwidthUL = null;
		else
			this.maxRequestedBandwidthUL = new MaxRequestedBandwidthULImpl(value, null, null);			
	}
	
	public Long getMaxRequestedBandwidthDL()
	{
		if(maxRequestedBandwidthDL==null)
			return null;
		
		return maxRequestedBandwidthDL.getUnsigned();
	}
	
	public void setMaxRequestedBandwidthDL(Long value)
	{
		if(value==null)
			this.maxRequestedBandwidthDL = null;
		else
			this.maxRequestedBandwidthDL = new MaxRequestedBandwidthDLImpl(value, null, null);			
	}
	
	public String getDefaultQoSName()
	{
		if(defaultQoSName==null)
			return null;
		
		return defaultQoSName.getString();
	}
	
	public void setDefaultQoSName(String value)
	{
		if(value==null)
			this.defaultQoSName = null;
		else
			this.defaultQoSName = new DefaultQoSNameImpl(value, null, null);			
	}
}