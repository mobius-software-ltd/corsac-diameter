package com.mobius.software.telco.protocols.diameter.primitives;
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
import java.util.Map;
/**
*
* @author yulian oifa
*
*/
public interface DiameterGroupedAvp extends DiameterAvp 
{
	Map<DiameterAvpKey,List<DiameterAvp>> getOptionalAvps();
	
	List<DiameterAvp> getOptionalAvps(DiameterAvpKey avpKey);
	
	void addOptionalAvp(DiameterAvpKey avpKey,DiameterAvp avp);
	
	void setOptionalAvps(Map<DiameterAvpKey,List<DiameterAvp>> avps);
}