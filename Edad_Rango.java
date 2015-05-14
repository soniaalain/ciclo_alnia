import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Edad_Rango {

	static String fec_nac="17/03/1984";
	static Integer fc_reposo=Integer.parseInt("80");
	
	public static void main(String[] args) {
		
		// CALCULANDO LA EDAD DESDE LA FECHA DE NACIMIENTO: NECESITO PARAMETRO STRING "FEC_NAC" DESDE INTERFAZ DE USUARIO
		
	
		String edad="";
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date edad1;
		try {
			edad1 = formatter.parse(fec_nac);
		 edad=getEdad(edad1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(edad);
		// HASTA AQUI EL CÁLCULO DE EDAD
		
		//AHORA CALCULAREMOS LOS RANGOS DE TRABAJO DEL USUARIO: NECESITO PARÁMETRO "EDAD" CALCULADO ANTES DE TIPO STRING Y LAS "PULSACIONES" TIPO INT DE LA INTERFAZ DE USUARIO.
		//DATOS NECESARIOS: EDAD+PULSACIONES EN REPOSO
		
		/* Fc=nº de contracciones del corazón por minuto.
		 * Fc max=límite teórico que corresponde al máximo de puls que puede alcanzarse durante un esfuerzo sin comprometer la salud.
		 * Fc max se cálcula con la fórmula de Tanaka (FCM = 208,75 – [0,73 * edad])
		 * CÁLCULO DE FRECUENCIA DE TRABAJO:
		 * MÉTODO KARVONEN:
		 * Fc_trabajo=[(Fc_max-Fc_reposo)*porcentaje de esfuerzo]+Fc_reposo
		 * */
		calcularRangos(edad);
Precarga barra=new Precarga();
barra.setVisible(true);
	}
		
	//FUNCIONES PARA CÁLUCLO DE EDAD DEL USUARIO:
	
	public static String getEdad(Date fechaNacimiento) {
        if (fechaNacimiento != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    StringBuilder result = new StringBuilder();
            if (fechaNacimiento != null) {
           // result.append(sdf.format(fechaNacimiento));
            //result.append(" (");
                Calendar c = new GregorianCalendar();
                c.setTime(fechaNacimiento);
                result.append(calcularEdad(c));
                //result.append(" años)");
            }
            return result.toString();
    }
return "";
    }
     
private static int calcularEdad(Calendar fechaNac) {
    Calendar today = Calendar.getInstance();
        int diffYear = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int diffMonth = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
    int diffDay = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
        // Si está en ese año pero todavía no los ha cumplido
        if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
            diffYear = diffYear - 1; // no aparecían los dos guiones del
                                    // postincremento 😐
}
        return diffYear;
}


//FUNCION QUE CALCULA LOS RANGOS DE TRABAJO

public static void calcularRangos(String edad){
	
	Integer fc_max=(int) (208.75 -(0.73*Integer.parseInt(edad)));

	//ZONA 1 < de 50%
	
	Integer zona1_minima=0;//Solo se necesita la zona minima del rango1, los demas.. el minimo es el maximo de la zona anterior.
	Integer zona1_maxima=fc_reposo;
	//Integer fc_trabajo1_minima=(int) (((fc_max-fc_reposo)*0.50)+fc_reposo);
	//Integer fc_trabajo1_maxima=(int) (((fc_max-fc_reposo)*0.60)+fc_reposo);		
	//System.out.println("Zona1 minima="+Integer.toString(fc_trabajo1_minima));
	//System.out.println("Zona1 maxima"+Integer.toString(fc_trabajo1_maxima));
	
	//ZONA 2=50-60%- AYUDA A LA RECUPERACIÓN
	
	Integer zona2_minima=0;//Solo se necesita la zona minima del rango1, los demas.. el minimo es el maximo de la zona anterior.
	//Integer zona2_maxima=fc_trabajo1_maxima;
	//Integer fc_trabajo2_minima=(int) (((fc_max-fc_reposo)*0.50)+fc_reposo);
	Integer fc_trabajo2_maxima=(int) (((fc_max-fc_reposo)*0.60)+fc_reposo);		
	//System.out.println("Zona2 minima="+Integer.toString(fc_trabajo2_minima));
	System.out.println("Zona2 maxima"+Integer.toString(fc_trabajo2_maxima));
	
	//ZONA 3=60-70%- MEJORA LA RESISTENCIA BÁSICA Y LA QUEMA DE GRASAS
	
	//Integer zona2_minima=0;
	Integer zona3_maxima=0;
	//Integer fc_trabajo3_minima=fc_trabajo2_maxima;
	Integer fc_trabajo3_maxima=(int) (((fc_max-fc_reposo)*0.70)+fc_reposo);		
	//System.out.println("Zona3 minima="+Integer.toString(fc_trabajo3_minima));
	System.out.println("Zona3 maxima"+Integer.toString(fc_trabajo3_maxima));
	
	//ZONA 4=70-80%- MEJORA LA RESISTENCIA AERÓBICA
	
	//Integer zona4_minima=0;
	Integer zona4_maxima=0;
	//Integer fc_trabajo4_minima=fc_trabajo3_maxima;
	Integer fc_trabajo4_maxima=(int) (((fc_max-fc_reposo)*0.80)+fc_reposo);		
	//System.out.println("Zona4 minima="+Integer.toString(fc_trabajo4_minima));
	System.out.println("Zona4 maxima"+Integer.toString(fc_trabajo4_maxima));
	
	//ZONA 4=80-90%-INCREMENTA LA RESISTENCIA ANAERÓBICA EN SESIONES CORTAS
	
	//Integer zona5_minima=0;
	Integer zona5_maxima=0;
	//Integer fc_trabajo5_minima=fc_trabajo4_maxima;
	Integer fc_trabajo5_maxima=(int) (((fc_max-fc_reposo)*0.90)+fc_reposo);		
	//System.out.println("Zona5 minima="+Integer.toString(fc_trabajo5_minima));
	System.out.println("Zona5 maxima"+Integer.toString(fc_trabajo5_maxima));
	
	//ZONA 6=90-100%-MEJORA LA VELOCIDAD Y TONIFICA EL SISTEMA NEUROMUSCULAR
	
	//Integer zona5_minima=0;
	Integer zona6_maxima=0;
	//Integer fc_trabajo6_minima=fc_trabajo5_maxima;
	Integer fc_trabajo6_maxima=(int) (((fc_max-fc_reposo)*1)+fc_reposo);		
	//System.out.println("Zona6 minima="+Integer.toString(fc_trabajo6_minima));
	System.out.println("Zona6 maxima"+Integer.toString(fc_trabajo6_maxima));

}

}
