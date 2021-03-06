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
package org.geosdi.geoplatform.gml.api.parser.base.geometry.collection;

import com.google.common.base.Preconditions;
import com.vividsolutions.jts.geom.GeometryCollection;
import org.geosdi.geoplatform.gml.api.AbstractGeometricAggregate;
import org.geosdi.geoplatform.gml.api.MultiGeometry;
import org.geosdi.geoplatform.gml.api.MultiGeometryProperty;
import org.geosdi.geoplatform.gml.api.MultiLineString;
import org.geosdi.geoplatform.gml.api.MultiPoint;
import org.geosdi.geoplatform.gml.api.MultiPolygon;
import org.geosdi.geoplatform.gml.api.MultiSurface;
import org.geosdi.geoplatform.gml.api.parser.base.GMLBaseParser;
import org.geosdi.geoplatform.gml.api.parser.base.geometry.collection.responsability.GeometryCollectionHandler;
import org.geosdi.geoplatform.gml.api.parser.base.geometry.collection.responsability.MultiPointCollectionHandler;
import org.geosdi.geoplatform.gml.api.parser.exception.ParserException;

/**
 * <p>This Class permits to parse this kinds of GML Geometries : 
 * <ul>
 *      <li>{@link MultiPoint}</li>
 *      <li>{@link MultiLineString}</li>
 *      <li>{@link MultiPolygon}</li>
 *      <li>{@link MultiGeometry}</li>
 * </ul>
 * </p>
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class GMLBaseGeometryCollectionParser implements
        GMLBaseParser<AbstractGeometricAggregate, MultiGeometryProperty, GeometryCollection> {
    
    private GeometryCollectionHandler multiPointHandler = new MultiPointCollectionHandler();

    @Override
    public GeometryCollection parseGeometry(
            AbstractGeometricAggregate gmlGeometry)
            throws ParserException {
        
        return this.multiPointHandler.parseGeometry(gmlGeometry);
    }

    @Override
    public GeometryCollection parseGeometry(MultiGeometryProperty propertyType)
            throws ParserException {

        Preconditions.checkNotNull(propertyType, "The MultiGeometry Property "
                + "must be not null.");

        if (propertyType.isSetGeometricAggregate()) {
            return parseGeometry(propertyType.getAbstractGeometricAggregate());
        }

        throw new ParserException("There is no GeometricAggregate to parse.");
    }
}
