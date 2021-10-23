package com.carrental.util;

import com.carrental.auth.UserDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Util {

    public static String getActiveUsername() {
        UserDetail authUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return authUser.getUsername();
    }

    public static boolean isNullOrEmpty(Object o) {
        if (o == null) {
            return true;
        } else if (o.getClass().isArray()) {
            return o == null || ((Object[]) ((Object[]) o)).length == 0;
        } else {
            return o == null || o.toString().trim().equals("");
        }
    }

    public static ResponseEntity<Map<String, Object>> responseBody(String path, String adi, ArrayList<Object> nesne) {
        Map<String, Object> responseBody = new HashMap<>();

        for (int i = 0; i < nesne.size(); i++) {
            responseBody.put(adi, nesne.get(i));
        }

        responseBody.put("path", path);
        responseBody.put("status", HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
