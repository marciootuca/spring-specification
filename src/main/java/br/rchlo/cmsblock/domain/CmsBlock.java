package br.rchlo.cmsblock.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cms_block")
public class CmsBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "row_id")
    private Long rowId;

    @Column(name = "block_id")
    private Long blockId;

    @Column(name = "title")
    private String title;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "content")
    private String content;


}
