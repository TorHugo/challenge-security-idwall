package com.dev.torhugo.challenge_idwall.util;

public class StringUtil {
    public static String generateBaseUri(final String host, final String path){
        return host.concat(path);
    }
}
