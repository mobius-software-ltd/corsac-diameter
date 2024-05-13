package com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c;
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

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSFlowIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSServiceAreaImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSStartStopIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.TMGIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.MBMSCellListImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSFlowIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSServiceArea;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSStartStopIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSStartStopIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.TMGI;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.FECRequest;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.LocalM1Information;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.LocalMB2UInformation;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MB2USecurity;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerRequest;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSStartTime;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.ROHCMaxCID;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.ROHCRequest;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSCellList;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class MBMSBearerRequestImpl extends DiameterGroupedAvpImpl implements MBMSBearerRequest
{
	private MBMSStartStopIndication mbmsStartStopIndication;
	private TMGI tmgi;
	private MBMSFlowIdentifier mbmsFlowIdentifier;
	private QoSInformation qosInformation;
	private MBMSServiceArea mbmsServiceArea;
	private MBMSStartTime mbmsStartTime;
	private MB2USecurity mb2uSecurity;
	private MBMSCellList mbmsCellList;
	private LocalM1Information localM1Information;
	private LocalMB2UInformation localMB2UInformation;
	private FECRequest fecRequest;
	private List<ROHCRequest> rohcRequest;
	private ROHCMaxCID rohcMaxCID;
    		
	protected MBMSBearerRequestImpl()
	{
		
	}
	
	public MBMSBearerRequestImpl(MBMSStartStopIndicationEnum mbmsStartStopIndication) throws MissingAvpException
	{
		setMBMSStartStopIndication(mbmsStartStopIndication);
	}
	
	public MBMSStartStopIndicationEnum getMBMSStartStopIndication()
	{
		if(mbmsStartStopIndication==null)
			return null;
		
		return mbmsStartStopIndication.getEnumerated(MBMSStartStopIndicationEnum.class);
	}
	
	public void setMBMSStartStopIndication(MBMSStartStopIndicationEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("MBMS-StartStop-Indication is required", Arrays.asList(new DiameterAvp[] { new MBMSStartStopIndicationImpl() }));
			
		this.mbmsStartStopIndication = new MBMSStartStopIndicationImpl(value, null, null);	
	}
	
	public ByteBuf getTMGI()
	{
		if(tmgi==null)
			return null;
		
		return tmgi.getValue();
	}
	
	public void setTMGI(ByteBuf value)
	{
		if(value==null)
			this.tmgi = null;
		else
			this.tmgi = new TMGIImpl(value, null, null);			
	}
	
	public ByteBuf getMBMSFlowIdentifier()
	{
		if(mbmsFlowIdentifier==null)
			return null;
		
		return mbmsFlowIdentifier.getValue();
	}
	
	public void setMBMSFlowIdentifier(ByteBuf value)
	{
		if(value==null)
			this.mbmsFlowIdentifier = null;
		else
			this.mbmsFlowIdentifier = new MBMSFlowIdentifierImpl(value, null, null);			
	}
	
	public QoSInformation getQOSInformation()
	{
		return qosInformation;
	}
	
	public void setQOSInformation(QoSInformation value)
	{
		this.qosInformation = value;
	}
	
	public ByteBuf getMBMSServiceArea()
	{
		if(mbmsServiceArea==null)
			return null;
		
		return mbmsServiceArea.getValue();
	}
	
	public void setMBMSServiceArea(ByteBuf value)
	{
		if(value==null)
			this.mbmsServiceArea = null;
		else
			this.mbmsServiceArea = new MBMSServiceAreaImpl(value, null, null);			
	}
	
	public Date getMBMSStartTime()
	{
		if(mbmsStartTime==null)
			return null;
		
		return mbmsStartTime.getDateTime();
	}
	
	public void setMBMSStartTime(Date value)
	{
		if(value==null)
			this.mbmsStartTime = null;
		else
			this.mbmsStartTime = new MBMSStartTimeImpl(value, null, null);			
	}
	
	public Long getMB2USecurity()
	{
		if(mb2uSecurity==null)
			return null;
		
		return mb2uSecurity.getUnsigned();
	}
	
	public void setMB2USecurity(Long value)
	{
		if(value==null)
			this.mb2uSecurity = null;
		else
			this.mb2uSecurity = new MB2USecurityImpl(value, null, null);			
	}
	
	public ByteBuf getMBMSCellList()
	{
		if(mbmsCellList==null)
			return null;
		
		return mbmsCellList.getValue();
	}
	
	public void setMBMSCellList(ByteBuf value)
	{
		if(value==null)
			this.mbmsCellList = null;
		else
			this.mbmsCellList = new MBMSCellListImpl(value, null, null);			
	}
	
	public LocalM1Information getLocalM1Information()
	{
		return localM1Information;
	}
	
	public void setLocalM1Information(LocalM1Information value)
	{
		this.localM1Information = value;		
	}
	
	public LocalMB2UInformation getLocalMB2UInformation()
	{
		return localMB2UInformation;
	}
	
	public void setLocalMB2UInformation(LocalMB2UInformation value)
	{
		this.localMB2UInformation = value;		
	}
	
	public ByteBuf getFECRequest()
	{
		if(fecRequest==null)
			return null;
		
		return fecRequest.getValue();
	}
	
	public void setFECRequest(ByteBuf value)
	{
		if(value==null)
			this.fecRequest = null;
		else
			this.fecRequest = new FECRequestImpl(value, null, null);			
	}
	
	public List<ROHCRequest> getROHCRequest()
	{
		return rohcRequest;
	}
	
	public void setROHCRequest(List<ROHCRequest> value)
	{
		this.rohcRequest = value;
	}
	
	public Long getROHCMaxCID()
	{
		if(rohcMaxCID==null)
			return null;
		
		return rohcMaxCID.getUnsigned();
	}
	
	public void setROHCMaxCID(Long value)
	{
		if(value==null)
			this.rohcMaxCID = null;
		else
			this.rohcMaxCID = new ROHCMaxCIDImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(mbmsStartStopIndication==null)
			return new MissingAvpException("MBMS-StartStop-Indication is required", Arrays.asList(new DiameterAvp[] { new MBMSStartStopIndicationImpl() }));
		
		return null;
	}
}