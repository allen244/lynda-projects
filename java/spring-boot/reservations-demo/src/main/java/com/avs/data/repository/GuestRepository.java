package com.avs.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.avs.data.entity.Guest;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {

}