/* 
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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
Builder class for javafx.scene.control.MenuBar
@see javafx.scene.control.MenuBar
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class MenuBarBuilder<B extends javafx.scene.control.MenuBarBuilder<B>> extends javafx.scene.control.ControlBuilder<B> implements javafx.util.Builder<javafx.scene.control.MenuBar> {
    protected MenuBarBuilder() {
    }
    
    /** Creates a new instance of MenuBarBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.control.MenuBarBuilder<?> create() {
        return new javafx.scene.control.MenuBarBuilder();
    }
    
    private int __set;
    public void applyTo(javafx.scene.control.MenuBar x) {
        super.applyTo(x);
        int set = __set;
        if ((set & (1 << 0)) != 0) x.getMenus().addAll(this.menus);
        if ((set & (1 << 1)) != 0) x.setUseSystemMenuBar(this.useSystemMenuBar);
    }
    
    private java.util.Collection<? extends javafx.scene.control.Menu> menus;
    /**
    Add the given items to the List of items in the {@link javafx.scene.control.MenuBar#getMenus() menus} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B menus(java.util.Collection<? extends javafx.scene.control.Menu> x) {
        this.menus = x;
        __set |= 1 << 0;
        return (B) this;
    }
    
    /**
    Add the given items to the List of items in the {@link javafx.scene.control.MenuBar#getMenus() menus} property for the instance constructed by this builder.
    */
    public B menus(javafx.scene.control.Menu... x) {
        return menus(java.util.Arrays.asList(x));
    }
    
    private boolean useSystemMenuBar;
    /**
    Set the value of the {@link javafx.scene.control.MenuBar#isUseSystemMenuBar() useSystemMenuBar} property for the instance constructed by this builder.
    * @since JavaFX 2.1
    */
    @SuppressWarnings("unchecked")
    public B useSystemMenuBar(boolean x) {
        this.useSystemMenuBar = x;
        __set |= 1 << 1;
        return (B) this;
    }
    
    /**
    Make an instance of {@link javafx.scene.control.MenuBar} based on the properties set on this builder.
    */
    public javafx.scene.control.MenuBar build() {
        javafx.scene.control.MenuBar x = new javafx.scene.control.MenuBar();
        applyTo(x);
        return x;
    }
}
