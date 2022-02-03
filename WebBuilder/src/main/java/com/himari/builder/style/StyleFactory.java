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

import com.himari.builder.component.Component;

import java.util.Set;

public record StyleFactory(Component component, Set<StyleAttribute<?>> style, boolean global) {

    public String create() {
        if (style.size() == 0) {
            return "";
        }

        StringBuilder flagBuilder = new StringBuilder((global ? component.getType().getTag() : component.getIdentifier()) + " {\n");
        System.out.println("Is global: " + global + " Identifier: " + component.getType().getTag());
        int index = 0;
        for (StyleAttribute<?> flag : style) {
            index++;
            flagBuilder.append("    ").append(flag.getName()).append(": ").append(flag.getValue()).append(";").append(index < style.size() ? "\n" : "");
        }

        flagBuilder.append("\n}");
        return flagBuilder.toString();
    }
}
