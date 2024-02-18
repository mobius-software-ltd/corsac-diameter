package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.oma.DCDInformation;
import com.mobius.software.telco.protocols.diameter.primitives.oma.IMInformation;
import com.mobius.software.telco.protocols.diameter.primitives.oma.ServiceGenericInformation;

/**
*
* @author yulian oifa
*
*/

/*
 *  The Service-Information AVP (AVP code 873) is of type Grouped. Its purpose is to allow the transmission of additional
	3GPP service specific information elements which are not described in this document.
	It has the following ABNF grammar:

	Service-Information :: = < AVP Header: 873>
		   * [ Subscription-Id ]
			 [ AoC-Information ]
			 [ PS-Information ]
			 [ IMS-Information ]
			 [ MMS-Information ]
			 [ LCS-Information ]
			 [ PoC-Information ]
			 [ MBMS-Information ]
			 [ SMS-Information ]
			 [ VCS-Information ]
			 [ MMTel-Information ]
			 [ ProSe-Information ]
			 [ Service-Generic-Information ]
			 [ IM-Information ]
			 [ DCD-Information ]
			 [ M2M-Information ]
 			 [ CPDT-Information ] 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SERVICE_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "Service-Information")
public interface ServiceInformation extends DiameterAvp 
{
	List<SubscriptionId> getSubscriptionId();
	
	void setSubscriptionId(List<SubscriptionId> subscriptionId);
	
	AoCInformation getAoCInformation();
	
	void setAoCInformation(AoCInformation aocInformation);
	
	PSInformation getPSInformation();
	
	void setPSInformation(PSInformation psInformation);
	
	IMSInformation getIMSInformation();
	
	void setIMSInformation(IMSInformation imsInformation);
	
	MMSInformation getMMSInformation();
	
	void setMMSInformation(MMSInformation mmsInformation);
	
	LCSInformation getLCSInformation();
	
	void setLCSInformation(LCSInformation lcsInformation);
	
	PoCInformation getPoCInformation();
	
	void setPoCInformation(PoCInformation pocInformation);
	
	MBMSInformation getMBMSInformation();
	
	void setMBMSInformation(MBMSInformation mbmsInformation);
	
	SMSInformation getSMSInformation();
	
	void setSMSInformation(SMSInformation smsInformation);

	VCSInformation getVCSInformation();
	
	void setVCSInformation(VCSInformation vcsInformation);
	
	MMTelInformation getMMTelInformation();
	
	void setMMTelInformation(MMTelInformation mmtelInformation);
	
	ProSeInformation getProSeInformation();
	
	void setProSeInformation(ProSeInformation proseInformation);
	
	ServiceGenericInformation getServiceGenericInformation();
	
	void setServiceGenericInformation(ServiceGenericInformation serviceGenericInformation);
	
	IMInformation getIMInformation();
	
	void setIMInformation(IMInformation imInformation);
	
	DCDInformation getDCDInformation();
	
	void setDCDInformation(DCDInformation serviceGenericInformation);
	
	M2MInformation getM2MInformation();
	
	void setM2MInformation(M2MInformation m2mInformation);
	
	CPDTInformation getCPDTInformation();
	
	void setCPDTInformation(CPDTInformation cpdtInformation);	
}