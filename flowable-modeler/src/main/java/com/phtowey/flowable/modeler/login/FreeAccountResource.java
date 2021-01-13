package com.phtowey.flowable.modeler.login;

import org.flowable.ui.common.model.UserRepresentation;
import org.flowable.ui.common.security.DefaultPrivileges;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * FreeAccountResource
 *
 * @author photowey
 * @date 2021/01/13
 * @since 1.0.0
 */
@RestController
@RequestMapping("/free")
public class FreeAccountResource {

    @GetMapping(value = "/rest/account", produces = "application/json")
    public UserRepresentation getAccount() {
        UserRepresentation userRepresentation = this.populateUserRepresentation();
        List<String> privileges = new ArrayList<>();
        this.populateAdminPrivileges(userRepresentation, privileges);

        return userRepresentation;
    }

    public void populateAdminPrivileges(UserRepresentation userRepresentation, List<String> privileges) {
        privileges.add(DefaultPrivileges.ACCESS_MODELER);
        privileges.add(DefaultPrivileges.ACCESS_IDM);
        privileges.add(DefaultPrivileges.ACCESS_ADMIN);
        privileges.add(DefaultPrivileges.ACCESS_TASK);
        privileges.add(DefaultPrivileges.ACCESS_REST_API);
        userRepresentation.setPrivileges(privileges);
    }

    public UserRepresentation populateUserRepresentation() {
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setEmail("photowey.flowable@ext.com");
        userRepresentation.setFirstName("shark");
        userRepresentation.setLastName("chili");
        userRepresentation.setFullName("shark chili");
        userRepresentation.setId("202010249527792377");
        userRepresentation.setTenantId("flowable-ext");
        return userRepresentation;
    }
}
