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

import com.himari.builder.component.Component;
import com.himari.builder.component.ComponentType;
import com.himari.builder.flag.AttributeContainer;

import java.awt.*;

public class Resource implements Component {

    private final AttributeContainer flagContainer = new AttributeContainer();

    private final String reference;
    private String referenceLanguage;
    private String mediaQuery;
    private ReferencePolicy policy;
    private Relationship relationship;
    private String sizes;
    private String mediaType;

    public Resource(String reference) {
        this.reference = reference;

        AttributeContainer.addAttribute(flagContainer, "href", reference);
    }

    public Resource(String reference, String mediaType) {
        this(reference);
        setMediaType(mediaType);
    }

    public Resource(String reference, Relationship relationship) {
        this(reference);
        setRelationship(relationship);
    }

    public Resource(String reference, Relationship relationship, String mediaType) {
        this(reference);
        setRelationship(relationship);
        setMediaType(mediaType);
    }

    public String getReference() {
        return reference;
    }

    public String getReferenceLanguage() {
        return referenceLanguage;
    }

    public void setReferenceLanguage(String referenceLanguage) {
        AttributeContainer.addAttribute(flagContainer, "hreflang", referenceLanguage);
        this.referenceLanguage = referenceLanguage;
    }

    public String getMediaQuery() {
        return mediaQuery;
    }

    public void setMediaQuery(String mediaQuery) {
        AttributeContainer.addAttribute(flagContainer, "media", mediaQuery);
        this.mediaQuery = mediaQuery;
    }

    public ReferencePolicy getPolicy() {
        return policy;
    }

    public void setPolicy(ReferencePolicy policy) {
        AttributeContainer.addAttribute(flagContainer, "referrerpolicy", policy.getValue());
        this.policy = policy;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        AttributeContainer.addAttribute(flagContainer, "rel", relationship.getValue());
        this.relationship = relationship;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        AttributeContainer.addAttribute(flagContainer, "sizes", sizes);
        this.sizes = sizes;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        AttributeContainer.addAttribute(flagContainer, "type", mediaType);
        this.mediaType = mediaType;
    }

    @Override
    public ComponentType getType() {
        return ComponentType.LINK;
    }

    @Override
    public AttributeContainer getFlagContainer() {
        return flagContainer;
    }

    @Override
    public void setIdentifier(String identifier) {
        throw new UnsupportedOperationException("Operation of setting the identifier is not supported in link component.");
    }

    @Override
    public String getIdentifier() {
        return null;
    }
}
