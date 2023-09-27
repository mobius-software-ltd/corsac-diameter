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

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SessionPriorityImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccessNetworkInfoChange;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccessNetworkInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccessTransferInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccountExpiration;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AlternateChargedPartyAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ApplicationServerInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AssociatedURI;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.BearerService;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CalledAssertedIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CalledIdentityChange;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CalledPartyAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CallingPartyAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CarrierSelectRoutingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CauseCode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CellularNetworkInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EarlyMediaDescription;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EventType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.FEIdentifierList;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.FromAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.IMSApplicationReferenceIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.IMSChargingIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.IMSCommunicationServiceIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.IMSEmergencyIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.IMSEmergencyIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.IMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.IMSVisitedNetworkIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.InitialIMSChargingIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.InstanceId;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.InterOperatorIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MessageBody;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NNIInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NodeFunctionality;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NodeFunctionalityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NumberPortabilityRoutingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OnlineChargingFlag;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OnlineChargingFlagEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OutgoingSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RealTimeTariffInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ReasonHeader;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RelatedIMSChargingIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RelatedIMSChargingIdentifierNode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RequestedPartyAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RoleOfNode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RoleOfNodeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RouteHeaderReceived;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RouteHeaderTransmitted;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SDPMediaComponent;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SDPSessionDescription;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServedPartyIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceSpecificInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TADIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TADIdentifierEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeStamps;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TransitIOIList;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TrunkGroupID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerCapabilities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SessionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SessionPriorityEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 876L, vendorId = KnownVendorIDs.TGPP_ID)
public class IMSInformationImpl implements IMSInformation
{
	private EventType eventType;
	private RoleOfNode roleOfNode;
	private NodeFunctionality nodeFunctionality;
	private UserSessionId userSessionId;
	private OutgoingSessionId outgoingSessionId;
	private SessionPriority sessionPriority;
	private List<CallingPartyAddress> callingPartyAddress;
	private CalledPartyAddress calledPartyAddress;
	private List<CalledAssertedIdentity> calledAssertedIdentity;
	private CalledIdentityChange calledIdentityChange;
	private NumberPortabilityRoutingInformation numberPortabilityRoutingInformation;
	private CarrierSelectRoutingInformation carrierSelectRoutingInformation;
	private AlternateChargedPartyAddress alternateChargedPartyAddress;
	private List<RequestedPartyAddress> requestedPartyAddress;
	private List<AssociatedURI> associatedURI;
	private TimeStamps timeStamps;
	private List<ApplicationServerInformation> applicationServerInformation;
	private List<InterOperatorIdentifier> interOperatorIdentifier;
	private List<TransitIOIList> transitIOIList;
	private IMSChargingIdentifier imsChargingIdentifier;
	private List<SDPSessionDescription> sdpSessionDescription;
	private List<SDPMediaComponent> sdpMediaComponent;	
	private ServedPartyIPAddress servedPartyIPAddress;
	private ServerCapabilities serverCapabilities;
	private TrunkGroupID trunkGroupID;
	private BearerService bearerService;
	private ServiceID serviceId;
	private List<ServiceSpecificInfo> serviceSpecificInfo;
	private List<MessageBody> messageBody;
	private CauseCode causeCode; 
	private List<ReasonHeader> reasonHeader;
	private List<AccessNetworkInformation> accessNetworkInformation;
	private CellularNetworkInformation cellularNetworkInformation; 
	private List<EarlyMediaDescription> earlyMediaDescription; 
	private IMSCommunicationServiceIdentifier imsCommunicationServiceIdentifier; 
	private IMSApplicationReferenceIdentifier imsApplicationReferenceIdentifier;
	private OnlineChargingFlag onlineChargingFlag;
	private RealTimeTariffInformation realTimeTariffInformation;
	private AccountExpiration accountExpiration;
	private InitialIMSChargingIdentifier initialIMSChargingIdentifier;
	private List<NNIInformation> nniInformation; 
	private FromAddress fromAddress; 
	private IMSEmergencyIndicator imsEmergencyIndicator;
	private IMSVisitedNetworkIdentifier imsVisitedNetworkIdentifier;
	private List<AccessNetworkInfoChange> accessNetworkInfoChange;
	private List<AccessTransferInformation> accessTransferInformation;
	private RelatedIMSChargingIdentifier relatedIMSChargingIdentifier;
	private RelatedIMSChargingIdentifierNode relatedIMSChargingIdentifierNode;
	private RouteHeaderReceived routeHeaderReceived;
	private RouteHeaderTransmitted routeHeaderTransmitted;
	private InstanceId instanceId;
	private TADIdentifier tadIdentifier;
	private FEIdentifierList feIdentifierList;
					
