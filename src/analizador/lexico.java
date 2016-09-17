/* Generated By:JavaCC: Do not edit this line. lexico.java */
package analizador;
import java.io.*;
import java.util.Scanner;
public class lexico implements lexicoConstants {
        public static boolean bandera;
        public static void main( String[] args )throws ParseException, Exception
        {
                try
                {
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Presione 1 para analisis lexico, 2 para analisis sintactico: ");
                        int n = sc.nextInt();
                        if(n == 1){
                        System.out.println("Selecciono Analisis Lexico");
                        lexico analizador = new lexico( System.in ) ;
                        analizador.iniciarAnalisisLexico();
                        }
                        else if(n == 2){
                        System.out.println("Selecciono Analisis Sintactico");
                        lexico analizador = new lexico( System.in ) ;
                        analizador.iniciarAnalisisSintactico();
                        }
                        System.out.println("\u005ctAnalisis Finalizado");
                }
                catch(ParseException e)
                {
                        System.out.println(e.getMessage());
                        System.out.println("\u005ctAnalisis Finalizado");
                }
        }

//este metodo inicia el analizador lexico
  static final public void iniciarAnalisisLexico() throws ParseException {
 lexico.bandera = true;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MAIN:
      case CONSTANTE:
      case INPUT:
      case PRINT:
      case IF:
      case ELSE:
      case WHILE:
      case DO:
      case FOR:
      case OR:
      case AND:
      case NOT:
      case TRUE:
      case FALSE:
      case ASIGNACION:
      case RESTA:
      case SUMA:
      case MULTIPLICACION:
      case DIVISION:
      case MENOR:
      case MAYOR:
      case MENORIGUAL:
      case MAYORIGUAL:
      case IGUAL:
      case DIFERENTE:
      case PARENTA:
      case PARENTC:
      case LLAVEA:
      case LLAVEC:
      case COMA:
      case PUNTO:
      case PCOMA:
      case DCOMA:
      case SCOMA:
      case DCORCHETE:
      case SCORCHETE:
      case INT:
      case FLOAT:
      case BOOLEAN:
      case CHAR:
      case STR:
      case NUMERO:
      case DECIMAL:
      case CADENA:
      case CARACTER:
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MAIN:
        jj_consume_token(MAIN);
        break;
      case CONSTANTE:
        jj_consume_token(CONSTANTE);
        break;
      case INPUT:
        jj_consume_token(INPUT);
        break;
      case PRINT:
        jj_consume_token(PRINT);
        break;
      case IF:
        jj_consume_token(IF);
        break;
      case ELSE:
        jj_consume_token(ELSE);
        break;
      case WHILE:
        jj_consume_token(WHILE);
        break;
      case DO:
        jj_consume_token(DO);
        break;
      case FOR:
        jj_consume_token(FOR);
        break;
      case OR:
        jj_consume_token(OR);
        break;
      case AND:
        jj_consume_token(AND);
        break;
      case NOT:
        jj_consume_token(NOT);
        break;
      case TRUE:
        jj_consume_token(TRUE);
        break;
      case FALSE:
        jj_consume_token(FALSE);
        break;
      case ASIGNACION:
        jj_consume_token(ASIGNACION);
        break;
      case RESTA:
        jj_consume_token(RESTA);
        break;
      case SUMA:
        jj_consume_token(SUMA);
        break;
      case MULTIPLICACION:
        jj_consume_token(MULTIPLICACION);
        break;
      case DIVISION:
        jj_consume_token(DIVISION);
        break;
      case MENOR:
        jj_consume_token(MENOR);
        break;
      case MAYOR:
        jj_consume_token(MAYOR);
        break;
      case MAYORIGUAL:
        jj_consume_token(MAYORIGUAL);
        break;
      case MENORIGUAL:
        jj_consume_token(MENORIGUAL);
        break;
      case IGUAL:
        jj_consume_token(IGUAL);
        break;
      case DIFERENTE:
        jj_consume_token(DIFERENTE);
        break;
      case PARENTA:
        jj_consume_token(PARENTA);
        break;
      case PARENTC:
        jj_consume_token(PARENTC);
        break;
      case LLAVEA:
        jj_consume_token(LLAVEA);
        break;
      case LLAVEC:
        jj_consume_token(LLAVEC);
        break;
      case COMA:
        jj_consume_token(COMA);
        break;
      case PUNTO:
        jj_consume_token(PUNTO);
        break;
      case PCOMA:
        jj_consume_token(PCOMA);
        break;
      case DCOMA:
        jj_consume_token(DCOMA);
        break;
      case SCOMA:
        jj_consume_token(SCOMA);
        break;
      case DCORCHETE:
        jj_consume_token(DCORCHETE);
        break;
      case SCORCHETE:
        jj_consume_token(SCORCHETE);
        break;
      case INT:
        jj_consume_token(INT);
        break;
      case FLOAT:
        jj_consume_token(FLOAT);
        break;
      case BOOLEAN:
        jj_consume_token(BOOLEAN);
        break;
      case CHAR:
        jj_consume_token(CHAR);
        break;
      case STR:
        jj_consume_token(STR);
        break;
      case NUMERO:
        jj_consume_token(NUMERO);
        break;
      case DECIMAL:
        jj_consume_token(DECIMAL);
        break;
      case CADENA:
        jj_consume_token(CADENA);
        break;
      case CARACTER:
        jj_consume_token(CARACTER);
        break;
      case IDENTIFICADOR:
        jj_consume_token(IDENTIFICADOR);
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void iniciarAnalisisSintactico() throws ParseException {
 lexico.bandera = false;
    jj_consume_token(MAIN);
    jj_consume_token(LLAVEA);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONSTANTE:
      case INPUT:
      case PRINT:
      case IF:
      case WHILE:
      case DO:
      case FOR:
      case INT:
      case FLOAT:
      case BOOLEAN:
      case CHAR:
      case STR:
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      bloque();
    }
    jj_consume_token(LLAVEC);
  }

