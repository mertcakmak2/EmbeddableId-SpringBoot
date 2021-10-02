package com.example.composite.embeddableIds;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEmbeddedId implements Serializable {

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "provider_id")
    private Integer providerId;

    @Column(name = "company_id")
    private Integer companyId;

}
