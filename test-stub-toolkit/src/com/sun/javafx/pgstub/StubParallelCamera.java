/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.pgstub;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.Vec3d;
import com.sun.javafx.geom.transform.Affine3D;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.geom.transform.GeneralTransform3D;
import com.sun.javafx.sg.PGNode;
import com.sun.javafx.sg.PGParallelCamera;
import com.sun.scenario.effect.Blend;

public class StubParallelCamera extends StubNode implements PGParallelCamera {
    @Override public void setNearClip(float f) {}
    @Override public void setFarClip(float f) {}
    @Override public void setViewWidth(double viewWidth) { }
    @Override public void setViewHeight(double viewHeight) { }
    @Override public void setProjViewTransform(GeneralTransform3D projViewTx) { }
    @Override public void setPosition(Vec3d position) { }
    @Override public void setWorldTransform(Affine3D ad) {}
    @Override public void setTransformMatrix(BaseTransform bt) {}
    @Override public void setContentBounds(BaseBounds bb) {}
    @Override public void setTransformedBounds(BaseBounds bb, boolean bln) {}
    @Override public void setVisible(boolean bln) {}
    @Override public void setOpacity(float f) {}
    @Override public void setNodeBlendMode(Blend.Mode mode) {}
    @Override public void setDepthTest(boolean bln) {}
    @Override public void setClipNode(PGNode pgnode) {}
    @Override public void setCachedAsBitmap(boolean bln, CacheHint ch) {}
    @Override public void setEffect(Object o) {}
    @Override public void effectChanged() {}
    @Override public void release() {}
}
