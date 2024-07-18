package com.mobius.software.telco.protocols.diameter.test.network;
/*
 * Mobius Software LTD
 * Copyright 2019 - 2023, Mobius Software LTD and individual contributors
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

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;

import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.NetworkListener;
import com.mobius.software.telco.protocols.diameter.PeerStateEnum;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.commons.CapabilitiesExchangeAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.DeviceWatchdogAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.DisconnectPeerAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.DisconnectPeerRequest;
/**
*
* @author yulian oifa
*
*/
public class LinkTest extends NetworkTestBase
{
	protected static final String localListenerID = "1";
	
	@Test
	public void testProperConnection() throws Exception
	{
		//we dont handle events here , only the connectivity
		super.setupRemote(new EmptyServerRoSessionListener(),new EmptyServerRfSessionListener());
		super.setupLocal();
		
		final AtomicLong ceaReceived=new AtomicLong(0L);
		final AtomicLong dwaReceived=new AtomicLong(0L);
		final AtomicLong dpaReceived=new AtomicLong(0L);
		final AtomicLong otherReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, AsyncCallback callback)
			{
				if(message instanceof CapabilitiesExchangeAnswer)
					ceaReceived.incrementAndGet();
				else if(message instanceof DeviceWatchdogAnswer)
					dwaReceived.incrementAndGet();
				else if(message instanceof DisconnectPeerAnswer)
					dpaReceived.incrementAndGet();
				else
					otherReceived.incrementAndGet();
			}
		});
		
		assertEquals(localStack.getNetworkManager().getLink(localLinkID).getPeerState(),PeerStateEnum.IDLE);
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isStarted());
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isConnected());
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isUp());
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(localStack.getNetworkManager().getLink(localLinkID).getPeerState(),PeerStateEnum.OPEN);
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isConnected());
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isStarted());
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isUp());
		
		try
		{
			Thread.sleep(idleTimeout * 5);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(localStack.getNetworkManager().getLink(localLinkID).getPeerState(),PeerStateEnum.OPEN);
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isConnected());
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isStarted());
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isUp());
		
		super.stopLocal();
		super.stopRemote();
		
		try
		{
			Thread.sleep(responseTimeout);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(localStack.getNetworkManager().getLink(localLinkID).getPeerState(),PeerStateEnum.IDLE);
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isConnected());
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isStarted());
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isUp());
		
		assertEquals(ceaReceived.get(), 1L);
		assertEquals(dwaReceived.get(), 5L);
		assertEquals(dpaReceived.get() , 1L);
		assertEquals(otherReceived.get(), 0L);
	}
	
	@Test
	public void testReconnectConnection() throws Exception
	{
		//we dont handle events here , only the connectivity
		super.setupRemote(new EmptyServerRoSessionListener(),new EmptyServerRfSessionListener());
		super.setupLocal();
				
		final AtomicLong ceaReceived=new AtomicLong(0L);
		final AtomicLong dwaReceived=new AtomicLong(0L);
		final AtomicLong dpaReceived=new AtomicLong(0L);
		final AtomicLong dprReceived=new AtomicLong(0L);
		final AtomicLong otherReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, AsyncCallback callback)
			{
				if(message instanceof CapabilitiesExchangeAnswer)
					ceaReceived.incrementAndGet();
				else if(message instanceof DeviceWatchdogAnswer)
					dwaReceived.incrementAndGet();
				else if(message instanceof DisconnectPeerAnswer)
					dpaReceived.incrementAndGet();
				else if(message instanceof DisconnectPeerRequest)
					dprReceived.incrementAndGet();
				else
					otherReceived.incrementAndGet();
			}
		});
		
		assertEquals(localStack.getNetworkManager().getLink(localLinkID).getPeerState(),PeerStateEnum.IDLE);
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isStarted());
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isConnected());
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isUp());
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(localStack.getNetworkManager().getLink(localLinkID).getPeerState(),PeerStateEnum.OPEN);
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isConnected());
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isStarted());
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isUp());
		
		super.stopRemote();
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(localStack.getNetworkManager().getLink(localLinkID).getPeerState(),PeerStateEnum.IDLE);
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isConnected());
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isStarted());
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isUp());
		
		setupRemote(null, null);
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(localStack.getNetworkManager().getLink(localLinkID).getPeerState(),PeerStateEnum.OPEN);
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isConnected());
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isStarted());
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isUp());
		
		super.stopLocal();
		super.stopRemote();
		
		try
		{
			Thread.sleep(responseTimeout);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(localStack.getNetworkManager().getLink(localLinkID).getPeerState(),PeerStateEnum.IDLE);
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isConnected());
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isStarted());
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isUp());
		
		assertEquals(ceaReceived.get(), 2L);
		assertEquals(dprReceived.get(), 1L);
		assertEquals(otherReceived.get(), 0L);
		//the connection disconnects faster then we receive
		assertEquals(dpaReceived.get() , 1L);
	}
	
	@Test
	public void testNoCommonApp() throws Exception
	{
		//we dont handle events here , only the connectivity
		super.setupRemote(new EmptyServerRoSessionListener(),new EmptyServerRfSessionListener());
		super.setupLocalWithImproperApplications();
		
		final AtomicLong ceaReceived=new AtomicLong(0L);
		final AtomicLong dwaReceived=new AtomicLong(0L);
		final AtomicLong dpaReceived=new AtomicLong(0L);
		final AtomicLong otherReceived=new AtomicLong(0L);
		
		DiameterStack localStack = this.localStack;
		localStack.getNetworkManager().addNetworkListener(localListenerID, new NetworkListener()
		{
			@Override
			public void onMessage(DiameterMessage message, AsyncCallback callback)
			{
				if(message instanceof CapabilitiesExchangeAnswer)
					ceaReceived.incrementAndGet();
				else if(message instanceof DeviceWatchdogAnswer)
					dwaReceived.incrementAndGet();
				else if(message instanceof DisconnectPeerAnswer)
					dpaReceived.incrementAndGet();
				else
					otherReceived.incrementAndGet();
			}
		});
		
		assertEquals(localStack.getNetworkManager().getLink(localLinkID).getPeerState(),PeerStateEnum.IDLE);
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isStarted());
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isConnected());
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isUp());
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(localStack.getNetworkManager().getLink(localLinkID).getPeerState(),PeerStateEnum.IDLE);
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isConnected());
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isStarted());
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isUp());
		
		try
		{
			Thread.sleep(idleTimeout * 5);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(localStack.getNetworkManager().getLink(localLinkID).getPeerState(),PeerStateEnum.IDLE);
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isConnected());
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isStarted());
		assertTrue(localStack.getNetworkManager().getLink(localLinkID).isUp());
		
		super.stopLocal();
		super.stopRemote();
		
		try
		{
			Thread.sleep(responseTimeout);
		}
		catch(InterruptedException ex)
		{
			
		}
		
		assertEquals(localStack.getNetworkManager().getLink(localLinkID).getPeerState(),PeerStateEnum.IDLE);
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isConnected());
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isStarted());
		assertFalse(localStack.getNetworkManager().getLink(localLinkID).isUp());
		
		assertTrue(ceaReceived.get() <= 6L);
		assertTrue(ceaReceived.get() >= 5L);
		assertEquals(dwaReceived.get(), 0L);
		assertEquals(dpaReceived.get() , 0L);
		assertEquals(otherReceived.get(), 0L);
	}
}