/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.javafx.scene.control.behavior;

import static javafx.scene.input.KeyCode.A;
import static javafx.scene.input.KeyCode.BACK_SLASH;
import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.END;
import static javafx.scene.input.KeyCode.ENTER;
import static javafx.scene.input.KeyCode.ESCAPE;
import static javafx.scene.input.KeyCode.F2;
import static javafx.scene.input.KeyCode.HOME;
import static javafx.scene.input.KeyCode.KP_DOWN;
import static javafx.scene.input.KeyCode.KP_LEFT;
import static javafx.scene.input.KeyCode.KP_RIGHT;
import static javafx.scene.input.KeyCode.KP_UP;
import static javafx.scene.input.KeyCode.LEFT;
import static javafx.scene.input.KeyCode.PAGE_DOWN;
import static javafx.scene.input.KeyCode.PAGE_UP;
import static javafx.scene.input.KeyCode.RIGHT;
import static javafx.scene.input.KeyCode.SPACE;
import static javafx.scene.input.KeyCode.TAB;
import static javafx.scene.input.KeyCode.UP;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewFocusModel;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import com.sun.javafx.PlatformUtil;
import javafx.util.Callback;

public class TableViewBehavior<T> extends BehaviorBase<TableView<T>> {
    /**************************************************************************
     *                          Setup KeyBindings                             *
     *************************************************************************/
    protected static final List<KeyBinding> TABLE_VIEW_BINDINGS = new ArrayList<KeyBinding>();

