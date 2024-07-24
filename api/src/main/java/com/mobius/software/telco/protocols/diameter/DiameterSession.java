package com.mobius.software.telco.protocols.diameter;

import org.restcomm.cluster.ClusteredID;

import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
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
public interface DiameterSession
{
	String getID();
	
	Long getApplicationID();
	
	ClusteredID<?> getIdleTimerID();
	
	ClusteredID<?> getSendTimerID();
	
	void setIdleTimerID(ClusteredID<?> id);
	
	void setSendTimerID(ClusteredID<?> id);
	
	SessionStateEnum getSessionState();
	
	void requestReceived(DiameterRequest request, AsyncCallback callback);
	
	void answerReceived(DiameterAnswer answer, AsyncCallback callback, Long idleTime,Boolean stopSendTimer);
	
	void requestSent(DiameterRequest request, AsyncCallback callback);
	
	void answerSent(DiameterAnswer answer, AsyncCallback callback, Long idleTime);
	
	void terminate(Long resultCode);
	
	void onTimeout();
	
	void onIdleTimeout();
	
	boolean isServer();
}