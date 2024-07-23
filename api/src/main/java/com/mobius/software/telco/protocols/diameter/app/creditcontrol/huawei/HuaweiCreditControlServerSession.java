package com.mobius.software.telco.protocols.diameter.app.creditcontrol.huawei;

import com.mobius.software.telco.protocols.diameter.app.ServerCCSession;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.huawei.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.huawei.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.huawei.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.huawei.SessionTerminationAnswer;

public interface HuaweiCreditControlServerSession extends ServerCCSession<CreditControlAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{
}