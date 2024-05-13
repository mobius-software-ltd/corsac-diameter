package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RatingGroupImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccessNetworkIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ApplicationEntityID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ControlMemorySize;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CurrentNumberMembers;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DataMemorySize;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ExternalID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.GroupName;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.HostingCSEID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.M2MEventRecordTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.M2MInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MaximumNumberMembers;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NodeId;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.Occupancy;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OneM2MOriginator;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProtocolType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProtocolTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.Receiver;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RequestBodySize;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RequestHeadersSize;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RequestOperation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RequestOperationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ResponseBodySize;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ResponseHeadersSize;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ResponseStatusCode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ResponseStatusCodeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SubgroupName;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TargetID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RatingGroup;

/**
*
* @author yulian oifa
*
*/
public class M2MInformationImpl extends DiameterGroupedAvpImpl implements M2MInformation
{
	private ApplicationEntityID applicationEntityID;
	
	private ExternalID externalID;
	
	private Receiver receiver;
	
	private OneM2MOriginator originator;
	
	private HostingCSEID hostingCSEID;
	
	private TargetID targetID;
	
	private ProtocolType protocolType;
	
	private RequestOperation requestOperation;
	
	private RequestHeadersSize requestHeadersSize;
	
	private RequestBodySize requestBodySize;
	
	private ResponseHeadersSize responseHeadersSize;
	
	private ResponseBodySize responseBodySize;
	
	private ResponseStatusCode responseStatusCode;
	
	private RatingGroup ratingGroup;
	
	private M2MEventRecordTimestamp m2mEventRecordTimestamp;
	
	private ControlMemorySize controlMemorySize;
	
	private DataMemorySize dataMemorySize;
	
	private AccessNetworkIdentifier accessNetworkIdentifier;
	
	private Occupancy occupancy;
	
	private GroupName groupName;
	
	private MaximumNumberMembers maximumNumberMembers;
	
	private CurrentNumberMembers currentNumberMembers;
	
	private SubgroupName subgroupName;
	
	private NodeId nodeId;
		
	public M2MInformationImpl() 
	{
	}
	
	public String getApplicationEntityID()
	{
		if(this.applicationEntityID == null)
			return null;
		
		return this.applicationEntityID.getString();
	}
	
	public void setApplicationEntityID(String value)
	{
		if(value == null)
			this.applicationEntityID = null;
		else
			this.applicationEntityID = new ApplicationEntityIDImpl(value, null, null);
	}
	
	public String getExternalID()
	{
		if(this.externalID == null)
			return null;
		
		return this.externalID.getString();
	}
	
	public void setExternalID(String value)
	{
		if(value == null)
			this.externalID = null;
		else
			this.externalID = new ExternalIDImpl(value, null, null);
	}
	
	public String getReceiver()
	{
		if(this.receiver == null)
			return null;
		
		return this.receiver.getString();
	}
	
	public void setReceiver(String value)
	{
		if(value == null)
			this.receiver = null;
		else
			this.receiver = new ReceiverImpl(value, null, null);
	}	
	
	public String getOriginator()
	{
		if(this.originator == null)
			return null;
		
		return this.originator.getString();
	}
	
	public void setOriginator(String value)
	{
		if(value == null)
			this.originator = null;
		else
			this.originator = new OneM2MOriginatorImpl(value, null, null);
	}	
	
	public String getHostingCSEID()
	{
		if(this.hostingCSEID == null)
			return null;
		
		return this.hostingCSEID.getString();
	}
	
	public void setHostingCSEID(String value)
	{
		if(value == null)
			this.hostingCSEID = null;
		else
			this.hostingCSEID = new HostingCSEIDImpl(value, null, null);
	}
	
	public String getTargetID()
	{
		if(this.targetID == null)
			return null;
		
		return this.targetID.getString();
	}
	
	public void setTargetID(String value)
	{
		if(value == null)
			this.targetID = null;
		else
			this.targetID = new TargetIDImpl(value, null, null);
	}
	
	public ProtocolTypeEnum getProtocolType()
	{
		if(this.protocolType == null)
			return null;
		
		return this.protocolType.getEnumerated(ProtocolTypeEnum.class);
	}
	
	public void setProtocolType(ProtocolTypeEnum value)
	{
		if(value == null)
			this.protocolType = null;
		else
			this.protocolType = new ProtocolTypeImpl(value, null, null);
	}	
	
	public RequestOperationEnum getRequestOperation()
	{
		if(this.requestOperation == null)
			return null;
		
		return this.requestOperation.getEnumerated(RequestOperationEnum.class);
	}
	
	public void setRequestOperation(RequestOperationEnum value)
	{
		if(value == null)
			this.requestOperation = null;
		else
			this.requestOperation = new RequestOperationImpl(value, null, null);
	}
	
	public Long getRequestHeadersSize()
	{
		if(this.requestHeadersSize == null)
			return null;
		
		return this.requestHeadersSize.getUnsigned();
	}
	
	public void setRequestHeadersSize(Long value)
	{
		if(value == null)
			this.requestHeadersSize = null;
		else
			this.requestHeadersSize = new RequestHeadersSizeImpl(value, null, null);
	}
	
	public Long getRequestBodySize()
	{
		if(this.requestBodySize == null)
			return null;
		
		return this.requestBodySize.getUnsigned();
	}
	
