package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CCMoney;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.*;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 20400L, vendorId = KnownVendorIDs.HUAWEI_ID)
public class INInformationImpl implements INInformation
{
	private ActiveFlag activeFlag;
	
	private CallingVlrNumber callingVlrNumber;
	
	private CallingMscAddress callingMscAddress;
	
	private CallingCellIDOrSAI callingCellIDOrSAI;
	
	private AccessMethod accessMethod;
	
	private AuthInformation authInformation;
	
	private List<BalanceInfo> balanceInfo;
	
	private CallingPartyAddress callingPartyAddress;
	
	private CalledPartyAddress calledPartyAddress;
	
	private CalledShortNumber calledShortNumber;
	
	private SpecificOutput specificOutput;
	
	private CallingPartysCategory callingPartysCategory;
	
	private CallingPartyAddressNature callingPartyAddressNature;
	
	private CalledPartyAddressNature calledPartyAddressNature;
	
	private CallingLAI callingLAI;
	
	private CalledVlrNumber calledVlrNumber;
	
	private CalledCellIDOrSAI calledCellIDOrSAI;
	
	private CalledIMEI calledIMEI;
	
	private CallingIMEI callingIMEI;
	
	private RedirectingPartyId redirectingPartyId;
	
	private RedirectionReason redirectionReason;
	
	private MSCAddress mscAddress;
	
	private TimeZone timeZone;
	
	private AccessNetworkType accessNetworkType;
	
	private ServiceKey serviceKey;
	
	private CallForwardIndicator callForwardIndicator;
	
	private UEIMSI ueIMSI;
	
	private OriginalCalledPartyId originalCalledPartyId;
	
	private CallReferenceNumber callReferenceNumber;
	
	private SSPTime sspTime;
	
	private ChargeFlowType chargeFlowType;
	
	private BearerCapability bearerCapability;
	
	private CallingLocationNumberNature callingLocationNumberNature;
	
	private CalledPartyBCDNumberNature calledPartyBCDNumberNature;
	
	private CalledLocationNumber calledLocationNumber;
	
	private CalledLocationNumberNature calledLocationNumberNature;
	
	private OriginalCalledPartyIdNature originalCalledPartyIdNature;
	
	private RerouteCalledNumber rerouteCalledNumber;
	
	private FunctionFlag functionFlag;
	
	private PersonalPayNotifyMode personalPayNotifyMode;
	
	private UserPasswd userPassWd;
	
	private IDDOriginateNumber iddOriginateNumber;
	
	private AddressOfRestrictedIndicator addressOfRestrictedIndicator;
	
	private ConnectCalledNumber connectCalledNumber;
	
	private CallingLocationNumber callingLocationNumber;
	
	private CalledMscAddress calledMscAddress;
	
	private RedirectingPartyIdNature redirectingPartyIdNature;
	
	private RealCalledNumber realCalledNumber;
	
	private CalledPartyBCDNumber calledPartyBCDNumber;
	
	private NewSSPTime newSSPTime;
	
	private INAPCS1TariffClass inapCS1TariffClass;
	
	private CalledLAI calledLAI;
	
	private KeepVoiceFlag keepVoiceFlag;
	
	private List<ServiceParameterInfo> serviceParameterInfo;
	
	private AlertLevel alertLevel;
	
	private GracePeriod gracePeriod;
	
	private DisablePeriod disablePeriod;
	
	private CallType callType;
	
	private VPNNotifyFlag vpnNotifyFlag;
	
	private FavAreaFlag favAreaFlag;
	
	private SameCUGNotFreeNotifyFlag sameCUGNotFreeNotifyFlag;
	
	private PersonalPayCostValue personalPayCostValue;
	
	private ActiveCurrencyCode activeCurrencyCode;
	
	private SuspendReason suspendReason;
	
	private ChargePartyType chargePartyType;
	
	private CreditUseNotification creditUseNotification;
	
	private UserBasicInfo userBasicInfo;
	
	private CommunityInformation communityInformation;
	
	private SubscriberPayType subscriberPayType;
	
	private ActivePeriod activePeriod;
	
	private AnnouncementData announcementData;
	
	private List<NoticeInformation> noticeInformation;
	
	private ShareCallPercent shareCallPercent;
	
	private ServiceFreeIndicator serviceFreeIndicator;
	
	private HandleOverToolboxFlag handleOverToolboxFlag;
	
	private CallBeginTime callBeginTime;
	
	private AdjustRoamingType adjustRoamingType;
	
	private TotalCostFlag totalCostFlag;
	
	private ReleaseReason releaseReason;
	
	private AccountInfo accountInfo;
	
	private CalledPartyNP calledPartyNP;
	
	private CallingPartyNP callingPartyNP;
	
	private FavCellIdFlag favCellIdFlag;
	
	private RechargeInformation rechargeInformation;
	
	private ActiveMethod activeMethod;
	
	private OperatorID operatorID;
	
	private AccountQueryMethod accountQueryMethod;
	
	private AccountType accountType;
	
	private CCMoney ccMoney;
	
	private FixRentFee fixRentFee;
	
	private NextBillDateTime nextBillDateTime;
	
	private AmountBeforeRecharge amountBeforeRecharge;
	
	private	RchgExtActKey rchgExtActKey;
	
	private AccountChangeInfo accountChangeInfo;
	
	private CumInfo cumInfo;
	
	private ParentLimitValue parentLimitValue;
	
	private AdditionalInfo additionalInfo;
	
	private ChargeConfirmFlag chargeConfirmFlag;
	
	private MainProductID mainProductID;
	
	private IVRLang ivrLang;
	
	private SMSLang smsLang;
	
	private PayType payType;
	
	private Brand brand;
	
