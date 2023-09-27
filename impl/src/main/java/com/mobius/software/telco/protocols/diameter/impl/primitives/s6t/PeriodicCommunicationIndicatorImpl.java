package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterEnumeratedImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PeriodicCommunicationIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PeriodicCommunicationIndicatorEnum;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3115L, vendorId = KnownVendorIDs.TGPP_ID)
public class PeriodicCommunicationIndicatorImpl extends DiameterEnumeratedImpl<PeriodicCommunicationIndicatorEnum> implements PeriodicCommunicationIndicator
{
	protected PeriodicCommunicationIndicatorImpl()
	{
		super();
	}

	protected PeriodicCommunicationIndicatorImpl(Integer minValue, Integer maxValue)
	{
		super(minValue, maxValue);
	}

	public PeriodicCommunicationIndicatorImpl(PeriodicCommunicationIndicatorEnum value, Integer minValue, Integer maxValue)
	{
		super(value, minValue, maxValue);
	}
}