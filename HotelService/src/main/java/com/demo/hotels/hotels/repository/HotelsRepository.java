package com.demo.hotels.hotels.repository;

import com.demo.hotels.hotels.models.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelsRepository extends JpaRepository<Hotels,String> {

}
