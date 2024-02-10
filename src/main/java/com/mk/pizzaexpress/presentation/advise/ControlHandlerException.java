package com.mk.pizzaexpress.presentation.advise;

import com.mk.pizzaexpress.domain.dto.generic.ExceptionErrorDto;
import com.mk.pizzaexpress.domain.entity.Ingrediente;
import com.mk.pizzaexpress.domain.entity.usuarios.Proveedor;
import com.mk.pizzaexpress.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControlHandlerException {

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleNotFoundException(NotFoundException exception){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ExceptionErrorDto(exception.getMessage()));
    }

    @ExceptionHandler(value = AdministradorException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleAdministradorException(AdministradorException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionErrorDto(exception.getMessage()));
    }

    @ExceptionHandler(value = ClienteException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleClienteException(ClienteException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionErrorDto(exception.getMessage()));
    }

    @ExceptionHandler(value = ProveedorException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleProveedorException(ProveedorException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionErrorDto(exception.getMessage()));
    }

    @ExceptionHandler(value = PedidoException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handlePedidoException(PedidoException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionErrorDto(exception.getMessage()));
    }

    @ExceptionHandler(value = BebidaException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleBebidaException(BebidaException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionErrorDto(exception.getMessage()));
    }

    @ExceptionHandler(value = PizzaException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handlePizzaException(PizzaException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionErrorDto(exception.getMessage()));
    }

    @ExceptionHandler(value = ImagenException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleImagenException(ClienteException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionErrorDto(exception.getMessage()));
    }

    @ExceptionHandler(value = RecetaException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleRecetaException(RecetaException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionErrorDto(exception.getMessage()));
    }

    @ExceptionHandler(value = IngredienteException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleIngredienteException(IngredienteException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionErrorDto(exception.getMessage()));
    }

    @ExceptionHandler(value = StockException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handlerStockException(StockException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionErrorDto(exception.getMessage()));
    }
}
