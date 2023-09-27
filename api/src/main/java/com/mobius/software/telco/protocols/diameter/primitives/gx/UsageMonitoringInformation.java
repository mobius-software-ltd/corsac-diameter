package com.mobius.software.telco.protocols.diameter.primitives.gx;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.60	Usage-Monitoring-Information AVP
	The Usage-Monitoring-Information AVP (AVP code 1067) is of type Grouped, and it contains the usage monitoring control information.
	The Monitoring-Key AVP identifies the usage monitoring control instance.
	The Granted-Service-Unit AVP shall be used by the PCRF to provide the volume and/or the time of usage threshold level to the PCEF. The CC-Total-Octets AVP shall be used for providing threshold level for the total volume, or the CC-Input-Octets and/or CC-Output-Octets AVPs shall be used for providing threshold level for the uplink volume and/or the downlink volume. The CC-Time AVP shall be used for providing the time threshold to the PCEF. Monitoring-Time AVP shall be used for providing the time at which the PCEF shall reapply the threshold value provided by the PCRF.
	The Used-Service-Unit AVP shall be used by the PCEF to provide the measured usage to the PCRF. Reporting shall be done, as requested by the PCRF, in CC-Total-Octets, CC-Input-Octets, CC-Output-Octets or CC-Time AVPs of Used-Service-Unit AVP. The Monitoring-Time AVP within the Used-Service-Unit AVP shall indicate the usage after the monitoring time as specified in clause 4.5.17.6.
	The Quota-Consumption-Time AVP defines the time interval in seconds after which the time measurement shall stop for the Monitoring Key, if no packets are received belonging to the corresponding Monitoring Key. The Quota-Comsumption-Time may be included when the Usage-Monitoring-InformationAVP also contains a Granted-Service-Unit including a CC-Time AVP (i.e. when the granted usage is for for usage monitoring based on time). If the Quota-Consumption-Time AVP contains a value of zero, or if no Quota-Consumption-Time AVP is present, the time of usage shall be measured continuously from the point user plane traffic is detected for the corresponding Monitoring Key until the time usage measurement is disabled for the same Monitoring Key.
	The Usage-Monitoring-Level AVP determines the scope of the usage monitoring instance.
	The Usage-Monitoring-Report AVP determines if accumulated usage shall be reported for the usage monitoring key included in Monitoring-Key AVP.
	The Usage-Monitoring-Support AVP determines if a usage monitoring instance is disabled.
	AVP Format:

	Usage-Monitoring-Information::= < AVP Header: 1067 >
			[ Monitoring-Key ]
		0*2 [ Granted-Service-Unit ]
		0*2 [ Used-Service-Unit ]
			[ Quota-Consumption-Time ]
			[ Usage-Monitoring-Level ]
			[ Usage-Monitoring-Report ]
			[ Usage-Monitoring-Support ]
		*	[ AVP ]
 */
@DiameterAvpDefinition(code = 1067L, vendorId = KnownVendorIDs.TGPP_ID, must=false, name = "Usage-Monitoring-Information")
public interface UsageMonitoringInformation extends DiameterGroupedAvp
{
	ByteBuf getMonitoringKey();
	
	void setMonitoringKey(ByteBuf value);	
	
	List<GrantedServiceUnit> getGrantedServiceUnit();
	
	void setGrantedServiceUnit(List<GrantedServiceUnit> value);	
	
	List<UsedServiceUnit> getUsedServiceUnit();
	
	void setUsedServiceUnit(List<UsedServiceUnit> value);	
	
	Long getQuotaConsumptionTime();
	
	void setQuotaConsumptionTime(Long value);	
	
	UsageMonitoringLevelEnum getUsageMonitoringLevel();
	
	void setUsageMonitoringLevel(UsageMonitoringLevelEnum value);
	
	UsageMonitoringReportEnum getUsageMonitoringReport();
	
	void setUsageMonitoringReport(UsageMonitoringReportEnum value);
	
	UsageMonitoringSupportEnum getUsageMonitoringSupport();
	
	void setUsageMonitoringSupport(UsageMonitoringSupportEnum value);
}