	private ActivationDate activationDate;
	
	private ManagementState managementState;
	
	private State state;
	
	private PPSBalance ppsBalance;
	
	private POSBalance posBalance;
	
	private SSPNO sspno;
	
	private ChargeNumberNature chargeNumberNature;
	
	public INInformationImpl()
	{
		
	}
	
	@Override
	public Integer getActiveFlag()
	{
		if(activeFlag==null)
			return null;
		
		return activeFlag.getInteger();
	}
	
	@Override
	public void setActiveFlag(Integer value)
	{
		if(value==null)
			this.activeFlag = null;
		else
			this.activeFlag = new ActiveFlagImpl(value, null, null);
	}
	
	@Override
	public String getCallingVlrNumber()
	{
		if(callingVlrNumber==null)
			return null;
		
		return callingVlrNumber.getString();
	}
	
	@Override
	public void setCallingVlrNumber(String value)
	{
		if(value==null)
			this.callingVlrNumber = null;
		else
			this.callingVlrNumber = new CallingVlrNumberImpl(value);
	}
	
	@Override
	public ByteBuf getCallingMscAddress()
	{
		if(callingMscAddress==null)
			return null;
		
		return callingMscAddress.getValue();
	}
	
	@Override
	public void setCallingMscAddress(ByteBuf value)
	{
		if(value==null)
			this.callingMscAddress = null;
		else
			this.callingMscAddress = new CallingMscAddressImpl(value);
	}
	
	@Override
	public String getCallingCellIDOrSAI()
	{
		if(callingCellIDOrSAI==null)
			return null;
		
		return callingCellIDOrSAI.getString();
	}
	
	@Override
	public void setCallingCellIDOrSAI(String value)
	{
		if(value==null)
			this.callingCellIDOrSAI = null;
		else
			this.callingCellIDOrSAI = new CallingCellIDOrSAIImpl(value);
	}
	
	@Override
	public Long getAccessMethod()
	{
		if(accessMethod==null)
			return null;
		
		return accessMethod.getUnsigned();
	}
	
	@Override
	public void setAccessMethod(Long value)
	{
		if(value==null)
			this.accessMethod = null;
		else
			this.accessMethod = new AccessMethodImpl(value, null, null);
	}
	
	@Override
	public AuthInformation getAuthInformation()
	{
		return authInformation;
	}
	
	@Override
	public void setAuthInformation(AuthInformation value)
	{
		this.authInformation = value;
	}
	
	@Override
	public List<BalanceInfo> getBalanceInfo()
	{
		return balanceInfo;
	}
	
	@Override
	public void setBalanceInfo(List<BalanceInfo> value)
	{
		this.balanceInfo = value;
	}
	
	@Override
	public String getCallingPartyAddress()
	{
		if(callingPartyAddress==null)
			return null;
		
		return callingPartyAddress.getString();
	}
	
	@Override
	public void setCallingPartyAddress(String value)
	{
		if(value==null)
			this.callingPartyAddress = null;
		else
			this.callingPartyAddress = new CallingPartyAddressImpl(value);
	}
	
	@Override
	public String getCalledPartyAddress()
	{
		if(calledPartyAddress==null)
			return null;
		
		return calledPartyAddress.getString();
	}
	
	@Override
	public void setCalledPartyAddress(String value)
	{
		if(value==null)
			this.calledPartyAddress = null;
		else
			this.calledPartyAddress = new CalledPartyAddressImpl(value);
	}
	
	@Override
	public String getCalledShortNumber()
	{
		if(calledShortNumber==null)
			return null;
		
		return calledShortNumber.getString();
	}
	
	@Override
	public void setCalledShortNumber(String value)
	{
		if(value==null)
			this.calledShortNumber = null;
		else
			this.calledShortNumber = new CalledShortNumberImpl(value);
	}
	
	@Override
	public Long getSpecificOutput()
	{
		if(specificOutput==null)
			return null;
		
		return specificOutput.getUnsigned();
	}
	
	@Override
	public void setSpecificOutput(Long value)
	{
		if(value==null)
			this.specificOutput = null;
		else
			this.specificOutput = new SpecificOutputImpl(value, null, null);
	}
	
	@Override
	public Long getCallingPartysCategory()
	{
		if(callingPartysCategory==null)
			return null;
		
		return callingPartysCategory.getUnsigned();
	}
	
	@Override
	public void setCallingPartysCategory(Long value)
	{
		if(value==null)
			this.callingPartysCategory = null;
		else
			this.callingPartysCategory = new CallingPartysCategoryImpl(value, null, null);
	}
	
	@Override
	public Long getCallingPartyAddressNature()
	{
		if(callingPartyAddressNature==null)
			return null;
		
		return callingPartyAddressNature.getUnsigned();
	}
	
	@Override
	public void setCallingPartyAddressNature(Long value)
	{
		if(value==null)
			this.callingPartyAddressNature = null;
		else
			this.callingPartyAddressNature = new CallingPartyAddressNatureImpl(value, null, null);
	}
	
	@Override
	public Long getCalledPartyAddressNature()
	{
		if(calledPartyAddressNature==null)
			return null;
		
		return calledPartyAddressNature.getUnsigned();
	}
	
	@Override
	public void setCalledPartyAddressNature(Long value)
	{
		if(value==null)
			this.calledPartyAddressNature = null;
		else
			this.calledPartyAddressNature = new CalledPartyAddressNatureImpl(value, null, null);
	}
	
	@Override
	public String getCallingLAI()
	{
		if(callingLAI==null)
			return null;
		
		return callingLAI.getString();
	}
	
	@Override
	public void setCallingLAI(String value)
	{
		if(value==null)
			this.callingLAI = null;
		else
			this.callingLAI = new CallingLAIImpl(value);
	}
	
