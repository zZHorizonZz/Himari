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

package com.github;

import com.himari.builder.component.BodyComponent;
import com.himari.builder.component.divider.DividerComponent;
import com.himari.builder.component.graphic.LabelComponent;
import com.himari.builder.component.header.resources.Relationship;
import com.himari.builder.component.header.resources.Resource;
import com.himari.builder.page.Page;
import com.himari.builder.page.PageFactory;
import com.himari.mapping.Mapping;
import com.himari.response.Response;

public class DemoMapping implements Mapping<String> {

    @Override
    public Response<String> handle() {
        BodyComponent body = new BodyComponent();
        DividerComponent div = new DividerComponent();
        div.setBackgroundColor("rgb(0, 0, 139)");
        body.appendComponent(div);
        div.appendComponent(new LabelComponent("Test text"));

        div.setIdentifier("test");

        Page page = new Page("Test title....");
        page.getResourceList().add(new Resource("style.css", Relationship.STYLESHEET));
        page.setPageBody(body);

        PageFactory pageFactory = new PageFactory(page);
        String output = pageFactory.createHtml();
        return new Response<>(output);
    }
}
