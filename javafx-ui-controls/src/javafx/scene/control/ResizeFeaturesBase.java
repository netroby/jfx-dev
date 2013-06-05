/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * An immutable wrapper class for use by the column resize policies offered by
 * controls such as {@link TableView} and {@link TreeTableView}. 
 * @since JavaFX 8.0
 */
public class ResizeFeaturesBase<S> {
  private final TableColumnBase<S,?> column;
  private final Double delta;

  /**
   * Creates an instance of this class, with the provided TableColumnBase and 
   * delta values being set and stored in this immutable instance.
   * 
   * @param column The column upon which the resize is occurring, or null
   *      if this ResizeFeatures instance is being created as a result of a
   *      resize operation.
   * @param delta The amount of horizontal space added or removed in the 
   *      resize operation.
   */
  public ResizeFeaturesBase(TableColumnBase<S,?> column, Double delta) {
      this.column = column;
      this.delta = delta;
  }

  /**
   * Returns the column upon which the resize is occurring, or null
   * if this ResizeFeatures instance was created as a result of a
   * resize operation.
   */
  public TableColumnBase<S,?> getColumn() { return column; }

  /**
   * Returns the amount of horizontal space added or removed in the 
   * resize operation.
   */
  public Double getDelta() { return delta; }
}
