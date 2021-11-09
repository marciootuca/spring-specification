package br.rchlo.cmsblock.service;

import br.rchlo.cmsblock.api.parameters.SearchCriteriaParameter;
import br.rchlo.cmsblock.integration.repository.CmsBlockRepository;
import br.rchlo.cmsblock.presenters.CmsBlockPresenter;
import br.rchlo.cmsblock.specification.SearchOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CmsBlockService {

    private final CmsBlockRepository repository;

    private SearchCriteriaParameter criteria ;

    public CmsBlockPresenter find(Map<String, String> search){
      return Optional.of(repository.findAll(getSearchOperation(search)))
                   .map(cmsBlock -> new CmsBlockPresenter(cmsBlock, criteria))
                   .orElseThrow(() -> new NotFoundException("cms block not found"));
    }

    private SearchOperation getSearchOperation(Map<String,String> searchs){
        var value = getParams(searchs, "value");
        var key = getParams(searchs, "field");
        var operation = getParams(searchs, "condition_type");
        criteria = SearchCriteriaParameter.of(key, value, operation );
        return SearchOperation.valueOf(operation.toUpperCase())
                        .getSearchCriteriaDto(SearchCriteriaParameter.of(key, value, null));

    }

    private String getParams (Map<String,String> entryMap, String filter){
        return entryMap.entrySet()
                .stream()
                .filter(f-> f.getKey().contains(filter))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }
}