  static final public void bloque() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CONSTANTE:
    case INPUT:
    case PRINT:
    case INT:
    case FLOAT:
    case BOOLEAN:
    case CHAR:
    case STR:
    case IDENTIFICADOR:
      sentencias();
      break;
    case IF:
      decisionIF();
      break;
    case WHILE:
    case DO:
    case FOR:
      ciclos();
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

//BLOQUE DE SENTENCIAS
  static final public void sentencias() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CONSTANTE:
    case INT:
    case FLOAT:
    case BOOLEAN:
    case CHAR:
    case STR:
      declaracion();
      break;
    case PRINT:
      impresion();
      break;
    case IDENTIFICADOR:
      asignacion();
      break;
    case INPUT:
      entrada();
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void declaracion() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CONSTANTE:
      constantes();
      break;
    case INT:
    case FLOAT:
    case BOOLEAN:
    case CHAR:
    case STR:
      variables();
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void constantes() throws ParseException {
    jj_consume_token(CONSTANTE);
    tipoDato();
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(ASIGNACION);
    operacion();
    jj_consume_token(PCOMA);
  }

  static final public void variables() throws ParseException {
    tipoDato();
    jj_consume_token(IDENTIFICADOR);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DCORCHETE:
      arreglo();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ASIGNACION:
        jj_consume_token(ASIGNACION);
        jj_consume_token(LLAVEA);
        valorDato();
        label_3:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case COMA:
            ;
            break;
          default:
            jj_la1[6] = jj_gen;
            break label_3;
          }
          jj_consume_token(COMA);
          valorDato();
        }
        jj_consume_token(LLAVEC);
        break;
      default:
        jj_la1[7] = jj_gen;
        ;
      }
      break;
    default:
      jj_la1[9] = jj_gen;
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ASIGNACION:
        jj_consume_token(ASIGNACION);
        operacion();
        break;
      default:
        jj_la1[8] = jj_gen;
        ;
      }
    }
    jj_consume_token(PCOMA);
  }

  static final public void operacion() throws ParseException {
    valorDato();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RESTA:
      case SUMA:
      case MULTIPLICACION:
      case DIVISION:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_4;
      }
      operadores();
      valorDato();
    }
  }

  static final public void arreglo() throws ParseException {
    jj_consume_token(DCORCHETE);
    operacion();
    jj_consume_token(SCORCHETE);
  }

  static final public void tipoDato() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      break;
    case FLOAT:
      jj_consume_token(FLOAT);
      break;
    case BOOLEAN:
      jj_consume_token(BOOLEAN);
      break;
    case CHAR:
      jj_consume_token(CHAR);
      break;
    case STR:
      jj_consume_token(STR);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void valorDato() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RESTA:
      jj_consume_token(RESTA);
      break;
    default:
      jj_la1[12] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMERO:
      jj_consume_token(NUMERO);
      break;
    case DECIMAL:
      jj_consume_token(DECIMAL);
      break;
    case CARACTER:
      jj_consume_token(CARACTER);
      break;
    case TRUE:
      jj_consume_token(TRUE);
      break;
    case FALSE:
      jj_consume_token(FALSE);
      break;
    case CADENA:
      jj_consume_token(CADENA);
      break;
    case IDENTIFICADOR:
      jj_consume_token(IDENTIFICADOR);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DCORCHETE:
        arreglo();
        break;
      default:
        jj_la1[13] = jj_gen;
        ;
      }
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void impresion() throws ParseException {
    jj_consume_token(PRINT);
    valorDato();
    jj_consume_token(PCOMA);
  }

  static final public void asignacion() throws ParseException {
    jj_consume_token(IDENTIFICADOR);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DCORCHETE:
      arreglo();
      break;
    default:
      jj_la1[15] = jj_gen;
      ;
    }
    jj_consume_token(ASIGNACION);
    operacion();
    jj_consume_token(PCOMA);
  }

  static final public void entrada() throws ParseException {
    jj_consume_token(INPUT);
    jj_consume_token(PARENTA);
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(PARENTC);
    jj_consume_token(PCOMA);
  }

