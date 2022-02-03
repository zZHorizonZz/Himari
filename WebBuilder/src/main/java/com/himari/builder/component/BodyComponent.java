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

import com.himari.builder.flag.AttributeContainer;
import com.himari.builder.style.StyleAttributeContainer;
import com.himari.builder.style.styles.MarginStyleElement;

import java.util.*;
import java.util.stream.Collectors;

public class BodyComponent implements ExpandableComponent, MarginStyleElement {

    private final List<Component> components = new LinkedList<>();
    private final AttributeContainer flagContainer = new AttributeContainer();
    private final StyleAttributeContainer styleAttributeContainer = new StyleAttributeContainer();

    @Override
    public ComponentType getType() {
        return ComponentType.BODY;
    }

    @Override
    public AttributeContainer getFlagContainer() {
        return flagContainer;
    }

    @Override
    public void setIdentifier(String identifier) {
        throw new UnsupportedOperationException("Operation of setting the identifier is not supported in body component.");
    }

    @Override
    public String getIdentifier() {
        return null;
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

    @Override
    public StyleAttributeContainer getStyleContainer() {
        return styleAttributeContainer;
    }
}
