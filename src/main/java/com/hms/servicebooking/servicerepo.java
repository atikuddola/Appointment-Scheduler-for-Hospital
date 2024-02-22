package com.hms.servicebooking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface servicerepo extends JpaRepository<servicemodel, String> {

}
