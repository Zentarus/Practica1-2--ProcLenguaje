/* alike.java */
/* Generated By:JavaCC: Do not edit this line. alike.java */
package traductor;

//...

public class alike implements alikeConstants {
   //...

   public static void main(String[] args) {
           alike parser = null;

           try {
                   if(args.length == 0) {
                           parser = new alike(System.in);
                   }
                   else {
                           parser = new alike(new java.io.FileInputStream(args[0]));
                   }
                   //Programa es el símbolo inicial de la gramática
                   parser.Programa();
                   //...
                   System.out.println("***** An\u00e1lisis terminado con \u00e9xito *****");
           }
           catch (java.io.FileNotFoundException e) {
                   System.err.println ("Fichero " + args[0] + " no encontrado.");
           }
           catch (TokenMgrError e) {
                   System.err.println("LEX_ERROR: " + e.getMessage());

           }
           catch (ParseException e) {
                        System.err.println("Parse_exception: " + e.getMessage());
           }
           //...
   }

//------------ Símbolo inicial de la gramática. Para análisis léxico no hace falta más
/*void Programa() : 
{
	//Token t;
}
{
   ( 
	   < tBEGIN >
	   | 
	   < tBOOL > | < tCHAR > | < tCHARACTER > | < tINTEGER > | < tNULL > | < tARRAY > | < tCONST_INT > | < tCONST_CHAR > | < tCONST_STRING > 
	   |
	   < tASIGN > | < tSUM > | < tRES > | < tEQU > | < tGT > | < tLT > | < tGE > | < tLE > | < tMUL > | < tMOD > | < tDIV > | < tNOT > | < tDIF > | < tAND > | < tOR >
	   |
	   < tIF > | < tELIF > |	< tTHEN > |	< tWHILE > | < tLOOP > | < tTRUE > | < tFALSE > | <tELSE>
	   |
	   < tPROCEDURE > | < tIS > | < tREF > | < tEND > | < tRETURN > | < tOF > | <tFUNCTION>
	   |
	   < tSKIP_LN > | < tPUT > | < tPUT_LN > | < tGET > | <tCHAR2INT> | <tINT2CHAR> 
	   |
	   < tPUNTO > |	< tCOMA > |	< tDOSPUNTOS > | < tDOBLEPUNTO > | < tPUNTOCOMA > |	< tCORCHETES_OPEN > | < tCORCHETES_CLOSE > | < tPARENTESIS_OPEN > |	< tPARENTESIS_CLOSE > | < tID >
   )+
   < EOF >
}*/
  static final public 

void Programa() throws ParseException {
    jj_consume_token(tPROCEDURE);
    jj_consume_token(tID);
    jj_consume_token(tIS);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tID:{
      declaracion_variables();
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tPROCEDURE:
    case tFUNCTION:{
      declaracion_procs_funcs();
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    jj_consume_token(tBEGIN);
    instrucciones();
    jj_consume_token(tEND);
    jj_consume_token(tPUNTOCOMA);
    jj_consume_token(0);
}

  static final public void declaracion_procs_funcs() throws ParseException {
    label_1:
    while (true) {
      declaracion_proc_func();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case tPROCEDURE:
      case tFUNCTION:{
        ;
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        break label_1;
      }
    }
}

  static final public void declaracion_proc_func() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tPROCEDURE:{
      declaracion_proc();
      break;
      }
    case tFUNCTION:{
      declaracion_func();
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  static final public void declaracion_func() throws ParseException {
    cabecera_funcion();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tID:{
      declaracion_variables();
      break;
      }
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    jj_consume_token(tBEGIN);
    instrucciones();
    jj_consume_token(tEND);
    jj_consume_token(tPUNTOCOMA);
}

  static final public void declaracion_proc() throws ParseException {
    cabecera_procedimiento();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tID:{
      declaracion_variables();
      break;
      }
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    jj_consume_token(tBEGIN);
    instrucciones();
    jj_consume_token(tEND);
    jj_consume_token(tPUNTOCOMA);
}

  static final public void lista_ids() throws ParseException {
    jj_consume_token(tID);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case tCOMA:{
        ;
        break;
        }
      default:
        jj_la1[6] = jj_gen;
        break label_2;
      }
      jj_consume_token(tCOMA);
      jj_consume_token(tID);
    }
}

  static final public void declaracion_variables() throws ParseException {
    label_3:
    while (true) {
      declaracion_var();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case tID:{
        ;
        break;
        }
      default:
        jj_la1[7] = jj_gen;
        break label_3;
      }
    }
}

