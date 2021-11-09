package br.rchlo.cmsblock.presenters;

import br.rchlo.cmsblock.api.parameters.SearchCriteriaParameter;
import br.rchlo.cmsblock.domain.CmsBlock;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CmsBlockPresenter {

    private  List<Item> items = new ArrayList();
    private SearchCriteria searchCriteria;
    private Long totalCount;


    public CmsBlockPresenter(List<CmsBlock> cmsBlock, SearchCriteriaParameter searchCriteria){
        this.mapItems(cmsBlock).mapCriteria(searchCriteria).countItem();
    }

    private  CmsBlockPresenter mapItems(List<CmsBlock> cmsBlock){
        this.items = cmsBlock.stream().map(block -> new Item().mapItem(block)).collect(Collectors.toList());
        return this;
    }

    private CmsBlockPresenter mapCriteria(SearchCriteriaParameter searchCriteria){
        this.searchCriteria = Optional.of(searchCriteria)
                .map(groups -> new SearchCriteria().listGroups(searchCriteria))
                .orElse(new SearchCriteria());
        return this;
    }
    private CmsBlockPresenter countItem(){
        this.totalCount = this.items.stream().collect(Collectors.counting());
        return this;
    }


}
