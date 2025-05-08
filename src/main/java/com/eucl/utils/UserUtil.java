package com.eucl.utils;

import java.util.UUID;

public class UserUtil {
    public static String generateUserId() {
        return "EUCL-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }
}

