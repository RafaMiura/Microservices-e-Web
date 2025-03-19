package checkp1.controller.handlers.dto;

import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationErrorDTO extends CustomErrorDTO {

    private List<FielMessageDTO> errors = new ArrayList<>();



    public ValidationErrorDTO(Instant timestamp, Integer status, String error, String path){
        super(timestamp, status, error, path);

    }
    //metodo para add erros à list
    public void addError(String fieldName, String message){
        //remove o erro de campos duplicados
        errors.removeIf(x -> x.getFieldName().equals(fieldName));
        errors.add(new FielMessageDTO(fieldName, message));
    }


}