	@Override
	public String getCalledVlrNumber()
	{
		if(calledVlrNumber==null)
			return null;
		
		return calledVlrNumber.getString();
	}
	
	@Override
	public void setCalledVlrNumber(String value)
	{
		if(value==null)
			this.calledVlrNumber = null;
		else
			this.calledVlrNumber = new CalledVlrNumberImpl(value);
	}
	
	@Override
	public String getCalledCellIDOrSAI()
	{
		if(calledCellIDOrSAI==null)
			return null;
		
		return calledCellIDOrSAI.getString();
	}
	
	@Override
	public void setCalledCellIDOrSAI(String value)
	{
		if(value==null)
			this.calledCellIDOrSAI = null;
		else
			this.calledCellIDOrSAI = new CalledCellIDOrSAIImpl(value);
	}
	
	@Override
	public String getCalledIMEI()
	{
		if(calledIMEI==null)
			return null;
		
		return calledIMEI.getString();
	}
	
	@Override
	public void setCalledIMEI(String value)
	{
		if(value==null)
			this.calledIMEI = null;
		else
			this.calledIMEI = new CalledIMEIImpl(value);
	}
	
	@Override
	public String getCallingIMEI()
	{
		if(callingIMEI==null)
			return null;
		
		return callingIMEI.getString();
	}
	
	@Override
	public void setCallingIMEI(String value)
	{
		if(value==null)
			this.callingIMEI = null;
		else
			this.callingIMEI = new CallingIMEIImpl(value);
	}
	
	@Override
	public String getRedirectingPartyId()
	{
		if(redirectingPartyId==null)
			return null;
		
		return redirectingPartyId.getString();
	}
	
	@Override
	public void setRedirectingPartyId(String value)
	{
		if(value==null)
			this.redirectingPartyId = null;
		else
			this.redirectingPartyId = new RedirectingPartyIdImpl(value);
	}
	
	@Override
	public Long getRedirectionReason()
	{
		if(redirectionReason==null)
			return null;
		
		return redirectionReason.getUnsigned();
	}
	
	@Override
	public void setRedirectionReason(Long value)
	{
		if(value==null)
			this.redirectionReason = null;
		else
			this.redirectionReason = new RedirectionReasonImpl(value, null, null);
	}
	
	@Override
	public String getMSCAddress()
	{
		if(mscAddress==null)
			return null;
		
		return mscAddress.getString();
	}
	
	@Override
	public void setMSCAddress(String value)
	{
		if(value==null)
			this.mscAddress = null;
		else
			this.mscAddress = new MSCAddressImpl(value);
	}

	@Override
	public Long getTimeZone()
	{
		if(timeZone==null)
			return null;
		
		return timeZone.getUnsigned();
	}
	
	@Override
	public void setTimeZone(Long value)
	{
		if(value==null)
			this.timeZone = null;
		else
			this.timeZone = new TimeZoneImpl(value, null, null);
	}
	
	@Override
	public Long getAccessNetworkType()
	{
		if(accessNetworkType==null)
			return null;
		
		return accessNetworkType.getUnsigned();
	}
	
	@Override
	public void setAccessNetworkType(Long value)
	{
		if(value==null)
			this.accessNetworkType = null;
		else
			this.accessNetworkType = new AccessNetworkTypeImpl(value, null, null);
	}
	
	@Override
	public Long getServiceKey()
	{
		if(serviceKey==null)
			return null;
		
		return serviceKey.getUnsigned();
	}
	
	@Override
	public void setServiceKey(Long value)
	{
		if(value==null)
			this.serviceKey = null;
		else
			this.serviceKey = new ServiceKeyImpl(value, null, null);
	}
	
	@Override
	public Long getCallForwardIndicator()
	{
		if(callForwardIndicator==null)
			return null;
		
		return callForwardIndicator.getUnsigned();
	}
	
	@Override
	public void setCallForwardIndicator(Long value)
	{
		if(value==null)
			this.callForwardIndicator = null;
		else
			this.callForwardIndicator = new CallForwardIndicatorImpl(value, null, null);
	}
	
	@Override
	public String getUEIMSI()
	{
		if(ueIMSI==null)
			return null;
		
		return ueIMSI.getString();
	}
	
	@Override
	public void setUEIMSI(String value)
	{
		if(value==null)
			this.ueIMSI = null;
		else
			this.ueIMSI = new UEIMSIImpl(value);
	}
	
	@Override
	public String getOriginalCalledPartyId()
	{
		if(originalCalledPartyId==null)
			return null;
		
		return originalCalledPartyId.getString();
	}
	
	@Override
	public void setOriginalCalledPartyId(String value)
	{
		if(value==null)
			this.originalCalledPartyId = null;
		else
			this.originalCalledPartyId = new OriginalCalledPartyIdImpl(value);
	}
	
	@Override
	public String getCallReferenceNumber()
	{
		if(callReferenceNumber==null)
			return null;
		
		return callReferenceNumber.getString();
	}
	
	@Override
	public void setCallReferenceNumber(String value)
	{
		if(value==null)
			this.callReferenceNumber = null;
		else
			this.callReferenceNumber = new CallReferenceNumberImpl(value);
	}
	
	@Override
	public Date getSSPTime()
	{
		if(sspTime==null)
			return null;
		
		return sspTime.getDateTime();
	}
	
	@Override
	public void setSSPTime(Date value)
	{
		if(value==null)
			this.sspTime = null;
		else
			this.sspTime = new SSPTimeImpl(value, null, null);
	}
	
	@Override
	public Long getChargeFlowType()
	{
		if(chargeFlowType==null)
			return null;
		
		return chargeFlowType.getUnsigned();
	}
	
