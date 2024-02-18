package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei;
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

import com.mobius.software.telco.protocols.diameter.HuaweiAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CCMoney;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
/* 	3.2.81  IN-Information AVP
	
	AVP Name
	IN-Information
	
	AVP Code
	20300

	AVP Data Type
	Grouped

	Vendor ID
	2011

	Description
	Indicates the intelligent network information.
	
	The IN-Information AVP is an AVP group. The detailed ABNF syntax is as follows ( mix of all possible usages together ):
	IN-Information ::= <AVP Header: 20300> 
                     [Active-Flag]
					 [Calling-Vlr-Number]
					 [Calling-Msc-Address]
					 [Calling-CellID-Or-SAI]
					 [Access-Method]
					 [Auth-Information]
					*[BalanceInfo]
					 [Calling-Party-Address]
					 [Called-Party-Address]
					 [Called-Short-Number]
					 [Specific-Output]
					 [Calling-Partys-Category]
					 [Calling-Party-Address-Nature]
					 [Called-Party-Address-Nature]
					 [Calling-LAI]
					 [Called-Vlr-Number]
					 [Called-CellID-Or-SAI]
					 [Called-IMEI]
					 [Calling-IMEI]
					 [Additional-Calling-Party-Number]
					 [Redirecting-Party-Id]
					 [Redirection-Reason]
					 [MSCAddress]
					 [Time-Zone]
					 [Access-Network-Type]
					 [Service-Key]
					 [Call-Forward-Indicator]
					 [UE-IMSI]
				 	 [Original-Called-Party-Id]
					 [Call-Reference-Number]
					 [Route-Prefix]
					 [SSP-Time]
					 [Charge-Flow-Type]
					 [Bearer-Capability]
					 [Calling-Location-Number-Nature]
					 [called-Party-BCDNumber-Nature]
					 [Called-Location-Number]
					 [Called-Location-Number-Nature]
					 [Original-Called-Party-Id-Nature]
					 [Reroute-Called-Number]
					 [FunctionFlag]
					 [VPNCall-Auth-Flag]
					 [PersonalPayNotifyMode]
					 [UserPassWd]
					 [IDD-Originate-Number]
					 [Address-Of-Restricted-Indicator]
					 [Connect-Called-Number]
					 [Calling-Location-Number]
					 [Called-Msc-Address]
					 [Redirecting-Party-Id-Nature]
					 [Real-Called-Number]
					 [called-Party-BCDNumber]
					 [Original-Redirecting-Party-Id]
					 [New-SSP-Time]
					 [INAPCS1-Tariff-Class]
					 [Called-LAI]
					 [Keepvoiceflag]
					*[Service-Parameter-Info]
					 [Alert-Level]
					 [graceperiod]
					 [disableperiod]
					 [Call-Type]
					 [VPNNotifyFlag]
					 [FavAreaFlag]
					 [SameCUGNotFreeNotifyFlag]
					 [PersonalPayCostValue]
					 [ActiveCurrencyCode]
					 [SuspendReason]
					 [ChargePartyType]
					 [Credit-Use-Notification]
					 [User-Basic-info]
					 [Community-information]
					 [Subscriber-Pay-Type]
					 [ActivePeriod]
					 [Announcement-Data]
					*[Notice-Information]
					 [ShareCallPercent]
					 [Service-Free-Indicator]
					 [HandleOver-Toolbox-Flag]
					 [Call-Begin-Time]
					 [Adjust-Roaming-Type]
					 [Total-Cost-Flag]
					 [Release-Reason]
					 [AccountInfo]
					 [Called-Party-NP]
					 [Calling-Party-NP]
					 [FavCellIdFlag]
					 [Recharge-Information]
					 [ActiveMethod]
					 [OperatorID]
					 [Account-Query-Method]
					 [Account-Type]
					 [CC-Money]
					 [Fix-Rent-Fee]
					 [Next-Bill-Datetime]
					 [Amount-Before-Recharge]
					 [RchgExtActKey]
					 [Account-Change-Info]
					 [CumInfo]
					 [Parentlimitvalue]
					 [AdditionalInfo]
					 [Charge-ConfirmFlag]
					 [MainProductID]
					 [IVRLang]
					 [SMSLang]
					 [PayType]
					 [Brand]
					 [ActivationDate]
					 [managementstate]
					 [State]
					 [PPSBalance]
					 [POSBalance]
*/
@DiameterAvpDefinition(code = HuaweiAvpCodes.IN_INFORMATION, vendorId = VendorIDs.HUAWEI_ID, name = "P2PSMS-Information")
public interface INInformation extends DiameterAvp 
{
	Integer getActiveFlag();
	
	void setActiveFlag(Integer value);
	
	String getCallingVlrNumber();
	
	void setCallingVlrNumber(String value);
	
	ByteBuf getCallingMscAddress();
	
	void setCallingMscAddress(ByteBuf value);
	
	String getCallingCellIDOrSAI();
	
