package work.oscarramos.calculaedad;


import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CalculoEdadTarea {
    public static void main(String[] args) {
        String fechaCap = JOptionPane.showInputDialog("Fecha de nacimiento año-mes-dia : ");
        if(fechaCap.isEmpty()){
            int cap =  JOptionPane.showConfirmDialog(null,"Desea continuar","Debe ingresar una fecha",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
            if(cap==0){
                main(args);
            }else{
                System.exit(0);
            }
        }
        LocalDate fechaNacimiento = LocalDate.parse(fechaCap, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate actual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, actual);

        if(periodo.isNegative()){
            int cap =  JOptionPane.showConfirmDialog(null,"Desea continuar","Error en la fecha",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
            if(cap==0){
                main(args);
            }
        }else{
            JOptionPane.showConfirmDialog(null,"Usted tiene una de edad de : "+ periodo.getYears() + " años","Resultado", JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
