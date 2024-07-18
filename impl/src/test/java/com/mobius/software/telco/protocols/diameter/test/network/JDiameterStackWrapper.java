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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jdiameter.api.Answer;
import org.jdiameter.api.ApplicationId;
import org.jdiameter.api.Configuration;
import org.jdiameter.api.Network;
import org.jdiameter.api.NetworkReqListener;
import org.jdiameter.api.Request;
import org.jdiameter.api.rf.ServerRfSessionListener;
import org.jdiameter.api.ro.ServerRoSessionListener;
import org.jdiameter.client.api.ISessionFactory;
import org.jdiameter.common.impl.validation.DictionaryImpl;
import org.jdiameter.server.impl.MutablePeerTableImpl;
import org.jdiameter.server.impl.NetworkImpl;
import org.jdiameter.server.impl.StackImpl;
import org.jdiameter.server.impl.app.rf.IServerRfSessionData;
import org.jdiameter.server.impl.app.rf.ServerRfSessionImpl;
import org.jdiameter.server.impl.helpers.XMLConfiguration;
import org.jdiameter.server.impl.io.sctp.NetworkGuard;
import org.jdiameter.server.impl.io.sctp.SCTPServerConnection;
import org.mobicents.protocols.api.Association;
import org.mobicents.protocols.api.Server;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
/**
*
* @author yulian oifa
*
*/
public class JDiameterStackWrapper extends StackImpl implements NetworkReqListener
{
	private static ApplicationId accountingApplicationID = ApplicationId.createByAccAppId(ApplicationIDs.ACCOUNTING);
	private static ApplicationId creditControlApplicationID = ApplicationId.createByAuthAppId(ApplicationIDs.CREDIT_CONTROL);
	
	private static Logger logger = LogManager.getLogger(JDiameterStackWrapper.class);
	private RoSessionFactory roSessionFactory;
	private RfSessionFactory rfSessionFactory;
	
	private Network network;
	private List<SCTPServerConnection> serverConnections;
	
	public JDiameterStackWrapper() 
	{
		super();
	}

	public JDiameterStackWrapper(InputStream streamConfig,ServerRoSessionListener sessionRoListener,ServerRfSessionListener sessionRfListener) throws Exception 
	{
		loadConfiguration(new XMLConfiguration(streamConfig),sessionRoListener, sessionRfListener);
	}

	public JDiameterStackWrapper(String stringConfig,ServerRoSessionListener sessionRoListener,ServerRfSessionListener sessionRfListener) throws Exception 
	{
		loadConfiguration(new XMLConfiguration(new ByteArrayInputStream(stringConfig.getBytes())), sessionRoListener, sessionRfListener);
	}

	public void init(InputStream streamConfig,ServerRoSessionListener sessionRoListener,ServerRfSessionListener sessionRfListener) throws Exception 
	{
		this.loadConfiguration(new XMLConfiguration(streamConfig), sessionRoListener, sessionRfListener);
	}

	public void loadConfiguration(Configuration config,ServerRoSessionListener sessionRoListener,ServerRfSessionListener sessionRfListener) throws Exception 
	{
	    // local one
	    try 
	    {
	    	this.init(config);

	    	//looks like its needed to support app
	    	network = unwrap(Network.class);
	    	network.addNetworkReqListener(this, accountingApplicationID);
	    	network.addNetworkReqListener(this, creditControlApplicationID);
	    	
	    	// Let it stabilize...
	    	Thread.sleep(500);

	    	// no need to validate diameter
	    	DictionaryImpl.INSTANCE.setEnabled(false);
	    	
	    	roSessionFactory = new RoSessionFactory(sessionRoListener, getSessionFactory());
	    	((ISessionFactory)getSessionFactory()).registerAppFacory(org.jdiameter.api.ro.ServerRoSession.class, roSessionFactory);
	    	((ISessionFactory)getSessionFactory()).registerAppFacory(org.jdiameter.api.ro.ClientRoSession.class, roSessionFactory);

	    	rfSessionFactory = new RfSessionFactory(sessionRfListener, getSessionFactory());
	    	((ISessionFactory)getSessionFactory()).registerAppFacory(org.jdiameter.api.rf.ServerRfSession.class, rfSessionFactory);
	    	((ISessionFactory)getSessionFactory()).registerAppFacory(org.jdiameter.api.rf.ClientRfSession.class, rfSessionFactory);

	    	roSessionFactory.setServerSessionListener(roSessionFactory);	
	    	rfSessionFactory.setServerSessionListener(rfSessionFactory);
	    }
	    catch (Exception e) 
	    {
	    	logger.error("Failure creating diameter stack," + e.getMessage(), e);
	    }
	}

