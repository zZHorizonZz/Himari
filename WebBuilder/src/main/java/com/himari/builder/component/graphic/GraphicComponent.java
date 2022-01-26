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

package com.himari.builder.component.graphic;

import com.himari.builder.component.Component;
import com.himari.builder.flag.Attribute;
import com.himari.builder.flag.AttributeContainer;

public abstract class GraphicComponent implements Component {

    private String value;
    private String identifier;

    private final AttributeContainer attributeContainer = new AttributeContainer();

    public GraphicComponent() {
    }

    public GraphicComponent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
    public AttributeContainer getFlagContainer() {
        return attributeContainer;
    }
}
