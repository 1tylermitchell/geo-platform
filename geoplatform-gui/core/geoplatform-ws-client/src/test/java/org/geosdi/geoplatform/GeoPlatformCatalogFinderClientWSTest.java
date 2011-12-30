/*
 *  geo-platform
 *  Rich webgis framework
 *  http://geo-platform.org
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
package org.geosdi.geoplatform;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.geosdi.geoplatform.cxf.GeoPlatformCatalogFinderClient;

import org.geosdi.geoplatform.exception.GPCatalogException;
import org.geosdi.geoplatform.responce.GPCatalogMetadataDTO;
import org.geosdi.geoplatform.services.GPCatalogFinderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"applicationContext-Test.xml", "classpath*:applicationContext.xml"})
public class GeoPlatformCatalogFinderClientWSTest {

    @Autowired
    private GeoPlatformCatalogFinderClient geoPlatformCatalogFinderClient;

    @Test
    public void testWSRequest() {
        try {
            Assert.assertNotNull(geoPlatformCatalogFinderClient);

            GPCatalogFinderService gpCatalogFinderService = geoPlatformCatalogFinderClient.create();

            List<GPCatalogMetadataDTO> catalogMetadataDTOList = gpCatalogFinderService.searchPublicMetadata("strade romane");
            Assert.assertNotNull("List of metadata elements is null", catalogMetadataDTOList);
            Assert.assertTrue("No metadata elements get from web service", catalogMetadataDTOList.size() > 0);

            for (GPCatalogMetadataDTO gpCatalogMetadataDTO : catalogMetadataDTOList) {
                Assert.assertTrue("GPCatalogMetadataLoader is empty", gpCatalogMetadataDTO.toString().equals("") == false);
            }
        } catch (GPCatalogException ex) {
            Logger.getLogger(GeoPlatformCatalogFinderClientWSTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
    }
}
