package ecma.ai.transferapp.controller;

import ecma.ai.transferapp.entity.Card;
import ecma.ai.transferapp.payload.ApiResponse;
import ecma.ai.transferapp.payload.CardDto;
import ecma.ai.transferapp.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    CardService cardService;


    @PostMapping
    public HttpEntity<?> add(@RequestBody CardDto dto, HttpServletRequest httpServletRequest) {

        ApiResponse response = cardService.add(dto, httpServletRequest);

        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody CardDto cardDto, HttpServletRequest httpServletRequest) {
        ApiResponse response = cardService.edit(id, cardDto, httpServletRequest);

        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);
    }


    @DeleteMapping("/{id}")
    public HttpEntity<?> delet(@PathVariable Integer id, HttpServletRequest httpServletRequest) {
        ApiResponse response = cardService.deleted(id, httpServletRequest);
        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);

    }

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Card> cardList = cardService.getAll();
        return ResponseEntity.ok(cardList);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        Card card = cardService.getOne(id);
        if (card == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(card);
    }
}
