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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CalledIMEI;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CallingIMEI;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.DCS;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.DestAddress;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.DestIMSI;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.FeeFixed;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.FeeFlag;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.FeeSingle;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.FeeType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.MOMSCAddr;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.MTMSCAddr;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.MessagePid;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.NotifyMode;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.OperationResult;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.OrigIMSI;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.OriginalCalledPartyId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.OriginalCalledPartyIdNature;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.P2PSMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SMId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SMLength;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SMSCAddress;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SPIdBinary;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SendResult;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SmsType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SourceAddress;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.StatusReportRequest;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.VMccMncAddr;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class P2PSMSInformationImpl extends DiameterAvpImpl implements P2PSMSInformation 
{
	private SmsType smsType;
	
	private SMSCAddress smscAddress;
	
	private SMId smId;
	
	private SMLength smLength;
	
	private MOMSCAddr moMSCAddr;
	
	private MTMSCAddr mtMSCAddr;
	
	private SourceAddress sourceAddress;
	
	private DestAddress destAddress;
	
	private FeeFlag feeFlag;
	
	private FeeType feeType;
	
	private FeeSingle feeSingle;
	
	private FeeFixed feeFixed;
	
	private MessagePid messagePid;
	
	private OrigIMSI origIMSI;
	
	private DestIMSI destIMSI;
	
	private StatusReportRequest statusReportRequest;
	
	private CallingIMEI callingIMEI;
	
	private CalledIMEI calledIMEI;
	
	private SendResult sendResult;
	
	private SPIdBinary spId;
	
	private DCS dcs;
	
	private VMccMncAddr vmccMncAddr;
	
	private OriginalCalledPartyId originalCalledPartyId;
	
	private OriginalCalledPartyIdNature originalCalledPartyIdNature;
	
	private NotifyMode notifyMode;
	
	private OperationResult operationResult;
	
	public P2PSMSInformationImpl()
	{
		
	}
	
	@Override
	public Long getSmsType()
	{
		if(smsType==null)
			return null;
		
		return smsType.getUnsigned();
	}
	
	@Override
	public void setSmsType(Long value)
	{
		if(value==null)
			this.smsType = null;
		else
			this.smsType = new SmsTypeImpl(value, null, null);
	}
	
	@Override
	public String getSMSCAddress()
	{
		if(smscAddress==null)
			return null;
		
		return smscAddress.getString();
	}
	
	@Override
	public void setSMSCAddress(String value)
	{
		if(value==null)
			this.smscAddress = null;
		else
			this.smscAddress = new SMSCAddressImpl(value);
	}
	
	@Override
	public String getSMId()
	{
		if(smId==null)
			return null;
		
		return smId.getString();
	}
	
	@Override
	public void setSMId(String value)
	{
		if(value==null)
			this.smId = null;
		else
			this.smId = new SMIdImpl(value);
	}
	
	@Override
	public Long getSMLength()
	{
		if(smLength==null)
			return null;
		
		return smLength.getUnsigned();
	}
	
	@Override
	public void setSMLength(Long value)
	{
		if(value==null)
			this.smLength = null;
		else
			this.smLength = new SMLengthImpl(value, null, null);
	}
	
	@Override
	public String getMOMSCAddr()
	{
		if(moMSCAddr==null)
			return null;
		
		return moMSCAddr.getString();
	}
	
	@Override
	public void setMOMSCAddr(String value)
	{
		if(value==null)
			this.moMSCAddr = null;
		else
			this.moMSCAddr = new MOMSCAddrImpl(value);
	}
	
	@Override
	public String getMTMSCAddr()
	{
		if(mtMSCAddr==null)
			return null;
		
		return mtMSCAddr.getString();
	}
	
	@Override
	public void setMTMSCAddr(String value)
	{
		if(value==null)
			this.mtMSCAddr = null;
		else
			this.mtMSCAddr = new MTMSCAddrImpl(value);
	}
	
	@Override
	public String getSourceAddress()
	{
		if(sourceAddress==null)
			return null;
		
		return sourceAddress.getString();
	}
	
	@Override
	public void setSourceAddress(String value)
	{
		if(value==null)
			this.sourceAddress = null;
		else
			this.sourceAddress = new SourceAddressImpl(value);
	}	
	
	@Override
	public String getDestAddress()
	{
		if(destAddress==null)
			return null;
		
		return destAddress.getString();
	}
	
	@Override
	public void setDestAddress(String value)
	{
		if(value==null)
			this.destAddress = null;
		else
			this.destAddress = new DestAddressImpl(value);
	}			
	
	@Override
	public Long getFeeFlag()
	{
		if(feeFlag==null)
			return null;
		
		return feeFlag.getUnsigned();
	}
	
	@Override
	public void setFeeFlag(Long value)
	{
		if(value==null)
			this.feeFlag = null;
		else
			this.feeFlag = new FeeFlagImpl(value, null, null);
	}			
	
	@Override
	public Long getFeeType()
	{
		if(feeType==null)
			return null;
		
		return feeType.getUnsigned();
	}
	
	@Override
	public void setFeeType(Long value)
	{
		if(value==null)
			this.feeType = null;
		else
			this.feeType = new FeeTypeImpl(value, null, null);
	}			
	
	@Override
	public Long getFeeSingle()
	{
		if(feeSingle==null)
			return null;
		
		return feeSingle.getUnsigned();
	}
	
	@Override
	public void setFeeSingle(Long value)
	{
		if(value==null)
			this.feeSingle = null;
		else
			this.feeSingle = new FeeSingleImpl(value, null, null);
	}			
	
	@Override
	public Long getFeeFixed()
	{
		if(feeFixed==null)
			return null;
		
		return feeFixed.getUnsigned();
	}
	
	@Override
	public void setFeeFixed(Long value)
	{
		if(value==null)
			this.feeFixed = null;
		else
			this.feeFixed = new FeeFixedImpl(value, null, null);
	}
	
	@Override
	public Long getMessagePid()
	{
		if(messagePid==null)
			return null;
		
		return messagePid.getUnsigned();
	}
	
	@Override
	public void setMessagePid(Long value)
	{
		if(value==null)
			this.messagePid = null;
		else
			this.messagePid = new MessagePidImpl(value, null, null);
	}	
	
	@Override
	public String getOrigIMSI()
	{
		if(origIMSI==null)
			return null;
		
		return origIMSI.getString();
	}
	
	@Override
	public void setOrigIMSI(String value)
	{
		if(value==null)
			this.origIMSI = null;
		else
			this.origIMSI = new OrigIMSIImpl(value);
	}
	        
	@Override
	public String getDestIMSI()
	{
		if(destIMSI==null)
			return null;
		
		return destIMSI.getString();
	}
	
	@Override
	public void setDestIMSI(String value)
	{
		if(value==null)
			this.destIMSI = null;
		else
			this.destIMSI = new DestIMSIImpl(value);
	}
	
	@Override
	public Long getStatusReportRequest()
	{
		if(statusReportRequest==null)
			return null;
		
		return statusReportRequest.getUnsigned();
	}
	
	@Override
	public void setStatusReportRequest(Long value)
	{
		if(value==null)
			this.statusReportRequest = null;
		else
			this.statusReportRequest = new StatusReportRequestImpl(value, null, null);
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
	public Long getSendResult()
	{
		if(sendResult==null)
			return null;
		
		return sendResult.getUnsigned();
	}
	
	@Override
	public void setSendResult(Long value)
	{
		if(value==null)
			this.sendResult = null;
		else
			this.sendResult = new SendResultImpl(value, null, null);
	}
	        
	@Override
	public ByteBuf getSPId()
	{
		if(spId==null)
			return null;
		
		return spId.getValue();
	}
	
	@Override
	public void setSPId(ByteBuf value)
	{
		if(value==null)
			this.spId = null;
		else
			this.spId = new SPIdBinaryImpl(value, null, null);
	}	
	
	@Override
	public Long getVMccMncAddr()
	{
		if(vmccMncAddr==null)
			return null;
		
		return vmccMncAddr.getUnsigned();
	}
	
	@Override
	public void setVMccMncAddr(Long value)
	{
		if(value==null)
			this.vmccMncAddr = null;
		else
			this.vmccMncAddr = new VMccMncAddrImpl(value, null, null);
	}		
	
	@Override
	public Long getDCS()
	{
		if(dcs==null)
			return null;
		
		return dcs.getUnsigned();
	}
	
	@Override
	public void setDCS(Long value)
	{
		if(value==null)
			this.dcs = null;
		else
			this.dcs = new DCSImpl(value, null, null);
	}

	@Override
	public String getOriginalCalledPartyId()
	{
		if(originalCalledPartyId==null)
			return null;
		
		return originalCalledPartyId.getString();
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
	public Long getOriginalCalledPartyIdNature()
	{
		if(originalCalledPartyIdNature==null)
			return null;
		
		return originalCalledPartyIdNature.getUnsigned();
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
	public Long getNotifyMode()
	{
		if(notifyMode==null)
			return null;
		
		return notifyMode.getUnsigned();
	}
	
	@Override
	public void setNotifyMode(Long value)
	{
		if(value==null)
			this.notifyMode = null;
		else
			this.notifyMode = new NotifyModeImpl(value, null, null);
	}
	
	@Override
	public Long getOperationResult()
	{
		if(operationResult==null)
			return null;
		
		return operationResult.getUnsigned();
	}
	
	@Override
	public void setOperationResult(Long value)
	{
		if(value==null)
			this.operationResult = null;
		else
			this.operationResult = new OperationResultImpl(value, null, null);
	}
}