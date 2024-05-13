package com.mobius.software.telco.protocols.diameter;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;

@DiameterAvpDefinition(code = OneM2MAvpCodes.ACCESS_NETWORK_IDENTIFIER, vendorId = VendorIDs.ONEM2M_ID, name = "Access-Network-Identifier")
public interface AvpInterface 
{
	
}
