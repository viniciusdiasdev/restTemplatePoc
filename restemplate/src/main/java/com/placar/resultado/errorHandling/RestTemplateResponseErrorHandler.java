package com.placar.resultado.errorHandling;

import com.placar.resultado.exceptions.NotFoundException;
import com.placar.resultado.exceptions.ServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

        @Override
        public boolean hasError(ClientHttpResponse httpResponse)
                throws IOException {

            return (
                    httpResponse.getStatusCode().is4xxClientError()
                            || httpResponse.getStatusCode().is5xxServerError());
        }

        @Override
        public void handleError(ClientHttpResponse httpResponse)
                throws IOException {
            if (httpResponse.getStatusCode().is5xxServerError()) {
                throw new ServerException("Erro no servidor");
            } else if (httpResponse.getStatusCode().is4xxClientError()) {
                // handle CLIENT_ERROR
                if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                    throw new NotFoundException("Nao encontrado o erro");
                } if (httpResponse.getStatusCode() == HttpStatus.BAD_REQUEST) {
                    throw new NotFoundException("Erro de requisição");
                }
            }
        }
    }