    static {
        TABLE_VIEW_BINDINGS.add(new KeyBinding(TAB, "TraverseNext"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(TAB, "TraversePrevious").shift());

        TABLE_VIEW_BINDINGS.add(new KeyBinding(HOME, "SelectFirstRow"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(END, "SelectLastRow"));
        
        TABLE_VIEW_BINDINGS.add(new KeyBinding(PAGE_UP, "ScrollUp"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(PAGE_DOWN, "ScrollDown"));

        TABLE_VIEW_BINDINGS.add(new KeyBinding(LEFT, "SelectLeftCell"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_LEFT, "SelectLeftCell"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(RIGHT, "SelectRightCell"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_RIGHT, "SelectRightCell"));

        TABLE_VIEW_BINDINGS.add(new KeyBinding(UP, "SelectPreviousRow"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_UP, "SelectPreviousRow"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(DOWN, "SelectNextRow"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_DOWN, "SelectNextRow"));

        TABLE_VIEW_BINDINGS.add(new KeyBinding(LEFT, "TraverseLeft"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_LEFT, "TraverseLeft"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(RIGHT, "SelectNextRow"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_RIGHT, "SelectNextRow"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(UP, "TraverseUp"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_UP, "TraverseUp"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(DOWN, "TraverseDown"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_DOWN, "TraverseDown"));

        TABLE_VIEW_BINDINGS.add(new KeyBinding(HOME, "SelectAllToFirstRow").shift());
        TABLE_VIEW_BINDINGS.add(new KeyBinding(END, "SelectAllToLastRow").shift());
        TABLE_VIEW_BINDINGS.add(new KeyBinding(PAGE_UP, "SelectAllPageUp").shift());
        TABLE_VIEW_BINDINGS.add(new KeyBinding(PAGE_DOWN, "SelectAllPageDown").shift());

        TABLE_VIEW_BINDINGS.add(new KeyBinding(UP, "AlsoSelectPrevious").shift());
        TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_UP, "AlsoSelectPrevious").shift());
        TABLE_VIEW_BINDINGS.add(new KeyBinding(DOWN, "AlsoSelectNext").shift());
        TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_DOWN, "AlsoSelectNext").shift());
        
        TABLE_VIEW_BINDINGS.add(new KeyBinding(SPACE, "SelectAllToFocus").shift());

//        TABLE_VIEW_BINDINGS.add(new KeyBinding(UP, "AlsoSelectPreviousCell").shift());
//        TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_UP, "AlsoSelectPreviousCell").shift());
//        TABLE_VIEW_BINDINGS.add(new KeyBinding(DOWN, "AlsoSelectNextCell").shift());
//        TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_DOWN, "AlsoSelectNextCell").shift());
        TABLE_VIEW_BINDINGS.add(new KeyBinding(LEFT, "AlsoSelectLeftCell").shift());
        TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_LEFT, "AlsoSelectLeftCell").shift());
        TABLE_VIEW_BINDINGS.add(new KeyBinding(RIGHT, "AlsoSelectRightCell").shift());
        TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_RIGHT, "AlsoSelectRightCell").shift());

        if (PlatformUtil.isMac()) {
            TABLE_VIEW_BINDINGS.add(new KeyBinding(UP, "FocusPreviousRow").meta());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(DOWN, "FocusNextRow").meta());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(RIGHT, "FocusRightCell").meta());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_RIGHT, "FocusRightCell").meta());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(LEFT, "FocusLeftCell").meta());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_LEFT, "FocusLeftCell").meta());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(A, "SelectAll").meta());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(HOME, "FocusFirstRow").meta());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(END, "FocusLastRow").meta());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(SPACE, "toggleFocusOwnerSelection").ctrl().meta());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(PAGE_UP, "FocusPageUp").meta());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(PAGE_DOWN, "FocusPageDown").meta());
        } else {
            TABLE_VIEW_BINDINGS.add(new KeyBinding(UP, "FocusPreviousRow").ctrl());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(DOWN, "FocusNextRow").ctrl());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(RIGHT, "FocusRightCell").ctrl());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_RIGHT, "FocusRightCell").ctrl());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(LEFT, "FocusLeftCell").ctrl());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(KP_LEFT, "FocusLeftCell").ctrl());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(A, "SelectAll").ctrl());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(HOME, "FocusFirstRow").ctrl());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(END, "FocusLastRow").ctrl());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(SPACE, "toggleFocusOwnerSelection").ctrl());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(PAGE_UP, "FocusPageUp").ctrl());
            TABLE_VIEW_BINDINGS.add(new KeyBinding(PAGE_DOWN, "FocusPageDown").ctrl());
        }

        TABLE_VIEW_BINDINGS.add(new KeyBinding(ENTER, "Activate"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(SPACE, "Activate"));
        TABLE_VIEW_BINDINGS.add(new KeyBinding(F2, "Activate"));
//        TABLE_VIEW_BINDINGS.add(new KeyBinding(SPACE, "Activate").ctrl());
        
        TABLE_VIEW_BINDINGS.add(new KeyBinding(ESCAPE, "CancelEdit"));

        if (PlatformUtil.isMac()) {
            TABLE_VIEW_BINDINGS.add(new KeyBinding(BACK_SLASH, "ClearSelection").meta());
        } else {
            TABLE_VIEW_BINDINGS.add(new KeyBinding(BACK_SLASH, "ClearSelection").ctrl());
        }
    }

    @Override protected void callAction(String name) {
        if ("SelectPreviousRow".equals(name)) selectPreviousRow();
        else if ("SelectNextRow".equals(name)) selectNextRow();
        else if ("SelectLeftCell".equals(name)) selectLeftCell();
        else if ("SelectRightCell".equals(name)) selectRightCell();
        else if ("SelectFirstRow".equals(name)) selectFirstRow();
        else if ("SelectLastRow".equals(name)) selectLastRow();
        else if ("SelectAll".equals(name)) selectAll();
        else if ("SelectAllPageUp".equals(name)) selectAllPageUp();
        else if ("SelectAllPageDown".equals(name)) selectAllPageDown();
        else if ("SelectAllToFirstRow".equals(name)) selectAllToFirstRow();
        else if ("SelectAllToLastRow".equals(name)) selectAllToLastRow();
        else if ("AlsoSelectNext".equals(name)) alsoSelectNext();
        else if ("AlsoSelectPrevious".equals(name)) alsoSelectPrevious();
        else if ("AlsoSelectLeftCell".equals(name)) alsoSelectLeftCell();
        else if ("AlsoSelectRightCell".equals(name)) alsoSelectRightCell();
        else if ("ClearSelection".equals(name)) clearSelection();
        else if ("ScrollUp".equals(name)) scrollUp();
        else if ("ScrollDown".equals(name)) scrollDown();
        else if ("FocusPreviousRow".equals(name)) focusPreviousRow();
        else if ("FocusNextRow".equals(name)) focusNextRow();
        else if ("FocusLeftCell".equals(name)) focusLeftCell();
        else if ("FocusRightCell".equals(name)) focusRightCell();
        else if ("Activate".equals(name)) activate();
        else if ("CancelEdit".equals(name)) cancelEdit();
        else if ("FocusFirstRow".equals(name)) focusFirstRow();
        else if ("FocusLastRow".equals(name)) focusLastRow();
        else if ("toggleFocusOwnerSelection".equals(name)) toggleFocusOwnerSelection();
        else if ("SelectAllToFocus".equals(name)) selectAllToFocus();
        else if ("FocusPageUp".equals(name)) focusPageUp();
        else if ("FocusPageDown".equals(name)) focusPageDown();
        else super.callAction(name);
    }

    // TODO
    @Override protected List<KeyBinding> createKeyBindings() {
        return TABLE_VIEW_BINDINGS;
    }
    
    @Override protected void callActionForEvent(KeyEvent e) {
        // RT-12751: we want to keep an eye on the user holding down the shift key, 
        // so that we know when they enter/leave multiple selection mode. This
        // changes what happens when certain key combinations are pressed.
        isShiftDown = e.getEventType() == KeyEvent.KEY_PRESSED && e.isShiftDown();
        isCtrlDown = e.getEventType() == KeyEvent.KEY_PRESSED && e.isControlDown();
        
        super.callActionForEvent(e);
    }

    /**************************************************************************
     *                         State and Functions                            *
     *************************************************************************/

    public TableViewBehavior(TableView control) {
        super(control);
    }

    @Override public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        
        // FIXME can't assume (yet) cells.get(0) is necessarily the lead cell
        ObservableList<TablePosition> cells = getControl().getSelectionModel().getSelectedCells();
        setAnchor(cells.isEmpty() ? null : cells.get(0));
        
        if (!getControl().isFocused() && getControl().isFocusTraversable()) {
            getControl().requestFocus();
        }
    }
    
    private boolean isCtrlDown = false;
    private boolean isShiftDown = false;
    
    
    
    /*
     * Anchor is created upon
     * - initial selection of an item (by mouse or keyboard)
     * 
     * Anchor is changed when you
     * - move the selection to an item by UP/DOWN/LEFT/RIGHT arrow keys
     * - select an item by mouse click
     * - add/remove an item to/from an existing selection by CTRL+SPACE shortcut
     * - add/remove an items to/from an existing selection by CTRL+mouse click
     * 
     * Note that if an item is removed from an existing selection by 
     * CTRL+SPACE/CTRL+mouse click, anchor still remains on this item even 
     * though it is not selected.
     * 
     * Anchor is NOT changed when you
     * - create linear multi-selection by SHIFT+UP/DOWN/LEFT/RIGHT arrow keys
     * - create linear multi-selection by SHIFT+SPACE arrow keys
     * - create linear multi-selection by SHIFT+mouse click
     * 
     * In case there is a discontinuous selection in the list, creating linear 
     * multi-selection between anchor and focused item will cancel the 
     * discontinuous selection. It means that only items that are located between
     * anchor and focused item will be selected. 
     */
    private TablePosition anchor;
    
    private void setAnchor(int row, TableColumn col) {
        setAnchor(row == -1 && col == null ? null : 
                new TablePosition(getControl(), row, col));
    }
    private void setAnchor(TablePosition tp) {
        anchor = tp;
    }
