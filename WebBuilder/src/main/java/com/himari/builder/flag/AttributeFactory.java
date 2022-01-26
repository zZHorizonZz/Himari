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

import java.util.Set;

public record AttributeFactory(Set<Attribute<?>> flags) {

    public String create() {
        StringBuilder flagBuilder = new StringBuilder();
        int index = 0;
        for (Attribute<?> flag : flags) {
            index++;
            flagBuilder.append(flag.getName()).append("=").append(flag.getValue()).append(index < flags.size() ? " " : "");
        }

        return flagBuilder.toString();
    }
}