	protected IMSInformationImpl()
	{
	}
	
	public IMSInformationImpl(NodeFunctionalityEnum nodeFunctionality)
	{
		if(nodeFunctionality==null)
			throw new IllegalArgumentException("Node-Functionality is required");
		
		this.nodeFunctionality = new NodeFunctionalityImpl(nodeFunctionality, null, null);				
	}
	
	public EventType getEventType()
	{
		return eventType;
	}
	
	public void setEventType(EventType value)
	{
		this.eventType = value;			
	}
	
	public RoleOfNodeEnum getRoleOfNode()
	{
		if(roleOfNode==null)
			return null;
		
		return roleOfNode.getEnumerated(RoleOfNodeEnum.class);
	}
	
	public void setRoleOfNode(RoleOfNodeEnum value)
	{
		if(value==null)
			this.roleOfNode = null;
		else
			this.roleOfNode = new RoleOfNodeImpl(value, null, null);			
	}
	
	public NodeFunctionalityEnum getNodeFunctionality()
	{
		if(nodeFunctionality==null)
			return null;
		
		return nodeFunctionality.getEnumerated(NodeFunctionalityEnum.class);
	}
	
	public void setNodeFunctionality(NodeFunctionalityEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("Node-Functionality is required");
		
		this.nodeFunctionality = new NodeFunctionalityImpl(value, null, null);				
	}
	
	public String getUserSessionId()
	{
		if(userSessionId==null)
			return null;
		
		return userSessionId.getString();
	}
	
	public void setUserSessionId(String value)
	{
		if(value==null)
			this.userSessionId = null;
		else
			this.userSessionId = new UserSessionIdImpl(value, null, null);			
	}
	
	public String getOutgoingSessionId()
	{
		if(outgoingSessionId==null)
			return null;
		
		return outgoingSessionId.getString();
	}
	
	public void setOutgoingSessionId(String value)
	{
		if(value==null)
			this.outgoingSessionId = null;
		else
			this.outgoingSessionId = new OutgoingSessionIdImpl(value, null, null);			
	}
	
	public SessionPriorityEnum getSessionPriority()
	{
		if(sessionPriority==null)
			return null;
		
		return sessionPriority.getEnumerated(SessionPriorityEnum.class);
	}
	
	public void setSessionPriority(SessionPriorityEnum value)
	{
		if(value==null)
			this.sessionPriority = null;
		else
			this.sessionPriority = new SessionPriorityImpl(value, null, null);			
	}
	
