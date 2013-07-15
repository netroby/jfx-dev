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

package javafx.scene.shape;

import java.util.Arrays;
import java.util.Collection;

import javafx.scene.paint.Color;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.sun.javafx.scene.DirtyBits;
import com.sun.javafx.test.OnInvalidateMethodsTestBase;

@RunWith(Parameterized.class)
public class Shape_onInvalidate_Test extends OnInvalidateMethodsTestBase {

    public Shape_onInvalidate_Test(Configuration config) {
        super(config);
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
            {new Configuration(Line.class, "strokeWidth", 2.0, new DirtyBits[] {DirtyBits.SHAPE_STROKEATTRS})},
            {new Configuration(Line.class, "strokeLineJoin", StrokeLineJoin.BEVEL, new DirtyBits[] {DirtyBits.SHAPE_STROKEATTRS})},
            {new Configuration(Line.class, "strokeLineCap", StrokeLineCap.BUTT, new DirtyBits[] {DirtyBits.SHAPE_STROKEATTRS})},
            {new Configuration(Line.class, "strokeMiterLimit", 4.0, new DirtyBits[] {DirtyBits.SHAPE_STROKEATTRS})},
            {new Configuration(Line.class, "strokeDashOffset", 1.0, new DirtyBits[] {DirtyBits.SHAPE_STROKEATTRS})},
            {new Configuration(Line.class, "fill", Color.RED, new DirtyBits[] {DirtyBits.SHAPE_FILL})},
            {new Configuration(Line.class, "stroke", Color.RED, new DirtyBits[] {DirtyBits.SHAPE_STROKE})},
            {new Configuration(Line.class, "smooth", false, new DirtyBits[] {DirtyBits.NODE_SMOOTH})}
        };
        return Arrays.asList(data);
    }
}
