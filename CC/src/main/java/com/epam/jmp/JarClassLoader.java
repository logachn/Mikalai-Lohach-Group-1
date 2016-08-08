package com.epam.jmp;


import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class JarClassLoader extends URLClassLoader {

    public JarClassLoader(URL[] urls) {
        super(urls);
    }

    public void addFile (String path) throws MalformedURLException
    {
        String urlPath = "jar:file://" + path + "!/";
        addURL (new URL (urlPath));
    }
}