	public List<String> getCallingPartyAddress()
	{
		if(callingPartyAddress==null || callingPartyAddress.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(CallingPartyAddress curr:callingPartyAddress)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setCallingPartyAddress(List<String> value)
	{
		if(value==null || value.size()==0)
			this.callingPartyAddress = null;
		else
		{
			this.callingPartyAddress = new ArrayList<CallingPartyAddress>();
			for(String curr:value)
				this.callingPartyAddress.add(new CallingPartyAddressImpl(curr, null, null));
		}
	}
	
	public String getCalledPartyAddress()
	{
		if(calledPartyAddress==null)
			return null;
		
		return calledPartyAddress.getString();
	}
	
	public void setCalledPartyAddress(String value)
	{
		if(value==null)
			this.calledPartyAddress = null;
		else
			this.calledPartyAddress = new CalledPartyAddressImpl(value, null, null);			
	}
	
	public List<String> getCalledAssertedIdentity()
	{
		if(calledAssertedIdentity==null || calledAssertedIdentity.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(CalledAssertedIdentity curr:calledAssertedIdentity)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setCalledAssertedIdentity(List<String> value)
	{
		if(value==null || value.size()==0)
			this.calledAssertedIdentity = null;
		else
		{
			this.calledAssertedIdentity = new ArrayList<CalledAssertedIdentity>();
			for(String curr:value)
				this.calledAssertedIdentity.add(new CalledAssertedIdentityImpl(curr, null, null));
		}
	}
	
	public CalledIdentityChange getCalledIdentityChange()
	{
		return calledIdentityChange;
	}
	
	public void setCalledIdentityChange(CalledIdentityChange value)
	{
		this.calledIdentityChange = value;	
	}
	
	public String getNumberPortabilityRoutingInformation()
	{
		if(numberPortabilityRoutingInformation==null)
			return null;
		
		return numberPortabilityRoutingInformation.getString();
	}
	
	public void setNumberPortabilityRoutingInformation(String value)
	{
		if(value==null)
			this.numberPortabilityRoutingInformation = null;
		else
			this.numberPortabilityRoutingInformation = new NumberPortabilityRoutingInformationImpl(value, null, null);			
	}
	
	public String getCarrierSelectRoutingInformation()
	{
		if(carrierSelectRoutingInformation==null)
			return null;
		
		return carrierSelectRoutingInformation.getString();
	}
	
	public void setCarrierSelectRoutingInformation(String value)
	{
		if(value==null)
			this.carrierSelectRoutingInformation = null;
		else
			this.carrierSelectRoutingInformation = new CarrierSelectRoutingInformationImpl(value, null, null);			
	}
	
	public String getAlternateChargedPartyAddress()
	{
		if(alternateChargedPartyAddress==null)
			return null;
		
		return alternateChargedPartyAddress.getString();
	}
	
	public void setAlternateChargedPartyAddress(String value)
	{
		if(value==null)
			this.alternateChargedPartyAddress = null;
		else
			this.alternateChargedPartyAddress = new AlternateChargedPartyAddressImpl(value, null, null);			
	}
	
	public List<String> getRequestedPartyAddress()
	{
		if(requestedPartyAddress==null || requestedPartyAddress.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(RequestedPartyAddress curr:requestedPartyAddress)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setRequestedPartyAddress(List<String> value)
	{
		if(value==null || value.size()==0)
			this.requestedPartyAddress = null;
		else
		{
			this.requestedPartyAddress = new ArrayList<RequestedPartyAddress>();
			for(String curr:value)
				this.requestedPartyAddress.add(new RequestedPartyAddressImpl(curr, null, null));
		}
	}
	
	public List<String> getAssociatedURI()
	{
		if(associatedURI==null || associatedURI.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(AssociatedURI curr:associatedURI)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setAssociatedURI(List<String> value)
	{
		if(value==null || value.size()==0)
			this.associatedURI = null;
		else
		{
			this.associatedURI = new ArrayList<AssociatedURI>();
			for(String curr:value)
				this.associatedURI.add(new AssociatedURIImpl(curr, null, null));
		}
	}
	
	public TimeStamps getTimeStamps()
	{
		return timeStamps;
	}
	
	public void setTimeStamps(TimeStamps value)
	{
		this.timeStamps = value;
	}
	
	public List<ApplicationServerInformation> getApplicationServerInformation()
	{
		return applicationServerInformation;
	}
	
	public void setApplicationServerInformation(List<ApplicationServerInformation> value)
	{
		this.applicationServerInformation = value;
	}
	
	public List<InterOperatorIdentifier> getInterOperatorIdentifier()
	{
		return interOperatorIdentifier;
	}
	
	public void setInterOperatorIdentifier(List<InterOperatorIdentifier> value)
	{
		this.interOperatorIdentifier = value;
	}
	
	public List<String> getTransitIOIList()
	{
		if(transitIOIList==null || transitIOIList.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(TransitIOIList curr:transitIOIList)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setTransitIOIList(List<String> value)
	{
		if(value==null || value.size()==0)
			this.transitIOIList = null;
		else
		{
			this.transitIOIList = new ArrayList<TransitIOIList>();
			for(String curr:value)
				this.transitIOIList.add(new TransitIOIListImpl(curr, null, null));
		}
	}
	
	public String getIMSChargingIdentifier()
	{
		if(imsChargingIdentifier==null)
			return null;
		
		return imsChargingIdentifier.getString();
	}
	
	public void setIMSChargingIdentifier(String value)
	{
		if(value==null)
			this.imsChargingIdentifier = null;
		else
			this.imsChargingIdentifier = new IMSChargingIdentifierImpl(value, null, null);			
	}
	
	public List<String> getSDPSessionDescription()
	{
		if(sdpSessionDescription==null || sdpSessionDescription.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(SDPSessionDescription curr:sdpSessionDescription)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setSDPSessionDescription(List<String> value)
	{
		if(value==null || value.size()==0)
			this.sdpSessionDescription = null;
		else
		{
			this.sdpSessionDescription = new ArrayList<SDPSessionDescription>();
			for(String curr:value)
				this.sdpSessionDescription.add(new SDPSessionDescriptionImpl(curr, null, null));
		}
	}
	
	public List<SDPMediaComponent> getSDPMediaComponent()
	{
		return sdpMediaComponent;
	}
	
	public void setSDPMediaComponent(List<SDPMediaComponent> value)
	{
		this.sdpMediaComponent = value;
	}
	
	public InetAddress getServedPartyIPAddress()
	{
		if(servedPartyIPAddress==null)
			return null;
		
		return servedPartyIPAddress.getAddress();
	}
	
	public void setServedPartyIPAddress(InetAddress value)
	{
		if(value==null)
			this.servedPartyIPAddress = null;
		else
			this.servedPartyIPAddress = new ServedPartyIPAddressImpl(value, null, null);			
	}
	
	public ServerCapabilities getServerCapabilities()
	{
		return serverCapabilities;
	}
	
	public void setServerCapabilities(ServerCapabilities value)
	{
		this.serverCapabilities = value;
	}
	
	public TrunkGroupID getTrunkGroupID()
	{
		return trunkGroupID;
	}
	
	public void setTrunkGroupID(TrunkGroupID value)
	{
		this.trunkGroupID = value;
	}
	
	public ByteBuf getBearerService()
	{
		if(bearerService==null)
			return null;
		
		return bearerService.getValue();
	}
	
	public void setBearerService(ByteBuf value)
	{
		if(value==null)
			this.bearerService = null;
		else
			this.bearerService = new BearerServiceImpl(value, null, null);			
	}
	
	public String getServiceID()
	{
		if(serviceId==null)
			return null;
		
		return serviceId.getString();
	}
	
	public void setServiceID(String value)
	{
		if(value==null)
			this.serviceId = null;
		else
			this.serviceId = new ServiceIDImpl(value, null, null);			
	}
	
	public List<ServiceSpecificInfo> getServiceSpecificInfo()
	{
		return serviceSpecificInfo;
	}
	
	public void setServiceSpecificInfo(List<ServiceSpecificInfo> value)
	{
		this.serviceSpecificInfo = value;
	}
	
	public List<MessageBody> getMessageBody()
	{
		return messageBody;
	}
	
	public void setMessageBody(List<MessageBody> value)
	{
		this.messageBody = value;
	}
	
	public Long getCauseCode()
	{
		if(causeCode==null)
			return null;
		
		return causeCode.getUnsigned();
	}
	
	public void setCauseCode(Long value)
	{
		if(value==null)
			this.causeCode = null;
		else
			this.causeCode = new CauseCodeImpl(value, null, null);			
	}
	
	public List<String> getReasonHeader()
	{
		if(reasonHeader==null || reasonHeader.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(ReasonHeader curr:reasonHeader)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setReasonHeader(List<String> value)
	{
		if(value==null || value.size()==0)
			this.reasonHeader = null;
		else
		{
			this.reasonHeader = new ArrayList<ReasonHeader>();
			for(String curr:value)
				this.reasonHeader.add(new ReasonHeaderImpl(curr, null, null));
		}
	}
	
	public List<ByteBuf> getAccessNetworkInformation()
	{
		if(accessNetworkInformation==null || accessNetworkInformation.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(AccessNetworkInformation curr:accessNetworkInformation)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setAccessNetworkInformation(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.accessNetworkInformation = null;
		else
		{
			this.accessNetworkInformation = new ArrayList<AccessNetworkInformation>();
			for(ByteBuf curr:value)
				this.accessNetworkInformation.add(new AccessNetworkInformationImpl(curr, null, null));
		}
	}
	
	public ByteBuf getCellularNetworkInformation()
	{
		if(cellularNetworkInformation==null)
			return null;
		
		return cellularNetworkInformation.getValue();
	}
	
	public void setCellularNetworkInformation(ByteBuf value)
	{
		if(value==null)
			this.cellularNetworkInformation = null;
		else
			this.cellularNetworkInformation = new CellularNetworkInformationImpl(value, null, null);			
	}
	
	public List<EarlyMediaDescription> getEarlyMediaDescription()
	{
		return earlyMediaDescription;
	}
	
	public void setEarlyMediaDescription(List<EarlyMediaDescription> value)
	{
		this.earlyMediaDescription = value;
	}
	
	public String getIMSCommunicationServiceIdentifier()
	{
		if(imsCommunicationServiceIdentifier==null)
			return null;
		
		return imsCommunicationServiceIdentifier.getString();
	}
	
	public void setIMSCommunicationServiceIdentifier(String value)
	{
		if(value==null)
			this.imsCommunicationServiceIdentifier = null;
		else
			this.imsCommunicationServiceIdentifier = new IMSCommunicationServiceIdentifierImpl(value, null, null);			
	}
	
	public String getIMSApplicationReferenceIdentifier()
	{
		if(imsApplicationReferenceIdentifier==null)
			return null;
		
		return imsApplicationReferenceIdentifier.getString();
	}
	
	public void setIMSApplicationReferenceIdentifier(String value)
	{
		if(value==null)
			this.imsApplicationReferenceIdentifier = null;
		else
			this.imsApplicationReferenceIdentifier = new IMSApplicationReferenceIdentifierImpl(value, null, null);			
	}
	
	public OnlineChargingFlagEnum getOnlineChargingFlag()
	{
		if(onlineChargingFlag==null)
			return null;
		
		return onlineChargingFlag.getEnumerated(OnlineChargingFlagEnum.class);
	}
	
	public void setOnlineChargingFlag(OnlineChargingFlagEnum value)
	{
		if(value==null)
			this.onlineChargingFlag = null;
		else
			this.onlineChargingFlag = new OnlineChargingFlagImpl(value, null, null);			
	}
	
	public RealTimeTariffInformation getRealTimeTariffInformation()
	{
		return realTimeTariffInformation;
	}
	
	public void setRealTimeTariffInformation(RealTimeTariffInformation value)
	{
		this.realTimeTariffInformation = value;
	}
	
	public Date getAccountExpiration()
	{
		if(accountExpiration==null)
			return null;
		
		return accountExpiration.getDateTime();
	}
	
	public void setAccountExpiration(Date value)
	{
		if(value==null)
			this.accountExpiration = null;
		else
			this.accountExpiration = new AccountExpirationImpl(value, null, null);			
	}
	
	public String getInitialIMSChargingIdentifier()
	{
		if(initialIMSChargingIdentifier==null)
			return null;
		
		return initialIMSChargingIdentifier.getString();
	}
	
	public void setInitialIMSChargingIdentifier(String value)
	{
		if(value==null)
			this.initialIMSChargingIdentifier = null;
		else
			this.initialIMSChargingIdentifier = new InitialIMSChargingIdentifierImpl(value, null, null);			
	}
	
	public List<NNIInformation> getNNIInformation()
	{
		return nniInformation;
	}
	
	public void setNNIInformation(List<NNIInformation> value)
	{
		this.nniInformation = value;
	}
	
	public String getFromAddress()
	{
		if(fromAddress==null)
			return null;
		
		return fromAddress.getString();
	}
	
	public void setFromAddress(String value)
	{
		if(value==null)
			this.fromAddress = null;
		else
			this.fromAddress = new FromAddressImpl(value, null, null);			
	}
	
	public IMSEmergencyIndicatorEnum getIMSEmergencyIndicator()
	{
		if(imsEmergencyIndicator==null)
			return null;
		
		return imsEmergencyIndicator.getEnumerated(IMSEmergencyIndicatorEnum.class);
	}
	
	public void setIMSEmergencyIndicator(IMSEmergencyIndicatorEnum value)
	{
		if(value==null)
			this.imsEmergencyIndicator = null;
		else
			this.imsEmergencyIndicator = new IMSEmergencyIndicatorImpl(value, null, null);			
	}
	
	public String getIMSVisitedNetworkIdentifier()
	{
		if(imsVisitedNetworkIdentifier==null)
			return null;
		
		return imsVisitedNetworkIdentifier.getString();
	}
	
	public void setIMSVisitedNetworkIdentifier(String value)
	{
		if(value==null)
			this.imsVisitedNetworkIdentifier = null;
		else
			this.imsVisitedNetworkIdentifier = new IMSVisitedNetworkIdentifierImpl(value, null, null);			
	}
	
	public List<AccessNetworkInfoChange> getAccessNetworkInfoChange()
	{
		return accessNetworkInfoChange;
	}
	
	public void setAccessNetworkInfoChange(List<AccessNetworkInfoChange> value)
	{
		this.accessNetworkInfoChange = value;
	}
	
	public List<AccessTransferInformation> getAccessTransferInformation()
	{
		return accessTransferInformation;
	}
	
	public void setAccessTransferInformation(List<AccessTransferInformation> value)
	{
		this.accessTransferInformation = value;
	}
	
	public String getRelatedIMSChargingIdentifier()
	{
		if(relatedIMSChargingIdentifier==null)
			return null;
		
		return relatedIMSChargingIdentifier.getString();
	}
	
	public void setRelatedIMSChargingIdentifier(String value)
	{
		if(value==null)
			this.relatedIMSChargingIdentifier = null;
		else
			this.relatedIMSChargingIdentifier = new RelatedIMSChargingIdentifierImpl(value, null, null);			
	}
	
	public RelatedIMSChargingIdentifierNode getRelatedIMSChargingIdentifierNode()
	{
		return relatedIMSChargingIdentifierNode;
	}
	
	public void setRelatedIMSChargingIdentifierNode(RelatedIMSChargingIdentifierNode value)
	{
		this.relatedIMSChargingIdentifierNode = value;
	}
	
	public String getRouteHeaderReceived()
	{
		if(routeHeaderReceived==null)
			return null;
		
		return routeHeaderReceived.getString();
	}
	
	public void setRouteHeaderReceived(String value)
	{
		if(value==null)
			this.routeHeaderReceived = null;
		else
			this.routeHeaderReceived = new RouteHeaderReceivedImpl(value, null, null);			
	}
	
	public String getRouteHeaderTransmitted()
	{
		if(routeHeaderTransmitted==null)
			return null;
		
		return routeHeaderTransmitted.getString();
	}
	
	public void setRouteHeaderTransmitted(String value)
	{
		if(value==null)
			this.routeHeaderTransmitted = null;
		else
			this.routeHeaderTransmitted = new RouteHeaderTransmittedImpl(value, null, null);			
	}
	
	public String getInstanceId()
	{
		if(instanceId==null)
			return null;
		
		return instanceId.getString();
	}
	
	public void setInstanceId(String value)
	{
		if(value==null)
			this.instanceId = null;
		else
			this.instanceId = new InstanceIdImpl(value, null, null);			
	}
	
	public TADIdentifierEnum getTADIdentifier()
	{
		if(tadIdentifier==null)
			return null;
		
		return tadIdentifier.getEnumerated(TADIdentifierEnum.class);
	}
	
	public void setTADIdentifier(TADIdentifierEnum value)
	{
		if(value==null)
			this.tadIdentifier = null;
		else
			this.tadIdentifier = new TADIdentifierImpl(value, null, null);			
	}
	
	public String getFEIdentifierList()
	{
		if(feIdentifierList==null)
			return null;
		
		return feIdentifierList.getString();
	}
	
	public void setFEIdentifierList(String value)
	{
		if(value==null)
			this.feIdentifierList = null;
		else
			this.feIdentifierList = new FEIdentifierListImpl(value, null, null);			
	}
	
	@DiameterValidate
	public String validate()
	{
		if(nodeFunctionality==null)
			return "Node-Functionality is required";
		
		return null;
	}
}