package br.rchlo.cmsblock.api.parameters;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
public class SearchCriteriaParameter {
    private String key;
    private String value;
    private String operation;
}
