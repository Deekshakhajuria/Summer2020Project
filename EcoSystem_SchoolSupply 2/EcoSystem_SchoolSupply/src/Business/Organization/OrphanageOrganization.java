/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.OrphanageEmployeeRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author deekshakhajuria
 */
public class OrphanageOrganization extends Organization {
    public OrphanageOrganization() {
        super(Organization.Type.Orphanage.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new OrphanageEmployeeRole());
        return roles;
    } 
}
