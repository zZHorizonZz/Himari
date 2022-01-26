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

package com.himari.builder.flag;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

public class AttributeContainer {

    private final List<Attribute<?>> attributes = new LinkedList<>();
    private final Map<String, Attribute<?>> mappedAttributes = new HashMap<>();

    public static void addAttribute(AttributeContainer container, String name, String value) {
        if (value == null) {
            container.removeAttribute(name);
        } else {
            container.addAttribute(new Attribute<>(name, value));
        }
    }

    public void addAttribute(Attribute<?> flag) {
        if (!attributes.contains(flag)) {
            attributes.add(flag);
        }

        mappedAttributes.put(flag.getName(), flag);
    }

    public void removeAttribute(Attribute<?> flag) {
        this.removeAttribute(flag.getName());
    }

    public void removeAttribute(String name) {
        attributes.removeIf(flag -> flag.getName().equals(name));
        mappedAttributes.remove(name);
    }

    @Nullable
    public Attribute<?> getAttributeByName(String name) {
        return mappedAttributes.get(name);
    }

    @NotNull
    public List<Attribute<?>> getAttributes() {
        return attributes;
    }

    public Set<Attribute<?>> getAttributesAsSet() {
        return attributes.stream().collect(Collectors.toUnmodifiableSet());
    }

    @NotNull
    public Map<String, Attribute<?>> getMappedAttributes() {
        return mappedAttributes;
    }

    public int size() {
        return attributes.size();
    }
}
