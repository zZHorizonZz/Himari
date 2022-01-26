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

package com.himari.builder.component.divider;

import com.himari.builder.component.Component;
import com.himari.builder.component.ComponentType;
import com.himari.builder.component.ExpandableComponent;
import com.himari.builder.flag.Attribute;
import com.himari.builder.flag.AttributeContainer;

import java.util.*;
import java.util.stream.Collectors;

public class DividerComponent implements ExpandableComponent {

    private String identifier;

    private final List<Component> components = new LinkedList<>();
    private final AttributeContainer flagContainer = new AttributeContainer();

    @Override
    public ComponentType getType() {
        return ComponentType.DIVIDER;
    }

    @Override
    public AttributeContainer getFlagContainer() {
        return flagContainer;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
        this.addAttribute(new Attribute<>("class", identifier));
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public boolean appendComponent(Component component) {
        return components.add(component);
    }

    @Override
    public boolean appendComponentOnIndex(int index, Component component) {
        if (index >= components.size()) {
            return false;
        }

        components.add(index, component);
        return true;
    }

    @Override
    public boolean removeComponentByIndex(int index) {
        if (index >= components.size()) {
            return false;
        }

        components.remove(index);
        return true;
    }

    @Override
    public boolean removeComponentByIdentifier(String identifier) {
        Iterator<Component> componentIterator = iterator();
        while (componentIterator.hasNext()) {
            Component component = componentIterator.next();
            if (!component.hasIdentifier()) {
                continue;
            }

            if (component.getIdentifier().equals(identifier)) {
                componentIterator.remove();
                return true;
            }
        }

        return false;
    }

    @Override
    public Optional<Component> findComponentByIdentifier(String identifier) {
        return components.parallelStream().filter(component -> component.getIdentifier().equals(identifier)).findFirst();
    }

    @Override
    public Set<Component> findComponentsByIdentifier(String identifier) {
        return components.parallelStream().filter(component -> component.getIdentifier().equals(identifier)).collect(Collectors.toUnmodifiableSet());
    }
}
