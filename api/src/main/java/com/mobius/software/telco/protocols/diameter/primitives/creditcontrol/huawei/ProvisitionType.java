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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.224  Provisition-Type AVP

	AVP Name
	Provisition-Type

	AVP Code
	20682

	AVP Data Type
	Unsigned32

	Vendor-Id
	2011

	Description
	    - 151: FullTrackOnlinePlay
	    - 152: FuleTrackDownload
	    - 153: ColorRing
	    - 154: RingToneDownload
	    - 155: GameDownload
	    - 156: ApplicationDownload
	    - 157: ApplicationOnlinePlay
	    - 158: VideoOnlinePlay
	    - 159: VideoDownload
	    - 160: ThemeDownload
	    - 161: AudioDonwload
	    - 162: PictureDownload
	    - 163: TextDownload
	    - 164: WidgetDownload

 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.PROVISITION_TYPE, vendorId = VendorIDs.HUAWEI_ID, name = "Provisition-Type")
public interface ProvisitionType extends DiameterUnsigned32
{
}