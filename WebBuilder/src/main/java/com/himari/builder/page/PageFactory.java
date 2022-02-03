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

import com.himari.builder.HtmlFactory;
import com.himari.builder.StylesheetFactory;
import com.himari.builder.component.HtmlComponent;
import com.himari.builder.component.header.HeaderComponent;

public class PageFactory {

    private final Page page;

    private String html;
    private String stylesheet;

    public PageFactory(Page page) {
        this.page = page;
    }

    public String createHtml() {
        StringBuilder pageBuilder = new StringBuilder("""
                <!DOCTYPE HTML>""");

        HtmlComponent html = new HtmlComponent();
        if (page.getResourceList().size() > 0) {
            HeaderComponent header = new HeaderComponent();
            page.getResourceList().forEach(header::appendComponent);
            html.appendComponent(header);
        }

        html.appendComponent(page.getPageBody());
        HtmlFactory htmlFactory = new HtmlFactory(html);
        pageBuilder.append(htmlFactory.create());

        this.html = pageBuilder.toString();

        return this.html;
    }

    public String createStyleSheet() {
        StylesheetFactory stylesheetFactory = new StylesheetFactory(page.getPageBody());
        this.stylesheet = stylesheetFactory.create();

        return this.stylesheet;
    }

    public Page getPage() {
        return page;
    }

    public String getHtml() {
        return html;
    }

    public String getStylesheet() {
        return stylesheet;
    }
}
