package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterTimeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReferenceIDValidityTime;

/**
*
* @author yulian oifa
*
*/
public class ReferenceIDValidityTimeImpl extends DiameterTimeImpl implements ReferenceIDValidityTime
{
	protected ReferenceIDValidityTimeImpl()
	{
		super();
	}

	protected ReferenceIDValidityTimeImpl(Long minValue, Long maxValue)
	{
		super(minValue, maxValue);
	}

	public ReferenceIDValidityTimeImpl(Date value, Long minValue, Long maxValue)
	{
		super(value, minValue, maxValue);
	}
}