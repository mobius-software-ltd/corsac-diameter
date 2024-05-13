package com.mobius.software.telco.protocols.diameter.impl.primitives.np;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.np.AggregatedCongestionInfo;
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLocationId;
import com.mobius.software.telco.protocols.diameter.primitives.np.IMSIList;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class AggregatedCongestionInfoImpl extends DiameterGroupedAvpImpl implements AggregatedCongestionInfo
{
	private CongestionLocationId congestionLocationId;
	
	private IMSIList imsiList;
	
	public AggregatedCongestionInfoImpl()
	{
		
	}
	
	public CongestionLocationId getCongestionLocationId()
	{
		return this.congestionLocationId;
	}
	
	public void setCongestionLocationId(CongestionLocationId value)
	{
		this.congestionLocationId = value;
	}
	
	public ByteBuf getIMSIList()
	{
		if(imsiList == null)
			return null;
		
		return imsiList.getValue();
	}
	
	public void setIMSIList(ByteBuf value)
	{
		if(value == null)
			this.imsiList = null;
		else
			this.imsiList = new IMSIListImpl(value, null, null);
	}
}