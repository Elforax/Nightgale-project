package me.elforax.infernalmadness.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class FileCopy {

    /**
     * Mirrors a pre configured file
     * @param in    inputstream pointing to the pre configured file
     * @param file  the output file where it needs to be copied to
     */
    public void copy(InputStream in, File file){
        try{
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