	@Override
	public void setChargeFlowType(Long value)
	{
		if(value==null)
			this.chargeFlowType = null;
		else
			this.chargeFlowType = new ChargeFlowTypeImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getBearerCapability()
	{
		if(bearerCapability==null)
			return null;
		
		return bearerCapability.getValue();
	}
	
	@Override
	public void setBearerCapability(ByteBuf value)
	{
		if(value==null)
			this.bearerCapability = null;
		else
			this.bearerCapability = new BearerCapabilityImpl(value);
	}
	
	@Override
	public Long getCallingLocationNumberNature()
	{
		if(callingLocationNumberNature==null)
			return null;
		
		return callingLocationNumberNature.getUnsigned();
	}
	
	@Override
	public void setCallingLocationNumberNature(Long value)
	{
		if(value==null)
			this.callingLocationNumberNature = null;
		else
			this.callingLocationNumberNature = new CallingLocationNumberNatureImpl(value, null, null);
	}
	
	@Override
	public Long getCalledPartyBCDNumberNature()
	{
		if(calledPartyBCDNumberNature==null)
			return null;
		
		return calledPartyBCDNumberNature.getUnsigned();
	}
	
	@Override
	public void setCalledPartyBCDNumberNature(Long value)
	{
		if(value==null)
			this.calledPartyBCDNumberNature = null;
		else
			this.calledPartyBCDNumberNature = new CalledPartyBCDNumberNatureImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getCalledLocationNumber()
	{
		if(calledLocationNumber==null)
			return null;
		
		return calledLocationNumber.getValue();
	}
	
	@Override
	public void setCalledLocationNumber(ByteBuf value)
	{
		if(value==null)
			this.calledLocationNumber = null;
		else
			this.calledLocationNumber = new CalledLocationNumberImpl(value);
	}
	
	@Override
	public Long getCalledLocationNumberNature()
	{
		if(calledLocationNumberNature==null)
			return null;
		
		return calledLocationNumberNature.getUnsigned();
	}
	
	@Override
	public void setCalledLocationNumberNature(Long value)
	{
		if(value==null)
			this.calledLocationNumberNature = null;
		else
			this.calledLocationNumberNature = new CalledLocationNumberNatureImpl(value, null, null);
	}
	
	@Override
	public Long getOriginalCalledPartyIdNature()
	{
		if(originalCalledPartyIdNature==null)
			return null;
		
		return originalCalledPartyIdNature.getUnsigned();
	}
	
	@Override
	public void setOriginalCalledPartyIdNature(Long value)
	{
		if(value==null)
			this.originalCalledPartyIdNature = null;
		else
			this.originalCalledPartyIdNature = new OriginalCalledPartyIdNatureImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getRerouteCalledNumber()
	{
		if(rerouteCalledNumber==null)
			return null;
		
		return rerouteCalledNumber.getValue();
	}
	
	@Override
	public void setRerouteCalledNumber(ByteBuf value)
	{
		if(value==null)
			this.rerouteCalledNumber = null;
		else
			this.rerouteCalledNumber = new RerouteCalledNumberImpl(value, null, null);
	}
	
	@Override
	public String getFunctionFlag()
	{
		if(functionFlag==null)
			return null;
		
		return functionFlag.getString();
	}
	
	@Override
	public void setFunctionFlag(String value)
	{
		if(value==null)
			this.functionFlag = null;
		else
			this.functionFlag = new FunctionFlagImpl(value);
	}
	
	@Override
	public String getPersonalPayNotifyMode()
	{
		if(personalPayNotifyMode==null)
			return null;
		
		return personalPayNotifyMode.getString();
	}
	
	@Override
	public void setPersonalPayNotifyMode(String value)
	{
		if(value==null)
			this.personalPayNotifyMode = null;
		else
			this.personalPayNotifyMode = new PersonalPayNotifyModeImpl(value);
	}
	
	@Override
	public String getUserPassWd()
	{
		if(userPassWd==null)
			return null;
		
		return userPassWd.getString();
	}
	
	@Override
	public void setUserPassWd(String value)
	{
		if(value==null)
			this.userPassWd = null;
		else
			this.userPassWd = new UserPasswdImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getIDDOriginateNumber()
	{
		if(iddOriginateNumber==null)
			return null;
		
		return iddOriginateNumber.getValue();
	}
	
	@Override
	public void setIDDOriginateNumber(ByteBuf value)
	{
		if(value==null)
			this.iddOriginateNumber = null;
		else
			this.iddOriginateNumber = new IDDOriginateNumberImpl(value);
	}
	
	@Override
	public Long getAddressOfRestrictedIndicator()
	{
		if(addressOfRestrictedIndicator==null)
			return null;
		
		return addressOfRestrictedIndicator.getUnsigned();
	}
	
	@Override
	public void setAddressOfRestrictedIndicator(Long value)
	{
		if(value==null)
			this.addressOfRestrictedIndicator = null;
		else
			this.addressOfRestrictedIndicator = new AddressOfRestrictedIndicatorImpl(value, null, null);
	}
	
	@Override
	public String getConnectCalledNumber()
	{
		if(connectCalledNumber==null)
			return null;
		
		return connectCalledNumber.getString();
	}
	
	@Override
	public void setConnectCalledNumber(String value)
	{
		if(value==null)
			this.connectCalledNumber = null;
		else
			this.connectCalledNumber = new ConnectCalledNumberImpl(value);
	}
	
	@Override
	public ByteBuf getCallingLocationNumber()
	{
		if(callingLocationNumber==null)
			return null;
		
		return callingLocationNumber.getValue();
	}
	
	@Override
	public void setCallingLocationNumber(ByteBuf value)
	{
		if(value==null)
			this.callingLocationNumber = null;
		else
			this.callingLocationNumber = new CallingLocationNumberImpl(value);
	}
	
	@Override
	public ByteBuf getCalledMscAddress()
	{
		if(calledMscAddress==null)
			return null;
		
		return calledMscAddress.getValue();
	}
	
	@Override
	public void setCalledMscAddress(ByteBuf value)
	{
		if(value==null)
			this.calledMscAddress = null;
		else
			this.calledMscAddress = new CalledMscAddressImpl(value);
	}
	
	@Override
	public Long getRedirectingPartyIdNature()
	{
		if(redirectingPartyIdNature==null)
			return null;
		
		return redirectingPartyIdNature.getUnsigned();
	}
	
	@Override
	public void setRedirectingPartyIdNature(Long value)
	{
		if(value==null)
			this.redirectingPartyIdNature = null;
		else
			this.redirectingPartyIdNature = new RedirectingPartyIdNatureImpl(value, null, null);
	}
	
	@Override
	public String getRealCalledNumber()
	{
		if(realCalledNumber==null)
			return null;
		
		return realCalledNumber.getString();
	}
	
	@Override
	public void setRealCalledNumber(String value)
	{
		if(value==null)
			this.realCalledNumber = null;
		else
			this.realCalledNumber = new RealCalledNumberImpl(value);
	}
	
	@Override
	public ByteBuf getCalledPartyBCDNumber()
	{
		if(calledPartyBCDNumber==null)
			return null;
		
		return calledPartyBCDNumber.getValue();
	}
	
	@Override
	public void setCalledPartyBCDNumber(ByteBuf value)
	{
		if(value==null)
			this.calledPartyBCDNumber = null;
		else
			this.calledPartyBCDNumber = new CalledPartyBCDNumberImpl(value);
	}
	
	@Override
	public Date getNewSSPTime()
	{
		if(newSSPTime==null)
			return null;
		
		return newSSPTime.getDateTime();
	}
	
	@Override
	public void setNewSSPTime(Date value)
	{
		if(value==null)
			this.newSSPTime = null;
		else
			this.newSSPTime = new NewSSPTimeImpl(value, null, null);
	}
	
	@Override
	public String getINAPCS1TariffClass()
	{
		if(inapCS1TariffClass==null)
			return null;
		
		return inapCS1TariffClass.getString();
	}
	
	@Override
	public void setINAPCS1TariffClass(String value)
	{
		if(value==null)
			this.inapCS1TariffClass = null;
		else
			this.inapCS1TariffClass = new INAPCS1TariffClassImpl(value, null, null);
	}
	
	@Override
	public String getCalledLAI()
	{
		if(calledLAI==null)
			return null;
		
		return calledLAI.getString();
	}
	
	@Override
	public void setCalledLAI(String value)
	{
		if(value==null)
			this.calledLAI = null;
		else
			this.calledLAI = new CalledLAIImpl(value, null, null);
	}
	
	@Override
	public Long getKeepVoiceFlag()
	{
		if(keepVoiceFlag==null)
			return null;
		
		return keepVoiceFlag.getUnsigned();
	}
	
	@Override
	public void setKeepVoiceFlag(Long value)
	{
		if(value==null)
			this.keepVoiceFlag = null;
		else
			this.keepVoiceFlag = new KeepVoiceFlagImpl(value, null, null);
	}
	
	@Override
	public List<ServiceParameterInfo> getServiceParameterInfo()
	{
		return serviceParameterInfo;
	}
	
	@Override
	public void setServiceParameterInfo(List<ServiceParameterInfo> value)
	{
		this.serviceParameterInfo = value;
	}
	
	@Override
	public Long getAlertLevel()
	{
		if(alertLevel==null)
			return null;
		
		return alertLevel.getUnsigned();
	}
	
	@Override
	public void setAlertLevel(Long value)
	{
		if(value==null)
			this.alertLevel = null;
		else
			this.alertLevel = new AlertLevelImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getGracePeriod()
	{
		if(gracePeriod==null)
			return null;
		
		return gracePeriod.getValue();
	}
	
	@Override
	public void setGracePeriod(ByteBuf value)
	{
		if(value==null)
			this.gracePeriod = null;
		else
			this.gracePeriod = new GracePeriodImpl(value);
	}
	
	@Override
	public ByteBuf getDisablePeriod()
	{
		if(disablePeriod==null)
			return null;
		
		return disablePeriod.getValue();
	}
	
	@Override
	public void setDisablePeriod(ByteBuf value)
	{
		if(value==null)
			this.disablePeriod = null;
		else
			this.disablePeriod = new DisablePeriodImpl(value);
	}
	
	@Override
	public Long getCallType()
	{
		if(callType==null)
			return null;
		
		return callType.getUnsigned();
	}
	
	@Override
	public void setCallType(Long value)
	{
		if(value==null)
			this.callType = null;
		else
			this.callType = new CallTypeImpl(value, null, null);
	}
	
	@Override
	public String getVPNNotifyFlag()
	{
		if(vpnNotifyFlag==null)
			return null;
		
		return vpnNotifyFlag.getString();
	}
	
	@Override
	public void setVPNNotifyFlag(String value)
	{
		if(value==null)
			this.vpnNotifyFlag = null;
		else
			this.vpnNotifyFlag = new VPNNotifyFlagImpl(value);
	}
	
	@Override
	public Long getFavAreaFlag()
	{
		if(favAreaFlag==null)
			return null;
		
		return favAreaFlag.getUnsigned();
	}
	
	@Override
	public void setFavAreaFlag(Long value)
	{
		if(value==null)
			this.favAreaFlag = null;
		else
			this.favAreaFlag = new FavAreaFlagImpl(value, null, null);
	}
	
	@Override
	public Integer getSameCUGNotFreeNotifyFlag()
	{
		if(sameCUGNotFreeNotifyFlag==null)
			return null;
		
		return sameCUGNotFreeNotifyFlag.getInteger();
	}
	
	@Override
	public void setSameCUGNotFreeNotifyFlag(Integer value)
	{
		if(value==null)
			this.sameCUGNotFreeNotifyFlag = null;
		else
			this.sameCUGNotFreeNotifyFlag = new SameCUGNotFreeNotifyFlagImpl(value, null, null);
	}
	
	@Override
	public Long getPersonalPayCostValue()
	{
		if(personalPayCostValue==null)
			return null;
		
		return personalPayCostValue.getLong();
	}
	
	@Override
	public void setPersonalPayCostValue(Long value)
	{
		if(value==null)
			this.personalPayCostValue = null;
		else
			this.personalPayCostValue = new PersonalPayCostValueImpl(value, null, null);
	}
	
	@Override
	public Long getActiveCurrencyCode()
	{
		if(activeCurrencyCode==null)
			return null;
		
		return activeCurrencyCode.getUnsigned();
	}
	
	@Override
	public void setActiveCurrencyCode(Long value)
	{
		if(value==null)
			this.activeCurrencyCode = null;
		else
			this.activeCurrencyCode = new ActiveCurrencyCodeImpl(value, null, null);
	}
	
	@Override
	public Long getSuspendReason()
	{
		if(suspendReason==null)
			return null;
		
		return suspendReason.getUnsigned();
	}
	
	@Override
	public void setSuspendReason(Long value)
	{
		if(value==null)
			this.suspendReason = null;
		else
			this.suspendReason = new SuspendReasonImpl(value, null, null);
	}
	
	@Override
	public Long getChargePartyType()
	{
		if(chargePartyType==null)
			return null;
		
		return chargePartyType.getUnsigned();
	}
	
	@Override
	public void setChargePartyType(Long value)
	{
		if(value==null)
			this.chargePartyType = null;
		else
			this.chargePartyType = new ChargePartyTypeImpl(value, null, null);
	}
	
	@Override
	public CreditUseNotification getCreditUseNotification()
	{
		return creditUseNotification;
	}
	
	@Override
	public void setCreditUseNotification(CreditUseNotification value)
	{
		this.creditUseNotification = value;
	}
	
	@Override
	public UserBasicInfo getUserBasicInfo()
	{
		return userBasicInfo;
	}
	
	@Override
	public void setUserBasicInfo(UserBasicInfo value)
	{
		this.userBasicInfo = value;
	}
	
	@Override
	public CommunityInformation getCommunityInformation()
	{
		return communityInformation;
	}
	
	@Override
	public void setCommunityInformation(CommunityInformation value)
	{
		this.communityInformation = value;
	}
	
	@Override
	public Long getSubscriberPayType()
	{
		if(subscriberPayType==null)
			return null;
		
		return subscriberPayType.getUnsigned();
	}
	
	@Override
	public void setSubscriberPayType(Long value)
	{
		if(value==null)
			this.subscriberPayType = null;
		else
			this.subscriberPayType = new SubscriberPayTypeImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getActivePeriod()
	{
		if(activePeriod==null)
			return null;
		
		return activePeriod.getValue();
	}
	
	@Override
	public void setActivePeriod(ByteBuf value)
	{
		if(value==null)
			this.activePeriod = null;
		else
			this.activePeriod = new ActivePeriodImpl(value);
	}
	
	@Override
	public AnnouncementData getAnnouncementData()
	{
		return announcementData;
	}
	
	@Override
	public void setAnnouncementData(AnnouncementData value)
	{
		this.announcementData = value;
	}
	
	@Override
	public List<NoticeInformation> getNoticeInformation()
	{
		return noticeInformation;
	}
	
	@Override
	public void setNoticeInformation(List<NoticeInformation> value)
	{
		this.noticeInformation = value;
	}
	
	@Override
	public Integer getShareCallPercent()
	{
		if(shareCallPercent==null)
			return null;
		
		return shareCallPercent.getInteger();
	}
	
	@Override
	public void setShareCallPercent(Integer value)
	{
		if(value==null)
			this.shareCallPercent = null;
		else
			this.shareCallPercent = new ShareCallPercentImpl(value, null, null);
	}
	
	@Override
	public Long getServiceFreeIndicator()
	{
		if(serviceFreeIndicator==null)
			return null;
		
		return serviceFreeIndicator.getUnsigned();
	}
	
	@Override
	public void setServiceFreeIndicator(Long value)
	{
		if(value==null)
			this.serviceFreeIndicator = null;
		else
			this.serviceFreeIndicator = new ServiceFreeIndicatorImpl(value, null, null);
	}
	
	@Override
	public Integer getHandleOverToolboxFlag()
	{
		if(handleOverToolboxFlag==null)
			return null;
		
		return handleOverToolboxFlag.getInteger();
	}
	
	@Override
	public void setHandleOverToolboxFlag(Integer value)
	{
		if(value==null)
			this.handleOverToolboxFlag = null;
		else
			this.handleOverToolboxFlag = new HandleOverToolboxFlagImpl(value, null, null);
	}
	
	@Override
	public String getCallBeginTime()
	{
		if(callBeginTime==null)
			return null;
		
		return callBeginTime.getString();
	}
	
	@Override
	public void setCallBeginTime(String value)
	{
		if(value==null)
			this.callBeginTime = null;
		else
			this.callBeginTime = new CallBeginTimeImpl(value, null, null);
	}
	
	@Override
	public Integer getAdjustRoamingType()
	{
		if(adjustRoamingType==null)
			return null;
		
		return adjustRoamingType.getInteger();
	}
	
	@Override
	public void setAdjustRoamingType(Integer value)
	{
		if(value==null)
			this.adjustRoamingType = null;
		else
			this.adjustRoamingType = new AdjustRoamingTypeImpl(value, null, null);
	}
	
	@Override
	public Long getTotalCostFlag()
	{
		if(totalCostFlag==null)
			return null;
		
		return totalCostFlag.getUnsigned();
	}
	
	@Override
	public void setTotalCostFlag(Long value)
	{
		if(value==null)
			this.totalCostFlag = null;
		else
			this.totalCostFlag = new TotalCostFlagImpl(value, null, null);
	}
	
	@Override
	public Integer getReleaseReason()
	{
		if(releaseReason==null)
			return null;
		
		return releaseReason.getInteger();
	}
	
	@Override
	public void setReleaseReason(Integer value)
	{
		if(value==null)
			this.releaseReason = null;
		else
			this.releaseReason = new ReleaseReasonImpl(value, null, null);
	}
	
	@Override
	public AccountInfo getAccountInfo()
	{
		return accountInfo;
	}
	
	@Override
	public void setAccountInfo(AccountInfo value)
	{
		this.accountInfo = value;
	}
	
	@Override
	public String getCalledPartyNP()
	{
		if(calledPartyNP==null)
			return null;
		
		return calledPartyNP.getString();
	}
	
	@Override
	public void setCalledPartyNP(String value)
	{
		if(value==null)
			this.calledPartyNP = null;
		else
			this.calledPartyNP = new CalledPartyNPImpl(value);
	}
	
	@Override
	public String getCallingPartyNP()
	{
		if(callingPartyNP==null)
			return null;
		
		return callingPartyNP.getString();
	}
	
	@Override
	public void setCallingPartyNP(String value)
	{
		if(value==null)
			this.callingPartyNP = null;
		else
			this.callingPartyNP = new CallingPartyNPImpl(value);
	}
	
	@Override
	public FavCellIdFlagEnum getFavCellIdFlag()
	{
		if(favCellIdFlag==null)
			return null;
		
		return favCellIdFlag.getEnumerated(FavCellIdFlagEnum.class);
	}
	
	@Override
	public void setFavCellIdFlag(FavCellIdFlagEnum value)
	{
		if(value==null)
			this.favCellIdFlag = null;
		else
			this.favCellIdFlag = new FavCellIdFlagImpl(value, null, null);
	}
	
	@Override
	public RechargeInformation getRechargeInformation()
	{
		return rechargeInformation;
	}
	
	@Override
	public void setRechargeInformation(RechargeInformation value)
	{
		this.rechargeInformation = value;
	}
	
	@Override
	public Long getActiveMethod()
	{
		if(activeMethod==null)
			return null;
		
		return activeMethod.getUnsigned();
	}
	
	@Override
	public void setActiveMethod(Long value)
	{
		if(value==null)
			this.activeMethod = null;
		else
			this.activeMethod = new ActiveMethodImpl(value, null, null);
	}
	
	@Override
	public String getOperatorID()
	{
		if(operatorID==null)
			return null;
		
		return operatorID.getString();
	}
	
	@Override
	public void setOperatorID(String value)
	{
		if(value==null)
			this.operatorID = null;
		else
			this.operatorID = new OperatorIDImpl(value);
	}
	
	@Override
	public Long getAccountQueryMethod()
	{
		if(accountQueryMethod==null)
			return null;
		
		return accountQueryMethod.getUnsigned();
	}
	
	@Override
	public void setAccountQueryMethod(Long value)
	{
		if(value==null)
			this.accountQueryMethod = null;
		else
			this.accountQueryMethod = new AccountQueryMethodImpl(value, null, null);
	}
	
	@Override
	public Long getAccountType()
	{
		if(accountType==null)
			return null;
		
		return accountType.getUnsigned();
	}
	
	@Override
	public void setAccountType(Long value)
	{
		if(value==null)
			this.accountType = null;
		else
			this.accountType = new AccountTypeImpl(value, null, null);
	}
	
	@Override
	public CCMoney getCCMoney()
	{
		return ccMoney;
	}
	
	@Override
	public void setCCMoney(CCMoney value)
	{
		this.ccMoney = value;
	}
	
	@Override
	public Long getFixRentFee()
	{
		if(fixRentFee==null)
			return null;
		
		return fixRentFee.getUnsigned();
	}
	
	@Override
	public void setFixRentFee(Long value)
	{
		if(value==null)
			this.fixRentFee = null;
		else
			this.fixRentFee = new FixRentFeeImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getNextBillDateTime()
	{
		if(nextBillDateTime==null)
			return null;
		
		return nextBillDateTime.getValue();
	}
	
	@Override
	public void setNextBillDateTime(ByteBuf value)
	{
		if(value==null)
			this.nextBillDateTime = null;
		else
			this.nextBillDateTime = new NextBillDateTimeImpl(value);
	}
	
	@Override
	public Long getAmountBeforeRecharge()
	{
		if(amountBeforeRecharge==null)
			return null;
		
		return amountBeforeRecharge.getUnsigned();
	}
	
	@Override
	public void setAmountBeforeRecharge(Long value)
	{
		if(value==null)
			this.amountBeforeRecharge = null;
		else
			this.amountBeforeRecharge = new AmountBeforeRechargeImpl(value, null, null);
	}
	
	@Override
	public	Long getRchgExtActKey()
	{
		if(rchgExtActKey==null)
			return null;
		
		return rchgExtActKey.getUnsigned();
	}
	
	@Override
	public void setRchgExtActKey(Long value)
	{
		if(value==null)
			this.rchgExtActKey = null;
		else
			this.rchgExtActKey = new RchgExtActKeyImpl(value, null, null);
	}
	
	@Override
	public AccountChangeInfo getAccountChangeInfo()
	{
		return accountChangeInfo;
	}
	
	@Override
	public void setAccountChangeInfo(AccountChangeInfo value)
	{
		this.accountChangeInfo = value;
	}
	
	@Override
	public CumInfo getCumInfo()
	{
		return cumInfo;
	}
	
	@Override
	public void setCumInfo(CumInfo value)
	{
		this.cumInfo = value;
	}
	
	@Override
	public Long getParentLimitValue()
	{
		if(parentLimitValue==null)
			return null;
		
		return parentLimitValue.getLong();
	}
	
	@Override
	public void setParentLimitValue(Long value)
	{
		if(value==null)
			this.parentLimitValue = null;
		else
			this.parentLimitValue = new ParentLimitValueImpl(value, null, null);
	}
	
	@Override
	public String getAdditionalInfo()
	{
		if(additionalInfo==null)
			return null;
		
		return additionalInfo.getString();
	}
	
	@Override
	public void setAdditionalInfo(String value)
	{
		if(value==null)
			this.additionalInfo = null;
		else
			this.additionalInfo = new AdditionalInfoImpl(value);
	}
	
	@Override
	public ChargeConfirmFlagEnum getChargeConfirmFlag()
	{
		if(chargeConfirmFlag==null)
			return null;
		
		return chargeConfirmFlag.getEnumerated(ChargeConfirmFlagEnum.class);
	}
	
	@Override
	public void setChargeConfirmFlag(ChargeConfirmFlagEnum value)
	{
		if(value==null)
			this.chargeConfirmFlag = null;
		else
			this.chargeConfirmFlag = new ChargeConfirmFlagImpl(value, null, null);
	}
	
	@Override
	public Long getMainProductID()
	{
		if(mainProductID==null)
			return null;
		
		return mainProductID.getUnsigned();
	}
	
	@Override
	public void setMainProductID(Long value)
	{
		if(value==null)
			this.mainProductID = null;
		else
			this.mainProductID = new MainProductIDImpl(value, null, null);
	}
	
	@Override
	public Long getIVRLang()
	{
		if(ivrLang==null)
			return null;
		
		return ivrLang.getUnsigned();
	}
	
	@Override
	public void setIVRLang(Long value)
	{
		if(value==null)
			this.ivrLang = null;
		else
			this.ivrLang = new IVRLangImpl(value, null, null);
	}
	
	@Override
	public Long getSMSLang()
	{
		if(smsLang==null)
			return null;
		
		return smsLang.getUnsigned();
	}
	
	@Override
	public void setSMSLang(Long value)
	{
		if(value==null)
			this.smsLang = null;
		else
			this.smsLang = new SMSLangImpl(value, null, null);
	}
	
	@Override
	public Long getPayType()
	{
		if(payType==null)
			return null;
		
		return payType.getUnsigned();
	}
	
	@Override
	public void setPayType(Long value)
	{
		if(value==null)
			this.payType = null;
		else
			this.payType = new PayTypeImpl(value, null, null);
	}
	
	@Override
	public Long getBrand()
	{
		if(brand==null)
			return null;
		
		return brand.getUnsigned();
	}
	
	@Override
	public void setBrand(Long value)
	{
		if(value==null)
			this.brand = null;
		else
			this.brand = new BrandImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getActivationDate()
	{
		if(activationDate==null)
			return null;
		
		return activationDate.getValue();
	}
	
	@Override
	public void setActivationDate(ByteBuf value)
	{
		if(value==null)
			this.activationDate = null;
		else
			this.activationDate = new ActivationDateImpl(value);
	}
	
	@Override
	public String getManagementState()
	{
		if(managementState==null)
			return null;
		
		return managementState.getString();
	}
	
	@Override
	public void setManagementState(String value)
	{
		if(value==null)
			this.managementState = null;
		else
			this.managementState = new ManagementStateImpl(value);
	}
	
	@Override
	public Long getState()
	{
		if(state==null)
			return null;
		
		return state.getUnsigned();
	}
	
	@Override
	public void setState(Long value)
	{
		if(value==null)
			this.state = null;
		else
			this.state = new StateImpl(value, null, null);
	}
	
	@Override
	public Long getPPSBalance()
	{
		if(ppsBalance==null)
			return null;
		
		return ppsBalance.getLong();
	}
	
	@Override
	public void setPPSBalance(Long value)
	{
		if(value==null)
			this.ppsBalance = null;
		else
			this.ppsBalance = new PPSBalanceImpl(value, null, null);
	}
	
	@Override
	public Long getPOSBalance()
	{
		if(posBalance==null)
			return null;
		
		return posBalance.getLong();
	}
	
	@Override
	public void setPOSBalance(Long value)
	{
		if(value==null)
			this.posBalance = null;
		else
			this.posBalance = new POSBalanceImpl(value, null, null);
	}
	
	@Override
	public Long getSSPNO()
	{
		if(sspno==null)
			return null;
		
		return sspno.getUnsigned();
	}
	
	@Override
	public void setSSPNO(Long value)
	{
		if(value==null)
			this.sspno = null;
		else
			this.sspno = new SSPNOImpl(value, null, null);
	}
	
	@Override
	public Integer getChargeNumberNature()
	{
		if(chargeNumberNature==null)
			return null;
		
		return chargeNumberNature.getInteger();
	}
	
	@Override
	public void setChargeNumberNature(Integer value)
	{
		if(value==null)
			this.chargeNumberNature = null;
		else
			this.chargeNumberNature = new ChargeNumberNatureImpl(value, null, null);
	}
}