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

import com.mobius.software.telco.protocols.diameter.HuaweiAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterInteger32;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.205  CDR-Service-Type AVP

	AVP Name
	CDR-Service-Type

	AVP Code
	20631

	AVP Data Type
	Integer32

	Vendor ID
	2011

	Description
	Indicates the service type. Referring to the following values:
	    - 0: wap
	    - 1: kjava
	    - 2: sms
	    - 3: mms
	    - 4: Mail
	    - 5: LBS
	    - 6: StreamMedia
	    - 7: IMPS
	    - 8: UM
	    - 9: WapPush
	    - 11: CRBT
	    - 12: General
	    - 13: MC
	    - 14: PIM
	    - 15: VMB
	    - 16: CMB
	    - 17: PaymentGW
	    - 18: Storage 
	    - 20: Service Package

 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.CDR_SERVICE_TYPE, vendorId = VendorIDs.HUAWEI_ID, name = "CDR-Service-Type")
public interface CDRServiceType extends DiameterInteger32
{
}