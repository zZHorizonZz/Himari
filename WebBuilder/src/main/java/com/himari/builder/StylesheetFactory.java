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
import com.himari.builder.component.graphic.GraphicComponent;
import com.himari.builder.flag.AttributeFactory;

public record StylesheetFactory(Component component) {

    public String create() {
        if (component == null) {
            return "";
        }

        return evaluateComponent(component, 1, 128);
    }

    private String evaluateComponent(Component component, int currentDepth, int maxDepth) {
        StringBuilder builder = new StringBuilder();
        builder.append(component.getType().getTag());
        if (component.getFlagContainer().size() > 0) {
            builder.append(" ").append(new AttributeFactory(component.getFlagContainer().getAttributesAsSet()).create());
        }

        builder.append(">");

        if (component instanceof ExpandableComponent expandableComponent) {
            expandableComponent.iterator().forEachRemaining(childComponent -> {
                if (currentDepth < maxDepth) {
                    builder.append("\n");
                    builder.append("\t".repeat(Math.max(0, currentDepth)));
                    builder.append(evaluateComponent(childComponent, currentDepth + 1, maxDepth));
                }
            });
        }

        if (component instanceof GraphicComponent graphicComponent) {
            builder.append(graphicComponent.getValue());
        } else {
            builder.append("\n");
            builder.append("\t".repeat(Math.max(0, currentDepth - 1)));
        }

        return builder.toString();
    }
}
