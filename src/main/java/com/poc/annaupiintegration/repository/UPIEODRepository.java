package com.poc.annaupiintegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.annaupiintegration.entity.UPIEODEntity;

public interface UPIEODRepository extends JpaRepository<UPIEODEntity, String> {

}
