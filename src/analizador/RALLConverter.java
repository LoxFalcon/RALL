/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

/**
 *
 * @author Arturo
 */
public class RALLConverter implements lexicoConstants {

    public static final String Null = "$";
    public static final String Void = "%";
    private final char newLine = '\n';
    private final char close = ';';
    private final StringBuilder symbols;
    private final StringBuilder functions;
    private final StringBuilder main;
    private final StringBuilder include;
    public static final int FUNCTIONS = 1;
    public static final int SYMBOLS = 2;
    public static final int MAINBLOCK = 3;
    private int currentContext = 0;
    private String result;

    public RALLConverter() {
        include = new StringBuilder();
        include.append("#include <stdio.h>\n");
        include.append("#include <stdlib.h>\n");
        symbols = new StringBuilder();
        symbols.append("/*BLOQUE DE VARIABLES Y CONSTANTES*/\n");
        functions = new StringBuilder();
        functions.append("/*BLOQUE DE FUNCIONES*/\n");
        main = new StringBuilder();
        main.append("/*BLOQUE PRINCIPAL*/\n");
        insertHeader();
        openMain();
    }

    private void insertHeader() {
        symbols.append("struct _stackInt{\n");
        symbols.append("	int* data;\n");
        symbols.append("	int tope;\n");
        symbols.append("	int capacidad;\n");
        symbols.append("};\n");
        symbols.append("\n");
        symbols.append("struct _stackFloat{\n");
        symbols.append("	float* data;\n");
        symbols.append("	int tope;\n");
        symbols.append("	int capacidad;\n");
        symbols.append("};\n");
        symbols.append("\n");
        symbols.append("struct _stackChar{\n");
        symbols.append("	char* data;\n");
        symbols.append("	int tope;\n");
        symbols.append("	int capacidad;\n");
        symbols.append("};\n");
        symbols.append("\n");
        symbols.append("struct _queueInt{\n");
        symbols.append("	int* data;\n");
        symbols.append("	int frente;\n");
        symbols.append("	int fin;\n");
        symbols.append("	int capacidad;\n");
        symbols.append("};\n");
        symbols.append("\n");
        symbols.append("struct _queueFloat{\n");
        symbols.append("	float* data;\n");
        symbols.append("	int frente;\n");
        symbols.append("	int fin;\n");
        symbols.append("	int capacidad;\n");
        symbols.append("};\n");
        symbols.append("\n");
        symbols.append("struct _queueChar{\n");
        symbols.append("	char* data;\n");
        symbols.append("	int frente;\n");
        symbols.append("	int fin;\n");
        symbols.append("	int capacidad;\n");
        symbols.append("};\n");
        functions.append("int _popInt(struct _stackInt *s){\n");
        functions.append("	if(s->tope == -1){\n");
        functions.append("		printf(\"ERROR Stack vacío\\n\");\n");
        functions.append("		exit(EXIT_FAILURE);\n");
        functions.append("	}\n");
        functions.append("	return s->data[s->tope--];\n");
        functions.append("}\n");
        functions.append("\n");
        functions.append("float _popFloat(struct _stackFloat *s){\n");
        functions.append("	if(s->tope == -1){\n");
        functions.append("		printf(\"ERROR Stack vacío\\n\");\n");
        functions.append("		exit(EXIT_FAILURE);\n");
        functions.append("	}\n");
        functions.append("	return s->data[s->tope--];\n");
        functions.append("}\n");
        functions.append("\n");
        functions.append("char _popChar(struct _stackChar *s){\n");
        functions.append("	if(s->tope == -1){\n");
        functions.append("		printf(\"ERROR Stack vacío\\n\");\n");
        functions.append("		exit(EXIT_FAILURE);\n");
        functions.append("	}\n");
        functions.append("	return s->data[s->tope--];\n");
        functions.append("}\n");
        functions.append("\n");
        functions.append("int _frontInt(struct _queueInt *q){\n");
        functions.append("	if(q->frente==-1 || q->fin==-1){\n");
        functions.append("		printf(\"ERROR Cola vacía\\n\");\n");
        functions.append("		exit(EXIT_FAILURE);\n");
        functions.append("	}\n");
        functions.append("	int retVal = q->data[q->frente];\n");
        functions.append("	if(q->frente == q->fin){ //Se vacía la cola\n");
        functions.append("		q->frente = -1;\n");
        functions.append("		q->fin = -1; 		\n");
        functions.append("	}else{\n");
        functions.append("		q->frente = (q->frente + 1) % q->capacidad;\n");
        functions.append("	} \n");
        functions.append("	return retVal;\n");
        functions.append("}\n");
        functions.append("\n");
        functions.append("float _frontFloat(struct _queueFloat *q){\n");
        functions.append("	if(q->frente==-1 || q->fin==-1){\n");
        functions.append("		printf(\"ERROR Cola vacía\\n\");\n");
        functions.append("		exit(EXIT_FAILURE);\n");
        functions.append("	}\n");
        functions.append("	float retVal = q->data[q->frente];\n");
        functions.append("	if(q->frente == q->fin){ //Se vacía la cola\n");
        functions.append("		q->frente = -1;\n");
        functions.append("		q->fin = -1; 		\n");
        functions.append("	}else{\n");
        functions.append("		q->frente = (q->frente + 1) % q->capacidad;\n");
        functions.append("	} \n");
        functions.append("	return retVal;\n");
        functions.append("}\n");
        functions.append("\n");
        functions.append("char _frontChar(struct _queueChar *q){\n");
        functions.append("	if(q->frente==-1 || q->fin==-1){\n");
        functions.append("		printf(\"ERROR Cola vacía\\n\");\n");
        functions.append("		exit(EXIT_FAILURE);\n");
        functions.append("	}\n");
        functions.append("	char retVal = q->data[q->frente];\n");
        functions.append("	if(q->frente == q->fin){ //Se vacía la cola\n");
        functions.append("		q->frente = -1;\n");
        functions.append("		q->fin = -1; 		\n");
        functions.append("	}else{\n");
        functions.append("		q->frente = (q->frente + 1) % q->capacidad;\n");
        functions.append("	} \n");
        functions.append("	return retVal;\n");
        functions.append("}\n");
        functions.append("\n");
        functions.append("void _pushInt(struct _stackInt *s, int valor){\n");
        functions.append("	if(s->tope>=s->capacidad){\n");
        functions.append("		printf(\"ERROR Stack lleno\\n\");\n");
        functions.append("		exit(EXIT_FAILURE);\n");
        functions.append("	}\n");
        functions.append("	s->data[++s->tope] = valor;\n");
        functions.append("}\n");
        functions.append("\n");
        functions.append("void _pushFloat(struct _stackFloat *s, float valor){\n");
        functions.append("	if(s->tope>=s->capacidad){\n");
        functions.append("		printf(\"ERROR Stack lleno\\n\");\n");
        functions.append("		exit(EXIT_FAILURE);\n");
        functions.append("	}\n");
        functions.append("	s->data[++s->tope] = valor;\n");
        functions.append("}\n");
        functions.append("\n");
        functions.append("void _pushChar(struct _stackChar *s, char valor){\n");
        functions.append("	if(s->tope>=s->capacidad){\n");
        functions.append("		printf(\"ERROR Stack lleno\\n\");\n");
        functions.append("		exit(EXIT_FAILURE);\n");
        functions.append("	}\n");
        functions.append("	s->data[++s->tope] = valor;\n");
        functions.append("}\n");
        functions.append("\n");
        functions.append("void _enqueueInt(struct _queueInt *q, int valor){\n");
        functions.append("	int newIndex = (q->fin + 1) % q->capacidad;\n");
        functions.append("	if(newIndex == q->frente){\n");
        functions.append("		printf(\"ERROR Cola llena\\n\");\n");
        functions.append("		exit(EXIT_FAILURE);\n");
        functions.append("	}\n");
        functions.append("	q->data[newIndex] = valor;\n");
        functions.append("}\n");
        functions.append("\n");
        functions.append("void _enqueueFloat(struct _queueFloat *q, float valor){\n");
        functions.append("	int newIndex = (q->fin + 1) % q->capacidad;\n");
        functions.append("	if(newIndex == q->frente){\n");
        functions.append("		printf(\"ERROR Cola llena\\n\");\n");
        functions.append("		exit(EXIT_FAILURE);\n");
        functions.append("	}\n");
        functions.append("	q->data[newIndex] = valor;\n");
        functions.append("}\n");
        functions.append("\n");
        functions.append("void _enqueueChar(struct _queueInt *q, char valor){\n");
        functions.append("	int newIndex = (q->fin + 1) % q->capacidad;\n");
        functions.append("	if(newIndex == q->frente){\n");
        functions.append("		printf(\"ERROR Cola llena\\n\");\n");
        functions.append("		exit(EXIT_FAILURE);\n");
        functions.append("	}\n");
        functions.append("	q->data[newIndex] = valor;\n");
        functions.append("}\n");
        functions.append("\n");
        functions.append("void _initStackInt(struct _stackInt *s, int capacidad){\n");
        functions.append("	s->tope = -1;\n");
        functions.append("	s->capacidad = capacidad;\n");
        functions.append("	s->data = (int*)malloc(capacidad*sizeof(int));\n");
        functions.append("}\n");
        functions.append("\n");
        functions.append("void _initStackFloat(struct _stackFloat *s, int capacidad){\n");
        functions.append("	s->tope = -1;\n");
        functions.append("	s->capacidad = capacidad;\n");
        functions.append("	s->data = (float*)malloc(capacidad*sizeof(float));\n");
        functions.append("}\n");
        functions.append("\n");
        functions.append("void _initStackChar(struct _stackChar *s, int capacidad){\n");
        functions.append("	s->tope = -1;\n");
        functions.append("	s->capacidad = capacidad;\n");
        functions.append("	s->data = (char*)malloc(capacidad*sizeof(char));\n");
        functions.append("}\n");
        functions.append("\n");
        functions.append("void _initQueueInt(struct _queueInt *q, int capacidad){\n");
        functions.append("	q->frente = -1;\n");
        functions.append("	q->fin = -1;\n");
        functions.append("	q->capacidad = capacidad;\n");
        functions.append("	q->data = (int*)malloc(capacidad*sizeof(int));\n");
        functions.append("}\n");
        functions.append("\n");
        functions.append("\n");
        functions.append("void _initQueueFloat(struct _queueFloat *q, int capacidad){\n");
        functions.append("	q->frente = -1;\n");
        functions.append("	q->fin = -1;\n");
        functions.append("	q->capacidad = capacidad;\n");
        functions.append("	q->data = (float*)malloc(capacidad*sizeof(float));\n");
        functions.append("}\n");
        functions.append("\n");
        functions.append("void _initQueueChar(struct _queueChar *q, int capacidad){\n");
        functions.append("	q->frente = -1;\n");
        functions.append("	q->fin = -1;\n");
        functions.append("	q->capacidad = capacidad;\n");
        functions.append("	q->data = (char*)malloc(capacidad*sizeof(char));\n");
        functions.append("}\n");
    }

