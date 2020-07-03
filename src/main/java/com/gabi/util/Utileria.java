package com.gabi.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utileria {

    //regresa una lista de strings con las fechas siguientes, segun el parametro count
    public static List<String> getNextDays(int count){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Date start = new Date();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, count);

        Date endDate = cal.getTime();

        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(start);
        List<String> nextDays = new ArrayList<String>();
        while (!gcal.getTime().after(endDate)){
            Date d = gcal.getTime();
            gcal.add(Calendar.DATE, 1);
            nextDays.add(sdf.format(d));
        }
        return nextDays;
    }


    public static String guardarImagen(MultipartFile multipart, HttpServletRequest request){
        String nombreOriginal = multipart.getOriginalFilename();
        nombreOriginal = nombreOriginal.replace(" ", "-");
        String nombreFinal = randomAlphaNumeric(8)+nombreOriginal;
        String rutaFinal = request.getServletContext().getRealPath("/resources/images/");
        try{
            File imageFile = new File(rutaFinal + nombreFinal);
            System.out.println("El nombre del archivo creado es: " + imageFile.toString());
            System.out.println(imageFile);
            multipart.transferTo(imageFile);
            return nombreFinal;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String randomAlphaNumeric(int count){
        String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0){
            int character = (int) (Math.random() * CARACTERES.length());
            builder.append(CARACTERES.charAt(character));
        }
        return builder.toString();
    }
}
