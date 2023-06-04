package com.hackaton.ezmilk.exception;

import java.text.MessageFormat;
import java.util.List;

public class MessageExceptionBundle {

    MessageExceptionBundle() {
    }

    public static String getMensagem(IDomainException mensagem, Object... argumentos) {
        formatarArgumentos(argumentos);
        return MessageFormat.format(mensagem.getMessage(), argumentos);
    }

    public static String getMensagem(String mensagem, Object... argumentos) {
        formatarArgumentos(argumentos);
        return MessageFormat.format(mensagem, argumentos);
    }

    public static String getMensagem(IDomainException mensagem) {
        return mensagem.getMessage();
    }

    private static void formatarArgumentos(Object[] argumentos) {
        for (int i = 0; i < argumentos.length; i++) {
            if (argumentos[i] == null) {
                argumentos[i] = " ";
            }
            if (argumentos[i] instanceof List) {
                StringBuilder retorno = new StringBuilder();

                for (Object s : (List<?>) argumentos[i]) {
                    retorno.append(s).append("\r\n");
                }
                argumentos[i] = retorno.toString();
            }
        }
    }
}

