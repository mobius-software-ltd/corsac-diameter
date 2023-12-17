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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AccessModule;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.AccountType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CardBatch;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CardBrandID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CardCurDistributorID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CardMoney;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CardNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CardSpID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CardType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ChannelID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ChargeMoney;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ChargeNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.EtopupSessionID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ExParameter1;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ExParameter10;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ExParameter2;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ExParameter3;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ExParameter4;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ExParameter5;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ExParameter6;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ExParameter7;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ExParameter8;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ExParameter9;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ExTransType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.FraudTimes;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.NewCardMoney;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.RechargeInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.RechargeMethod;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.RechargeMethodEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SerialNo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.UniformSerialNo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 20314L, vendorId = KnownVendorIDs.HUAWEI_ID)
public class RechargeInformationImpl implements RechargeInformation
{
	private ChargeNumber chargeNumber;
	
	private CardNumber cardNumber;
	
	private CardBatch cardBatch;
	
	private CardType cardType;
	
	private CardMoney cardMoney;
	
	private ChargeMoney chargeMoney;
	
	private CardSpID cardSpID;
	
	private CardBrandID cardBrandID;
	
	private CardCurDistributorID cardCurDistributorID;
	
	private FraudTimes fraudTimes;
	
	private SerialNo serialNo;
	
	private UniformSerialNo uniformSerialNo;
	
	private RechargeMethod rechargeMethod;
	
	private EtopupSessionID etopupSessionID;
	
	private AccountType accountType;
	
	private NewCardMoney newCardMoney;
	
	private ExTransType exTransType;
	
	private ChannelID channelID;
	
	private ExParameter1 exParameter1;
	
	private ExParameter2 exParameter2;
	
	private ExParameter3 exParameter3;
	
	private ExParameter4 exParameter4;
	
	private ExParameter5 exParameter5;
	
	private ExParameter6 exParameter6;
	
	private ExParameter7 exParameter7;
	
	private ExParameter8 exParameter8;
	
	private ExParameter9 exParameter9;
	
	private ExParameter10 exParameter10;
	
	private AccessModule accessModule;
	
	public RechargeInformationImpl()
	{
		
	}
	
	@Override
	public ByteBuf getChargeNumber()
	{
		if(chargeNumber==null)
			return null;
		
		return chargeNumber.getValue();
	}
	
	@Override
	public void setChargeNumber(ByteBuf value)
	{
		if(value==null)
			this.chargeNumber = null;
		else
			this.chargeNumber = new ChargeNumberImpl(value);
	}
	
	@Override
	public ByteBuf getCardNumber()
	{
		if(cardNumber==null)
			return null;
		
		return cardNumber.getValue();
	}
	
	@Override
	public void setCardNumber(ByteBuf value)
	{
		if(value==null)
			this.cardNumber = null;
		else
			this.cardNumber = new CardNumberImpl(value);
	}	
	
	@Override
	public ByteBuf getCardBatch()
	{
		if(cardBatch==null)
			return null;
		
		return cardBatch.getValue();
	}
	
	@Override
	public void setCardBatch(ByteBuf value)
	{
		if(value==null)
			this.cardBatch = null;
		else
			this.cardBatch = new CardBatchImpl(value);
	}		
	
	@Override
	public Long getCardType()
	{
		if(cardType==null)
			return null;
		
		return cardType.getUnsigned();
	}
	
	@Override
	public void setCardType(Long value)
	{
		if(value==null)
			this.cardType = null;
		else
			this.cardType = new CardTypeImpl(value, null, null);
	}			
	
	@Override
	public Long getCardMoney()
	{
		if(cardMoney==null)
			return null;
		
		return cardMoney.getLong();
	}
	
	@Override
	public void setCardMoney(Long value)
	{
		if(value==null)
			this.cardMoney = null;
		else
			this.cardMoney = new CardMoneyImpl(value, null, null);
	}				
	
