package br.rchlo.cmsblock.api.controller;

import br.rchlo.cmsblock.presenters.CmsBlockPresenter;
import br.rchlo.cmsblock.service.CmsBlockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = {"rest/V1/cmsBlock", "rest/default/V1/cmsBlock", "rest/all/V1/cmsBlock"})
public class CmsBlockControllerImpl implements CmsBlockController{

    private final CmsBlockService service;

    @GetMapping("/search")
    @Override
    public ResponseEntity<CmsBlockPresenter> find(String authorization, Map<String, String> search) {
        var response = service.find(search);
        return ResponseEntity.ok(response);
     }
}
