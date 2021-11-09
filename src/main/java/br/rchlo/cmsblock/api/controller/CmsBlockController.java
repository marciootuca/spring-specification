package br.rchlo.cmsblock.api.controller;

import br.rchlo.cmsblock.presenters.CmsBlockPresenter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface CmsBlockController {

    @Operation(summary = "Busca cms block", description = "")
    @SecurityRequirements(value = {}) // Desabilita a segurança para essa operação
    @ApiResponse(responseCode = "200", description = "Success") // Gerado ao encontrar a cliente com sucesso
    ResponseEntity<CmsBlockPresenter> find(@RequestHeader("Authorization") String authorization, @RequestParam Map<String, String> params);

}
