
import java.util.Scanner;

public class Figuras {
    Scanner entrada = new Scanner(System.in);
    //apartado de variables 
    //menucito
    int menu;
    //variables del circulo
    double radioCirculo = 0;
    double diametroCirculo = 0;
    double AreaCirculo = 0;
    double PerimetroCirculo = 0;
    //variables del cuadrado
    double LadoCuadrado = 0;
    double AreaCuadrado = 0;
    double PerimetroCuadrado = 0;
    //variables del triangulo
    double BaseTriangulo = 0;
    double AlturaTriangulo = 0;
    double AreaTriangulo = 0;
    double PerimetroTriangulo = 0;
    // variables del Cubo
    double LadoCubo = 0;
    double AreaCubo = 0;
    double PerimetroCubo = 0;
    //Variables del rectangulo
    double BaseRectangulo = 0;
    double AlturaRectangulo = 0;
    double AreaRectangulo = 0;
    double PerimetroRectangulo = 0;

    public void calculadora(){
        //aqui va menú
        do{
            System.out.println("Ingressa el numero de la figura que deseas calcular");
            System.out.println("1.- Circulo");
            System.out.println("2.- Cuadrado");
            System.out.println("3.- Triangulo");
            System.out.println("4.- Cubo");
            System.out.println("5.- Rectangulo");
            System.out.println("6.- Salir");
            menu = entrada.nextInt();
            try {
                
            if(menu < 1 || menu > 6) {
                throw new Exception("Su opción no es valida, ingrese de nuevo su opción");
            }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            switch (menu){
                case 1:
                    
                System.out.println("Introduce el radio del circulo");
                radioCirculo = entrada.nextDouble();
                diametroCirculo = radioCirculo*2;
                AreaCirculo = Math.PI * Math.pow(radioCirculo,2);
                PerimetroCirculo = Math.PI * diametroCirculo;
                System.out.println("El area del circulo calculado: " + AreaCirculo);
                System.out.println("El perimetro del circulo calculado es: " + PerimetroCirculo);




                    break;

                case 2: 
                System.out.println("Introduce el lado del cuadrado");
                LadoCuadrado = entrada.nextDouble();
                AreaCuadrado = Math.pow(LadoCuadrado, 2);
                PerimetroCuadrado = 4 * LadoCuadrado;
                System.out.println("El area del cuadrado es: " + AreaCuadrado);
                System.out.println("El perimetro del cuadrado es: " + PerimetroCuadrado);
                break;

                case 3:

                    System.out.println("Introduce la base del triangulo");
                    BaseTriangulo = entrada.nextDouble();

                    System.out.println("Introduce la altura del triangulo");
                    AlturaTriangulo = entrada.nextDouble();

                    AreaTriangulo = (BaseTriangulo * AlturaTriangulo) / 2;

                    PerimetroTriangulo = 6 * BaseTriangulo;

                    System.out.println("El perimetro del triangulo es: " + PerimetroTriangulo);
                    break;

                    case 4: 

                    System.out.println("Introduce el lado del cubo");
                    LadoCubo = entrada.nextDouble();
                    AreaCubo = 6 * Math.pow(LadoCubo, 2);
                    PerimetroCubo = 12 * LadoCubo;
                    System.out.println("El area del cubo es: " + AreaCubo);
                    System.out.println("El perimetro del cubo es: " + PerimetroCubo);
                    break;

                    case 5:
                     System.out.println("Introduce la base del rectangulo");

                    BaseRectangulo = entrada.nextDouble();
                    System.out.println("Introduce la altura del rectangulo");
                    AlturaRectangulo = entrada.nextDouble();
                    AreaRectangulo = BaseRectangulo * AlturaRectangulo;
                    PerimetroRectangulo = 2 * (BaseRectangulo * AlturaRectangulo);
                    System.out.println("El area del rectangulo es: " + AreaRectangulo);
                    System.out.println("El perimetro del rectangulo es: " + PerimetroRectangulo);
                    break;

                    case 6: 
                    System.out.println("JEJEJE gracias por usar este programita pro jejejeje");
                    break;
            }
        }while(menu  !=6 );
    }
}

