package com.mobius.software.telco.protocols.diameter.app.sd;

import com.mobius.software.telco.protocols.diameter.commands.sd.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.sd.TDFSessionRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;

public interface SessionFactory
{
	public SdClientSession createClientSession(CreditControlRequest request) throws DiameterException;	
	
	public SdServerSession createServerSession(CreditControlRequest request) throws DiameterException;	
	
	public SdClientSession createClientSession(TDFSessionRequest request) throws DiameterException;	
	
	public SdServerSession createServerSession(TDFSessionRequest request) throws DiameterException;
}