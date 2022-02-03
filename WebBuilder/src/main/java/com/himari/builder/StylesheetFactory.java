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

package com.himari.builder;

import com.himari.builder.component.Component;
import com.himari.builder.component.ExpandableComponent;
import com.himari.builder.style.StyleFactory;
import com.himari.builder.style.styles.StyleElement;

public record StylesheetFactory(Component component) {

    public String create() {
        if (component == null || !(component instanceof StyleElement)) {
            return "";
        }

        return evaluateComponent(component);
    }

    private String evaluateComponent(Component component) {
        StringBuilder builder = new StringBuilder();
        if (component instanceof StyleElement styleable) {
            if (styleable.getStyleContainer().size() > 0) {
                builder.append(new StyleFactory(component, styleable.getStyleContainer().getStyleAttributesAsSet(), component.hasIdentifier()).create());
                builder.append("\n");
            }
        }

        if (component instanceof ExpandableComponent expandableComponent) {
            expandableComponent.getComponents().forEach(comp -> builder.append(evaluateComponent(comp)));
        }

        return builder.toString();
    }
}