//No meterlos todos aqui, no son iguales
  static final public void operadores() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MULTIPLICACION:
      jj_consume_token(MULTIPLICACION);
      break;
    case DIVISION:
      jj_consume_token(DIVISION);
      break;
    case SUMA:
      jj_consume_token(SUMA);
      break;
    case RESTA:
      jj_consume_token(RESTA);
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void operadoresRelacionales() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MENOR:
      jj_consume_token(MENOR);
      break;
    case MAYOR:
      jj_consume_token(MAYOR);
      break;
    case IGUAL:
      jj_consume_token(IGUAL);
      break;
    case MENORIGUAL:
      jj_consume_token(MENORIGUAL);
      break;
    case MAYORIGUAL:
      jj_consume_token(MAYORIGUAL);
      break;
    case DIFERENTE:
      jj_consume_token(DIFERENTE);
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

//BLOQUE DE DECISIONES
  static final public void decisionIF() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(PARENTA);
    expresionLogica();
    jj_consume_token(PARENTC);
    jj_consume_token(LLAVEA);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONSTANTE:
      case INPUT:
      case PRINT:
      case IF:
      case WHILE:
      case DO:
      case FOR:
      case INT:
      case FLOAT:
      case BOOLEAN:
      case CHAR:
      case STR:
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[18] = jj_gen;
        break label_5;
      }
      bloque();
    }
    jj_consume_token(LLAVEC);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      decisionELSE();
      break;
    default:
      jj_la1[19] = jj_gen;
      ;
    }
  }

  static final public void decisionELSE() throws ParseException {
    jj_consume_token(ELSE);
    jj_consume_token(LLAVEA);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONSTANTE:
      case INPUT:
      case PRINT:
      case IF:
      case WHILE:
      case DO:
      case FOR:
      case INT:
      case FLOAT:
      case BOOLEAN:
      case CHAR:
      case STR:
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[20] = jj_gen;
        break label_6;
      }
      bloque();
    }
    jj_consume_token(LLAVEC);
  }

//Inicio expresionLogica
  static final public void expresionLogica() throws ParseException {
    expresionSimple();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
      case AND:
        ;
        break;
      default:
        jj_la1[21] = jj_gen;
        break label_7;
      }
      operadoresLogicos();
      expresionSimple();
    }
  }

  static final public void expresionSimple() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
    case FALSE:
    case RESTA:
    case NUMERO:
    case DECIMAL:
    case CADENA:
    case CARACTER:
    case IDENTIFICADOR:
      valorDato();
      label_8:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case RESTA:
        case SUMA:
        case MULTIPLICACION:
        case DIVISION:
        case MENOR:
        case MAYOR:
        case MENORIGUAL:
        case MAYORIGUAL:
        case IGUAL:
        case DIFERENTE:
          ;
          break;
        default:
          jj_la1[22] = jj_gen;
          break label_8;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case MENOR:
        case MAYOR:
        case MENORIGUAL:
        case MAYORIGUAL:
        case IGUAL:
        case DIFERENTE:
          operadoresRelacionales();
          break;
        case RESTA:
        case SUMA:
        case MULTIPLICACION:
        case DIVISION:
          operadores();
          break;
        default:
          jj_la1[23] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        valorDato();
      }
      break;
    case NOT:
      expresionBoolean();
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void expresionBoolean() throws ParseException {
    jj_consume_token(NOT);
    jj_consume_token(PARENTA);
    expresionLogica();
    jj_consume_token(PARENTC);
  }

