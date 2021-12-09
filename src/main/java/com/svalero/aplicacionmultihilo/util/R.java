package com.svalero.aplicacionmultihilo.util;

import java.io.File;
import java.net.URL;

public class R {

    public static URL getURL (String name){
        return Thread.currentThread().getContextClassLoader().getResource("ui" + File.separator + name);
    }
}
