package ro.academyplus.avaj.simulator.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class OutputRedirector {

    public static void redirectOutputToFile(String file) throws IOException
    {
     
       PrintStream originalOut = System.out;
       FileOutputStream redirectOutputToFile = new FileOutputStream(file);

        System.setOut(new PrintStream(originalOut) {
        @Override
        public void write(byte[] buf, int off, int len) {
            //originalOut.write(buf, off, len);
            try {
                redirectOutputToFile.write(buf, off, len);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });
    }

}
