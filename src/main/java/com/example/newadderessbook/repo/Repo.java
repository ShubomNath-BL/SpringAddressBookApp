package com.example.newadderessbook.repo;

import com.example.newadderessbook.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends JpaRepository<AddressEntity, Long> {

    @Query(value = "select * from addressbookapp.address,addressbookapp.city where address.user_id=city.id and city= :city", nativeQuery = true)
    List<AddressEntity> findByCity(String city);
}
