/*
 * Copyright (c) 2010, 2011, Oracle  and/or its affiliates. All rights reserved.
 */

package javafx.scene.control;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Richard
 */
public class SkinStub<C extends Control> implements Skin<C> {
    Rectangle r = new Rectangle();
    Node n;
    C c;

    public SkinStub(C c) {
        r.setWidth(20);
        r.setHeight(20);
        r.setStrokeWidth(0);
        n = r;
        this.c = c;
    }

    // For the sake of testing, I need to set the node sometimes
    public void setNode(Node n) {
        this.n = n;
    }

    /**
     * Gets the Control to which this Skin is assigned. A Skin must be created
     * for one and only one Control. This value will only ever go from a
     * non-null to null value when the Skin is removed from the Control, and
     * only as a consequence of a call to {@link dispose}.
     * <p/>
     * The caller who constructs a Control must also construct a Skin and
     * properly establish the relationship between the Control and its Skin.
     *
<PRE>
Button b = new Button();
ButtonSkin s = new ButtonSkin(b);
b.setSkin(s);
</PRE>
     * @return A non-null Control, or a null value if disposed.
     */
    @Override
    public C getSkinnable() {
        return c;
    }

    /**
     * Gets the Node which represents this Skin. This must never be null, except
     * after a call to {@link dispose}, and must never change except when
     * changing to null.
     *
     * @return
     */
    @Override
    public Node getNode() {
        return n;
    }

    /**
     * Called by a Control when the Skin is replaced on the Control. This method
     * allows a Skin to implement any logic necessary to clean up itself after
     * the Skin is no longer needed. It may be used to release native resources.
     * The methods {@link getControl}, {@link getBehavior}, and {@link getNode}
     * should return null following a call to dispose. Calling dispose twice
     * has no effect.
     */
    @Override
    public void dispose() {
    }

//    public static final class TextOffsetsStub extends Group implements TextOffsets {
//        @GenerateProperty private double offset = 10;
//        @Override public double getBaselineOffset() {
//            return offset;
//        }
//    }
}
