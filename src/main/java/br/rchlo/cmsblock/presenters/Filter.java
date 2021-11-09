package br.rchlo.cmsblock.presenters;

import br.rchlo.cmsblock.api.parameters.SearchCriteriaParameter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Filter {
    private String field;
    private String value;
    private String conditionType;

    public  Filter mapFilter(SearchCriteriaParameter dto){
        this.field = dto.getKey();
        this.value = dto.getValue();
        this.conditionType = dto.getOperation();
        return this;
    }
}
