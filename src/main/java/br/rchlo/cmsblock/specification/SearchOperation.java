package br.rchlo.cmsblock.specification;

import br.rchlo.cmsblock.api.parameters.SearchCriteriaParameter;
import br.rchlo.cmsblock.domain.CmsBlock;
import org.springframework.data.jpa.domain.Specification;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public enum SearchOperation implements Specification<CmsBlock> {

    GREATER_THAN{
        @Override
        public SearchOperation getSearchCriteriaDto(SearchCriteriaParameter dto) {
            this.dto = dto;
            return this;
        }

        @Override
        public Predicate toPredicate(Root<CmsBlock> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.greaterThan(
                    root.get(dto.getKey()), dto.getValue().toString());

        }
    },
    LESS_THAN {
        @Override
        public SearchOperation getSearchCriteriaDto(SearchCriteriaParameter dto) {
            this.dto = dto;
            return this;
        }
        @Override
        public Predicate toPredicate(Root<CmsBlock> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.lessThan(
                    root.get(dto.getKey()), dto.getValue().toString());
        }
    },
    GREATER_THAN_EQUAL {
        @Override
        public SearchOperation getSearchCriteriaDto(SearchCriteriaParameter dto) {
            this.dto = dto;
            return this;
        }
        @Override
        public Predicate toPredicate(Root<CmsBlock> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get(dto.getKey()), dto.getValue().toString());
        }
    },
    LESS_THAN_EQUAL {
        @Override
        public SearchOperation getSearchCriteriaDto(SearchCriteriaParameter dto) {
            this.dto = dto;
            return this;
        }
        @Override
        public Predicate toPredicate(Root<CmsBlock> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.lessThanOrEqualTo(
                    root.get(dto.getKey()), dto.getValue().toString());
        }
    },
    NOT_EQUAL {
        @Override
        public SearchOperation getSearchCriteriaDto(SearchCriteriaParameter dto) {
            this.dto = dto;
            return this;
        }
        @Override
        public Predicate toPredicate(Root<CmsBlock> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.notEqual(
                    root.get(dto.getKey()), dto.getValue().toString());
        }
    },
    EQ {
        @Override
        public SearchOperation getSearchCriteriaDto(SearchCriteriaParameter dto) {
            this.dto = dto;
            return this;
        }
        @Override
        public Predicate toPredicate(Root<CmsBlock> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.equal(
                    root.get(dto.getKey()), dto.getValue().toString());
        }
    },
    MATCH {
        @Override
        public SearchOperation getSearchCriteriaDto(SearchCriteriaParameter dto) {
            this.dto = dto;
            return this;

        }
        @Override
        public Predicate toPredicate(Root<CmsBlock> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.like(
                    criteriaBuilder.lower(root.get(dto.getKey())),
                    "%" + dto.getValue().toString().toLowerCase() + "%");
        }
    },
    MATCH_START {
        @Override
        public SearchOperation getSearchCriteriaDto(SearchCriteriaParameter dto) {
            this.dto = dto;
            return this;
        }
        @Override
        public Predicate toPredicate(Root<CmsBlock> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.like(
                    criteriaBuilder.lower(root.get(dto.getKey())),
                    dto.getValue().toString().toLowerCase() + "%" );
        }
    },
    MATCH_END {
        @Override
        public SearchOperation getSearchCriteriaDto(SearchCriteriaParameter dto) {
            this.dto = dto;
            return this;
        }
        @Override
        public Predicate toPredicate(Root<CmsBlock> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.like(
                    criteriaBuilder.lower(root.get(dto.getKey())),
                     "%"+dto.getValue().toString().toLowerCase() );
        }
    },
    IN {
        @Override
        public SearchOperation getSearchCriteriaDto(SearchCriteriaParameter dto) {
            this.dto = dto;
            return this;
        }
        @Override
        public Predicate toPredicate(Root<CmsBlock> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.in(root.get(dto.getKey())).value(dto.getValue());
        }
    },
    NOT_IN {
        @Override
        public SearchOperation getSearchCriteriaDto(SearchCriteriaParameter dto) {
            this.dto = dto;
            return this;
        }
        @Override
        public Predicate toPredicate(Root<CmsBlock> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.not(root.get(dto.getKey())).in(dto.getValue());
        }
    };

    public SearchCriteriaParameter dto;

     public abstract SearchOperation  getSearchCriteriaDto(SearchCriteriaParameter dto);



}
