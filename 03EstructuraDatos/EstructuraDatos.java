/*
Vamos a crear 14 programas dentro de un menu gigante para poner a prueba sus conocimientos de algoritmia 
1.- Desarrollar un programa para calcular el bono de un descuento por edad
2.- Convertir numeros decimales a binarios
3.- Convertir temperaturas entre los 3 principales grados C -> F y K
4.- Realizar un programa para contar numeros positivos y negativos de una serie de numeros 
5.-Desarrollar una tienda para agregar productos y precios
6.-Desarrollar un programa para calcular el area y perimetro de 5 diferentes figuras
*/

import java.util.Scanner;
public class EstructuraDatos {
    public static void main(String[] args) {
        //aqui van las variables
Scanner sc = new Scanner(System.in);
int opcion = 0;
int edad = 0;
char socios;
double paguito = 0;
double resultadobono = 0;
char letrarepetir;
float compra = 0;
double temperatura = 0;
double conversion = 0;
int[] num = new int [10];
int post = 0;
int neg = 0;
double radio = 0;
double acirculo = 0;
double lcuadrado = 0;
double acuadrado = 0;
double bcilindro = 0;
double acilindro = 0;
double baclindro = 0;
float lrectangulo = 0;
float brectangulo = 0;
float arectangulo = 0;
float btriangulo = 0;
float altriangulo = 0;
float atriangulo = 0;
        //aqui va el menu
        do{

            System.out.println("Bienvenido a este programa para verificar que tanto saben programar a partir de algoritmos basicos");
            System.out.println("Por favor elija la opcion deseada");
            System.out.println("1.- Bono de descuento");
            System.out.println("2.- Decimales a binarios");
            System.out.println("3.- Conversion Temperaturas");
            System.out.println("4.- Numeros positivos y negativos");
            System.out.println("5.- Tienda");
            System.out.println("6.- Area y Perimetro");
            System.out.println("14.- Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
System.out.println("Ingrese su edad: ");
edad = sc.nextInt();

if (edad > 65){
    System.out.println("Tiene un bono del 40%");
    resultadobono = paguito * 0.40;
}else if (edad < 21){
    System.out.println("Sus padres son socios s/n");
socios = sc.next().charAt(0);
if(socios == 's' ){
    System.out.println("Tiene un bono del 40%");
    resultadobono = paguito * 0.40;
}
}else {
    System.out.println("No tiene bono");
}
System.out.println("El pago final con el bono es: " + resultadobono);
                    break;

                case 2:
                    System.out.println("Ingrese un numero positivo entero que se desee convertir a binario");
                int numbinario;
                String guardarbinario ="";
                numbinario = sc.nextInt();

                if(numbinario > 0){
                // realizar mod 2
                while( numbinario > 0){
                if(numbinario%2 == 0){
                    guardarbinario = "0" + guardarbinario;
                }
                else {
                    guardarbinario = "1" + guardarbinario;
                }
                numbinario = (int)numbinario/2;
                }
                }else if(numbinario == 0){
                guardarbinario = "0";
                }else{
                guardarbinario = "No se puede convertir ese numero, solo acepta positivos";
                }
                System.out.println("El numero convertido a binario es: " + guardarbinario);
                    break;

                    case 3:
                        System.out.println("Ingrese la temperatura");
                        temperatura = sc.nextFloat();
                        System.out.println("Ingrese la escala de temperatura c,f,k");
                        char escala = sc.next().charAt(0);
                        System.out.println("Ingrese a que escala quiere convertir c,f,k");
                        char escalaconvertir = sc.next().charAt(0);
                        if (escala == 'c'&& escalaconvertir == 'f'){
                            conversion = (temperatura * 9/5) + 32;
                            System.out.println("Temperatura convertida es: " + conversion + " F");
                        }else if (escala == 'c' && escalaconvertir == 'k'){
                            conversion = temperatura + 273.15;
                            System.out.println("temperatura en Kelvin es:" + conversion + " K");
                        }else if (escala == 'f' && escalaconvertir == 'c'){
                            conversion = (temperatura - 32) * 5/9;
                            System.out.println("temperatura convertida es: " + conversion + " c");
                        }else if (conversion == 'f' && escalaconvertir == 'k'){
                            conversion = (temperatura - 32) * 5/9 + 273.15;
                            System.out.println("Temperatura convertida es: " + conversion + " k");
                        }else if (escala == 'k' && escalaconvertir == 'c'){
                        conversion = temperatura - 273.15;
                        System.out.println("Temperatura convertida es : " + conversion + " c");
                        }else if (escala == 'k' && escalaconvertir == 'f'){
                        conversion = (temperatura - 273.15) * 9/5 + 32;
                        System.out.println("Temperatura convertida es: " + conversion + " f");
                        }else {
                            System.out.println("Ingresar una escala valida");
                        }
                    break;
                    case 4:
                    for(int i = 0; i < num.length; i++){
                        System.out.println("Ingresa un numero, presiona 0 para terminar");
                        num[i] = sc.nextInt();
                        if (num [i] == 0){
                            break;
                        }else if (num[i] > 0) {
                            post++;
                        }else {
                            neg++;
                        }
                    }
                    System.out.println("Numero de positivos: " + post);
                    System.out.println("Numero de negativos: " + neg);
                    break;
                    case 5:
                    
System.out.println("Bienvenido a esta linda hermosa y kawaii");
                System.out.println("Por favor ingrese cuantos elementos va a comprar");
                int elementosproducto = 0;
                elementosproducto = sc.nextInt();
                if (elementosproducto > 0 ){
                    for(int i = 1; i <= elementosproducto;i++ ){
                        System.out.println("Ingresa el nombre del producto");
                        String nombreproducto = "";
                        nombreproducto = sc.next();
                        System.out.println("Ingrese el precio");
                        float precio = 0;
                        precio = sc.nextFloat();
                        System.out.println("Ingrese la cantidad");
                        int cantidad = 0;
                        cantidad = sc.nextInt();
                        float resultado = 0;
                        resultado = precio * cantidad;
                        compra = resultado + compra;
                    }
                    System.out.println("El total de la compra es: " + compra);
                }else{
                    System.out.println("Ingrese solo positivos");
                }
                break;

                    case 6:
                    System.out.println("Ingresa la figura deseada 1. Circulo, 2. Cuadrado, 3. Rectangulo, 4. Triangulo 5. Cilindro");
                    int figura = sc.nextInt();
                    switch (figura) {
                        case 1:
                            System.out.println("Ingrese el radio del circulo");
                            radio = sc.nextFloat();
                            acirculo = Math.PI * Math.pow(radio, 2);
                            System.out.println("El area del circulo es: " + acirculo);
                            break;
                            case 2:
                                System.out.println("Ingresa el lado del cuadrado");
                                lcuadrado = sc.nextFloat();
                                acuadrado = Math.pow(lcuadrado, 2);
                                System.out.println("El area es: " + acuadrado);
                    
                    break;

                    case 3:
                        System.out.println("Ingresa base del rectangulo");
                        brectangulo = sc.nextFloat();
                        System.out.println("Ingresa el lado del rectangulo");
                        lrectangulo = sc.nextFloat();
                        arectangulo = brectangulo + lrectangulo;
                        System.out.println("el area del rectangulo es:" + arectangulo);
                        break;
                        case 4:
System.out.println("Ingresa la bsae del triangulo");
btriangulo = sc.nextFloat();
System.out.println("Ingresa la altura del triangulo");
altriangulo = sc.nextFloat();
atriangulo = (btriangulo * altriangulo) / 2;
System.out.println("Area del triangulo:" + atriangulo);
                            break;
                            
                            case 5:
System.out.println("Ingresa la primer base del cilindro");
bcilindro = sc.nextFloat();
System.out.println("Ingresa la segunda base del cilindro");
baclindro = sc.nextFloat();
acilindro = 2 * Math.PI * (bcilindro * baclindro);
System.out.println("El area del cilindro es: " + acilindro);
                                break;
}
                    default:System.out.println("Ingresa una opcion valida");
                    break;
            }System.out.println("Desea repetir el programa presione s");
            letrarepetir = sc.next().charAt(0);
}while(letrarepetir == 's');
}
}