//Fin expresionLogica
  static final public void operadoresLogicos() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OR:
      jj_consume_token(OR);
      break;
    case AND:
      jj_consume_token(AND);
      break;
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

//BLOQUE DE CICLOS
  static final public void ciclos() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case WHILE:
      cicloWhile();
      break;
    case DO:
      cicloDoWhile();
      break;
    case FOR:
      cicloFor();
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void cicloDoWhile() throws ParseException {
    jj_consume_token(DO);
    jj_consume_token(LLAVEA);
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONSTANTE:
      case INPUT:
      case PRINT:
      case IF:
      case WHILE:
      case DO:
      case FOR:
      case INT:
      case FLOAT:
      case BOOLEAN:
      case CHAR:
      case STR:
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[27] = jj_gen;
        break label_9;
      }
      bloque();
    }
    jj_consume_token(LLAVEC);
    jj_consume_token(WHILE);
    jj_consume_token(PARENTA);
    expresionLogica();
    jj_consume_token(PARENTC);
    jj_consume_token(PCOMA);
  }

  static final public void cicloWhile() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(PARENTA);
    expresionLogica();
    jj_consume_token(PARENTC);
    jj_consume_token(LLAVEA);
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONSTANTE:
      case INPUT:
      case PRINT:
      case IF:
      case WHILE:
      case DO:
      case FOR:
      case INT:
      case FLOAT:
      case BOOLEAN:
      case CHAR:
      case STR:
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[28] = jj_gen;
        break label_10;
      }
      bloque();
    }
    jj_consume_token(LLAVEC);
  }

  static final public void cicloFor() throws ParseException {
    jj_consume_token(FOR);
    jj_consume_token(PARENTA);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
    case FLOAT:
    case BOOLEAN:
    case CHAR:
    case STR:
      tipoDato();
      break;
    default:
      jj_la1[29] = jj_gen;
      ;
    }
    inicializar();
    jj_consume_token(PCOMA);
    expresionLogica();
    jj_consume_token(PCOMA);
    incrementos();
    jj_consume_token(PARENTC);
    jj_consume_token(LLAVEA);
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONSTANTE:
      case INPUT:
      case PRINT:
      case IF:
      case WHILE:
      case DO:
      case FOR:
      case INT:
      case FLOAT:
      case BOOLEAN:
      case CHAR:
      case STR:
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[30] = jj_gen;
        break label_11;
      }
      bloque();
    }
    jj_consume_token(LLAVEC);
  }

  static final public void inicializar() throws ParseException {
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(ASIGNACION);
    operacion();
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMA:
        ;
        break;
      default:
        jj_la1[31] = jj_gen;
        break label_12;
      }
      jj_consume_token(COMA);
      inicializar();
    }
  }

  static final public void incrementos() throws ParseException {
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(ASIGNACION);
    operacion();
    label_13:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMA:
        ;
        break;
      default:
        jj_la1[32] = jj_gen;
        break label_13;
      }
      jj_consume_token(COMA);
      incrementos();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public lexicoTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[33];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xfffffffe,0xfffffffe,0x3bc,0x3bc,0x1c,0x4,0x40000000,0x8000,0x8000,0x0,0xf0000,0x0,0x10000,0x0,0x6000,0x0,0xf0000,0x3f00000,0x3bc,0x40,0x3bc,0xc00,0x3ff0000,0x3ff0000,0x17000,0xc00,0x380,0x3bc,0x3bc,0x0,0x3bc,0x40000000,0x40000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x7fff,0x7fff,0x43e0,0x43e0,0x43e0,0x3e0,0x0,0x0,0x0,0x8,0x0,0x3e0,0x0,0x8,0x7c00,0x8,0x0,0x0,0x43e0,0x0,0x43e0,0x0,0x0,0x0,0x7c00,0x0,0x0,0x43e0,0x43e0,0x3e0,0x43e0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public lexico(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public lexico(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new lexicoTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 33; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 33; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public lexico(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new lexicoTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 33; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 33; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public lexico(lexicoTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 33; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(lexicoTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 33; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[52];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 33; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 52; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
