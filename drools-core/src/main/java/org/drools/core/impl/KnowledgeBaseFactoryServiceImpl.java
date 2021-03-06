/*
 * Copyright 2010 JBoss Inc
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

package org.drools.core.impl;

import org.drools.core.RuleBaseConfiguration;
import org.drools.core.RuleBaseFactory;
import org.drools.core.SessionConfiguration;
import org.kie.api.KieBaseConfiguration;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactoryService;
import org.kie.api.runtime.Environment;
import org.kie.api.runtime.KieSessionConfiguration;

import java.util.Properties;

public class KnowledgeBaseFactoryServiceImpl implements KnowledgeBaseFactoryService {

    public KieBaseConfiguration newKnowledgeBaseConfiguration() {
        return new RuleBaseConfiguration();
    }
        
    public KieBaseConfiguration newKnowledgeBaseConfiguration(Properties properties, ClassLoader... classLoaders) {
        return new RuleBaseConfiguration(properties, classLoaders);
    }
    
    public KieSessionConfiguration newKnowledgeSessionConfiguration() {
        return new SessionConfiguration();
    }
        
    public KieSessionConfiguration newKnowledgeSessionConfiguration(Properties properties) {
        return new SessionConfiguration(properties);
    }
    
    public KnowledgeBase newKnowledgeBase() {
        return new KnowledgeBaseImpl( RuleBaseFactory.newRuleBase() );
    }
    
    public KnowledgeBase newKnowledgeBase( String kbaseId ) {
        return new KnowledgeBaseImpl( RuleBaseFactory.newRuleBase(kbaseId) );
    }
    
    public KnowledgeBase newKnowledgeBase(KieBaseConfiguration conf) {
        return new KnowledgeBaseImpl( RuleBaseFactory.newRuleBase( ( RuleBaseConfiguration ) conf ) );
    }

    public KnowledgeBase newKnowledgeBase(String kbaseId, 
                                          KieBaseConfiguration conf) {
        return new KnowledgeBaseImpl( RuleBaseFactory.newRuleBase( kbaseId, 
                                                                   (RuleBaseConfiguration) conf ) );
    }

    public Environment newEnvironment() {
        return EnvironmentFactory.newEnvironment();//new EnvironmentImpl(); //
    }
}
