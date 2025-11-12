package Ejercicios_UT01;

public class Snippet {
	/*UT 02 – Estructuras de control –
	Ejercicios condicionales
	Ejercicio 02 – 01
	Escribir un programa que pida dos números e indique si el primero es mayor que el
	segundo o no.
	Ejercicio 02 – 02
	Algoritmo que pida un número y diga si es positivo, negativo o 0.
	Ejercicio 02 – 03
	Escribe un programa que lea un número e indique si es par o impar. El resto de la
	división entera de un número entre dos es cero si es par, y uno si es impar.
	Ejercicio 02 – 04
	Crea un programa que pida al usuario dos números y muestre la división del primero
	por el segundo sólo si el segundo no es cero. Si el segundo es cero, mostrará un
	mensaje de aviso indicando que no se puede hacer la operación.
	Ejercicio 02 – 05
	Escribe un programa que pida un nombre de usuario y una contraseña y si se ha
	introducido “pepe” y “asdasd” se indica “Has entrado al sistema”, si no, se mostrará
	un error.
	Ejercicio 02 – 06
	Programa que lea una cadena de texto por teclado y compruebe si es una letra
	mayúscula. Debe comprobar que es de longitud 1 (sólo una letra), y que esta es
	mayúscula.
	Ejercicio 02 – 07
	Crea un programa que pida dos números ‘nota’ y ‘edad’ y un carácter ‘sexo’ y
	muestre el mensaje ‘ACEPTADA’ si la nota es mayor o igual a cinco, la edad es
	mayor o igual a dieciocho y el sexo es ‘F’. En caso de que se cumpla lo mismo, pero
	el sexo sea ‘M’, debe imprimir ‘POSIBLE’. Si no se cumplen dichas condiciones se
	debe mostrar ‘NO ACEPTADA’.
	Ejercicio 02 – 08
	Escribe un programa que pida tres números y los muestre ordenados (de mayor a
	menor);
	Ejercicio 02 – 09
	Escribir un programa que lea un año e indicar si es bisiesto. Un año es bisiesto si es
	un número divisible por 4, pero no si es divisible por 100, excepto que también sea
	divisible por 400.
	Ejercicio 02 – 10
	Programa que pida los puntos centrales x1, y1, x2, y2 y los radios r1, r2 de dos
	circunferencias y las clasifique en uno de estos estados:
	● exteriores
	● tangentes exteriores
	● secantes
	● tangentes interiores
	● interiores
	● concéntricas
	Necesitarás calcular la distancia entre los dos centros. Lo hicimos en un ejercicio de
	la UT 03.
	Ayuda: http://mimosa.pntic.mec.es/clobo/geoweb/circun3.htm
	Ejercicio 02 – 11
	Escribe un programa que pida una fecha (día, mes y año, por separado) y diga si es
	correcta. Ten en cuenta que hay años bisiestos. En un problema anterior hicimos
	una comprobación de si un año es bisiesto o no.
	Ejercicio 02 – 12
	La asociación de vinicultores tiene como política fijar un precio inicial al kilo de uva,
	que se clasifica en tipos A y B, y además en tamaños 1 y 2. Cuando se realiza la
	venta del producto, esta es de un solo tipo y tamaño.
	Se requiere determinar cuánto recibirá de beneficios (o pérdidas) un productor por la
	uva que entrega en un embarque, considerando lo siguiente:
	● Si es de tipo A, se incrementa el precio por kilo:
	○ 20 céntimos al precio inicial cuando es de tamaño 1
	○ 30 céntimos si es de tamaño 2
	● Si es de tipo B, se rebaja el precio por kilo:
	○ 30 céntimos cuando es de tamaño 1.
	○ 50 céntimos cuando es de tamaño 2.
	Realice un algoritmo para determinar la ganancia o pérdida obtenida en un
	embarque.
	Ejercicio 02 – 13
	El director de una escuela está organizando un viaje de estudios, y requiere
	determinar cuánto debe cobrar a cada alumno y cuánto debe pagar a la compañía
	de viajes por el servicio. La forma de cobrar es la siguiente: si son 100 alumnos o
	más, el costo por cada alumno es de 65 euros; de 50 a 99 alumnos, el costo es de
	70 euros, de 30 a 49, de 95 euros, y si son menos de 30, el costo de la renta del
	autobús es de 4000 euros, sin importar el número de alumnos. Realice un algoritmo
	que permita determinar el pago a la compañía de autobuses y lo que debe pagar
	cada alumno por el viaje.
	Ejercicio 02 – 14
	La política de cobro de una compañía telefónica es: cuando se realiza una llamada,
	el cobro es por el tiempo que ésta dura, de tal forma que los primeros cinco minutos
	cuestan 1 euro cada minuto, los siguientes tres, 80 céntimos, los siguientes dos
	minutos, 70 céntimos, y a partir del décimo minuto, 50 céntimos. Además, se carga
	un impuesto de 3 % cuando es domingo, y si es otro día, en turno de mañana, 15 %,
	y en turno de tarde, 10 %. Realice un algoritmo para determinar cuánto debe pagar
	por cada concepto una persona que realiza una llamada.
	Ejercicio 02 – 15
	Realiza un programa que pida por teclado el resultado (dato entero) obtenido al
	lanzar un dado de seis caras y muestre por pantalla el número en letras (dato
	cadena) de la cara opuesta al resultado obtenido.
	● Nota 1: En las caras opuestas de un dado de seis caras están los números: 1-6, 2-5
	y 3-4.
	● Nota 2: Si el número del dado introducido es menor que 1 o mayor que 6, se
	mostrará el mensaje: “ERROR: número incorrecto.”.
	Ejercicio 02 – 16
	Realiza un programa que pida el día de la semana (del 1 al 7) y escriba el día
	correspondiente en letras. Si introducimos otro número nos mostrará un mensaje
	indicando que el número no es válido.
	Ejercicio 02 – 17
	Escribe un programa que pida un número entero entre uno y doce (un mes)
	Mostrará:
	● Si el mes no es un número entre 1 y 12 a.i., mostrará un error.
	● El número de días del mes
	Ejercicio 02 – 18
	Amplía el programa del ejercicio anterior para que pida también el año y
	● Si el año es menor que cero, o el mes no es un número entre 1 y 12 a.i., mostrará un
	error.
	● El número de días del mes. Teniendo en cuenta que el año puede ser bisiesto.
	Ejercicio 02 – 19
	Una compañía de transporte internacional tiene servicio en algunos países de
	América del Norte, América Central, América del Sur, Europa y Asia. El costo por el
	servicio de transporte se basa en el peso del paquete y la zona a la que va dirigido.
	Lo anterior se muestra en la tabla:
	Zona Ubicación Costo/gramo
	1 América del Norte 24.00 euros
	2 América Central 20.00 euros
	3 América del Sur 21.00 euros
	4 Europa 10.00 euros
	5 Asia 18.00 euros
	Parte de su política implica que los paquetes con un peso superior a 5 kg no son
	transportados, por cuestiones de logística y de seguridad. Realice un algoritmo para
	determinar el cobro por la entrega de un paquete o, en su caso, el rechazo de la
	entrega.
	Ejercicio 02 – 20
	Escribe un programa en Java que simule una calculadora de operaciones básicas.
	El programa debe solicitar al usuario que introduzca dos números y luego le dará la
	opción de realizar una de las siguientes operaciones: suma, resta, multiplicación o
	división.
	El usuario debe seleccionar la operación deseada introduciendo un número del 1 al
	4. Luego, el programa debe realizar la operación seleccionada y mostrar el
	resultado.
	Si la operación es ilegal (división por cero), debe mostrar un mensaje indicando que
	no se puede realizar.*/
}

