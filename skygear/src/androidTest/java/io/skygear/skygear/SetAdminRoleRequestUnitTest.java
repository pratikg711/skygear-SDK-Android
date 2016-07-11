package io.skygear.skygear;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class SetAdminRoleRequestUnitTest {

    @Test
    public void testSetAdminRoleRequestCreation() throws Exception {
        SetAdminRoleRequest request = new SetAdminRoleRequest(new Role[]{
                new Role("God"),
                new Role("Boss")
        });

        assertEquals("role:admin", request.action);

        Map<String, Object> data = request.data;
        String[] roleNames = (String[]) data.get("roles");
        List<String> roleNameList = Arrays.asList(roleNames);

        assertEquals(2, roleNameList.size());
        assertTrue(roleNameList.contains("God"));
        assertTrue(roleNameList.contains("Boss"));
    }

    @Test
    public void testSetAdminRoleRequestCreationWithSingleRole() throws Exception {
        SetAdminRoleRequest request = new SetAdminRoleRequest(new Role("God"));

        assertEquals("role:admin", request.action);

        Map<String, Object> data = request.data;
        String[] roleNames = (String[]) data.get("roles");

        assertEquals(1, roleNames.length);
        assertEquals("God", roleNames[0]);
    }
}