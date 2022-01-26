/*
 * Copyright 2021 Daniel Fiala
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.himari.builder.component;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ExpandableComponent extends Component {

    List<Component> getComponents();

    boolean appendComponent(Component component);

    boolean appendComponentOnIndex(int index, Component component);

    boolean removeComponentByIndex(int index);

    boolean removeComponentByIdentifier(String identifier);

    Optional<Component> findComponentByIdentifier(String identifier);

    Set<Component> findComponentsByIdentifier(String identifier);

    default Iterator<Component> iterator() {
        return getComponents().iterator();
    }
}
