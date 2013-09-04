/* 
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package javafx.scene.control;

/**
Builder class for javafx.scene.control.IndexRange
@see javafx.scene.control.IndexRange
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public final class IndexRangeBuilder implements javafx.util.Builder<javafx.scene.control.IndexRange> {
    protected IndexRangeBuilder() {
    }
    
    /** Creates a new instance of IndexRangeBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.control.IndexRangeBuilder create() {
        return new javafx.scene.control.IndexRangeBuilder();
    }
    
    private int end;
    /**
    Set the value of the {@link javafx.scene.control.IndexRange#getEnd() end} property for the instance constructed by this builder.
    */
    public javafx.scene.control.IndexRangeBuilder end(int x) {
        this.end = x;
        return this;
    }
    
    private int start;
    /**
    Set the value of the {@link javafx.scene.control.IndexRange#getStart() start} property for the instance constructed by this builder.
    */
    public javafx.scene.control.IndexRangeBuilder start(int x) {
        this.start = x;
        return this;
    }
    
    /**
    Make an instance of {@link javafx.scene.control.IndexRange} based on the properties set on this builder.
    */
    public javafx.scene.control.IndexRange build() {
        javafx.scene.control.IndexRange x = new javafx.scene.control.IndexRange(this.start, this.end);
        return x;
    }
}
