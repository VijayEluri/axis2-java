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
package org.apache.axis2.clustering.control.wka;

import org.apache.axis2.clustering.ClusteringFault;
import org.apache.axis2.clustering.control.ControlCommand;
import org.apache.axis2.context.ConfigurationContext;

/**
 *  When a member wishes to gracefully leave a group, it will send this message to the group
 */
public class LeaveGroupCommand extends ControlCommand {
    public void execute(ConfigurationContext configurationContext) throws ClusteringFault {
        //TODO: Method implementation

    }
}
