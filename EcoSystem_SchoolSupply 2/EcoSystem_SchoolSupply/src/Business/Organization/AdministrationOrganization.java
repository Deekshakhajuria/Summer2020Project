/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.SchoolClerkRole;
import java.util.ArrayList;

/**
 *
 * @author deekshakhajuria
 */
public class AdministrationOrganization extends Organization {
    public AdministrationOrganization() {
        super(Organization.Type.Administration.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SchoolClerkRole());
        return roles;
    }
}
