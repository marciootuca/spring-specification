package br.rchlo.cmsblock.presenters;

import br.rchlo.cmsblock.api.parameters.SearchCriteriaParameter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class FilterGroup {
    private List<Filter> filters = new ArrayList<Filter>();

    public  FilterGroup mapGroup(SearchCriteriaParameter dto){
        filters.add(Optional.of(dto).map(filter -> new Filter().mapFilter(dto)).orElse(new Filter()));
        return this;
    }

}
