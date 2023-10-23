package com.dev.torhugo.challenge_idwall.util;

public class ConstantsUtil {

    public ConstantsUtil() {
    }
    public static final String HOST_FBI = "https://api.fbi.gov";
    public static final String HOST_INTERPOL = "https://ws-public.interpol.int/notices/v1";
    public static final String PATH_FBI = "/@wanted";
    public static final String PATH_INTERPOL = "/red";
    public static final String PATH_INTERPOL_IMAGE = "/images";
    public static final String CARACTER_PATH = "/";
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299";
    public static final String AUTHORIZATION = "Authorization";
    public static final String SECRET_KEY = "cmVhc29uZGVzY3JpYmVuZWVkZWRmaWxscmlnaHRleGFjdGluZGl2aWR1YWxzdGVtc2M=";
    public static final String PATH_REGISTER_USER = "/api/v1/auth/register";
    public static final String PATH_AUTHENTICATE_USER = "/api/v1/auth/authenticate";
}
