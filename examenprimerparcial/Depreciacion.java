package examenprimerparcial;
import java.util.*;
import java.util.Scanner;

public class Depreciacion {
		public static void main(String[] args) {
			Scanner lec=new Scanner(System.in);
			char sal;
			double Ca, DA,vsp, valor, DPA;
			int op,  Viu, op2;
			String nombre;
			
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Bienvenido al sistema de depreciacion de Joshua" + "\n ");
			System.out.println("Favor ingrese su nombre");
			nombre = lec.nextLine();
			System.out.println("---------------------------------------------------------------------");
			do {
				
			do{System.out.println("" + nombre + " Que metodo gusta utilizar?  " + "\n1. Metodo de linea" + "\n2. Metodo de las unidades producidas" + "\n3. Metodo de reduccion de saldo" + "\n4. Metodo de la suma de los digitos por año"); 
			op=lec.nextInt();}while(op<1 || op>4);
			
			do{System.out.print(" Digite el valor del activo: ");
			Ca=lec.nextInt();}while(Ca<1000 || Ca>100000);
			
			do{System.out.print("Digite el valor de desecho/residual: ");
			vsp=lec.nextInt();}while(vsp<0 || vsp>100000);
			
			do{System.out.print("Digite la vida util del activo: ");
			Viu=lec.nextInt();}while(Viu<1 || Viu>20);
			
			switch(op) {
			
			case 1:
				System.out.println(" " + nombre + " Has escogido metodo de linea");
				if(vsp==0) {
					DA=(Ca/Viu);
				}else {
					DA=((Ca-vsp)/Viu);
				}
				valor=Ca-DA;DPA=0;
				    System.out.println("------------------------------------------------------------------------------");
				System.out.println("Costo del activo: " + Ca );
				 System.out.println("Valor de Desecho: " + vsp);
				  System.out.println("Vida Util: " + Viu);
				  System.out.println(" Cuota de Amortizacion: " + DA);
				    System.out.println("-------------------------------------------------------------------------------");
				 for(int i=1;i<=Viu;i++) {
					DPA=DPA+DA;
					valor=valor-DA;
				 }
				break;
			case 2:
				  int []datos = new int[Viu];
				  int suma=0;
				  double nw;
					System.out.println("Ingrese los valores de cada año de vida util");
					
					  for (int i = 0; i<Viu; i++) {
						  System.out.print((i+1)+" Año: ");
						  datos[i] = lec.nextInt();
					  }
					  for (int i = 0; i < Viu; i++) {
						  suma+= datos[i];
					  }
						if(vsp==0) {
							DA=(Ca/suma);
						}else {
							DA=(Ca-vsp)/suma;
						}
						System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					  System.out.println("Costo del activo: " + Ca );
					  System.out.println("Valor de Desecho/Residual: " + vsp);
					  System.out.println("Vida Util: " + Viu);
					  System.out.println("Vida util en unidades: " + suma);
					  System.out.println(" Depreciacion por unidad de produccion: " + DA);

						  valor=Ca;DPA=0;
						      System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
						  for(int i=0;i<Viu;i++) {
							  nw=datos[i]*DA;
							  valor=(valor-nw);
							  DPA=DPA+nw;
							  System.out.println("C$"+nw+"          | "+"C$"+DPA+"              | "+"C$"+valor);
						  }
				break;
			case 3:
				  double []datoss = new double[7];
				  int sum1=0;
				double VUA, DTD;
				VUA=1.0/Viu;
				DTD=VUA*2;
				valor=Ca;DPA=0;
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(" + Costo del activo: "+ Ca);
				 System.out.println("Valor de Desecho/Residual: " + vsp);
				  System.out.println("Vida Util: " + Viu);
				  System.out.println( " Tasa del doble saldo: " + DTD +"%" );
			    System.out.println("----------------------------------------------------------------------------------------------------------------------------");
			    for(int i=0;i<=Viu;i++) {
				     valor=valor-DPA;
				     DPA=valor*DTD;
				     datoss[i]=DPA;
				     sum1+= datoss[i];
				     
			    }
				
				break;
			case 4:
				double sum, Vu, IM, frac;
				 sum=0;
		for (int i=Viu;i>0;i--){
		    sum=sum+i;
		}
		if(vsp==0) {
			IM=(Ca);
		}else {
			IM=Ca-vsp;
		}
			frac=(Math.round((Viu/sum) * 10000) / 10000);
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.println(" Costo del activo: C$ " + Ca );
			 System.out.println(" Valor de Desecho/Residual: " + vsp);
			  System.out.println("Vida Util: " + Viu);
			  System.out.println("-----------------------------------------------------------------------------------------------------------");
			Vu=Viu;valor=Ca;DPA=0;
		for(int j=1;j<=Viu;j++) {
			frac=(Math.round((Vu/sum) * 10000) / 10000);
			Vu=Vu-1;
			DA=Math.round(IM*frac);
			DPA=DPA+DA;
			valor=valor-DA;
		}
				break;
			}
			System.out.println("" + nombre +"Desea ingresar mas opciones?(S/N)");
			System.out.println("1.Si 2.No");
			op2=lec.nextInt();
		}while(op2 < 2 && op2 > 1);
			System.out.println("Buen dia " + nombre + ":) ");
			lec.close();


		}
	}


