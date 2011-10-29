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
package org.geosdi.geoplatform.services.development;

import java.util.List;
import org.geosdi.geoplatform.core.model.GPAuthority;
import org.geosdi.geoplatform.core.model.GPFolder;
import org.geosdi.geoplatform.core.model.GPLayer;
import org.geosdi.geoplatform.core.model.GPProject;
import org.geosdi.geoplatform.core.model.GPUser;
import org.geosdi.geoplatform.core.model.GPUserProjects;
import org.geosdi.geoplatform.exception.IllegalParameterFault;
import org.geosdi.geoplatform.gui.global.security.GPRole;
import org.springframework.security.acls.domain.BasePermission;

/**
 *
 * @author Vincenzo Monteverde
 * @email vincenzo.monteverde@geosdi.org - OpenPGP key ID 0xB25F4B38
 */
public class EntityCorrectness {

    public static void checkProject(GPProject project) throws IllegalParameterFault {
        if (project == null) {
            throw new IllegalParameterFault("Project must be NOT NULL");
        }
        if (EntityCorrectness.empty(project.getName())) {
            throw new IllegalParameterFault("Project \"name\" must be NOT NULL or empty");
        }
        if (project.getNumberOfElements() < 0) {
            throw new IllegalParameterFault("Project \"numberOfElements\" must be greater or equal 0");
        }
    }

    public static void checkProjectLog(GPProject project) {
        try {
            EntityCorrectness.checkProject(project);
        } catch (IllegalParameterFault ex) {
            throw new EntityCorrectnessException(ex.getMessage());
        }
    }

    public static void checkProjectListLog(List<GPProject> projects) {
        for (GPProject project : projects) {
            EntityCorrectness.checkProjectLog(project);
        }
    }

    public static void checkUserProject(GPUserProjects userProject) throws IllegalParameterFault {
        if (userProject == null) {
            throw new IllegalParameterFault("UserProject must be NOT NULL");
        }
        if (userProject.getProject() == null) {
            throw new IllegalParameterFault("Project must be NOT NULL");
        }
        if (userProject.getUser() == null) {
            throw new IllegalParameterFault("User must be NOT NULL");
        }
        if ((userProject.getPermissionMask() < BasePermission.READ.getMask())
                || (userProject.getPermissionMask() > BasePermission.ADMINISTRATION.getMask())) {
            throw new IllegalParameterFault("PermissionMask NOT allowed");
        }
    }

    public static void checkUserProjectLog(GPUserProjects userProject) {
        try {
            EntityCorrectness.checkUserProject(userProject);
        } catch (IllegalParameterFault ex) {
            throw new EntityCorrectnessException(ex.getMessage());
        }
    }

    public static void checkUserProjectListLog(List<GPUserProjects> userProjects) {
        for (GPUserProjects up : userProjects) {
            EntityCorrectness.checkUserProjectLog(up);
        }
    }

    public static void checkUser(GPUser user) throws IllegalParameterFault {
        if (user == null) {
            throw new IllegalParameterFault("User must be NOT NULL");
        }
        if (EntityCorrectness.empty(user.getName())) {
            throw new IllegalParameterFault("User \"name\" must be NOT NULL or empty");
        }
        if (EntityCorrectness.empty(user.getUsername())) {
            throw new IllegalParameterFault("User \"username\" must be NOT NULL or empty");
        }
        if (EntityCorrectness.empty(user.getPassword())) {
            throw new IllegalParameterFault("User \"password\" must be NOT NULL or empty");
        }
    }

    public static void checkAuthority(List<GPAuthority> authorities) throws IllegalParameterFault {
        if (authorities == null || authorities.isEmpty()) {
            throw new IllegalParameterFault("User must have at least a role");
        }
        for (GPAuthority authority : authorities) {
            String role = authority.getAuthority();
            if (EntityCorrectness.empty(role)) {
                throw new IllegalParameterFault("Authority is null or empty");
            }
            if (GPRole.fromString(role) == null) {
                throw new IllegalParameterFault("Authority is incorrect");
            }
        }
    }

    public static void checkUserAndAuthority(GPUser user) throws IllegalParameterFault {
        EntityCorrectness.checkUser(user);
        EntityCorrectness.checkAuthority(user.getGPAuthorities());
    }

    public static void checkUserLog(GPUser user) {
        try {
            EntityCorrectness.checkUser(user);
        } catch (IllegalParameterFault ex) {
            throw new EntityCorrectnessException(ex.getMessage());
        }
    }

    public static void checkAuthorityLog(List<GPAuthority> authorities) {
        try {
            EntityCorrectness.checkAuthority(authorities);
        } catch (IllegalParameterFault ex) {
            throw new EntityCorrectnessException(ex.getMessage());
        }
    }

    public static void checkUserAndAuthorityLog(GPUser user) {
        try {
            EntityCorrectness.checkUserAndAuthority(user);
        } catch (IllegalParameterFault ex) {
            throw new EntityCorrectnessException(ex.getMessage());
        }
    }

    public static void checkFolder(GPFolder folder) throws IllegalParameterFault {
        if (folder == null) {
            throw new IllegalParameterFault("Folder must be NOT NULL");
        }
        if (folder.getProject() == null) {
            throw new IllegalParameterFault("Folder \"project\" must be NOT NULL");
        }
        if (EntityCorrectness.empty(folder.getName())) {
            throw new IllegalParameterFault("Folder \"name\" must be NOT NULL or empty");
        }
        if (folder.getNumberOfDescendants() < 0) {
            throw new IllegalParameterFault("Folder \"numberOfDescendants\" must be greater or equal 0");
        }
        if (folder.getPosition() < 1) {
            throw new IllegalParameterFault("Folder \"position\" must be greater or equal 1");
        }
    }

    public static void checkFolderLog(GPFolder folder) {
        try {
            EntityCorrectness.checkFolder(folder);
        } catch (IllegalParameterFault ex) {
            throw new EntityCorrectnessException(ex.getMessage());
        }
    }

    public static void checkLayer(GPLayer layer) throws IllegalParameterFault {
        if (layer == null) {
            throw new IllegalParameterFault("Layer must be NOT NULL");
        }
        if (layer.getProject() == null) {
            throw new IllegalParameterFault("Layer \"project\" must be NOT NULL");
        }
        if (layer.getFolder() == null) {
            throw new IllegalParameterFault("Layer \"folder\" must be NOT NULL");
        }
        if (layer.getTitle() == null) {
            throw new IllegalParameterFault("Layer \"title\" must be NOT NULL");
        }
        if (layer.getLayerType() == null) {
            throw new IllegalParameterFault("Layer \"layerType\" must be NOT NULL");
        }
    }

    public static void checkLayerListLog(List<GPLayer> layers) {
        for (GPLayer layer : layers) {
            EntityCorrectness.checkLayerLog(layer);
        }
    }

    public static void checkLayerLog(GPLayer layer) {
        try {
            EntityCorrectness.checkLayer(layer);
        } catch (IllegalParameterFault ex) {
            throw new EntityCorrectnessException(ex.getMessage());
        }
    }

    public static boolean empty(String value) {
        if (value == null) {
            return true;
        }
        return value.trim().equals("");
    }
}