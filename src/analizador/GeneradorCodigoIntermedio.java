
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
s.push(a+d.pop()-e.get(i)-z[x[y]*w[j]])
push(s,a+pop(d)-get(e,i)-z[x[y]*w[j]]);
<IDENTIFICADOR_STACK><.><PUSH><(>operacion()<)> pop(x)+pop(x)
"push(IDENTIFICADOR_STACK, );

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
    public void resetCode(){
        declaraciones.setLength(0);
        instrucciones.setLength(0);
        funciones.setLength(0);
    }
    
    /* Método que genera todo el código y lo guarda en un archivo llamado: tmp.asm */
    public void generateCode(){
        System.out.println(declaraciones.toString());
        System.out.println(instrucciones.toString());
    }
    
    public void print(String contenido, int tipo){
        int id = identificarToken(contenido);
        if(id==IDENTIFICADOR){
            if(tipo == INT){
                
            }else{ //FLOAT
                
            }
        }else{
            if(tipo == INT){
                
            }else{ //FLOAT
                
            }
        }
    }
    public void println(){
        //sb.append()
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
        }
        sb.append('\n');
        declaraciones.append(sb);
        if(expresion!=null && expresion.length()>0) asignacion(identificador, tipoDato, expresion);
    }
    public void asignacion(String identificador, int tipoDato, String expresion){
        expresion(expresion);
        instrucciones.append("mov [").append(identificador).append("], eax\n");
    }    
    public final static int[] prioridad = {1,1,2,2};
    public final static String operador = "+-*/";
    public final static int ARREGLO = 47;
    public final static int OPERADOR = 48; //Cuidar que no sea uno de lexicoConstants
    
    /* Retorna un int con el tipo de token que está en value*/
    private int identificarToken(String value){        
        if(value.equals("(")) return PARENTA;
        if(value.equals(")")) return PARENTC;
        boolean decimal = value.matches("\\d*\\.\\d*");
        if(decimal) return DECIMAL;
        boolean entero = value.matches("\\d+");
        if(entero) return NUMERO;
        String regexVar = "[a-zA-Z]([a-z]|[A-Z]|[0-9]|[_])*";
        boolean variable = value.matches(regexVar);
        if(variable) return IDENTIFICADOR;
        return OPERADOR;
    }
    
    //Método que va a dejarme el resultado en el registro EAX
    
    public void expresion(String expresion){
        ArrayList<TokenExpresion> conv = convertirExpresion(expresion);
        for (int i = 0; i < conv.size(); i++) {
            TokenExpresion tmp = conv.get(i);
            switch(tmp.getType()){
                case OPERADOR:
                    int operacion = operador.indexOf(tmp.getValue());
                    instrucciones.append("pop ebx\n");
                    instrucciones.append("pop eax\n");  
                    switch(operacion){
                        case 0: //Suma
                            instrucciones.append("add eax ebx\n");
                            break;
                        case 1: //Resta                                              
                            instrucciones.append("sub eax ebx\n");
                            break;
                        case 2: //Multiplicación
                            instrucciones.append("mul ebx\n");
                            break;
                        case 3: //División
                            instrucciones.append("div ebx\n");
                            break;
                    }
                    instrucciones.append("push eax\n");
                    break;
                case NUMERO:
                case DECIMAL:
                    instrucciones.append("push ").append(tmp.getValue()).append('\n');
                    break;
                case IDENTIFICADOR:
                    instrucciones.append("push [").append(tmp.getValue()).append("]\n");
                    break;
            }
        }
        instrucciones.append("pop eax\n");
    }
    /*
        
        Stack<int> s(100);
        struct ListInt{
        };
        struct StackInt{
            int* datos;
            int tope;
            int capacidad;
        };
        struct StackChar{
            char* datos;
            int tope;
            int capacidad;
        }
        int a(){}
        int main(){
            int b(){}
        }
        StackInt s;
        s->datos = (int*)malloc(100*sizeof(int));
        s->capacidad = 100;
        s->tope = -1;
        int popInt(int s*){
        }
        char popChar(char s*){
        }
        float popFloat(float s*){
        }
        Stack<int> s(100);
        Lista<int> l;
    */
    ArrayList<TokenExpresion> convertirExpresion(String expresion){
        //Shunting-yard algorithm
        
        String s[] = expresion.split(" ");
        Stack<String> operadores = new Stack<>();
        ArrayList<TokenExpresion> RPN = new ArrayList<>();
        for(int i=0;i<s.length;i++){
            int id = identificarToken(s[i]); 
            if(id==OPERADOR){                  
                int ind = prioridad[operador.indexOf(s[i])];                
                while(!operadores.empty()){
                    String tmp = operadores.peek();
                    int idTmp = identificarToken(tmp);
                    if(idTmp==OPERADOR){
                        int ind2 = prioridad[operador.indexOf(tmp)];
                        if(ind<=ind2){
                            RPN.add(new TokenExpresion(tmp,OPERADOR));
                            operadores.pop();
                        }else{
                            break;
                        }
                    }else break;
                }
                operadores.push(s[i]);                
            }else if(id==NUMERO || id == DECIMAL || id == IDENTIFICADOR){
                RPN.add(new TokenExpresion(s[i],id));
            }else if(id==PARENTA){
                operadores.push(s[i]);
            }else if(id==PARENTC){
                while(!operadores.empty()){
                    String tmp = operadores.pop();
                    int idTmp = identificarToken(tmp);
                    if(idTmp==PARENTA) break;
                    else{
                        RPN.add(new TokenExpresion(tmp, idTmp));
                    }
                }
            }
        }
        while(!operadores.empty()){
            String tok = operadores.pop();
            int id = identificarToken(tok);
            RPN.add(new TokenExpresion(tok, id));
        }
        return RPN;
    }
    class TokenExpresion{
        private final String value;
        private final int type;

        public TokenExpresion(String value, int type) {
            this.value = value;
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public int getType() {
            return type;
        }
    }
}
