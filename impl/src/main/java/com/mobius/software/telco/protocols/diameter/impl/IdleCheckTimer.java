package com.mobius.software.telco.protocols.diameter.impl;

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
import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mobius.software.common.dal.timers.RunnableTimer;
import com.mobius.software.common.dal.timers.Timer;
import com.mobius.software.telco.protocols.diameter.DiameterSession;

/**
 *
 * @author yulian oifa
 *
 */
public class IdleCheckTimer extends RunnableTimer
{
	public static Logger logger = LogManager.getLogger(IdleCheckTimer.class);

	private AtomicLong timestamp;
	private long timeout;
	private DiameterSession session;

	public IdleCheckTimer(DiameterSession session, long timeout)
	{
		super(null, System.currentTimeMillis() + timeout, session.getID());
		
		this.session = session;
		this.timeout = timeout;
		this.timestamp = new AtomicLong(System.currentTimeMillis() + timeout);
	}

	@Override
	public void execute()
	{		
		if (timestamp.get() < Long.MAX_VALUE)
		{
			logger.error("Session " + session.getID() + " is idle");
			session.onIdleTimeout();
		}
	}

	@Override
	public Long getRealTimestamp()
	{
		return timestamp.get();
	}

	@Override
	public void stop()
	{
		timestamp.set(Long.MAX_VALUE);
	}

	public void restart()
	{
		this.timestamp.set(System.currentTimeMillis() + timeout);
	}

	public void restart(Long idleTime)
	{
		if (idleTime != null)
			timeout = idleTime;

		this.timestamp.set(System.currentTimeMillis() + timeout);
	}
}
