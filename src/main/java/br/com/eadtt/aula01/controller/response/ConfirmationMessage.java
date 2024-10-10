package br.com.eadtt.aula01.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * {
 *     "status": "ERROR",
 *     "confirmationMessages": [
 *          {
 *              "message": "Veiculo cadastrado no banco com sucesso",
 *              "messageCode": "VEICULO_CADASTRADO"
 *          }, {
 *              "message": "Dono possui pendencias",
 *              "CLIENTE_PAGAMENTO_PENDENTE"
 *          }
 *     ]
 * }
 */
@Data
public class ConfirmationMessage {
    private Status status;
    private List<Message> confirmationMessages;

    @Data
    @AllArgsConstructor
    public static class Message {
        private String message;
        private String messageCode;
    }
    public static enum Status {
        ERROR,
        OK,
        BAD_REQUEST
    }
}