	void setCallingCellIDOrSAI(String value);
	
	Long getAccessMethod();
	
	void setAccessMethod(Long value);
	
	AuthInformation getAuthInformation();
	
	void setAuthInformation(AuthInformation value);
	
	List<BalanceInfo> getBalanceInfo();
	
	void setBalanceInfo(List<BalanceInfo> value);
	
	String getCallingPartyAddress();
	
	void setCallingPartyAddress(String value);
	
	String getCalledPartyAddress();
	
	void setCalledPartyAddress(String value);
	
	String getCalledShortNumber();
	
	void setCalledShortNumber(String value);
	
	Long getSpecificOutput();
	
	void setSpecificOutput(Long value);
	
	Long getCallingPartysCategory();
	
	void setCallingPartysCategory(Long value);
	
	Long getCallingPartyAddressNature();
	
	void setCallingPartyAddressNature(Long value);
	
	Long getCalledPartyAddressNature();
	
	void setCalledPartyAddressNature(Long value);
	
	String getCallingLAI();
	
	void setCallingLAI(String value);
	
	String getCalledVlrNumber();
	
	void setCalledVlrNumber(String value);
	
	String getCalledCellIDOrSAI();
	
	void setCalledCellIDOrSAI(String value);
	
	String getCalledIMEI();
	
	void setCalledIMEI(String value);
	
	String getCallingIMEI();
	
	void setCallingIMEI(String value);
	
	String getRedirectingPartyId();
	
	void setRedirectingPartyId(String value);
	
	Long getRedirectionReason();
	
	void setRedirectionReason(Long value);
	
	String getMSCAddress();
	
	void setMSCAddress(String value);
	
	Long getTimeZone();
	
	void setTimeZone(Long value);
	
	Long getAccessNetworkType();
	
	void setAccessNetworkType(Long value);
	
	Long getServiceKey();
	
	void setServiceKey(Long value);
	
	Long getCallForwardIndicator();
	
	void setCallForwardIndicator(Long value);
	
	String getUEIMSI();
	
	void setUEIMSI(String value);
	
	String getOriginalCalledPartyId();
	
	void setOriginalCalledPartyId(String value);
	
	String getCallReferenceNumber();
	
	void setCallReferenceNumber(String value);
	
	Date getSSPTime();
	
	void setSSPTime(Date value);
	
	Long getChargeFlowType();
	
	void setChargeFlowType(Long value);
	
	ByteBuf getBearerCapability();
	
	void setBearerCapability(ByteBuf value);
	
	Long getCallingLocationNumberNature();
	
	void setCallingLocationNumberNature(Long value);
	
	Long getCalledPartyBCDNumberNature();
	
	void setCalledPartyBCDNumberNature(Long value);
	
	ByteBuf getCalledLocationNumber();
	
	void setCalledLocationNumber(ByteBuf value);
	
	Long getCalledLocationNumberNature();
	
	void setCalledLocationNumberNature(Long value);
	
	Long getOriginalCalledPartyIdNature();
	
	void setOriginalCalledPartyIdNature(Long value);
	
	ByteBuf getRerouteCalledNumber();
	
	void setRerouteCalledNumber(ByteBuf value);
	
	String getFunctionFlag();
	
	void setFunctionFlag(String value);
	
	String getPersonalPayNotifyMode();
	
	void setPersonalPayNotifyMode(String value);
	
	String getUserPassWd();
	
	void setUserPassWd(String value);
	
	ByteBuf getIDDOriginateNumber();
	
	void setIDDOriginateNumber(ByteBuf value);
	
	Long getAddressOfRestrictedIndicator();
	
	void setAddressOfRestrictedIndicator(Long value);
	
	String getConnectCalledNumber();
	
	void setConnectCalledNumber(String value);
	
	ByteBuf getCallingLocationNumber();
	
	void setCallingLocationNumber(ByteBuf value);
	
	ByteBuf getCalledMscAddress();
	
	void setCalledMscAddress(ByteBuf value);
	
	Long getRedirectingPartyIdNature();
	
	void setRedirectingPartyIdNature(Long value);
	
	String getRealCalledNumber();
	
	void setRealCalledNumber(String value);
	
	ByteBuf getCalledPartyBCDNumber();
	
	void setCalledPartyBCDNumber(ByteBuf value);
	
	Date getNewSSPTime();
	
	void setNewSSPTime(Date value);
	
	String getINAPCS1TariffClass();
	
	void setINAPCS1TariffClass(String value);
	
	String getCalledLAI();
	
	void setCalledLAI(String value);
	
	Long getKeepVoiceFlag();
	
	void setKeepVoiceFlag(Long value);
	
	List<ServiceParameterInfo> getServiceParameterInfo();
	
	void setServiceParameterInfo(List<ServiceParameterInfo> value);
	
	Long getAlertLevel();
	
	void setAlertLevel(Long value);
	
	ByteBuf getGracePeriod();
	
	void setGracePeriod(ByteBuf value);
	
