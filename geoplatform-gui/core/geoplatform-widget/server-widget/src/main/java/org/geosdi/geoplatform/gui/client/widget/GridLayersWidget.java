/*
 *  geo-platform
 *  Rich webgis framework
 *  http://geo-plartform.org
 * ====================================================================
 *
 * Copyright (C) 2008-2011 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
package org.geosdi.geoplatform.gui.client.widget;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.RowExpander;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import org.geosdi.geoplatform.gui.client.ServerWidgetResources;
import org.geosdi.geoplatform.gui.client.model.GPLayerBeanModel.GPLayerBeanKeyValue;
import org.geosdi.geoplatform.gui.client.widget.grid.GeoPlatformGridWidget;
import org.geosdi.geoplatform.gui.model.GPLayerBean;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 */
public class GridLayersWidget extends GeoPlatformGridWidget<GPLayerBean> {

    private FormPanel formPanel;
    private Button done;
    private DisplayServerWidget displayWidget;

    /**
     * @Constructor
     */
    public GridLayersWidget() {
        super(false);
        this.initServerWidget();
        this.initFormPanel();
    }

    private void initServerWidget() {
        this.displayWidget = new DisplayServerWidget();
    }

    private void initFormPanel() {
        this.formPanel = new FormPanel();
        getFormPanel().setHeaderVisible(false);
        getFormPanel().setFrame(true);
        getFormPanel().setLayout(new FlowLayout());

        this.getFormPanel().setTopComponent(this.displayWidget.getToolbar());

        this.getFormPanel().add(this.grid);

        this.getFormPanel().setButtonAlign(HorizontalAlignment.RIGHT);

        this.done = new Button("Done", ServerWidgetResources.ICONS.done());

        this.done.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                //** TODO: HERE THE CODE TO SEND ALL SELECTED LAYERS IN THE LAYERS STORE **/
            }
        });
    }

    @Override
    public void setGridProperties() {
        grid.setAutoExpandColumn(GPLayerBeanKeyValue.GPLAYER_NAME.getValue());
        grid.setBorders(false);

        grid.getView().setForceFit(true);
        grid.setLoadMask(true);

        grid.getSelectionModel().setSelectionMode(SelectionMode.MULTI);

        grid.addListener(Events.CellClick, new Listener<BaseEvent>() {

            @Override
            public void handleEvent(BaseEvent be) {
                done.enable();
            }
        });
    }

    @Override
    public ColumnModel prepareColumnModel() {
        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

        XTemplate tpl = XTemplate.create(
                "<p><b>Abstract:</b> {abstractText}</p>");
        RowExpander rowExpander = new RowExpander(tpl);

        configs.add(rowExpander);

        ColumnConfig name = new ColumnConfig();
        name.setId(GPLayerBeanKeyValue.GPLAYER_NAME.getValue());
        name.setHeader("Layer Name");
        name.setWidth(200);
        configs.add(name);

        ColumnConfig title = new ColumnConfig();
        title.setId(GPLayerBeanKeyValue.GPLAYER_LABEL.getValue());
        title.setHeader("Title");
        title.setWidth(150);
        configs.add(title);

        return new ColumnModel(configs);
    }

    @Override
    public void createStore() {
        this.store = new ListStore<GPLayerBean>();
    }

    /**
     * @return the formPanel
     */
    public FormPanel getFormPanel() {
        return formPanel;
    }
}