    public void insertVariable(int kind, String id, String value, String index) {
        boolean isArray = false;
        symbols.append(getType(kind));
        symbols.append(id);
        if (!index.equals(Null)) {
            symbols.append("[");
            isArray = true;
            symbols.append(index);
            symbols.append("]");
        }
        if (!value.equals(Null)) {
            symbols.append(" = ");
            if (isArray) {
                symbols.append("{");
                symbols.append(value);
                symbols.append("}");
            } else {
                symbols.append(value);
            }
        }
        symbols.append(close);
        symbols.append(newLine);
    }

    public void insertConstant(int kind, String id, String value) {
        symbols.append("const ");
        symbols.append(getType(kind));
        symbols.append(id);
        symbols.append(" = ");
        symbols.append(value);
        symbols.append(close);
        symbols.append(newLine);
    }

    public String getType(int kind) {
        String value = "";
        switch (kind) {
            case INT:
                value = "int ";
                break;
            case FLOAT:
                value = "float ";
                break;
            case CHAR:
                value = "char ";
                break;
        }
        return value;
    }

    public void insertAssignment(String id, String value, String index) {
        StringBuilder target = getContext();
        target.append(id);
        if (!index.equals(Null)) {
            target.append("[");
            target.append(index);
            target.append("]");
        }
        target.append(" = ");
        target.append(value);
        target.append(close);
        target.append(newLine);
    }

