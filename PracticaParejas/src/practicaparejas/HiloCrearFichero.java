package practicaparejas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Danny
 */
public class HiloCrearFichero {
        interfazEspacios strAux;
        String ruta;

        public HiloCrearFichero(String rutaFich, interfazEspacios metodo) {
            strAux = metodo;
            ruta = rutaFich;
        }

        public void crearFicheroEjem() {
            String[] palabras = new String['Z' - 'A' + 1];
            Random r = new Random(new Date().getTime());
            for (char c = 'A'; c < 'Z' + 1; c++) {
                int repe = r.nextInt((8 - 2) + 1) + 2; //numero entre 2 y 9
                System.out.println(repe + " " + c);
                palabras[c - 65] = "";
                for (int i = 0; i < repe; i++) {
                    palabras[c - 65] += "" + c;
                }
            }
            System.out.println(">" + Arrays.toString(palabras));
            //crear fichero
            FileWriter fich = null;
            try {
                fich = new FileWriter(this.ruta, false);
                for (int i = 0; i < 100000; i++) {
                    if (r.nextInt(3) == 0) {
                        fich.write(palabras[r.nextInt(palabras.length)]);
                    }
                    if (r.nextInt(3) == 0) {
                        for (int j = 0; j < 10; j++) {
                                fich.write(" ");
                        }
                    }
                    if (r.nextInt(12) == 0) {
                            fich.write("\n\r");
                    }
                }
                    fich.close();
            } catch (IOException ex) {
                System.out.println("Error en escritura : " + ex.getMessage());
            } finally {
                try {
                    if (fich != null) {
                        fich.close();
                    }
                } catch (IOException ex) {
                        System.out.println("Error en escritura : " + ex.getMessage());
                }
            }
        }

        public void leerFicheroEjem() {
        File fich = new File(this.ruta);
        Scanner escaner = null;
        try {
            escaner = new Scanner(fich);
            while (escaner.hasNextLine()) {
                String linea = escaner.nextLine();
                System.out.println(strAux.quitaEspacio(linea));
            }
        } catch (Exception ex) {
                System.out.println("Error en escritura : " + ex.getMessage());
        } finally {
                try {
                    if (escaner != null) {
                        escaner.close();
                    }
                } catch (Exception ex) {
                    System.out.println("Error en cerrar : " + ex.getMessage());
                }
        }
    }
}