	@Override
	public ChargeMoney getChargeMoney()
	{
		return this.chargeMoney;
	}
	
	@Override
	public void setChargeMoney(ChargeMoney value)
	{
		this.chargeMoney = value;
	}
	
	@Override
	public Long getCardSpID()
	{
		if(cardSpID==null)
			return null;
		
		return cardSpID.getUnsigned();
	}
	
	@Override
	public void setCardSpID(Long value)
	{
		if(value==null)
			this.cardSpID = null;
		else
			this.cardSpID = new CardSpIDImpl(value, null, null);
	}				
	
	@Override
	public ByteBuf getCardBrandID()
	{
		if(cardBrandID==null)
			return null;
		
		return cardBrandID.getValue();
	}
	
	@Override
	public void setCardBrandID(ByteBuf value)
	{
		if(value==null)
			this.cardBrandID = null;
		else
			this.cardBrandID = new CardBrandIDImpl(value);
	}					
	
	@Override
	public String getCardCurDistributorID()
	{
		if(cardCurDistributorID==null)
			return null;
		
		return cardCurDistributorID.getString();
	}
	
	@Override
	public void setCardCurDistributorID(String value)
	{
		if(value==null)
			this.cardCurDistributorID = null;
		else
			this.cardCurDistributorID = new CardCurDistributorIDImpl(value, null, null);
	}					
	
	@Override
	public Long getFraudTimes()
	{
		if(fraudTimes==null)
			return null;
		
		return fraudTimes.getUnsigned();
	}
	
	@Override
	public void setFraudTimes(Long value)
	{
		if(value==null)
			this.fraudTimes = null;
		else
			this.fraudTimes = new FraudTimesImpl(value, null, null);
	}						
	
	@Override
	public String getSerialNo()
	{
		if(serialNo==null)
			return null;
		
		return serialNo.getString();
	}
	
	@Override
	public void setSerialNo(String value)
	{
		if(value==null)
			this.serialNo = null;
		else
			this.serialNo = new SerialNoImpl(value);
	}								
	
	@Override
	public String getUniformSerialNo()
	{
		if(uniformSerialNo==null)
			return null;
		
		return uniformSerialNo.getString();
	}
	
	@Override
	public void setUniformSerialNo(String value)
	{
		if(value==null)
			this.uniformSerialNo = null;
		else
			this.uniformSerialNo = new UniformSerialNoImpl(value);
	}											
	
	@Override
	public RechargeMethodEnum getRechargeMethod()
	{
		if(rechargeMethod==null)
			return null;
		
		return rechargeMethod.getEnumerated(RechargeMethodEnum.class);
	}
	
	@Override
	public void setRechargeMethod(RechargeMethodEnum value)
	{
		if(value==null)
			this.rechargeMethod = null;
		else
			this.rechargeMethod = new RechargeMethodImpl(value, null, null);
	}											
	
	@Override
	public String getEtopupSessionID()
	{
		if(etopupSessionID==null)
			return null;
		
		return etopupSessionID.getString();
	}
	