    public void openFunction(int kind, String id, String arguments) {
        functions.append(getType(kind));
        functions.append(id);
        functions.append("(");
        if (!arguments.equals(Void)) {
            functions.append(arguments);
        }
        functions.append(") {");
        functions.append(newLine);
    }

    public void returnValue(String value) {
        StringBuilder target = getContext();
        target.append("return");
        target.append(" ");
        target.append(value);
        target.append(close);
        target.append(newLine);
    }

    public void callFunction(String id, String arguments) {
        StringBuilder target = getContext();
        target.append(id);
        target.append("(");
        if (!arguments.equals(Void)) {
            target.append(arguments);
        }
        target.append(")");
        target.append(close);
        target.append(newLine);
    }

    public void closeFunction() {
        functions.append("}");
        functions.append(newLine);
    }

    public void closeBlock() {
        StringBuilder target = getContext();
        target.append("}");
        target.append(newLine);
    }

    public void openIF(String expression) {
        StringBuilder target = getContext();
        target.append("if(");
        target.append(expression);
        target.append("){");
        target.append(newLine);
    }

    public void openELSE() {
        StringBuilder target = getContext();
        target.append("else{ ");
        target.append(newLine);
    }

    public void openFor(String initialization, String expression, String increments) {
        StringBuilder target = getContext();
        target.append("for(");
        target.append(initialization);
        target.append(';');
        target.append(expression);
        target.append(';');
        target.append(increments);
        target.append("){");
        target.append(newLine);
    }

