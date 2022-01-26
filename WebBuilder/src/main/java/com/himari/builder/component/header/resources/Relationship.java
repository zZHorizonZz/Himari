/*
 * Copyright (c)  2021 Daniel Fiala
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

package com.himari.builder.component.header.resources;

public enum Relationship {

    ALTERNATE("alternate"),
    AUTHOR("author"),
    DNS_PREFETCH("dns-prefetch"),
    HELP("help"),
    ICON("icon"),
    LICENSE("license"),
    NEXT("next"),
    PING_BACK("pingback"),
    PRE_CONNECT("preconnect"),
    PRE_FETCH("prefetch"),
    PRE_LOAD("preload"),
    PRE_RENDER("prerender"),
    PREVIOUS("prev"),
    SEARCH("search"),
    STYLESHEET("stylesheet");

    private final String value;

    Relationship(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
