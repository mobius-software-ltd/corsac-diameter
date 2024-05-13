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

import java.util.Arrays;
import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CurrencyCodeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CurrencyCode;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.BalanceCategory;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.BalanceDate;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.BalanceID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.BalanceInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.BalanceType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CurrentBalance;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.MeasureType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.PaymentType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.RelatedObjectID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.RelatedObjectType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.UnpaidFee;

/**
*
* @author yulian oifa
*
*/
public class BalanceInfoImpl extends DiameterAvpImpl implements BalanceInfo 
{
	private PaymentType paymentType;
	
	private BalanceCategory balanceCategory;
	
	private BalanceID balanceID;
	
	private BalanceType balanceType;
	
	private CurrentBalance currentBalance;
	
	private BalanceDate balanceDate;
	
	private MeasureType measureType;
	
	private CurrencyCode currencyCode;
	
	private RelatedObjectType relatedObjectType;
	
	private RelatedObjectID relatedObjectID;
	
	private UnpaidFee unpaidFee;
	
	protected BalanceInfoImpl()
	{

	}
	
	public BalanceInfoImpl(Integer balanceCategory, Long balanceID, Long balanceType, Long currentBalance, Date balanceDate, Long measureType) throws MissingAvpException
	{
		setBalanceCategory(balanceCategory);
		
		setBalanceID(balanceID);
		
		setBalanceType(balanceType);
		
		setCurrentBalance(currentBalance);
		
		setBalanceDate(balanceDate);
		
		setMeasureType(measureType);
	}
	
	@Override
	public Integer getPaymentType()
	{
		if(paymentType==null)
			return null;
		
		return paymentType.getInteger();
	}
	
	@Override
	public void setPaymentType(Integer value)
	{
		if(value==null)
			this.paymentType = null;
		else
			this.paymentType = new PaymentTypeImpl(value, null, null);
	}		
	
	@Override
	public Integer getBalanceCategory()
	{
		if(balanceCategory==null)
			return null;
		
		return balanceCategory.getInteger();
	}
	
	@Override
	public void setBalanceCategory(Integer value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Balance-Category is required", Arrays.asList(new DiameterAvp[] { new BalanceCategoryImpl() }));
		
		this.balanceCategory = new BalanceCategoryImpl(value, null, null);
	}
	
	@Override
	public Long getBalanceID()
	{
		if(balanceID==null)
			return null;
		
		return balanceID.getLong();
	}
	
	@Override
	public void setBalanceID(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Balance-Id is required", Arrays.asList(new DiameterAvp[] { new BalanceIDImpl() }));
		
		this.balanceID = new BalanceIDImpl(value, null, null);
	}		
	
	@Override
	public Long getBalanceType()
	{
		if(balanceType==null)
			return null;
		
		return balanceType.getLong();
	}
	
	@Override
	public void setBalanceType(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Balance-Type is required", Arrays.asList(new DiameterAvp[] { new BalanceTypeImpl() }));
		
		this.balanceType = new BalanceTypeImpl(value, null, null);
	}	
	
	@Override
	public Long getCurrentBalance()
	{
		if(currentBalance==null)
			return null;
		
		return currentBalance.getLong();
	}
	
	@Override
	public void setCurrentBalance(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Current-Balance is required", Arrays.asList(new DiameterAvp[] { new CurrentBalanceImpl() }));			
		
		this.currentBalance = new CurrentBalanceImpl(value, null, null);
	}
	
	@Override
	public Date getBalanceDate()
	{
		if(balanceDate==null)
			return null;
		
		return balanceDate.getDateTime();
	}
	
	@Override
	public void setBalanceDate(Date value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Balance-Date is required", Arrays.asList(new DiameterAvp[] { new BalanceDateImpl() }));
			
		this.balanceDate = new BalanceDateImpl(value, null, null);
	}		
	
	@Override
	public Long getMeasureType()
	{
		if(measureType==null)
			return null;
		
		return measureType.getUnsigned();
	}
	
	@Override
	public void setMeasureType(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Measure-Type is required", Arrays.asList(new DiameterAvp[] { new MeasureTypeImpl() }));
		
		this.measureType = new MeasureTypeImpl(value, null, null);
	}	
	
	@Override
	public Long getCurrencyCode()
	{
		if(currencyCode==null)
			return null;
		
		return currencyCode.getUnsigned();
	}
	
	@Override
	public void setCurrencyCode(Long value)
	{
		if(value==null)
			this.currencyCode = null;
		else
			this.currencyCode = new CurrencyCodeImpl(value, null, null);
	}	
	
	@Override
	public Integer getRelatedObjectType()
	{
		if(relatedObjectType==null)
			return null;
		
		return relatedObjectType.getInteger();
	}
	
	@Override
	public void setRelatedObjectType(Integer value)
	{
		if(value==null)
			this.relatedObjectType = null;
		else
			this.relatedObjectType = new RelatedObjectTypeImpl(value, null, null);
	}		
	
	@Override
	public Long getRelatedObjectID()
	{
		if(relatedObjectID==null)
			return null;
		
		return relatedObjectID.getLong();
	}
	
	@Override
	public void setRelatedObjectID(Long value)
	{
		if(value==null)
			this.relatedObjectID = null;
		else
			this.relatedObjectID = new RelatedObjectIDImpl(value, null, null);
	}	
	
	@Override
	public Long getUnpaidFee()
	{
		if(unpaidFee==null)
			return null;
		
		return unpaidFee.getLong();
	}
	
	@Override
	public void setUnpaidFee(Long value)
	{
		if(value==null)
			this.unpaidFee = null;
		else
			this.unpaidFee = new UnpaidFeeImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(balanceCategory==null)
			return new MissingAvpException("Balance-Category is required", Arrays.asList(new DiameterAvp[] { new BalanceCategoryImpl() }));
		
		if(balanceID==null)
			return new MissingAvpException("Balance-Id is required", Arrays.asList(new DiameterAvp[] { new BalanceIDImpl() }));
		
		if(balanceType==null)
			return new MissingAvpException("Balance-Type is required", Arrays.asList(new DiameterAvp[] { new BalanceTypeImpl() }));
		
		if(currentBalance==null)
			return new MissingAvpException("Current-Balance is required", Arrays.asList(new DiameterAvp[] { new CurrentBalanceImpl() }));
		
		if(balanceDate==null)
			return new MissingAvpException("Balance-Date is required", Arrays.asList(new DiameterAvp[] { new BalanceDateImpl() }));
		
		if(measureType==null)
			return new MissingAvpException("Measure-Type is required", Arrays.asList(new DiameterAvp[] { new MeasureTypeImpl() }));
		
		return null;
	}
}