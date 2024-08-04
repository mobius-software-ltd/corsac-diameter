package com.mobius.software.telco.protocols.diameter;

import java.util.Map;

import org.restcomm.cluster.ClusteredID;

import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
public interface DiameterProvider<L1 extends SessionListener,L2 extends SessionListener,A,M,F> extends NetworkListener
{
	A getAvpFactory();
	
	M getMessageFactory();
	
	F getSessionFactory();
	
	void setClientListener(ClusteredID<?> listenerID, L1 listener);
	
	void setServerListener(ClusteredID<?> listenerID, L2 listener);
	
	void removeClientListener(ClusteredID<?> listenerID);
	
	void removeServerListener(ClusteredID<?> listenerID);
	
	Map<ClusteredID<?>,L1> getClientListeners();
	
	Map<ClusteredID<?>,L2> getServerListeners();
	
	DiameterStack getStack();	
	
	DiameterSession getNewSession(DiameterRequest message);
	
	String getPackageName();
}