	@Override
	public void setEtopupSessionID(String value)
	{
		if(value==null)
			this.etopupSessionID = null;
		else
			this.etopupSessionID = new EtopupSessionIDImpl(value);
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
	public Long getNewCardMoney()
	{
		if(newCardMoney==null)
			return null;
		
		return newCardMoney.getLong();
	}
	
	@Override
	public void setNewCardMoney(Long value)
	{
		if(value==null)
			this.newCardMoney = null;
		else
			this.newCardMoney = new NewCardMoneyImpl(value, null, null);
	}									
	
	@Override
	public String getExTransType()
	{
		if(exTransType==null)
			return null;
		
		return exTransType.getString();
	}
	
	@Override
	public void setExTransType(String value)
	{
		if(value==null)
			this.exTransType = null;
		else
			this.exTransType = new ExTransTypeImpl(value);
	}						
	
	@Override
	public String getChannelID()
	{
		if(channelID==null)
			return null;
		
		return channelID.getString();
	}
	
	@Override
	public void setChannelID(String value)
	{
		if(value==null)
			this.channelID = null;
		else
			this.channelID = new ChannelIDImpl(value);
	}						
	
	@Override
	public String getExParameter1()
	{
		if(exParameter1==null)
			return null;
		
		return exParameter1.getString();
	}
	
	@Override
	public void setExParameter1(String value)
	{
		if(value==null)
			this.exParameter1 = null;
		else
			this.exParameter1 = new ExParameter1Impl(value);
	}
	
	@Override
	public String getExParameter2()
	{
		if(exParameter2==null)
			return null;
		
		return exParameter2.getString();
	}
	
	@Override
	public void setExParameter2(String value)
	{
		if(value==null)
			this.exParameter2 = null;
		else
			this.exParameter2 = new ExParameter2Impl(value);
	}
	
	@Override
	public String getExParameter3()
	{
		if(exParameter3==null)
			return null;
		
		return exParameter3.getString();
	}
	
	@Override
	public void setExParameter3(String value)
	{
		if(value==null)
			this.exParameter3 = null;
		else
			this.exParameter3 = new ExParameter3Impl(value);
	}
	
	@Override
	public String getExParameter4()
	{
		if(exParameter4==null)
			return null;
		
		return exParameter4.getString();
	}
	
	@Override
	public void setExParameter4(String value)
	{
		if(value==null)
			this.exParameter4 = null;
		else
			this.exParameter4 = new ExParameter4Impl(value);
	}
	
	@Override
	public String getExParameter5()
	{
		if(exParameter5==null)
			return null;
		
		return exParameter5.getString();
	}
	
	@Override
	public void setExParameter5(String value)
	{
		if(value==null)
			this.exParameter5 = null;
		else
			this.exParameter5 = new ExParameter5Impl(value);
	}
	
	@Override
	public String getExParameter6()
	{
		if(exParameter6==null)
			return null;
		
		return exParameter6.getString();
	}
	
	@Override
	public void setExParameter6(String value)
	{
		if(value==null)
			this.exParameter6 = null;
		else
			this.exParameter6 = new ExParameter6Impl(value);
	}
	
	@Override
	public String getExParameter7()
	{
		if(exParameter7==null)
			return null;
		
		return exParameter7.getString();
	}
	
	@Override
	public void setExParameter7(String value)
	{
		if(value==null)
			this.exParameter7 = null;
		else
			this.exParameter7 = new ExParameter7Impl(value);
	}
	
	@Override
	public String getExParameter8()
	{
		if(exParameter8==null)
			return null;
		
		return exParameter8.getString();
	}
	
	@Override
	public void setExParameter8(String value)
	{
		if(value==null)
			this.exParameter8 = null;
		else
			this.exParameter8 = new ExParameter8Impl(value);
	}
	
	@Override
	public String getExParameter9()
	{
		if(exParameter9==null)
			return null;
		
		return exParameter9.getString();
	}
	
	@Override
	public void setExParameter9(String value)
	{
		if(value==null)
			this.exParameter9 = null;
		else
			this.exParameter9 = new ExParameter9Impl(value);
	}
	
	@Override
	public String getExParameter10()
	{
		if(exParameter10==null)
			return null;
		
		return exParameter10.getString();
	}
	
	@Override
	public void setExParameter10(String value)
	{
		if(value==null)
			this.exParameter10 = null;
		else
			this.exParameter10 = new ExParameter10Impl(value);
	}

	@Override
	public Integer getAccessModule()
	{
		if(accessModule==null)
			return null;
		
		return accessModule.getInteger();
	}
	
	@Override
	public void setAccessModule(Integer value)
	{
		if(value==null)
			this.accessModule = null;
		else
			this.accessModule = new AccessModuleImpl(value, null, null);
	}
}