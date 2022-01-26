/*
 * Copyright (c)  2022 Daniel Fiala
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.himari.builder.style;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

public class StyleAttributeContainer {

    private final List<StyleAttribute<?>> attributes = new LinkedList<>();
    private final Map<String, StyleAttribute<?>> mappedAttributes = new HashMap<>();

    public static void addStyleAttribute(StyleAttributeContainer container, String name, String value) {
        if (value == null) {
            container.removeStyleAttribute(name);
        } else {
            container.addStyleAttribute(new StyleAttribute<>(name, value));
        }
    }

    public void addStyleAttribute(StyleAttribute<?> flag) {
        if (!attributes.contains(flag)) {
            attributes.add(flag);
        }

        mappedAttributes.put(flag.getName(), flag);
    }

    public void removeStyleAttribute(StyleAttribute<?> flag) {
        this.removeStyleAttribute(flag.getName());
    }

    public void removeStyleAttribute(String name) {
        attributes.removeIf(flag -> flag.getName().equals(name));
        mappedAttributes.remove(name);
    }

    @Nullable
    public StyleAttribute<?> getStyleAttributesByName(String name) {
        return mappedAttributes.get(name);
    }

    @NotNull
    public List<StyleAttribute<?>> getStyleAttributes() {
        return attributes;
    }

    public Set<StyleAttribute<?>> getStyleAttributesAsSet() {
        return attributes.stream().collect(Collectors.toUnmodifiableSet());
    }

    @NotNull
    public Map<String, StyleAttribute<?>> getMappedStyleAttributes() {
        return mappedAttributes;
    }

    public int size() {
        return attributes.size();
    }
}