  static final public void declaracion_variables_puntocoma() throws ParseException {
    label_4:
    while (true) {
      declaracion_var_puntocoma();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case tID:{
        ;
        break;
        }
      default:
        jj_la1[8] = jj_gen;
        break label_4;
      }
    }
}

  static final public void tipo_variable() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tBOOL:{
      jj_consume_token(tBOOL);
      break;
      }
    case tCHAR:{
      jj_consume_token(tCHAR);
      break;
      }
    case tCHARACTER:{
      jj_consume_token(tCHARACTER);
      break;
      }
    case tINTEGER:{
      jj_consume_token(tINTEGER);
      break;
      }
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  static final public void rango() throws ParseException {
    jj_consume_token(tCONST_INT);
    jj_consume_token(tDOSPUNTOS);
    jj_consume_token(tCONST_INT);
}

  static final public void estructura_array() throws ParseException {
    jj_consume_token(tARRAY);
    jj_consume_token(tPARENTESIS_OPEN);
    rango();
    jj_consume_token(tPARENTESIS_CLOSE);
    jj_consume_token(tOF);
    tipo_variable();
}

  static final public void declaracion_var_puntocoma() throws ParseException {
    lista_ids();
    jj_consume_token(tDOBLEPUNTO);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tREF:{
      jj_consume_token(tREF);
      break;
      }
    default:
      jj_la1[10] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tBOOL:
    case tCHAR:
    case tCHARACTER:
    case tINTEGER:{
      tipo_variable();
      break;
      }
    case tARRAY:{
      estructura_array();
      break;
      }
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  static final public void declaracion_var() throws ParseException {
    lista_ids();
    jj_consume_token(tDOBLEPUNTO);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tBOOL:
    case tCHAR:
    case tCHARACTER:
    case tINTEGER:{
      tipo_variable();
      break;
      }
    case tARRAY:{
      estructura_array();
      break;
      }
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(tPUNTOCOMA);
}

  static final public void lista_parametros_funcion_o_proc() throws ParseException {
    declaracion_var_puntocoma();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case tPUNTOCOMA:{
        ;
        break;
        }
      default:
        jj_la1[13] = jj_gen;
        break label_5;
      }
      jj_consume_token(tPUNTOCOMA);
      declaracion_var_puntocoma();
    }
}

  static final public void cabecera_procedimiento() throws ParseException {
    jj_consume_token(tPROCEDURE);
    jj_consume_token(tID);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tPARENTESIS_OPEN:{
      jj_consume_token(tPARENTESIS_OPEN);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case tID:{
        lista_parametros_funcion_o_proc();
        break;
        }
      default:
        jj_la1[14] = jj_gen;
        ;
      }
      jj_consume_token(tPARENTESIS_CLOSE);
      break;
      }
    default:
      jj_la1[15] = jj_gen;
      ;
    }
    jj_consume_token(tIS);
}

  static final public void cabecera_funcion() throws ParseException {
    jj_consume_token(tFUNCTION);
    jj_consume_token(tID);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tPARENTESIS_OPEN:{
      jj_consume_token(tPARENTESIS_OPEN);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case tID:{
        lista_parametros_funcion_o_proc();
        break;
        }
      default:
        jj_la1[16] = jj_gen;
        ;
      }
      jj_consume_token(tPARENTESIS_CLOSE);
      break;
      }
    default:
      jj_la1[17] = jj_gen;
      ;
    }
    jj_consume_token(tRETURN);
    tipo_variable();
    jj_consume_token(tIS);
}

  static final public void inst_leer() throws ParseException {
    jj_consume_token(tGET);
    jj_consume_token(tPARENTESIS_OPEN);
    lista_ids();
    jj_consume_token(tPARENTESIS_CLOSE);
}

  static final public void inst_saltar_linea() throws ParseException {
    jj_consume_token(tSKIP_LN);
}

  static final public void inst_escribir() throws ParseException {
    jj_consume_token(tPUT);
    jj_consume_token(tPARENTESIS_OPEN);
    lista_una_o_mas_exps();
    jj_consume_token(tPARENTESIS_CLOSE);
}

  static final public void inst_escribir_linea() throws ParseException {
    jj_consume_token(tPUT_LN);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tPARENTESIS_OPEN:{
      jj_consume_token(tPARENTESIS_OPEN);
      lista_una_o_mas_exps();
      jj_consume_token(tPARENTESIS_CLOSE);
      break;
      }
    default:
      jj_la1[18] = jj_gen;
      ;
    }
}

  static final public void inst_invocacion_o_asignacion() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tCONST_INT:
    case tCONST_CHAR:
    case tCONST_STRING:
    case tSUM:
    case tRES:
    case tNOT:
    case tTRUE:
    case tFALSE:
    case tCHAR2INT:
    case tINT2CHAR:
    case tPARENTESIS_OPEN:
    case tID:{
      expresion();
      jj_consume_token(tASIGN);
      expresion();
      break;
      }
    default:
      jj_la1[19] = jj_gen;
      if (jj_2_1(2)) {
        jj_consume_token(tID);
        jj_consume_token(tPARENTESIS_OPEN);
        lista_una_o_mas_exps();
        jj_consume_token(tPARENTESIS_CLOSE);
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
}

  static final public void inst_if() throws ParseException {
    jj_consume_token(tIF);
    expresion();
    jj_consume_token(tTHEN);
    instrucciones();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case tELIF:{
        ;
        break;
        }
      default:
        jj_la1[20] = jj_gen;
        break label_6;
      }
      jj_consume_token(tELIF);
      expresion();
      jj_consume_token(tTHEN);
      instrucciones();
    }
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tELSE:{
      jj_consume_token(tELSE);
      instrucciones();
      break;
      }
    default:
      jj_la1[21] = jj_gen;
      ;
    }
    jj_consume_token(tEND);
    jj_consume_token(tIF);
}

  static final public void inst_while() throws ParseException {
    jj_consume_token(tWHILE);
    expresion();
    jj_consume_token(tLOOP);
    instrucciones();
    jj_consume_token(tEND);
    jj_consume_token(tLOOP);
}

  static final public void inst_return() throws ParseException {
    jj_consume_token(tRETURN);
    expresion();
}

  static final public void inst_null() throws ParseException {
    jj_consume_token(tNULL);
}

  static final public void instruccion() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tGET:{
      inst_leer();
      break;
      }
    case tSKIP_LN:{
      inst_saltar_linea();
      break;
      }
    case tPUT:{
      inst_escribir();
      break;
      }
    case tPUT_LN:{
      inst_escribir_linea();
      break;
      }
    case tCONST_INT:
    case tCONST_CHAR:
    case tCONST_STRING:
    case tSUM:
    case tRES:
    case tNOT:
    case tTRUE:
    case tFALSE:
    case tCHAR2INT:
    case tINT2CHAR:
    case tPARENTESIS_OPEN:
    case tID:{
      inst_invocacion_o_asignacion();
      break;
      }
    case tIF:{
      inst_if();
      break;
      }
    case tWHILE:{
      inst_while();
      break;
      }
    case tRETURN:{
      inst_return();
      break;
      }
    case tNULL:{
      inst_null();
      break;
      }
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  static final public void instrucciones() throws ParseException {
    label_7:
    while (true) {
      instruccion();
      jj_consume_token(tPUNTOCOMA);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case tNULL:
      case tCONST_INT:
      case tCONST_CHAR:
      case tCONST_STRING:
      case tSUM:
      case tRES:
      case tNOT:
      case tIF:
      case tWHILE:
      case tTRUE:
      case tFALSE:
      case tRETURN:
      case tSKIP_LN:
      case tPUT:
      case tPUT_LN:
      case tGET:
      case tCHAR2INT:
      case tINT2CHAR:
      case tPARENTESIS_OPEN:
      case tID:{
        ;
        break;
        }
      default:
        jj_la1[23] = jj_gen;
        break label_7;
      }
    }
}

  static final public void expresion() throws ParseException {
    relacion();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tAND:
    case tOR:{
      label_8:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case tAND:{
          jj_consume_token(tAND);
          break;
          }
        case tOR:{
          jj_consume_token(tOR);
          break;
          }
        default:
          jj_la1[24] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        relacion();
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case tAND:
        case tOR:{
          ;
          break;
          }
        default:
          jj_la1[25] = jj_gen;
          break label_8;
        }
      }
      break;
      }
    default:
      jj_la1[26] = jj_gen;
      ;
    }
}

  static final public void lista_una_o_mas_exps() throws ParseException {
    expresion();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case tCOMA:{
        ;
        break;
        }
      default:
        jj_la1[27] = jj_gen;
        break label_9;
      }
      jj_consume_token(tCOMA);
      expresion();
    }
}

  static final public void relacion() throws ParseException {
    expresion_simple();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tEQU:
    case tGT:
    case tLT:
    case tGE:
    case tLE:
    case tDIF:{
      operador_relacional();
      expresion_simple();
      break;
      }
    default:
      jj_la1[28] = jj_gen;
      ;
    }
}

  static final public void operador_relacional() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tEQU:{
      jj_consume_token(tEQU);
      break;
      }
    case tLT:{
      jj_consume_token(tLT);
      break;
      }
    case tGT:{
      jj_consume_token(tGT);
      break;
      }
    case tLE:{
      jj_consume_token(tLE);
      break;
      }
    case tGE:{
      jj_consume_token(tGE);
      break;
      }
    case tDIF:{
      jj_consume_token(tDIF);
      break;
      }
    default:
      jj_la1[29] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  static final public void expresion_simple() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tSUM:
    case tRES:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case tSUM:{
        jj_consume_token(tSUM);
        break;
        }
      case tRES:{
        jj_consume_token(tRES);
        break;
        }
      default:
        jj_la1[30] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    default:
      jj_la1[31] = jj_gen;
      ;
    }
    termino();
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case tSUM:
      case tRES:{
        ;
        break;
        }
      default:
        jj_la1[32] = jj_gen;
        break label_10;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case tSUM:{
        jj_consume_token(tSUM);
        break;
        }
      case tRES:{
        jj_consume_token(tRES);
        break;
        }
      default:
        jj_la1[33] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      termino();
    }
}

  static final public void termino() throws ParseException {
    factor();
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case tMUL:
      case tMOD:
      case tDIV:{
        ;
        break;
        }
      default:
        jj_la1[34] = jj_gen;
        break label_11;
      }
      operador_multiplicativo();
      factor();
    }
}

  static final public void operador_multiplicativo() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tMUL:{
      jj_consume_token(tMUL);
      break;
      }
    case tMOD:{
      jj_consume_token(tMOD);
      break;
      }
    case tDIV:{
      jj_consume_token(tDIV);
      break;
      }
    default:
      jj_la1[35] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  static final public void factor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tCONST_INT:
    case tCONST_CHAR:
    case tCONST_STRING:
    case tTRUE:
    case tFALSE:
    case tCHAR2INT:
    case tINT2CHAR:
    case tPARENTESIS_OPEN:
    case tID:{
      primario();
      break;
      }
    case tNOT:{
      jj_consume_token(tNOT);
      primario();
      break;
      }
    default:
      jj_la1[36] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  static final public void primario() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case tPARENTESIS_OPEN:{
      jj_consume_token(tPARENTESIS_OPEN);
      expresion();
      jj_consume_token(tPARENTESIS_CLOSE);
      break;
      }
    case tINT2CHAR:{
      jj_consume_token(tINT2CHAR);
      jj_consume_token(tPARENTESIS_OPEN);
      expresion();
      jj_consume_token(tPARENTESIS_CLOSE);
      break;
      }
    case tCHAR2INT:{
      jj_consume_token(tCHAR2INT);
      jj_consume_token(tPARENTESIS_OPEN);
      expresion();
      jj_consume_token(tPARENTESIS_CLOSE);
      break;
      }
    default:
      jj_la1[37] = jj_gen;
      if (jj_2_2(2)) {
        jj_consume_token(tID);
        jj_consume_token(tPARENTESIS_OPEN);
        lista_una_o_mas_exps();
        jj_consume_token(tPARENTESIS_CLOSE);
      } else {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case tID:{
          jj_consume_token(tID);
          break;
          }
        case tCONST_INT:{
          jj_consume_token(tCONST_INT);
          break;
          }
        case tCONST_CHAR:{
          jj_consume_token(tCONST_CHAR);
          break;
          }
        case tCONST_STRING:{
          jj_consume_token(tCONST_STRING);
          break;
          }
        case tTRUE:{
          jj_consume_token(tTRUE);
          break;
          }
        case tFALSE:{
          jj_consume_token(tFALSE);
          break;
          }
        default:
          jj_la1[38] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
}

  static private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_1()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_2()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_3_1()
 {
    if (jj_scan_token(tID)) return true;
    if (jj_scan_token(tPARENTESIS_OPEN)) return true;
    return false;
  }

  static private boolean jj_3_2()
 {
    if (jj_scan_token(tID)) return true;
    if (jj_scan_token(tPARENTESIS_OPEN)) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public alikeTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[39];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	   jj_la1_init_2();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1e00,0x0,0x5e00,0x5e00,0x0,0x0,0x0,0x0,0x0,0x0,0x401b8000,0x0,0x0,0x401ba000,0x401ba000,0x80000000,0x80000000,0x80000000,0x0,0x7e00000,0x7e00000,0x180000,0x180000,0x180000,0x180000,0x38000000,0x38000000,0x40038000,0x0,0x38000,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x0,0x600,0x600,0x600,0x0,0x0,0x1000000,0x0,0x0,0x0,0x1000,0x0,0x0,0x8000000,0x0,0x40000000,0x0,0x40000000,0x40000000,0x40600180,0x4,0x8,0x407f01a2,0x407f01a2,0x1,0x1,0x1,0x1000000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x40600180,0x40600000,0x180,};
	}
	private static void jj_la1_init_2() {
	   jj_la1_2 = new int[] {0x1,0x0,0x0,0x0,0x1,0x1,0x0,0x1,0x1,0x0,0x0,0x0,0x0,0x0,0x1,0x0,0x1,0x0,0x0,0x1,0x0,0x0,0x1,0x1,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x0,0x1,};
	}
  static final private JJCalls[] jj_2_rtns = new JJCalls[2];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public alike(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public alike(java.io.InputStream stream, String encoding) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser.  ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new alikeTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 39; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
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
	 for (int i = 0; i < 39; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public alike(java.io.Reader stream) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new alikeTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 39; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new alikeTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 39; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public alike(alikeTokenManager tm) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 39; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(alikeTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 39; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   if (++jj_gc > 100) {
		 jj_gc = 0;
		 for (int i = 0; i < jj_2_rtns.length; i++) {
		   JJCalls c = jj_2_rtns[i];
		   while (c != null) {
			 if (c.gen < jj_gen) c.first = null;
			 c = c.next;
		   }
		 }
	   }
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }

  @SuppressWarnings("serial")
  static private final class LookaheadSuccess extends java.lang.Error {
    @Override
    public Throwable fillInStackTrace() {
      return this;
    }
  }
  static private final LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
	 if (jj_scanpos == jj_lastpos) {
	   jj_la--;
	   if (jj_scanpos.next == null) {
		 jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
	   } else {
		 jj_lastpos = jj_scanpos = jj_scanpos.next;
	   }
	 } else {
	   jj_scanpos = jj_scanpos.next;
	 }
	 if (jj_rescan) {
	   int i = 0; Token tok = token;
	   while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
	   if (tok != null) jj_add_error_token(kind, i);
	 }
	 if (jj_scanpos.kind != kind) return true;
	 if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
	 return false;
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

  static private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
	 if (pos >= 100) {
		return;
	 }

	 if (pos == jj_endpos + 1) {
	   jj_lasttokens[jj_endpos++] = kind;
	 } else if (jj_endpos != 0) {
	   jj_expentry = new int[jj_endpos];

	   for (int i = 0; i < jj_endpos; i++) {
		 jj_expentry[i] = jj_lasttokens[i];
	   }

	   for (int[] oldentry : jj_expentries) {
		 if (oldentry.length == jj_expentry.length) {
		   boolean isMatched = true;

		   for (int i = 0; i < jj_expentry.length; i++) {
			 if (oldentry[i] != jj_expentry[i]) {
			   isMatched = false;
			   break;
			 }

		   }
		   if (isMatched) {
			 jj_expentries.add(jj_expentry);
			 break;
		   }
		 }
	   }

	   if (pos != 0) {
		 jj_lasttokens[(jj_endpos = pos) - 1] = kind;
	   }
	 }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[65];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 39; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		   if ((jj_la1_2[i] & (1<<j)) != 0) {
			 la1tokens[64+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 65; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 jj_endpos = 0;
	 jj_rescan_token();
	 jj_add_error_token(0, 0);
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  static private boolean trace_enabled;

/** Trace enabled. */
  static final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
	 jj_rescan = true;
	 for (int i = 0; i < 2; i++) {
	   try {
		 JJCalls p = jj_2_rtns[i];

		 do {
		   if (p.gen > jj_gen) {
			 jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
			 switch (i) {
			   case 0: jj_3_1(); break;
			   case 1: jj_3_2(); break;
			 }
		   }
		   p = p.next;
		 } while (p != null);

		 } catch(LookaheadSuccess ls) { }
	 }
	 jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
	 JJCalls p = jj_2_rtns[index];
	 while (p.gen > jj_gen) {
	   if (p.next == null) { p = p.next = new JJCalls(); break; }
	   p = p.next;
	 }

	 p.gen = jj_gen + xla - jj_la; 
	 p.first = token;
	 p.arg = xla;
  }

  static final class JJCalls {
	 int gen;
	 Token first;
	 int arg;
	 JJCalls next;
  }

}
