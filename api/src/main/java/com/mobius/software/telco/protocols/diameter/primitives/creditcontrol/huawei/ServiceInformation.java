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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CPDTInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.M2MInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MBMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MMTelInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VCSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.oma.DCDInformation;
import com.mobius.software.telco.protocols.diameter.primitives.oma.IMInformation;
import com.mobius.software.telco.protocols.diameter.primitives.oma.ServiceGenericInformation;

/**
*
* @author yulian oifa
*
*/

/*
 *  3.2.578  Service-Information AVP
	
	AVP Name
	Service-Information

	AVP Code
	873

	AVP Data Type
	Grouped

	Vendor ID
	10415

	Description
	Indicates the basic information about the service.
	The Service-Information AVP is an AVP group. The detailed ABNF syntax is as follows:

	Service-Information ::= <AVP Header: 873> 
		  [PS-Information] 
          [IN-Information] 
          [P2PSMS-Information]  
          [MDSP-Information] 
          [IMS-Information] 
          [LCS-Information] 
          [PoC-Information] 
          [Conference- Information] 
          [Message-Information] 

The Service-Information AVP group varies with different services. It records the specific information about certain service types, allow the client to transmit the extra service information, and can be flexibly extended.

 */
@DiameterAvpDefinition(code = TgppAvpCodes.SERVICE_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "Service-Information")
public interface ServiceInformation extends DiameterAvp 
{
	PSInformation getPSInformation();
	
	void setPSInformation(PSInformation value);
	
	INInformation getINInformation();
	
	void setINInformation(INInformation value);
	
	P2PSMSInformation getP2PSMSInformation();
	
	void setP2PSMSInformation(P2PSMSInformation value);
	
	IMSInformation getIMSInformation();
	
	void setIMSInformation(IMSInformation value);
	
	MMSInformation getMMSInformation();
	      	
	void setMMSInformation(MMSInformation value);
	      	
	LCSInformation getLCSInformation();
	
	void setLCSInformation(LCSInformation value);
	
	PoCInformation getPoCInformation();
	
	void setPoCInformation(PoCInformation value);
	
	MBMSInformation getMBMSInformation();
	
	void setMBMSInformation(MBMSInformation value);
	
	SMSInformation getSMSInformation();
	
	void setSMSInformation(SMSInformation value);

	VCSInformation getVCSInformation();
	
	void setVCSInformation(VCSInformation value);
	
	MMTelInformation getMMTelInformation();
	
	void setMMTelInformation(MMTelInformation value);
	
	ProSeInformation getProSeInformation();
	
	void setProSeInformation(ProSeInformation value);
	
	ServiceGenericInformation getServiceGenericInformation();
	
	void setServiceGenericInformation(ServiceGenericInformation value);
	
	IMInformation getIMInformation();
	
	void setIMInformation(IMInformation value);
	
	DCDInformation getDCDInformation();
	
	void setDCDInformation(DCDInformation value);
	
	M2MInformation getM2MInformation();
	
	void setM2MInformation(M2MInformation value);
	
	CPDTInformation getCPDTInformation();
	
	void setCPDTInformation(CPDTInformation value);	
}