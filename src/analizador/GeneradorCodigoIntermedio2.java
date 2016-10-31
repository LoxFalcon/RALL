
package analizador;
import static analizador.lexicoConstants.*;
import java.util.ArrayList;
import java.util.Stack;
/*
String declarcion;
string cuerpo;
string funciones;
String res = Generador.buildCode();
.asm
System.executeCmd("nasm -f tmp.asm -o tmp.exe");


.MODEL 386
.STACK 300h
.DATA
	+declaracion
.CODE
	funciones

	cuerpo
	mov ah, 4Ch
	int 21h



void declaracion(string id, int tipoDato, string valor, int linea){
	String declaraciones += new String(id + " " + "dd" + " " + "0");
	asignacion(id,valor,linea);	
}

switch(tipoDato){
	case LexicoConstants.INTEGER:
		break;
	case LexicoConstants.FLOAT:
}
32 = int
33 = float

void asignacion(string id, string valor, int linea){
	expresion(valor); <-- resultado en AX
	mov [id], ax

}
if(a+20/10 < b*2 && 2*10/5-20 != 1 || afsdk<fkdsaj && ){
	<
	expresion(b*2);
	"mov cx, ax";
	expresion(a+20/10);
	cmp ax,cx
	jge falso
	
	a+20/10
	b*2
}else{
	if (
}

void expresion(string expresion){
	Stack<> vlores;
	Stack<> operador;
	
	mov ax, 5;
	mul 10
	mov dx, ax
	
	mov dx, ax
	add ax, 20
	mov dx, ax

	mov ax, dx					
}

int a = 5*10+20; //No necesita otra variable
a = 3;
a = 10*a;
int b = a*2;


<FUNCION> <TIPO_DATO> <NOMBRE_FUNCION> <PARA> (<tipo_dato> <id>)* <PARB> <LLAVEA>
	<CUERPO>
	[<RETURN> <OPERACION> <PCOMA>]
<LLAVEB>

a[i] <-

cmp ax, bx
*/
public class GeneradorCodigoIntermedio2 {
    private StringBuilder declaraciones;
    private StringBuilder instrucciones;
    private StringBuilder funciones;
    
    public GeneradorCodigoIntermedio2(){
        declaraciones = new StringBuilder();
        instrucciones = new StringBuilder();
        funciones = new StringBuilder();
    }    
    public void declaracion(String identificador, int tipoDato, String expresion){
        StringBuilder sb = new StringBuilder();
        sb.append(identificador).append(' ');
        switch(tipoDato){
            case INT:
                sb.append("dd 0"); //4 bytes
                break;
            case FLOAT:
                sb.append("dq 0"); //8 bytes
                break;
            case STR:
                sb.append("resb 255");
                break;
            case BOOLEAN:
            case CHAR:
                sb.append("db 0");
                break;                  
        }
        sb.append('\n');
        declaraciones.append(sb);
        if(expresion!=null && expresion.length()>0) asignacion(identificador, tipoDato, expresion);
    }
    public void asignacion(String identificador, int tipoDato, String expresion){
        expresion(expresion);
        instrucciones.append("mov [").append(identificador).append("], eax\n");
    }    
    public static int[] prioridad = {1,1,2,2};
    public static String operador = "+-*/";
    public static int ARREGLO = 47;
    public static int OPERADOR = 48; //Cuidar que no sea uno de lexicoConstants
    
    /* Retorna un int con el tipo de token que está en value*/
    private int identificarToken(String value){
        System.out.println("me trabé");
        boolean decimal = value.matches("\\d*\\.\\d*");
        if(decimal) return DECIMAL;
        boolean entero = value.matches("\\d+");
        if(entero) return NUMERO;
        String regexVar = "[a-zA-Z]([a-z]|[A-Z]|[0-9]|[_])*";
        boolean variable = value.matches(regexVar);
        if(variable) return IDENTIFICADOR;
        boolean arreglo = value.matches(regexVar+"\\[.\\]");
        if(arreglo) return ARREGLO;
        System.out.println("me trabé2");
        return OPERADOR;
    }
    public void expresion(String expresion){
        //Shunting-yard algorithm
        String s[] = expresion.split(" ");
        Stack<String> operadores = new Stack<>();
        StringBuilder RPN = new StringBuilder();
        for(int i=0;i<s.length;i++){
            System.out.println("Analizando: \""+s[i]+"\"");
            int id = identificarToken(s[i]);
            System.out.println("ID: "+id);
            if(id==OPERADOR){
                int ind = prioridad[operador.indexOf(s[i])];                
                while(!operadores.empty()){
                    String tmp = operadores.peek();
                    int ind2 = prioridad[operador.indexOf(tmp)];
                    if(ind<=ind2){
                        if(RPN.length()>0) RPN.append(' ');
                        RPN.append(tmp);
                        operadores.pop();
                    }else{
                        break;
                    }
                }
                operadores.push(s[i]);                
            }else{
                if(RPN.length()>0) RPN.append(' ');
                RPN.append(s[i]);
            }
        }
        while(!operadores.empty()){
            RPN.append(' ').append(operadores.pop());
        }
        System.out.println("RPN: "+RPN.toString());
    }
}
