package com.backend.resume.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Audit<U> {

    @Nullable
    @CreatedBy
    @Column(name = "createdUserId", updatable = false)
	protected U createdUserId;

    @CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate", updatable = false)
	protected Date createdDate;

	@Nullable
	@LastModifiedBy
	protected U lastModifiedUserId;

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastModifiedDate;

    public U getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(U createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public U getLastModifiedUserId() {
        return lastModifiedUserId;
    }

    public void setLastModifiedUserId(U lastModifiedUserId) {
        this.lastModifiedUserId = lastModifiedUserId;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    
    
}