//    private void shiftAnchor(boolean rowDirection, int delta) {
//        if (anchor == null) return;
//        if (rowDirection) {
//            int currentRow = anchor.getRow();
//            int newRow = currentRow + delta;
//            if (newRow >= 0 && newRow < getItemCount()) {
//                setAnchor(newRow, anchor.getTableColumn());
//            }
//        } else {
//            System.err.println("can not shift in column direction yet");
//        }
//    }
    private int getItemCount() {
        return getControl().getItems() == null ? 0 : getControl().getItems().size();
    }
    
    
    
//    // Support for RT-13826:
//    // set when focus is moved by keyboard to allow for proper selection positions
//    private int selectPos = -1;

    private Callback<Void, Integer> onScrollPageUp;
    public void setOnScrollPageUp(Callback<Void, Integer> c) { onScrollPageUp = c; }

    private Callback<Void, Integer> onScrollPageDown;
    public void setOnScrollPageDown(Callback<Void, Integer> c) { onScrollPageDown = c; }

    private Runnable onFocusPreviousRow;
    public void setOnFocusPreviousRow(Runnable r) { onFocusPreviousRow = r; }

    private Runnable onFocusNextRow;
    public void setOnFocusNextRow(Runnable r) { onFocusNextRow = r; }

    private Runnable onSelectPreviousRow;
    public void setOnSelectPreviousRow(Runnable r) { onSelectPreviousRow = r; }

    private Runnable onSelectNextRow;
    public void setOnSelectNextRow(Runnable r) { onSelectNextRow = r; }

    private Runnable onMoveToFirstCell;
    public void setOnMoveToFirstCell(Runnable r) { onMoveToFirstCell = r; }

    private Runnable onMoveToLastCell;
    public void setOnMoveToLastCell(Runnable r) { onMoveToLastCell = r; }

    private Runnable onSelectRightCell;
    public void setOnSelectRightCell(Runnable r) { onSelectRightCell = r; }

    private Runnable onSelectLeftCell;
    public void setOnSelectLeftCell(Runnable r) { onSelectLeftCell = r; }
    
    private void scrollUp() {
        TableView.TableViewSelectionModel<T> sm = getControl().getSelectionModel();
        if (sm == null || sm.getSelectedCells().isEmpty()) return;
        
        TablePosition selectedCell = sm.getSelectedCells().get(0);
        
        int newSelectedIndex = -1;
        if (onScrollPageUp != null) {
            newSelectedIndex = onScrollPageUp.call(null);
        }
        if (newSelectedIndex == -1) return;
        
        sm.clearAndSelect(newSelectedIndex, selectedCell.getTableColumn());
    }

    private void scrollDown() {
        TableView.TableViewSelectionModel<T> sm = getControl().getSelectionModel();
        if (sm == null || sm.getSelectedCells().isEmpty()) return;
        
        TablePosition selectedCell = sm.getSelectedCells().get(0);
        
        int newSelectedIndex = -1;
        if (onScrollPageDown != null) {
            newSelectedIndex = onScrollPageDown.call(null);
        }
        if (newSelectedIndex == -1) return;
        
        sm.clearAndSelect(newSelectedIndex, selectedCell.getTableColumn());
    }
    
    private void focusFirstRow() {
        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;
        
        TableColumn tc = fm.getFocusedCell() == null ? null : fm.getFocusedCell().getTableColumn();
        fm.focus(0, tc);
        
        if (onMoveToFirstCell != null) onMoveToFirstCell.run();
    }
    
    private void focusLastRow() {
        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;
        
        TableColumn tc = fm.getFocusedCell() == null ? null : fm.getFocusedCell().getTableColumn();
        fm.focus(getItemCount() - 1, tc);
        
        if (onMoveToLastCell != null) onMoveToLastCell.run();
    }

    // TODO need table.scrollDown()
    private void focusPreviousRow() {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null) return;

        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;

        if (sm.isCellSelectionEnabled()) {
            fm.focusAboveCell();
        } else {
            fm.focusPrevious();
        }
        
        if (! isCtrlDown || anchor == null) {
            setAnchor(fm.getFocusedIndex(), null);
        }

        if (onFocusPreviousRow != null) onFocusPreviousRow.run();
    }

    private void focusNextRow() {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null) return;

        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;
        
        if (sm.isCellSelectionEnabled()) {
            fm.focusBelowCell();
        } else {
            fm.focusNext();
        }
        
        if (! isCtrlDown || anchor == null) {
            setAnchor(fm.getFocusedIndex(), null);
        }
        
        if (onFocusNextRow != null) onFocusNextRow.run();
    }

    private void focusLeftCell() {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null) return;

        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;

        fm.focusLeftCell();
        if (onFocusPreviousRow != null) onFocusPreviousRow.run();
    }

    private void focusRightCell() {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null) return;

        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;

        fm.focusRightCell();
        if (onFocusNextRow != null) onFocusNextRow.run();
    }
    
    private void focusPageUp() {
        int newFocusIndex = onScrollPageUp.call(null);
        
        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;
        TableColumn tc = fm.getFocusedCell() == null ? null : fm.getFocusedCell().getTableColumn();
        fm.focus(newFocusIndex, tc);
    }
    
    private void focusPageDown() {
        int newFocusIndex = onScrollPageDown.call(null);
        
        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;
        TableColumn tc = fm.getFocusedCell() == null ? null : fm.getFocusedCell().getTableColumn();
        fm.focus(newFocusIndex, tc);
    }

    private void clearSelection() {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null) return;

        sm.clearSelection();
    }

    private void alsoSelectPrevious() {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null || sm.getSelectionMode() == SelectionMode.SINGLE) return;
        
        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;
        
        final int focusIndex = fm.getFocusedIndex();

        if (sm.isCellSelectionEnabled()) {
            TablePosition focusedCell = fm.getFocusedCell();
            if (isShiftDown && sm.isSelected(focusedCell.getRow() - 1, focusedCell.getTableColumn())) {
                int newFocusOwner = focusedCell.getRow() - 1;
                sm.clearSelection(fm.getFocusedIndex(), focusedCell.getTableColumn());
                fm.focus(newFocusOwner, focusedCell.getTableColumn());
            } else {
                if (! sm.isSelected(focusIndex, focusedCell.getTableColumn())) {
                    sm.select(focusIndex, focusedCell.getTableColumn());
                }
                sm.selectAboveCell();
            }
        } else {
            if (isShiftDown && anchor != null) {
                int newRow = fm.getFocusedIndex() - 1;

                clearSelectionOutsideRange(anchor.getRow(), newRow);
                
                if (anchor.getRow() > newRow) {
                    sm.selectRange(anchor.getRow(), newRow - 1);
                } else {
                    sm.selectRange(anchor.getRow(), newRow + 1);
                }
            } else {
                sm.selectPrevious();
            }
        }

        onSelectPreviousRow.run();
    }

    private void alsoSelectNext() {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null || sm.getSelectionMode() == SelectionMode.SINGLE) return;
        
        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;

        if (sm.isCellSelectionEnabled()) {
            TablePosition focusedCell = fm.getFocusedCell();
            if (isShiftDown && sm.isSelected(focusedCell.getRow() + 1, focusedCell.getTableColumn())) {
                int newFocusOwner = focusedCell.getRow() + 1;
                sm.clearSelection(fm.getFocusedIndex(), focusedCell.getTableColumn());
                fm.focus(newFocusOwner, focusedCell.getTableColumn());
            } else {
                sm.selectBelowCell();
            }
        } else {
            if (isShiftDown && anchor != null) {
                int newRow = fm.getFocusedIndex() + 1;

                clearSelectionOutsideRange(anchor.getRow(), newRow);
                
                if (anchor.getRow() > newRow) {
                    sm.selectRange(anchor.getRow(), newRow - 1);
                } else {
                    sm.selectRange(anchor.getRow(), newRow + 1);
                }
            } else {
                sm.selectNext();
            }
        }
        onSelectNextRow.run();
    }
    
    private void clearSelectionOutsideRange(int start, int end) {
        TableView.TableViewSelectionModel<T> sm = getControl().getSelectionModel();
        if (sm == null) return;
        
        int min = Math.min(start, end);
        int max = Math.max(start, end);
        
        List<Integer> indices = new ArrayList<Integer>(sm.getSelectedIndices());
        
        for (int i = 0; i < indices.size(); i++) {
            int index = indices.get(i);
            if (index < min || index >= max) {
                sm.clearSelection(index);
            }
        }
    }

    private void alsoSelectLeftCell() {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null || sm.getSelectionMode() == SelectionMode.SINGLE) return;

        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;
        
        TablePosition fc = fm.getFocusedCell();
        if (fc == null || fc.getTableColumn() == null) return;
        
        TableColumn leftColumn = getColumn(fc.getTableColumn(), -1);
        if (leftColumn == null) return;
        
        if (isShiftDown && anchor != null && 
            sm.isSelected(fc.getRow(), leftColumn) &&
            ! (fc.getRow() == anchor.getRow() && fc.getTableColumn().equals(leftColumn))) {
                sm.clearSelection(fc.getRow(), fc.getTableColumn());
                fm.focus(fc.getRow(), leftColumn);
        } else {
            sm.selectLeftCell();
        }
    }

    private void alsoSelectRightCell() {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null || sm.getSelectionMode() == SelectionMode.SINGLE) return;

        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;
        
        TablePosition fc = fm.getFocusedCell();
        if (fc == null || fc.getTableColumn() == null) return;
        
        TableColumn rightColumn = getColumn(fc.getTableColumn(), 1);
        if (rightColumn == null) return;
        
        if (isShiftDown && anchor != null && 
            sm.isSelected(fc.getRow(), rightColumn) &&
            ! (fc.getRow() == anchor.getRow() && fc.getTableColumn().equals(rightColumn))) {
                sm.clearSelection(fc.getRow(), fc.getTableColumn());
                fm.focus(fc.getRow(), rightColumn);
        } else {
            sm.selectRightCell();
        }
    }
    
    private TableColumn getColumn(TableColumn tc, int delta) {
        return getControl().getVisibleLeafColumn(getControl().getVisibleLeafIndex(tc) + delta);
    }

    private void selectFirstRow() {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null) return;

        ObservableList<TablePosition> selection = sm.getSelectedCells();
        TableColumn<?,?> selectedColumn = selection.size() == 0 ? null : selection.get(0).getTableColumn();
        sm.clearAndSelect(0, selectedColumn);

        if (onMoveToFirstCell != null) onMoveToFirstCell.run();
    }

    private void selectLastRow() {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null) return;

        ObservableList<TablePosition> selection = sm.getSelectedCells();
        TableColumn<?,?> selectedColumn = selection.size() == 0 ? null : selection.get(0).getTableColumn();
        sm.clearAndSelect(getItemCount() - 1, selectedColumn);

        if (onMoveToLastCell != null) onMoveToLastCell.run();
    }

    private void selectPreviousRow() {
        selectCell(-1, 0);
        if (onSelectPreviousRow != null) onSelectPreviousRow.run();
    }

    private void selectNextRow() {
        selectCell(1, 0);
        if (onSelectNextRow != null) onSelectNextRow.run();
    }

    private void selectLeftCell() {
        selectCell(0, -1);
        if (onSelectLeftCell != null) onSelectLeftCell.run();
    }

    private void selectRightCell() {
        selectCell(0, 1);
        if (onSelectRightCell != null) onSelectRightCell.run();
    }

    private void selectCell(int rowDiff, int columnDiff) {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null) return;

        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;

        TablePosition focusedCell = fm.getFocusedCell();
        int currentRow = focusedCell.getRow();
        int currentColumn = focusedCell.getColumn();
        if (rowDiff < 0 && currentRow == 0) return;
        else if (rowDiff > 0 && currentRow == getItemCount() - 1) return;
        else if (columnDiff < 0 && currentColumn == 0) return;
        else if (columnDiff > 0 && currentColumn == getVisibleLeafColumnCount(getControl().getColumns(), 0) - 1) return;

        TableColumn tc = focusedCell.getTableColumn();
        tc = getColumn(tc, columnDiff);
        
        int row = focusedCell.getRow() + rowDiff;
        sm.clearAndSelect(row, tc);
        setAnchor(row, tc);
    }

    // copied from TableView
    private int getVisibleLeafColumnCount(List cols, int count) {
        if (cols == null || cols.isEmpty()) return count;

        for (int i = 0; i < cols.size(); i++) {
            TableColumn col = (TableColumn) cols.get(i);
            if (col.getColumns() != null && col.getColumns().isEmpty()) {
                count++;
            } else {
                count += getVisibleLeafColumnCount(col.getColumns(), count);
            }
        }

        return count;
    }
    
    private void cancelEdit() {
        getControl().edit(-1, null);
    }

    private void activate() {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null) return;

        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;

        TablePosition cell = fm.getFocusedCell();
        sm.select(cell.getRow(), cell.getTableColumn());

        // edit this row also
        getControl().edit(cell.getRow(), cell.getTableColumn());
    }
    
    private void selectAllToFocus() {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null) return;

        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;

        TablePosition focusedCell = fm.getFocusedCell();
        int focusIndex = focusedCell.getRow();
        int selectIndex = sm.getSelectedIndex();
        
        sm.clearSelection();
        if (! sm.isCellSelectionEnabled()) {
            int startPos = selectIndex;
            int endPos = selectIndex > focusIndex ? focusIndex - 1 : focusIndex + 1;
            sm.selectRange(startPos, endPos);
        } else {
            int min = Math.min(selectIndex, focusIndex);
            int max = Math.max(selectIndex, focusIndex);
            
            for (int i = min; i <= max; i++) {
                sm.select(i, focusedCell.getTableColumn());
            }
        }
    }
    
    private void selectAll() {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null) return;
        sm.selectAll();
    }

    private void selectAllToFirstRow() {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null) return;

        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;

        TablePosition focusedCell = fm.getFocusedCell();
        
        int leadIndex = focusedCell.getRow();
        
        if (isShiftDown) {
            leadIndex = anchor == null ? leadIndex : anchor.getRow();
        }

        sm.clearSelection();
        if (! sm.isCellSelectionEnabled()) {
            // we are going from 0 to one before the focused cell as that is
            // the requirement of selectRange, so we call focus on the 0th row
            sm.selectRange(0, leadIndex + 1);
            getControl().getFocusModel().focus(0);
            setAnchor(leadIndex, null);
        } else {
            // TODO
            
//            setAnchor(leadIndex, );
        }

        if (onMoveToFirstCell != null) onMoveToFirstCell.run();
    }

    private void selectAllToLastRow() {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null) return;

        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;

        TablePosition focusedCell = fm.getFocusedCell();
        
        int leadIndex = focusedCell.getRow();
        
        if (isShiftDown) {
            leadIndex = anchor == null ? leadIndex : anchor.getRow();
            setAnchor(leadIndex, null);
        }
        
        sm.clearSelection();
        if (! sm.isCellSelectionEnabled()) {
            sm.selectRange(leadIndex, getItemCount());
        } else {
            // TODO
        }

        if (onMoveToLastCell != null) onMoveToLastCell.run();
    }
    
    private void selectAllPageUp() {
        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;

        int leadIndex = fm.getFocusedIndex();
        if (isShiftDown) {
            leadIndex = anchor == null ? leadIndex : anchor.getRow();
            setAnchor(leadIndex, null);
        }
        
        int leadSelectedIndex = onScrollPageUp.call(null);
        
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null) return;
        
        sm.clearSelection();
        sm.selectRange(leadSelectedIndex, leadIndex + 1);
    }
    
    private void selectAllPageDown() {
        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;
        
        int leadIndex = fm.getFocusedIndex();
        if (isShiftDown) {
            leadIndex = anchor == null ? leadIndex : anchor.getRow();
            setAnchor(leadIndex, null);
        }
        
        int leadSelectedIndex = onScrollPageDown.call(null);
        
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null) return;
        
        sm.clearSelection();
        sm.selectRange(leadIndex, leadSelectedIndex + 1);
    }
    
    private void toggleFocusOwnerSelection() {
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null) return;

        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;

        TablePosition focusedCell = fm.getFocusedCell();
        
        if (sm.isSelected(focusedCell.getRow(), focusedCell.getTableColumn())) {
            sm.clearSelection(focusedCell.getRow(), focusedCell.getTableColumn());
        } else {
            sm.select(focusedCell.getRow(), focusedCell.getTableColumn());
        }
    }
    
    // This functionality was added, but then removed when it was realised by 
    // UX that TableView should not include 'spreadsheet-like' functionality.
    // When / if we ever introduce this kind of control, this functionality can
    // be re-enabled then.
    /*
    private void moveToLeftMostColumn() {
        // Functionality as described in RT-12752
        if (onMoveToLeftMostColumn != null) onMoveToLeftMostColumn.run();
        
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null || ! sm.isCellSelectionEnabled()) return;
        
        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;

        TablePosition focusedCell = fm.getFocusedCell();
        
        TableColumn endColumn = getControl().getVisibleLeafColumn(0);
        sm.clearAndSelect(focusedCell.getRow(), endColumn);
    }
    
    private void moveToRightMostColumn() {
        // Functionality as described in RT-12752
        if (onMoveToRightMostColumn != null) onMoveToRightMostColumn.run();
        
        TableView.TableViewSelectionModel sm = getControl().getSelectionModel();
        if (sm == null || ! sm.isCellSelectionEnabled()) return;
        
        TableViewFocusModel fm = getControl().getFocusModel();
        if (fm == null) return;

        TablePosition focusedCell = fm.getFocusedCell();
        
        TableColumn endColumn = getControl().getVisibleLeafColumn(getControl().getVisibleLeafColumns().size() - 1);
        sm.clearAndSelect(focusedCell.getRow(), endColumn);
    }
     */
}
