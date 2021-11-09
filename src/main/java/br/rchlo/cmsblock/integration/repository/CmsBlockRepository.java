package br.rchlo.cmsblock.integration.repository;

import br.rchlo.cmsblock.domain.CmsBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CmsBlockRepository extends JpaRepository<CmsBlock, Long>, JpaSpecificationExecutor<CmsBlock> {
}