	ByteBuf getDisablePeriod();
	
	void setDisablePeriod(ByteBuf value);
	
	Long getCallType();
	
	void setCallType(Long value);
	
	String getVPNNotifyFlag();
	
	void setVPNNotifyFlag(String value);
	
	Long getFavAreaFlag();
	
	void setFavAreaFlag(Long value);
	
	Integer getSameCUGNotFreeNotifyFlag();
	
	void setSameCUGNotFreeNotifyFlag(Integer value);
	
	Long getPersonalPayCostValue();
	
	void setPersonalPayCostValue(Long value);
	
	Long getActiveCurrencyCode();
	
	void setActiveCurrencyCode(Long value);
	
	Long getSuspendReason();
	
	void setSuspendReason(Long value);
	
	Long getChargePartyType();
	
	void setChargePartyType(Long value);
	
	CreditUseNotification getCreditUseNotification();
	
	void setCreditUseNotification(CreditUseNotification value);
	
	UserBasicInfo getUserBasicInfo();
	
	void setUserBasicInfo(UserBasicInfo value);
	
	CommunityInformation getCommunityInformation();
	
	void setCommunityInformation(CommunityInformation value);
	
	Long getSubscriberPayType();
	
	void setSubscriberPayType(Long value);
	
	ByteBuf getActivePeriod();
	
	void setActivePeriod(ByteBuf value);
	
	AnnouncementData getAnnouncementData();
	
	void setAnnouncementData(AnnouncementData value);
	
	List<NoticeInformation> getNoticeInformation();
	
	void setNoticeInformation(List<NoticeInformation> value);
	
	Integer getShareCallPercent();
	
	void setShareCallPercent(Integer value);
	
	Long getServiceFreeIndicator();
	
	void setServiceFreeIndicator(Long value);
	
	Integer getHandleOverToolboxFlag();
	
	void setHandleOverToolboxFlag(Integer value);
	
	String getCallBeginTime();
	
	void setCallBeginTime(String value);
	
	Integer getAdjustRoamingType();
	
	void setAdjustRoamingType(Integer value);
	
	Long getTotalCostFlag();
	
	void setTotalCostFlag(Long value);
	
	Integer getReleaseReason();
	
	void setReleaseReason(Integer value);
	
	AccountInfo getAccountInfo();
	
	void setAccountInfo(AccountInfo value);
	
	String getCalledPartyNP();
	
	void setCalledPartyNP(String value);
	
	String getCallingPartyNP();
	
	void setCallingPartyNP(String value);
	
	FavCellIdFlagEnum getFavCellIdFlag();
	
	void setFavCellIdFlag(FavCellIdFlagEnum value);
	
	RechargeInformation getRechargeInformation();
	
	void setRechargeInformation(RechargeInformation value);
	
	Long getActiveMethod();
	
	void setActiveMethod(Long value);
	
	String getOperatorID();
	
	void setOperatorID(String value);
	
	Long getAccountQueryMethod();
	
	void setAccountQueryMethod(Long value);
	
	Long getAccountType();
	
	void setAccountType(Long value);
	
	CCMoney getCCMoney();
	
	void setCCMoney(CCMoney value);
	
	Long getFixRentFee();
	
	void setFixRentFee(Long value);
	
	ByteBuf getNextBillDateTime();
	
	void setNextBillDateTime(ByteBuf value);
	
	Long getAmountBeforeRecharge();
	
	void setAmountBeforeRecharge(Long value);
	
	Long getRchgExtActKey();
	
	void setRchgExtActKey(Long value);
	
	AccountChangeInfo getAccountChangeInfo();
	
	void setAccountChangeInfo(AccountChangeInfo value);
	
	CumInfo getCumInfo();
	
	void setCumInfo(CumInfo value);
	
	Long getParentLimitValue();
	
	void setParentLimitValue(Long value);
	
	String getAdditionalInfo();
	
	void setAdditionalInfo(String value);
	
	ChargeConfirmFlagEnum getChargeConfirmFlag();
	
	void setChargeConfirmFlag(ChargeConfirmFlagEnum value);
	
	Long getMainProductID();
	
	void setMainProductID(Long value);
	
	Long getIVRLang();
	
	void setIVRLang(Long value);
	
	Long getSMSLang();
	
	void setSMSLang(Long value);
	
	Long getPayType();
	
	void setPayType(Long value);
	
	Long getBrand();
	
	void setBrand(Long value);
	
	ByteBuf getActivationDate();
	
	void setActivationDate(ByteBuf value);
	
	String getManagementState();
	
	void setManagementState(String value);
	
	Long getState();
	
	void setState(Long value);
	
	Long getPPSBalance();
	
	void setPPSBalance(Long value);
	
	Long getPOSBalance();
	
	void setPOSBalance(Long value);
	
	Long getSSPNO();
	
	void setSSPNO(Long value);
	
	Integer getChargeNumberNature();
	
	void setChargeNumberNature(Integer value);
}