	public void setRequestBodySize(Long value)
	{
		if(value == null)
			this.requestBodySize = null;
		else
			this.requestBodySize = new RequestBodySizeImpl(value, null, null);
	}
	
	public Long getResponseHeadersSize()
	{
		if(this.responseHeadersSize == null)
			return null;
		
		return this.responseHeadersSize.getUnsigned();
	}
	
	public void setResponseHeadersSize(Long value)
	{
		if(value == null)
			this.responseHeadersSize = null;
		else
			this.responseHeadersSize = new ResponseHeadersSizeImpl(value, null, null);
	}	
	
	public Long getResponseBodySize()
	{
		if(this.responseBodySize == null)
			return null;
		
		return this.responseBodySize.getUnsigned();
	}
	
	public void setResponseBodySize(Long value)
	{
		if(value == null)
			this.responseBodySize = null;
		else
			this.responseBodySize = new ResponseBodySizeImpl(value, null, null);
	}
	
	public ResponseStatusCodeEnum getResponseStatusCode()
	{
		if(this.responseStatusCode == null)
			return null;
		
		return this.responseStatusCode.getEnumerated(ResponseStatusCodeEnum.class);
	}
	
	public void setResponseStatusCode(ResponseStatusCodeEnum value)
	{
		if(value == null)
			this.responseStatusCode = null;
		else
			this.responseStatusCode = new ResponseStatusCodeImpl(value, null, null);
	}	
	
	public Long getRatingGroup()
	{
		if(this.ratingGroup == null)
			return null;
		
		return this.ratingGroup.getUnsigned();
	}
	
	public void setRatingGroup(Long value)
	{
		if(value == null)
			this.ratingGroup = null;
		else
			this.ratingGroup = new RatingGroupImpl(value, null, null);
	}
	
	public Date getM2MEventRecordTimestamp()
	{
		if(this.m2mEventRecordTimestamp == null)
			return null;
		
		return this.m2mEventRecordTimestamp.getDateTime();
	}
	
	public void setM2MEventRecordTimestamp(Date value)
	{
		if(value == null)
			this.m2mEventRecordTimestamp = null;
		else
			this.m2mEventRecordTimestamp = new M2MEventRecordTimestampImpl(value, null, null);
	}	
	
	public Long getControlMemorySize()
	{
		if(this.controlMemorySize == null)
			return null;
		
		return this.controlMemorySize.getUnsigned();
	}
	
	public void setControlMemorySize(Long value)
	{
		if(value == null)
			this.controlMemorySize = null;
		else
			this.controlMemorySize = new ControlMemorySizeImpl(value, null, null);
	}	
	
	public Long getDataMemorySize()
	{
		if(this.dataMemorySize == null)
			return null;
		
		return this.dataMemorySize.getUnsigned();
	}
	
	public void setDataMemorySize(Long value)
	{
		if(value == null)
			this.dataMemorySize = null;
		else
			this.dataMemorySize = new DataMemorySizeImpl(value, null, null);
	}	
	
	public Long getAccessNetworkIdentifier()
	{
		if(this.accessNetworkIdentifier == null)
			return null;
		
		return this.accessNetworkIdentifier.getUnsigned();
	}
	
	public void setAccessNetworkIdentifier(Long value)
	{
		if(value == null)
			this.accessNetworkIdentifier = null;
		else
			this.accessNetworkIdentifier = new AccessNetworkIdentifierImpl(value, null, null);
	}	
	
	public Long getOccupancy()
	{
		if(this.occupancy == null)
			return null;
		
		return this.occupancy.getUnsigned();
	}
	
	public void setOccupancy(Long value)
	{
		if(value == null)
			this.occupancy = null;
		else
			this.occupancy = new OccupancyImpl(value, null, null);
	}
	
	public String getGroupName()
	{
		if(this.groupName == null)
			return null;
		
		return this.groupName.getString();
	}
	
	public void setGroupName(String value)
	{
		if(value == null)
			this.groupName = null;
		else
			this.groupName = new GroupNameImpl(value, null, null);
	}
	
	public Long getMaximumNumberMembers()
	{
		if(this.maximumNumberMembers == null)
			return null;
		
		return this.maximumNumberMembers.getUnsigned();
	}
	
	public void setMaximumNumberMembers(Long value)
	{
		if(value == null)
			this.maximumNumberMembers = null;
		else
			this.maximumNumberMembers = new MaximumNumberMembersImpl(value, null, null);
	}
	
	public Long getCurrentNumberMembers()
	{
		if(this.currentNumberMembers == null)
			return null;
		
		return this.currentNumberMembers.getUnsigned();
	}
	
	public void setCurrentNumberMembers(Long value)
	{
		if(value == null)
			this.currentNumberMembers = null;
		else
			this.currentNumberMembers = new CurrentNumberMembersImpl(value, null, null);
	}
	
	public String getSubgroupName()
	{
		if(this.subgroupName == null)
			return null;
		
		return this.subgroupName.getString();		
	}
	
	public void setSubgroupName(String value)
	{
		if(value == null)
			this.subgroupName = null;
		else
			this.subgroupName = new SubgroupNameImpl(value, null, null);
	}	
	
	public String getNodeId()
	{
		if(this.nodeId == null)
			return null;
		
		return this.nodeId.getString();
	}
	
	public void setNodeId(String value)
	{
		if(value == null)
			this.nodeId = null;
		else
			this.nodeId = new NodeIdImpl(value, null, null);
	}
}