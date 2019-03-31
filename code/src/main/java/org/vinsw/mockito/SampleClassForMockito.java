package org.vinsw.mockito;

import java.io.IOException;

public class SampleClassForMockito {

    /**
     * Simple method throwing different exceptions depending on the parameter
     * @param n
     * @throws IOException
     */
    public void generateException(int n)  {

        switch (n) {
            case 1:
                try {
                    throw new IOException();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case 2:
                throw new IndexOutOfBoundsException();
            case 3:
                throw new NullPointerException();
            case 4:
                throw new NullPointerException();
        }



    }



}
