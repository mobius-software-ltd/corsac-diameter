package com.mobius.software.telco.protocols.diameter.app.sgmb;

import com.mobius.software.telco.protocols.diameter.commands.sgmb.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;

public interface SessionFactory
{
	public SgmbClientSession createClientSession(ReAuthRequest request) throws DiameterException;	
	
	public SgmbServerSession createServerSession(ReAuthRequest request) throws DiameterException;	
	
}