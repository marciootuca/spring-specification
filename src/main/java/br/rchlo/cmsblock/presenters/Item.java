package br.rchlo.cmsblock.presenters;

import br.rchlo.cmsblock.domain.CmsBlock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    private Long id;
    private String identifier;
    private String title;
    private String content;
    private String creationTime;
    private String updateTime;
    private Boolean active;

    public List<Item> items (CmsBlock cmsBlock){
        return List.of(this.mapItem(cmsBlock));
    }


    public Item mapItem(CmsBlock cmsBlock) {
        this.content = cmsBlock.getContent();
        this.id = cmsBlock.getBlockId();
        this.identifier = cmsBlock.getIdentifier();
        this.title = cmsBlock.getTitle();
        return this;
    }

}
