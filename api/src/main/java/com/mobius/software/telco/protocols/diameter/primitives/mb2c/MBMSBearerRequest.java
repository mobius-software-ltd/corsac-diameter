package com.mobius.software.telco.protocols.diameter.primitives.mb2c;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSStartStopIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.6	MBMS‑Bearer‑Request AVP
	The MBMS‑Bearer‑Request AVP (AVP code 3504) is of type Grouped. It is used by the GCS AS to request the activation, modification, or deactivation of an MBMS bearer.
	The MBMS‑StartStop‑Indication AVP shall indicate if an activation, modification, or deactivation of an MBMS bearer is requested.
	For the activation of an MBMS bearer, the TMGI AVP, the MBMS‑Start‑Time AVP and the MB2U‑Security AVP may be included, and the QoS‑Information AVP shall be included. If the MBMS Cell List feature is supported, the GCS AS shall also include the MBMS-Cell-List AVP or the MBMS‑Service‑Area AVP, or both. If the MBMS Cell List feature is not supported, the GCS AS shall also include the MBMS‑Service‑Area AVP. If the V2X Localized User Plane feature is supported, the GCS AS may also include the Local-M1-Information AVP and the Local-MB2-U-Information AVP. If the FEC feature is supported, the GCS AS may include the FEC-Request AVP. If the ROHC feature is supported, the GCS AS may include the ROHC-Request AVP together with the ROHC-Max-CID AVP.
	For the modification of an MBMS bearer, the TMGI AVP, and the MBMS‑Flow‑Identifier AVP shall be included and the MBMS‑Service‑Area AVP, the QoS‑Information AVP and / or, if the MBMS Cell List feature is supported, the MBMS-Cell-List may be included. However, at least one of the MBMS‑Service‑Area AVP, the MBMS-Cell-List AVP and the QoS‑Information AVP shall be included. The QoS‑Information AVP shall only be used to modify the priority and pre-emption characteristics, and shall otherwise indicate the same values that were supplied when the activation of the MBMS bearer was requested. If the FEC feature is supported, the GCS AS may include the FEC-Request AVP. If the ROHC feature is supported, the GCS AS may include the ROHC-Request AVP together with the ROHC-Max-CID AVP.
	For the deactivation of an MBMS bearer, the TMGI AVP and the MBMS‑Flow‑Identifier AVP shall be included.
	AVP Format:

	MBMS-Bearer-Request::=           < AVP Header: 3504 >
                                 { MBMS-StartStop-Indication }
                                 [ TMGI]
                                 [ MBMS-Flow-Identifier ]
                                 [ QoS-Information ]
                                 [ MBMS-Service-Area ]
                                 [ MBMS-Start-Time ]
                                 [ MB2U-Security ]
                                 [ MBMS-Cell-List ]
                                 [ Local-M1-Information ]
                                 [ Local-MB2-U-Information ]
                                 [ FEC-Request ]
                                *[ ROHC-Request ]
                                 [ ROHC-Max-CID ]
                                *[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MBMS_BEARER_REQUEST, vendorId = VendorIDs.TGPP_ID, name = "MBMS‑Bearer‑Request")
public interface MBMSBearerRequest extends DiameterGroupedAvp
{
	MBMSStartStopIndicationEnum getMBMSStartStopIndication();
	
	void setMBMSStartStopIndication(MBMSStartStopIndicationEnum value) throws MissingAvpException;	
	
	ByteBuf getTMGI();
	
	void setTMGI(ByteBuf value);
	
	ByteBuf getMBMSFlowIdentifier();
	
	void setMBMSFlowIdentifier(ByteBuf value);
	
	QoSInformation getQOSInformation();
	
	void setQOSInformation(QoSInformation value);
	
	ByteBuf getMBMSServiceArea();
	
	void setMBMSServiceArea(ByteBuf value);
	
	Date getMBMSStartTime();
	
	void setMBMSStartTime(Date value);
	
	Long getMB2USecurity();
	
	void setMB2USecurity(Long value);
	
	ByteBuf getMBMSCellList();
	
	void setMBMSCellList(ByteBuf value);
	
	LocalM1Information getLocalM1Information();
	
	void setLocalM1Information(LocalM1Information value);
	
	LocalMB2UInformation getLocalMB2UInformation();
	
	void setLocalMB2UInformation(LocalMB2UInformation value);
	
	ByteBuf getFECRequest();
	
	void setFECRequest(ByteBuf value);
	
	List<ROHCRequest> getROHCRequest();
	
	void setROHCRequest(List<ROHCRequest> value);
	
	Long getROHCMaxCID();
	
	void setROHCMaxCID(Long value);
	
}