package com.mobius.software.telco.protocols.diameter.commands.pc2;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.MonitorTarget;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.ProSeCodeSuffixMask;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppCodeSuffixRange;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeRestrictedCodeSuffixRange;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.6.3	ProXimity-Action-Answer (PXA) command
	The PXA command, indicated by the Command-Code field set to 8388676 and the 'R' bit cleared in the Command Flags field, is sent by the ProSe Application Server to the ProSe Function in response to the PXR command as part of the procedures specified for EPC-level ProSe discovery and ProSe direct discovery in clause 5.
	Message Format:

	<PX-Answer> ::=  < Diameter Header: 8388676, PXY >
                 < Session-Id >
                 { Auth-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 [ Result-Code ]
                 [ Experimental-Result ]
                 [ Error-Message ]
                 [ Error-Reporting-Host ]
                 [ Failed-AVP ]
                 [ Origin-State-Id ]
                *[ Redirect-Host ]
                 [ Redirect-Host-Usage ]
                 [ Redirect-Max-Cache-Time ]
                *[ Proxy-Info ]
                 { ProSe-Request-Type }
                 [ Targeted-EPUID ]
                 [ ProSe-Function-ID ]
                *[ PDUID ]
                *[ ProSe-Restricted-Code-Suffix-Range ] 
                *[ ProSe-Application-Code-Suffix-Range ]
                *[ ProSe-Code-Suffix-Mask ]
                *[ Monitor-Target ]
                *[ Target-PDUID ]
                 [ProSe-Application-Metadata ]
                 [Application-Data ]
                *[ Load ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777350, commandCode = 8388676, request = false, proxyable = true, name="PX-Answer")
public interface ProXimityActionAnswer extends Pc2Answer
{
	String getTargetedEPUID();
	
	void setTargetedEPUID(String value);
	
	ByteBuf getProSeFunctionID();
	
	void setProSeFunctionID(ByteBuf value);
	
	List<ByteBuf> getPDUID();
	 
	void setPDUID(List<ByteBuf> value);
	
	List<ProSeRestrictedCodeSuffixRange> getProSeRestrictedCodeSuffixRange();
	 
	void setProSeRestrictedCodeSuffixRange(List<ProSeRestrictedCodeSuffixRange> value);
	
	List<ProSeAppCodeSuffixRange> getProSeApplicationCodeSuffixRange();
	 
	void setProSeApplicationCodeSuffixRange(List<ProSeAppCodeSuffixRange> value);
	
	List<ProSeCodeSuffixMask> getProSeCodeSuffixMask();
	 
	void setProSeCodeSuffixMask(List<ProSeCodeSuffixMask> value);
	
	List<MonitorTarget> getMonitorTarget();
	 
	void setMonitorTarget(List<MonitorTarget> value);
	
	List<ByteBuf> getTargetPDUID();
	 
	void setTargetPDUID(List<ByteBuf> value);
	
	String getProSeApplicationMetadata();
	
	void setProSeApplicationMetadata(String value);
	
	String getApplicationData();
	
	void setApplicationData(String value);
	
	List<Load> getLoad();
	 
	void setLoad(List<Load> value);	
}