import java.util.Scanner;

public class examen {
    public static void main(String[] args){
        
        //aqui van las variables
Scanner sc = new Scanner(System.in);
int opcion = 0;
char letrarepetir = 'n';

//Constantes de precios y el porcentaje 
double precio_porcelanato = 22.35;
double precio_marmoleado = 34.27;
double precio_acrilico = 22.94;
double iva = 0.16;
double descuento = 0.0795; //7.95%

//datos del cliente (comprador)
String nombre = "";
String apellidopat = "";
String apellidomat = "";
String fechadenacimiento = "";
String direccion = "";
//variables para cuartos
int numcuartos = 0;
double totalsiniva = 0;
double montoiva = 0;
double totalconiva = 0;
//menucito pro

do{
System.out.println("Sistema de cotizacion de piso kawaii");
System.out.println("Elija la opcion deseada");
System.out.println("1.- Registrar datos del cliente");
System.out.println("2.- Catalogo de pisos");
System.out.println("3.- Calcular costo de instalacion");
System.out.println("0.- Salir");

opcion = sc.nextInt();

switch (opcion) {

    case 1:
        System.out.println("Ingrese su nombre: ");
        nombre = sc.next();

        System.out.println("Ingrese su apellido paterno: ");
        apellidopat = sc.next();

        System.out.println("Ingrese su apellido materno: ");
        apellidomat = sc.next();

        sc.nextLine();
        System.out.println("Ingresa tu fecha de nacimiento (dd/mm/aaaa): ");
        fechadenacimiento = sc.nextLine();

        System.out.println("Ingrese su direccion: ");
        direccion = sc.nextLine();

        System.out.println("Los datos fueron guardados de forma correcta jeje");
        break;

        case 2:
            System.out.println("Tipos de piso disponibles");
            System.out.println("(PRECIOS POR METRO CUADRADO)");
            System.out.println("");
            System.out.println("1.- Porcelanato sin iva: " + precio_porcelanato + " con iva: " + (precio_porcelanato * (1 + iva)));
            System.out.println("2.- Marmoleado sin iva: " + precio_marmoleado + " con iva: " + (precio_marmoleado * (1 + iva)));
                        System.out.println("1.- Porcelanato sin iva: " + precio_acrilico + " con iva: " + (precio_acrilico * (1 + iva)));
            System.out.println("");
            break;

            case 3:

            if (nombre.isEmpty()){
                System.out.println("Primero registra tus datos en la opcion 1");
                break;
            }

System.out.println("Cuantos cuartos tiene el inmueble(el minimo 2, maximo 4): ");
numcuartos = sc.nextInt();

if (numcuartos  < 2 || numcuartos > 4){
    System.out.println("Numero de cuartos entre 2 y 4");
    break;
}

double[] largos = new double[numcuartos];
double[] anchos = new double [numcuartos];
int[] tipos = new int[numcuartos];

for (int i = 0; i  < numcuartos; i++){
    System.out.println("Datos del cuarto numero " +  (i + 1) + ":");

    do { 
        System.out.println("Ingresa el largo en metros");
        largos[i] = sc.nextDouble(); sc.nextLine();
        if (largos[i]  <= 0){
            System.out.println("Largo mayor a 0");
        }
    } while (largos[i]  <= 0);

do { 
    System.out.println("Ingrese el ancho en metros: ");
    anchos[i] = sc.nextDouble();
    if (anchos[i] <= 0 ){
        System.out.println("Ancho mayor a 0");
    }
}while (anchos[i] <= 0);
    System.out.println("Tipo de piso que desea");
    System.out.println("1.- Porcelanato $" + precio_porcelanato + " por metro cuadrado");
    System.out.println("2.- Marmoleado $" + precio_marmoleado + " por metro cuadrado");
    System.out.println("3.- Acrilico $" + precio_acrilico + " por metro cuadrado");
do { 
    tipos[i] =sc.nextInt(); sc.nextLine();
    if (tipos[i] < 1 || tipos[i] > 3){
        System.out.println("Solo se pueden las opciones 1, 2, 3");
    }
    
} while (tipos [i]  < 1|| tipos[i] > 3);
}
System.out.println("Resumen de tu cotizacion");
System.out.println("Cliente : " + nombre + " " + apellidopat + " " + apellidomat);
System.out.println("Nacimiento : " + fechadenacimiento);
System.out.println("Direccion : " + direccion);
System.out.println("");


totalsiniva = 0;
for (int i = 0; i < numcuartos; i++ ){
    double area = largos[i] * anchos[i];
    double precio = 0;
    String nombretipo = "";
    switch (tipos[i]) {
        case 1:
            precio = precio_porcelanato;
            nombretipo = "Porcelanato";
            break;

            case 2: 
            precio = precio_marmoleado;
            nombretipo = "Marmoleado";
            break;

            case 3:
                precio = precio_acrilico;
                nombretipo = "Acrilico";
                break;
    }

double subtotal = area * precio;

double coniva = subtotal * (1 + iva);

System.out.printf( "Cuarto " + (i + 1) + " - " + nombretipo);
System.out.println("Area : " + area + "m2");
System.out.println("Precio por m2: " + precio);
System.out.println("subtotal sin iva: " + subtotal);
System.out.println("total con iva: " + coniva);
totalsiniva = totalsiniva + subtotal;
}

montoiva = totalsiniva * iva;
totalconiva = totalsiniva + montoiva;

System.out.println("subtotal sin iva: " + totalsiniva);
System.out.println("iva: " + montoiva);
System.out.println("total a pagar: " + totalconiva);

System.out.println("Desea finalizar con la compra s/n");
char confirmar = sc.next().charAt(0);

if(confirmar == 's'){
    double montodescuento = totalconiva * descuento;
    double totalfinal = totalconiva - montodescuento;

    System.out.println("Compra confirmada aplicando descuento del 7.95%");
    System.out.println("Total antes del descuento: " + totalconiva);
    System.out.println("Descuento: " + montodescuento);
    System.out.println("Total final: " + totalfinal);
}else {
    System.out.println("Compra no confrimada");
}
break;
case 0: 
System.out.println("Bai bai ");
break;
default:
    System.out.println("Ingrese una opcion ");
break;

}
System.out.println("Desea repetir el programa presione 's' ");
letrarepetir = sc.next().charAt(0);
}while (letrarepetir == 's');
    }
}