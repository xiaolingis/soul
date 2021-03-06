/*
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.dromara.soul.client.core.disruptor;

import org.dromara.soul.disruptor.AbstractDisruptorConsumerExecutor;
import org.dromara.soul.disruptor.DisruptorConsumerFactory;
import org.dromara.soul.register.client.api.SoulClientRegisterRepository;

/**
 * The type Soul meta data register event handler.
 *
 * @author tydhot
 */
public class SoulMetaDataRegisterEventHandler extends AbstractDisruptorConsumerExecutor<SoulClientRegisterEvent> implements DisruptorConsumerFactory<SoulClientRegisterEvent> {
   
    private final SoulClientRegisterRepository soulClientRegisterRepository;
    
    /**
     * Instantiates a new Soul meta data register event handler.
     *
     * @param soulClientRegisterRepository the soul client register repository
     */
    public SoulMetaDataRegisterEventHandler(final SoulClientRegisterRepository soulClientRegisterRepository) {
        this.soulClientRegisterRepository = soulClientRegisterRepository;
    }

    @Override
    public void executor(final SoulClientRegisterEvent data) {
        soulClientRegisterRepository.persistInterface(data.getMetaData());
    }

    @Override
    public String fixName() {
        return "SoulMetaDataRegisterEventHandler";
    }

    @Override
    public AbstractDisruptorConsumerExecutor<SoulClientRegisterEvent> create() {
        return this;
    }
}
