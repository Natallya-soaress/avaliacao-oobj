package com.oobj.integrador.integrador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.naming.NamingException;
import java.io.*;

import static com.oobj.integrador.enfileirador.EscritorArquivo.escreveArquivoEntrada;
import static com.oobj.integrador.enfileirador.EscritorArquivo.nomearArquivoEntrada;


@RequestMapping("api")
@RestController
public class IntegradorController {

    @PostMapping("/pre-impressao")
    public ResponseEntity<String> recebeRequisição(@RequestBody String entrada) throws IOException, NamingException, JMSException {

        escreveArquivoEntrada(entrada, nomearArquivoEntrada());

        return new ResponseEntity<String>("\"preImpressaoSolicitada\" : true", HttpStatus.OK);
    }

}
