/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * you may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.ballerinalang.persistence.states;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This is used to manage the active @{@link State}s of the system.
 *
 * @since 0.981.1
 */
public class RuntimeStates {

    private static Map<String, List<State>> states = new ConcurrentHashMap<>();

    public static void add(State state) {
        List<State> stateList = states.computeIfAbsent(state.getId(), k -> new ArrayList<>());
        stateList.add(state);
    }

    public static List<State> get(String stateId) {
        return states.get(stateId);
    }

    public static void remove(String stateId) {
        states.remove(stateId);
    }
}
