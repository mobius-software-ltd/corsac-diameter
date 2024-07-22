package com.mobius.software.telco.protocols.diameter;

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.commons.CapabilitiesExchangeRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.DeviceWatchdogRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.DisconnectPeerRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.DisconnectCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;

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
public interface DiameterLink
{
	void sendMessage(DiameterMessage message,AsyncCallback callback);
	
	public boolean isStarted();

	public boolean isConnected();

	public boolean isUp();
	
	public InetAddress getRemoteAddress();
	
	public Integer getRemotePort();
	
	public InetAddress getLocalAddress();
	
	public Integer getLocalPort();

	public Boolean isServer();
	
	public Boolean isSctp();
	
	public String getLocalHost();

	public String getLocalRealm();
	
	public String getDestinationHost();
	
	public String getDestinationRealm();
	
	public void stop(Boolean remove) throws DiameterException;
	
	public void start() throws DiameterException;
	
	void registerApplication(List<VendorSpecificApplicationId> vendorApplicationIds, List<Long> authApplicationIds, List<Long> acctApplicationIds, Package providerPackageName, Package packageName) throws DiameterException;
	
	List<Long> getAuthApplicationIds();
	
	List<Long> getAcctApplicationIds();
	
	List<VendorSpecificApplicationId> getVendorSpecificApplicationIds();
	
	Package getPackage(Long applicationID, Boolean isAuth);
	
	PeerStateEnum getPeerState();
	
	void setPeerState(PeerStateEnum peerState);
	
	void sendError(DiameterException ex) throws MissingAvpException, AvpNotSupportedException;	
	
	void sendCER();
	
	void sendCEA(CapabilitiesExchangeRequest request);
	
	void sendDWR();
	
	void sendDWA(DeviceWatchdogRequest request, long resultCode);
	
	void sendDPR(DisconnectCauseEnum cause, AsyncCallback callback);
	
	void sendDPA(DisconnectPeerRequest request, long resultCode);
	
	void resetInactivityTimer();
	
	void resetReconnectTimer();
	
	//used to notify that disconnect has been succesfully completed
	void disconnectOperationCompleted();
}