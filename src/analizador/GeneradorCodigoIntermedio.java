package analizador;
import static analizador.lexicoConstants.*;
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
public class GeneradorCodigoIntermedio {
    private StringBuilder declaraciones;
    private StringBuilder instrucciones;
    private StringBuilder funciones;
    
    public GeneradorCodigoIntermedio(){
        declaraciones = new StringBuilder();
        instrucciones = new StringBuilder();
        funciones = new StringBuilder();
    }    
    public void declaracion(String identificador, int tipoDato, String expresion){
        StringBuilder sb = new StringBuilder();
        sb.append(identificador).append(' ');
        switch(tipoDato){
            case INT:
                sb.append("dd "); //4 bytes
                break;
            case FLOAT:
                sb.append("dq "); //8 bytes
                break;
            case STR:
               // sb
                break;
            case BOOLEAN:
                break;
            case CHAR:
                break;                     
                   
        }
    }
    public void asignacion(String identificador, String expresion){
        
    }           
}
