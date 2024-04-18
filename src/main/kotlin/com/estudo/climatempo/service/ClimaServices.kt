package com.estudo.climatempo.service

import com.estudo.climatempo.controller.request.Clima
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class ClimaServices {

    fun enviarParaFila() {
        //criar regra de negocio
        //converter em json

        val clima = Clima()
        val mapper = jacksonObjectMapper().writeValueAsString(clima)
        println(mapper)

    }
}