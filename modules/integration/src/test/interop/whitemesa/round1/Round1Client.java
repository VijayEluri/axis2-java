/*
 * Copyright 2004,2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package test.interop.whitemesa.round1;

import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Call;
import org.apache.axis2.client.Options;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.description.AxisOperation;
import org.apache.axis2.description.OutInAxisOperation;
import org.apache.axis2.engine.AxisConfiguration;
import org.apache.axis2.soap.SOAPEnvelope;
import test.interop.whitemesa.round1.util.Round1ClientUtil;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


public class Round1Client {

    public SOAPEnvelope sendMsg(Round1ClientUtil util, String epUrl, String soapAction) throws AxisFault {

        SOAPEnvelope retEnv = null;
        URL url = null;
        try {
            url = new URL(epUrl);
        } catch (MalformedURLException e) {
            throw new AxisFault(e);
        }

        String clientHome = "target/test-resources/integrationRepo";

        Options options = new Options();
        options.setTo(new EndpointReference(url.toString()));
        options.setSoapAction(soapAction);
        options.setListenerTransportProtocol(Constants.TRANSPORT_HTTP);

        Call call = new Call(clientHome);
        call.setClientOptions(options);
        SOAPEnvelope reqEnv = util.getEchoSoapEnvelope();


        AxisConfiguration axisConfig = new AxisConfiguration();
        ConfigurationContext configCtx = new ConfigurationContext(axisConfig);
        MessageContext msgCtx = new MessageContext(configCtx);
        msgCtx.setEnvelope(reqEnv);


        QName opName = new QName("");
        AxisOperation opDesc = new OutInAxisOperation(opName);
        MessageContext retMsgCtx = call.invokeBlocking(opDesc, msgCtx);
        //SOAPEnvelope responseEnvelop = replyContext.getEnvelope();
        retEnv = retMsgCtx.getEnvelope();

        return retEnv;
    }
}


