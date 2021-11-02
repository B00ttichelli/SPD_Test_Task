package com.example.spd_test_task.controller;

import com.example.spd_test_task.dto.PurchasesDTO;
import com.example.spd_test_task.service.PurchasesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class PurchaseController {

    private final PurchasesService purchasesService;

    @PostMapping("/purchase")
    public ResponseEntity purchase(@RequestBody PurchasesDTO purchasesDTO) {
        try {
            return ResponseEntity.ok(purchasesService.save(purchasesDTO));
        } catch (Exception e) {

            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

/*    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e) {
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
        e.getConstraintViolations().forEach(a -> errors.add(a.getPropertyPath() + " : " + a.getMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }*/
}
