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

import com.himari.builder.flag.Attribute;
import com.himari.builder.flag.AttributeContainer;
import org.jetbrains.annotations.Nullable;

public interface Component {

    ComponentType getType();

    AttributeContainer getFlagContainer();

    default void addAttribute(Attribute<?> attribute) {
        getFlagContainer().addAttribute(attribute);
    }

    @Nullable
    default Attribute<?> getAttributeByName(String name) {
        return getFlagContainer().getAttributeByName(name);
    }

    void setIdentifier(String identifier);

    String getIdentifier();

    default boolean hasIdentifier() {
        return getIdentifier() != null;
    }
}
