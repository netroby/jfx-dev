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

package com.sun.prism.es2;

import com.sun.prism.Image;
import com.sun.prism.PhongMaterial;
import com.sun.prism.Texture;
import com.sun.prism.TextureMap;
import com.sun.prism.impl.BaseGraphicsResource;
import com.sun.prism.impl.Disposer;
import com.sun.prism.paint.Color;
import sun.util.logging.PlatformLogger;

/**
 * TODO: 3D - Need documentation
 */
class ES2PhongMaterial extends BaseGraphicsResource implements PhongMaterial {

    static int count = 0;
    private final ES2Context context;
    private final long nativeHandle;
    TextureMap maps[] = new TextureMap[MAX_MAP_TYPE];

    Color diffuseColor = Color.WHITE;
    Color specularColor = Color.WHITE;

    boolean isSpecularAlpha = false;
    boolean isBumpAlpha = false;

    private ES2PhongMaterial(ES2Context context, long nativeHandle,
            Disposer.Record disposerRecord) {
        super(disposerRecord);
        this.context = context;
        this.nativeHandle = nativeHandle;
        count++;
    }

    static ES2PhongMaterial create(ES2Context context) {
        long nativeHandle = context.createES2PhongMaterial();
        return new ES2PhongMaterial(context, nativeHandle, new ES2PhongMaterialDisposerRecord(context, nativeHandle));
    }

    long getNativeHandle() {
        return nativeHandle;
    }

    public void setSolidColor(float r, float g, float b, float a) {
        diffuseColor = new Color(r,g,b,a);
    }

    public void setTextureMap(TextureMap map) {
        maps[map.getType().ordinal()] = map;
    }

    private Texture setupTexture(TextureMap map) {
        Image image = map.getImage();
        Texture texture = (image == null) ? null
                : context.getResourceFactory().getCachedTexture(image, Texture.WrapMode.CLAMP_TO_EDGE);
        switch (map.getType()) {
            case SPECULAR:
                isSpecularAlpha = texture == null ? false : !texture.getPixelFormat().isOpaque();
                break;
            case BUMP:
                isBumpAlpha = texture == null ? false : !texture.getPixelFormat().isOpaque();
                break;
            case DIFFUSE:
                break;
            case SELF_ILLUM:
                break;
            default:
            // NOP
        }
        return texture;
    }

    public void lockTextureMaps() {
        for (int i = 0; i < MAX_MAP_TYPE; i++) {
            Texture texture = maps[i].getTexture();
            if (!maps[i].isDirty() && texture != null) {
                texture.lock();
                if (!texture.isSurfaceLost()) {
                    continue;
                }
            }
            texture = setupTexture(maps[i]);
            maps[i].setTexture(texture);
            maps[i].setDirty(false);
            if (maps[i].getImage() != null && texture == null) {
                String logname = PhongMaterial.class.getName();
                PlatformLogger.getLogger(logname).warning(
                        "Warning: Low on texture resources. Cannot create texture.");
            }
        }
    }

    public void unlockTextureMaps() {
        for (int i = 0; i < MAX_MAP_TYPE; i++ ) {
            Texture texture = maps[i].getTexture();
            if (texture != null) {
                texture.unlock();
            }
        }
    }

    @Override
    public void dispose() {
        disposerRecord.dispose();
        count--;
    }

    public int getCount() {
        return count;
    }

    static class ES2PhongMaterialDisposerRecord implements Disposer.Record {

        private final ES2Context context;
        private long nativeHandle;

        ES2PhongMaterialDisposerRecord(ES2Context context, long nativeHandle) {
            this.context = context;
            this.nativeHandle = nativeHandle;
        }

        void traceDispose() {
        }

        public void dispose() {
            if (nativeHandle != 0L) {
                traceDispose();
                context.releaseES2PhongMaterial(nativeHandle);
                nativeHandle = 0L;
            }
        }
    }
}
