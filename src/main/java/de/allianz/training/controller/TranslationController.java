package de.allianz.training.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RequestMapping("/translate")
@RequiredArgsConstructor
@RestController
public class TranslationController {

   private final MessageSource messageSource;

   @GetMapping
   public String getSomehow(Locale locale) {
       return locale.toString();
   }

}
