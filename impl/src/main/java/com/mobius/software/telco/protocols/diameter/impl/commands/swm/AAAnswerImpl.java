package com.mobius.software.telco.protocols.diameter.impl.commands.swm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.swm.AAAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.SessionTimeoutImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingCharacteristicsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UserLocationInfoTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.APNOIReplacementImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.SessionTimeout;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UserLocationInfoTime;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNOIReplacement;
import com.mobius.software.telco.protocols.diameter.primitives.sta.AccessNetworkInfo;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TraceInfo;

/*
 * Mobius Software LTD, Open Source Cloud Communications
 * Copyright 2023, Mobius Software LTD and individual contrib, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

/**
*
* @author yulian oifa
*
*/
@DiameterCommandImplementation(applicationId = 16777264, commandCode = 271, request = false)
public class AAAnswerImpl extends SwmAnswerWithIdImpl implements AAAnswer
{
	private AuthRequestType authRequestType;
	
	private APNOIReplacement apnOIReplacement;
	
	private APNConfiguration apnConfiguration;
				
	private TraceInfo traceInfo;

	private SubscriptionId subscriptionID;
	
	private TGPPChargingCharacteristics tgppChargingCharacteristics;
	
	private SessionTimeout sessionTimeout;	
	
	private OCSupportedFeatures ocSupportedFeatures;
	 
	private OCOLR ocOLR;
    
	private List<Load> load;
	
	private AccessNetworkInfo accessNetworkInfo;
	
	private UserLocationInfoTime userLocationInfoTime;
		
	protected AAAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public AAAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId, AuthRequestTypeEnum authRequestType)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId);
		setExperimentalResultAllowed(false);
		
		setAuthRequestType(authRequestType);
	}

	@Override
	public AuthRequestTypeEnum getAuthRequestType() 
	{
		if(authRequestType == null)
			return null;
		
		return authRequestType.getEnumerated(AuthRequestTypeEnum.class);
	}

	@Override
	public void setAuthRequestType(AuthRequestTypeEnum value) 
	{
		if(value==null)
			throw new IllegalArgumentException("Auth-Request-Type is required");	
		
		this.authRequestType = new AuthRequestTypeImpl(value, null, null);
	}
	
	@Override
	public String getAPNOIReplacement()
	{
		if(apnOIReplacement==null)
			return null;
		
		return apnOIReplacement.getString();
	}
	
	@Override
	public void setAPNOIReplacement(String value) 
	{
		if(value == null)
			this.apnOIReplacement = null;
		else
			this.apnOIReplacement = new APNOIReplacementImpl(value, null, null);
	}
	
	@Override
	public APNConfiguration getAPNConfiguration()
	{
		return this.apnConfiguration;
	}
				
	@Override
	public void setAPNConfiguration(APNConfiguration value)
	{
		this.apnConfiguration = value;
	}
	
	@Override
	public TraceInfo getTraceInfo()
	{
		return traceInfo;
	}

	@Override
	public void setTraceInfo(TraceInfo value)
	{
		this.traceInfo = value;
	}
	
	@Override
	public SubscriptionId getSubscriptionID()
	{
		return subscriptionID;
	}
	
	@Override
	public void setSubscriptionID(SubscriptionId value)
	{
		this.subscriptionID = value;
	}
	
	@Override
	public String getTGPPChargingCharacteristics() 
	{
		if(tgppChargingCharacteristics==null)
			return null;
		
		return tgppChargingCharacteristics.getString();
	}

	@Override
	public void setTGPPChargingCharacteristics(String value) 
	{
		if(value == null)
			this.tgppChargingCharacteristics = null;
		else
			this.tgppChargingCharacteristics = new TGPPChargingCharacteristicsImpl(value, null, null);
	}
	
	@Override
	public Long getSessionTimeout() 
	{
		if(sessionTimeout == null)
			return null;
		
		return sessionTimeout.getUnsigned();
	}
	
	@Override
	public void setSessionTimeout(Long value)
	{
		if(value==null)
			this.sessionTimeout = null;
		else
			this.sessionTimeout = new SessionTimeoutImpl(value, null, null);
	}
	
	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	 		
	@Override
	public OCOLR getOCOLR()
	{
		return this.ocOLR;
	}
	 
	@Override
	public void setOCOLR(OCOLR value)
	{
		this.ocOLR = value;
	}
    
	@Override
	public List<Load> getLoad()
	{
		return this.load;
	}
	 
	@Override
	public void setLoad(List<Load> value)
	{
		this.load = value;
	}
	
	@Override
	public AccessNetworkInfo getAccessNetworkInfo()
	{
		return this.accessNetworkInfo;
	}
	
	@Override
	public void setAccessNetworkInfo(AccessNetworkInfo value)
	{
		this.accessNetworkInfo = value;
	}
	
	@Override
	public Date getUserLocationInfoTime() 
	{
		if(userLocationInfoTime == null)
			return null;
		
		return userLocationInfoTime.getDateTime();
	}
	
	@Override
	public void setUserLocationInfoTime(Date value)
	{
		if(value==null)
			this.userLocationInfoTime = null;
		else
			this.userLocationInfoTime = new UserLocationInfoTimeImpl(value, null, null);
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(authRequestType==null)
			return "Auth-Request-Type is required";
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authApplicationId);
		result.add(authRequestType);
        result.add(resultCode);
        result.add(originHost);
		result.add(originRealm);
		result.add(username);
		result.add(apnOIReplacement);
		result.add(apnConfiguration);
		result.add(traceInfo);
        result.add(subscriptionID);
        result.add(tgppChargingCharacteristics);
        result.add(sessionTimeout);
        result.add(ocSupportedFeatures);
        result.add(ocOLR);
        
        if(load!=null)
        	result.addAll(load);
        
        
        result.add(accessNetworkInfo);
        result.add(userLocationInfoTime);
        
        if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}