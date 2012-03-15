/*
 *  geo-platform
 *  Rich webgis framework
 *  http://geo-platform.org
 * ====================================================================
 *
 * Copyright (C) 2008-2012 geoSDI Group (CNR IMAA - Potenza - ITALY).
 *
 * This program is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version. This program is distributed in the 
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR 
 * A PARTICULAR PURPOSE. See the GNU General Public License 
 * for more details. You should have received a copy of the GNU General 
 * Public License along with this program. If not, see http://www.gnu.org/licenses/ 
 *
 * ====================================================================
 *
 * Linking this library statically or dynamically with other modules is 
 * making a combined work based on this library. Thus, the terms and 
 * conditions of the GNU General Public License cover the whole combination. 
 * 
 * As a special exception, the copyright holders of this library give you permission 
 * to link this library with independent modules to produce an executable, regardless 
 * of the license terms of these independent modules, and to copy and distribute 
 * the resulting executable under terms of your choice, provided that you also meet, 
 * for each linked independent module, the terms and conditions of the license of 
 * that module. An independent module is a module which is not derived from or 
 * based on this library. If you modify this library, you may extend this exception 
 * to your version of the library, but you are not obligated to do so. If you do not 
 * wish to do so, delete this exception statement from your version. 
 *
 */
package org.geosdi.geoplatform.gui.client.widget.components.search;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.google.gwt.user.client.Element;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 */
public class CatalogSearchWidget extends LayoutContainer {

    public CatalogSearchWidget() {
       setLayout(new ColumnLayout());
       setStyleAttribute("padding", "10px");
    }

    @Override
    protected void onRender(Element parent, int index) {
        super.onRender(parent, index);
        
        LayoutContainer left = new LayoutContainer();
        left.setLayout(new ColumnLayout());

        Label searchLabel = new Label("Search Text");
        searchLabel.setStyleAttribute("color", "#4169E1");
        searchLabel.setStyleAttribute("font",
                "normal 14px tahoma, arial, helvetica, sans-serif");

        left.add(searchLabel, new ColumnData(300.0));

        HorizontalPanel panel = new HorizontalPanel();
        panel.setStyleAttribute("padding-top", "8px");

        TextField<String> searchTextField = new TextField<String>();
        searchTextField.setWidth(250);
        panel.add(searchTextField);

        Button searchButton = new Button("Search");
        searchButton.setStyleAttribute("padding-left", "6px");
        panel.add(searchButton);

        left.add(panel);

        // Search Panel - Right
        LayoutContainer right = new LayoutContainer();
        right.setLayout(new ColumnLayout());

        Label optionsLabel = new Label("Search Options");
        optionsLabel.setStyleAttribute("color", "#4169E1");
        optionsLabel.setStyleAttribute("font",
                "normal 14px tahoma, arial, helvetica, sans-serif");

        right.add(optionsLabel, new ColumnData(240.0));

//        HorizontalPanel checkBoxes = new HorizontalPanel();
//        checkBoxes.setStyleAttribute("padding-top", "4px");

        CheckBoxGroup optionsCheckboxgroup = new CheckBoxGroup();
        optionsCheckboxgroup.setOrientation(Orientation.VERTICAL);
//        checkBoxes.add(optionsCheckboxgroup);

        CheckBox TitleCheckbox = new CheckBox();
        TitleCheckbox.setBoxLabel("Title");
        TitleCheckbox.setHideLabel(true);
        optionsCheckboxgroup.add(TitleCheckbox);

        CheckBox abstractCheckbox = new CheckBox();
        abstractCheckbox.setBoxLabel("Abstract");
        abstractCheckbox.setHideLabel(true);
        optionsCheckboxgroup.add(abstractCheckbox);

        CheckBox keywordsCheckbox = new CheckBox();
        keywordsCheckbox.setBoxLabel("Keywords");
        keywordsCheckbox.setHideLabel(true);
        optionsCheckboxgroup.add(keywordsCheckbox);
        
        right.add(optionsCheckboxgroup);

        CheckBox allCheckbox = new CheckBox();
        allCheckbox.setBoxLabel("Select/Deselect all");
        allCheckbox.setHideLabel(true);

//        checkBoxes.add(allCheckbox);

        right.add(allCheckbox);

        add(left, new ColumnData(0.6));
        add(right, new ColumnData(0.4));
    }
    
    
}