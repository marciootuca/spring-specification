package br.rchlo.cmsblock.presenters;

import br.rchlo.cmsblock.api.parameters.SearchCriteriaParameter;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class SearchCriteria {
    private List<FilterGroup> filterGroups = new ArrayList<FilterGroup>();

    public SearchCriteria listGroups(SearchCriteriaParameter dto){
        this.filterGroups.add(toFilterGroup(dto));
        return this;
    }

    public FilterGroup toFilterGroup(SearchCriteriaParameter dto){
      return Optional.of(dto).map(searchCriteriaDto -> new FilterGroup().mapGroup(searchCriteriaDto)).orElse(new FilterGroup());
    }

}
