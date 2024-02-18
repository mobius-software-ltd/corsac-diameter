package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterInteger32Impl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AdjustRoamingType;

/**
*
* @author yulian oifa
*
*/
public class AdjustRoamingTypeImpl extends DiameterInteger32Impl implements AdjustRoamingType
{
	protected AdjustRoamingTypeImpl()
	{
		super();
	}

	protected AdjustRoamingTypeImpl(Integer minValue, Integer maxValue)
	{
		super(minValue, maxValue);
	}

	public AdjustRoamingTypeImpl(Integer value, Integer minValue, Integer maxValue)
	{
		super(value, minValue, maxValue);
	}
}