	@Override
	public Answer processRequest(Request request) 
	{				
		Integer intApplicationId  = new Long(request.getApplicationId()).intValue(); 
		switch(intApplicationId)
		{
			case 3:
				org.jdiameter.api.rf.ServerRfSession serverRfSession = (org.jdiameter.api.rf.ServerRfSession)rfSessionFactory.getSession(request.getSessionId(), org.jdiameter.api.rf.ServerRfSession.class);
				if(serverRfSession == null)
					serverRfSession = (org.jdiameter.api.rf.ServerRfSession)rfSessionFactory.getNewSession(request.getSessionId(), org.jdiameter.api.rf.ServerRfSession.class, accountingApplicationID,  new Object[] { request });
				
				try
				{
					patchRfSession((org.jdiameter.server.impl.app.rf.ServerRfSessionImpl)serverRfSession);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				return ((org.jdiameter.server.impl.app.rf.ServerRfSessionImpl)serverRfSession).processRequest(request);				
			case 4:
				org.jdiameter.api.ro.ServerRoSession serverRoSession = (org.jdiameter.api.ro.ServerRoSession)roSessionFactory.getNewSession(request.getSessionId(), org.jdiameter.api.ro.ServerRoSession.class, accountingApplicationID,  new Object[] { request });
				return ((org.jdiameter.server.impl.app.ro.ServerRoSessionImpl)serverRoSession).processRequest(request);		
		}
		
		return null;
	}
	
	public void patchRfSession(ServerRfSessionImpl rfSession) throws IllegalArgumentException, IllegalAccessException
	{
		Class<ServerRfSessionImpl> rfClass = ServerRfSessionImpl.class;
		Field[] f= rfClass.getDeclaredFields();
		Field sessionDataField = null;
		for(Field currField:f)
			if(currField.getName().equals("sessionData"))
			{
				currField.setAccessible(true);
				sessionDataField = currField;
			}
		
		IServerRfSessionData rfSessionData = (IServerRfSessionData)sessionDataField.get(rfSession);
		rfSessionData.setStateless(false);
	}
	
	@SuppressWarnings("unchecked")
	public void loadConnections() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
	{
		//brutal hack to allow stopping sctp servers for restart
		Class<NetworkImpl> networkClass = NetworkImpl.class;
		Field[] f= networkClass.getDeclaredFields();
		Field networkField = null;
		for(Field currField:f)
			if(currField.getName().equals("manager"))
			{
				currField.setAccessible(true);
				networkField = currField;
			}
		
		MutablePeerTableImpl peerTable = (MutablePeerTableImpl)networkField.get(network);
		
		Class<MutablePeerTableImpl> peerClass = MutablePeerTableImpl.class;
		f= peerClass.getDeclaredFields();
		Field peerField = null;
		for(Field currField:f)
			if(currField.getName().equals("networkGuard"))
			{
				currField.setAccessible(true);
				peerField = currField;
			}
		
		NetworkGuard guard = (NetworkGuard)peerField.get(peerTable);
		
		Class<NetworkGuard> networkGuardClass = NetworkGuard.class;
		f= networkGuardClass.getDeclaredFields();
		Field connectionsField = null;
		for(Field currField:f)
			if(currField.getName().equals("serverConnections"))
			{
				currField.setAccessible(true);
				connectionsField = currField;
			}
		
		serverConnections = new ArrayList<SCTPServerConnection>((List<SCTPServerConnection>) connectionsField.get(guard));
	}
	
	public void terminate() throws Exception
	{
		for(SCTPServerConnection currConnection:serverConnections)
		{
			for(Association association:currConnection.getManagement().getAssociations().values())
				currConnection.getManagement().stopAssociation(association.getName());
			
			for(Server server:currConnection.getManagement().getServers())
				currConnection.getManagement().stopServer(server.getName());
		}
	}
}