    public void openWhile(String expression) {
        StringBuilder target = getContext();
        target.append("while(");
        target.append(expression);
        target.append("){");
        target.append(newLine);
    }

    public void openDoWhile() {
        StringBuilder target = getContext();
        target.append("do{");
        target.append(newLine);
    }

    public void closeDoWhile(String expression) {
        StringBuilder target = getContext();
        target.append("}while(");
        target.append(expression);
        target.append(")");
        target.append(close);
        target.append(newLine);
    }

    public void printElement(int valueKind, String value) {
        StringBuilder target = getContext();
        target.append("printf(");
        switch (valueKind) {
            case INT:
            case NUMERO:
                target.append("\"%d\",");
                break;
            case FLOAT:
            case DECIMAL:
                target.append("\"%f\",");
                break;
            case CHAR:
            case CARACTER:
                target.append("\"%c\",");
                break;
            case STR:
                target.append("\"%s\",");
                break;
        }
        target.append(value);
        target.append(")");
        target.append(close);
        target.append(newLine);
    }

    public void printLine() {
        StringBuilder target = getContext();
        target.append("printf(\"\\n\")");
        target.append(close);
        target.append(newLine);
    }

    public void inputElement(int valueKind, String id) {
        StringBuilder target = getContext();
        target.append("scanf(");
        switch (valueKind) {
            case INT:
                target.append("\"%d\",");
                break;
            case FLOAT:
                target.append("\"%f\",");
                break;
            case CHAR:
                target.append("\"%c\",");
                break;
            case STR:
                target.append("\"%s\",");
                break;
        }
        target.append("&");
        target.append(id);
        target.append(")");
        target.append(close);
        target.append(newLine);
    }

    public void setContext(int context) {
        currentContext = context;
    }

    private StringBuilder getContext() {
        switch (currentContext) {
            case FUNCTIONS:
                return functions;
            case SYMBOLS:
                return symbols;
            case MAINBLOCK:
                return main;
            default:
                return null;
        }
    }

    public void insert(String expression) {
        getContext().append(expression);
    }

    private void openMain() {
        main.append("int main(){");
        main.append(newLine);
    }

    private void closeMain() {
        main.append("return 0;\n");
        main.append("}");
    }

    private void pack() {
        StringBuilder constructor = new StringBuilder();
        closeMain();
        constructor.append(include);
        constructor.append(symbols);
        constructor.append(functions);
        constructor.append(main);
        result = constructor.toString();
    }

    public String getResult() {
        pack();
        return result;
    }

    public void printResult() {
        pack();
        System.out.println(result);
    }

}
