package com.estudo.climatempo.controller

import com.estudo.climatempo.controller.request.Clima
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class ClimaController {

    @GetMapping("clima", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun temperatura(): ResponseEntity<String> {

        val key = "f056d"
        val url = String.format("https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&lang=pt_br&appid=%s",
            key)

        val restTemplate = RestTemplate()
        //val retorno = restTemplate.getForEntity(url, String::class.java)

        return ResponseEntity.ok("ok");

    }

    @GetMapping("clima/lang", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun temperaturaCidade(@RequestParam lang: String): ResponseEntity<String> {

        val url = String.format("http://qualquerurl/%s", lang);

        return ResponseEntity.ok(url);

    }

    @GetMapping("clima/{lang}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun temperaturaLingua(@PathVariable lang: String): ResponseEntity<String> {

        val url = String.format("http://qualquerurl/%s", lang);

        return ResponseEntity.ok(url);

    }

    @PostMapping("clima/post", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun temperaturaLingua(@RequestBody clima: Clima): ResponseEntity<String> {

        val url = String.format("http://post.clima/%s", clima);

        return ResponseEntity.ok(url);

    }

}