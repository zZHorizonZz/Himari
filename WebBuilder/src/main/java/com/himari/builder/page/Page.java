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

package com.himari.builder.page;

import com.himari.builder.component.BodyComponent;
import com.himari.builder.component.header.resources.Resource;

import java.util.LinkedList;
import java.util.List;

public class Page {

    private String title;
    private List<Resource> resourceList = new LinkedList<>();
    private BodyComponent pageBody;

    public Page(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    public BodyComponent getPageBody() {
        return pageBody;
    }

    public void setPageBody(BodyComponent pageBody) {
        this.pageBody = pageBody;
    }
}
