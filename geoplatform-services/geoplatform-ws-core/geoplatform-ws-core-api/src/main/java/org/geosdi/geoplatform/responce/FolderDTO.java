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
package org.geosdi.geoplatform.responce;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import org.geosdi.geoplatform.core.model.GPFolder;
import org.geosdi.geoplatform.core.model.GPProject;

/**
 * @author giuseppe
 * @author Vincenzo Monteverde <vincenzo.monteverde@geosdi.org>
 */
@XmlRootElement(name = "FolderDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class FolderDTO extends AbstractElementDTO {

    private Boolean expanded;
    private Integer numberOfDescendants;
    //
    @XmlElementWrapper(name = "elementList")
    @XmlElement(name = "element")
    private List<IElementDTO> elementList;

    /**
     * Default constructor. NOTE: elementList is NULL.
     */
    public FolderDTO() {
    }

    /**
     * Constructor with GPFolder as arg.
     *
     * @param folder
     */
    public FolderDTO(GPFolder folder) {
        super(folder.getId(), folder.getName(), folder.getPosition(),
                folder.isShared(), folder.isChecked());
        this.expanded = folder.isExpanded();
        this.numberOfDescendants = folder.getNumberOfDescendants();
        this.elementList = new ArrayList<IElementDTO>();
    }

    /**
     * @return the expanded
     */
    public Boolean isExpanded() {
        return expanded;
    }

    /**
     * @param expanded the expanded to set
     */
    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    /**
     * @return the numberOfDescendants
     */
    public Integer getNumberOfDescendants() {
        return numberOfDescendants;
    }

    /**
     * @param numberOfDescendants to set
     */
    public void setNumberOfDescendants(Integer numberOfDescendants) {
        this.numberOfDescendants = numberOfDescendants;
    }

    /**
     * @return the elementList
     */
    public List<IElementDTO> getElementList() {
        return elementList;
    }

    /**
     * @param folders to add of elementList
     */
    public void addFolders(List<FolderDTO> folders) {
        elementList.addAll(folders);
        Collections.sort(elementList);
    }

    /**
     * @param layer to add of elementList
     */
    public void addLayer(ShortLayerDTO layer) {
        elementList.add(layer);
        Collections.sort(elementList);
    }

    /**
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FolderDTO [" + super.toString()
                + ", expanded=" + expanded
                + ", numberOfDescendants=" + numberOfDescendants + "]";
    }

    public static List<FolderDTO> convertToFolderDTOList(List<GPFolder> folders) {
        List<FolderDTO> foldersDTO = Lists.newArrayListWithCapacity(folders.size());

        for (GPFolder folder : folders) {
            FolderDTO folderDTO = new FolderDTO(folder);
            foldersDTO.add(folderDTO);
        }

        return foldersDTO;
    }

    public static GPFolder convertToGPFolder(GPProject project, GPFolder parent,
            FolderDTO folderDTO) {
        GPFolder folder = new GPFolder();

        folder.setProject(project);
        folder.setParent(parent);
        // Set all properties except "id" and "shared"
        folder.setName(folderDTO.getName());
        if (folderDTO.getPosition() != null) {
            folder.setPosition(folderDTO.getPosition());
        }
        if (folderDTO.isChecked() != null) {
            folder.setChecked(folderDTO.isChecked());
        }
        // Specific properties of a folder
        if (folderDTO.isExpanded() != null) {
            folder.setExpanded(folderDTO.isExpanded());
        }
        if (folderDTO.getNumberOfDescendants() != null) {
            folder.setNumberOfDescendants(folderDTO.getNumberOfDescendants());
        }

        return folder;
    }
}
